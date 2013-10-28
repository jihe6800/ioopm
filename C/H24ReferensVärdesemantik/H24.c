#include<stdio.h>

struct point {
  int x;
  int y;
};

struct point translate(struct point p, struct point relative){
  p.x += relative.x;
  p.y += relative.y;
  return p;
}

void translatePointer(struct point *p, struct point *relative){
  p->x += relative->x;
  p->y += relative->y;
}

void printPoint(char *msg, struct point p){
  printf("%s (%d, %d)\n", msg, p.x, p.y);  // "." icke lokal plats, dvs. Ingen pekare. 
}

void printPointPointer(char *msg, struct point *p){
  printf("%s (%d, %d)\n", msg, p->x, p->y);
}

int main(){
  struct point firstPoint =  { .x = 7, .y = 3 };
  struct point secondPoint = { .x = 35, .y = 39 };
  
  printPoint("firstPoint is:", firstPoint);
  printPoint("secondPoint is:", secondPoint);

  translatePointer(&firstPoint, &secondPoint);

  printPointPointer("firstPoint translated by secondPoint", &firstPoint);

  printPoint("firstPoint translated by secondPoint", translate(firstPoint, secondPoint));
  return 0;
}
