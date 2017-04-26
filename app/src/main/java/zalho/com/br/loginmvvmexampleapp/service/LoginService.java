package zalho.com.br.loginmvvmexampleapp.service;

import rx.Observable;
import zalho.com.br.loginmvvmexampleapp.model.entidades.Login;

/**
 * Created by andre on 12/04/2017.
 */

public interface LoginService {

    Observable<String> verificaCredenciais(Login login);
}
