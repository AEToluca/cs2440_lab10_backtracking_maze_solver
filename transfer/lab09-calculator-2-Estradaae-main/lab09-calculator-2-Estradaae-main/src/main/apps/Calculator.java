package apps;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.FlowLayout;


public class Calculator
{
    private static final int X_LOC = 100;
    private static final int Y_LOC = 100;
    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;
    private static final String NAME = "calculator";
    private static final String RESULT_PREAMBLE = "Result = ";
    private static final String ERROR_MESSAGE = "Error";
    private JFrame frame;
    private JTextField infixExpression;
    private JLabel resultLabel;
    public Calculator()
    {
        createFrame();
        initializeComponents();
        displayFrame();
    }
    public JFrame getFrame()
    {
        return frame;
    }
    private void createFrame()
    {
        frame = new JFrame();
        frame.setLocation(X_LOC, Y_LOC);
        frame.setSize(WIDTH, HEIGHT);
        frame.setTitle(NAME);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private void initializeComponents()
    {
        infixExpression = new JTextField(10);
        resultLabel = new JLabel(RESULT_PREAMBLE);
        initializeInputs();
        initializeResults();
        initializeButtons();
    }
    private void displayFrame()
    {
        frame.pack();
        frame.setVisible(true);
    }
    private void initializeInputs()
    {
        String input = infixExpression.getText();
        infixExpression.setName("infixExpression");
        infixExpression.setText(input);
        infixExpression.setColumns(7);  
        JPanel panelInputs = new JPanel(new FlowLayout());
        panelInputs.add(infixExpression, FlowLayout.LEFT);
        frame.add(panelInputs, BorderLayout.NORTH);
    }
    private void initializeResults()
    {
        JPanel panelResults = new JPanel(new BorderLayout());
        resultLabel.setName("resultLabel");
        panelResults.add(resultLabel);
        frame.add(panelResults, BorderLayout.LINE_START);


    }
    private void initializeButtons()
    {
        JPanel panelButtons = new JPanel(new BorderLayout());
        JButton calculateButton = new JButton("CALCULATE");
        calculateButton.setName("calculateButton");
        calculateButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {  
                String result = calculate();
                updateResult(result);
            }
        });
        JButton clearButton = new JButton("CLEAR");
        clearButton.setName("clearButton");
        clearButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                infixExpression.setText("");
                resultLabel.setText(RESULT_PREAMBLE);
            }
        });
        panelButtons.add(calculateButton, BorderLayout.LINE_START);
        panelButtons.add(clearButton, BorderLayout.CENTER);
        frame.add(panelButtons, BorderLayout.AFTER_LAST_LINE);
    }
    private String calculate() {
        String expression = infixExpression.getText();
        double result = ExpressionEvaluator.evaluate(expression);
    
        if (Double.isNaN(result)) 
        {
            return ERROR_MESSAGE;
        }
    
        return String.valueOf(result);
    }
    private void updateResult(String result)
    {
        resultLabel.setText(RESULT_PREAMBLE + result);   
    }
}
