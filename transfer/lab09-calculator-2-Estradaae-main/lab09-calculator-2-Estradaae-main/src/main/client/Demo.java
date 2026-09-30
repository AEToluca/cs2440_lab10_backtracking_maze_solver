package client;

import apps.Calculator;

/**
 * Demo used to manually test the program.
 * 
 * @author Willow Sapphire
 * @version 5/20/2019
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
        @SuppressWarnings("unused")
        Calculator calc = new Calculator();
        calc.getFrame();
    }
    
}
