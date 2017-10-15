#include<stdio.h>
#include<math.h>
int main()
{
	int i,j,n;
	printf("Enter number of records :\n");
	scanf("%d",&n);
	float x[n],y[n][n],sum=0,term=1,f;
	printf("Enter x and f(x) respectively :\n");
	for(i=0;i<n;i++)
		scanf("%f %f",&x[i],&y[i][0]);
	printf("Enter x for finding f(x) :\n");
	scanf("%f",&f);
	for(i=1;i<n;i++)
    	for(j=0;j<n-i;j++)
    	 	y[j][i]=(y[j+1][i-1]-y[j][i-1])/(x[j+i]-x[j]);
    for(i=0;i<n;i++)
    {
    	sum+=term*y[0][i];
    	term*=(f-x[i]);
    }
    printf("%f\n",sum);
    return 0;
}
