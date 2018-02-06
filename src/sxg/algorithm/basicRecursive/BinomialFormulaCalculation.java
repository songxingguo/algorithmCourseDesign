package sxg.algorithm.basicRecursive;

/**
 * 
 * 二项式公式计算
 * 完成二项式公式计算，即Ckn=Ck−1n−1+Ckn−1Cnk=Cn−1k−1+Cn−1k. 
 * 公式解释：为了从n个不同元素中抓取k个元素(CknCnk)，可以这样考虑，
 * 如果第一个元素一定在结果中，那么就需要从剩下的n-1个元素中抓取k-1个元素(Ck−1n−1Cn−1k−1)；
 * 如果第一个元素不在结果中，就需要从剩下的n-1个元素中抓取k个元素(Ckn−1Cn−1k)。 
 * @author songxinggo
 * @date 2018.01.02
 */
public class BinomialFormulaCalculation {
	
	/**
	 * 
	 * @Title: getBinomialForRecursive
	 * @Description: 使用递归算法计算二项式公式
	 * @param: @param n
	 * @param: @param k
	 * @param: @return
	 * @return: int   
	 * @throws
	 */
	public static int getBinomialForRecursive(int n , int k) {
		
		//Cn0和Cnn返回确认的值为1
		if (k == 0 || k == n) {
			return 1;
		} else {
			return getBinomialForRecursive(n - 1, k -1) 
					+ getBinomialForRecursive(n -1, k);
		}
	}
	
	/**
	 * 
	 * @Title: getBinomialForMemorandum
	 * @Description: 使用备忘录计算二项式公式
	 * @param: @param n
	 * @param: @param k
	 * @param: @return
	 * @return: int   
	 * @throws
	 */
	public static int getBinomialForMemorandum(int n, int k) {
		int[][] binomial = new int[n + 1][n + 1];
		int value;
		
		if (k == 0 || k == n) {
			 value = 1;
		} else if (binomial[n][k] != 0) {
			 return binomial[n][k];
		} else {
			value = getBinomialForMemorandum(n - 1, k -1) 
					+ getBinomialForMemorandum(n -1, k);
		}
		
		binomial[n][k] = value;
		return binomial[n][k];	
	}
	
	/**
	 * 
	 * @Title: getBinomialForIterate
	 * @Description: 使用迭代计算二项式公式
	 * @param: @param n
	 * @param: @param k
	 * @param: @return
	 * @return: int   
	 * @throws
	 */
	public static int getBinomialForIterate(int n, int k) {
		int denominator = 1;
		int molecule = 1;
		
		if (k == 0 || k == n) {
			return 1;
		}
		
		for (int i = n; i > n - k; i--) {
			denominator = denominator * i; 
		}
		
		for (int j = k; j > 0; j--) {
			molecule = molecule * j;
		}
		
		return denominator / molecule;
	}
}
