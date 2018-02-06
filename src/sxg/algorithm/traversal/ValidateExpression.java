package sxg.algorithm.traversal;

import java.util.ArrayList;

public class ValidateExpression {
	public static boolean verfyExpression(String expression) {
		int value = CalculateExpression.calculateExpression(expression);
		System.out.println(value);
		if (value == 24) {
			return true;
		}
		
		return false;
	}
	
	public static ArrayList<ArrayList<String>> findSolusion(String a, String b, String c, String d) {
		ArrayList<ArrayList<String>> solusions = new ArrayList<ArrayList<String>>();
		
		if (!calculate(a,b,c,d).isEmpty()) solusions.add(calculate(a,b,c,d));
		if (!calculate(a,b,d,c).isEmpty()) solusions.add(calculate(a,b,d,c));
		if (!calculate(a,c,d,b).isEmpty()) solusions.add(calculate(a,c,d,b));
		if (!calculate(a,c,b,d).isEmpty()) solusions.add(calculate(a,c,b,d));
		if (!calculate(a,d,b,c).isEmpty()) solusions.add(calculate(a,d,b,c));
		if (!calculate(a,d,c,b).isEmpty()) solusions.add(calculate(a,d,c,b));
		if (!calculate(b,a,c,d).isEmpty()) solusions.add(calculate(b,a,c,d));
		if (!calculate(b,a,d,c).isEmpty()) solusions.add(calculate(b,a,d,c));
		if (!calculate(b,c,a,d).isEmpty()) solusions.add(calculate(b,c,a,d));
		if (!calculate(b,c,d,a).isEmpty()) solusions.add(calculate(b,c,d,a));
		if (!calculate(b,d,c,a).isEmpty()) solusions.add( calculate(b,d,c,a));
		if (!calculate(b,d,a,c).isEmpty()) solusions.add(calculate(b,d,a,c));
		if (!calculate(c,a,b,d).isEmpty()) solusions.add(calculate(c,a,b,d));
		if (!calculate(c,b,d,a).isEmpty()) solusions.add(calculate(c,b,d,a));
		if (!calculate(c,b,a,d).isEmpty()) solusions.add(calculate(c,b,a,d));
		if (!calculate(c,d,a,b).isEmpty()) solusions.add(calculate(c,d,a,b));
		if (!calculate(c,d,b,a).isEmpty()) solusions.add(calculate(c,d,b,a));
		if (!calculate(d,a,b,c).isEmpty()) solusions.add(calculate(d,a,b,c));
		if (!calculate(d,a,c,b).isEmpty()) solusions.add(calculate(d,a,c,b));
		if (!calculate(d,b,c,a).isEmpty()) solusions.add(calculate(d,b,c,a));
		if (!calculate(d,b,a,c).isEmpty()) solusions.add(calculate(d,b,a,c));
		if (!calculate(d,c,a,b).isEmpty()) solusions.add(calculate(d,c,a,b));
		if (!calculate(d,c,b,a).isEmpty()) solusions.add(calculate(d,c,b,a));

		System.out.println(solusions);
		return solusions;
	}
	
