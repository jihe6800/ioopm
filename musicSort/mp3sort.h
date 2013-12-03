#ifndef ID3PRINT_H
#define ID3PRINT_H
#define _GNU_SOURCE

#include <stdlib.h>
#include <stdio.h>
#include <dirent.h>

/**
 * Returns the dot and whats after of 'filename'.
 *
 * @param The filename which the dot and rest will be collected from.
 * @return The dot and whats after.
 */
const char *get_filename_ext(const char *filename);

/**
 * Returns 1, for "dirent.h"
 */
int one (const struct dirent *unused);


/**
 * If main is called with an argument, is saves that argument as the path,
 * else it will set the path to the current directory.
 * 
 * @param The place where the path will be saved.
 * @param The number of arguments to main.
 * @param The arguments of main.
 */
void getPath(char *path,int argc,char *argv);

#endif
