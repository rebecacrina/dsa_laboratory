import java.util.Comparator;


public class Monomial implements Comparable<Monomial>{
	private float coeff;
	private int deg;
	
	public Monomial(float coef, int deg){
		this.coeff = coef;
		this.deg = deg;
	}

	public float getCoeff() {
		return coeff;
	}

	public void setCoeff(float coeff) {
		this.coeff = coeff;
	}

	public int getDeg() {
		return deg;
	}

	public void setDeg(int deg) {
		this.deg = deg;
	}
	
	@Override
	public String toString(){
		if(getCoeff()>=0)
			return getCoeff() + "x^" + getDeg();
		else
			return "("+getCoeff() +")"+ "x^" + getDeg();
	}

	@Override
	public int compareTo(Monomial m) {
		
		return Comparators.DEGREE.compare(this, m);
	}
	public static class Comparators {

      
        public static Comparator<Monomial> DEGREE = new Comparator<Monomial>() {
            @Override
            public int compare(Monomial m1, Monomial m2) {
                return m2.deg - m1.deg;
            }
        };
    }
}
