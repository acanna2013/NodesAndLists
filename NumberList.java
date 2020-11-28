/**
 * Complete the methods sumOfXthNodes and
 * doubleThisNode.  If you finish early,
 * write two other methods that accomplish
 * the same thing but as static methods.
 *
 */
public class NumberList {
	private ListNode front;

	public NumberList() {
		front = null;
	}

	public NumberList(ListNode sentIn) {
		front = sentIn;
	}

	public void addToFront(ListNode sentIn) {
		ListNode temp = new ListNode(sentIn.getValue(), front);
		front = temp;
	}

	public void addToEnd(ListNode sentIn) {
		ListNode temp = front;
		while (temp.getNext() != null) {
			temp = temp.getNext();
		}
		temp.setNext(new ListNode(sentIn.getValue(), null));
	}

	public static void print(ListNode list) {
		while (list != null) {
			if (list.getNext() == null)
				System.out.print(list.getValue());
			else
				System.out.print(list.getValue() + ", ");
			list = list.getNext();
		}
		System.out.println();
	}


// Returns the sum value of all the Xth nodes in the list
// (remember, these are sent in as Strings)
	public int sumOfXthNodes(int x) {
		int count = 1;
		int sum = 0;
		
		ListNode temp = front;
		while (temp.getNext() != null) {
			while (count < x) {
				count++;
				temp = temp.getNext();
			}
			if (temp!=null)
				sum += Integer.parseInt((String)temp.getValue());
			count = 0;
		}
		return sum;
	}
	
// Looks for a node containing a value sent in as a parameter - 
// If it finds it, it creates a duplicate node right after it -
// If the value isn't found, the list is not changed
	public void doubleThisNode(Comparable obj) {
		ListNode temp = front;
		while (temp != null)
		{
			if (temp.getValue().toString().equals(obj.toString())) {
				temp.setNext(new ListNode(temp.getValue(), temp.getNext()));
				return;
			}
			temp = temp.getNext();
		}
	}
	
	public static void main(String[] args) {
		
		
		ListNode c = new ListNode("2", new ListNode("1", new ListNode("5", new ListNode("9", new ListNode("20",new ListNode("30",null))))));
		NumberList one = new NumberList(c);
		
		System.out.print("Original: ");
		print(one.front);
		System.out.println("Sum of every 2nd  (40 expected): " + one.sumOfXthNodes(2));
		System.out.println("Sum of every 3rd  (35 expected): " + one.sumOfXthNodes(3));
		
		ListNode e = new ListNode("2", new ListNode("1", new ListNode("5", new ListNode("9", new ListNode("20",new ListNode("30",null))))));
		NumberList three = new NumberList(e);
		System.out.print("Original: ");
		print(three.front);
		three.doubleThisNode(5);
		System.out.println("\nCalling doubleThisNode(5) - (2, 1, 5, 5, 9, 20, 30 expected):");
		print(three.front);
	}
}



/*
 *!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 *NUMBERLIST WITH STATIC METHODS
 *
 *
 *	private static ListNode front;

	public NumberList() {
		front = null;
	}

	public NumberList(ListNode sentIn) {
		front = sentIn;
	}

	public void addToFront(ListNode sentIn) {
		ListNode temp = new ListNode(sentIn.getValue(), front);
		front = temp;
	}

	public void addToEnd(ListNode sentIn) {
		ListNode temp = front;
		while (temp.getNext() != null) {
			temp = temp.getNext();
		}
		temp.setNext(new ListNode(sentIn.getValue(), null));
	}

	public static void print(ListNode list) {
		while (list != null) {
			if (list.getNext() == null)
				System.out.print(list.getValue());
			else
				System.out.print(list.getValue() + ", ");
			list = list.getNext();
		}
		System.out.println();
	}

	public static int sumOfXthNodes(int x) {
		int count = 1;
		int sum = 0;
		
		ListNode temp = front;
		while (temp.getNext() != null) {
			while (count < x) {
				count++;
				temp = temp.getNext();
			}
			if (temp != null)
				sum += Integer.parseInt(temp.getValue().toString());
			count = 0;
		}
		return sum;
	}
	
	public static void doubleThisNode(Comparable obj) {
		ListNode temp = front;
		
		while (temp != null)
		{
			if (temp.getValue().toString().compareTo(obj.toString()) == 0) {
				temp.setNext(new ListNode(obj, temp.getNext()));
				return;
			}
			temp = temp.getNext();
		}
	}
 *
 *
*/