	public static ArrayList<String> calculate(String a, String b, String c, String d) {
		ArrayList<String> strings = new ArrayList<String>();
	    if (equalTwentyFour(caseOne(a, b, c, d, "+", "+", "+"))) {
	    	strings.add(caseOne(a, b, c, d, "+", "+", "+"));
	    }
	    if (equalTwentyFour(caseOne(a, b, c, d, "+", "+", "-")))  {
	    	strings.add(caseOne(a, b, c, d, "+", "+", "-"));
	    }
	    if (equalTwentyFour(caseOne(a, b, c, d, "*", "*", "*"))) {
	    	strings.add(caseOne(a, b, c, d, "*", "*", "*"));
	    } 
	    if (equalTwentyFour(caseTwo(a, b, c, d, "+", "*", "+"))) {
	    	strings.add(caseTwo(a, b, c, d, "+", "*", "+"));
	    }
	    if (equalTwentyFour(caseTwo(a, b, c, d, "-", "*", "+"))){
	    	strings.add(caseTwo(a, b, c, d, "-", "*", "+"));
	    }
	   	if (equalTwentyFour(caseTwo(a, b, c, d, "-", "*", "-"))){
	      	strings.add(caseTwo(a, b, c, d, "-", "*", "-"));  
	    }
	    if (!d.equals("0") && equalTwentyFour(caseTwo(a, b, c, d, "*", "-", "/"))){
	    	strings.add(caseTwo(a, b, c, d, "*", "-", "/")); 
	    } 
	    if (!d.equals("0") && equalTwentyFour(caseTwo(a, b, c, d, "*", "+", "/"))){
	    	strings.add(caseTwo(a, b, c, d, "*", "+", "/")); 
	    } 
	    if (equalTwentyFour(caseTwo(a, b, c, d, "*", "*", "+"))){
	    	strings.add(caseTwo(a, b, c, d, "*", "*", "+")); 
	    }  
	    if (equalTwentyFour(caseTwo(a, b, c, d, "*", "*", "-"))){
	    	strings.add(caseTwo(a, b, c, d, "*", "*", "-")); 
	    }   
	    if (!d.equals("0") && equalTwentyFour(caseTwo(a, b, c, d, "+", "+", "/"))){
	    	strings.add(caseTwo(a, b, c, d, "+", "+", "/")); 
	    }   
	    if (!d.equals("0") && equalTwentyFour(caseTwo(a, b, c, d, "+", "*", "/"))){
	    	strings.add(caseTwo(a, b, c, d, "+", "*", "/")); 
	    }  
	    if (equalTwentyFour(caseTwo(a, b, c, d, "*", "+", "*"))){
	    	strings.add(caseTwo(a, b, c, d, "*", "+", "*")); 
	    } 
	    if (equalTwentyFour(caseTwo(a, b, c, d, "*", "-", "*"))){
	    	strings.add(caseTwo(a, b, c, d, "*", "-", "*")); 
	    }  
	    else if (equalTwentyFour(caseTwo(a, b, c, d, "*", "/", "*"))){
	    	strings.add(caseTwo(a, b, c, d, "*", "/", "*")); 
	    }  
	    if (!c.equals(d) && equalTwentyFour(caseTwo(a, b, c, d, "*", "/", "-"))){
	    	strings.add(caseTwo(a, b, c, d, "*", "/", "-")); 
	    }  
	    if (!d.equals(c) && equalTwentyFour(caseTwo(a, b, c, d, "*", "/", "+"))){
	    	strings.add(caseTwo(a, b, c, d, "*", "/", "+")); 
	    } 
	    if (equalTwentyFour(caseThree(a, b, c, d, "+", "+", "*"))){
	    	strings.add(caseThree(a, b, c, d, "+", "+", "*")); 
	    }
	    if (equalTwentyFour(caseThree(a, b, c, d, "-", "-", "*"))){
	    	strings.add(caseThree(a, b, c, d, "-", "-", "*")); 
	    }
	    if (equalTwentyFour(caseThree(a, b, c, d, "+", "-", "*"))){
	    	strings.add(caseThree(a, b, c, d, "+", "-", "*")); 
	    }
	    if (!d.equals("0") && equalTwentyFour(caseThree(a, b, c, d, "*", "*", "/"))){
	    	strings.add(caseThree(a, b, c, d, "*", "*", "/")); 
	    }  
	    if (equalTwentyFour(caseFour(a, b, c, d, "*", "*", "-"))){
	    	strings.add(caseFour(a, b, c, d, "*", "*", "-")); 
	    }  
	    if (equalTwentyFour(caseFour(a, b, c, d, "*", "*", "+"))){
	    	strings.add(caseFour(a, b, c, d, "*", "*", "+")); 
	    }  
	    if (equalTwentyFour(caseFour(a, b, c, d, "*", "+", "+"))){
	    	strings.add(caseFour(a, b, c, d, "*", "+", "+")); 
	    }
	    if (equalTwentyFour(caseFour(a, b, c, d, "*", "+", "-"))){
	    	strings.add(caseFour(a, b, c, d, "*", "+", "-")); 
	    }    

	    if (equalTwentyFour(caseFour(a, b, c, d, "*", "-", "-"))){
	    	strings.add(caseFour(a, b, c, d, "*", "-", "-")); 
	    }    
	    	
	    System.out.println(strings);
	    return strings;
	}
	
