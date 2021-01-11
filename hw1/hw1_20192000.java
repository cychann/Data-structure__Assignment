import java.util.*;

// offset

/**
 * Maze Class
 * 
 */

class Maze {
	
	private int[][] maze;	// 2 dim array for maze
	private int[][] mark;	// 2 dim array for visit marking
	private int[][] move = {
			{1,0},{1,-1},{0,-1},{-1,-1},{-1,0},{-1,1},{0,1},{1,1},
	};
	
	public Maze(int m, int p) {
		maze = new int[m + 2][p + 2];
		mark = new int[m + 2][p + 2];
		for(int i = 0; i < m + 2; i++)
			for(int j = 0; j < p + 2; j++) {
				maze[i][j] = 1;
				mark[i][j] = 0;
			}
	}

	// create the maze structure
	public void SetWall(int i, int j, int val) {
		maze[i][j] = val;
	}
	
	public class Mazeitem{ 
		int i;
		int j;
		int dir;
		
		public Mazeitem(int i, int j, int dir) {
			this.i = i;
			this.j = j;
			this.dir = dir;
		}
	}


	public void Path(int m, int p) {
		Stack<Mazeitem> stack = new Stack<Mazeitem>(); 
		Stack<Mazeitem> stack1 = new Stack<Mazeitem>(); 
		stack.push(new Mazeitem(1,1,0)); 
		while(stack.isEmpty() != true) {
			Mazeitem route = stack.pop();
			while(route.dir<8) { 
				int g = route.i + move[route.dir][0];
				int h = route.j + move[route.dir][1];
				if((g==m) && (h==p)) { 
					stack.push(new Mazeitem(route.i, route.j, route.dir)); 
					stack.push(new Mazeitem(m,p,0)); 
					
					while(stack.isEmpty() != true) { 
						stack1.push((Mazeitem)stack.pop()); 
					}
					while(stack1.isEmpty() != true) {
						route = (Mazeitem)stack1.pop();
						// System.out.println(route);
						String s = new String();
						s = "(" + route.i + "," + route.j + ")";
						System.out.println(s);
					}
					return;
				}
				
				
				
				if(maze[g][h]==0 && mark[g][h]==0) {
					mark[g][h] = 1;
					stack.push(new Mazeitem(route.i, route.j, route.dir));
					route.i = g;
					route.j = h;
					route.dir = 0;
				}
				else
					route.dir++;
			}
		}
		System.out.println("No path in the maze.");
	}

}; 

