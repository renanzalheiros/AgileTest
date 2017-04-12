package zalho.com.br.loginmvvmexampleapp.service;

import android.databinding.BaseObservable;
import android.databinding.ObservableBoolean;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.kelvinapps.rxfirebase.RxFirebaseAuth;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by andre on 06/03/2017.
 */

public class LoginServiceImpl extends BaseObservable implements LoginService {

    private String userEmail;
    private ObservableBoolean completou = new ObservableBoolean(false);

    @Override
    public Observable<String> verificaCredenciais(String email, String senha) {
        return RxFirebaseAuth.signInWithEmailAndPassword(FirebaseAuth.getInstance(), email, senha).map(new Func1<AuthResult, String>() {
            @Override
            public String call(AuthResult authResult) {
                return authResult.getUser().getEmail();
            }
        });

        /*
        final Task<AuthResult> authResultTask = FirebaseAuth.getInstance().signInWithEmailAndPassword(email, senha);
        authResultTask.addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                setUserEmail(task.getResult().getUser().getEmail());
            }
        });



        while(!completou.get()){
            Log.i("Firebase - Conexao", "Conexao falhou");
        }
        return userEmail;
         */
    }

    public void setUserEmail(String email){
        userEmail = email;
        completou.set(true);
    }
}
