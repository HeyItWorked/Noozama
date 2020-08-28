package objects;

import org.junit.Test;

import group7.noozama.dso.CartItem;
import group7.noozama.dso.Product;
import group7.noozama.dso.ShoppingCart;

import static org.junit.Assert.*;


public class CartTests{
  @Test
  public void testEmptyCart(){
    Product p = new Product( "Sock", "s1", "Jacquard-knit socks in a soft cotton blend with elastication at top.", 4.99, "clothes" );
    CartItem ci= new CartItem(p,1);
    ShoppingCart sc= new ShoppingCart();
    assertFalse(sc.removeFromCart(ci));
    assertFalse(sc.itemQuantity(1,ci));
    assertTrue(sc.returnTotal()==0);
    assertTrue(sc.returnCartPrice()==0);
  }

  @Test
  public void testSingleCartItem(){
    Product p=new Product( "Sock", "s1", "Jacquard-knit socks in a soft cotton blend with elastication at top.", 4.99, "clothes" );
    CartItem ci= new CartItem(p,1);
    ShoppingCart sc= new ShoppingCart();
    assertTrue(sc.addToCart(ci));
    assertFalse(sc.addToCart(ci));
    assertTrue(sc.returnTotal()==1);
    assertTrue(sc.returnCartPrice()==4.99);
    assertTrue(sc.itemQuantity(4,ci));
    assertTrue(sc.returnTotal()==4);
    assertTrue(sc.returnCartPrice()==19.96);
  }

  @Test
  public void testRemoveFromCart(){
    Product p=new Product( "Sock", "s1", "Jacquard-knit socks in a soft cotton blend with elastication at top.", 4.99, "clothes" );
    CartItem ci= new CartItem(p,1);
    ShoppingCart sc= new ShoppingCart();
    assertTrue(sc.addToCart(ci));
    assertFalse(sc.removeFromCart(null));
    assertTrue(sc.removeFromCart(ci));
    assertFalse(sc.itemQuantity(1,ci));
    assertTrue(sc.returnTotal()==0);
    assertTrue(sc.returnCartPrice()==0);
  }
}
