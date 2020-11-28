import java.util.*;

public class HistoList
{
   private HistoNode front;

	public HistoList( )
	{
		front = null;
	}

	//addLetter will add a new node to the front for let if let does not exist
	//addLetter will bump up the count if let already exists
	public void addLetter(char let)
	{
		if (front == null) {
			front= new HistoNode(let, 1, front);
			return;
		}
		
		int count = 0;
		HistoNode tempFront = front;
		HistoNode temp = tempFront;
		while (tempFront != null) {
			count = tempFront.getLetterCount();
			
			//check last node
			if (tempFront.getLetter() == let && temp == null){
				tempFront.setLetterCount(++count);
				return;			
			}
			else if (tempFront.getLetter() == let) {
				tempFront.setLetterCount(++count);
				return;			
			}
			temp = tempFront;
			tempFront = tempFront.getNext();
		}
		front= new HistoNode(let, 1, front);
	}
	
//	public void remove(char let) {
//		if (front == null)
//			return;
//		
//		int count = 0;
//		HistoNode tempFront = front;
//		while (tempFront != null) {
//			if (tempFront.getLetter() == let) {
//				tempFront.setLetterCount(tempFront.getLetterCount());
//				count = tempFront.getLetterCount();
//			}
//			tempFront = tempFront.getNext();
//			
//		}
//		tempFront = front;
//		HistoNode tempPrevious = tempFront;
//		
//		if (count == 1) {
//			while (tempFront != null) {
//				if (tempFront.getLetter() == let) {
//					tempPrevious.setNext(tempFront.getNext());
//					return;
//				}
//				tempPrevious = tempFront;
//				tempFront = tempFront.getNext();
//			}
//			
//		}
//		else {
//			while (tempFront != null) {
//				if (tempFront.getLetter() == let) {
//					tempFront.setLetterCount(tempFront.getLetterCount()-1);
//					return;
//				}
//				tempFront = tempFront.getNext();
//			}
//		}
//	}

	//returns a string will all values from list
	public String toString()
	{
		String output = "";
		while (front != null)
		{
			output += front.getLetter() + " - " + front.getLetterCount() + " ";
			front = front.getNext();
		}

		return output;
	}
}
