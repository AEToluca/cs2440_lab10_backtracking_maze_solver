package client;

import maze.MazeSolver;

/**
 * Demo used to manually test the program.
 * 
 * @author 
 * @version 
 */
public class Demo
{
	/**
     * Runs the demo.
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) 
    {
        MazeSolver t = new MazeSolver("data/maze0.txt");
        t.printMap();
        String solution = t.findSolution();
        t.printMap();
        if (solution != null)
        {
            System.out.println(solution);
        }
        else
        {
            System.out.println("There is no solution.");
        }
    }
}
