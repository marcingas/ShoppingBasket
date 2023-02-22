import java.util.Map;

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
        temp = new StockItem("cup", 0.45,10);
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
        for(String s : stockList.Items().keySet()){
            System.out.println(s);
        }
        Basket marcinsBasket = new Basket("Marcin");
        sellItem(marcinsBasket,"carToy",2);
        System.out.println(marcinsBasket);

        sellItem(marcinsBasket,"cup",45);
        System.out.println(marcinsBasket);
        sellItem(marcinsBasket,"carToy",198);
        sellItem(marcinsBasket,"spanner", 5);
        System.out.println(marcinsBasket);
        sellItem(marcinsBasket,"carToy", 1);
        sellItem(marcinsBasket,"juice", 4);
        sellItem(marcinsBasket, "bread",1);
        System.out.println("My basket is : " + marcinsBasket);
        System.out.println("Stock list after I bought stuff is: ");
        System.out.println(stockList);
        stockList.Items().get("carToy").adjustStock(2000);
        stockList.get("carToy").adjustStock(-1000);
        System.out.println("new ist is " + stockList);

        for(Map.Entry<String, Double>price: stockList.PriceList().entrySet()){
            System.out.println(price.getKey() + " costs " + price.getValue());
        }




    }
    public static int sellItem(Basket basket, String item, int quantity){
        StockItem stockItem = stockList.get(item);
        if(stockItem == null){
            System.out.println("We don't sell " + item);
            return 0;
        }
        if(stockList.reserveStock(item,quantity) != 0){
            return basket.addToBasket(stockItem,quantity);
        }
        return 0;
    }
    public static int removeItem(Basket basket, String item, int quantity){
        StockItem stockItem = stockList.get(item);
        if(stockItem == null){
            System.out.println("We don't sell " + item);
            return 0;
        }
        if(basket.removeFromBasket(stockItem,quantity) == quantity){
            return stockList.unreserveStock(item, quantity);
        }
        return 0;
    }

    public static void checkOut(Basket basket){
        for(Map.Entry<StockItem,Integer>item : basket.Items().entrySet()){
            stockList.sellStock(item.getKey().getName(), item.getValue());
        }
        basket.clearBasket();
    }
}