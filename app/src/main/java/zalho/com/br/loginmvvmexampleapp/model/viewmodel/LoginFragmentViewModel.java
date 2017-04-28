package zalho.com.br.loginmvvmexampleapp.model.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.ObservableField;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.kelvinapps.rxfirebase.RxFirebaseDatabase;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;
import rx.subscriptions.CompositeSubscription;
import zalho.com.br.loginmvvmexampleapp.MainActivity;
import zalho.com.br.loginmvvmexampleapp.manager.LoginManager;
import zalho.com.br.loginmvvmexampleapp.model.entidades.Login;
import zalho.com.br.loginmvvmexampleapp.view.fragments.TimelineFragment;

/**
 * Created by andre on 24/02/2017.
 */

public class LoginFragmentViewModel extends BaseObservable {

    public ObservableField<String> campoLogin;
    public ObservableField<String> campoSenha;
    private CompositeSubscription subscriptions;

    private Login login;
    @Inject
    LoginManager loginManager;

    public LoginFragmentViewModel() {
        login = new Login();
        campoLogin = new ObservableField<>(login.getLogin());
        campoSenha = new ObservableField<>(login.getSenha());
        subscriptions = new CompositeSubscription();
    }

    public void onResume(){
    }

    public void onClickLogin(final View view){
        //Fechar o teclado;
        InputMethodManager systemService = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        systemService.hideSoftInputFromWindow(view.getWindowToken(), 0);

        if(campoLogin.get() == null){
            Toast.makeText(view.getContext(), "Campo email deve ser preenchido", Toast.LENGTH_SHORT).show();
        } else if(campoSenha.get() == null){
            Toast.makeText(view.getContext(), "Campo senha deve ser preenchido", Toast.LENGTH_SHORT).show();
        } else if(!loginManager.validaEmail(campoLogin.get())){
            Toast.makeText(view.getContext(), "Insira um email válido", Toast.LENGTH_SHORT).show();
        } else if(!loginManager.validaSenha(campoSenha.get())){
            Toast.makeText(view.getContext(), "Campo senha deve ter entre 5 e 10 caracteres", Toast.LENGTH_SHORT).show();
        } else {
            login.setLogin(campoLogin.get());
            login.setSenha(campoSenha.get());

//            Task<AuthResult> authResultTask = loginManager.realizaLogin(this.login);
//            if(retornoLogin.equals("loginSuccess")){
//                ((MainActivity) view.getContext()).navegarPara(TimelineFragment.class);
//            } else if(retornoLogin.equals("loginFail")){
//                Snackbar.make(view, "Email ou senha inválidos", Snackbar.LENGTH_LONG).show();
//            }
//            authResultTask.addOnCompleteListener((MainActivity) view.getContext(), new OnCompleteListener<AuthResult>() {
//                @Override
//                public void onComplete(@NonNull Task<AuthResult> task) {
//                    if(task.isSuccessful()){
//                        ((MainActivity) view.getContext()).navegarPara(TimelineFragment.class);
//                    } else {
////                        Toast.makeText(view.getContext(), "Login ou senha inválidos", Toast.LENGTH_LONG).show();
//                        Snackbar snackbar = Snackbar.make(view, "Email ou senha incorretos", Snackbar.LENGTH_SHORT);
//                        snackbar.show();
//                    }
//                }
//            });

            Subscription subscription = loginManager.realizaLogin(login).subscribe(new Action1<String>() {
                @Override
                public void call(String userId) {
                    ((MainActivity) view.getContext()).navegarPara(TimelineFragment.class);
                }
            }, new Action1<Throwable>() {
                @Override
                public void call(Throwable throwable) {
                    Snackbar.make(view, "Email ou senha incorretos", Snackbar.LENGTH_LONG).show();
                }
            });

            subscriptions.add(subscription);
        }
    }

    public void onStop() {
        subscriptions.unsubscribe();
    }
}
