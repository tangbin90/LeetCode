/**
 * Copyright (C), 2015-2018, 苏宁金融集团
 * Author: TangBin 17082720
 * FileName: BestTimeToBuyAndSellStock
 * Date: 2018/2/24 14:49
 * Description:
 */

/**
 * @author: TangBin 17082720 
 * @Email: 17082720@cnsuning.com
 * @create: 2018/2/24 14:49
 * @since 1.0.0
 * @description: 〈〉
 */
public class NO121_BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if(prices.length==0)
            return 0;
        int buyPrice = prices[0];
        int profit = 0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>buyPrice){
                profit = Math.max(prices[i]-buyPrice,profit);
            }else{
                buyPrice = prices[i];
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] prices ={7,1,5,3,6,4};
        NO121_BestTimeToBuyAndSellStock best = new NO121_BestTimeToBuyAndSellStock();
        best.maxProfit(prices);
    }
}
