//MAIN CLASS

package lab3;

public class Lab3 {

    public static void main(String[] args) 
    {
        weather w1 = new weather();
        weather w2 = new weather(1,1);
        System.out.println(w2);
        
        //If wind is severe
        if(w2.isSevere())
        {
            System.out.println("Severe!");
        }
    }   
}
