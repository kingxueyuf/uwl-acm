import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
5 5
**...
.....
....*
..*..
.....
*/
public class Main {
	int row;
	int col;
	char[][] maze;
	char[][] mazeCopy;
	List<Node> queue;
	List<Integer> result = new ArrayList<Integer>();

	public static void main(String args[]) {
		Main main = new Main();
		main.run();
	}

	public void run() {

		// getInput();

		Scanner scan = new Scanner(System.in);
		int num =1;
		while (scan.hasNext()) {
			String oneLine = scan.nextLine();
			String[] arr = oneLine.split(" ");
			row = Integer.valueOf(arr[0]);
			col = Integer.valueOf(arr[1]);
			maze = new char[row][col];
			mazeCopy = new char[row][col];
			for (int i = 0; i < row; i++) {
				String nextLine = scan.nextLine();
				maze[i] = nextLine.toCharArray();
				mazeCopy[i] = nextLine.toCharArray();
			}

			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					if (maze[i][j] == '.') {
						Node node = generateQueue(i, j);
						DFS(node);
						clearTable();
					}
				}
			}
			Output(num);
			num++;
		}
	}
	
	public void clearTable()
	
	{
		for(int i = 0 ; i <row; i++)
		{
			for(int j = 0 ; j<col ;j++)
			{
				maze[i][j] = mazeCopy[i][j];
			}
		}
	}
	public void Output(int num)
	{
		int[] arr = new int[result.size()];
		for(int i = 0 ; i <arr.length ; i++)
		{
			arr[i] = result.get(i);
//			System.out.println(result.get(i));
		}
		Arrays.sort(arr);
		if(arr.length == 0)
		{
			System.out.println("Case "+num+":" +" -1");
		}
		System.out.println("Case " +num+": "+arr[0]);
	}
	
	public Node generateQueue(int row , int col)
	{
		Node node = new Node();
		node.row = row;
		node.col = col;
		return node;
	}
	
	public void DFS(Node current)
	{
		maze[current.row][current.col] = '1';
		boolean find = true;
		for(int i = 0 ; i < row ; i ++)
		{
			for(int j = 0 ; j <col ;j++)
			{
//				System.out.print(maze[i][j]);
				if(maze[i][j] == '.')
					find = false;
			}
//			System.out.println();
		}
//		System.out.println();
		if(find)
		{
			this.result.add(current.step);
			return;
		}
		int row;
		int col;
		for (int i = 0; i < 4; i++) {
			switch (i) {
			case 0:
				// up
				row = current.row -1;
				col = current.col;
//				System.out.println(row + " " + col);
				if(row >= 0 && maze[row][col] =='.')
				{
					maze[row][col] = '1';//used
					Node node = new Node();
					node.row = row;
					node.col = col;
					node.direction = 0;
					if(current.direction != node.direction)
					{
						node.step = current.step +1;
					}else
					{
						node.step = current.step;
					}
					DFS(node);
					maze[row][col] = '.';
				}
				break;
			case 1:
				// down
				row = current.row +1;
				col = current.col;
//				System.out.println(row + " " + col);
				if(row < this.row && maze[row][col] =='.')
				{
					maze[row][col] = '1';//used
					Node node = new Node();
					node.row = row;
					node.col = col;
					node.direction = 1;
					if(current.direction != node.direction)
					{
						node.step = current.step +1;
					}else
					{
						node.step = current.step;
					}
					DFS(node);
					maze[row][col] = '.';
				}
				break;
			case 2:
				// left
				row = current.row;
				col = current.col -1;
//				System.out.println(row + " " + col);
				if(col >= 0 && maze[row][col] =='.')
				{
					maze[row][col] = '1';//used
					Node node = new Node();
					node.row = row;
					node.col = col;
					node.direction = 2;
					if(current.direction != node.direction)
					{
						node.step = current.step +1;
					}else
					{
						node.step = current.step;
					}
					DFS(node);
					maze[row][col] = '.';
				}
				break;
			case 3:
				// right
				row = current.row;
				col = current.col +1;
//				System.out.println(row + " " + col);
				if(col < this.col && maze[row][col] =='.')
				{
					maze[row][col] = '1';//used
					Node node = new Node();
					node.row = row;
					node.col = col;
					node.direction = 3;
					if(current.direction != node.direction)
					{
						node.step = current.step +1;
					}else
					{
						node.step = current.step;
					}
					DFS(node);
					maze[row][col] = '.';
				}
				break;
			}
		}
	}

	public void getInput() {


		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
//				System.out.print(maze[i][j]);
			}
//			System.out.println();
		}
	}

	class Node {
		int row;
		int col;
		int step = 0;
		int direction = -1 ;
		List<Node> childList = new ArrayList<Node>();
	}
}
