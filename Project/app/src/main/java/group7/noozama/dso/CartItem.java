package group7.noozama.dso;

public class CartItem{
  private Product item;
  private int quantity;
  
  public CartItem(Product i, int q){
    item=i;
    quantity=q;
  }
  
  public void changeQuantity(int c){
    quantity=c;
  }
  
  public int getQuantity(){
    return quantity;
  }
  
  public Product getProduct(){
    return item;
  }
  
}