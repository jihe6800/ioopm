#include<stdio.h>

unsigned int RecursiveFaculty(unsigned int index){
  
  if(index == 1){
    return 1;
  } else {
    return index * RecursiveFaculty(index-1);
  }
}

unsigned int IterativeFaculty(unsigned int index){
  
  unsigned int fact = 1;
  for(int i=1;i<=index;i++){
    fact = i * fact;
  }
  return fact;
}


int main(){

  unsigned int rec = RecursiveFaculty(10);
  unsigned int iter = IterativeFaculty(10);

  printf("RecursiveFaculty for index 10: %d\n", rec);
  printf("IterativeFaculty for index 10: %d\n", iter);
  return 0;
}
