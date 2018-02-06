/**  
* @Title: SimpleFractalTree.java
* @Package sxg.algorithm.basicRecursive
* @Description: TODO
* @author songxingguo
* @date 2018年1月2日 上午11:04:12
*/
package sxg.algorithm.basicRecursive;

import java.util.ArrayList;

/**
 * 题目：绘制一个简单的分形树
 * 描述：如下图所示，先垂直绘制一根线段，然后在线段长度的三分之一处和三分之二处分别以固定夹角绘制另外两根线段，
 * 长度分别为原线段的2/3. 如此反复，直至线段长度小于某个较小的值。
 * 其中，线条颜色以及长度，夹角（例如产生某个范围的随机数）都可以自行进行微调。
 * 如果树枝不够丰满，可以自行增设。
 * @author songxinggo
 * @date 2018.01.02
 */
public class SimpleFractalTree {

	private int length;
	
	private ArrayList<Branch> branchs = new ArrayList<SimpleFractalTree.Branch>();
	
	/**
	 * @Title: SimpleFractalTree
	 * @throws
	 */
	public SimpleFractalTree() {
	}
	
	/**
	 * @Title: SimpleFractalTree
	 * @param: @param length
	 * @throws
	 */
	public SimpleFractalTree(int length) {
		super();
		this.length = length;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public ArrayList<Branch> getBranchs() {
		return branchs;
	}

	public void setBranchs(ArrayList<Branch> branchs) {
		this.branchs = branchs;
	}

	/**
	 * 
	 * 树枝
	 * @author songxinggo
	 * @date 2018.01.02
	 */
	class Branch {
		private Node startNode;
		
		private Node endNode;
		
		private String color;
		
		private int angle;

		/**
		 * 
		 * @Title: getXDistance
		 * @Description: 获取横向距离
		 * @param: @return
		 * @return: int   
		 * @throws
		 */
		public int getXDistance() {
			return endNode.getxCoordinate() - startNode.getxCoordinate();
		}
		
		public int getYDistance() {
			return endNode.getyCoordinate() - startNode.getyCoordinate();
		}
		
		public Node getStartNode() {
			return startNode;
		}

		public void setStartNode(Node startNode) {
			this.startNode = startNode;
		}

		public Node getEndNode() {
			return endNode;
		}

		public void setEndNode(Node endNode) {
			this.endNode = endNode;
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}

		public int getAngle() {
			return angle;
		}

		public void setAngle(int angle) {
			this.angle = angle;
		}
	}
	
	/**
	 * 
	 * 树节点
	 * @author songxinggo
	 * @date 2018.01.02
	 */
	class Node {
		private int xCoordinate;
		
		private int yCoordinate;

		public Node(int xCoordinate, int yCoordinate) {
			this.xCoordinate = xCoordinate;
			this.yCoordinate = yCoordinate;
		}
		
		public int getxCoordinate() {
			return xCoordinate;
		}

		public void setxCoordinate(int xCoordinate) {
			this.xCoordinate = xCoordinate;
		}

		public int getyCoordinate() {
			return yCoordinate;
		}

		public void setyCoordinate(int yCoordinate) {
			this.yCoordinate = yCoordinate;
		}
	}
}
