/**  
* @Title: Interval.java
* @Package sxg.algorithm.dynamicProgramming
* @Description: TODO
* @author songxingguo
* @date 2018年1月5日 下午12:58:32
*/
package sxg.algorithm.dynamicProgramming;

import java.util.Arrays;

/**
 * <p>Title: </p>
 * 每次选取结束时间最早的
 * @author songxinggo
 * @date 2018.01.05
 */
public class Interval {
    private static int t = 0;  
 
    public static int interval(Work[] works) {  
    	
    	//先按结束时间排序
        Arrays.sort(works);  
        int count = 0;  
        //当前工作的结束时间  
        int t = 0;  
        for (int i = 0; i < works.length; i++) {  
        	//当前工作的结束时间小于下一个工作的开始时间
            if(t < works[i].getStart()) {  
                count ++;  
                System.out.print(" " + i);
                t = works[i].getEnd();  
            }  
        }  
        
        return count;  
    }  
    
    public static void maxInterval(Work[] works) {
    	//先按结束时间排序
        Arrays.sort(works);  
        
        maxInterval(works.length - 1, works);
        
        System.out.println("  值：" + maxInterval(works.length - 1, works));
    }
    
    /**
     * 
     * @Title: maxInterval
     * @Description: TODO
     * @param: 
     * @return: void   
     * @throws
     */
    public static int maxInterval(int j, Work[] works) {
    	if (j == 0 || t >= works[j].getStart()) {
    		return 0;
    	} else {
            System.out.print(" 序号：" + j);
            t = works[j].getEnd();  
            int t1 = works[j].value + maxInterval(j, works);
        	int t2 = works[j].value + maxInterval(j - 1, works);
        	return Math.max(t1, t2);
    	} 
    }
  
    public static void main(String args[]) {  
        Work[] works = {  
            new Work(1, 3, 1),  
            new Work(2, 5, 2),  
            new Work(4, 7, 3),  
            new Work(6, 9, 4),  
            new Work(8, 10, 5)  
        };  
        
//        int result = interval(works);  
//        System.out.println(result);  
        
        maxInterval(works);
    } 
}
