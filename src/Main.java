import java.util.Map;

public class Main {

    private static StockList stockList = new StockList();
    public static void main(String[] args) {
        StockItem temp = new StockItem("bread", 0.86, 100);
        stockList.addStock(temp);
        temp = new StockItem("cake", 1.10,70);
        stockList.addStock(temp);
        temp = new StockItem("carToy", 12.10,2);
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
        sellItem(marcinsBasket,"carToy",1);



        System.out.println(marcinsBasket);
        removeItem(marcinsBasket,"cup",5);
        System.out.println(marcinsBasket);



        sellItem(marcinsBasket,"carToy",1);
        System.out.println(marcinsBasket);
        sellItem(marcinsBasket,"carToy",1);
        System.out.println(marcinsBasket);
        if(sellItem(marcinsBasket, "carToy",1) != 1){
            System.out.println("There are no more carToy's in stock");
        }

        sellItem(marcinsBasket,"cup",45);
        System.out.println(marcinsBasket);
        sellItem(marcinsBasket,"carToy",198);
        sellItem(marcinsBasket,"spanner", 5);

        sellItem(marcinsBasket,"carToy", 1);
        sellItem(marcinsBasket,"juice", 4);
        sellItem(marcinsBasket, "bread",1);

        Basket basket = new Basket("customer");
        sellItem(basket,"cup",2);
        sellItem(basket,"juice", 1);
        removeItem(basket,"cup", 1);
        System.out.println("customer's basket is: " + basket);



        removeItem(marcinsBasket,"carToy",1);
        removeItem(marcinsBasket,"cup",9);
        removeItem(marcinsBasket,"carToy",1);

        System.out.println("carToy's removed: " + removeItem(marcinsBasket, "carToy", 1));
        System.out.println(marcinsBasket);

        removeItem(marcinsBasket, "bread",1);
        removeItem(marcinsBasket, "cup",3);
        removeItem(marcinsBasket, "juice",4);
        removeItem(marcinsBasket, "cup",132);
        System.out.println(marcinsBasket);

        System.out.println("\nDisplay stock list before and after checkout");

        System.out.println(basket);
        System.out.println(stockList);
        checkOut(basket);
        System.out.println(basket);
        System.out.println(stockList);



        StockItem car = stockList.Items().get("carToy");
        if(car != null){car.adjustStock(2000);
        }
        if(car != null){
        stockList.get("carToy").adjustStock(-1000);
        }
        System.out.println("new stockList is " + stockList);

        checkOut(marcinsBasket);
        System.out.println(marcinsBasket);




    }



    //methods:
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