public class Maze {
	private final char[][] maze;
	public int height;
	public int width;

	public Maze(char[][] maze) {
		this.maze = maze;
		this.height = maze.length;
		this.width = maze[0].length;
	}

	public boolean escape(int row, int col) {
		// Base case: If we have arrived at the exit, return true
		if (row == height - 1 && col == width - 1) {
			maze[row][col] = '+';
			return true;
		}

		// If the current position is not empty, return false
		if (maze[row][col] != ' ') {
			return false;
		}

		// Mark the current position as visited
		maze[row][col] = '+';

		// Check whether we can escape from one of the empty neighboring locations
		if (escape(row, col + 1) || escape(row + 1, col) || escape(row, col - 1) || escape(row - 1, col)) {
			return true;
		}

		// If no path found we backtrack and mark the current position as unvisited
		maze[row][col] = ' ';
		return false;
	}

}
