#include<stdio.h>
void input(int n,float x[n],float y[n][n],float* f);
void createTable(int n,float x[n],float y[n][n]);
float calculate(int n,float x[n],float y[n][n],float f);
int main()
{
	int i,j,n;
	printf("Enter number of records :\n");
	scanf("%d",&n);
	float x[n],y[n][n],sum,f;
	input(n,x,y,&f);
	createTable(n,x,y);
	sum=calculate(n,x,y,f);
    printf("%f\n",sum);
    return 0;
}
void input(int n,float x[n],float y[n][n],float* f)
{
	int i;
	printf("Enter x and f(x) respectively :\n");
	for(i=0;i<n;i++)
		scanf("%f %f",&x[i],&y[i][0]);
	printf("Enter x for finding f(x) :\n");
	scanf("%f",f);
}
void createTable(int n,float x[n],float y[n][n])
{
	int i,j;
	for(i=1;i<n;i++)
    	for(j=0;j<n-i;j++)
    	 	y[j][i]=(y[j+1][i-1]-y[j][i-1])/(x[j+i]-x[j]);
}
float calculate(int n,float x[n],float y[n][n],float f)
{
	int i;
	float sum=0,term=1;
    for(i=0;i<n;i++)
    {
    	sum+=(term*y[0][i]);
    	term*=(f-x[i]);
    }
    return sum;
}
