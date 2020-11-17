import java.util.*;

class LabTest {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (true) {
			System.err.println("Enter n m : ");
			int n = in.nextInt();
			int m = in.nextInt();
			if (n == 0)
				break;

			System.out.println("Combination(" + n + ", " + m + ") : " + Combi(n, m));
		}
		in.close();
	}

	static int Combi(int n, int m) {
		System.out.println("Combi(" + n + ", " + m + ")");
		int result = 0;
		if (n == 1)
			result++;
		else if (n == m)
			result++;
		else if (m == 0)
			result++;
		else
			return Combi(n - 1, m) + Combi(n - 1, m - 1);
		return result;
	}
}
