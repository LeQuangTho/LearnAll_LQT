package BaiTapTrenLop;

public class max {

	public static void main(String[] args) {
		int [] a = {-3,1,2,4,5};
		int max = a[0];
		for (int i=0;i<a.length;i++) {
			if(max < a[i]) max=a[i];
		}
			if(max % 3 == 0) System.out.println(max);
			else {
				System.out.println("ko co");
			}
			int n= 4;
			String num = ((n%2 ==0)?"chan":"le");
			System.out.printf(" " +num);
	}

}
