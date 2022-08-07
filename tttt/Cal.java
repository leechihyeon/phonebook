public class Cal {
	String[] history;
	int position = 0;
	// StringBuilder sb = new StringBuilder();

	public Cal() {
		history = new String[20];
	}

	public Cal(int size) {
		history = new String[size];
	}

	int plus(int a, int b) {
		writeHistory(a, '+', b, a + b);
		return a + b;
	}

	int minus(int a, int b) {
		writeHistory(a, '-', b, a - b);
		return a - b;
	}

	int mux(int a, int b) {
		writeHistory(a, '*', b, a * b);
		return a * b;
	}

	float div(int a, int b) {
		writeHistory(a, '/', b, a / b);
		return (float) a / b;
	}

	void historyprn() {
		for (int i = 0; i < position; i++) {
			System.out.println(history[i]);
			if (i % 10 == 9) {
				System.out.println("--------------------");
			}
		}
	}

	void writeHistory(int a, char op, int b, float result) {
		StringBuilder sb = new StringBuilder();
		result = a+op+b;
		System.out.println("result값 : "+result);
		sb.append(a).append(op).append(b).append("=").append(result);
		history[position++] = sb.toString();
	}
}
