package group7.noozama.UI;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import group7.noozama.R;
import group7.noozama.database.RealmDatabase;
import group7.noozama.dso.User;
import io.realm.Realm;

public class UserScreen extends AppCompatActivity {
    private TextView name, username, password, email, address, logOut;
    private List<User> userList;
    private Realm realm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_screen);
        logOut = findViewById(R.id.logOut);
        SpannableString content = new SpannableString("Log Out");
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        logOut.setText(content);
        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),SplashScreen.class);
                startActivity(i);
            }
        });
        name = findViewById(R.id.name);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        email = findViewById(R.id.email);
        address = findViewById(R.id.address);
        if(RealmDatabase.dataSwitch != 1) {
            userList = RealmDatabase.stubDatabase.getUserList();

            name.setText(userList.get(0).getName());
            username.setText(userList.get(0).getUsername());
            password.setText(userList.get(0).getPassword());
            email.setText(userList.get(0).getEmail());
            address.setText(userList.get(0).getAddress());
        }
        else{
            realm = Realm.getDefaultInstance();
            userList = new ArrayList<>();
            userList.addAll(realm.copyFromRealm(realm.where(User.class).findAll()));

            name.setText(userList.get(0).getName());
            username.setText(userList.get(0).getUsername());
            password.setText(userList.get(0).getPassword());
            email.setText(userList.get(0).getEmail());
            address.setText(userList.get(0).getAddress());
        }
    }
    public void goBack(View view){
        Intent i = new Intent(getApplicationContext(), Homepage.class);
        startActivity(i);
    }
}
