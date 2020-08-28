import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import objects.CartTests;
import objects.StubDatabaseTest;
import objects.CartItemTests;
import objects.ProductTest;
import objects.UserTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CartItemTests.class,
        CartTests.class,
        StubDatabaseTest.class,
        ProductTest.class,
        UserTest.class
})

public class AllUnitTests
{

}
