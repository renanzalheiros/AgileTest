package zalho.com.br.loginmvvmexampleapp.service;

import android.content.Context;

import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import zalho.com.br.loginmvvmexampleapp.model.Login;

/**
 * Created by andre on 06/03/2017.
 */

public class LoginService {

//    private final String compLogin = "@loginmvvm.com";

    private FirebaseAuth loginAuth;
    private FirebaseAuth.AuthStateListener authListener;

    public LoginService(){
        loginAuth = FirebaseAuth.getInstance();
    }

    public Task<AuthResult> verificaCredenciais(Login login) {
        return loginAuth.signInWithEmailAndPassword(login.getLogin(), login.getSenha());
    }
}
