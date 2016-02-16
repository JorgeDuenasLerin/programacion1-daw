public class Fraccion {

	private int _num;
	private int _den;

	public Fraccion(int num, int den) {
		setNum(num);
		setDen(den);
	}

	@Override
	public boolean equals(Object obj) {
		if (super.equals(obj)) {
			return true;
		}

		if (obj instanceof Fraccion) {

			Fraccion f = (Fraccion) obj;

			return f.getDen() * getNum() == f.getNum() * getDen();
		}
		return false;

	}

	public static void main(String[] args) {
		Object f1 = new Fraccion(3, 4);
		Object f2 = new Fraccion(6, 8);
		Object f3 = new Fraccion(9, 4);
		System.out.printf(" Deberia ser true : %b\n", f1.equals(f2));
		System.out.printf(" Deberia ser true : %b\n", f2.equals(f1));
		System.out.printf(" Deberia ser false : %b\n", f3.equals(f1));
		System.out.printf(" Deberia ser false : %b\n", f1.equals(f3));
		System.out.printf(" Deberia ser false : %b\n", f1.equals("hola"));
	}

	public int getNum() {
		return _num;
	}

	public void setNum(int _num) {
		this._num = _num;
	}

	public int getDen() {
		return _den;
	}

	public void setDen(int _den) {
		this._den = _den;
	}

}
