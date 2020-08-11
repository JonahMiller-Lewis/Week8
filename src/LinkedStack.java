// This class implements a Stack ADT as a linked list
public class LinkedStack {
	LinkedNode front;  // Reference to the first LinkedNode in the list
	int count;         // Number of nodes in the list
	
	// Constructor - initializes the front and count variables
	LinkedStack() {
		front = null;
		count = 0;
	}
	
	// Implements the push operation
	void push(int x) {
		LinkedNode newNode = new LinkedNode(x);
    	newNode.next = front;
    	front = newNode;
    	count++;
	}
	
	// Implements the pop operation
	int pop() {
		int x = front.x;
		front = front.next;
		count--;
		return x;
	}
	
	// Implements the peek operation
	int peek() {
		return front.x;
	}
	
	// Implements the isEmpty operation
	boolean isEmpty() {
		return front==null;
	}
	
	// Implements the size operation
	int size() {
		return count;		
	}
	
	// This method returns a String containing
	// a space separated representation of the underlying linked list
	public String toString() {
		String str = "";
		
		LinkedNode cur = front;
		while (cur!=null) {
			str += cur.x + " ";
			cur = cur.next;
		}
		
		return str;
	}
	
	//This method will remove the bottom half of the LinkedStack.
	//It functions by first creating an LinkedStack which is an inverse of the original, by popping each int from the original to the inverse.
	//The top half of the inversed stack (which is the bottom half of the original) is then popped off, and the remaining ints are pushed back to the original.
	//This leaves only the top half of the original stack.
	//The time complexity of this function is O(2n), where n is the number of integers within the stack.
	void removeBottomHalf() {		

		LinkedStack inverseStack = new LinkedStack();
		
		while (size() > 0) {
			inverseStack.push(pop());
		}
		
		int half = inverseStack.size()/2;
		
		while(inverseStack.size() > half) {
			inverseStack.pop();
		}
		
		while(inverseStack.size() > 0) {
			push(inverseStack.pop());
		}

	}
	
}
