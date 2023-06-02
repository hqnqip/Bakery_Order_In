import java.util.Scanner;

//Sandwich = Subclass. Food = Superclass.
public class Sandwich extends Food
{
    //Instance Variables
    private boolean hasCheese;
    private boolean hasHam;
    private boolean hasLettuce;


    //Constructor
    public Sandwich(String name, double price, boolean hasCheese, boolean hasHam, boolean hasLettuce)
    {
        super(name, price);
        this.hasCheese = hasCheese;
        this.hasHam = hasHam;
        this.hasLettuce = hasLettuce;
    }//End constructor.


    //Setters
    public void setCheese(boolean trueF)
    {
        hasCheese = trueF;
    }//End setCheese().

    public void setHam(boolean trueF)
    {
        hasHam = trueF;
    }//End setHam().

    public void setLettuce(boolean trueF)
    {
        hasLettuce = trueF;
    }//End setLettuce().


    //Brain
    //Purpose: Allow for the user to make personal adjustments.
    //Function: It takes input from Bakery class. Depending on the input,
    //the method asks the user if they'd like to include this ingredient ("yes" or "no").
    public void changeSandwich(String request)
    {
        String input = "";
        if (request.equals("cheese"))
        {
            System.out.println("\nWould you want cheese?");
            input = (Bakery.key).nextLine();
            hasCheese = this.yesNo(input);
        }
        else if (request.equals("ham"))
        {
            System.out.println("\nWould you want ham?");
            input = (Bakery.key).nextLine();
            hasHam = this.yesNo(input);
        }
        else if (request.equals("lettuce"))
        {
            System.out.println("\nWould you want lettuce?");
            input = (Bakery.key).nextLine();
            hasHam = this.yesNo(input);
        }
        else
        {
            System.out.println("\nHmm, not sure what's that, but guess you might as well have everything! (っ˘ڡ˘ς)");
            hasCheese = true;
            hasHam = true;
            hasLettuce = true;
        }

        updateBill();
    }//End changeSandwich().

    //Overloaded.
    //Purpose: Only called when the user makes no input.
    public void changeSandwich()
    {
        System.out.println("Don't tell me you're only eating everything but the bread. ( •_•)");
        hasCheese = false;
        hasHam = false;
        hasLettuce = false;

        updateBill();
    }


    //Purpose: To act as helper method to prevent typing the same code for
    //cheese, ham, and lettuce in changeSandwich().
    public boolean yesNo(String request)
    {
        request = request.toLowerCase();
        if (request.equals("yes") || request.equals("y"))
            return true;
        return false;
    }//End yesNo().


    //Purpose: Based on ingredients within the sandwich, the price changes.
    //Similar to how adding a slice of tomato adds $0.29 to a burger.
    public void updateBill()
    {
        price = 2;

        if (hasCheese)
            price += 0.55;
        if (hasHam)
            price += 1.00;
        if (hasLettuce)
            price += 0.25;
    }//End updateBill().


    //toString
    @Override
    public String toString()
    {
        String output = super.toString() +
                "\nCheese: " + hasCheese +
                "\nHam: " + hasHam +
                "\nLettuce: " + hasLettuce;
        return output;
    }//End toString().

}//End Class.