import java.util.*;
import java.lang.*;

public class gift extends item
{
    private String label;
    private String manufacturer;
    private int gift_counter = 0;

    /**
     * Default constructor
     */
    public gift()
    {
        label = "label";
        manufacturer = "manufacturer";
    }

    /**
     * Overloaded contructor
     * @param price price of gift
     * @param quantity quantity of gift
     * @param label label of gift
     * @param man manufacturer of gift
     */
    public gift(double price, int quantity, String label, String man)
    {
        super(price, quantity);
        gift_counter++;
        setLabel(label);
        setManufacturer(man);
    }

    /**
     * copy constructor
     * @param a gift item a
     */
    public gift(gift a)
    {
        label = a.getLabel();
        manufacturer = a.getManufacturer();
    }

    /**
     * Setter setLabel()
     * @param label label of gift
     */
    public void setLabel(String label){
        this.label = label;
    }

    /**
     * Setter setManufacturer()
     * @param man manufacturer of gift
     */
    public void setManufacturer(String man)
    {
        this.manufacturer = man;
    }

    /**
     * Getter method getLabel()
     * @return
     */
    public String getLabel() {
        return this.label;
    }

    /**
     * Getter method getManufacturer()
     * @return String manufacturer name
     */
    public String getManufacturer()
    {
        return this.manufacturer;
    }

    /**
     * Displayed() method
     * @return string to print
     */
    public String Displayed() {
        return String.format("%-10s %-10s %-20s %-10.2f %-10d", getItem_id(), getLabel(), getManufacturer(), getPrice(), getQtty());
    }

    /**
     * @return void
     * This function updates the quantity of a particular instance of books.
     */
    public void Purchased(int q)
    {

        if(quantity >= q)
        {
            quantity -= q;
        }
        else
        {
            System.out.println("We only have " + quantity + " of item id " + item_id + " available.");
        }
    }
}
