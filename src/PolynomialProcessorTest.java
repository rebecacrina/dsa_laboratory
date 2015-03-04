import static org.junit.Assert.*;

import org.junit.Test;


public class PolynomialProcessorTest {
	
	PolynomialProcessor processor = new PolynomialProcessor();
	
	@Test
	public void testAdd() {
		Polynomial a = PolyFactory.Factory("2x^3+1x^1+3");
		Polynomial b = PolyFactory.Factory("2x^1+7"); 
		Polynomial resInput = PolyFactory.Factory("2x^3+3x^1+10");
		Polynomial res = processor.add(a,b);
		assertTrue(res.equalsPoly(resInput));
	}
	
	@Test
	public void testSubtract() {
		Polynomial a = PolyFactory.Factory("2x^3+1x^1+3");
		Polynomial b = PolyFactory.Factory("2x^1+7"); 
		Polynomial resInput = PolyFactory.Factory("2x^3-1x^1-4");
		Polynomial res = processor.subtract(a, b);
		assertTrue(res.equalsPoly(resInput));
	}
	@Test
	public void testMultiply() {
		Polynomial a = PolyFactory.Factory("2x^2+1x^1+3");
		Polynomial b = PolyFactory.Factory("2x^1"); 
		Polynomial resInput = PolyFactory.Factory("4x^3+2x^2+6x^1");
		Polynomial res = processor.multiply(a, b);
		assertTrue(res.equalsPoly(resInput));
	}
	@Test
	public void testDivide() {
		Polynomial a = PolyFactory.Factory("x^2+2x+1");
		Polynomial b = PolyFactory.Factory("x+1"); 
		Polynomial quotient = PolyFactory.Factory("x+1");
		Polynomial remainder = PolyFactory.Factory("0");
		Polynomial[] res = processor.divide(a, b);
		assertTrue(res[1].equalsPoly(quotient) && res[0].equalsPoly(remainder));
	}
	@Test
	public void testDifferentiate() {
		Polynomial a = PolyFactory.Factory("3x^4-7x^3+27x^2+x-7");
		Polynomial res = PolyFactory.Factory("12x^3-21x^2+54x+1");
		processor.diff(a);
		assertTrue(a.equalsPoly(res));
	}
	@Test
	public void testIntegrate() {
		Polynomial a = PolyFactory.Factory("12x^3-21x^2+52x+1");
		Polynomial res = PolyFactory.Factory("3x^4-7x^3+27x^2+x-7");
		processor.integrate(a);
		assertTrue(a.equalsPoly(res));
	}
	@Test
	public void testScalarMultiplication(){
		Polynomial a = PolyFactory.Factory("3x^4-7x^3+27x^2+x-7");
		Polynomial res = PolyFactory.Factory("-9x^4+21x^3-51x^2-3x+21");
		processor.scalarMul(a, -3);
		assertTrue(a.equalsPoly(res));
	}
	@Test
	public void testScalarDivision(){
		Polynomial a = PolyFactory.Factory("-18x^4+42x^3-12x^2-6x+42");
		Polynomial res = PolyFactory.Factory("3x^4-7x^3+2x^2+x-7");
		processor.scalarDiv(a, -6);
		assertTrue(a.equalsPoly(res));
	}
}
