public class Cal1 {
	String[] history;
	int now=0;
	
	int plus(int a, int b) {
		historyprn(a, '+', b, a+b);
		return 0;
	}
	
	void historyprn(int a, char op, int b, float result) {
		System.out.println(result);
		StringBuilder sb=new StringBuilder();
		sb.append(a).append(op).append(b).append("=").append(result);
	}
}
