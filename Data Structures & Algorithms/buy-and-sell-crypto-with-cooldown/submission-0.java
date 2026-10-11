class Solution {
    public int maxProfit(int[] prices) {
        int hold=-prices[0];
        int sell=0;
        int cooldown=0;
        for(int i=1;i<prices.length;i++){
            int prevHold=hold;
            int prevSell=sell; 
            hold=Math.max(hold,cooldown-prices[i]);
            sell=prevHold+prices[i];
            cooldown=Math.max(prevSell,cooldown);
        }
        return Math.max(cooldown,sell);
    }
}
