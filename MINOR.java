import java.util.*;
class Peddlar
{
    Scanner sc=new Scanner(System.in);
    Random rant=new Random();
    int dis[][]=new int[4][4];
    int arr[][]=new int[4][5];
    
    void initialiseCityOrder(int n)
    {
        int[] fit_value_sequence=new int[n];
        
        List <Integer>l1=new ArrayList<Integer>();
        for(int i=0;i<n;i++)
        {
            l1.add(i);
        }
        for(int i=0;i<n;i++)
        {
        
        Collections.shuffle(l1);
        for(int j=0;j<n;j++)
        {
            arr[i][j]=l1.get(j);
        }
        }
        System.out.println();
        for(int i=0;i<n;i++)
        {
            int fit_value=0;

            System.out.println("CITY VISITING PATTERN NO- "+(i+1)+" ");
            System.out.print(" | ");
            for(int j=0;j<n;j++)
            {
                System.out.print(arr[i][j]+" | ");
            }
            for(int j=0;j+1<n;j++)
            {
                fit_value+=dis[arr[i][j]][arr[i][j+1]];
            }
            fit_value=fit_value+dis[arr[i][3]] [arr[i][0]];
            System.out.println();
            fit_value_sequence[i]=fit_value;
            System.out.println("FIT_VALUE="+fit_value);
            System.out.println();
            System.out.println();
            arr[i][n] = fit_value;
        }
        System.out.println();
        
        
        System.out.println("array of fit_value: ");

        for(int i=0;i<n;i++)
        {
            System.out.print(+fit_value_sequence[i]+" ");
        }
        
        initialisePickfitnessValue(fit_value_sequence,arr);

    }
    
    
    void initialiseCityDistance(int n)
    {
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                if(i==j)
                {
                    dis[i][j]=0;
                    continue;
                }
                dis[i][j]=rant.nextInt(9)+1;
                dis[j][i]=dis[i][j];
            }
        }
        System.out.println("DISTANCE OF ONE CITY TO ANOTHER CITY");
            for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                System.out.print(dis[i][j]+" ");
            }
            System.out.println();
            
        }
            
    }
    void initialisePickfitnessValue(int[] fit_value_sequence,int[][] arr)
    {
    int m = fit_value_sequence.length;
	int[][] a = new int[m][m+1];
	
	for(int i=0;i<m;i++)
	    for(int j=0;j<m;j++)
	        a[i][j] = arr[i][j];
        
        for(int i=0;i<4;i++)
        for(int j=4;j<5;j++)
            a[i][j] = fit_value_sequence[i];
        
        //int ar[][] = new int[m][m+1];
        //ar = sortbyColumn(a,m);
        
        
		for(int i = 0; i< m-1; i++) {
			
			for (int j= 0; j<m-1-i; j++) {
				 
				if (fit_value_sequence[j+1] < fit_value_sequence[j]) {
					int temp= fit_value_sequence[j+1];
					fit_value_sequence[j+1] = fit_value_sequence[j];
					fit_value_sequence[j]= temp;
					
				}
				
			}
		}
		System.out.println();
		System.out.println("After sorting the fitness_sequence on the basics of fitness:");
		for (int item: fit_value_sequence) {
			System.out.print(item+" ");
		}
		//selection(arr,m);
    }
    void sortbyColumn(int arr[][], int col)
        {
            Arrays.sort(arr, new Comparator<int[]>() {

            public int compare(final int[] entry1,
            final int[] entry2) {

            if (entry1[col] > entry2[col])
            return 1;
            else
            return -1;
        }
        }); 
        
        
        }
     void selection (int[][] arr,int m1)
    {
        int m = m1;
        int[] selected1 = new int[m+1];
        int[] selected2 = new int[m+1];
        int[] selected3 = new int[m+1];
        int[] selected4 = new int[m+1];
        
        for(int i=0;i<1;i++)
            for(int j=0;j<m+1;j++)
                selected1[j] = arr[i][j];
                
        for(int i=1;i<2;i++)
            for(int j=0;j<m+1;j++)
                selected2[j] = arr[i][j];

        for(int i=2;i<3;i++)
            for(int j=0;j<m+1;j++)
                selected3[j] = arr[i][j];
                
        for(int i=3;i<4;i++)
            for(int j=0;j<m+1;j++)
                selected4[j] = arr[i][j];
        
        System.out.println();
        System.out.println();
        System.out.println("The two paths which are selected for crossover are - ");
        
            System.out.println("1-> Path - 1");
            System.out.print("      ");
            for(int j=0;j<m;j++)
                System.out.print(selected1[j]+" ");
                System.out.print("  Fitness value is: "+selected1[m]);
            System.out.println();
            System.out.println("2-> Path - 2");
            System.out.print("      ");
            for(int j=0;j<m;j++)
                System.out.print(selected2[j]+" ");
                System.out.print("  Fitness value is: "+selected2[m]);
            System.out.println();
        crossover(selected1, selected2,selected3,selected4,m);    
    }
     void crossover(int[] arr1,int[] arr2,int[] arr3,int[] arr4,int m)
    {
        int i;
        int a1[] = new int[m+1];
        int a2[] = new int[m+1];
        int a3[] = new int[m];
        int a4[] = new int[m];
        
        int fit_value=0;
        for(i=0;i<m;i++){
            a1[i] = arr1[i];
            a2[i] = arr2[i];
            a3[i] = arr3[i];
            a4[i] = arr4[i];
        }
        
        int temp,temp1;
        
        int[] a13 = new int[m+1];
        int[] a14 = new int[m+1];
        
        for(i=0;i<m/2;i++){
            temp = a2[i];
            for(int j=0;j<m;j++){
                if(a3[j] == temp){
                temp1 = a3[i];
                a3[i] = a3[j];
                a3[j] = temp1;
                }
            }
        }
        
        for(i=0;i<m;i++)
            a13[i] = a3[i];
        
        for(i=0;i<m;i++)
            a3[i] = arr3[i];
        
        
        
        for(i=(m/2)+1;i<m;i++){
            temp = a1[i];
            for(int j=0;j<m;j++){
                if(a4[j] == temp){
                temp1 = a4[i];
                a4[i] = a4[j];
                a4[j] = temp1;
                }
            }
        }
        
        for(i=0;i<m;i++){
            a14[i] = a4[i];
        }
        for(i=0;i<m;i++)
            a4[i] = arr4[i];
            
        
        System.out.println();
        System.out.println("After Crossover - ");
    
        
        for(int k=0;k+1<m;k++)
        {
            fit_value=fit_value+dis[a1[k]][a1[k+1]];
        }
        fit_value=fit_value+dis[a1[0]][a1[m-1]];
        a1[m] = fit_value;
        for(i=0;i<m;i++)
            System.out.print(a1[i]+" ");
            
        System.out.print("Fitness Value "+fit_value );
        
        
        
        System.out.println();
        fit_value=0;
        
        
        for(int k=0;k+1<m;k++)
        {
        fit_value=fit_value+dis[a2[k]][a2[k+1]];

        }
        fit_value=fit_value+dis[a2[0]][a2[m-1]];
        a2[m] = fit_value;
        for(i=0;i<m;i++)
            System.out.print(a2[i]+" ");
            
        System.out.print("Fitness Value "+fit_value );
        
        
        System.out.println();
        fit_value=0;
        
        
        
        for(int k=0;k+1<m;k++)
        {
        fit_value=fit_value+dis[a13[k]][a13[k+1]];

        }
        fit_value=fit_value+dis[a13[0]][a13[m-1]];
        a13[m] = fit_value;
        for(i=0;i<m;i++)
            System.out.print(a13[i]+" ");
        System.out.print("Fitness Value "+fit_value );
        
        
        System.out.println();
        fit_value=0;

            
        for(int k=0;k+1<m;k++)
        {
            fit_value=fit_value+dis[a14[k]][a14[k+1]];
        }
        fit_value=fit_value+dis[a14[0]][a14[m-1]];
        a14[m] = fit_value;
        for(i=0;i<m;i++)
            System.out.print(a14[i]+" ");
        System.out.print("Fitness Value "+fit_value );
        
        fit_value=0;
        System.out.println();
        
        for(i=0;i<1;i++)
            for(int j=0;j<m+1;j++)
                arr[i][j] = a1[j];
        
        for(i=1;i<2;i++)
            for(int j=0;j<m+1;j++)
                arr[i][j] = a2[j];
        
        for(i=2;i<3;i++)
            for(int j=0;j<m+1;j++)
                arr[i][j] = a13[j];
        
        for(i=3;i<4;i++)
            for(int j=0;j<m+1;j++)
                arr[i][j] = a14[j];
                
        System.out.println();
        System.out.println();
        
    }
    
}
public class Main {
    public static void main(String args[]) 
    {
        Scanner sc = new Scanner(System.in);
        Peddlar P1 = new Peddlar();
        P1.initialiseCityDistance(4);
     
        P1.initialiseCityOrder(4);
        System.out.println();
        System.out.println("Enter the number of iterations- ");
            int n = sc.nextInt();
        for(int i=0;i<n;i++){
            System.out.println("Iteration: "+i);
            P1.sortbyColumn(P1.arr,4);
            P1.selection(P1.arr,4);
        }    
    }
    
}