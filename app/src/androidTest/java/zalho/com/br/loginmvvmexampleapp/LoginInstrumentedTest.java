package zalho.com.br.loginmvvmexampleapp;

import android.os.SystemClock;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class LoginInstrumentedTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void loginFail(){
        onView(withId(R.id.et_login))
                .perform(typeText("zalho@loginmvvm.com"), closeSoftKeyboard());

        onView(withId(R.id.et_senha))
                .perform(typeText("123456"), closeSoftKeyboard());

        onView(withId(R.id.btn_entrar)).perform(click());
        SystemClock.sleep(3000);

        try{
            onView(withId(R.id.rv_timeline)).check(doesNotExist());
            assertTrue(true);
        } catch (Exception e){
            assertFalse(true);
        }
    }

    @Test
    public void loginSuccess() {
        // Context of the app under test.
//        Context appContext = InstrumentationRegistry.getTargetContext();

        onView(withId(R.id.et_login))
                .perform(typeText("salsa@loginmvvm.com"), closeSoftKeyboard());

        onView(withId(R.id.et_senha))
                .perform(typeText("123456"), closeSoftKeyboard());

        onView(withId(R.id.btn_entrar)).perform(click());
        SystemClock.sleep(3000);

        try{
            onView(withId(R.id.rv_timeline)).check(matches(isDisplayed()));
            assertTrue(true);
        } catch (Exception e) {
            assertFalse(true);
        }

    }
}
