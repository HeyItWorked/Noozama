import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import objects.AddToShoppingCartTest;
import objects.SearchItemTest;
import objects.SortBySalesTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    SortBySalesTest.class,
    SearchItemTest.class,
    AddToShoppingCartTest.class
})
public class AllAcceptanceTests {
}
