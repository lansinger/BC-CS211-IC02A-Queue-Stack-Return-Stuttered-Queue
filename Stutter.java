import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Stutter{

    public static void main(String args[]){

        Queue<Integer> q = new LinkedList<Integer>();
        q.add(1);
        q.add(2);
        q.add(3);

        System.out.println("");
        System.out.println("Queue 'q' before stutter() is (front <- " + q.toString() + " <- back)"); // [front <- 1, 2, 3 <- back]
        System.out.println("");
        
        Queue<Integer> stuttered = new LinkedList<Integer>(stutter(q));
        System.out.println("");
        System.out.println("Queue 'q' after stutter() is (front <- " + stuttered.toString() + " <-back)");
        System.out.println("");
        

    }

    //replaces every element of the queue input with two copies of that element
    public static Queue<Integer> stutter(Queue<Integer> q){   
        Queue<Integer> copy = new LinkedList<Integer>(q); // [front <- 1, 2, 3 <- back]
        System.out.println("Queue passed into stutter() is now Queue 'copy': (front <- " + copy.toString() + " <- back");

        Stack<Integer> stuttered = new Stack<Integer>();
        Stack<Integer> backup = new Stack<Integer>();
                
        while (!copy.isEmpty()){  // [top <- 3, 3, 2, 2, 1, 1 || bottom]
            int element = copy.peek();
            stuttered.push(element);
            stuttered.push(copy.remove());
        }
        System.out.println("Stack 'stuttered' is: (bottom | " + stuttered + " | top ->)"); 
                            // prints first-in / bottom to top [1, 1, 2, 2, 3, 3]

        while (!stuttered.isEmpty()){ // [top <- 1, 1, 2, 2, 3, 3 || bottom ]
            backup.push(stuttered.pop());
        }
        System.out.println("Stack 'backup' is: (bottom | " + backup + " | top ->)"); 
                            // prints first-in / bottom to top [3, 3, 2, 2, 1, 1]

        while (!backup.isEmpty()){  // converts back to Queue object            
            copy.add(backup.pop()); // [front <- 1, 1, 2, 2, 3, 3 <- back]
        }
        System.out.println("Queue 'copy' is now: (front <- " + copy.toString() + " <- back)");

        return copy;        
    }
}