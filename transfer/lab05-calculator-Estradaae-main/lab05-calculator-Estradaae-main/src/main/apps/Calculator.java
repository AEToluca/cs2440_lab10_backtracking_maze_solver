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
    private JTextField leftOpField;
    private JTextField rightOpField;
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
        leftOpField = new JTextField(10);
        rightOpField = new JTextField(10);
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
        String leftOperand = leftOpField.getText(); 
        String rightOperand = rightOpField.getText();
        leftOpField.setName("leftOperand");
        rightOpField.setName("rightOperand");
        leftOpField.setText(leftOperand);
        rightOpField.setText(rightOperand);
        leftOpField.setColumns(7);   
        rightOpField.setColumns(7);
        JPanel panelInputs = new JPanel(new FlowLayout());
        panelInputs.add(leftOpField, FlowLayout.LEFT);
        panelInputs.add(rightOpField, FlowLayout.CENTER);
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
        JButton addButton = new JButton("ADD");
        addButton.setName("addButton");
        addButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e)
            {   
                double result = getLeftNum() + getRightNum();
                updateResult(result);
            }
        });

        JButton subButton = new JButton("SUB");
        subButton.setName("subButton");
        subButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e)
            {
                double result = getLeftNum() - getRightNum();
                updateResult(result);
            }
        });
        JButton multButton = new JButton("MULT");
        multButton.setName("multButton");
        multButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e)
            {
                double result = getLeftNum() * getRightNum();
                updateResult(result);
            }
        });

        JButton divButton = new JButton("DIV");
        divButton.setName("divButton");
        divButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e)
            {
                if (getRightNum() == 0) 
                {
                    updateResult(Double.NaN);
                } 
                else 
                {
                    double result = getLeftNum() / getRightNum();
                    updateResult(result);
                }
            }
        });
        panelButtons.add(addButton, BorderLayout.LINE_START);
        panelButtons.add(subButton, BorderLayout.CENTER);
        panelButtons.add(multButton, BorderLayout.LINE_END);
        panelButtons.add(divButton, BorderLayout.PAGE_END);
        frame.add(panelButtons, BorderLayout.AFTER_LAST_LINE);
    }

    private double getLeftNum() 
    {
        String leftOperandText = leftOpField.getText();
        try 
        {
            return Double.parseDouble(leftOperandText);
        }
        catch (NumberFormatException e) 
        {
            
            return Double.NaN;
        }
    }
    
    private double getRightNum() {
        String rightOperandText = rightOpField.getText();
        try 
        {
            return Double.parseDouble(rightOperandText);
        } 
        catch (NumberFormatException e) 
        {
            
            return Double.NaN;
        }
    }
    
    public void updateResult(double result)
    {
        if(Double.isNaN(result))
        {
            resultLabel.setText(RESULT_PREAMBLE + ERROR_MESSAGE);
        }
        else
        {
            resultLabel.setText(RESULT_PREAMBLE + result);
        }
    }
}
