    #include <math.h>
    int a,b,c,d,r=1;
    int main()
    {
        scanf("%i%i\n%i%i",&a,&b,&c,&d);
        if (a>0 &&b>0&& c>0&&d>0 )
        {
            if (a==c) r=(a==b+d)?1:0;
            else if (a==d) r=(a==b+c)?1:0;
            else if (b==c) r=(b==a+d)?1:0;
            else if (b==d) r=(b==a+c)?1:0;
            else r=0;
        }
        else r=0;
        printf(r!=0?"YES":"NO");
        return 0;
    }
