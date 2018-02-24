/**
 * Copyright (C), 2015-2018, 苏宁金融集团
 * Author: TangBin 17082720
 * FileName: BestTimeToBuyAndSellStockII
 * Date: 2018/2/24 15:14
 * Description:
 */

/**
 * @author: TangBin 17082720 
 * @Email: 17082720@cnsuning.com
 * @create: 2018/2/24 15:14
 * @since 1.0.0
 * @description: 〈Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

〉
 */
public class NO122_BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        if(prices.length == 0)
            return 0;

        int buyPrice = prices[0];
        int sellPrice = prices[0];
        int profit = 0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>=prices[i-1]){
                sellPrice = prices[i];
            }else{
                profit += sellPrice-buyPrice;
                buyPrice = prices[i];
                sellPrice=prices[i];
            }
        }
        if(sellPrice>buyPrice)
            profit += sellPrice-buyPrice;
        return profit;
    }

    public static void main(String[] args){
        int[] prices = {1, 0, 2, 3, 2, 0, 3};
        NO122_BestTimeToBuyAndSellStockII bestTime = new NO122_BestTimeToBuyAndSellStockII();
        System.out.println(bestTime.maxProfit(prices));
    }
}
