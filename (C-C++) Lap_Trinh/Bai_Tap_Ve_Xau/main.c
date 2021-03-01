#include <stdio.h>
int main()
{
    char x[1000],y[1000];
    fflush(stdin);
    scanf("%[^\n]s",x);
    int n=strlen(x);
    printf("%s\n",x);
    for (int i=0; i<n;i++)
    {
        if (x[i]>='a' && x[i]<='z') x[i]=x[i]-'a'+'A';
        else if (x[i]>='A' && x[i]<='Z') x[i]=x[i]-'A'+'a';
    }
    printf("%s\n",x);
     for (int i=0; i<n;i++)
    {
        if (x[i]>='a' && x[i]<='z') x[i]=x[i]-'a'+'A';
    }
    printf("%s\n",x);
    for (int i=0; i<n;i++)
    {
        if (x[i]>='A' && x[i]<='Z') x[i]=x[i]-'A'+'a';
    }
    printf("%s\n",x);
    for (int i=0; i<n;i++)
    {
        if (x[i]!='a'&&x[i]!='e'&&x[i]!='i'&&x[i]!='o'&&x[i]!='u') x[i]=x[i]-'a'+'A';
    }
    printf("%s\n",x);
    for (int i=0; i<n;i++)
    {
        if (x[i]>='a' && x[i]<='z') x[i]=x[i]-'a'+'A';
    }
    for (int i=0; i<n;i+=2)
    {
       x[i]=x[i]-'A'+'a';
    }
    for (int i=0; i<n;i++)
    {
        if (x[i]>='a' && x[i]<='z') x[i]=x[i]-'a'+'A';
        else if (x[i]>='A' && x[i]<='a') x[i]=x[i]-'A'+'a';
    }
    printf("%s",x);
    return 0;
}
