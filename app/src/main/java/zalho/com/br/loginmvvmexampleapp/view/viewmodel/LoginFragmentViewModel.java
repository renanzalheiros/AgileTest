package zalho.com.br.loginmvvmexampleapp.view.viewmodel;

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

import zalho.com.br.loginmvvmexampleapp.MainActivity;
import zalho.com.br.loginmvvmexampleapp.R;
import zalho.com.br.loginmvvmexampleapp.manager.LoginManager;
import zalho.com.br.loginmvvmexampleapp.model.Login;
import zalho.com.br.loginmvvmexampleapp.view.fragments.TimelineFragment;

/**
 * Created by andre on 24/02/2017.
 */

public class LoginFragmentViewModel extends BaseObservable {

    public ObservableField<String> campoLogin;
    public ObservableField<String> campoSenha;

    private Login login;
    private LoginManager loginManager;

    public LoginFragmentViewModel(Login login) {
        this.login = login;
        campoLogin = new ObservableField<>(login.getLogin());
        campoSenha = new ObservableField<>(login.getSenha());
        loginManager = new LoginManager();
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
        } else if(campoLogin.get().length() < 5){
            Toast.makeText(view.getContext(), "Campo email deve ter pelo menos 5 caracteres", Toast.LENGTH_SHORT).show();
        } else if(campoSenha.get().length() < 6){
            Toast.makeText(view.getContext(), "Campo senha deve ter pelo menos 6 caracteres", Toast.LENGTH_SHORT).show();
        } else {
            login.setLogin(campoLogin.get());
            login.setSenha(campoSenha.get());

            Task<AuthResult> authResultTask = loginManager.realizaLogin(login);

            authResultTask.addOnCompleteListener((MainActivity) view.getContext(), new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        FragmentTransaction ft = ((MainActivity) view.getContext()).getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.frame_layout_app, new TimelineFragment());
                        ft.commit();
                    } else {
//                        Toast.makeText(view.getContext(), "Login ou senha inválidos", Toast.LENGTH_LONG).show();
                        Snackbar snackbar = Snackbar.make(view, "Email ou senha inválidos", Snackbar.LENGTH_SHORT);
                        snackbar.show();
                    }
                }
            });
        }
    }
}
