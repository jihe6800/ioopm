#include <string.h>
#include <stdio.h>
#include <sys/stat.h>


/**
 * Saves a file at the location 'path' which is artist/album/title with
 * the name 'filename'.
 *
 * @param The path to where the file will be saved.
 * @param The name of the file.
 * @param The artist from the meta data of the file.
 * @param The album from the meta data of the file.
 * @param The title from the meta data of the file.
 */
void renameAndMove(char *path, char *filename, char *artist, char *album, char *title);



/**
 * @param Sets 'artist' to uknown.
 * @param Sets 'album' to uknown.
 * @param Sets 'title' to uknown.
 */
void setUnknown(char *artist, char *album, char *title);
