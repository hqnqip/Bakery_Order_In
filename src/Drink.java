//Drink = Subclass. Food = Superclass.
public class Drink extends Food
{
    //Instance Variables
    protected int ounces;
    //^^ Used protected static to access from Bakery class.


    //Constructor
    public Drink (String name, double price, int ounces)
    {
        super(name, price);
        this.ounces = ounces;
    }//End constructor.


    //Setter
    public void setOunces(int num)
    {
        ounces = num;
    }//End setOunces().


    //Getter
    public int getOunces()
    {
        return ounces;
    }//End getOunces().


    //Brain Methods
    //Purpose: Allow the user to make changes in number of same drinks.
    //Function: Asks user for number of ounces. Based on input, the number
    //of cups needed changes.
    public String setSize(int num)
    {
        if (num > 8 && num <= 16)
        {
            this.setOunces(16);
            return "That's a 16 fl oz. large for you.";
        }
        else if (num > 16)
        {
            int cups = num / 16;
            int over = num % 16;

            if (over != 0)
                cups++;

            price = price * cups;
            return "Woah, woah! That's too much.. We may need " + cups + " cups..";
        }
        else
            return "Okay, a small drink.";
    }//End setSize().


    @Override
    //Purpose: Random event for when the waiter drops the drinks;
    //Overrides dropFood() from Food.java.
    public void dropFood()
    {
        System.out.println("A waiter is holding a tray full of glass drinks on one hand...");

        int num = (int) (Math.random() * 9);
        if (num == 0)
        {
            System.out.println("SHATTERS! Your drink fell with no grace whatsoever. You'll be compensated! ｡ﾟ( ﾟஇ‸இﾟ)ﾟ｡");
            Bakery.bill = 0;
        }
        else if (num == 2)
            System.out.println("The drinks wobbled wobbled, but only a bit spilled over. 且_(ﾟ◇ﾟ；)ノﾞ");
        else
            System.out.println("Phew! Nothing happened. ( ˘▽˘)っ♨");
    }//End dropFood().


    //toString
    @Override
    public String toString()
    {
        String output = super.toString() +
                "\nOunces: " + ounces;
        return output;
    }//End toString().

}//End Class.