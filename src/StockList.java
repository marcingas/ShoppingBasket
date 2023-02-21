import java.util.HashMap;
import java.util.Map;

public class StockList {
    private final Map<String,StockItem> list;
    public StockList(){
        this.list = new HashMap<>();
    }
    public int addStock(StockItem item){
        if(item != null){
            StockItem inStock = list.getOrDefault(item.getName(),item);
            //check if already have quantities of this item, adjust the quantity:
            if(inStock != item){
                item.adjustStock(inStock.getQuantityStock());
            }
            list.put(item.getName(), item);
            return item.getQuantityStock();
        }
        return 0;
    }




}
