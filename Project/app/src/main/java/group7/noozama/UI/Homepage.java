package group7.noozama.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import group7.noozama.R;
import group7.noozama.database.RealmDatabase;
import group7.noozama.dso.Global;
import group7.noozama.dso.Product;

import group7.noozama.logic.HomeAdapter;
import io.realm.Case;
import io.realm.Realm;


public class Homepage extends AppCompatActivity implements Global {
    private RecyclerView recyclerView;
    private HomeAdapter adapter;
    private SearchView searchView;
    private Spinner spinner;
    private ArrayAdapter<String> arrayAdapter;
    private Realm realm;
    private List<Product> list = new ArrayList<>();
    private TextView textView, viewCart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grocery_menu);
        recyclerView = findViewById(R.id.recyclerView);
        setupRecycler();
        searchView = findViewById(R.id.searchView);
        overwriteClose();
        searchItem();
        spinner = findViewById(R.id.spinner);
        setupSpinner();
        overwriteSpinner(spinner);
        textView = findViewById(R.id.logOut);
        viewCart = findViewById(R.id.viewCart);
        viewCart.setClickable(true);
        if(cart.returnTotal() != 0){
            viewCart.setVisibility(View.VISIBLE);
        }
        else {
            viewCart.setVisibility(View.INVISIBLE);
        }
    }
    public void setupRecycler(){
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        if(RealmDatabase.dataSwitch == 1){
            realm = Realm.getDefaultInstance();
            list.addAll(realm.copyFromRealm(realm.where(Product.class).findAll()));
            adapter = new HomeAdapter(list,this);
        }
        else {
            adapter = new HomeAdapter(RealmDatabase.stubDatabase.getDatabase(), this);
        }
        recyclerView.setAdapter(adapter);
    }
    public void setupSpinner(){
        List<String> stringList = new ArrayList<>();
        if(RealmDatabase.dataSwitch != 1) {
            arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, RealmDatabase.stubDatabase.getCategory());
        }
        else{
            list.clear();
            list.addAll(realm.copyFromRealm(realm.where(Product.class).distinct("label").findAll()));
            stringList.add("none");
            for (Product product: list){
                String label = product.getLabel();
                if (!stringList.contains(label)){
                    stringList.add(label);
                }
            }
            arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, stringList);
        }
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setSelection(0);
    }
    public void overwriteSpinner(Spinner spinner){
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String filter = parent.getItemAtPosition(position).toString();
                if(!filter.equals("none")) {
                    if(RealmDatabase.dataSwitch != 1) {
                        adapter = new HomeAdapter(RealmDatabase.stubDatabase.categorySearch(parent.getItemAtPosition(position).toString()), getApplicationContext());
                    }
                    else {
                        list.clear();
                        list.addAll(realm.copyFromRealm(realm.where(Product.class).equalTo("label",filter).findAll()));
                        adapter = new HomeAdapter(list,getApplicationContext());
                    }
                }
                else{
                    if(RealmDatabase.dataSwitch != 1){
                        adapter = new HomeAdapter(RealmDatabase.stubDatabase.getDatabase(),getApplicationContext());
                    }
                    else {
                        list.clear();
                        list.addAll(realm.copyFromRealm(realm.where(Product.class).findAll()));
                        adapter = new HomeAdapter(list,getApplicationContext());
                    }
                }
                recyclerView.setAdapter(adapter);
                textView.setText("Displaying " + adapter.getItemCount() + " Results ");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void searchItem(){
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                String input = query;
                if(RealmDatabase.dataSwitch != 1){
                    Product product = RealmDatabase.stubDatabase.findProduct(input);
                    if(product == null){
                        Toast.makeText(getApplicationContext(), "Item unavailable, please contact customer support", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        adapter = new HomeAdapter(product, getApplicationContext());
                    }
                }
                else{
                    list.clear();
                    list.addAll(realm.copyFromRealm(realm.where(Product.class).equalTo("name", input, Case.INSENSITIVE).findAll()));
                    adapter = new HomeAdapter(list, getApplicationContext());
                }
                recyclerView.setAdapter(adapter);
                textView.setText("Displaying " + adapter.getItemCount() + " Result");
                return false;
            }
            //Abstract method required declaration in order to override implement new SearchView.OnQueryTextListener()
            @Override
            public boolean onQueryTextChange(String newText) {
                spinner.setEnabled(false);
                spinner.setSelection(0);
                return false;
            }
        });
    }
    public void overwriteClose(){
        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                spinner.setSelection(0);
                spinner.setEnabled(true);
                list.clear();
                Realm.init(getApplicationContext());
                realm = realm.getDefaultInstance();
                list.addAll(realm.copyFromRealm(realm.where(Product.class).findAll()));
                adapter = new HomeAdapter(list,getApplicationContext());
                recyclerView.setAdapter(adapter);
                textView.setText("Displaying " + adapter.getItemCount() + " Results");
                return false;
            }
        });
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        if(dataSwitch != 0) {
            realm.close();
        }
    }

    public void profileView(View view){
        Intent i = new Intent(getApplicationContext(),UserScreen.class);
        startActivity(i);
    }
    public void checkout(View view){
        Intent i = new Intent(getApplicationContext(), PaymentPage.class);
        startActivity(i);
    }
}