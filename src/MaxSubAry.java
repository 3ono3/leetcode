/**
 * @author GuoJingyuan
 * @date 2019/9/19
 */
public class MaxSubAry {
    public static void main(String[] args) {
        int[] tt = {7,6,4,3,1};
        int s = sumVal(tt);
    }
    private static int sumVal(int[] prices) {
        int maxProfit = 0;
        int buyDay = 0;
        int saleDay = 0;
        for (int i = 1; i < prices.length - 1; i++) {
            if (prices[i] < prices[buyDay]) {
                buyDay = i;
            } else {
                if (prices[i] > prices[i+1]) {
                    saleDay = i;
                    int subVal = prices[saleDay] - prices[buyDay];
                    maxProfit += subVal;
                    buyDay = i+1;
                }
            }
        }
        int lastIndex = prices.length - 1;
        if (prices[lastIndex] < prices[buyDay]){
            buyDay = lastIndex;
        }
        if (buyDay < lastIndex) {
            maxProfit += (prices[lastIndex] - prices[buyDay]);
        }
        return maxProfit;
    }
}
