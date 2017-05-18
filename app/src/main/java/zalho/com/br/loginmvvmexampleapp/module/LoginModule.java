package zalho.com.br.loginmvvmexampleapp.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import zalho.com.br.loginmvvmexampleapp.model.entidades.Login;
import zalho.com.br.loginmvvmexampleapp.model.manager.LoginManager;
import zalho.com.br.loginmvvmexampleapp.service.LoginService;
import zalho.com.br.loginmvvmexampleapp.service.LoginServiceImpl;
import zalho.com.br.loginmvvmexampleapp.service.LoginServiceRetrofit;

/**
 * Created by andre on 26/04/2017.
 */
@Module
public class LoginModule {

    @Provides
    @Singleton
    LoginManager getLoginManager(){
        return new LoginManager();
    }

    @Provides
    @Singleton
    LoginService getLoginService(){
        return new LoginServiceImpl();
    }

    @Provides
    @Singleton
    LoginServiceRetrofit retrofitLoginService(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        LoginServiceRetrofit service = retrofit.create(LoginServiceRetrofit.class);
        return service;
    }
}
