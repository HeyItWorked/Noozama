package objects;

import android.view.KeyEvent;
import android.view.View;
import android.widget.SearchView;
import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.rule.ActivityTestRule;
import androidx.test.filters.LargeTest;
import group7.noozama.R;
import group7.noozama.UI.Homepage;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.pressKey;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.AllOf.allOf;
@RunWith(AndroidJUnit4ClassRunner.class)
@LargeTest
public class SearchItemTest {
    @Rule
    public ActivityTestRule<Homepage> activityRule = new ActivityTestRule<>(Homepage.class);
    private ViewAction typeSearchViewText(final String text){
        return new ViewAction(){
            @Override
            public Matcher<View> getConstraints() {
                //Ensure that only apply if it is a SearchView and if it is visible.
                return allOf(isDisplayed(), isAssignableFrom(SearchView.class));
            }

            @Override
            public String getDescription() {
                return "Change view text";
            }

            @Override
            public void perform(UiController uiController, View view) {
                ((SearchView) view).setQuery(text,false);
            }
        };
    }
    @Test
    public void itemSearchSuccess(){
        onView(withId(R.id.searchView)).perform(click(),typeSearchViewText("Sock"),pressKey(KeyEvent.KEYCODE_ENTER));
        onView(new objects.RecyclerViewMatcher(R.id.recyclerView).atPositionOnView(0, R.id.itemName)).check(matches(withText("Sock")));
    }
    @Test
    public void itemSearchFail(){
        onView(withId(R.id.searchView)).perform(click(),typeSearchViewText("Garbage"),pressKey(KeyEvent.KEYCODE_ENTER));
        onView(withId(R.id.recyclerView)).check(new objects.RecyclerViewItemCountAssertion(28));
    }
}
