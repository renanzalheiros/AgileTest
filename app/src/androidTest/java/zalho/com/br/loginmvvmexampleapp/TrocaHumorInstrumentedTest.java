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
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
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

        //clicar no botão trocar humor na tela timeline
        onView(withId(R.id.btn_troca_humor)).perform(click());
        SystemClock.sleep(5000);

        //clicar no view holder referente ao texto "Feliz" na tela de troca de humor
//        onView(withId(R.id.rv_selecao_humor)).perform(actionOnHolderItem(withSubject("Feliz"), click()));
        onView(allOf(withId(R.id.texto_troca_humor), withText("Feliz"))).perform(click());
        SystemClock.sleep(2000);

        //verificar se o primeiro item da lista na tela de timeline é o humor selecionado na tela anterior
        onView(withRecyclerView(R.id.rv_timeline).atPosition(0)).check(matches(hasDescendant(withText("Feliz"))));
        SystemClock.sleep(2000);
    }

    public static RecyclerViewMatcher withRecyclerView(final int recyclerViewId){
        return new RecyclerViewMatcher(recyclerViewId);
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
