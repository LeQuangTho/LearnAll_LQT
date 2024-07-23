package BaiTapTrenLop; 
public class tongmod3 {
	static int [] a = {1,2,3,4,5,6};
	public static void main(String[] args) {
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			if(a[i] % 3 == 0) sum+= a[i];  
			
		}
		System.out.println(" " + sum);
	}
}