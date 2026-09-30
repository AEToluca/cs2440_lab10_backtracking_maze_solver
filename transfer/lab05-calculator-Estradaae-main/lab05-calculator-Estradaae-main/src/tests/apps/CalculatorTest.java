package apps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.awt.BorderLayout;
import java.awt.Component;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextField;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test class for the calculator GUI.
 * 
 * @author Mitch Parry
 * @author Willow Sapphire
 * @version 08/03/2023
 */
public class CalculatorTest
{
    private static final int NUM_RUNS = 5;
    private static final int TERM_INDEX = 0;
    private static final int NAME_INDEX = 1;
    private static final int LABEL_INDEX = 2;
    private static final String[][] BUTTONS = {
        {"addition", "addButton", "ADD"},
        {"subtraction", "subButton", "SUB"},
        {"division", "divButton", "DIV"},
        {"multiplication", "multButton", "MULT"}
    };
    private static final String[][] LABELS = {
        {"result", "resultLabel", "result ="}
    };

    private static final int SIZE_INDEX = 2;
    private static final String[][] FIELDS = {
        {"left operand", "leftOperand", "5"},
        {"right operand", "rightOperand", "5"}
    };    

    private Calculator calc;

    private JFrame frame;

    /**
     * Initialize test obj for each test.
     */
    @BeforeEach
    public void beforeEach()
    {
        calc = new Calculator();
        frame = calc.getFrame();
        assertNotNull(frame, "getFrame returned null");
        assertTrue(frame.isVisible(), "Calculator not visibile after created");
    }

    @Test
    public void testFrame()
    {
        String title = frame.getTitle();
        int index = title.toLowerCase().indexOf("calculator");
        assertTrue(index >= 0, "title does not include the word 'calculator'");
    }

    @Test
    public void testButtons()
    {
        JButton button;
        for (String[] quals : BUTTONS)
        {
            button = getPanelComponent(JButton.class, quals[NAME_INDEX]);
            assertNotNull(button, String.format(
                "Could not find %s button. Was its name set correctly?",
                quals[TERM_INDEX]));
            assertTrue(button.isVisible(), String.format(
                "%s button not visible on the calculator.",
                quals[TERM_INDEX]));
            assertEquals(quals[LABEL_INDEX], button.getText(), String.format(
                "%s button has incorrect label.", quals[TERM_INDEX]));
        }
    }

    @Test
    public void testLabels()
    {
        JLabel label;
        for (String[] quals : LABELS)
        {
            label = getPanelComponent(JLabel.class, quals[NAME_INDEX]);
            assertNotNull(label, String.format(
                "Could not find %s label. Was its name set correctly?",
                quals[TERM_INDEX]));
            assertTrue(label.isVisible(), String.format(
                "%s label not visible on the calculator.",
                quals[TERM_INDEX]));
            assertTrue(label.getText().toLowerCase().contains(quals[LABEL_INDEX]),
                String.format("%s label should include the phrase '%s'",
                quals[TERM_INDEX], quals[LABEL_INDEX]));
        }
    }

    @Test
    public void testFields()
    {
        JTextField field;
        for (String[] quals : FIELDS)
        {
            field = getPanelComponent(JTextField.class, quals[NAME_INDEX]);
            assertNotNull(field, String.format(
                "Could not find %s field. Was its name set correctly?",
                quals[TERM_INDEX]));
            assertTrue(field.isVisible(), String.format(
                "%s field not visible on the calculator.",
                quals[TERM_INDEX]));
            assertTrue(field.getColumns() >= Integer.parseInt(quals[SIZE_INDEX]),
                String.format("%s field should have at least %s columns",
                quals[TERM_INDEX], quals[SIZE_INDEX]));
        }
    }

    @Test
    public void testAddition()
    {
        for (int i = 0; i < NUM_RUNS; i++)
        {
            int leftOp = (int) (Math.random() * 1000);
            int rightOp = (int) (Math.random() * 1000);
            testAdd(leftOp, rightOp);
            testAdd(leftOp * -1, rightOp);
            testAdd(leftOp, rightOp * -1);
            testAdd(leftOp * -1, rightOp * -1);
        }
    }

