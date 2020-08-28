package objects;

import org.junit.Before;
import org.junit.Test;
import group7.noozama.dso.User;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class UserTest {
    User user;


    @Before
    public void setup() {
        user = new User( "Rose Schmidt", "Rose123", "12345", "RoseSchmidt@Gmail.com", "123 Easy Street" );
    }

    @Test
    public void testNullConstructor(){
        User myUser = new User();
        String string1 = myUser.getName();
        assertNull(string1);
    }

    @Test
    public void testConstructor(){
        System.out.println("\nStarting TestConstructor");
        assertNotNull( user );
    }


    @Test
    public void testGetName(){
        System.out.println("\nStarting TestGetName");
        assertTrue("Rose Schmidt".equals( user.getName() )  );
    }


    @Test
    public void testGetUsername(){
        System.out.println("\nStarting TestGetUsername");
        assertTrue("Rose123".equals( user.getUsername() )  );
    }


    @Test
    public void testGetPassword(){
        System.out.println("\nStarting TestGetPassword");
        assertTrue("12345".equals( user.getPassword() )  );
    }


    @Test
    public void testGetEmail(){
        System.out.println("\nStarting TestGetEmail");
        assertTrue( "RoseSchmidt@Gmail.com".equals( user.getEmail() ) );
    }

    @Test
    public void testGetAddress(){
        System.out.println("\nStarting TestGetAddress");
        assertTrue( "123 Easy Street".equals( user.getAddress() ) );
    }

}
