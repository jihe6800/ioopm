#include<stdio.h>
#include<stdlib.h>

unsigned int FibonacciStack(unsigned int index){
  
  int Fibonacci;
  
  if(index == 0 || index == 1){
    Fibonacci = index;
    return Fibonacci;
  } else {
    Fibonacci = FibonacciStack(index-1) + FibonacciStack(index-2);
    return Fibonacci;
  }
}


unsigned int *FibonacciHeap(unsigned int index){
  
  unsigned int *Fibonacci = malloc(sizeof(int));
  if(Fibonacci == NULL){
    puts("Failed");
    exit(-1);
  }
  
  if(index == 0 || index == 1){
    *Fibonacci = index;
    return Fibonacci;
  } else {
    *Fibonacci = *FibonacciHeap(index-1) + *FibonacciHeap(index-2);
    return Fibonacci;
  }
}



int main(){
  
  unsigned int index = 34;
  printf("FibonacciStack at index %u is : %u\n", index, FibonacciStack(index));
  printf("FibonacciHeap at index %u is : %u\n", index, *FibonacciHeap(index));
  
  return 0;
}