    @Test
    public void testSubtraction()
    {
        for (int i = 0; i < NUM_RUNS; i++)
        {
            int leftOp = (int) (Math.random() * 1000);
            int rightOp = (int) (Math.random() * 1000);
            testSubtract(leftOp, rightOp);
            testSubtract(leftOp * -1, rightOp);
            testSubtract(leftOp, rightOp * -1);
            testSubtract(leftOp * -1, rightOp * -1);
        }
    }

    @Test
    public void testMultiplication()
    {
        for (int i = 0; i < NUM_RUNS; i++)
        {
            int leftOp = (int) (Math.random() * 1000);
            int rightOp = (int) (Math.random() * 1000);
            testMultiply(leftOp, rightOp);
            testMultiply(leftOp * -1, rightOp);
            testMultiply(leftOp, rightOp * -1);
            testMultiply(leftOp * -1, rightOp * -1);
        }
    }

    @Test
    public void testDivision()
    {
        for (int i = 0; i < NUM_RUNS; i++)
        {
            int leftOp = (int) (Math.random() * 1000);
            int rightOp = (int) (Math.random() * 1000);
            testDivide(leftOp, rightOp);
            testDivide(leftOp * -1, rightOp);
            testDivide(leftOp, rightOp * -1);
            testDivide(leftOp * -1, rightOp * -1);
            testDivide(leftOp, rightOp * 0);
            testDivide(leftOp * -1, rightOp * 0);
            testDivide(leftOp * 0, rightOp * 0);
            testDivide(leftOp * 0, rightOp);
            testDivide(leftOp * 0, rightOp * -1);
        }
    }

    public void testInvalidI()
    {
        for (int i = 0; i < NUM_RUNS; i++)
        {
            String leftOp = Integer.toString((int) (Math.random() * 1000));
            String rightOp = Integer.toString((int) (Math.random() * 1000));
            for (char op : new char[]{'+', '-', '*', '/'})
            {
                testNonnumeric(leftOp, "nan", op);
                testNonnumeric("nan", rightOp, op);
                testNonnumeric("nan", "nan", op);
                testNonnumeric(leftOp, "", op);
                testNonnumeric("", rightOp, op);
                testNonnumeric("", "", op);
            }
        }
    }

    /**
     * Test layout with three panels.
     */
    @Test
    public void testLayout1()
    {
        JButton button = getPanelComponent(JButton.class, "addButton");
        JPanel buttonPanel = (JPanel) button.getParent();
        JPanel rootPanel = (JPanel) buttonPanel.getParent();
        assertEquals(rootPanel.getComponentCount(), 3);
    }

    /**
     * Test layout with textField panel at PAGE_START, NORTH, or
     * BEFORE_FIRST_LINE.
     */
    @Test
    public void testLayout2()
    {
        JTextField field = getPanelComponent(JTextField.class, "leftOperand");
        JPanel panel = (JPanel) field.getParent();
        JPanel rootPanel = (JPanel) panel.getParent();
        BorderLayout bl = (BorderLayout) rootPanel.getLayout();
        Component a = bl.getLayoutComponent(BorderLayout.PAGE_START);
        Component b = bl.getLayoutComponent(BorderLayout.NORTH);
        Component c = bl.getLayoutComponent(BorderLayout.BEFORE_FIRST_LINE);
        if (panel != a && panel != b && panel != c)
        {
            fail("Text field layout fails.");
        }
    }

