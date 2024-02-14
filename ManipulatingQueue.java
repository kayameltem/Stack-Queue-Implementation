import java.util.ArrayList;

public class ManipulatingQueue {
    private static Queue queue ;

    public ManipulatingQueue(String[] elements) {
        queue = new Queue();
        for (String s : elements) {
            queue.enqueue(Integer.valueOf(s));
        }
    }    
    public String removeGreater(int i) {
        // removes all the numbers greater than i.
        Queue dummy = new Queue();
        while (! queue.isEmpty()) {
            if (queue.peek() > i) {
                queue.dequeue();
                continue;
            }
            dummy.enqueue(queue.dequeue());
            }
            queue = dummy;
            return queue.display();
        
        }
        
    public String calculateDistance() {
        // calculates difference between all the data.
        Queue copy = new Queue();
        Queue dummy = new Queue();
        while(!queue.isEmpty()) {
            copy.enqueue(queue.peek());
            dummy.enqueue(queue.dequeue());
        
        }
        while (! dummy.isEmpty()) {
            queue.enqueue(dummy.dequeue());     
        }
        int total = 0;
        while (!copy.isEmpty()) {
        dummy = new Queue();
        int i = copy.dequeue() ;
        while (! copy.isEmpty()) {
            total+= Math.abs(i - copy.peek());
            dummy.enqueue(copy.dequeue());
        }
        copy = dummy;
        }
        return Integer.toString(total);
    }
    public String addOrRemove(int number) {
        /* if number is negative, removes number times data.
        if number is positive, adds number times random data which 
        is between 0-50.
        */
    if (number > 0){
        while (number > 0){
        queue.enqueue((int)(Math.random() * 50)); 
        number--;
        }
    }
    else if (number < 0) {
            while(number < 0)
                if (!queue.isEmpty()) {
                queue.dequeue();
                number++; }
            }
    return queue.display();
    }
    public String reverse(int number) {
        // reverse first numberth data from head of the queue .
        ArrayList<Integer> liste = new ArrayList<Integer>();
        while (! queue.isEmpty()) {
            liste.add(queue.dequeue());         
        }
        while(number > 0) {
            queue.enqueue(liste.remove(number-1));
            number--;
            
    }
        while (! liste.isEmpty()) {
            queue.enqueue(liste.remove(0));        
        }
        return queue.display();
    }
    public String sortElements() {
    // sorts all the queue.
    Queue sorted = new Queue();
    while (! queue.isEmpty()) {
    Queue dummy = new Queue();
    int min = queue.dequeue();
    while(! queue.isEmpty()) {
        if (queue.peek() < min ) {
            dummy.enqueue(min);
            min = queue.dequeue();                    
        }
        else {
            dummy.enqueue(queue.dequeue());
        
        }
    }
        sorted.enqueue(min);
        queue = dummy;
    }
    queue = sorted;
    return queue.display();
    }
    public String distinctElements() {
        // finds number of distinct elements.
        Queue copy = new Queue();
        Queue dummy = new Queue();
        while(!queue.isEmpty()) {
            copy.enqueue(queue.peek());
            dummy.enqueue(queue.dequeue());
        
        }
        while (! copy.isEmpty()) {
            queue.enqueue(copy.dequeue());      
        }
        sortElements();
        int distinct = queue.dequeue();
        int total = 1;
        while (! queue.isEmpty()) {
            if (queue.peek() != distinct) {
                total +=1 ;
                distinct = queue.peek();
            }
            queue.dequeue();
            
            }
        queue = dummy;
        return Integer.toString(total);
        }

    public static Queue getQueue() {
        return queue;
    }
           
}