public class Main {

    private static ListaMagazynowa listaMagazynowa = new ListaMagazynowa();
    public static void main(String[] args) {
        TowarNaMagazynie temp = new TowarNaMagazynie("bread", 0.86, 100);
        listaMagazynowa.dodajDoMagazynu(temp);
        temp = new TowarNaMagazynie("cake", 1.10,70);
        listaMagazynowa.dodajDoMagazynu(temp);
        temp = new TowarNaMagazynie("carToy", 12.10,200);
        listaMagazynowa.dodajDoMagazynu(temp);
        temp = new TowarNaMagazynie("chair", 62.0,10);
        listaMagazynowa.dodajDoMagazynu(temp);
        temp = new TowarNaMagazynie("cup", 0.50,200);
        listaMagazynowa.dodajDoMagazynu(temp);
        temp = new TowarNaMagazynie("cup", 0.45,10);
        listaMagazynowa.dodajDoMagazynu(temp);
        temp = new TowarNaMagazynie("door", 72.95,40);
        listaMagazynowa.dodajDoMagazynu(temp);
        temp = new TowarNaMagazynie("juice", 2.50,40);
        listaMagazynowa.dodajDoMagazynu(temp);
        temp = new TowarNaMagazynie("phone", 94.0,30);
        listaMagazynowa.dodajDoMagazynu(temp);
        temp = new TowarNaMagazynie("towel", 1.43,50);
        listaMagazynowa.dodajDoMagazynu(temp);
        temp = new TowarNaMagazynie("vase", 9.99,70);
        listaMagazynowa.dodajDoMagazynu(temp);
        System.out.println(listaMagazynowa);
        for(String s : listaMagazynowa.Towary().keySet()){
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
        System.out.println(listaMagazynowa);

        temp = new TowarNaMagazynie("pen",1.12);
        listaMagazynowa.Towary().put(temp.getName(), temp);





    }
    public static int sellItem(Basket basket, String item, int quantity){
        TowarNaMagazynie towarNaMagazynie = listaMagazynowa.get(item);
        if(towarNaMagazynie == null){
            System.out.println("We don't sell " + item);
            return 0;
        }
        if(listaMagazynowa.sprzedajTowar(item,quantity) != 0){
            basket.dodajDoKoszyka(towarNaMagazynie,quantity);
            return quantity;
        }
        return 0;
    }
}