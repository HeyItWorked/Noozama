package objects;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.rule.ActivityTestRule;
import androidx.test.filters.LargeTest;
import group7.noozama.R;
import group7.noozama.UI.Homepage;
import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withSpinnerText;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.containsString;

@RunWith(AndroidJUnit4ClassRunner.class)
@LargeTest
public class SortBySalesTest {
    private String chosenLabel;
    private String saleItem;
    private RecyclerView recyclerView;
    private int itemCount;
    private int recyclerViewId = R.id.recyclerView;
    @Rule
    public ActivityTestRule<Homepage> activityRule = new ActivityTestRule<>(Homepage.class);
    @Before
    public void init() {
        chosenLabel = "sale";
        saleItem = "Toiletpaper";
        recyclerView = activityRule.getActivity().findViewById(recyclerViewId);
    }
    public static objects.RecyclerViewMatcher withRecyclerView(final int recyclerViewId) {
        return new objects.RecyclerViewMatcher(recyclerViewId);
    }
    @Test
    public void sortForSalesItem() {
        onView(withId(R.id.spinner)).perform(click());
        onData(anything()).atPosition(3).perform(click());
        onView(withId(R.id.spinner)).check(matches(withSpinnerText(containsString(chosenLabel))));
    }
    @Test
    public void checkTag(){
        onView(withId(R.id.spinner)).perform(click());
        onData(anything()).atPosition(3).perform(click());
        onView(new objects.RecyclerViewMatcher(recyclerViewId).atPositionOnView(0, R.id.itemName)).check(matches(withText(saleItem)));
    }
    @Test
    public void recyclerViewDisplay(){
        onView(withId(R.id.spinner)).perform(click());
        onData(anything()).atPosition(3).perform(click());
        itemCount = recyclerView.getAdapter().getItemCount();
        for(int i = 0; i < itemCount; i++) {
            onView(withId(recyclerViewId)).perform(RecyclerViewActions.scrollToPosition(i));
            onView(new objects.RecyclerViewMatcher(recyclerViewId).atPositionOnView(i, R.id.cardView)).check(matches(isDisplayed()));
            if(i == 9) {
                onView(new objects.RecyclerViewMatcher(recyclerViewId).atPositionOnView(9, R.id.itemName)).check(matches(withText("Bench")));
            }
        }
    }
}
