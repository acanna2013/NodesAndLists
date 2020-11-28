import java.util.LinkedList;
import java.util.ListIterator;
public class Fruits{
	private LinkedList<String> bowl;
	
	public Fruits() {
		bowl = new LinkedList<String>(); //NOW I can add to/populate the list
		bowl.addLast("apple");
		bowl.addLast("banana");
		bowl.addLast("cherry");
		bowl.addLast("lime");
		bowl.addLast("lemon");
		bowl.addLast("orange");
		bowl.addLast("papaya");
		bowl.addLast("strawberry");
		bowl.addLast("watermelon");
	}
	
	public void displayFruit() { 
		System.out.println(bowl); //same thing as bowl.toString()
	}
	
	public void displayFruit2() { //not calling the toString in LinkedList
		for(String t : bowl) {
			System.out.println(t);
		}
	}
	
	public void displayFruit3() { //uses iterator to access values, have more control over what it's doing
		ListIterator<String> iter = bowl.listIterator();
		while(iter.hasNext())
			System.out.println(iter.next());
	}
	
	public void displayEveryOtherFruit() {
		ListIterator<String> iter = bowl.listIterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
			if (iter.hasNext()) //check if end of list
				iter.next();
		}
	}
	
	public void removeEveryOtherFruit() {
		ListIterator<String> iter = bowl.listIterator();
		iter.next();
		while(iter.hasNext()) {
			iter.next();
			iter.remove();
			if(iter.hasNext())
				iter.next();
		}
	}
	
	public void displayReverse() {
		ListIterator<String> iter = bowl.listIterator();
		while(iter.hasNext()) { //moves the iterator as far right as possible
			iter.next();
		}
		while (iter.hasPrevious()) {
			System.out.println(iter.previous());
			
		}
	}
	
	public void printLastElement() {
		ListIterator<String> iter = bowl.listIterator();
		while(iter.hasNext()) { //moves the iterator as far right as possible
			iter.next();
		}
		System.out.println(iter.previous());
	}
	
	public void insertFruit(String newFruit)
	{
		ListIterator<String> iter = bowl.listIterator();
		while(iter.hasNext()) {
			String fruit = iter.next();
			if (newFruit.compareTo(fruit) <= 0 )
			{
				iter.previous();
				iter.add(newFruit);
				break;
			}
		}
	}
	
	public void removeLetter(String letter)
	{
		ListIterator<String> iter = bowl.listIterator();
		while(iter.hasNext()) {
			if(iter.next().substring(0,1).equals(letter))
			{
				iter.remove();
				break;
			}
		}
	}
	
	public String findWord(String word)
	{
		ListIterator<String> iter = bowl.listIterator();
		while(iter.hasNext()) {
			if (iter.next().equals(word))
			{
				return "is indeed in the list";
			}
		}
		return "is not found in the list";
	}
	
	public void reverseFruits()
	{
		ListIterator<String> iter = bowl.listIterator();
		while (iter.hasNext()) {
			iter.next();
		}
		LinkedList<String> bowlReverse = new LinkedList<String>();
		while(iter.hasPrevious()) {
			bowlReverse.add(iter.previous());
		}
		for(String t : bowlReverse) {
			System.out.println(t);
		}
	}
	
	public boolean checkPrime(int n)
	{
		for (int i = 2; i <= n/2; i++)
		{
			if (n%i == 0 && n != 2)
				return false;
		}
		return true;
	}
	
	public void removeNonPrimes(LinkedList<Integer> prime)
	{
		ListIterator<Integer> iter = prime.listIterator();
		
		for(int t : prime) {
			System.out.print(t + " ");
		}
		System.out.println();
		
		while(iter.hasNext())
		{
			int temp = iter.next();
			if (!checkPrime(temp))
				iter.remove();
		}
		
		for(int t : prime) {
			System.out.print(t + " ");
		}
}
	
	public static void main(String []args) {
		Fruits one = new Fruits();
		LinkedList<Integer> withPrime = new LinkedList<Integer>();
		for (int i = 1; i <= 20; i++) {
			int random = (int)(Math.random()*20)+1;
			withPrime.add(random);
		}
		one.removeNonPrimes(withPrime);
		System.out.println();
		one.insertFruit("pomegranates");
		one.insertFruit("kiwi");
		one.insertFruit("dragonfruit");
		one.displayFruit();
		one.removeLetter("l");
		System.out.println(one.findWord("pomegranates"));
		one.reverseFruits();
		
	}
}

