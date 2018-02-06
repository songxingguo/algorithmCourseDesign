/**  
* @Title: DNA.java
* @Package sxg.algorithm.dynamicProgramming
* @Description: TODO
* @author songxingguo
* @date 2018年1月5日 上午3:18:12
*/
package sxg.algorithm.dynamicProgramming;

import java.awt.Button;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class DNA extends JFrame{
	
	private Label notice = new Label("提示，只能输入AGCT四种字母");
	private Label input1 = new Label("第一个基因：");
	private Label input2 = new Label("第二个基因：");
	private Label input3 = new Label("相似度：");
	private Label input4 = new Label("匹配结果：");
	private Label input5 = new Label();
	private TextField str1 = new TextField(50);
	private TextField str2 = new TextField(50);
	private Button qd = new Button("确定");
	private Button cz = new Button("重置");
	private Panel panel = new Panel();
	
	public DNA() {
		panel.add(notice);
		panel.add(str1);
		panel.add(str2);
		panel.add(input1);
		panel.add(input2);
		panel.add(input3);
		panel.add(input4);
		panel.add(input5);
		panel.add(qd);
		panel.add(cz);
		panel.setLayout(null);
	
		notice.setBounds(100, 20, 300, 30);
		input1.setBounds(100, 50, 100, 30);
		str1.setBounds(200, 50, 300, 30);
		
		input2.setBounds(100, 80, 100, 30);
		str2.setBounds(200, 80, 300, 30);
		
		input3.setBounds(100, 110, 200, 30);
		input4.setBounds(100, 140, 200, 30);
		input5.setBounds(166, 180, 200, 30);
		
		qd.setBounds(250, 200, 50, 30);
		cz.setBounds(400, 200, 50, 30);
		
		qd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String jy1 = str1.getText();
				String jy2 = str2.getText();
				
				if(jy1.length() == 0 && jy2.length() == 0) {
					return ;
				}	
				if(check(jy1) && check(jy2)) {
					DNACompare dc = new DNACompare(jy1, jy2);
					input3.setText("相识度：  " + (dc.GetResult()==0?0:dc.GetResult()));
					input4.setText("匹配结果：  " + dc.SDNA1);
					input5.setText(dc.SDNA2);
				} 
			}
		}
	);
		
		cz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				str1.setText("");
				str2.setText("");
				input3.setText("相识度： ");
				input4.setText("匹配结果：");
				input5.setText("");
			}
		}
		);
		
		this.add(panel);
		this.setSize(600, 400);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("算法课程设计 DNA序列比对 ");		
	}
	
	public static boolean check(String string) {
		
		List<String> lis = new ArrayList<String>();
		lis.add("A");
		lis.add("C");
		lis.add("G");
		lis.add("T");
		for(int i = 0;i < string.length();i++) {
			String s = string.charAt(i)+"";
			if(!lis.contains(s)) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args){
		new DNA();
	}
}
