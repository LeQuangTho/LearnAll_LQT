#include <stdio.h>
#include <string.h>
#define sl 100

int main() {
	int i;
	char s1[sl], *n, s2[50][50];
	fflush(stdin);gets(s1);
	n = strtok(s1, " ");
	i = 0; t = 0;
	while (n != NULL)
	{
		strcpy(s2[i], n);
		n = strtok(NULL, " ");
		++i;
	}
	i -= 1;
	for (; i >= 0; --i) printf("%s ", s2[i]);
	return 0;
}
