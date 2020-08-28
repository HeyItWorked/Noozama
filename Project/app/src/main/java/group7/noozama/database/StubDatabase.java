package group7.noozama.database;

import java.util.ArrayList;
import java.util.List;

import group7.noozama.dso.Product;
import group7.noozama.dso.User;

public class StubDatabase {
 //arrayList of products
    private List<Product> database = new ArrayList<Product>();
    private List<String> category = new ArrayList<>();
    private List<User> userList = new ArrayList<>();
    public StubDatabase() {
        //add products to the list
        addAllProducts();
        addAllUsers();
        category.add("none");
        addCategory();
    }
 
 
    //add the hardcoded products to the list
    private void addAllProducts(){
    //add some random products
        database.add( new Product( "Sock", "s1", "Jacquard-knit socks in a soft cotton blend with elastication at top.", 4.99,  "clothes") );
        database.add( new Product( "Shirt", "s2", "Regular Fit – a classic fit with good room for movement and a gently shaped waist.", 39.99, "clothes" ) );
        database.add( new Product( "Shoe", "s3", "Chelsea boots with elastic panels at sides and a loop at back.", 59.99, "clothes" ) );
        database.add( new Product( "Hat", "s4", "Hat in crocheted paper straw.", 19.99, "clothes" ) );
        database.add( new Product( "Hoodie", "s5", "Long-sleeved sweatshirt in soft fabric with a lined drawstring hood, kangaroo pocket.", 24.99, "clothes" ) );
        database.add( new Product( "Sweatshirt", "s6", "Soft sweatshirt with a slightly looser fit.", 14.99, "clothes" ) );
        database.add( new Product( "Jacket", "s7", "Soft sweatshirt with a slightly looser fit.", 79.99, "clothes" ) );
        database.add( new Product( "Coat", "s8", "Straight-cut, double-breasted coat in felted wool-blend fabric.", 129.99, "clothes" ) );
        database.add( new Product( "Cardigan", "s9", "Fine-knit cardigan in cotton with a shawl collar, buttons at front.", 49.99, "clothes" ) );
        database.add( new Product( "Blazer", "s10", "Single-breasted blazer in woven stretch fabric with narrow, notched lapels.", 79.99, "clothes" ) );
        database.add( new Product( "Shorts", "s11", "5-pocket shorts in washed denim with heavily distressed details.", 34.99, "clothes" ) );
        database.add( new Product( "Banana", "s12", "Bananas are a healthy source of fiber, potassium, vitamin B6, vitamin C, and various antioxidants.", 999.99, "food" ) );
        // update stubDatabase
        database.add( new Product("Lemon","s13","The lemon fruit is an ellipsoid berry surrounded by a green rind, which ripens to yellow, protecting soft yellow segmented pulp.", 599.99,"food"));
        database.add( new Product("Apple","s14","An apple is a sweet, edible fruit produced by an apple tree.", 699.99,"food"));
        database.add( new Product("Watermelon","s15","Watermelon is a plant species in the family Cucurbitaceae, a vine-like flowering plant originating in West Africa.", 799.99,"food"));
        database.add( new Product("Tuna","s16","A tuna is a saltwater fish that belongs to the tribe Thunnini, a subgrouping of the Scombridae (mackerel) family.", 199.99,"food"));
        database.add( new Product("Noodle","s17","Noodles are a type of food made from unleavened dough which is rolled flat and cut, stretched or extruded, into long strips or strings.", 299.99,"food"));
        database.add( new Product("Rice","s18","Rice is the seed of the grass species Oryza sativa (Asian rice) or Oryza glaberrima (African rice). ", 399.99,"food"));
        //MOAR UPDATE!!!
        database.add( new Product( "Toiletpaper", "s19", "Worth more then gold, this item is a artifact from pre covid-19 days before the antivax karens bought them all.", 999.99,  "sale") );
        database.add( new Product( "Speakers", "s20", "These bad boys can fit soo many hours of 80's rock cover band albums in them.", 128.52,  "sale") );
        database.add( new Product( "Perfume", "s21", "Feel like a spring flower with gwyneth paltrow's newest scent.", 86.99,  "sale") );
        database.add( new Product( "onlyFan", "s22", "Just an only fan.", 32.99,  "sale") );
        database.add( new Product( "Mug", "s23", "On the back is a picture of baby yoda.", 18.99,  "sale") );
        database.add( new Product( "Milk", "s24", "Delivered ice cold so you can enjoy all the bone building goodness.", 5.99,  "sale") );
        database.add( new Product( "Chair", "s25", "I mean you can sit on it. What did you expect? It's a chair.", 52.99,  "sale") );
        database.add( new Product( "Calculator", "s26", "Warning, this calculator is non functional and can only display the number 5318008.", 13.99,  "sale") );
        database.add( new Product( "Book", "s27", "This was the book featured in the joker meme that one man bought a ticket for", 9.99,  "sale") );
        database.add( new Product( "Bench", "s28", "A nice bench that can fit more then one person at a time. If only you had someone to share your bench with", 72.99,  "sale") );
        
        
    }
    private void addCategory(){
        if (getSize() != 0){
            for(Product product: database){
                String label = product.getLabel();
                if (!category.contains(label)){
                    category.add(label);
                }
            }
        }
    }
    public Product getProduct(int i){
        Product result = null;

        if ( i < database.size() )
         result = database.get(i);

        return result;
    }

    public Product getProductById(String id){
        if(database.size() > 0){
            for(Product product: database){
                if(product.getID().equals(id)){
                    return product;
                }
            }
        }
        return null;
    }

    public int getSize(){
     return database.size();
 }


 /*return a specific product by name
   iterate through the stubDatabase list and check each entry to see if it's name is the same one the user searched for
   if the product is in the stubDatabase, return true, else return null
 */
    public Product findProduct( String searchName){
        Product result = null;
            for( int i = 0; i < database.size(); i++ ){
                if( searchName.equalsIgnoreCase( database.get(i).getName() ) )
                    result = database.get(i);
            }
        return result;
    }

    public List<Product> getDatabase() {
        return database;
    }
    public List<String> getCategory() {
        return category;
    }
    public List<Product> categorySearch(String input){
        List<Product> query = new ArrayList<>();
        for(Product product: database){
            if((product.getLabel()).equals(input)){
                query.add(product);
            }
        }
        return query;
    }

    private void addAllUsers(){
        userList.add( new User( "Rose Schmidt", "Rose123", "12345", "RoseSchmidt@Gmail.com", "123 Easy Street" ));
    }

    public List<User> getUserList() {
        return userList;
    }
    public boolean userSearch(String name, String pass){
        for(User user: userList){
            if (user.getUsername().equals(name) && user.getPassword().equals(pass)){
                return true;
            }
        }
        return false;
    }
}