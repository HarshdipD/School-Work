import java.util.*;

public class Lab3 {

    public static void main(String[] args)
    {

        String a = "(9*[3*{[(3+3)/5]*7}])";
        String b = "{3 *(2+[3−[4/[6/9]]]})";
        String c = " ((3*(9−(4*(6−5))))";
        String d = "{2−{3*{6/[[[(((9−0)))]]]}}/7}";

        //Converting strings to char arrays
        char[] A = a.toCharArray();
        char[] B = b.toCharArray();
        char[] C = c.toCharArray();
        char[] D = d.toCharArray();

        //char exp[] = {'[','(','{','}',')',']'};

        if(isBalanced(D))
        {
            System.out.println("The arithmetic operation is balanced!");
        }
        else
            System.out.println("The brackets are not balanced.");

    }

    static boolean isBalanced(char a[])
    {
        stackClass st = new stackClass();

        //For each element is char[]
        for(int i = 0; i < a.length; i++)
        {
            //If it is an open bracket, push it into a stack
            if(a[i] == '{' || a[i] == '(' || a[i] == '[')
            {
                st.push(a[i]);
            }

            //If bracket is closing, check if there is a opening bracket for that in stack st or
            //if it matches the same bracket in the stack
            if(a[i] == '}' || a[i] == ')' || a[i] == ']')
            {
                if(st.isEmpty())
                {
                    return false;
                }
                else if(!isMatchingPair(st.pop(), a[i]))
                {
                    return false;
                }
            }
        }

        if(st.isEmpty())
        {
            //Balanced
            return true;
        }
        else
            //Not balanced
            return false;
    }

    static boolean isMatchingPair(char a, char b)
    {
        if(a == '(' && b == ')')
        {
            return true;
        }
        else if(a == '{' && b == '}')
        {
            return true;
        }
        else if(a == '[' && b == ']')
        {
            return true;
        }
        else
            return false;
    }
}

        /*

        *****STACK COMMANDS TO CHECK THE ADT FUNCTIONS*****

        stackClass s = new stackClass();
        s.Display();
        s.push("One");
        s.push("Two");
        s.push("Three");
        s.push("Four");
        s.push("Five");
        s.push("Six");
        s.pop();
        s.push("Two");
        s.Display();
        System.out.println(s.size());
        */
