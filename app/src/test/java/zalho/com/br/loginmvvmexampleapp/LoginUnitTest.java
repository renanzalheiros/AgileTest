package zalho.com.br.loginmvvmexampleapp;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

import org.junit.Test;

import zalho.com.br.loginmvvmexampleapp.manager.LoginManager;
import zalho.com.br.loginmvvmexampleapp.model.Login;

import static junit.framework.Assert.assertEquals;

/**
 * Created by andre on 17/03/2017.
 */

public class LoginUnitTest {

    @Test
    public void testLogin(){
        LoginManager manager = new LoginManager();
        Login loginSuccess = new Login("teste", "teste");
        Task<AuthResult> authResultTask = manager.realizaLogin(loginSuccess);

        assertEquals(!authResultTask.isSuccessful(), authResultTask);
    }
}
