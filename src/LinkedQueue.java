// This class implements a queue using a linked list
// It requires the LinkedNode class to be defined
public class LinkedQueue {

	LinkedNode front;
	LinkedNode rear;
	int count;
	
	LinkedQueue() {
		front = rear = null;
		count = 0;
	}
	
	void enqueue(int x) {
		LinkedNode newNode = new LinkedNode(x);
		if (rear!=null)			
			rear.next = newNode;
		else 
			front = newNode;
		rear = newNode;
		count++;
	}
	
	int dequeue() {
		if (front==null) {
			return -1;
		}
		
		if (front!=rear) {
			int x = front.x;
			front = front.next;		
			count--;
			return x;
		} else {
			int x = front.x;
			front = null;
			rear = null;
			count --;
			return x;
		}
	}
	
	int first() {
		return front.x;
	}
	
	boolean isEmpty() {
		return count==0;
	}
	
	int size() {
		return count;
	}
	
	//This method will remove the middle int value in the the LinkedQueue (For even sized LinkedQueues, the middle value is rounded down)
	//It does so by dequeuing the top values of the LinkedQueue to a temporary queue, until it reaches the halfway point of the original
	//It then dequeues the integer at the halfway point, and then dequeues the rest of the remaining values in the original to the temporary LinkedQueue
	//Finally it dequeues all of the ints in the temporary LinkedQueue back to the original, leaving it the same minus it's middle value
	void removeMiddle() {
		
		LinkedQueue tempQueue = new LinkedQueue();
		
		int half = size()/2;
		
		while (size() -1 > half) {
			tempQueue.enqueue(dequeue());
		}
		
		dequeue();
		
		while(size() > 0) {
			tempQueue.enqueue(dequeue());
		}

		while(tempQueue.size() > 0) {
			enqueue(tempQueue.dequeue());
		}
	}
}
