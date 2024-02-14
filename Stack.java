public class Stack {
    private int[] stack ;
    private int top = -1;
    private final int MAX_SIZE = 100; 
    public Stack() {
        stack = new int[MAX_SIZE];
    }
    public void push(int e) {
        ++top;
        stack[top] = e;
    }
    public int pop() {
        --top;
    return stack[top+1];
    }
    public int peek() {
       return stack[top];    
    }
    public int size() {
        return top;   
    }
    public boolean isEmpty() {
        return top < 0; 
    } 
    public String display() {
        int copy = top;
        String s = "";
        while (copy >= 0) {
            s = s.concat(stack[copy] + " ");
            copy--;
        }
        return s;
    }
}