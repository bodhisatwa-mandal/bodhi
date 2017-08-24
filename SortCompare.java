/*
Sorting algorithms( * means algorithm yet to be implemented):-
->Bubble Sort
->Selection Sort
->Insertion Sort
->Counting Sort 1
->Counting Sort 2
->Java Inbuilt Sort
->Quick Sort
->Merge Sort
->Comb Sort
->Shell Sort
->Shaker/Cocktail/Cocktail Shaker Sort
->Stooge Sort
->Pancake Sort
->Bitonic Sort*
->Bogo Sort*(lol)
->Radix Sort*
->Heap Sort*
->Bucket Sort*
*/
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
		System.out.println("Inbuilt Sort    : "+time);

		obj.copy(arr);
		time=System.nanoTime();
		bubbleSort(arr);
		time=System.nanoTime()-time;
		System.out.println("Bubble Sort     : "+time);

		obj.copy(arr);
		time=System.nanoTime();
		countingSort1(arr);
		time=System.nanoTime()-time;
		System.out.println("Counting Sort 1 : "+time);

		obj.copy(arr);
		time=System.nanoTime();
		countingSort2(arr);
		time=System.nanoTime()-time;
		System.out.println("Counting Sort 2 : "+time);

		obj.copy(arr);
		time=System.nanoTime();
		insertionSort(arr);
		time=System.nanoTime()-time;
		System.out.println("Insertion Sort  : "+time);
		
		obj.copy(arr);
		time=System.nanoTime();
		selectionSort(arr);
		time=System.nanoTime()-time;
		System.out.println("Selection Sort  : "+time);

		obj.copy(arr);
		time=System.nanoTime();
		mergeSort(arr,0,n-1);
		time=System.nanoTime()-time;
		System.out.println("Merge Sort      : "+time);

		obj.copy(arr);
		time=System.nanoTime();
		combSort(arr);
		time=System.nanoTime()-time;
		System.out.println("Comb Sort       : "+time);

		obj.copy(arr);
		time=System.nanoTime();
		quickSort(arr,0,n-1);
		time=System.nanoTime()-time;
		System.out.println("Quick Sort      : "+time);

		obj.copy(arr);
		time=System.nanoTime();
		shellSort(arr);
		time=System.nanoTime()-time;
		System.out.println("Shell Sort      : "+time);

		obj.copy(arr);
		time=System.nanoTime();
		shakerSort(arr);
		time=System.nanoTime()-time;
		System.out.println("Shaker Sort     : "+time);

		obj.copy(arr);
		time=System.nanoTime();
		stoogeSort(arr,0,n-1);
		time=System.nanoTime()-time;
		System.out.println("Stooge Sort     : "+time);

		obj.copy(arr);
		time=System.nanoTime();
		pancakeSort(arr);
		time=System.nanoTime()-time;
		System.out.println("Pancake Sort    : "+time);

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
	static void countingSort1(int arr[])
    {
        int i,n = arr.length;
        int output[] = new int[n];
        int count[] = new int[n];
        for (i=0; i<n; ++i)
            count[i] = 0;
        for (i=0; i<n; ++i)
            count[arr[i]]++;
        for (i=1; i<n; ++i)
            count[i] += count[i-1];
        for (i = 0; i<n; i++)
            output[count[arr[i]]-- - 1] = arr[i];
        for (i = 0; i<n; ++i)
            arr[i] = output[i];
    }
	static void countingSort2(int arr[])
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
	static void merge(int arr[], int l, int m, int r)
	{
	    int i, j, k;
	    int n1 = m - l + 1;
	    int n2 =  r - m;
	    int L[]=new int[n1],R[]=new int[n2];
	    for (i = 0; i < n1; i++)
	        L[i] = arr[l + i];
	    for (j = 0; j < n2; j++)
	        R[j] = arr[m + 1+ j];
	    i = 0;
	    j = 0;
	    k = l; 
	    while (i < n1 && j < n2)
	    {
	        if (L[i] <= R[j])
	        {
	            arr[k] = L[i];
	            i++;
	        }
	        else
	        {
	            arr[k] = R[j];
	            j++;
	        }
	        k++;
	    }
	    while (i < n1)
	    {
	        arr[k] = L[i];
	        i++;
	        k++;
	    }
	    while (j < n2)
	    {
	        arr[k] = R[j];
	        j++;
	        k++;
	    }
	}
	static void mergeSort(int arr[], int l, int r)
	{
	    if (l < r)
	    {
	        int m = l+(r-l)/2;
	        mergeSort(arr, l, m);
	        mergeSort(arr, m+1, r);
	        merge(arr, l, m, r);
	    }
	}
    static void combSort(int arr[])
    {
        int n = arr.length;
        int gap = (n*10)/13;
        while (gap>0)
        {
            for (int i=0; i<n-gap; i++)
            {
                if (arr[i] > arr[i+gap])
                {
                    int temp = arr[i];
                    arr[i] = arr[i+gap];
                    arr[i+gap] = temp;
                }
            }
            gap = (gap*10)/13;
        }
    }
    static int partition(int arr[], int low, int high)
    {
        int pivot = arr[high]; 
        int i = (low-1);
        for (int j=low; j<high; j++)
        {
            if (arr[j] <= pivot)
            {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return i+1;
    }
    static void quickSort(int arr[], int low, int high)
    {
        if (low < high)
        {
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot-1);
            quickSort(arr, pivot+1, high);
        }
    }
    static void shellSort(int arr[])
    {
        int gap,temp,j,i,n = arr.length;
        for (gap = n/2; gap > 0; gap /= 2)
        {
            for (i = gap; i < n; i++)
            {
                temp = arr[i];
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap)
                    arr[j] = arr[j - gap];
                arr[j] = temp;
            }
        }
    }
    static void shakerSort(int arr[])
    {
    	int i,j,temp,n=arr.length;
    	for (i = 0; i < n/2; i++)
    	{
	        for (j = i; j < n - i - 1; j++)
		        if (arr[j] > arr[j+1])
    	        {
    	            temp = arr[j];
	                arr[j] = arr[j+1];
	                arr[j+1] = temp;
	            }
	        for (j = n - 2 - i; j > i; j--)
	            if (arr[j] < arr[j-1])
	            {
	                temp = arr[j];
	                arr[j] = arr[j-1];
	                arr[j-1] = temp;
	            }
	    }
    }
    static void stoogeSort(int arr[], int l, int h)
    {
        if (l >= h)
           return;
       int t;
        if (arr[l]>arr[h])
        {
            t = arr[l];
            arr[l] = arr[h];
            arr[h] = t;
        }
        if (h-l+1 > 2)
        {
            t = (h-l+1)/3;
            stoogeSort(arr, l, h-t);
            stoogeSort(arr, l+t, h);
            stoogeSort(arr, l, h-t);
        }
    }
    static void pancakeSort(int arr[])
    {
        int n=arr.length,i,j,max;
        for (i = n; i > 1; i--)
        {
        	max=0;
        	for (j = 1; j < i; j++)
            	if (arr[j] > arr[max])
            	    max = j;
            if (max != i-1)
            {
                flip(arr, max);
                flip(arr, i-1);
            }
        }
    }
    static void flip(int arr[], int i)
    {
        int temp, start = 0;
        while (start < i)
        {
            temp = arr[start];
            arr[start] = arr[i];
            arr[i] = temp;
            start++;
            i--;
        }
    }
}
