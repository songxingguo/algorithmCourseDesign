/**  
* @Title: State.java
* @Package sxg.algorithm.traversal
* @Description: TODO
* @author songxingguo
* @date 2018年1月5日 上午1:43:26
*/
package sxg.algorithm.traversal;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * @author songxinggo
 * @date 2018.01.05
 */
public class State {
	
	int[] buckets = new int[3];
	int[] maxCapacity = {8, 5, 3};
	State preState;
	
	public State(int first, int second, int third)  {
		buckets[0] = first;
		buckets[1] = second;
		buckets[2] = third;
	}
	
	public State(State s) {
		buckets[0] = s.buckets[0];
		buckets[1] = s.buckets[1];
		buckets[2] = s.buckets[2];
	}
	
	/**
	 * 
	 * @Title: pour
	 * @Description: 倒水
	 * @param: @param from
	 * @param: @param to
	 * @return: void   
	 * @throws
	 */
	public void pour(int from, int to) {
		//to容器的容量小于from和to中水量之和
		if (buckets[from] + buckets[to] > maxCapacity[to]) {
			buckets[from] = buckets[from] - (maxCapacity[to] - buckets[to]);
			buckets[to] = maxCapacity[to];
		} else {
			buckets[to] = buckets[from] + buckets[to];
			buckets[from] = 0;
		}
	}
	
	/**
	 * 
	 * @Title: canPour
	 * @Description: 是否可以倒水
	 * @param: @return
	 * @return: boolean   
	 * @throws
	 */
	public boolean canPour(int from, int to) {
		//from中水量为空或to中水量已经达到最大水量
		if (buckets[from] == 0 || buckets[to] == maxCapacity[to]) {
			return false;
		}
		
		return true;
	}
}
