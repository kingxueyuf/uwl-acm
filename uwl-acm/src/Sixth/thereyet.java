import java.util.Scanner;


public class thereyet {
	
	public static void main(String args[])
	{
		Scanner scan  = new Scanner(System.in);
		String num = scan.nextLine();
		int caseNum =1;
		while(!num.equals("-1"))
		{
			int start = 0 ;
			for(start = 0 ; start<num.length();start++)
			{
				if(num.charAt(start) != '0')
				{
					break;
				}
			}
			num = num.substring(start, num.length());
			int numLength = num.length();
			if(numLength == 1)
			{
				System.out.print("Case "+caseNum+":");
				System.out.println("0 miles to "+num);
				num = scan.nextLine();
				caseNum++;
				continue;
			}
			else if(numLength % 2 ==0)
			{
				//ou shu ge
				
				//top half part
				String onePartReverse = "";
				for(int i = (numLength/2)-1;i>-1 ; i--)
				{
					onePartReverse += num.charAt(i);
				}
				
				String twoPart="";
				for(int i = (numLength/2) ; i<numLength ; i++)
				{
					twoPart += num.charAt(i);
				}
				
				int onePartReverseNum = Integer.valueOf(onePartReverse);
				int twoPartNum = Integer.valueOf(twoPart);
				
				
				if(onePartReverseNum> twoPartNum)
				{
					System.out.print("Case "+caseNum+":");
					String finalRes = "";
					for(int i = 0 ; i <(numLength/2) ; i++)
					{
						finalRes +=num.charAt(i);
					}
					finalRes +=onePartReverseNum;
					int subNum = Integer.valueOf(finalRes) - Integer.valueOf(num);
					System.out.println(subNum+" miles to "+finalRes);
				}else
				{
					String result = "";
					for(int i = 0 ; i<(numLength/2)-1 ;i++)
					{
						result += num.charAt(i);
					}
					String endChar = num.charAt(numLength/2-1)+"";
					int endInt = Integer.valueOf(endChar)+1;
					result += endInt;
					
					System.out.print("Case "+caseNum+":");
					String finalRes = result;
					for(int i = result.length()-1 ; i >-1 ; i --)
					{
						finalRes += result.charAt(i);
					}
					int finalInt = Integer.valueOf(finalRes);
					int sub = finalInt-Integer.valueOf(num);
					System.out.println(sub+" miles to "+finalInt);
				}
				
			}else
			{
				//ji shu ge
			}
			
			num = scan.nextLine();
			caseNum++;
		}
	}

}
