#ifndef ID3PRINT_H
#define ID3PRINT_H
#define _GNU_SOURCE

#include <stdlib.h>
#include <stdio.h>
#include <dirent.h>

const char *get_filename_ext(const char *filename);
int one (const struct dirent *unused);
int getPath(char *path,int argc,char *argv);
int checkFile(FILE* in);
#endif
