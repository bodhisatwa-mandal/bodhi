#include <stdio.h>
#include <math.h>
void input(float* a,float* b,float* max_error);
float trap_area(float a,float b,float max_error);
float f(float x);
int main()
{
	float a,b,max_error;
	input(&a,&b,&max_error);
	float sum=trap_area(a,b,max_error);
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
	return x*x;
}
float trap_area(float a,float b,float max_error)
{
	int iterations=1;
	float x,width=b-a,fixed_term=(fabs(f(b))+fabs(f(a)))/2,sum0,sum1,error;
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
			sum1+=fabs(f(x));
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
