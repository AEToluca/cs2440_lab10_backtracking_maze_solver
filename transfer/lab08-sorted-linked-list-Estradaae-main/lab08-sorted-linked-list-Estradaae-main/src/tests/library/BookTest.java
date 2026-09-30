package library;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * JUnit tests for the Book class.
 * 
 * @author Mitch Parry
 * @version 2013-10-01
 */
public class BookTest
{
    /**
     * Check the fields.
     */
    @Test
    public void testFields()
    {
        String[] regexes = {
            "private;java.lang.String;title",
            "private;java.lang.String;author",
            "private;int;numPages"
        };
        MyTesting.checkFields(Book.class, regexes);
    }

    /**
     * Check the constructors.
     */
    @Test
    public void testConstructors()
    {
        String[] regexes = {
            "public;library\\.Book;\\[java.lang.String, "
                + "java.lang.String, int\\]"
        };
        MyTesting.checkConstructors(Book.class, regexes);
    }

    /**
     * Test constructor.
     */
    @Test
    public void testConstructor()
    {
        final int NUM_PAGES = 320;
        Book book = new Book("Michael Lewis", "Moneyball", NUM_PAGES);
        assertEquals("Michael Lewis", book.getAuthor(),
            "Constructor or getAuthor() doesn't work.");
        assertEquals("Moneyball", book.getTitle(),
            "Constructor or getTitle() doesn't work.");
        assertEquals(NUM_PAGES, book.getNumPages(),
            "Constructor or getnumPages() doesn't work.");
    }

    /**
     * Test constructor.
     */
    @Test
    public void testConstuctor2()
    {
        testConstructor();
    }

    /**
     * Test constructor.
     */
    @Test
    public void testConstuctor3()
    {
        testConstructor();
    }

    /**
     * Test constructor.
     */
    @Test
    public void testConstuctor4()
    {
        testConstructor();
    }

    /**
     * Test constructor.
     */
    @Test
    public void testConstuctor5()
    {
        testConstructor();
    }

    /**
     * Test compareTo.
     */
    @Test
    public void testCompareTo1()
    {
        final int NUM_PAGES = 100;
        Book a = new Book("author1", "title1", NUM_PAGES);
        Book b = new Book("author2", "title2", NUM_PAGES);
        assertTrue(a.compareTo(b) < 0,
            "author1, title1 should be less than author2, title2.");
    }

    /**
     * Test compareTo.
     */
    @Test
    public void testCompareTo2()
    {
        final int NUM_PAGES = 100;
        Book a = new Book("author1", "title1", NUM_PAGES);
        Book b = new Book("author1", "title2", NUM_PAGES);
        assertTrue(a.compareTo(b) < 0,
            "author1, title1 should be less than author1, title2.");
    }

    /**
     * Test compareTo.
     */
    @Test
    public void testCompareTo3()
    {
        final int NUM_PAGES = 100;
        Book a = new Book("author1", "title1", NUM_PAGES);
        Book b = new Book("author1", "title1", NUM_PAGES);
        assertTrue(a.compareTo(b) == 0,
            "author1, title1 should equal author1, title1.");
    }

    /**
     * Test compareTo.
     */
    @Test
    public void testCompareTo4()
    {
        final int NUM_PAGES = 100;
        Book a = new Book("author1", "title1", NUM_PAGES);
        Book b = new Book("author2", "title1", NUM_PAGES);
        assertTrue(a.compareTo(b) < 0,
            "author1, title1 should be less than author2, title1.");
    }

    /**
     * Test equals.
     */
    @Test
    public void testEquals1()
    {
        Book a = new Book("author1", "title1", 100);
        Book b = new Book("author1", "title1", 20);
        assertTrue(a.equals(b),
            "author1, title1 should equal author1, title1.");
    }

    /**
     * Test equals.
     */
    @Test
    public void testEquals2()
    {
        final int NUM_PAGES = 100;
        Book a = new Book("author1", "title1", NUM_PAGES);
        Book b = new Book("author1", "title2", NUM_PAGES);
        assertFalse(a.equals(b),
            "author1, title1 should not equal author1, title2.");
    }

    /**
     * Test equals.
     */
    @Test
    public void testEquals3()
    {
        final int NUM_PAGES = 100;
        Book a = new Book("author1", "title1", NUM_PAGES);
        Book b = new Book("author2", "title1", NUM_PAGES);
        assertFalse(a.equals(b),
            "author1, title1 should not equal author1, title2.");
    }

    /**
     * Test equals.
     */
    @Test
    public void testEquals4()
    {
        testEquals1();
    }

    /**
     * Test toString.
     */
    @Test
    public void testToString1()
    {
        final String CORRECT = "author1, title1, 100";
        Book a = new Book("author1", "title1", 100);
        assertEquals(CORRECT, a.toString(),
            "toString() should return \"" + CORRECT + "\"");
    }

    /**
     * Test toString.
     */
    @Test
    public void testToString2()
    {
        testToString1();
    }

    /**
     * Test toString.
     */
    @Test
    public void testToString3()
    {
        testToString1();
    }

    /**
     * Test toString.
     */
    @Test
    public void testToString4()
    {
        testToString1();
    }

    /**
     * Test toString.
     */
    @Test
    public void testToString5()
    {
        testToString1();
    }

}
