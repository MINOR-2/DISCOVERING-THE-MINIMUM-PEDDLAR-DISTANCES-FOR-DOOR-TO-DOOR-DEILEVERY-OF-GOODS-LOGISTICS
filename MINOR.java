import java.util.*;
class Peddlar
{
    Scanner sc=new Scanner(System.in);
    Random rant=new Random();
    int dis[][]=new int[5][5];

    void initialiseCityOrder(int n)
    {
        int arr[][]=new int[n][n];
        List <Integer>l1=new ArrayList<Integer>();
        for(int i=0;i<n;i++)
        {
            l1.add(i);
        }
        for(int i=0;i<5;i++)
        {
        
        Collections.shuffle(l1);
        for(int j=0;j<5;j++)
        {
            arr[i][j]=l1.get(j);
        }
        }
        System.out.println();
        for(int i=0;i<5;i++)
        {
            int fit_value=0;

            System.out.println("CITY VISITING PATTERN NO-"+(i+1)+" ");
            System.out.print(" | ");
            for(int j=0;j<5;j++)
            {
                System.out.print(arr[i][j]+" | ");
            }
            for(int j=0;j+1<5;j++)
            {
                fit_value+=dis[arr[i][j]][arr[i][j+1]];
            }
            fit_value=fit_value+dis[arr[i][4]] [arr[i][0]];
            System.out.println();
            System.out.println("FIT_VALUE="+fit_value);
            System.out.println();
            System.out.println();
        }
    }
    void initialiseCityDistance(int n)
    {
        for(int i=0;i<5;i++)
        {
            for(int j=i+1;j<5;j++)
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
            for(int i=0;i<5;i++)
        {
            for(int j=0;j<5;j++)
            {
                System.out.print(dis[i][j]+" ");
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