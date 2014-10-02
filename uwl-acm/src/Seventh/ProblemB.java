import java.util.Scanner;

public class ProblemB {

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		String line = scan.nextLine();
		while (!line.equals("#")) {
			char[] table = line.toCharArray();
			int res = 0;
			for (int i = 0; i < table.length; i++) {
				if (table[i] == '.')
					res += 100;
				else if (table[i] == '_')
					res += 0;
				else if (table[i] == '/') {
					// to left
					boolean stop = false;
					for (int j = i - 1; j > -1; j--) {
						if (table[j] == '.') {
							res += 100;
							stop = true;
							break;
						}
						if (table[j] == '|' || table[j] == '/'
								|| table[j] == '\\') {
							stop = true;
							break;
						}
					}
					if (stop)
						res += 0;
					else
						res += 100;
				} else if (table[i] == '\\') {
					// to right
					boolean stop = false;
					for (int j = i + 1; j < table.length; j++) {
						if (table[j] == '.') {
							res += 100;
							stop = true;
							break;
						}
						if (table[j] == '|' || table[j] == '/'
								|| table[j] == '\\') {
							stop = true;
							break;
						}
					}
					if (stop)
						res += 0;
					else
						res += 100;
				} else if (table[i] == '|') {
					// to left
					boolean stop = false;
					for (int j = i - 1; j > -1; j--) {
						if (table[j] == '.') {
							res += 50;
							stop = true;
							break;
						}
						if (table[j] == '|' || table[j] == '/'
								|| table[j] == '\\') {
							stop = true;
							break;
						}
					}
					if (stop)
						res += 0;
					else
						res += 50;
					// to right
					stop = false;
					for (int j = i + 1; j < table.length; j++) {
						if (table[j] == '.') {
							res += 50;
							stop = true;
							break;
						}
						if (table[j] == '|' || table[j] == '/'
								|| table[j] == '\\') {
							stop = true;
							break;
						}
					}
					if (stop)
						res += 0;
					else
						res += 50;
				}
			}
//			System.out.println(res);
			System.out.println(res/table.length);
			line = scan.nextLine();
		}
	}
}
