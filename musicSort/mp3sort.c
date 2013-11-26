#define _GNU_SOURCE

#include "mp3sort.h"
#include <string.h>
#include <stdio.h>
#include <dirent.h>
#include "renamer.h"
#include "mp3data.h"

int main(int argc, char* argv[])                    
{
  char artist[128];
  char album[128];
  char title[128];
  char filename[128];
  FILE* file;
  char path[128];
  struct dirent **eps;
  int files;

  getPath(path,argc, argv[1]);                                 
  files = scandir (path, &eps, one, alphasort);                     
  if (files >= 0) {
    printf("Found %d directory entries.\n",files);
    for (int count = 0; count < files; ++count){
      strcat(strcat(strcpy(filename,path),"/"), eps[count]->d_name);
      if (strcmp(get_filename_ext(filename),"mp3")){
	continue;      
      }
      file = fopen(filename, "r");                     
      if(checkFile(file)==0){                          
	printf("%s was skipped.",filename);
	continue;
      }
      setUnknown(artist,album,title);                  
      getFrames(artist,album,title,file);                
      renameAndMove(path,filename,artist,album,title);                                               
      fclose(file);                               
    }
  }
  else
    perror ("Couldn't open the directory");  
  return 0;
}











int checkFile(FILE* file){ 
  if(!file){
    return 0;
  }
  if(!checkID3(file)){
    return 0;
  }
  return 1;
}

int getPath(char *path,int argc,char *argv){
  if(argc >= 2){
    strcat(strcpy(path,argv),"/");                 
  }                                                   
  else{
    strcpy(path,"./");
  }
  return 0;
}

const char *get_filename_ext(const char *filename) {
    const char *dot = strrchr(filename, '.');
    if(!dot || dot == filename) return "";
    return dot + 1;
}

int one (const struct dirent *unused)
{
  return 1;
}
