import java.util.ArrayList;

public class Queue {
    private ArrayList<Integer> queue ; 
    
    public Queue() {
        queue = new ArrayList<Integer>();
    }
    public void enqueue(Integer e) {
        queue.add(e); 
    }
    public int dequeue() {
        return queue.remove(0); 
    }  
    public boolean isEmpty() {
        return queue.isEmpty();     
    }
    public int size() {
        return queue.size();      
    }
    public int peek() {
        return queue.get(0);     
    }
    public String display() {
        String s = "";
        for (int i : queue) {
            s = s.concat(i + " ");
        }
        return s;
    }
}