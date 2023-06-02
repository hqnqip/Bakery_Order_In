public class Food
{
    //Instance Variables
    protected String name;
    protected double price;


    //Constructor
    public Food (String name, double price)
    {
        this.name = name;
        this.price = price;
    }//End Constructor.


    //Setters
    public void setName(String newName)
    {
        name = newName;
    }//End setName().
    public void setPrice(double newPrice)
    {
        price = newPrice;
    }//End setPrice().


    //Getters
    public String getName()
    {
        return name;
    }//End getName().
    public double getPrice()
    {
        return price;
    }//End getPrice().


    //Brain
    //Purpose: Create code names for the user to use when they want to display
    //their status as a reward member.
    public String codeName()
    {
        int space = name.indexOf(" ");
        int length = name.length();

        //Function: If the full name is long, this creates a code name, starting with the
        //first letter. Based on whether there is a space, the remaining part is added.
        if (length <= 5)
            return name;
        else if (space != -1)
            return name.substring(0, 1) + "-" + name.substring(space + 1);
        else
            return name.substring(0, 1) + "-" + name.substring(length - 3);
    }//End codeName().


    //Purpose: Acts as a random event that affects the outcome.
    //Function: The int variable, num, is used with Math.random() to create a random integer from 0 to 4.
    public void dropFood()
    {
        System.out.println("A waiter is holding a plate full of dishes on one hand...");

        int num = (int) (Math.random() * 5);
        if (num == 0)
        {
            System.out.println("CRASH! Uh oh! Your order dropped! You'll be compensated.");
            Bakery.bill = 0;
        }
        else
            System.out.println("Phew! Nothing fell.");
    }


    //toString
    public String toString()
    {
        String output = "Name: " + name +
                        "\nPrice: $" + price;
        return output;
    }

}//End Class.