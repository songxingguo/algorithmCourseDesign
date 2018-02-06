/**  
* @Title: BinomialFormulaCalculationTest.java
* @Package sxg.algorithm.test
* @Description: TODO
* @author songxingguo
* @date 2018年1月2日 上午9:54:12
*/
package sxg.algorithm.test;

import static org.junit.Assert.fail;

import org.junit.Test;

import sxg.algorithm.basicRecursive.BinomialFormulaCalculation;

/**
 * <p>Title: </p>
 * <p>Description: </p>	
 * @author songxinggo
 * @date 2018.01.02
 */
public class BinomialFormulaCalculationTest {

	@Test
	public void testGetBinomialForRecursive() {
		Long start = System.currentTimeMillis();
		int count = BinomialFormulaCalculation.getBinomialForRecursive(20, 15);
		System.out.println(count);
//		if (count != 6) {
//			fail("结果不正确");
//		}
		
		Long end = System.currentTimeMillis();
		System.out.println("递归算法时间："  + (end - start));
	}
	
	@Test
	public void testGetBinomialForMemorandum() {
		Long start = System.currentTimeMillis();
		int count = BinomialFormulaCalculation
				.getBinomialForMemorandum(20, 15);
		System.out.println(count);
//		if (count != 6) {
//			fail("结果不正确");
//		}
		
		Long end = System.currentTimeMillis();
		System.out.println("备忘录算法时间："  + (end - start));
	}
	
	@Test
	public void testGetBinomialForIterate() {
		Long start = System.currentTimeMillis();
		
		int count = BinomialFormulaCalculation
				.getBinomialForIterate(20, 15);
		System.out.println(count);
//		if (count != 10) {
//			fail("结果不正确");
//		}
		
		Long end = System.currentTimeMillis();
		System.out.println("迭代算法时间："  + (end - start));
	}
}
