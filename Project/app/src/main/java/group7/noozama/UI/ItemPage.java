package group7.noozama.UI;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.text.DecimalFormat;

import group7.noozama.R;
import group7.noozama.dso.CartItem;
import group7.noozama.dso.Global;
import group7.noozama.dso.Product;

import static android.content.ContentValues.TAG;

public class ItemPage extends AppCompatActivity implements Global {
    private TextView numberOfItem, addToCart, itemName, itemPrice;
    private ConstraintLayout addToCartConstraint;
    private double price;
    private String id;
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.item_page);
        numberOfItem = findViewById(R.id.numberOfItem);
        itemName = findViewById(R.id.itemName);
        itemPrice = findViewById(R.id.price);
        numberOfItem.setText("1");
        addToCart = findViewById(R.id.addToCart);
        addToCart.setText("Add 1 item to cart");
        Intent i = getIntent();
        String nameText = i.getStringExtra("name");
        System.out.println(nameText);
        String priceText = i.getStringExtra("price");
        price = Double.parseDouble(priceText);
        System.out.println(priceText);
        itemName.setText(i.getStringExtra("name"));
        itemPrice.setText(Double.toString(price));
        id = i.getStringExtra("id");
        addToCartConstraint = findViewById(R.id.addToCartConstraint);
        addToCartConstraint.setClickable(true);
    }
    public void addToCart(View view){
        Product product = stubDatabase.getProductById(id);
        if(product != null) {
            CartItem cartItem = new CartItem(product, Integer.parseInt(numberOfItem.getText().toString()));
            cart.addToCart(cartItem);
        }
        Intent i = new Intent(this,Homepage.class);
        startActivity(i);
    }
    public void goBack(View view){
        Intent i = new Intent(getApplicationContext(),Homepage.class);
        startActivity(i);
    }
    public void decreaseNumber(View view){
        int i = Integer.parseInt(numberOfItem.getText().toString());
        if(i > 0){
            i -= 1;
            numberOfItem.setText(Integer.toString(i));
            addToCart.setText("Add " + i + " items to cart");
            DecimalFormat df = new DecimalFormat(".##");
            String formatted = df.format(i * price);
            itemPrice.setText(formatted);
        }
    }
    public void increaseNumber(View view){
        int i = Integer.parseInt(numberOfItem.getText().toString());
        i += 1;
        numberOfItem.setText(Integer.toString(i));
        addToCart.setText("Add " + i + " items to cart");
        DecimalFormat df = new DecimalFormat(".##");
        String formatted = df.format(i * price);
        itemPrice.setText(formatted);
    }
}
