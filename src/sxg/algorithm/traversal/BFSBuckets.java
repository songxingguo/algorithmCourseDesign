/**  
* @Title: BFSBuckets.java
* @Package sxg.algorithm.traversal
* @Description: TODO
* @author songxingguo
* @date 2018年1月5日 上午2:00:36
*/
package sxg.algorithm.traversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * @author songxinggo
 * @date 2018.01.05
 */
public class BFSBuckets {
	
	public static void bfs() {
		int n = 0;
		int[] visited = new int[853];
		Queue<State> queue = new LinkedList<State>();
		State start = new State(8, 0, 0);
		State state = start;
		State endState = new State(8, 8, 8);
//		ArrayList<State> pourList = new ArrayList<State>();
//		queue.offer(start);
		do {
			for (int i = 0; i < 3; i++) {
				for (int j =0; j < 3; j++) {
					
					//不向自己倒水或者可以倒水
					if (i != j && state.canPour(i, j)) {
					    State newState = new State(state);
					    newState.pour(i, j);
						
						//没有被访问
						if (visited[newState.buckets[0] * 100 + newState.buckets[1]*10 + newState.buckets[2]] == 0) {
							visited[newState.buckets[0] * 100 + newState.buckets[1]*10 + newState.buckets[2]]++; //标记为已访问
							
							queue.offer(newState);
	
							if (state.buckets[0] == 4 
									|| state.buckets[1] == 4 
									|| state.buckets[2] == 4) {
								System.out.println(state.buckets[0] + "" +  state.buckets[1] + state.buckets[2]);
								endState = state;
								continue;
							}
						}

					}
				}
			}
			
			state = queue.poll();
		} while(endState.buckets[0] == 8 
				&& endState.buckets[1] == 8 
				&& endState.buckets[2] == 8 
				&& !queue.isEmpty());
	}

	public static void main(String[] args) {
		bfs();
	}
}
