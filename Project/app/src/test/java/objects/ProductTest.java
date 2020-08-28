package objects;

import group7.noozama.dso.Product;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class ProductTest{
    Product product;


    @Before
    public void setup(){
        product = new Product( "Shoe", "S4KF04", "This is a shoe.", 4.99, "clothes" );
    }


    @Test
    public void testConstructor(){
        System.out.println("\nStarting TestConstructor");
        assertNotNull( product );
    }


    @Test
    public void testGetName(){
        System.out.println("\nStarting TestGetName");
        assertTrue("Shoe".equals( product.getName() )  );
    }


    @Test
    public void testGetID(){
        System.out.println("\nStarting TestGetID");
        assertTrue("S4KF04".equals( product.getID() )  );
    }


    @Test
    public void testGetDescription(){
        System.out.println("\nStarting TestGetDescription");
        assertTrue("This is a shoe.".equals( product.getDescription() )  );
    }


    @Test
    public void getPrice(){
        System.out.println("\nStarting TestPrice");
        assertTrue( 4.99 == product.getPrice()  );
    }

    @Test
    public void getLabel(){
        System.out.println("\nStarting TestLabel");
        assertTrue( "clothes".equals(product.getLabel() ) );
    }

    @Test
    public void testSetName(){
        System.out.println("\nStarting TestSetName");
        Product pro = new Product( "Shoe", "S4KF04", "This is a shoe.", 4.99, "clothes" );
        pro.setName("Grape");
        assertTrue("Grape".equals( pro.getName() )  );
    }

    @Test
    public void testSetID(){
        System.out.println("\nStarting TestSetID");
        Product pro = new Product( "Shoe", "S4KF04", "This is a shoe.", 4.99, "clothes" );
        pro.setID("12345");
        assertTrue("12345".equals( pro.getID() )  );
    }

    @Test
    public void testSetDescription(){
        System.out.println("\nStarting TestSetDescription");
        Product pro = new Product( "Shoe", "S4KF04", "This is a shoe.", 4.99, "clothes" );
        pro.setDescription("No shoe here");
        assertTrue("No shoe here".equals( pro.getDescription() )  );
    }


    @Test
    public void testSetPrice(){
        System.out.println("\nStarting TestSetPrice");
        Product pro = new Product( "Shoe", "S4KF04", "This is a shoe.", 4.99, "clothes" );
        pro.setPrice(800.00);
        assertTrue( 800.00 == pro.getPrice() );
    }

    @Test
    public void testSetLabel(){
        System.out.println("\nStarting TestLabel");
        Product pro = new Product( "Shoe", "S4KF04", "This is a shoe.", 4.99, "clothes" );
        pro.setLabel("Car");
        assertTrue("Car".equals( pro.getLabel() )  );
    }

    @Test
    public void testStartSale(){
        System.out.println("\nStarting testStartSale");
        Product pro = new Product( "Shoe", "S4KF04", "This is a shoe.", 4.99, "clothes" );
        pro.startSale(60.99);
        assertTrue( 60.99 == pro.getPrice() );
        assertFalse( pro.getPrice() == 4.99);
    }

}