    /**
     * Test layout with resultLabel panel at LINE_START, WEST,
     * BEFORE_LINE_BEGINS, CENTER, LINE_END, EAST, or AFTER_LINE_ENDS.
     */
    @Test
    public void testLayout3()
    {
        JLabel label = getPanelComponent(JLabel.class, "resultLabel");
        JPanel panel = (JPanel) label.getParent();
        JPanel rootPanel = (JPanel) panel.getParent();
        BorderLayout bl = (BorderLayout) rootPanel.getLayout();
        Component a = bl.getLayoutComponent(BorderLayout.LINE_START);
        Component b = bl.getLayoutComponent(BorderLayout.WEST);
        Component c = bl.getLayoutComponent(BorderLayout.BEFORE_LINE_BEGINS);
        Component d = bl.getLayoutComponent(BorderLayout.CENTER);
        Component e = bl.getLayoutComponent(BorderLayout.LINE_END);
        Component f = bl.getLayoutComponent(BorderLayout.EAST);
        Component g = bl.getLayoutComponent(BorderLayout.AFTER_LINE_ENDS);
        if (panel != a && panel != b && panel != c && panel != d
            && panel != e && panel != f && panel != g)
        {
            fail("Result label layout fails.");
        }
    }

    /**
     * Test layout with button panel at PAGE_END, SOUTH, or AFTER_LAST_LINE.
     */
    @Test
    public void testLayout4()
    {
        JButton button = getPanelComponent(JButton.class, "addButton");
        JPanel panel = (JPanel) button.getParent();
        JPanel rootPanel = (JPanel) panel.getParent();
        BorderLayout bl = (BorderLayout) rootPanel.getLayout();
        Component a = bl.getLayoutComponent(BorderLayout.PAGE_END);
        Component b = bl.getLayoutComponent(BorderLayout.SOUTH);
        Component c = bl.getLayoutComponent(BorderLayout.AFTER_LAST_LINE);
        if (panel != a && panel != b && panel != c)
        {
            fail("Button layout fails.");
        }
    }

    /**
     * Gets the subcomponent of root with the 'type' and 'name'.
     * 
     * @param <T> the return type.
     * @param root the root component.
     * @param type the type of the subcomponent.
     * @param name the name of the subcomponent.
     * @return the subcomponent or null if it does not exist.
     */
    @SuppressWarnings("unchecked")
    private <T extends Component> T getComponent(JComponent root,
        Class<T> type, String name)
    {
        for (Component c : root.getComponents())
        {
            if (c.getClass() == type)
            {
                if (((T) c).getName().equals(name))
                {
                    return (T) c;
                }
            }
        }
        fail("Could not find " + type + " with name = \"" + name + "\"");
        return null;
    }

    /**
     * Gets the content pane of the calculator.
     * 
     * @return the content pane for the calculator.
     */
    private JPanel getContentPane()
    {
        JFrame frame = calc.getFrame();
        assertNotNull(frame);
        JRootPane root = (JRootPane) frame.getRootPane();
        JLayeredPane layeredPane =
            getComponent(root, JLayeredPane.class, "null.layeredPane");
        JPanel contentPane =
            getComponent(layeredPane, JPanel.class, "null.contentPane");
        return contentPane;
    }

    /**
     * Gets the component within a panel of the frame of the calculator with the
     * specified name.
     * 
     * @param <T>  used for the return value.
     * @param type The type of component to find.
     * @param name the name of the component.
     * @return the component or null if it wasn't found.
     */
    @SuppressWarnings("unchecked")
    private <T extends Component> T getPanelComponent(Class<T> type,
        String name)
    {
        JPanel contentPane = getContentPane();
        for (Component c : contentPane.getComponents())
        {
            if (c instanceof JPanel)
            {
                for (Component d : ((JPanel) c).getComponents())
                {
                    if (d.getClass() == type && d.getName().equals(name))
                    {
                        return (T) d;
                    }
                }
            }
        }
        return null;
    }

    /**
     * Simulates entering keyboard input to the field.
     * 
     * @param f The text field
     * @param s The string to type
     */
    private void keyString(JTextField f, String s)
    {
        f.setText(s);
    }

    /**
     * Simulates clicking the button.
     * 
     * @param b the button
     */
    private void click(JButton b)
    {
        b.doClick();
    }

