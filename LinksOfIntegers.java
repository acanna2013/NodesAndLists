import java.util.LinkedList;
import java.util.ListIterator;
public class LinksOfIntegers {
	private LinkedList<Integer> list;

	public LinksOfIntegers() {
		list = new LinkedList<Integer>();
	}

	public LinksOfIntegers(int[] nums) {
		list = new LinkedList<Integer>();
		for (int i = 0; i < nums.length; i++)
		{
			list.add(nums[i]);
		}
	}

	public double getSum() {
		double sum = 0;
		ListIterator<Integer> integers = list.listIterator();
		
		while (integers.hasNext())
			sum += integers.next();
		return sum;
	}

	public double getAvg() {
		double avg = 0;
		int count = 0;
		ListIterator<Integer> integers = list.listIterator();
		
		avg = getSum();
		while (integers.hasNext()) {
			count++;
			integers.next();
		}
		return avg/count;
	}

	public int getLargest() {
		ListIterator<Integer> integers = list.listIterator();
		int largest = integers.next();
		int compare = 0;
		while (integers.hasNext()) {
			compare = integers.next();
			if (compare > largest)
				largest = compare;
		}
		return largest;
	}

	public int getSmallest() {
		ListIterator<Integer> integers = list.listIterator();
		int smallest = integers.next();
		int compare =0;
		while (integers.hasNext()) {
			compare = integers.next();
			if (compare < smallest)
				smallest = compare;
		}
		return smallest;
	}

	public String toString() {
		return "SUM: " + getSum() + "\nAVERAGE: " + getAvg()
			+ "\nSMALLEST: " + getSmallest() + "\nLARGEST: " + getLargest() + "\n";
	}
}