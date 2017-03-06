package zalho.com.br.loginmvvmexampleapp.view.viewmodel;

import android.app.Activity;
import android.databinding.BaseObservable;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

import zalho.com.br.loginmvvmexampleapp.MainActivity;
import zalho.com.br.loginmvvmexampleapp.R;
import zalho.com.br.loginmvvmexampleapp.model.Login;
import zalho.com.br.loginmvvmexampleapp.service.LoginService;
import zalho.com.br.loginmvvmexampleapp.view.fragments.DashboardFragment;

/**
 * Created by andre on 24/02/2017.
 */

public class LoginFragmentViewModel extends BaseObservable {

    public ObservableField<String> campoLogin;
    public ObservableField<String> campoSenha;

    private Login login;
    private LoginService loginService;

    public LoginFragmentViewModel(Login login) {
        this.login = login;
        campoLogin = new ObservableField<>(login.getLogin());
        campoSenha = new ObservableField<>(login.getSenha());
    }

    public void setCampoLogin(String campoLogin) {
        this.campoLogin.set(campoLogin);
    }

    public void setCampoSenha(String campoSenha) {
        this.campoSenha.set(campoSenha);
    }

    public void onClickLogin(final View view){
        login.setLogin(campoLogin.get());
        login.setSenha(campoSenha.get());
//        Log.i("Salsa", "onClickLogin: "+ login.getLogin());
//        Log.i("Salsa", "onClickLogin: "+ login.getSenha());

        loginService = new LoginService();
        Task<AuthResult> authResultTask = loginService.realizaLogin(login);

        authResultTask.addOnCompleteListener((MainActivity) view.getContext(), new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    FragmentTransaction ft = ((MainActivity) view.getContext()).getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.frame_layout_app, new DashboardFragment());
                    ft.commit();
                }
            }
        });
    }
}
