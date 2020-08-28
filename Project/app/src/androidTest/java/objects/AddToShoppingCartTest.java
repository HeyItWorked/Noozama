package objects;
import android.content.ComponentName;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.intent.Intents;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.rule.ActivityTestRule;
import androidx.test.filters.LargeTest;
import group7.noozama.R;
import group7.noozama.UI.Homepage;
import group7.noozama.UI.ItemPage;
import group7.noozama.UI.PaymentPage;

import androidx.test.platform.app.InstrumentationRegistry;
import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.anything;

@RunWith(AndroidJUnit4ClassRunner.class)
@LargeTest
public class AddToShoppingCartTest {
    private int amountAdded;
    private int recyclerViewId = R.id.recyclerView;
    private int spinnerId = R.id.spinner;

    @Rule
    public ActivityTestRule<Homepage> activityRule = new ActivityTestRule<>(Homepage.class);
    @Before
    public void init() {
        amountAdded = 5;
    }
    private Matcher<View> hasValueEqualTo(final String content) {

        return new TypeSafeMatcher<View>() {

            @Override
            public void describeTo(org.hamcrest.Description description) {

            }

            @Override
            public boolean matchesSafely(View view) {
                if (!(view instanceof TextView) && !(view instanceof EditText)) {
                    return false;
                }
                if (view != null) {
                    String text;
                    if (view instanceof TextView) {
                        text = ((TextView) view).getText().toString();
                    } else {
                        text = ((EditText) view).getText().toString();
                    }

                    return (text.equalsIgnoreCase(content));
                }
                return false;
            }
        };
    }
    @Test
    public void itemAddedToCart(){
        onView(withId(spinnerId)).perform(click());
        onData(anything()).atPosition(3).perform(click());
        onView(withId(recyclerViewId)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        for(int i = 1; i < amountAdded; i++) {
            onView(withId(R.id.plusButton)).perform(click());
        }
        onView(withId(R.id.addToCartConstraint)).perform(click());
        onView(withId(R.id.viewCart)).check(matches(isDisplayed()));
    }

    @Test
    public void goToItemPage(){
        Intents.init();
        onView(withId(spinnerId)).perform(click());
        onData(anything()).atPosition(3).perform(click());
        onView(withId(recyclerViewId)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        intended(hasComponent(new ComponentName(InstrumentationRegistry.getInstrumentation().getTargetContext(), ItemPage.class)));
        Intents.release();
    }

    @Test
    public void goToCheckout(){
        Intents.init();
        onView(withId(spinnerId)).perform(click());
        onData(anything()).atPosition(3).perform(click());
        onView(withId(recyclerViewId)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        for(int i = 1; i < amountAdded; i++) {
            onView(withId(R.id.plusButton)).perform(click());
        }
        onView(withId(R.id.addToCartConstraint)).perform(click());
        onView(withId(R.id.viewCart)).perform(click());
        intended(hasComponent(new ComponentName(InstrumentationRegistry.getInstrumentation().getTargetContext(), PaymentPage.class)));
        Intents.release();
    }
    public void tipThePackager(){
        Intents.init();
        onView(withId(spinnerId)).perform(click());
        onData(anything()).atPosition(3).perform(click());
        onView(withId(recyclerViewId)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        for(int i = 1; i < amountAdded; i++) {
            onView(withId(R.id.plusButton)).perform(click());
        }
        onView(withId(R.id.addToCartConstraint)).perform(click());
        onView(withId(R.id.viewCart)).perform(click());
        onView(withId(R.id.two)).perform(click());
        onView(withId(R.id.price3)).check(matches(hasValueEqualTo("2.00")));
        Intents.release();
    }
}
