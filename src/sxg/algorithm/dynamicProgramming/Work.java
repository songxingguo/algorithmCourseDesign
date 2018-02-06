/**  
* @Title: Work.java
* @Package sxg.algorithm.dynamicProgramming
* @Description: TODO
* @author songxingguo
* @date 2018年1月5日 下午12:53:49
*/
package sxg.algorithm.dynamicProgramming;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * @author songxinggo
 * @date 2018.01.05
 */
public class Work implements Comparable<Work> {
	private int start;
	
	private int end;
	
    int value;
	
	/**
	 * @Title: Work
	 * @Description: TODO
	 * @param: @param start
	 * @param: @param end
	 * @throws
	 */
	public Work(int start, int end, int value) {
		super();
		this.start = start;
		this.end = end;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	/**
	 * <p>Title: compareTo</p>
	 * <p>Description: </p>
	 * @param o
	 * @return
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Work o) {
        Work work = (Work) o;  
        
        if (this.end > work.getEnd())  
            return 1;  
        else if (this.end == work.getEnd())  
            return 0;  
        else  
            return -1;  
	}  
}