	private static boolean equalTwentyFour(String expression) {
		return CalculateExpression.calculateExpression(expression) == 24;
	}
	
	//情况一:没括号
	private static String caseOne(String a, String b, String c, String d, String z, String y, String q) {
		StringBuffer string = new StringBuffer();
		string.append(a);
		string.append(z);
		string.append(b);
		string.append(y);
		string.append(c);
		string.append(q);
		string.append(d);
		
		System.out.println("caseOne:" + string.toString());
		return string.toString();
	}
	
	//情况二:前后两括号
	private static String caseTwo(String a, String b, String c, String d, String z, String y, String q) {
		StringBuffer string = new StringBuffer();
		string.append("(");
		string.append(a);
		string.append(z);
		string.append(b);
		string.append(")");
		string.append(y);
		string.append("(");
		string.append(c);
		string.append(q);
		string.append(d);
		string.append(")");
		
		System.out.println("caseTwo:" + string.toString());
		return string.toString();
	}
	

	//情况三:前三一个括号
	private static String caseThree(String a, String b, String c, String d, String z, String y, String q) {
		StringBuffer string = new StringBuffer();
		string.append("(");
		string.append(a);
		string.append(z);
		string.append(b);
		string.append(y);
		string.append(c);
		string.append(")");
		string.append(q);
		string.append(d);
		
		System.out.println("caseThree:" + string.toString());
		return string.toString();
	}
	
	//情况四:前面两个一个括号
	private static String caseFour(String a, String b, String c, String d, String z, String y, String q) {
		StringBuffer string = new StringBuffer();
		string.append("(");
		string.append(a);
		string.append(z);
		string.append(b);
		string.append(")");
		string.append(y);
		string.append(c);
		string.append(q);
		string.append(d);
		
		System.out.println("caseFour:" + string.toString());
		return string.toString();
	}
	
	//情况五:中间一个括号
	private static String caseFive(String a, String b, String c, String d, String z, String y, String q) {
		StringBuffer string = new StringBuffer();
		string.append(a);
		string.append(z);
		string.append("(");
		string.append(b);
		string.append(y);
		string.append(c);
		string.append(")");
		string.append(q);
		string.append(d);
		
		System.out.println("caseFive:" + string.toString());
		return string.toString();
	}
	
	//情况六:前面两个混合括号
	private static String caseSix(String a, String b, String c, String d, String z, String y, String q) {
		StringBuffer string = new StringBuffer();
		string.append("(");
		string.append("(");
		string.append(a);
		string.append(z);
		string.append(b);
		string.append(")");
		string.append(y);
		string.append(c);
		string.append(")");
		string.append(q);
		string.append(d);
		
		System.out.println("caseSix:" + string.toString());
		return string.toString();
	}
	
	//情况七:后面两个混合括号
	private static String caseSeven(String a, String b, String c, String d, String z, String y, String q) {
		StringBuffer string = new StringBuffer();
		string.append("(");
		string.append(a);
		string.append(z);
		string.append("(");
		string.append(b);
		string.append(y);
		string.append(c);
		string.append(")");
		string.append(")");
		string.append(q);
		string.append(d);
		
		System.out.println("caseSeven:" + string.toString());
		return string.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(findSolusion("1", "5", "7", "9"));
	}
}