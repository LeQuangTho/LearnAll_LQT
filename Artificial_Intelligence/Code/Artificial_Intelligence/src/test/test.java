package test;

import java.util.Iterator;

public class test {

	public static void main(String[] args) {
		int  sum = 0, count = 0;
		do {
			if(count %3 ==0) continue;
			sum += count;
		}while(count++<11);
		System.out.println(sum);
	}
}
