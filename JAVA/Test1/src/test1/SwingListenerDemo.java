package test1;

import java.util.Scanner;

public class SwingListenerDemo {
   public static void main(String[] args){
	   Scanner sc = new Scanner(System.in);
	   String a = new String();
	   a = sc.next();
	   if(a.length()>30) System.out.println("KHONG");
	   else System.out.println("CO");
	   sc.close();
   }
}