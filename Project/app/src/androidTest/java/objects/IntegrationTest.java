package objects;

import org.junit.Test;
import group7.noozama.database.StubDatabase;
import group7.noozama.dso.ShoppingCart;
import group7.noozama.dso.CartItem;

import static org.junit.Assert.*;

public class IntegrationTest{
  
  @Test
  public void testChangeDBProductName(){
        StubDatabase db=new StubDatabase();

        db.getProduct(0).setName("FindMe");
        assertTrue(db.findProduct("FindMe")!=null);
        assertTrue(db.findProduct("FindMe").getName()=="FindMe");
 
  }
  
  @Test
  public void testAddDBProductToCart(){
    StubDatabase db=new StubDatabase();
    ShoppingCart sc=new ShoppingCart();
    assertTrue(sc.addToCart(new CartItem(db.getProduct(0),1)));
    assertTrue(sc.findInCart(db.getProduct(0))!=null);
  }


}
