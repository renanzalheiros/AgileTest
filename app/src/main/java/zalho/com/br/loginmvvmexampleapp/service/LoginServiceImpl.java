package zalho.com.br.loginmvvmexampleapp.service;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import zalho.com.br.loginmvvmexampleapp.model.entidades.Login;

/**
 * Created by andre on 06/03/2017.
 */

public class LoginServiceImpl implements LoginService{

    private String aux;

    @Override
    public String verificaCredenciais(String email, String senha) {
        Task<AuthResult> authResultTask = FirebaseAuth.getInstance().signInWithEmailAndPassword(email, senha);
        authResultTask.addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                daiSim(task.getResult().getUser().getEmail());
            }
        });

//        while(!authResultTask.isComplete()){
//            Log.i("FIREBASE - Conexão", "Ainda nao conseguiu conexao");
//        }
        return aux;
    }

    public void daiSim(String email){
        aux = email;
    }
}
