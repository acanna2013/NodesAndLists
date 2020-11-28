import java.util.LinkedList;
import java.util.ListIterator;
public class Polynomial{
	LinkedList<Term> poly;
	public Polynomial() {
		poly = new LinkedList<Term>();
	}
	
	public void addTerm(int coeff, int expo) {
		ListIterator<Term> iter = poly.listIterator();
		if (coeff == 0)
			return;

		ListIterator<Term> iter2 = poly.listIterator();
		while (iter2.hasNext())
		{
			if (iter2.next().getExpo() < expo) {
				iter2.previous();
				iter2.add(new Term(coeff, expo));
				return;
			}
			else if (iter.next().getExpo() == expo) {
				iter2.add(new Term(coeff, expo));
				return;
			}
		}
		iter2.add(new Term(coeff, expo));
	}
	
	public Polynomial add(Polynomial poly2) {
		ListIterator<Term> iter = this.poly.listIterator();
		ListIterator<Term> iter2 = poly2.poly.listIterator();
		
		Polynomial sum = new Polynomial();
		while (iter.hasNext() && iter2.hasNext()) {
			Term thisIter = iter.next();
			iter.previous();
            Term iterDos = iter2.next();
            iter2.previous();

			int exponent = thisIter.getExpo();
			int exponent2 = iterDos.getExpo();
			
			if (exponent == exponent2) {
				sum.poly.add(new Term(iter.next().coefficient + iter2.next().coefficient, exponent));
			}
			else if (exponent < exponent2)
				sum.poly.add(new Term(iter2.next().coefficient, exponent2));
			else if (exponent > exponent2)
				sum.poly.add(new Term(iter.next().coefficient, exponent));
		}

		while (iter.hasNext()) //if poly is longer
			sum.poly.add(new Term(iter.next().coefficient, iter.next().exponent));
		while (iter2.hasNext()) //if poly2 is longer
			sum.poly.add(new Term(iter2.next().coefficient, iter2.next().exponent));
		
		
		return sum;
	}

	
	public Polynomial multiply(Polynomial poly2) {
		ListIterator<Term> iter = this.poly.listIterator();
		
		Polynomial product = new Polynomial();
		Polynomial product1 = new Polynomial();
		while (iter.hasNext()) {
			Term thisIter = iter.next();
			int expo = thisIter.exponent;
			int coeff = thisIter.coefficient;
			
			ListIterator<Term> iter2 = poly2.poly.listIterator();
			while (iter2.hasNext()) {
				Term iterDos = iter2.next();
				int expo2 = iterDos.exponent;
				int coeff2 = iterDos.coefficient;
				product.poly.add(new Term(coeff * coeff2, expo + expo2));
			}
		}
		return product;
	}
	
	public Polynomial derivative() {
		ListIterator<Term> iter = this.poly.listIterator();
		Polynomial deriv = new Polynomial();
		
		while (iter.hasNext())
			deriv.poly.add(iter.next().firstDerivative());
		
		return deriv;
	}
	
	public String toString() { 
		ListIterator<Term> iter = poly.listIterator();
		String s="";
	
		while(iter.hasNext()) 
			s+= iter.next().toString() + " + ";
		
		return s.substring(0, s.length()-2);
	}
	
	
}