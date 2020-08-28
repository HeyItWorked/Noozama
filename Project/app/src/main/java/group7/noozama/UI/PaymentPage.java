package group7.noozama.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import group7.noozama.R;
import group7.noozama.database.RealmDatabase;
import group7.noozama.dso.Global;
import group7.noozama.logic.CartAdapter;

public class PaymentPage extends AppCompatActivity implements Global {
    private ImageButton two, three, four;
    private RecyclerView recyclerView;
    private CartAdapter adapter;
    private TextView price1, price3, price4, price5, totalPrice;
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.payment_zone);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        price1 = findViewById(R.id.price1);
        price1.setText(String.format("%.2f",cart.returnCartPrice()));
        price3 = findViewById(R.id.price3);
        price3.setText("0.00");
        double pst = 0.05 * cart.returnCartPrice();
        double gst = 0.07 * cart.returnCartPrice();
        price4 = findViewById(R.id.price4);
        price4.setText(String.format("%.2f",pst));
        price5 = findViewById(R.id.price5);
        price5.setText(String.format("%.2f",gst));
        totalPrice = findViewById(R.id.totalPrice);
        double finalBill = cart.returnCartPrice() * 1.12 + 3.99;
        totalPrice.setText(String.format("%.2f",finalBill));
        recyclerView = findViewById(R.id.shoppingRecycler);
        setupRecycler();
    }
    public void setupRecycler(){
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CartAdapter(cart.getCart(), getApplicationContext());
        recyclerView.setAdapter(adapter);
    }
    public void twoRed(View view){
        two.setImageResource(R.drawable.twored);
        three.setImageResource(R.drawable.three);
        four.setImageResource(R.drawable.four);
        price3.setText("2.00");
        double finalBill = cart.returnCartPrice() * 1.12 + 3.99 + 2;
        totalPrice.setText(String.format("%.2f",finalBill));
    }
    public void threeRed(View view){
        three.setImageResource(R.drawable.threered);
        two.setImageResource(R.drawable.two);
        four.setImageResource(R.drawable.four);
        price3.setText("3.00");
        double finalBill = cart.returnCartPrice() * 1.12 + 3.99 + 3;
        totalPrice.setText(String.format("%.2f",finalBill));
    }
    public void fourRed(View view){
        four.setImageResource(R.drawable.fourred);
        three.setImageResource(R.drawable.three);
        two.setImageResource(R.drawable.two);
        price3.setText("4.00");
        double finalBill = cart.returnCartPrice() * 1.12 + 3.99 + 4;
        totalPrice.setText(String.format("%.2f",finalBill));
    }
    public void goBack(View view){
        Intent i = new Intent(getApplicationContext(),Homepage.class);
        startActivity(i);
    }
    public void noVoucher(View view){
        Toast.makeText(this, "Voucher isn't offered by our store right now. Stay tuned!", Toast.LENGTH_SHORT).show();
    }
}
