package objects;

import org.junit.Test;

import java.util.List;

import group7.noozama.database.StubDatabase;
import group7.noozama.dso.Product;

import static org.junit.Assert.*;

public class StubDatabaseTest {

    @Test
    public void testDatabase1(){
        StubDatabase db;

        System.out.println("\nStarting testDatabase1");

        db = new StubDatabase();

        assertFalse( db.getDatabase().isEmpty() );

    }

    @Test
    public void testDatabase2(){
        StubDatabase db = new StubDatabase();

        System.out.println("\nStarting testDatabase2");

        db = new StubDatabase();

        assertNull(db.getProduct(56) );
        assertNull(db.getProduct(79) );
        assertNull(db.getProduct(100) );

        assertTrue(db.getProduct(5) instanceof Product);
        assertTrue(db.getProduct(8) instanceof Product);
    }

    @Test
    public void testDatabase3(){
        StubDatabase db = new StubDatabase();

        System.out.println("\nStarting testDatabase3");

        assertFalse(db.getSize() == 50);

        assertTrue(db.getSize() == 28);
    }

    @Test
    public void testDatabase4(){
        StubDatabase db = new StubDatabase();

        System.out.println("\nStarting testDatabase4");

        assertTrue(db.findProduct("cargo") == null);
        assertTrue(db.findProduct("trouser") == null);
        assertTrue(db.findProduct("jeans") == null);

        assertFalse(db.findProduct("blazer") == null);
        assertFalse(db.findProduct("banana") == null);
        assertFalse(db.findProduct("hoodie") == null);
    }

    @Test
    public void testDatabase5(){
        StubDatabase db = new StubDatabase();

        System.out.println("\nStarting testDatabase5");

        assertTrue(db.getUserList().size() == 1);
    }

    @Test
    public void testDatabase6(){
        StubDatabase db = new StubDatabase();

        System.out.println("\nStarting testDatabase6");

        assertTrue(db.userSearch("Harry","Potter") == false);
        assertTrue(db.userSearch("Rose123","12345") == true);
    }

    @Test
    public void testDatabase7(){
        StubDatabase db = new StubDatabase();

        System.out.println("\nStarting testDatabase7");
        List<Product> list = db.categorySearch("toys");
        assertTrue(list.size() == 0);
    }

}