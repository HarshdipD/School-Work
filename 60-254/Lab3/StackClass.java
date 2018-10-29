public class stackClass {

    private int MAX = 10;
    private int top = -1;
    private char[] a = new char[MAX];

    /**
     * Pushes an element in stack
     * @param s the string that is pushed
     */
    public void push(char s)
    {
        if(!isFull())
        {
            top++;
            a[top] = s;
        }
        else
            System.out.println("Stack is already full lol");
    }


    /**
     * Pops an element from the stack
     * @return the element that is popped
     */
    public char pop()
    {
        if(!isEmpty())
        {
            top--;

        }
        else
            System.out.println("Stack underflow error");

        return a[top + 1];
    }

    /**
     * Method to get the size of stack
     * @return top+1, that is size of stack
     */
    public int size()
    {
        return top + 1;
    }

    /**
     * Displays the stack
     */
    public void  Display()
    {
        for(int i = top; i >= 0; i--)
        {
            System.out.printf("%s  ", a[i]);
        }
    }

    /**
     * Boolean method to check if the stack is empty or not
     * @return boolean
     */
    public boolean isEmpty()
    {
        if(top > -1)
        {
            return false;
        }
        else
            return true;
    }

    /**
     * Boolean method to check if the stack is full or not
     * @return boolean
     */
    public boolean isFull()
    {
        if(top == 9)
        {
            return true;
        }
        else
            return false;
    }
}
