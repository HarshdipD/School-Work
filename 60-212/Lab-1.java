package lab1;

import java.util.Scanner;
import java.lang.Math;

public class Lab1 {
    public static void main(String[] args) {
        
        //PART 1
        //Getting user input for the number x and y
        Scanner scan1 = new Scanner(System.in);
        System.out.println("Enter value of x: ");
        int x = scan1.nextInt();
        System.out.println("Enter value of y: ");
        int y = scan1.nextInt();
        calc(x, y);
        
        //PART 2
        //Takes the user input of a string
        Scanner scan2 = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String StrIn = scan2.nextLine();
        wordCap(StrIn);
        
        //PART 3
        //Taking user input for a string and a keyword to search in it
        Scanner scan3 = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String str = scan3.nextLine();
        System.out.println("Enter a keyword to find in the string: ");
        String kw = scan3.nextLine();
        findKeyWord(str, kw);
            
   
    }
    
    /*
    Calculates the formula
    Input: Two ints x and y
    Output: Result of the formula
    */
    /**
     * 
     * @param a
     * @param b 
     */
        public static void calc(int a, int b){
            //Performing the calculations
            double num = (double) (Math.PI * Math.pow(b, 2));
            double numerator = (double) Math.sqrt(num);
            double denominator = 2 * a;

            double answer = numerator / denominator;

            //Printing out the result
            System.out.printf("The result of the calculation is%.2f ", answer);
        }
        /*
        Capitilizes the first word of the string
        Input: String from main
        Output: capitalized first character        
        */
        public static void wordCap(String StrIn){

            //Using toLowerCase() to lowercase all the characters
            String lowercaseString = StrIn.toLowerCase();

            //Uppercasing the first character of the string
            String StrOut = lowercaseString.substring(0, 1).toUpperCase() + lowercaseString.substring(1);

            //Printing out the Capitalized string
            System.out.println(StrOut);
        }
        
        /*
        Finds if the requested keyword is in the string
        Input: String and keywords to find
        Output: Tells if the keywords is found or not
        */
        public static void findKeyWord(String str, String kw){

            //Boolean to find if keyword found or not
            boolean found = str.contains(kw);

            //Giving the result
            if(found == true){
                System.out.println("Keyword found in the string!");
            }
            else{
                System.out.println("Keyword not found.");
            }
        }
}
