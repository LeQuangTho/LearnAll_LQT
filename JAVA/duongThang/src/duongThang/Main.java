package duongThang;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<duongThang> listDT = new ArrayList<>();
		listDT.add(new duongThang(1,3));
        listDT.add(new duongThang(5,-3));
        listDT.add(new duongThang(-6,12));
        listDT.add(new duongThang(0,9));

		// SumDiscDT

		int num = 0;
		double sumDT = 0;
		for (duongThang ptdt : listDT) {
			sumDT += ptdt.disc();
			if (ptdt.check(6,7)==true)
				num ++;
		}
		
		System.out.println("số ĐT đi qua điểm (6,7)" + num);
		System.out.printf("Tổng khoảng cách của ĐT %.3f", sumDT);
		
		
		
		
		//Đường tròn nè
		
		List<duongTron> listDTron = new ArrayList<>();
		listDTron.add(new duongTron(1,3,5));
        listDTron.add(new duongTron(5,-3,-2));
        listDTron.add(new duongTron(-6,12,6));
        listDTron.add(new duongTron(0,9,0));

		// SumDiscDT

		int num1 = 0;
		double sumDTron = 0;
		for (duongThang ptdtron : listDT) {
			sumDTron += ptdtron.disc();
			if (ptdtron.check(6,7)==true)
				num1++;
		}
		
		System.out.println("\nSố ĐT đi qua điểm (6,7)" + num1);
		System.out.printf("Tổng khoảng cách của ĐT %.3f",  sumDTron);
	}
}
