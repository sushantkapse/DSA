public class Stocks {
 public static void main(String[] args) {
    int price[] = {7,10,5,3,6,8};
    StockProfit(price);
}  
public static void StockProfit(int arr[]){
    
    int buyPrice=Integer.MAX_VALUE;
    int profit=0;
    int maxprofit = 0;
    for (int i = 0; i < arr.length; i++) {
        if(buyPrice < arr[i]){
            profit = arr[i]-buyPrice; 
            maxprofit = Math.max(maxprofit, profit);
        }
        else{
            buyPrice = arr[i];
        }
    }
    System.out.println("Maximum profit is : " + maxprofit);
 } 
}