    /**
     * Test BUTTONS.
     * 
     * @param a Left operand
     * @param b Right operand
     * @param op Operator
     */
    private void clickOperation(int a, int b, char op)
    {
        JTextField op1Field =
            getPanelComponent(JTextField.class, "leftOperand");
        JTextField op2Field =
            getPanelComponent(JTextField.class, "rightOperand");
        keyString(op1Field, Integer.toString(a));
        keyString(op2Field, Integer.toString(b));
        switch (op)
        {
            case '+':
                click(getPanelComponent(JButton.class, "addButton"));
                break;
            case '-':
                click(getPanelComponent(JButton.class, "subButton"));
                break;
            case '*':
                click(getPanelComponent(JButton.class, "multButton"));
                break;
            case '/':
                click(getPanelComponent(JButton.class, "divButton"));
                break;
            default:
        }
    }

    /**
     * Click button with nonnumeric input.
     * 
     * @param op1 Left operand
     * @param op2 Right operand
     * @param op Operator
     */
    private void clickNonnumeric(String op1, String op2, char op)
    {
        JTextField op1Field =
            getPanelComponent(JTextField.class, "leftOperand");
        JTextField op2Field =
            getPanelComponent(JTextField.class, "rightOperand");
        keyString(op1Field, op1);
        keyString(op2Field, op2);
        switch (op)
        {
            case '+':
                click(getPanelComponent(JButton.class, "addButton"));
                break;
            case '-':
                click(getPanelComponent(JButton.class, "subButton"));
                break;
            case '*':
                click(getPanelComponent(JButton.class, "multButton"));
                break;
            case '/':
                click(getPanelComponent(JButton.class, "divButton"));
                break;
            default:
        }
    }

    /**
     * Get last number from string.
     * 
     * @param r
     *            The string
     * @return the last number as a string
     */
    private String getLastNumber(String r)
    {
        Scanner scan = new Scanner(r);
        String s = null;
        while (scan.hasNext())
        {
            if (scan.hasNextDouble())
            {
                s = scan.next();
            }
            else
            {
                scan.next();
            }
        }
        scan.close();
        return s;
    }

    /**
     * Compare current result.
     * 
     * @return The current result
     */
    private String getAnswer()
    {
        JLabel resultLabel = getPanelComponent(JLabel.class, "resultLabel");
        return resultLabel.getText();
    }

    /**
     * Test add.
     * 
     * @param a
     *            Left operand
     * @param b
     *            Right operand
     */
    private void testAdd(int a, int b)
    {
        clickOperation(a, b, '+');
        String s = getLastNumber(getAnswer());
        int r = (int) Double.parseDouble(s);
        assertEquals(a + b, r);
    }

    /**
     * Test subtract.
     * 
     * @param a
     *            Left operand
     * @param b
     *            Right operand
     */
    private void testSubtract(int a, int b)
    {
        clickOperation(a, b, '-');
        String s = getLastNumber(getAnswer());
        int r = (int) Double.parseDouble(s);
        assertEquals(a - b, r);
    }

    /**
     * Test multiply.
     * 
     * @param a
     *            Left operand
     * @param b
     *            Right operand
     */
    private void testMultiply(int a, int b)
    {
        clickOperation(a, b, '*');
        String s = getLastNumber(getAnswer());
        int r = (int) Double.parseDouble(s);
        assertEquals(a * b, r);
    }

    /**
     * Test divide.
     * 
     * @param a
     *            Left operand
     * @param b
     *            Right operand
     */
    private void testDivide(int a, int b)
    {
        clickOperation(a, b, '/');
        String s = getAnswer();
        if (b != 0)
        {
            int r = (int) Double.parseDouble(getLastNumber(s));
            assertEquals(a / b, r);
        }
        else
        {
            assertTrue(s.toLowerCase().indexOf("error") >= 0);
        }
    }

    /**
     * Test Nonnumeric.
     * 
     * @param a Left operand
     * @param b Right operand
     * @param op Operator
     */
    private void testNonnumeric(String a, String b, char op)
    {
        clickNonnumeric(a, b, op);
        String s = getAnswer();
        assertTrue(s.toLowerCase().indexOf("error") >= 0);
    }
}
