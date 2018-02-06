package sxg.algorithm.basicRecursive;


import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import sxg.algorithm.basicRecursive.SimpleFractalTree.Branch;
import sxg.algorithm.basicRecursive.SimpleFractalTree.Node;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * @author songxinggo
 * @date 2018.01.02
 */
public class DrawSimpleFractalTree  extends JPanel{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 最小枝叶
	 */
	private int min;
	
	private SimpleFractalTree tree = new SimpleFractalTree();
	
    public DrawSimpleFractalTree(int length,int min){  
        this.min = min;  
        getBranchs(tree.new Node(850,800), length, 0.0);  
    }  
      
    public void paint(Graphics g) {  
        super.paintComponent(g);  
        ArrayList<Branch> branchs = tree.getBranchs();
          
        for(Branch b :  branchs) {  
        	// 随机颜色
        	g.setColor(new Color((int)(Math.random()*256),(int)(Math.random()*256)
        			,(int)(Math.random()*256)));
            g.drawLine(b.getStartNode().getxCoordinate(), b.getStartNode().getyCoordinate(), 
            		b.getEndNode().getxCoordinate(), b.getEndNode().getyCoordinate());  
      
        }  
          
    }  
    
    /**
     * 
     * @Title: printResult
     * @Description: 打印结果
     * @param: @param x
     * @param: @param y
     * @return: void   
     * @throws
     */
    public void printResult(int x, int y) {
    	 System.out.print("[" + x + "," + y +"],");
    }
	
	public void getBranchs(Node startNode, int length, Double angle) {
 		if (length <= min) {
			return;
		} else {
			
			Branch branch = tree.new Branch();
			branch.setStartNode(startNode);
			
			int xCoordinate1 =(int)(length*Math.cos(Math.PI/2 - angle) 
					+ startNode.getxCoordinate());
			int yCoordinate1 = (int) (startNode.getyCoordinate() 
					- length*Math.sin(Math.PI/2 - angle)); 

            branch.setEndNode(tree.new Node(xCoordinate1, yCoordinate1));
            tree.getBranchs().add(branch);
            
            int maxRight = length * 2/3;  
            int x2 = startNode.getxCoordinate()  + branch.getXDistance() / 3;  
            int y2 = startNode.getyCoordinate() + branch.getYDistance() / 3;  
            double angle1 = angle + Math.PI/6;  
            
            int maxLeft = length * 1/3;  
            int x3 = startNode.getxCoordinate() + branch.getXDistance() * 2/3;  
            int y3 = startNode.getyCoordinate() +  branch.getYDistance() * 2/3;  
            double angle2 = angle - Math.PI/6;  
            
            getBranchs(tree.new Node(x3, y3), maxLeft, angle2);  
            getBranchs(tree.new Node(x2, y2), maxRight, angle1);  
		}
	}
}
