package zchange;

/**
 * @author GUOJINGYUAN487
 * @since 2018/11/26 0026
 */
public class Solution {

    public static void main(String[] str){
        System.out.println(convert("ABCDE",4));
    }

    public static String convert(String s, int numRows) {
        if(s.length() < 1 || numRows < 2){
            return s;
        }
        //除数
        int divisor = numRows+numRows-2;

        int sumLine = (s.length()/divisor) *(numRows-1) + numRows -1;
        System.out.println("多少行：" + numRows + ";     多少列：" + sumLine);
        Character[][] charAry= new Character[numRows][sumLine];
        StringBuilder newSB = new StringBuilder();

        int index = 0;
        for(;index<s.length();index++){
            Character charInd = s.charAt(index);
            //行，列
            int line,col;
            //差，余,商
            int sub,remain,quotient;
            remain = (index+divisor) % divisor;
            quotient = index / divisor;
            if(remain > numRows-1){
                sub = remain - (numRows - 1);
                line = numRows - sub -1;
                //                      -2+1
                col = quotient*(numRows -1) + sub;
            }else{
                line = remain;
                //              -2+1
                col = (numRows - 1)*quotient;
            }
            System.out.println("index: " + index + ";     charIdx: " + charInd);
            System.out.println("line:" + line + ";  col:" + col + "\n");
            charAry[line][col] = charInd;
        }

        for(int i = 0; i < numRows; i++){
            for(int j = 0; j < charAry[i].length; j++){
                if(charAry[i][j] != null){
                    newSB.append(charAry[i][j]);
                }
            }
        }

        return  newSB.toString();
    }
}
