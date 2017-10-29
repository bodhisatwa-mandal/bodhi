#include <stdio.h>
float df(float x,float y);
void input(float* x0,float* y0,float* h,float* xn);
void euler(float h,int n,float arr[n][3]);
void modifiedEuler(float h,int n,float arr[n][3]);
void initializeArray(float x0,float y0,float f,int n,float arr[n][3]);
void display(int n,float arr[n][3]);
int main()
{
	float x0,y0,h,xn;
	input(&x0,&y0,&h,&xn);
	int n=(int)(1+(xn-x0)/h);
	float arr[n][3];
	initializeArray(x0,y0,h,n,arr);
	euler(h,n,arr);
	modifiedEuler(h,n,arr);
	display(n,arr);
	return 0;
}
void input(float* x0,float* y0,float* h,float* xn)
{
	printf("Enter x0,y0 : ");
	scanf("%f %f",x0,y0);
	printf("Enter h : ");
	scanf("%f",h);
	printf("Enter xn : ");
	scanf("%f",xn);
}
void initializeArray(float x0,float y0,float h,int n,float arr[n][3])
{
	int i;
	arr[0][0]=x0;
	arr[0][1]=arr[0][2]=y0;
	for(i=1;i<n;i++)
		arr[i][0]=arr[i-1][0]+h;
}
float df(float x,float y)
{
	return 2*x;
}
void display(int n,float arr[n][3])
{
	int i;
	char ch;
	printf("Show table? (y/n) : ");
	scanf(" %c",&ch);
	if(ch=='y')
	{
		for(i=0;i<89;i++)
			printf("=");
		printf("\n");
		printf("|    Iteration  ||           x          |       Euler f(x)      |  Modified Euler f(x)  |\n|");
		for(i=0;i<87;i++)
			printf("-");
		printf("|\n");
		for(i=0;i<n;i++)
			printf("|\t%d\t||\t%f\t|\t%f\t|\t%f\t|\n",i,arr[i][0],arr[i][1],arr[i][2]);
		for(i=0;i<89;i++)
			printf("=");
		printf("\n");
	}
	printf("Using Euler's Mehod f(%f) = %f\n",arr[n-1][0],arr[n-1][1]);
	printf("Using Modified Euler's Mehod f(%f) = %f\n",arr[n-1][0],arr[n-1][2]);
}
void euler(float h,int n,float arr[n][3])
{
	int i;
	for(i=1;i<n;i++)
		arr[i][1]=arr[i-1][1]+h*df(arr[i-1][0],arr[i-1][1]);
}
void modifiedEuler(float h,int n,float arr[n][3])
{
	int i;
	for(i=1;i<n;i++)
	{
		arr[i][2]=arr[i-1][2]+h*df(arr[i-1][0],arr[i-1][2]);
		arr[i][2]=arr[i-1][2]+0.5*h*(df(arr[i-1][0],arr[i-1][2])+df(arr[i][0],arr[i][2]));
	}
}
