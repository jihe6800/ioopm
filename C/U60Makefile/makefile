CC=gcc
CFLAGS=-std=c99 -Wall -ggdb -I.
DEPS= hello.h
OBJ = helloTest.o printHello.o

%.o: %.c $(DEPS)
	$(CC) -c -o $@ $< $(CFLAGS)

hello: $(OBJ)
	$(CC) -o $@ $^ $(CFLAGS)


