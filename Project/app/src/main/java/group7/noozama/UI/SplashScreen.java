package group7.noozama.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;
import java.util.List;

import group7.noozama.R;
import group7.noozama.database.RealmDatabase;
import group7.noozama.dso.User;
import io.realm.Realm;

public class SplashScreen extends AppCompatActivity {
    private EditText usernameLogin, passwordLogin;
    private ConstraintLayout loginZone;
    private List<User> userList = new ArrayList<>();
    private Realm realm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screeen);
        usernameLogin = findViewById(R.id.usernameLogIn);
        passwordLogin = findViewById(R.id.passwordLogIn);
        loginZone = findViewById(R.id.loginZone);
        loginZone.setY(3000);
        final ImageView img = findViewById(R.id.loadingSplash);
        final Animation rotate = AnimationUtils.loadAnimation(getBaseContext(),R.anim.rotate);
        final Animation fade = AnimationUtils.loadAnimation(getBaseContext(),R.anim.abc_fade_out);
        img.startAnimation(rotate);
        rotate.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                img.startAnimation(fade);
                img.animate().alpha(0);
                loginZone.animate().translationYBy(-3000).setDuration(900);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
    public void userSearch(View view){
        if(RealmDatabase.dataSwitch == 0){
            if(RealmDatabase.stubDatabase.userSearch(usernameLogin.getText().toString().trim(),passwordLogin.getText().toString().trim())){
                Intent i = new Intent(getApplicationContext(), Homepage.class);
                startActivity(i);
            }
            else{
                Toast.makeText(this, "Invalid Login Information", Toast.LENGTH_SHORT).show();
            }
        }
        else{
            realm = Realm.getDefaultInstance();
            userList.addAll(realm.copyFromRealm(realm.where(User.class).equalTo("username", usernameLogin.getText().toString().trim()).and().equalTo("password", passwordLogin.getText().toString().trim()).findAll()));
            if (userList.isEmpty()){
                Toast.makeText(this, "Invalid Login Information", Toast.LENGTH_SHORT).show();
            }
            else{
                Intent i = new Intent(getApplicationContext(), Homepage.class);
                startActivity(i);
            }
        }
    }
}
