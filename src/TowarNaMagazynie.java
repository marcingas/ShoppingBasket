public class TowarNaMagazynie implements Comparable<TowarNaMagazynie> {
    private final String name;
    private double price;
    private int iloscNaMagazynie;

    public TowarNaMagazynie(String name, double price) {
        this.name = name;
        this.price = price;
        this.iloscNaMagazynie = 0;
    }

    public TowarNaMagazynie(String name, double price, int iloscMagazynowana) {
        this.name = name;
        this.price = price;
        this.iloscNaMagazynie = iloscMagazynowana;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int IloscNaMagazynie() {
        return iloscNaMagazynie;
    }

    public void setPrice(double price) {
        if(price>0.0){
            this.price = price;
        }
    }
    public void KoretkaIlMagazyn(int quantity){
        int newQuantity = this.iloscNaMagazynie + quantity;
        if(newQuantity>=0){
            this.iloscNaMagazynie = newQuantity;
        }
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("Entering StockItems equals");
        if(obj == this){
            return true;
        }
        if(obj== null || (obj.getClass()!= this.getClass())){
            return false;
        }
        String objName = ((TowarNaMagazynie)obj).getName();
        return this.name.equals(objName);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode()+ 21;
    }

    @Override
    public int compareTo(TowarNaMagazynie towar) {
        System.out.println("Entering StockItem.compareTo");
        if(this == towar){
            return 0;
        }
        if(towar != null){
            return this.name.compareTo(towar.getName());
        }
        throw new NullPointerException();
    }

    @Override
    public String toString() {
        return this.name + " : price " + this.price;
    }
}
