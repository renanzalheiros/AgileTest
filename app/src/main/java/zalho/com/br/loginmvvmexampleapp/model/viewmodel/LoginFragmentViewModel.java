package zalho.com.br.loginmvvmexampleapp.model.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

import rx.Subscription;
import rx.functions.Action1;
import rx.subscriptions.CompositeSubscription;
import zalho.com.br.loginmvvmexampleapp.MainActivity;
import zalho.com.br.loginmvvmexampleapp.R;
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
    private LoginManager loginManager;

    public LoginFragmentViewModel(Login login) {
        this.login = login;
        campoLogin = new ObservableField<>(login.getLogin());
        campoSenha = new ObservableField<>(login.getSenha());
        subscriptions = new CompositeSubscription();
    }

    public void onResume(LoginManager manager){
        this.loginManager = manager;
    }

    public void setCampoLogin(String campoLogin) {
        this.campoLogin.set(campoLogin);
    }

    public void setCampoSenha(String campoSenha) {
        this.campoSenha.set(campoSenha);
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
                public void call(String email) {
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

    }
}
