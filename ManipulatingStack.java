public class ManipulatingStack {
    private static Stack stack;
    public ManipulatingStack(String[] elements) {
        stack = new Stack();
        int i = elements.length -1;
        while(i >= 0) {
            stack.push(Integer.valueOf(elements[i]));
            i--;
        }      
    }
    public String removeGreater(int i) {
        // removes all the numbers greater than i.
        Stack dummy = new Stack() ;
        while (stack.size() >= 0) {
        if (stack.peek() > i) {
        stack.pop();
        }

        else {
            dummy.push(stack.pop());
        }
        }
        while (dummy.size() >= 0) {
          stack.push(dummy.pop());
        }
         return stack.display();
    }
    public String calculateDistance() {
        // calculates difference between all the data.
        Stack stack1 = new Stack();
        Stack stack2 = new Stack();
        while(stack.size() >= 0) {
            stack1.push(stack.peek());
            stack2.push(stack.pop());
        }
        while (stack1.size() >= 0) {
            stack.push(stack1.pop());             
        }
        int total = 0;
        while (!stack2.isEmpty()) {
        stack1 = new Stack();
        int element = stack2.pop();
        while (stack2.size() >= 0) {
            total += Math.abs(stack2.peek() - element);
            stack1.push(stack2.pop()); 
        }
        stack2 = stack1;} 
        return Integer.toString(total);
    }
    public String addOrRemove(int number) {
        /* if number is negative, removes number times data.
        if number is positive, adds number times random data which 
        is between 0-50.
        */
    if (number < 0) {
        while (Math.abs(number)>0) {
            stack.pop();
            number ++;
        }
    }
    else {
        while (number >0) {
            stack.push((int)(Math.random() * 50));
            number--;

            }
        }
    return stack.display();

    }
    public String reverse(int number) { 
        // reverse first numberth data from top of the stack .
     Stack dummy = new Stack() ;
     Stack reversed = new Stack();
     while (number>0) {
         reversed.push(stack.pop());
         number--;
     }
    while ( !reversed.isEmpty()) {
        
        dummy.push(reversed.pop());
     }
     while (dummy.size() >= 0) {
         stack.push(dummy.pop());
    }
     
     return stack.display();
    }
    public String sortElements() {
        // sorts all the stack.
            
    Stack sorted = new Stack();
    int size = stack.size();
    while (size >= 0) {
        Stack dummy = new Stack();
    int max = stack.pop();
    while (stack.size() >=0){
        if (stack.peek() <= max) {
            dummy.push(stack.pop());
        }
        else {
            dummy.push(max);
            max = stack.pop();       
        }
    } sorted.push(max);
    stack = dummy;
    size-- ;
    }
    stack = sorted;
    return stack.display();
    }
    
    public String distinctElements() {
        // finds number of distinct elements.
        Stack stack1 = new Stack();
        Stack stack2 = new Stack();
        while(stack.size() >= 0) {
            stack1.push(stack.peek());
            stack2.push(stack.pop());
        }
        while (stack1.size() >= 0) {
            stack.push(stack1.pop());             
        }
        sortElements();
        int distinct = stack.pop();
        int total = 1;
        while (! stack.isEmpty()) {
            if (stack.peek() != distinct) {
                total +=1 ;
                distinct = stack.peek();
            }
            stack.pop();
            
            }
        while (! stack2.isEmpty()) {
            stack.push(stack2.pop());
            
        }
        return Integer.toString(total);
    }

    public static Stack getStack() {
        return stack;
    }
}