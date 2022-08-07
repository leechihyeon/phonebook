import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		/* 1) 두 수를 입력받는다. 2) 연산자를 선택한다. 3) 연산결과를 출력한다. */		
		Scanner sc=new Scanner(System.in);
		Cal cal=new Cal();
		int su1=0,su2=0;
		while(true) {
			System.out.println("두 수를 입력하세요. 예) 10 20");
			su1=sc.nextInt();			// 1) 두수 입력
			su2=sc.nextInt();
			switch(menu()) { // 3) 연산결과 출력
			case '1': System.out.println(cal.plus(su1, su2)); break;
			case '2': System.out.println(cal.minus(su1, su2)); break;
			case '3': System.out.println(cal.mux(su1, su2)); break;
			case '4': System.out.println(cal.div(su1, su2)); break;
			case '5': cal.historyprn(); break;
			case '6': System.out.println("프로그램이 종료되었습니다."); System.exit(0); break;
			default: System.out.println("메뉴를 다시 선택하세요."); break;
			}
		}
	}
	public static int menu() throws IOException { // 2) 연산자 선택
		System.out.println("메뉴를 선택하세요.");
		System.out.println("1.더하기 | 2. 빼기 | 3. 곱하기  | 4. 나누기  | 5. 연산결과 | 6. 종료 ");
		return System.in.read();
	}
}