import java.util.*;
class SortCompare
{
	int n;
	int arr[];
	SortCompare(int n)
	{
		this.n=n;
		arr=new int[n];
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number of elements");
		int n=sc.nextInt();
		int arr[]=new int[n];
		long time;
		SortCompare obj=new SortCompare(n);
		obj.initialize();
		
		obj.copy(arr);
		time=System.nanoTime();
		inbuiltSort(arr);
		time=System.nanoTime()-time;
		System.out.println("Inbuilt Sort   : "+time);

		obj.copy(arr);
		time=System.nanoTime();
		bubbleSort(arr);
		time=System.nanoTime()-time;
		System.out.println("Bubble Sort    : "+time);

		obj.copy(arr);
		time=System.nanoTime();
		countingSort(arr);
		time=System.nanoTime()-time;
		System.out.println("Counting Sort  : "+time);

		obj.copy(arr);
		time=System.nanoTime();
		insertionSort(arr);
		time=System.nanoTime()-time;
		System.out.println("Insertion Sort : "+time);
		
		obj.copy(arr);
		time=System.nanoTime();
		selectionSort(arr);
		time=System.nanoTime()-time;
		System.out.println("Selection Sort : "+time);

	}
	void display(int arr[])
	{
		int i;
		for(i=0;i<n;i++)
			System.out.println("*"+arr[i]);
	}
	void initialize()
	{
		int i;
		for(i=0;i<n;i++)
			arr[i]=(int)(Math.random()*n);
	}
	void copy(int arr[])
	{
		int i;
		for(i=0;i<n;i++)
			arr[i]=this.arr[i];
	}
	static void inbuiltSort(int arr[])
	{
		Arrays.sort(arr);
	}
	static void bubbleSort(int arr[])
	{
		int i,j,temp,n=arr.length;
		for(i=0;i<n-1;i++)
			for(j=0;j<n-i-1;j++)
				if(arr[j]>arr[j+1])
				{
					temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
	}
	static void countingSort(int arr[])
	{
		int i,j,k=0,n=arr.length,temp[]=new int[n];
		for(i=0;i<n;i++)
			for(j=0;j<n;j++)
				if(arr[j]==i)
					temp[k++]=i;
		for(i=0;i<n;i++)
			arr[i]=temp[i];
	}
	static void insertionSort(int arr[])
	{
		int i,j,temp,n=arr.length;
		for(i=0;i<n-1;i++)
		{
			temp=arr[i+1];
			for(j=i+1;j>0&&arr[j-1]>temp;j--)
				arr[j]=arr[j-1];
			arr[j]=temp;
		}
	}
	static void selectionSort(int arr[])
	{
		int i,j,pos,n=arr.length,temp;
		for(i=0;i<n-1;i++)
		{
			pos=i;
			for(j=i+1;j<n;j++)
				if(arr[j]<arr[pos])
					pos=j;
			temp=arr[pos];
			arr[pos]=arr[i];
			arr[i]=temp;
		}
	}
}
