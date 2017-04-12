package zalho.com.br.loginmvvmexampleapp.service;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

/**
 * Created by andre on 12/04/2017.
 */

public interface LoginService {

    public String verificaCredenciais(String email, String senha);
}
