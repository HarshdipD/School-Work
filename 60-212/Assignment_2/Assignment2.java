/**
 * @author Harshdip Singh Deogan
 * Student ID: 104924628
 */
import java.util.Scanner;

public class Assignment2
{
    private static int counter = 0;
    private static int MAX_ITEM = 100;
    private static item ITEM[] = new item[MAX_ITEM]; //max 100 items can be stored

    public static void main(String[] args)
    {
        //MAIN MENU
        System.out.println("MENU: ");
        System.out.println("1. Add item to the inventory\t 2. Display all items");
        System.out.println("3. Display books\t\t\t\t 4. Display gifts");
        System.out.println("5. Delete an item by item ID\t 6. Purchase an item");
        System.out.println("To display menu again, enter 7 or enter -1 to exit.");
        
        Scanner sc = new Scanner(System.in);
        int i = 0;

        /**
         * Switch statement to carry out commands from menu
         */
        do
        {
            System.out.print("Enter command: ");
            i = sc.nextInt();
            
            switch (i)
            {
                case 1:
                {
                    System.out.println("--Add an item to inventory--");
                    System.out.print("Enter type (gift or book): ");
                    String type = sc.next();
                    GiftOrBook(type.toLowerCase());
                    break;
                }

                case 2:
                {
                    System.out.println("--Display all the items--");
                    DisplayItem();
                    break;
                }

                case 3:
                {
                    System.out.println("--Display books--");
                    DisplayBook();
                    break;
                }

                case 4:
                {
                    System.out.println("--Display gifts--");
                    DisplayGift();
                    break;
                }

                case 5:
                {
                    System.out.println("--Delete an item by item ID--");
                    System.out.print("Enter the item id to delete: ");
                    int id = sc.nextInt();//The id that the user wants to delete
                    if(isValidID(id))
                    {
                        System.out.println();
                        deleteItem(id);
                        System.out.println("Success!\n Enter command: ");
                        break;
                    }
                    System.err.println("Invalid id!");//Prints an error statement if the id is invalid
                    break;
                }

                case 6:
                {
                    System.out.println("--Purchase an item--");
                    System.out.print("Enter the item id that you want to purchase: ");
                    int id = sc.nextInt();//Standard input
                    if(!isValidID(id))//validation check on the id that was input by the user
                    {
                        System.err.println("Invalid id!");
                        break;
                    }
                    System.out.println();
                    System.out.print("Enter the quantity of item that you want to purchase: ");
                    int q = sc.nextInt();//getting the quantity that the user wants to buy
                    System.out.println();
                    purchaseItem(id, q);//invoking the function
                    break;
                }
                
                case 7:
                {
                    System.out.println("\n\nMENU: ");
                    System.out.println("1. Add item to the inventory\t 2. Display all items");
                    System.out.println("3. Display books\t\t\t\t 4.Display gifts");
                    System.out.println("5. Delete an item by item ID\t 6. Purchase an item");
                    System.out.println("Or enter -1 to exit.");
                    break;
                }

                case -1:
                {
                    System.out.println("Exiting...");
                    break;
                }
                
                default:
                {
                    if(i != -1)
                        System.err.println("Invalid command. If you want to exit, enter -1");
                    break;
                }
            }
        }while(i != -1);
        
    }
    
    /**
     * This method determines if the user wants to enter gift or book, then proceeds to adding the Item
     * @param type from main menu
     */
    private static void GiftOrBook(String type)
    {
        switch (type) {
            case "gift":
             {
                 addItemGift(type);
                 break;

            }

            case "book":
             {
                 addItemBook(type);
                 break;
             }
            default:
                 System.err.println("Invalid type! Try again.\n\n");
                 break;
        }
    }

    /**
     * Method to add item gift
     * @param type type of item (book or gift)
     */
    private static void addItemGift(String type)
    {
        System.out.println("Enter a gift...");
        Scanner sc = new Scanner(System.in);
        System.out.printf("Enter a label for the gift: ");
        String label = sc.nextLine();
        System.out.printf("Enter the manufacturer of the gift: ");
        String man = sc.nextLine();
        System.out.printf("Enter price: ");
        double price = sc.nextDouble();
        System.out.printf("Enter quantity: ");
        int qtty = sc.nextInt();

        item g = new gift(price, qtty, label, man);
        addItem(g);

    }

