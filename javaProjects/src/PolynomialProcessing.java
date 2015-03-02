

public class PolynomialProcessing {
	
	
	Polynomial a;
	Polynomial b;
	Polynomial res;
	Polynomial[] divPoly = new Polynomial[2];

	public static void main(String[] agrs) {
		String s = "-2x^3+1x^1+3";
		String s1 ="+2x^1+7";
		PolynomialProcessing p = new PolynomialProcessing();
		//here I tested the operations
		p.polyFactoringA(s);
		p.printPolyA();
		p.polyFactoringB(s1);
		p.printPolyB();
		p.div();
		/*p.add();
		p.PrintRes();
		p.diff();
		p.PrintRes();*/
		p.integ();
		/*p.PrintRes();
		p.printPolyA();
		System.out.println(p.atPoint(1));
		p.scalarMul(2);
		p.printPolyA();
		p.scalarDiv(2);
		p.printPolyA();*/
	}

	public void polyFactoringA(String inputString) {
		this.a = Polynomial.getPolynomial(inputString);
	}
	
	public void polyFactoringB(String inputString) {
		this.b = Polynomial.getPolynomial(inputString);
	}
	
	public void add(){
		res = a.addition(b);
	}
	
	public void sub(){
		res = a.subtraction(b);
	}
	
	public void mul(){
		res = a.multiplication(b);
	}
	
	public void div(){
		divPoly = a.division(b);
		System.out.println("the quotient"+ divPoly[0]);
		System.out.println("the remainder" + divPoly[1]);
	}
	
	public void diff(){
		res = a.differentiatePoly(res);
	}
	
	public void integ(){
		res = a.integratePoly(a);
		System.out.println(res + "+ C ");
	}
	
	public void scalarMul(int value){
		a.scalarMultiplication(value);
	}
	
	public void scalarDiv(int value){
		a.scalarDivision(value);
	}
	
	public float atPoint(int value){
		return a.valueAtGivenPoint(value);
	}
	
	public void PrintRes(){
		System.out.println(res);
	}
	
	public void printPolyA(){
		System.out.println(a);
	}
	
	public void printPolyB(){
		System.out.println(b);
	}
	
}