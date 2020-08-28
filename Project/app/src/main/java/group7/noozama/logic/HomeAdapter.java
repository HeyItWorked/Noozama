package group7.noozama.logic;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import group7.noozama.R;
import group7.noozama.dso.Product;
import group7.noozama.UI.ItemPage;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {
    private List<Product> storage;
    private View v;
    private Context context;
    public HomeAdapter(List<Product> storage, Context context) {
        this.storage = storage;
        this.context = context;
    }

    public HomeAdapter(Product product, Context context){
        storage = new ArrayList<>();
        storage.add(product);
        this.context = context;
    }
    @NonNull
    @Override
    public HomeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(v);
    }
    @Override
    public void onBindViewHolder(@NonNull HomeAdapter.ViewHolder holder, int position) {
        Product product = storage.get(position);
        holder.itemImage.setImageResource(getImageId(product.getName().toLowerCase()));
        holder.productName.setText(product.getName());
        holder.productDescription.setText(product.getDescription());
        holder.productPrice.setText(Double.toString(product.getPrice()));
    }
    @Override
    public int getItemCount() {
        return storage.size();
    }
    public String getName(int position){
        return storage.get(position).getName();
    }
    public double getPrice(int position){
        return storage.get(position).getPrice();
    }
    public int getImageId(String imageName) {
        return context.getResources().getIdentifier("drawable/" + imageName, null, context.getPackageName());
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView itemImage;
        private TextView productName,productDescription, productPrice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setTag(this);
            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    HomeAdapter.ViewHolder viewHolder = (HomeAdapter.ViewHolder) v.getTag();
                    int position = viewHolder.getAdapterPosition();
                    Intent i = new Intent(v.getContext(),ItemPage.class);
                    i.putExtra("name",storage.get(position).getName());
                    i.putExtra("price",Double.toString(storage.get(position).getPrice()));
                    i.putExtra("id", storage.get(position).getID());
                    v.getContext().startActivity(i);
                }
            });
            itemImage = itemView.findViewById(R.id.itemImage);
            productName = itemView.findViewById(R.id.itemName);
            productDescription = itemView.findViewById(R.id.itemDescription);
            productPrice = itemView.findViewById(R.id.itemPrice);
        }
    }
}