    /**
     * Method to add item book
     * @param type type of item (book or gift)
     */
    private static void addItemBook(String type)
    {
        System.out.println("Enter a book...");
        Scanner sc = new Scanner(System.in);
        System.out.printf("Enter author name for book: ");
        String author = sc.nextLine();
        System.out.printf("Enter title of book: ");
        String title = sc.nextLine();
        System.out.printf("Enter the year the book was published: ");
        int year = sc.nextInt();
        System.out.printf("Enter price: ");
        double price = sc.nextDouble();
        System.out.printf("Enter quantity: ");
        int qtty = sc.nextInt();

       item b = new book(price, qtty, author, title, year);
        addItem(b);

    }

    /**
     * Method to add item
     * @param i item id
     */
    private static void addItem(item i)
    {
        ITEM[counter] = i;
        counter++;
    }

    /**
     * Method to display all the items in the inventory
     */
    public static void DisplayItem()
    {
        System.out.println("\n\t Items in the inventory:\n");
        System.out.println(String.format("%-40s %-10s %-10s", "ID", "Price", "Quantity"));
        for(int i = 0; i < counter; i++)
        {
            System.out.println(ITEM[i].Displayed());
        }
    }

    /**
     * Displays all the books in the inventory
     */
    public static void DisplayBook()
    {
        book b[] = new book[MAX_ITEM];
        int k = 0;

        for(int i = 0; i < counter; i++)
        {
            if(ITEM[i] instanceof book)
                b[k++] = (book)ITEM[i];
        }

        //Sorting
        for(int i = 1; i < k; i++)
        {
            book temp = b[i];
            int j = i - 1;

            while(j >= 0 &&  b[j].getAuthor().compareToIgnoreCase(temp.getAuthor()) > 0)
            {
                b[j + 1] = b[j];
                j--;
            }
            b[j + 1]=temp;
        }

        System.out.println("\n    All of the books in the inventory\n");
        System.out.println(String.format("%-10s %-10s %-10s %-10s %-10s %-10s","ID","Title","Author","Year","Price","Quantity"));
        for(int i = 0; i < k; i++)
        {
            System.out.println(b[i].Displayed());
        }
    }

    /**
     * Displays all the gifts in the inventory
     */
    public static void DisplayGift()
    {
        gift g[] = new gift[MAX_ITEM];
        int k = 0;
        for(int i = 0; i < counter; i++)
        {
            if(ITEM[i] instanceof gift)
                g[k++] = (gift)ITEM[i];
        }

        //Sorting
        for(int i = 1; i < k; i++)
        {
            gift temp = g[i];
            int j = i-1;

            while(j>=0 && g[j].getLabel().compareToIgnoreCase(temp.getLabel()) > 0)
            {
                g[j + 1] = g[j];
                j--;
            }
            g[j+1]=temp;
        }

        System.out.println("\n    All of the gifts in the inventory\n");
        System.out.println(String.format("%-10s %-10s %-20s %-10s %-10s","ID","Label","Manufacturer","Price","Quantity"));
        for(int i = 0; i < k; i++)
        {
            System.out.println(g[i].Displayed());
        }
    }

    /**
     * Delete method to delete an item by it's ID
     * @param id item id
     */
    public static void deleteItem(int id)
    {
        int index = -1;
        for(int i = 0; i < counter; i++)
        {
            if(ITEM[i].getItem_id() == id)
                index = i;
        }
        for(int i = index; i <= counter - 1; i++)
        {
            ITEM[i] = ITEM[i + 1];
        }
        ITEM[counter] = null;
        counter--;
    }

    /**
     * Purchase method
     * @param id item id
     * @param q quantity to purchase
     */
    public static void purchaseItem(int id, int q)
    {
        int index = -1;
        for(int i = 0; i < counter; i++)
        {
            if(ITEM[i].getItem_id() == id)//We check the id of the item if equal the we goona initiate the purchase
                index = i;
        }
        ITEM[index].Purchased(q);
        if(ITEM[index].getQtty() == 0)
            deleteItem(id);
    }

    /**
     * Boolean function to see if the id is valid
     * @param id item id
     * @return
     */
    public static boolean isValidID(int id)
    {
        for(int i = 0; i < counter; i++)
        {
            if(ITEM[i].getItem_id() == id)
                return true;
        }
        return false;
    }
}
