package group7.noozama.database;

import android.app.Application;

import java.util.List;

import group7.noozama.dso.Global;
import group7.noozama.dso.Product;
import group7.noozama.dso.ShoppingCart;
import group7.noozama.dso.User;
import io.realm.Realm;

public class RealmDatabase extends Application implements Global {
    private Realm realm;
    private List<Product> productList;
    private List<User> userList;
    @Override
    public void onCreate(){
        super.onCreate();
        // Initialize Realm
        if(dataSwitch == 1){
            Realm.init(this);
            realm = Realm.getDefaultInstance();
            createRealmDatabase();
        }
    }
    private void createRealmDatabase(){
        // Obtain a Realm instance
        realm = Realm.getDefaultInstance();
        //Set up new Realm stubDatabase if it doesn't exist
        if(realm.isEmpty()) {
            productList = stubDatabase.getDatabase();
            userList = stubDatabase.getUserList();
            addtoRealm(productList);
            addtoRealm(userList);
        }
    }
    private void addtoRealm(List list){
        realm.beginTransaction();
        realm.insert(list);
        realm.commitTransaction();
    }
}