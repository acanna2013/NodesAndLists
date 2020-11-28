public class ValueList {
	private ListNode front;

	public ValueList() {
		front = null;
	}

	public ValueList(ListNode sentIn) {
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

	/**
	 *     IMPLEMENT
	 *     THE TWO
	 *     METHODS
	 *     BELOW
	 */
	
		// Method countEm will return the number of nodes that hold
	// values between a and b, not including a or b
	
	// EXAMPLE: original list==>  1 -> 5 -> 3 -> 4 -> 7
	// after calling countEm(list, 2, 5)==>  value returned: 2 (3 and 4 are between 2 and 5)
	public static int countEm(ListNode list, Comparable a, Comparable b)
	{
		ListNode temp = list;
		int count = 0;
		while (temp != null) {
			if (temp.getValue().toString().compareTo(a.toString()) > 0 && 
					temp.getValue().toString().compareTo(b.toString()) < 0) {
				count++;
			}
			temp = temp.getNext();
		}
		return count;
	}

	// Method lessThanList() finds all the values smaller than
	// argument obj and creates / returns a new ValueList that
	// contains only those smaller values.
	// EXPECTED OUTPUT:
	// Original: 3, 5, 1, 4, 7
    // After calling lessThanList(5):
	//    (new list)  4, 1, 3   (order does not matter)
	public ValueList lessThanList(Comparable obj) {
		ListNode temp = front;
		ListNode value = new ListNode();
		
		while (temp != null) {
			if (temp.getValue().toString().compareTo(obj.toString()) < 0) {
				value.setNext(new ListNode(temp.getValue(), temp.getNext()));
				temp = temp.getNext();
			}
			temp = temp.getNext();
		}
		return new ValueList(value);
	}

	/**
	 *     RUNNERS
	 *     BELOW
	 */
	
	public static void main(String[] args) {
		// runner countEm()
		// EXPECTED OUTPUT:
		// Numbers between 2 and 5: 2
		ListNode b = new ListNode("8", new ListNode("3", new ListNode("2", new ListNode("9", new ListNode("4", null)))));
		System.out.println();
		System.out.println("Numbers between 2 and 5: " + countEm(b, "2", "5") + "\n");
		//runner lessThanList()
		// EXPECTED OUTPUT:
		// Original: 3, 5, 1, 4, 7
	    // After calling lessThanList(5):
		//           4, 1, 3   (order does not matter)
		ListNode g = new ListNode("3",
				new ListNode("5", new ListNode("1", new ListNode("4", new ListNode("7", null)))));
		ValueList lessList = new ValueList(g);
		System.out.print("Original: ");
		print(lessList.front);
		ValueList moreLess = lessList.lessThanList("5");
		System.out.println("After calling lessThanList(5):");
		System.out.print("\t  ");
		print(moreLess.front);
	}
}