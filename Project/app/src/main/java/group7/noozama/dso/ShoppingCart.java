package group7.noozama.dso;
import java.util.ArrayList;

public class ShoppingCart{
    private ArrayList<CartItem> cart= new ArrayList<CartItem>();
    private int cartTotal=0;
    private double cartPrice=0;

    public ShoppingCart(){
    }

    public ArrayList<CartItem> getCart() {
        return cart;
    }

    public boolean addToCart(CartItem ci){
        if(!cart.contains(ci)) {
            cart.add(ci);
            cartPrice+=cart.get(cart.indexOf(ci)).getProduct().getPrice() * ci.getQuantity();
            cartTotal++;
            return true;
        }else{
            System.out.println("The product is already in the cart, to add more change the quantity.");
            return false;
        }
    }

    public CartItem findInCart(Product p){
        CartItem found=null;
        for(int i=0;i<cart.size();i++){
            if(cart.get(i).getProduct()==p){
                found=cart.get(i);
            }

        }
        return found;
    }



    public boolean removeFromCart(CartItem ci){
        if(cart.contains(ci)) {
            cartTotal=cartTotal-cart.get(cart.indexOf(ci)).getQuantity();
            cartPrice=cartPrice-(cart.get(cart.indexOf(ci)).getProduct().getPrice()*cart.get(cart.indexOf(ci)).getQuantity());
            cart.remove(ci);
            return true;
        }else{
            System.out.println("The item is not in the cart.");
            return false;
        }
    }
    
    public boolean itemQuantity(int i,CartItem ci){
        if(cart.contains(ci)) {
            if(i<=0){
              removeFromCart(ci);
            }else{
              cartTotal+=(i-cart.get(cart.indexOf(ci)).getQuantity());
              cartPrice+=(cart.get(cart.indexOf(ci)).getProduct().getPrice()*(i-cart.get(cart.indexOf(ci)).getQuantity()));
              cart.get(cart.indexOf(ci)).changeQuantity(i);
            }
            return true;
        }else{
            System.out.println("The product is not in the cart");
            return false;
        }
    }
    
    public int returnTotal(){
      return cartTotal;
    }
    
    public double returnCartPrice(){
        return cartPrice;
    }

}
