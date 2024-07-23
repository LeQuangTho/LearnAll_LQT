package duongThang;

public class duongThang implements Shape{
	private double a;
	private double b;

	public duongThang(double a, double b) {
		super();
		this.a = a;
		this.b = b;
	}

	public duongThang() {
		super();
		this.a = 0;
		this.b = 0;
	}

	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}

	@Override
	public String toString() {
		return "duongThang y =" + a + "x + " + b + "";
	}
	
	@Override
	public double disc() {
		return Math.abs(this.b)/Math.sqrt(this.a*this.a+1.0);
	}
	
	@Override
	public boolean check(double x, double y) {
		double value=this.a*x+this.b;
        if(Math.abs(y-value)<0.0000001)return true;
        return false;
	}
}
