import java.util.*;

public abstract class item
{   
    protected int item_id;
    protected static int counter = 0;
    protected double price;
    protected int quantity;

    public abstract String Displayed();
    abstract public void Purchased(int q);

    /**
     * Default constructor item()
     */
    public item()
    {
        price = 0.0;
        quantity = 1;
    }
    
    /**
     * Overloaded constructor item()
     * @param price price of the item
     * @param quantity quantity of the item
     */
    public item(double price, int quantity)
    {
        this.item_id = ++counter;
        setPrice(price);
        setQtty(quantity);
    }
    
    /**
     * 
     * @param price price of the item
     */
    private void setPrice(double price)
    {
        if(price >= 0)
            this.price = price;
    }
    
    /**
     * 
     * @param qtty quantity of the item
     */
    private void setQtty(int qtty)
    {
        if(qtty > 0)
            this.quantity = qtty;
    }
    
    /**
     * 
     * @return price of the item
     */
    public double getPrice()
    {
        return this.price;
    }

    public int getItem_id()
    {
        return item_id;
    }

    /**
     * 
     * @return quantity of the item
     */
    public int getQtty()
    {
        return this.quantity;
    }
}
