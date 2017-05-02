package zalho.com.br.loginmvvmexampleapp;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import rx.Observable;
import rx.observers.TestSubscriber;
import zalho.com.br.loginmvvmexampleapp.model.manager.LoginManager;
import zalho.com.br.loginmvvmexampleapp.model.entidades.Login;
import zalho.com.br.loginmvvmexampleapp.service.LoginService;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Created by andre on 17/03/2017.
 */

@RunWith(MockitoJUnitRunner.class)
public class LoginUnitTest {

    public static final String LOGIN_SUCCESS = "salsa@loginmvvm.com";
    public static final String SENHA_SUCCESS = "123qwe";

    public static final String LOGIN_FAIL = "zalho@teste.com";
    public static final String SENHA_FAIL = "123qwe";

    public static final String INVALID_EMAIL = "zalho";
    public static final String INVALID_SENHA_MIN = "1234";
    public static final String INVALID_SENHA_MAX = "12345qwerta";

    public static final String MSG_FAIL_EMAIL_SENHA = "Email ou senha incorretos";

    @Mock
    LoginService service;

    @InjectMocks private LoginManager manager;

    @Before
    public void beforeTests(){
        Observable<String> loginSucesso = Observable.just(LOGIN_SUCCESS);
        Login login = new Login(LOGIN_SUCCESS, SENHA_SUCCESS);
        when(service.verificaCredenciais(login)).thenReturn(loginSucesso);

        Observable<String> loginErro = Observable.just(MSG_FAIL_EMAIL_SENHA);
        Login loginFail = new Login(LOGIN_FAIL, SENHA_FAIL);
        when(service.verificaCredenciais(loginFail)).thenReturn(loginErro);
    }

    @Test
    public void testLoginSuccess(){
        Login loginSuccess = new Login(LOGIN_SUCCESS, SENHA_SUCCESS);
        TestSubscriber<String> testSubscriber = new TestSubscriber<>();
        manager.realizaLogin(loginSuccess).subscribe(testSubscriber);
        testSubscriber.assertValue(loginSuccess.getLogin());
        testSubscriber.unsubscribe();
    }

    @Test
    public void testLoginFail(){
        Login loginFail = new Login(LOGIN_FAIL, SENHA_FAIL);
        TestSubscriber<String> testSubscriber = new TestSubscriber<>();
        manager.realizaLogin(loginFail).subscribe(testSubscriber);
        testSubscriber.assertValue(MSG_FAIL_EMAIL_SENHA);
        testSubscriber.unsubscribe();
    }

    @Test
    public void testSenhaValidation(){
        boolean senhaCurta = manager.validaSenha(INVALID_SENHA_MIN);
        boolean senhaLonga = manager.validaSenha(INVALID_SENHA_MAX);

        boolean senhaCorreta = manager.validaSenha(SENHA_SUCCESS);

        assertEquals(false, senhaCurta);
        assertEquals(false, senhaLonga);
        assertEquals(true, senhaCorreta);
    }
}
