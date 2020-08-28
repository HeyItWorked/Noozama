package objects;
import org.junit.Test;
import group7.noozama.dso.CartItem;
import group7.noozama.dso.Product;
import static org.junit.Assert.assertTrue;

public class CartItemTests{
  @Test
  public void testGetters(){
    Product p=new Product( "Sock", "s1", "Jacquard-knit socks in a soft cotton blend with elastication at top.", 4.99, "clothes" );
    CartItem ci= new CartItem(p,1);
    assertTrue(ci.getQuantity()==1);
    assertTrue(ci.getProduct()==p);
  }

  @Test
  public void testSetters(){
    Product p=new Product( "Sock", "s1", "Jacquard-knit socks in a soft cotton blend with elastication at top.", 4.99, "clothes" );
    CartItem ci= new CartItem(p,1);
    ci.changeQuantity(2);
    assertTrue(ci.getQuantity()==2);
  }
}
