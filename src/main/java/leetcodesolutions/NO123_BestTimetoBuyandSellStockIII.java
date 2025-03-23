package leetcodesolutions; /**
 * Copyright (C), 2015-2018, 苏宁金融集团
 * Author: TangBin 17082720
 * FileName: NO123_BestTimetoBuyandSellStockIII
 * Date: 2018/2/24 16:30
 * Description:
 */

/**
 * @author: TangBin 17082720 
 * @Email: 17082720@cnsuning.com
 * @create: 2018/2/24 16:30
 * @since 1.0.0
 * @description: 〈〉
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.

 */
public class NO123_BestTimetoBuyandSellStockIII {
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
}
