

public class StockTrade {

  private static int getMaxProfit(int[] stockPrices) {
    // each index can be a minute or 30 min, etc but the whole array is one stock
    int maxProfit = 0;
    int comparisonCount = 0;  // should be 15 with sample data
    for(int i = 0; i < stockPrices.length - 1; i++) {
      for(int k = i + 1; k < stockPrices.length; k++) {
        comparisonCount++;
        if (stockPrices[k] - stockPrices[i] >= maxProfit) {
          maxProfit = stockPrices[k] - stockPrices[i];
          System.out.print(maxProfit + " ");
        }
      }
    }
    System.out.println("-----");
    System.out.println("comparisonCount: " + comparisonCount);
    System.out.println("-----");
    return maxProfit;

  }


  public static void main(String[] args) {
    int[] stockPricesYesterday = {10, 7, 5, 8, 11, 9};

    int maxProfit = getMaxProfit(stockPricesYesterday);
    System.out.println("Max profit is: " + maxProfit);
  }
}
