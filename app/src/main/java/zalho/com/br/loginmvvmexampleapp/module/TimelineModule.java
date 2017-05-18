package zalho.com.br.loginmvvmexampleapp.module;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import zalho.com.br.loginmvvmexampleapp.dao.UserDAO;
import zalho.com.br.loginmvvmexampleapp.model.manager.TimelineManager;
import zalho.com.br.loginmvvmexampleapp.service.TimelineServiceRetrofit;

/**
 * Created by andre on 26/04/2017.
 */

@Module
public class TimelineModule {

    @Provides
    @Singleton
    TimelineManager getTimelineManager(){
        return new TimelineManager();
    }

    @Provides
    @Singleton
    TimelineServiceRetrofit getTimelineServiceRetrofit(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TimelineServiceRetrofit serviceRetrofit = retrofit.create(TimelineServiceRetrofit.class);
        return serviceRetrofit;
    }

}
