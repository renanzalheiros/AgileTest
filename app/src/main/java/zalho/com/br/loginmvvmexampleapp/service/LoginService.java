package zalho.com.br.loginmvvmexampleapp.service;

import rx.Observable;

/**
 * Created by andre on 12/04/2017.
 */

public interface LoginService {

    public Observable<String> verificaCredenciais(String email, String senha);
}
