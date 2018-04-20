package OBST;  
import java.util.Scanner;  
  
public class OBST {  
    public static class Cost{  
        public double times;  
        public int word;  
        public Cost(){}  
    }  
    static int size;  
    static double[] pro;  
    static String[] str;  
    static double[][] weight;  
    static Cost[][] cost;  
    static final double inf=10000;  
    static double ans;  
  
    public static void printOBSTree(int i,int j){  
        if(j<i||j<0||i<0||j>=size||i>=size)return;  
        System.out.println(str[cost[i][j].word]);  
        printOBSTree(i,cost[i][j].word-1);  
        printOBSTree(cost[i][j].word+1,j);  
    }  
      
    public static void findOBSTree(){  
        Scanner in = new Scanner(System.in);  
        size = in.nextInt();  
        pro = new double[size];  
        str = new String[size];  
        weight = new double[size][size];  
        cost = new Cost[size][size];  
          
        for(int i=0;i<size;i++){  
            for(int j=0;j<size;j++){  
                cost[i][j] = new Cost();  
            }  
        }  
        for(int i=0;i<size;i++){  
            str[i] = in.next();   
            pro[i] = in.nextDouble();  
  
        }  
        for(int i=0;i<size;i++){  
            weight[i][i] = pro[i];  
            for(int j=i+1;j<size;j++){  
                weight[i][j]=weight[i][j-1]+pro[j];  
  
            }  
        }  
        for(int i=0;i<size;i++){  
            System.out.println(pro[i]);  
            cost[i][i].times = pro[i];  
            cost[i][i].word = i;  
        }  
        for(int k=2;k<=size;k++){  
            for(int i=0;i<=size-k;i++){  
                int j=i+k-1;  
                cost[i][j].times=inf;  
                for(int l=i;l<=j;l++){  
                      
                    double tmp=weight[i][j]  
                            +((l>i)?cost[i][l-1].times:0)  
                            +((l<j)?cost[l+1][j].times:0);  
  
                    if(tmp<cost[i][j].times){  
                        cost[i][j].word = l;  
                        cost[i][j].times = tmp;  
                    }  
                }  
            }  
        }  
        ans=cost[0][size-1].times;  
        System.out.println(ans);  
        printOBSTree(0,size-1);  
        in.close();  
    }  
      
    public static void main(String args[]){  
        findOBSTree();    
    }  
}  