package group7.noozama.logic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import group7.noozama.R;
import group7.noozama.dso.CartItem;
import group7.noozama.dso.Product;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder>{
    private List<CartItem> cartItems;
    private Context context;
    private View v;

    public CartAdapter(List<CartItem> cartItems, Context context) {
        this.cartItems = cartItems;
        this.context = context;
    }

    @NonNull
    @Override
    public CartAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CartItem cartItem = cartItems.get(position);
        Product product = cartItem.getProduct();
        holder.itemName.setText(product.getName());
        double price = cartItem.getQuantity() * product.getPrice();
        holder.itemQuantity.setText(Integer.toString(cartItem.getQuantity()));
        holder.totalPrice.setText(String.format("%.2f",price));
    }

    @Override
    public int getItemCount() {
        return cartItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView itemName, itemQuantity, totalPrice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.name);
            itemQuantity = itemView.findViewById(R.id.quantity);
            totalPrice = itemView.findViewById(R.id.price);
        }
    }
}
