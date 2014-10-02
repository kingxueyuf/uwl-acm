import java.util.HashSet;
import java.util.Scanner;

public class ProblemC {

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		String line = scan.nextLine();
		while (!line.equals("*")) {
			char[] input = line.toCharArray();
			boolean find = true;
			for (int i = 0; i <= input.length - 2; i++) {
				boolean valid = checkSurprising(input, i);
				if (!valid)
				{
					find = false;
					System.out.println(line + " is NOT surprising.");
					break;
				}
			}
			if(find)
				System.out.println(line + " is surprising.");
			line = scan.nextLine();
		}
	}

	private static boolean checkSurprising(char[] input, int i) {
		// TODO Auto-generated method stub
		HashSet<String> set = new HashSet<String>();
		for (int a = 0; a < input.length; a++) {
			if (a + i + 1 >= input.length)
				break;
			String word = ""+input[a] + input[a + i + 1] + "";
			if (set.contains(word))
				return false;
			else
				set.add(word);
		}
		return true;

	}

}
