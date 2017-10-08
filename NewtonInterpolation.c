#include <stdio.h>
void difference(int n,float y[n][n]);
void forwardInterpolation(int n,float x[n],float y[n][n],float f);
void backwardInterpolation(int n,float x[n],float y[n][n],float f);
int main()
{
	int n,i,j,ch=1;
	printf("Enter number of elements\n");
	scanf("%d",&n);
	float x[n],y[n][n],f;
	printf("Enter x and y respectively\n");
	for(i=0;i<n;i++)
	scanf("%f %f",&x[i],&y[i][0]);
	difference(n,y);
	printf("Enter unknown x\n");
	scanf("%f",&f);
	printf("1.Forward Interpolation\n2.Backward Interpolation\n");
	scanf("%d",&ch);
	switch(ch)
	{
		case 1:
				forwardInterpolation(n,x,y,f);
				break;
		case 2:
				backwardInterpolation(n,x,y,f);
				break;
		default:
				printf("Invalid Choice\n");
	}
	return 0;
}
void difference(int n,float y[n][n])
{
	int i,j;
	for(i=1;i<n;i++)
	for(j=0;j<n-i;j++)
	y[j][i]=y[j+1][i-1]-y[j][i-1];
}
void forwardInterpolation(int n,float x[n],float y[n][n],float f)
{
	int i,j;
	float h=x[1]-x[0],p=(f-x[0])/h,sum=y[0][0],term=1;
	for(i=1;i<n;i++)
	{
		term*=(p--)/i;
		sum+=term*y[0][i];
	}
	printf("%f\n",sum);
}
void backwardInterpolation(int n,float x[n],float y[n][n],float f)
{
	int i,j;
	float h=x[1]-x[0],p=(f-x[n-1])/h,sum=y[n-1][0],term=1;
        for(i=1;i<n;i++)
        {
                term*=(p++)/i;
                sum+=term*y[n-i-1][i];
        }
        printf("%f\n",sum);
}
