package duongThang;

public class duongTron implements Shape{
    private double a,b;
    private double r;

    public duongTron(double a, double b, double r) {
        this.a = a;
        this.b = b;
        this.r = r;
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

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }
    @Override
    public double disc()
    {
        return Math.sqrt(this.a*this.a +this.b*this.b);
    }
    
    @Override
    public boolean check(double x,double y)
    {
    	double value = Math.sqrt((x-this.a)*(x-this.a) + (y-this.b)*(y-this.b));
		if((this.r * this.r - value) < 0.000001) 
			return true;
		else 
			return false;
    }
    @Override
    public String toString() {
        return "duongTron{" +
                "a=" + a +
                ", b=" + b +
                ", r=" + r +
                '}';
    }
}
