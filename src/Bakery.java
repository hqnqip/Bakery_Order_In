import java.util.ArrayList;
import java.util.Scanner;

public class Bakery
{
    //Instance Variables
    protected static ArrayList<Food> menu = new ArrayList<Food>();
            //^^ Class composition, due to the inclusion of objects of different types.
            //A 'Bakery' has 'Food'.
    protected static Scanner key = new Scanner(System.in);
    private int[][] tables = {{0, 0, 0, 1},
                              {0, 1, 0, 1},
                              {1, 1, 0, 0}};
    protected static Food order;
    protected static double bill = 0;


    //Constructor
    public Bakery(ArrayList<Food> ofDay)
    {
        //Makes a "copy" of Food references to ArrayList menu.
        for (Food i : ofDay)
        {
            menu.add(i);
        }
    }//End constructor.


    //Purpose: Acts as the main() of Bakery class, similar to Farmer class in OldMacDonald.
    public void openBakery()
    {
        //Function: Showing the table and menu to the user.
        System.out.println(this.checkTable());
        this.viewMenu();

        //Function: Checks user's request and whether it is a cake without slices.
        System.out.println("What would you like for today? (Type the order's name.)");
            String input = key.nextLine();
            System.out.println(request(input));
            System.out.println(Cake.checkSlices(order));

        //Function: Based on order type, unique methods are invoked.
        //This involves a lot of down-casting.
        //NOTE: Use 'instanceOf' in order to compare the object's type with a class.
        if (order instanceof Drink)
        {
            System.out.println("Okay. Would you like a small for 8 fl oz., or 16-fl oz. large? (Type a number of fl oz.)");
            int numPut = key.nextInt();
            System.out.println(((Drink)order).setSize(numPut));
        }
        else if (order instanceof Sandwich)
        {
            System.out.println("Is there anything in this sandwich you'd like to add or remove?");
            input = key.nextLine();

            //Using an overloaded method.
            if (input == "")
                ((Sandwich)order).changeSandwich();
            else
                ((Sandwich)order).changeSandwich(input);

            System.out.println("\nUpdating order...\n" + order.toString());
        }

        bill = order.getPrice();
            System.out.println("\nBeep.\nBeep.\nBeep.\n");
            order.dropFood();

        //Note: dropFood(), perhaps along with unique methods,
        //affects the cost the customer (user) must pay.

        //Rounding the decimal point to the hundredth's place.
        //(Referencing Mkyong.com 2021.)
        bill = Math.round(bill * 100.0) / 100.0;
        System.out.print("\nYour cost comes out to $" + bill + ".");

        if (bill != 0.0)
            System.out.println(" Thank you for visiting!");
    }//End openBakery().


    //Brain Methods
    //Purpose: Finds an available table in the 2D array.
    public String checkTable()
    {
        System.out.println("Welcome!\n");

        //Nested For-Loop.
        for (int i = 0; i < tables.length; i++)
        {
            for (int j = 0; i < tables[i].length; j++)
            {
                //Function: Checking if there is an open table not next to a window.
                if ((tables[i][j] == 0) && (j != 0) && (j != tables[i].length - 1))
                {
                    tables[i][j] = 1;
                    return "Window-tables are reserved, but table " + (j + 1) +
                            " along row " + (i + 1) + " is available!";
                }//End If-State.
            }
        }//End Nested For-Loop.

        return "Sorry, all tables are occupied now.";
    }//End checkTable().


    //Purpose: Prints the menu.
    public void viewMenu()
    {
        System.out.println("Here's our menu for today!\n");

        for (Food i : menu)
        {
            System.out.println(i.toString() + "\n");
        }
    }//End viewMenu().


    //Purpose: Allows for user input to make request food.
    //Function: This method runs two loops to check between the menu and user input.
    //Once a match is found, the corresponding Food object is returned with/without
    //changes to the order cost.
    public static Food request(String blank)
    {
        //Function: The user input is lower-cased as a common factor.
        blank = blank.toLowerCase();

        for (Food i : menu)
        {
            //Function: If the user correctly typed a member code.
            if ( (i.codeName()).equals(blank) )
            {
                System.out.println("\nOh, you must be a member of our 50% off rewards program!" +
                                   "\nYou've selected...");
                order = i;
                double temp = order.getPrice();
                order.setPrice(temp / 2.0); //Cuts the price by half.
                return i;
            }
            if ( (i.getName()).equals(blank) )
            {
                System.out.println("\nYou've selected...");
                order = i;
                return i;
            }
        }

        //Function: If the user input does not match accurately at all,
        //it automatically returns a "recommended" dish (first dish in the ArrayList).
        System.out.print("\nHm.. That doesn't seem right. How about one of our top recommended?" +
                         "\nYou can't go wrong with our famous strawberry shortcake!\n");
        order = menu.get(0);
        return menu.get(0);
    }//End order().

}//End Class.