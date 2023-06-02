import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        //Instantiation of Objects
        ArrayList<Food> ofDay = new ArrayList<Food>();
            Cake shortcake = new Cake("strawberry shortcake", 1.99, 3);
            Food teacake = new Cake("green teacake", 2.99, 0);
            Food carrot = new Cake("carrot cake", 2.59);
            Sandwich hamCheese = new Sandwich("protein sandwich", 5.55, true, true, false);
            Food vegan = new Sandwich("veggie sandwich", 2.25, false, false, true);
            Drink coffee = new Drink("coffee", 3.99, 8);
            Food milkTea = new Drink("milk tea", 4.55, 8);

        //Add each Food object to ofDay ArrayList.
        ofDay.add(shortcake);
            ofDay.add(teacake);
            ofDay.add(carrot);
            ofDay.add(hamCheese);
            ofDay.add(vegan);
            ofDay.add(coffee);
            ofDay.add(milkTea);
        Bakery hannah = new Bakery(ofDay);

        //Action
        hannah.openBakery();
    }
}//End Class.

