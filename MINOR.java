import java.util.*;
class Peddlar
{
    Scanner sc=new Scanner(System.in);
    Random rant=new Random();
    
    
    void initialiseCityOrder(int n)
    {
        int arr[][]=new int[n][n];
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
            arr[i][j]=l1.get(j)+1;
        }
        }
        System.out.println();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    void initialiseCityDistance(int n)
    {
        int arr[][]=new int[n][n];
        for(int i=0;i<5;i++)
        {
            for(int j=i+1;j<5;j++)
            {
                if(i==j)
                {
                    arr[i][j]=0;
                    continue;
                }
                arr[i][j]=rant.nextInt(9)+1;
                arr[j][i]=arr[i][j];
            }
            
        }
        
        
        for(int i=0;i<5;i++)
        {
            for(int j=0;j<5;j++)
            {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
            
            
        }
        
    }
}
public class MyClass {
    public static void main(String args[]) 
    {
     Peddlar P1=new Peddlar();
     P1.initialiseCityDistance(5);
     P1.initialiseCityOrder(5);
    }
}