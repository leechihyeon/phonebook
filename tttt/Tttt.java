package tttt;

import java.util.Scanner;

public class Tttt {

	public static void main(String[] args) {
		tttt2 t2=new tttt2();
		Scanner sc= new Scanner(System.in);
		System.out.println("두 수"
				+ "를 입력하세요");
		int su1=sc.nextInt();
		int su2=sc.nextInt();
	
		System.out.println("1.더하기");
		System.out.println("2.뺴기");
		System.out.println("3.곱하기");
		System.out.println("4.더하기");
		System.out.println("5.더하기");
		System.out.println("6.끝내기");
		
		switch (sc.nextInt()) {
		case 1:
			System.out.println(t2.add(su1,su2));
			break;

		case 6:
			System.out.println("시스템나가기");
			System.exit(0);
			break;
			
		default:
			break;
		}
		
System.out.println("꺼져");
		
		
		
}
}