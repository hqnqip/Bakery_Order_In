import java.util.Scanner;

public class Cake extends Food
{
    //Instance Variables
    private int slices;


    //Constructor
    public Cake (String name, double price, int slices)
    {
        super(name, price);
        this.slices = slices;
    }//End Constructor.

    //Overloaded Constructor
    public Cake (String name, double price)
    {
        super(name, price);
        int ran = (int) (Math.random() * 9);
        slices = ran;
    }//End Constructor.


    //Setter
    public void setSlices(int num)
    {
        slices = num;
    }//End setSlices().


    //Getter
    public int getSlices()
    {
        return slices;
    }//End getSlices().


    //Purpose: Checks if any slices cake are available.
    //NOTE: Have to pass the Food object, because the object does not always have type 'Cake'.
    public static String checkSlices(Food request)
    {
        String name = (Bakery.order).getName();
        String end = name.substring(name.length() - 4);

        //Function: Once there is a 'cake' in the name, the type is down-casted to Cake.
        if (end.equals("cake"))
        {
            //Function: If the cake has no slices available, the corresponding cake is removed from the ArrayList,
            //and the following is printed and the user must order a different item.
            if (( (Cake)request ).getSlices() == 0)
            {
                (Bakery.menu).remove(request);
                System.out.println("\nSorry! But we actually have no more slices left. Try something else.");
                String newOrder = (Bakery.key).nextLine();

                return Bakery.request(newOrder).toString();
            }

            //Function: Otherwise, the number of slices for the cake decreases by 1.
            int num = ( (Cake)request ).getSlices();
                ( (Cake)request ).setSlices(num--);

            return "\nOne slice of " + ( (Cake)request ).getName() + " coming up! 🥄(*ﾟ∀ﾟ* )";
        }
        return "";
    }//End checkSlices().


    //toString
    @Override
    public String toString()
    {
        String output = "Name: " + name +
                        "\nPrice per Slice: $" + price +
                        "\nSlices: " + slices;
        return output;
    }//End toString().

}//End Class.
