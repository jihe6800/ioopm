#include <string.h>
#include <errno.h>
#include <iconv.h>
#include <stdio.h>

int checkID3(FILE* file);
int getFrames(char *artist, char *album, char *title, FILE *file);
