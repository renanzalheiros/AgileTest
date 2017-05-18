package zalho.com.br.loginmvvmexampleapp.service;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Observable;
import zalho.com.br.loginmvvmexampleapp.model.entidades.EventoHumor;

/**
 * Created by andre on 18/05/2017.
 */

public interface TimelineServiceRetrofit {

    @GET("/humorHistoric/{userId}")
    Observable<List<EventoHumor>> getHistoricoHumor(@Path(value = "userId", encoded = true) String userId);
}
