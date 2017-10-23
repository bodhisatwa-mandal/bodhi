#include <stdio.h>
#include <math.h>
void input(float* a,float* b,float* max_error);
float trapezoidal(float a,float b,float max_error);
float simpson(float a,float b,float max_error);
float f(float x);
int main()
{
	float sum,a,b,max_error;
	input(&a,&b,&max_error);
	printf("\nUsing Trapezoidal Method :-\n");
	sum=trapezoidal(a,b,max_error);
	printf("Integration of the function in (%f,%f] = %f\n",a,b,sum);
	printf("\nUsing Simpson Method :-\n");
	sum=simpson(a,b,max_error);
	printf("Integration of the function in (%f,%f] = %f\n",a,b,sum);
	return 0;
}
void input(float* a,float* b,float* max_error)
{
	printf("Enter lower and upper limits respectively : ");
	scanf("%f %f",a,b);
	printf("Enter max error : ");
	scanf("%f",max_error);
}
float f(float x)
{
	return 1/(1+x);
}
float trapezoidal(float a,float b,float max_error)
{
	int iterations=1;
	float x,width=b-a,fixed_term=(f(b)+f(a))/2,sum0,sum1,error;
	sum1=fixed_term*width;
	for(x=0;x<105;x++)
		printf("-");
	printf("\n");
	printf("|   Iterations  ||  Partitions  |\tPrevious Sum\t|\tCurrent Sum\t|\tError\t\t|\n");
	printf("|");
	for(x=0;x<103;x++)
		printf("=");
	printf("|\n");
	do
	{
		sum0=sum1;
		sum1=0;
		width/=2;
		for(x=a+width;x<b;x+=width)
			sum1+=f(x);
		sum1+=fixed_term;
		sum1*=width;
		error=fabs(sum1-sum0);
		printf("|\t%d\t||\t%ld\t|\t%f\t|\t%f\t|\t%f\t|\n",iterations++,(long)((b-a)/width),sum0,sum1,error);
	}while(error>max_error);
	for(x=0;x<105;x++)
		printf("-");
	printf("\n");
	return sum1;
}
float simpson(float a,float b,float max_error)
{
	int iterations=1;
	float x,width=b-a,sum0,sum1,error;
	sum1=(width/6)*(f(a)+4*f((a+b)/2)+f(b));
	for(x=0;x<105;x++)
		printf("-");
	printf("\n");
	printf("|   Iterations  ||  Partitions  |\tPrevious Sum\t|\tCurrent Sum\t|\tError\t\t|\n");
	printf("|");
	for(x=0;x<103;x++)
		printf("=");
	printf("|\n");
	do
	{
		sum0=sum1;
		sum1=0;
		width/=2;
		for(x=a;x<=b-width;x+=width)
			sum1+=(width/6)*(f(x)+4*f(x+width/2)+f(x+width));
		error=fabs(sum1-sum0);
		printf("|\t%d\t||\t%ld\t|\t%f\t|\t%f\t|\t%f\t|\n",iterations++,(long)((b-a)/width),sum0,sum1,error);
	}while(error>max_error);
	for(x=0;x<105;x++)
		printf("-");
	printf("\n");
	return sum1;
}
