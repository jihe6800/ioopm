#include <string.h>
#include <iconv.h>
#include <errno.h>
#include <stdlib.h>
#include "mp3data.h"

char *convert_content(const char *content, size_t size) {
  char *encoding;
  switch (*content) {
  case 0x00:
    encoding = "ISO-8859-1";
    break;
  case 0x01:
    encoding = "UCS-2";
    break;
  default:
    printf("Couldn't convert -- first byte is neither 0x00 nor 0x01 (is: %i)!\n", *content);
    return NULL;
  }

  //first byte consumed and interpreted, move on:

  size--;
  content++;

  iconv_t cd = iconv_open("UTF-8", encoding);
  if ((int)cd != -1) {
    size_t outsize = 2*size;
    char *outbuf = calloc(outsize,sizeof(char));
    if (!outbuf) {
      fprintf(stderr, "Could not allocate outbuf (outsize=%zi)!\n", outsize);
      return NULL;
    }
    char *outbuf_start = outbuf;
    if (iconv(cd, &content, &size, &outbuf, &outsize) != -1) {
      return outbuf_start;
    } else {
      printf("conversion failed: %s\n", strerror(errno));
      iconv_close(cd);
      free(outbuf_start);
      return NULL;
    }
  } else {
    printf("couldn't create conversion descriptor: %s\n", strerror(errno));
  }
  iconv_close(cd);
  return NULL;

}


int checkID3(FILE* file){
  char buffer[3];
  for(int i=0;i<10;i++){
    fseek(file,0,SEEK_SET);
    fread(buffer,sizeof(char),sizeof(buffer),file);
    if(!strcmp("ID3",buffer)){
      return 1;  
    }
     }
  return 0;
}

int getFrame(char *tag, char *frame, FILE* file){
  char tagbuffer[5];
  char framebuffer[250];
  for(int counter=0;counter<3000;counter++){
    fseek(file,counter,SEEK_SET);
    fread(tagbuffer,sizeof(char),sizeof(tagbuffer),file);
    if(!strcmp(tag,tagbuffer)){
      fseek(file,counter+10,SEEK_SET);
      fread(framebuffer,sizeof(char),sizeof(framebuffer),file);
      strcpy(frame, convert_content(framebuffer, sizeof(framebuffer)));
      return 0;
    }
  }
  return 0;
}

int getFrames(char *artist, char *album, char *title, FILE *file){
  getFrame("TPE1",artist,file);
  getFrame("TALB",album,file);
  getFrame("TIT2",title,file);
  return 0;
}



