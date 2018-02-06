/**  
* @Title: DrawSimpleFractalTreeTest.java
* @Package sxg.algorithm.test
* @Description: TODO
* @author songxingguo
* @date 2018年1月3日 上午11:39:26
*/
package sxg.algorithm.test;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import org.junit.Test;

import sxg.algorithm.basicRecursive.DrawSimpleFractalTree;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * @author songxinggo
 * @date 2018.01.03
 */
public class DrawSimpleFractalTreeTest extends JFrame {
 
	private static final long serialVersionUID = 1L;  
	  
	public DrawSimpleFractalTreeTest(){  
		setTitle("drawTree");  
	    add(BorderLayout.CENTER,new DrawSimpleFractalTree(800,0));
	}  
	
	@Test
	public void testDrawSimpleFractalTree() {

	}
	
	public static void main(String[] args) {
		DrawSimpleFractalTreeTest jFrame = new DrawSimpleFractalTreeTest();  
	    jFrame.setLocationRelativeTo(null);  
	    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	    jFrame.setSize(500,500);  
	    jFrame.setLocation(400, 200);  
	    jFrame.setVisible(true);  
	}
}
