package zalho.com.br.loginmvvmexampleapp.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import zalho.com.br.loginmvvmexampleapp.model.manager.LoginManager;
import zalho.com.br.loginmvvmexampleapp.service.LoginServiceImpl;

/**
 * Created by andre on 26/04/2017.
 */
@Module
public class LoginModule {

    @Provides
    @Singleton
    LoginManager getLoginManager(){
        return new LoginManager(new LoginServiceImpl());
    }
}
