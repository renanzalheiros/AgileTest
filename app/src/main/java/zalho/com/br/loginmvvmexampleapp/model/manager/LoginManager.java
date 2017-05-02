package zalho.com.br.loginmvvmexampleapp.model.manager;

import android.util.Patterns;

import rx.Observable;
import zalho.com.br.loginmvvmexampleapp.model.entidades.Login;
import zalho.com.br.loginmvvmexampleapp.service.LoginService;

/**
 * Created by andre on 03/03/2017.
 */

public class LoginManager {

    private LoginService loginService;

    public LoginManager(LoginService loginService) {
        this.loginService = loginService;
    }

    public Observable<String> realizaLogin(Login login) {
//        String first = loginService.verificaCredenciais(login.getLogin(), login.getSenha()).toBlocking().first();

        return loginService.verificaCredenciais(login);

//        Task<AuthResult> authResultTask = loginService.verificaCredenciais(login);
//        authResultTask.addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//            @Override
//            public void onComplete(@NonNull Task<AuthResult> task) {
//                if(task.isSuccessful()){
//                    retorno = "loginSucesso";
//                } else {
//                    retorno = "loginFalhaCredenciais";
//                }
//            }
//        });
//        return retorno;
    }

    public boolean validaEmail(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public boolean validaSenha(String senha) {
        return senha.length() > 5 && senha.length() < 10;
    }
}