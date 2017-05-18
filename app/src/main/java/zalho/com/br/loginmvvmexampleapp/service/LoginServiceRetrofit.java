package zalho.com.br.loginmvvmexampleapp.service;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import zalho.com.br.loginmvvmexampleapp.model.entidades.Login;

/**
 * Created by andre on 18/05/2017.
 */

public interface LoginServiceRetrofit {

    @POST("/login")
    Call<Login> doLogin(@Body Login login);
}
