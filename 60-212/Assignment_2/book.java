import java.util.*;

public class book extends item
{
    private String author;
    private String title;
    private int year;
    private int book_count = 0;

    /**
     * Default constructor book()
     */
    public book()
    {
        author = "author";
        title = "title";
        year = 2018;
    }

    /**
     * Overloaded constructor
     * @param price price of book
     * @param quantity quantity of book
     * @param author author of book
     * @param title title of book
     * @param year of book published
     */
    public book(double price, int quantity, String author, String title, int year)
    {
        super(price, quantity);
        ++book_count;
        setAuthor(author);
        setTitle(title);
        setYear(year);
    }

    /**
     * Copy constructor
     * @param a book item a
     */
    public book(book a)
    {
        author = a.getAuthor();
        title = a.getTitle();
        year = a.getYear();
    }

    /**
     * Setter setAuthor()
     * @param author author of book
     */
    private void setAuthor(String author)
    {
        this.author = author;
    }

    /**
     * Setter setTitle
     * @param title title of book
     */
    private void setTitle(String title)
    {
        this.title = title;
    }

    /**
     * Setter setYear()
     * @param year int year
     */
    private void setYear(int year)
    {
        if(year > 1000)
            this.year = year;
    }

    /**
     * Getter getAuthor()
     * @return String author name
     */
    public String getAuthor()
    {
        return this.author;
    }

    /**
     * Getter getTitle()
     * @return String title name
     */
    public String getTitle()
    {
        return this.title;
    }

    /**
     * Getter getYear()
     * @return int year
     */
    public int getYear()
    {
        return this.year;
    }

    /**
     * Displayed() method
     * @return string to print
     */
    public String Displayed()
    {
        return String.format("%-10s %-10s %-10s %-10s %-10.2f %-10d", getItem_id(), getTitle(), getAuthor(), getYear(), getPrice(), getQtty());
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
