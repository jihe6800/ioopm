#include "renamer.h"
#include <string.h>
#include <stdio.h>
#include <sys/stat.h>

//Used to return int.
void renameAndMove(char *path, char *filename, char *artist, char *album, char *title){
    char dirname[128];
    strcpy(dirname,path);
    strcat(dirname,artist);
    mkdir(dirname,S_IRWXU | S_IRWXG | S_IRWXO);
    strcat(strcat(dirname,"/"),album);
    mkdir(dirname,S_IRWXU | S_IRWXG | S_IRWXO);
    strcat(strcat(strcat(artist," - "),title),".mp3");
    rename(filename, strcat(strcat(dirname,"/"),artist));
}

//used to return int
int setUnknown(char *artist, char *album, char *title){
  strcpy(artist,"Unknown Artist");
  strcpy(album,"Unknown Album");
  strcpy(title,"Unknown Track");
}
