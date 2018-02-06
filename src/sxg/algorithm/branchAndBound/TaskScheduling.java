/**  
* @Title: TaskScheduling.java
* @Package sxg.algorithm.branchAndBound
* @Description: TODO
* @author songxingguo
* @date 2018年1月5日 上午11:44:25
*/
package sxg.algorithm.branchAndBound;

import java.util.Scanner;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * @author songxinggo
 * @date 2018.01.05
 */
public class TaskScheduling {
	private int machineCount = 6;
	private int taskCount = 4;
	private static int[] s = new int[1001];//当前容器的任务时间
	private static int[] a = new int[1001]; //任务时间
	private static int ans = 15454;
	private static int n; //任务数
	private static int k; //机器数
	
	public static void main(String[] args) {
		Scanner input =  new Scanner(System.in);
		
		System.out.println("请输入任务数和机器数：");
		int taskCount = input.nextInt();
		int machineCount = input.nextInt();
		int[] taskTimes = new int[taskCount];
		System.out.println("请输入任务时间：");
		for (int i = 0; i < taskCount; i++) {
			taskTimes[i] = input.nextInt();
			System.out.println(taskTimes[i]);
		}
		
		dfs(1, 0);
	}
	
	public static void dfs(int x,int y) {  
	    int i;  
	    
	    //最优化剪枝：如果当前的最大值已经超过了当前已知的最小值，那么停止搜索  
	    if (ans <= y) return;
	    
	    //最后一个任务
	    if (x ==  n + 1) {  
	        if (ans > y) ans = y;  
	        return;  
	    }  
	    
	    //枚举每一个容器 
	    for (i = 1; i <= k; ++i) {
		    //最优化剪枝：往容器里放的时候不能超过当前已知的最小值  
		    if (s[i] + a[x] < ans) {  
		        s[i] += a[x];//将枚举到的时间（物品）放入容器  
		        dfs(x + 1, Math.max(y, s[i]));//搜索下一层，第二个关键字是当前k个容器里的最大值  
		        s[i] -= a[x];//回溯一步  
		    } 
	    }
	    
	    return;  
	}  
}
