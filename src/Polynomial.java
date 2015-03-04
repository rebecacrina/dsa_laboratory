import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Polynomial {
	private List<Monomial> monomialList = new ArrayList<Monomial>();

	public Polynomial(List<Monomial> list) {
		monomialList = list;
		Collections.sort(monomialList, Monomial.Comparators.DEGREE);
	}

	public Polynomial add(Polynomial b) {
		return additionNewPoly(this,b);
		
	}

	public Polynomial subtract(Polynomial b) {
		List<Monomial> list = new ArrayList<>();
		Polynomial p;
		for (int i = 0; i < b.getSize(); i++) {
			list.add(new Monomial((-1) * b.getCoeff(i), b.getDeg(i)));
		}
		p = new Polynomial(list);
		return add(p);
	}

	public Polynomial multiply(Polynomial b) {
		Polynomial res = monomPolyMultiplication(monomialList.get(0), b);
		Polynomial aux ;
		for (int i = 1; i < monomialList.size(); i++) {
			aux = monomPolyMultiplication(monomialList.get(i), b);
			res = additionNewPoly(res, aux);
		}
		return res;
	}

	public Polynomial[] divide(Polynomial b) {
		List<Monomial> rem = new ArrayList<>();
		Polynomial[] quoRem = new Polynomial[2];
		Monomial monom;
		// qouRem[0] the quotient
		// qouRem[1] the remainder
		quoRem[0] = clonePoly();
		while (quoRem[0].getDeg(0) >= b.getDeg(0)) {
			monom = new Monomial((float)((double)quoRem[0].getCoeff(0) / (double)b.getCoeff(0)),
					quoRem[0].getDeg(0) - b.getDeg(0));
			//System.out.println(quoRem[0].getCoeff(0)+ " / "+ b.getCoeff(0));
			//System.out.println(quoRem[0].getDeg(0)+ " - "+ b.getDeg(0));
			//System.out.println("monom "+ monom);
			monom.setCoeff((-1)*monom.getCoeff());
			quoRem[0]= additionNewPoly(quoRem[0], monomPolyMultiplication(monom, b));
			removeZeroCoeffMonomials(quoRem[0]);
			monom.setCoeff((-1)*monom.getCoeff());
			//System.out.println("quotents..."+quoRem[0]);
			rem.add(monom);
			//System.out.println("remainders..."+rem);

		}
		quoRem[1] = new Polynomial(rem);
		return quoRem;
	}

	public Polynomial differentiate(Polynomial a) {
		for (int i = 0; i < a.getSize()-1; i++) {
			if (a.getDeg(i) > 0) {
				a.setCoeff(i, a.getCoeff(i) * a.getDeg(i));
				a.setDeg(i, a.getDeg(i) - 1);
			}
		}
		if(a.getDeg(a.getSize()-1) != 0){
			a.setCoeff(a.getSize()-1, a.getCoeff(a.getSize()-1) * a.getDeg(a.getSize()-1));
			a.setDeg(a.getSize()-1, a.getDeg(a.getSize()-1) - 1);
		}else
		{
			a.monomialList.remove(a.getSize()-1);
		}
		removeZeroCoeffMonomials(a);
		return a;
	}

	public Polynomial integrate(Polynomial a) {
		for (int i = 0; i < a.getSize(); i++) {
			a.setCoeff(i, a.getCoeff(i) / (a.getDeg(i) + 1));
			a.setDeg(i, a.getDeg(i) + 1);
		}
		return a;
	}

	public float computeValueAtGivenPoint(int value) {
		float res = 0;
		for (Monomial x : monomialList) {
			res += x.getCoeff() * Math.pow(value, x.getDeg());
		}
		return res;
	}

	public void scalarMultiply(int value) {
		for (Monomial x : monomialList) {
			x.setCoeff(x.getCoeff() * value);
		}
	}

	public void scalarDivide(int value) {
		for (Monomial x : monomialList) {
			x.setCoeff(x.getCoeff() / value);
		}
	}
	
	public boolean equalsPoly(Polynomial b){
		boolean are = true;
		for (int i = 0; i < monomialList.size(); i++) {
			if(monomialList.get(i).getDeg() != b.getDeg(i) && monomialList.get(i).getCoeff() != b.getCoeff(i)){
				are = false;
			}
		}
		
		return are;
	}

	private void removeZeroCoeffMonomials(Polynomial p) {
		for (int i = 0; i < p.getSize(); i++) {
			if (p.getCoeff(i) == 0)
				p.monomialList.remove(i);
		}
	}

	private Polynomial monomPolyMultiplication(Monomial a, Polynomial b) {
		Polynomial aux = scalarMultiplicationNewPoly(b, a.getCoeff());
		for (int j = 0; j < b.getSize(); j++) {
			aux.setDeg(j, a.getDeg() + b.getDeg(j));
		}
		return aux;
	}

	private Polynomial scalarMultiplicationNewPoly(Polynomial a, float value) {
		List<Monomial> res = new ArrayList<Monomial>();
		for (int j = 0; j < a.getSize(); j++) {
			res.add(new Monomial(a.getCoeff(j) * value, a.getDeg(j)));
		}
		return new Polynomial(res);
	}

	private Polynomial additionNewPoly(Polynomial a, Polynomial b) {
		List<Monomial> res = new ArrayList<Monomial>();
		int i = 0, j = 0;
		while (i < a.getSize() && j < b.getSize()) {
			if (a.getDeg(i) == b.getDeg(j)) {
				float coeff = a.getCoeff(i) + b.getCoeff(j);
					int deg = b.getDeg(j);
					res.add(new Monomial(coeff, deg));
					i++;
					j++;
			} 
			else if (a.getDeg(i) > b.getDeg(j)) {
				res.add(a.getMonomial(i));
				i++;
			} else {
				res.add(b.getMonomial(j));
				j++;
			}
		}
		if (i == a.getSize()) {
			while (j < b.getSize()) {
				res.add(b.getMonomial(j));
				j++;
			}
		}
		if (j == b.getSize()) {
			while (i < a.getSize()) {
				res.add(a.getMonomial(i));
				i++;
			}
		}
		return new Polynomial(res);
	}

	private Polynomial clonePoly() {
		List<Monomial> list = new ArrayList<>();
		for (int i = 0; i < monomialList.size(); i++) {
			list.add(monomialList.get(i));
		}
		return new Polynomial(list);
	}

	private int getSize() {
		return monomialList.size();
	}

	private int getDeg(int i) {
		return monomialList.get(i).getDeg();
	}

	private float getCoeff(int i) {
		return monomialList.get(i).getCoeff();
	}

	private void setDeg(int i, int newValue) {
		monomialList.get(i).setDeg(newValue);
	}

	private void setCoeff(int i, float newValue) {
		monomialList.get(i).setCoeff(newValue);
	}

	private Monomial getMonomial(int i) {
		return monomialList.get(i);
	}

	public String toString() {
		String s = "";
		for (int i = 0; i < monomialList.size() - 1; i++) {
			if (monomialList.get(i).getCoeff() < 0)
				s += "(" + monomialList.get(i).getCoeff() + ")" + "x^"
						+ monomialList.get(i).getDeg() + "+";
			else
				s += monomialList.get(i).getCoeff() + "x^"
						+ monomialList.get(i).getDeg() + "+";
		}
		if (monomialList.get(monomialList.size() - 1).getCoeff() < 0)
			s += "(" + monomialList.get(monomialList.size() - 1).getCoeff()
					+ ")" + "x^"
					+ monomialList.get(monomialList.size() - 1).getDeg();
		else
			s += monomialList.get(monomialList.size() - 1).getCoeff() + "x^"
					+ monomialList.get(monomialList.size() - 1).getDeg();
		return s;
	}
}
