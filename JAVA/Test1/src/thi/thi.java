package thi;
interface I1{}
interface I2{}
class Base{
	int t;
	public Base() {
		t = 2;
	}
}
class sub extends Base{
	public sub() {
		t = 4;
	
	}
	public static void main(String[] args) {
		sub s1 = new sub();
		System.out.println(s1.t);
	}
}
