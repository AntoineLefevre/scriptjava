import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Script {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		String[] words = new String[n];
		for (int i = 0; i < n; i++) {
			words[i] = sc.nextLine();
		}
		Set<Character> lettres = new TreeSet<>();
		char[] lettreDeb = new char[n];
		int i = 0;
		for (String word : words) {
			lettreDeb[i] = word.toCharArray()[0];
			i++;
			for (char c : word.toCharArray()) {
				lettres.add(c);
			}
		}

		if (lettres.size() > 10) {
			System.out.println("Plus de 10 lettres différentes");
		} else {
			Integer[] values = new Integer[lettres.size()];

			testAll(lettres, values, 0);
		}

	}

	public static void testAll(Set<Character> letters, Integer[] values, int n) {
		if (n == letters.size()) {
			System.out.println(Arrays.asList(values));
			return;
		}
		for (int i = 0; i < 10; i++) {
			for (int a = 0; a < values.length; a++) {
				if (values[a] != i) {
					values[n] = i;
				}
			}				
			testAll(letters, values, n + 1);
		}
	}
}
