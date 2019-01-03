package BestTimeToBuyAndSellStock;

public class Solution {
    public static void main(String[] args) {
        int[] thePrices = {7,1,5,3,6};
        System.out.println(maxProfit(thePrices));
    }

    public static int maxProfit(int[] prices) {

        Integer theMaxProfit = 0;
        Integer theMinPrice = null;

        for (int i = 0; i < prices.length; i++) {
            if (theMinPrice == null || prices[i] < theMinPrice) {
                theMinPrice = prices[i];
            }
            if (prices[i] - theMinPrice > theMaxProfit) {
                theMaxProfit = prices[i] - theMinPrice;
            }
        }

        return (theMaxProfit > 0 ? theMaxProfit : 0);
    }

}
