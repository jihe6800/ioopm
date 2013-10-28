#include<stdio.h>

int main(){

  int array[5];
  int *Pointer = array;

  printf("The array is filled with: ");
  for(int i=0;i<5;i++){
    array[i] = i*i;
    printf("%d ", array[i]);
  }
  puts("");

  int value = array[4];
  printf("Value at index 4 = %d\n", value);
  value = *(Pointer + 2);
  printf("Value at index 3 = %d\n", value);
  *(Pointer + 4) = 42;
  value = array[4];
  printf("Value at index 4 is now = %d\n", value);
}
