
public class Term {
	int coefficient;
	int exponent;
	public Term (int coef, int exp) {
		coefficient = coef;
		exponent = exp;
	}
	public int getCoeff() {
		return coefficient;
	}
	public void setCoeff(int coefficient) {
		this.coefficient = coefficient;
	}
	public int getExpo() {
		return exponent;
	}
	public void setExponent(int exponent) {
		this.exponent = exponent;
	}
	
	public Term add(Term q)
	{
		if (q.exponent != this.exponent)
			return null;
		Term one = new Term(this.coefficient + q.coefficient, this.exponent);
		return one;
	}
	
	public Term multiply(Term q) {
		Term one = new Term(this.coefficient*q.coefficient, this.exponent+q.exponent);
		return one;
	}
	
	public Term firstDerivative() {
		Term one = new Term(this.coefficient *this.exponent, this.exponent -1);
		return one;
	}
	
	public String toString() {
		if (coefficient == 0)
			return "";
		else if (exponent == 0)
			return "1";
		else 
			return getCoeff() + "x^" + getExpo();
	}
}
