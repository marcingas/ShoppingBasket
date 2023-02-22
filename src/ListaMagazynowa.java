import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class ListaMagazynowa {
    private final Map<String, TowarNaMagazynie> list;
    public ListaMagazynowa(){
        this.list = new LinkedHashMap<>();
    }
    public int dodajDoMagazynu(TowarNaMagazynie towar){
        if(towar != null){
            TowarNaMagazynie naMagazynie = list.getOrDefault(towar.getName(),towar);
            //check if already have quantities of this towar, adjust the quantity:
            if(naMagazynie != towar){
                towar.KoretkaIlMagazyn(naMagazynie.IloscNaMagazynie());
            }
            list.put(towar.getName(), towar);
            return towar.IloscNaMagazynie();
        }
        return 0;
    }
    public int sprzedajTowar(String nazwaTowaru, int ilosc){
        TowarNaMagazynie naMagazynie = list.getOrDefault(nazwaTowaru, null);
        if((naMagazynie != null) && (naMagazynie.IloscNaMagazynie() >= ilosc) && (ilosc >0)){
            naMagazynie.KoretkaIlMagazyn(-ilosc);
            return ilosc;
        }
        return 0;
    }
    public TowarNaMagazynie get(String key){
        return list.get(key);
    }
    public Map<String, TowarNaMagazynie> Towary(){
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "\nStock List\n";
        double totalCost = 0.0;
        for(Map.Entry<String, TowarNaMagazynie>item : list.entrySet()){
            TowarNaMagazynie towarNaMagazynie = item.getValue();

            double itemValue = towarNaMagazynie.getPrice() * towarNaMagazynie.IloscNaMagazynie();
            s = s + towarNaMagazynie + ". There are " + towarNaMagazynie.IloscNaMagazynie() + " in stock. Value of items: ";
            s= s + String.format("%.2f",itemValue) + "\n";
            totalCost += itemValue;
        }
        return s + " Total stock value " + totalCost;
    }
}
