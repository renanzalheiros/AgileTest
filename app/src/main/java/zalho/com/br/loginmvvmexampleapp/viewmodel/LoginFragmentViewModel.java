package zalho.com.br.loginmvvmexampleapp.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;
import android.util.Log;
import android.view.View;

import zalho.com.br.loginmvvmexampleapp.model.Login;

/**
 * Created by andre on 24/02/2017.
 */

public class LoginFragmentViewModel extends BaseObservable {

    public ObservableField<String> campoLogin;
    public ObservableField<String> campoSenha;

    private Login login;

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

    public void onClickLogin(View view){
        login.setLogin(campoLogin.get());
        login.setSenha(campoSenha.get());
        Log.i("Salsa", "onClickLogin: "+ login.getLogin());
        Log.i("Salsa", "onClickLogin: "+ login.getSenha());
    }
}
