package zalho.com.br.loginmvvmexampleapp;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import rx.Observable;
import rx.observers.TestSubscriber;
import zalho.com.br.loginmvvmexampleapp.manager.LoginManager;
import zalho.com.br.loginmvvmexampleapp.model.entidades.Login;
import zalho.com.br.loginmvvmexampleapp.service.LoginService;

import static junit.framework.Assert.assertEquals;

/**
 * Created by andre on 17/03/2017.
 */

@RunWith(MockitoJUnitRunner.class)
public class LoginUnitTest {

    @Mock
    LoginService service;

    @InjectMocks private LoginManager manager;

    @Before
    public void beforeTests(){
        Task<?> authResultTask = Mockito.mock(Task.class);
    }

    @Test
    public void testLogin(){
        Login loginSuccess = new Login("salsa@loginmvvm.com", "123qwe");
        Observable<String> stringObservable = manager.realizaLogin(loginSuccess);

//        assertEquals(email, loginSuccess.getLogin());
    }
}
