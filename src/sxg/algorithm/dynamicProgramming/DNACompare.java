/**  
* @Title: DNASequence.java
* @Package sxg.algorithm.dynamicProgramming
* @Description: TODO
* @author songxingguo
* @date 2018年1月4日 下午3:32:09
*/
package sxg.algorithm.dynamicProgramming;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * @author songxinggo
 * @date 2018.01.04
 */
public class DNACompare {
	
    String DNA1;
    String DNA2;
    public int[][] arrayCourse;
    public String SDNA1;//变更后的DNA1
    public String SDNA2;//变更后的DNA2

    public DNACompare(String DNA1, String DNA2) {
        this.DNA1 = DNA1;
        this.DNA2 = DNA2;
        arrayCourse = new int[DNA1.length() + 1][DNA2.length() + 1];
        fillArrayCourse();
        loadDNA();
    }

    /**
     * 
     * @Title: getCourse
     * @Description: 两个单DNA（其中一个可为空格"_"）比较得到的的分数
     * @param: @param DNA1
     * @param: @param DNA2
     * @param: @return
     * @return: int   
     * @throws
     */
    public static int getCourse(String DNA1, String DNA2)
    {
        if (DNA1.equals(DNA2))
            return 5;
        else if ((DNA1.equals("A") && DNA2.equals("C")) || (DNA1.equals("C") && DNA2.equals("A")))//A
            return -1;
        else if ((DNA1.equals("A") && DNA2.equals("G")) || (DNA1.equals("G") && DNA2.equals("A")))
            return -2;
        else if ((DNA1.equals("A") && DNA2.equals("T")) || (DNA1.equals("T") && DNA2.equals("A")))
            return -1;
        else if ((DNA1.equals("A") && DNA2.equals("_")) || (DNA1.equals("_") && DNA2.equals("A")))
            return -3;
        else if ((DNA1.equals("C") && DNA2.equals("G")) || (DNA1.equals("G") && DNA2.equals("C")))//C
            return -3;
        else if ((DNA1.equals("C") && DNA2.equals("T")) || (DNA1.equals("T") && DNA2.equals("C")))
            return -2;
        else if ((DNA1.equals("C") && DNA2.equals("_")) || (DNA1.equals("_") && DNA2.equals("C")))
            return -4;
        else if ((DNA1.equals("G") && DNA2.equals("T")) || (DNA1.equals("T") && DNA2.equals("G")))//G
            return -2;
        else if ((DNA1.equals("G") && DNA2.equals("_")) || (DNA1.equals("_") && DNA2.equals("G")))
            return -2;
        else if ((DNA1.equals("T") && DNA2.equals("_")) || (DNA1.equals("_") && DNA2.equals("T")))//G
            return -1;
        
        return 0;
    }

    /**
     * 
     * @Title: fillArrayCourse
     * @Description: 填充arrayCourse表格
     * @param: 
     * @return: void   
     * @throws
     */
    public void fillArrayCourse() {
    	//确定第一列元素，第一列第i行元素等于上一行元素加上DNA1和空格的分值
        for (int i = 1; i < arrayCourse.length; i++) {
            arrayCourse[i][0] = arrayCourse[i - 1][0] + getCourse(DNA1.substring(i - 1, i), "_");
        }
  
        //确定第一行元素，第以行第i列的元素等于上一列元素加上DNA2和空格的分值
        for (int i = 1; i < arrayCourse[0].length; i++) {
            arrayCourse[0][i] = arrayCourse[0][i - 1] +  getCourse("_", DNA2.substring(i - 1, i));
        }
      
        for (int i = 1; i < arrayCourse.length; i++) {
            for (int j = 1; j < arrayCourse[0].length; j++) {
                int v1 = 0, v2 = 0, v3 = 0;
                //情况1：DNA1和"_"搭配,上一行的第j列加上DNA1和空格的分值
                v1 = arrayCourse[i - 1][j] + getCourse(DNA1.substring(i - 1, i), "_");
                //情况2：DNA1和DNA2搭配,上一行上一列的值加上DNA1和空格的分值
                v2 = arrayCourse[i - 1][j - 1] + getCourse(DNA1.substring(i - 1,i), DNA2.substring(j - 1, j));
                //情况3："_"和DNA2搭配，上一列第i行的值加上DNA2和空格的分值
                v3 = arrayCourse[i][j - 1] + getCourse("_" , DNA2.substring(j - 1, j));
                
                arrayCourse[i][j] = Math.max(Math.max(v1, v2), v3);
            }
        }
    }

    /**
     * 
     * @Title: loadDNA
     * @Description: 获取变更后的DNA1和DNA2
     * @param: 
     * @return: void   
     * @throws
     */
    private void loadDNA() {
        SDNA1 = "";
        SDNA2 = "";
        int rowIndex = arrayCourse.length - 1;//行
        int fieldIndex = arrayCourse[0].length - 1;//列
        while (rowIndex != 0 || fieldIndex != 0) {
        	//当行等于0时，SDNA1已经匹配完成，SDNA2前面的剩余基因与空格匹配
            if (rowIndex == 0) {
                for (int i = 0; i < fieldIndex; i++)
                    SDNA1 = "_" + SDNA1;//匹配后的SDNA1
                SDNA2 = DNA2.substring(0, fieldIndex) + SDNA2;//匹配后的SDNA2
                return;
            }
            
            //列为SDNA2 同行一样 
            if (fieldIndex == 0){
                for (int i = 0; i < rowIndex; i++)
                    SDNA2 = "_" + SDNA2;
                SDNA1 = DNA1.substring(0, rowIndex) + SDNA1;
                return;
            }

            int top = arrayCourse[rowIndex - 1][fieldIndex] + getCourse(DNA1.substring(rowIndex - 1, rowIndex), "_");//DNA1的最后一个基因和空格匹配
            int left = arrayCourse[rowIndex][fieldIndex - 1] + getCourse(DNA2.substring(fieldIndex - 1, fieldIndex), "_");//DNA2的最后一个基因和空格匹配
            int L = arrayCourse[rowIndex - 1][fieldIndex - 1] + getCourse(DNA1.substring(rowIndex - 1, rowIndex), DNA2.substring(fieldIndex - 1, fieldIndex));
            //DNA1的最后一个基因和DNA最后一个基因匹配
            int value = arrayCourse[rowIndex][fieldIndex];
            if (value == top) {
                SDNA1 = DNA1.substring(rowIndex - 1, rowIndex) + SDNA1;
                SDNA2 = "_" + SDNA2;
                rowIndex = rowIndex - 1;
            }
            else if (value == left) {
                SDNA1 = "_" + SDNA1;
                SDNA2 = DNA2.substring(fieldIndex - 1, fieldIndex) + SDNA2;
                fieldIndex = fieldIndex - 1;
            } else {
                SDNA1 = DNA1.substring(rowIndex - 1, rowIndex) + SDNA1;
                SDNA2 = DNA2.substring(fieldIndex - 1, fieldIndex) + SDNA2;
                rowIndex = rowIndex - 1;
                fieldIndex = fieldIndex - 1;
            }
        }
    }
    
    public int GetResult(){
    	int i = arrayCourse.length - 1;
        int j = arrayCourse[0].length - 1;
        return arrayCourse[i][j];
    }
    
    public static void main(String[] args) {
    	DNACompare c = new DNACompare("ACGT", "GCAT");
	}
}
