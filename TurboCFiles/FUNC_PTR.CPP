#include <stdio.h>
#include <conio.h>
char *copy(char *, char*);
void main()
{
  char * str;
  char source[]="Jaded";
  char target[10];
  str=copy(target,source);
  printf("%s\n",str);
  getch();
}
char *copy(char *t, char *s)
{
  char *r;
  r=t;//intial address of r is saved in t
  while(s!='\0')
  {
    *t=*s;
    t++;
    s++;
  }
  *t='\0';
  return (r);
}