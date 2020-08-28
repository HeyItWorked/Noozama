package group7.noozama.dso;

import io.realm.RealmObject;

public class User extends RealmObject {
    private String name;
    private String username;
    private String password;
    private String email;
    private String address;
    //payments
    //track orders
    public User(){}

    public User( String name, String username, String password, String email, String address){
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.address = address;
    }

    //getter methods
    public String getName(){ return name; };
    public String getUsername(){ return username; };
    public String getPassword(){ return password; };
    public String getEmail(){ return email; }
    public String getAddress(){ return address; };

}
