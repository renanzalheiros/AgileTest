package zalho.com.br.loginmvvmexampleapp.manager;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

import zalho.com.br.loginmvvmexampleapp.model.entidades.Login;
import zalho.com.br.loginmvvmexampleapp.service.LoginService;

/**
 * Created by andre on 03/03/2017.
 */

public class LoginManager {

    private LoginService loginService;

    public LoginManager() {
        this.loginService = new LoginService();
    }

    public Task<AuthResult> realizaLogin(Login login){
        return loginService.verificaCredenciais(login);
    }
}
