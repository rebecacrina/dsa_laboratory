

public class PolynomialProcessor {
	
	int value;
	Polynomial a;
	Polynomial b;
	Polynomial res;
	Polynomial[] divPoly = new Polynomial[2];
	
	public Polynomial getA(){
		return a;
	}
	
	public Polynomial getB(){
		return b;
	}
	
	public Polynomial getRes(){
		return res;
	}
	
	public Polynomial getQuotient(){
		return divPoly[1];
	}
	
	public Polynomial getRemainder(){
		return divPoly[0];
	}
	public void setValue(int num){
		value = num;
	}
	public int getValue(){
		return value;
	}

	public void polyFactoringA(String inputString) {
		a = PolyFactory.Factory(inputString);
	}
	
	public void polyFactoringB(String inputString) {
		b = PolyFactory.Factory(inputString);
	}
	
	public Polynomial add(Polynomial a, Polynomial b){
		res = a.add(b);
		return res;
	}
	
	public Polynomial subtract(Polynomial a, Polynomial b){
		res = a.subtract(b);
		return res;
	}
	
	public Polynomial multiply(Polynomial a, Polynomial b){
		res = a.multiply(b);
		return res;
	}
	
	public Polynomial[] divide(Polynomial a, Polynomial b){
		divPoly = a.divide(b);
		return divPoly;
	}
	
	public Polynomial diff(Polynomial a){
		res = a.differentiate(a);
		return res;
	}
	
	public Polynomial integrate(Polynomial a){
		res = a.integrate(a);
		return res;
	}
	
	public void scalarMul(Polynomial a, int value){
		 a.scalarMultiply(value);
	}
	
	public void scalarDiv(Polynomial a, int value){
		a.scalarDivide(value);
	}
	
	public float atPoint(Polynomial a, int value){
		return a.computeValueAtGivenPoint(value);
	}
	
}