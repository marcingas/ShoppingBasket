public class Main {

    private static StockList stockList = new StockList();
    public static void main(String[] args) {
        StockItem temp = new StockItem("bread", 0.86, 100);
        stockList.addStock(temp);
        temp = new StockItem("cake", 1.10,70);
        stockList.addStock(temp);
        temp = new StockItem("carToy", 12.10,200);
        stockList.addStock(temp);
        temp = new StockItem("chair", 62.0,10);
        stockList.addStock(temp);
        temp = new StockItem("cup", 0.50,200);
        stockList.addStock(temp);
        temp = new StockItem("door", 72.95,40);
        stockList.addStock(temp);
        temp = new StockItem("juice", 2.50,40);
        stockList.addStock(temp);
        temp = new StockItem("phone", 94.0,30);
        stockList.addStock(temp);
        temp = new StockItem("towel", 1.43,50);
        stockList.addStock(temp);
        temp = new StockItem("vase", 9.99,70);
        stockList.addStock(temp);
        System.out.println(stockList);




    }
}