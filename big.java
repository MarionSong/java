/* 
     * 分而治之  时间复杂度为O(NlogN) 
     */  
    public int maxSubSum3(int[] a,int left,int right){  
      
        if(left == right){  //基础情况：单个元素。直接返回这个数值或者0  
            return a[left];  
        }  
  
        int center = (left + right) / 2;      //获取中点  
          
        int leftMaxSum = maxSubSum3(a,left,center); // 整个出现在输入数据的左半部的最大子序列求和   
          
        int rightMaxSum = maxSubSum3(a,center+1,right); // 整个出现在输入数据的右半部的最大子序列求和   
          
        int lrMaxSum = max(leftMaxSum,rightMaxSum);  //计算左右两个子序列求和结果的最大值  
  
        // 横跨左右两个部分的最大子序列求和   
  
        //从center向左处理左半边  
        int maxLeftSum = 0;  
        int leftSum = 0;  
        for (int i = center; i >= left; i--){  
            leftSum += a[i];  
            maxLeftSum = max(maxLeftSum,leftSum);  
        }  
  
        //从center向右处理右半边  
        int maxRightSum = 0;  
        int rightSum = 0;  
        for (int j = center+1; j <= right; j++){  
            rightSum += a[j];  
            maxRightSum = max(maxRightSum,rightSum);  
        }  
  
        //返回求和和前面算出结果的最大值  
        return max( lrMaxSum, maxLeftSum+maxRightSum);  
    }  
  
    int max(int a,int b){  
        return a>=b ? a:b;  
    }  



















/* 
 * 计算并返回所最大子序列的和：最优算法  时间复杂度为O(N) 
 */  
 public int maxSubSum4(int[] a){  
  
     int maxSum = 0;     //最终结果  
     int nowSum = 0;    //当前求和   
  
      for (int j = 0; j < a.length; j++) {       //遍历序列的所有元素  
  
        nowSum += a[j];         //将当前元素添加到结果中  
  
       if(nowSum > maxSum) {         //如果大于最大值，则存储为新的最大值  
             maxSum = nowSum;  
       }else if(nowSum < 0){  
         nowSum = 0;  
       }  
      }  
      return maxSum;  
 }  