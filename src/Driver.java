
public class Driver {
	public static void main(String[] agrs) {
		
		//Creates instances of the ArrayQ and LinkedQueue classes
		ArrayQ array = new ArrayQ();
		LinkedQueue link = new LinkedQueue();
		
		//Uses the enqueue method of both classes to assign numbers
		array.enqueue(1);
		array.enqueue(7);
		array.enqueue(3);
		array.enqueue(5);
		array.enqueue(9);
		array.enqueue(2);

		link.enqueue(1);
		link.enqueue(7);
		link.enqueue(3);
		link.enqueue(5);
		link.enqueue(9);
		link.enqueue(2);
		
		/*These loop dequeues out each int from the two stacks, and prints them.
		To do this, the while loop runs while the stack still has integers within it. This functions because the dequeue method removes an
		integer from the stack when it is called. This also functions on the assumption that the ArrayQ and LinkedQueue are the same size.*/
		while(array.size() > 0) {
			System.out.println("ArrayStack: " + array.dequeue() + " || LinkedStack: " + link.dequeue());
		}
		
		//Reassigns the ints to the LinkedQueue, for exercise 2.
		link.enqueue(2);
		link.enqueue(9);
		link.enqueue(1);
		link.enqueue(4);

		//Runs the removeMiddle method found within the LinkedQueue class, and then print's the values of by the Dequeue method
		link.removeMiddle();
		
		while(link.size() > 0) {
			System.out.println(link.dequeue());
		}
		
	}
}
