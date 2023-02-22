import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Basket {
    private final String name;
    private final Map<TowarNaMagazynie, Integer> list;

    public Basket(String name) {
        this.name = name;
        this.list = new TreeMap<>();
    }
    public int dodajDoKoszyka(TowarNaMagazynie towar, int ilosc){
        if((towar != null) && (ilosc > 0)){
            int wKoszyku = list.getOrDefault(towar,0);
            list.put(towar,wKoszyku + ilosc);
            return wKoszyku;
        }
        return 0;
    }
    public Map<TowarNaMagazynie, Integer> Items(){
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "\nShopping basket" + name + " contains " + list.size() + ((list.size() == 1) ? " item " : " items ") + "\n";
        double totalCost = 0.0;
        for(Map.Entry<TowarNaMagazynie,Integer>item : list.entrySet()){
            s = s + item.getKey() + ". " + item.getValue() + " purchased\n";
            totalCost += item.getKey().getPrice() * item.getValue();

        }
        return s + " Total cost " + totalCost;
    }
}
