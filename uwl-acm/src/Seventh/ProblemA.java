import java.util.Scanner;


public class ProblemA {
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		String line = scan.nextLine();
		while(!line.equals("#")){
			char[] arr = line.toCharArray();
			int res = 0;
			for(int i = 0 ; i < arr.length; i++)
			{
				if(arr[i] == ' ')
					res += 0;
				else{
					res +=	(arr[i]-64) *(i+1);
//					System.out.println(arr[i]-64);
				}
			}
			System.out.println(res);
			line= scan.nextLine();
		}
	}
}
