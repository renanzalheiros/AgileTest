package zalho.com.br.loginmvvmexampleapp;

import android.os.SystemClock;
import android.support.test.espresso.NoMatchingViewException;
import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.ViewAssertion;
import android.support.test.espresso.matcher.BoundedMatcher;
import android.support.test.internal.util.Checks;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import zalho.com.br.loginmvvmexampleapp.view.adapter.TrocaHumorAdapter;
import zalho.com.br.loginmvvmexampleapp.view.viewholder.TrocaHumorViewHolder;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnHolderItem;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItem;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.hasSibling;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.view.View.FIND_VIEWS_WITH_TEXT;
import static org.hamcrest.core.AllOf.allOf;

/**
 * Created by andre on 17/04/2017.
 */

@RunWith(AndroidJUnit4.class)
public class TrocaHumorInstrumentedTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void humorChangeTest(){
        // passar pelo login
        onView(withId(R.id.et_login))
                .perform(typeText("salsa@loginmvvm.com"), closeSoftKeyboard());

        onView(withId(R.id.et_senha))
                .perform(typeText("123qwe"), closeSoftKeyboard());

        onView(withId(R.id.btn_entrar)).perform(click());
        SystemClock.sleep(3000);

        //passou pelo login

        onView(withId(R.id.btn_troca_humor)).perform(click());
        SystemClock.sleep(5000);
//        onView(withId(R.id.rv_selecao_humor)).perform(actionOnHolderItem(withSubject("Feliz"), click()));
        onView(allOf(withId(R.id.texto_troca_humor), withText("Feliz"))).perform(click());
        onView(withId(R.id.rv_timeline));
        SystemClock.sleep(2000);
    }

//    public static Matcher<RecyclerView.ViewHolder> withSubject(final String text){
//        Checks.checkNotNull(text);
//        return new BoundedMatcher<RecyclerView.ViewHolder, TrocaHumorViewHolder>(TrocaHumorViewHolder.class) {
//            @Override
//            public void describeTo(Description description) {
//                description.appendText("item with subject: " + text);
//            }
//
//            @Override
//            protected boolean matchesSafely(TrocaHumorViewHolder item) {
//                TextView tv_eventoHumor = (TextView) item.itemView.findViewById(R.id.texto_troca_humor);
//                if(tv_eventoHumor == null){
//                    return false;
//                }
//                return tv_eventoHumor.getText().toString().contains(text);
//            }
//        };
//    }

//    public static ViewAssertion hasViewWithTextAtPosition(final int index, final CharSequence text) {
//        return new ViewAssertion() {
//            @Override public void check(View view, NoMatchingViewException e) {
//                if (!(view instanceof RecyclerView)) {
//                    throw e;
//                }
//                RecyclerView rv = (RecyclerView) view;
//                ArrayList<View> outviews = new ArrayList<>();
//                rv.findViewHolderForAdapterPosition(index).itemView.findViewsWithText(outviews, text,
//                        FIND_VIEWS_WITH_TEXT);
//                Truth.assert_().withFailureMessage("There's no view at index "+ index + " of recyclerview that has text : "+ text)
//                        .that(outviews).isNotEmpty();
//            }
//        };
//    }
}
