#include <string.h>
#include <errno.h>
#include <iconv.h>
#include <stdio.h>


char *convert_content(const char *content, size_t size);


/**
 * Returns 1 if the meta data of 'file' starts with 'ID3', else 0.
 *
 * @param The file which will be checked.
 * @return Returns 1 if the ID3-tag exists, otherwise 0.
 */
int checkID3(FILE* file);



/**
 * @param The file which will be checked.
 * @return Returns 0 if the 'file' couldnt be opened or if the ID3-tag,
 * doesnt exist, otherwise it returns 1.
 */
//Used to be in mp3sort
int checkFile(FILE* in);



/**
 * Checks for a tag in the meta data of 'file'. If the tag is found,
 * the value after is saved, otherwise nothing is done.
 *
 * @param The tag which will be looked for in the metadata.
 * @param The pointer to where the data will be saved.
 * @param The file which contains the meta data.
 */
void getFrame(char *tag, char *frame, FILE *file);



/**
 * Looks for the tag 'artist', 'album' and 'title' in the meta
 * data of file. If found, it will be saved, otherwise nothing.
 *
 * @param The first tag which will be looked for. 
 * @param The second tag which will be looked for.
 * @param The third tag which will be looked for.
 * @param The file which contains the meta data.
 */
void getFrames(char *artist, char *album, char *title, FILE *file);
