package zalho.com.br.loginmvvmexampleapp.model.manager;

import android.util.Patterns;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Action1;
import zalho.com.br.loginmvvmexampleapp.model.entidades.Login;
import zalho.com.br.loginmvvmexampleapp.service.LoginService;

/**
 * Created by andre on 03/03/2017.
 */

public class LoginManager {

    @Inject
    LoginService loginService;

    public LoginManager() {
    }

    public Observable<String> realizaLogin(Login login) {
        return verificaCredenciais(login);
//        String first = loginService.verificaCredenciais(login.getLogin(), login.getSenha()).toBlocking().first();
    }

    protected Observable<String> verificaCredenciais(Login login) {
        return loginService.verificaCredenciais(login);
    }

    public boolean validaEmail(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public boolean validaSenha(String senha) {
        return senha.length() > 5 && senha.length() < 10;
    }
}
