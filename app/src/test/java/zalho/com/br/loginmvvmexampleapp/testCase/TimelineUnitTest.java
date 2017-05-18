package zalho.com.br.loginmvvmexampleapp.testCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import rx.Observable;
import rx.Subscription;
import rx.observers.TestSubscriber;
import zalho.com.br.loginmvvmexampleapp.model.entidades.EventoHumor;
import zalho.com.br.loginmvvmexampleapp.model.entidades.Humor;
import zalho.com.br.loginmvvmexampleapp.model.entidades.InformacaoHumor;
import zalho.com.br.loginmvvmexampleapp.model.entidades.Login;
import zalho.com.br.loginmvvmexampleapp.model.manager.TimelineManager;
import zalho.com.br.loginmvvmexampleapp.service.TimelineService;
import zalho.com.br.loginmvvmexampleapp.service.TimelineServiceImpl;
import zalho.com.br.loginmvvmexampleapp.service.TimelineServiceRetrofit;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.when;

/**
 * Created by andre on 10/05/2017.
 */

@RunWith(MockitoJUnitRunner.class)
public class TimelineUnitTest {

    private static EventoHumor eventoMockBem = new EventoHumor(new Humor(InformacaoHumor.Bem, 0));
    private static EventoHumor eventoMockIrritado = new EventoHumor(new Humor(InformacaoHumor.Irritado, 0));
    private Login login = new Login("1", "login", "senha");

    private static List<EventoHumor> eventosMocados = Arrays.asList(eventoMockBem, eventoMockIrritado);

    private MockWebServer mockWebServer;
    private static final String RESPONSE_BODY = "{\"id\" : 1}";


    @Mock
    TimelineService service;

    @Mock
    TimelineServiceRetrofit retrofitService;

    @InjectMocks
    TimelineManager manager;

    @Test
    public void testHumorEventList(){
        Observable<List<EventoHumor>> observableList = Observable.just(eventosMocados);
        when(service.getHistoricoEventosHumorWeb(login.getIdLogin())).thenReturn(observableList);

        TestSubscriber<List<EventoHumor>> testSubscriber = new TestSubscriber<>();

        manager.getEventosFromWeb().subscribe(testSubscriber);
        testSubscriber.assertValue(eventosMocados);
    }

    @Test
    public void testAddEventoHumor(){
        EventoHumor eventoHumor = new EventoHumor(new Humor(InformacaoHumor.Feliz, 0));

        manager.addEventoHumor(eventoHumor);

        assertEquals(eventoHumor, eventosMocados.get(eventosMocados.size()));
    }

    @Test
    public void testListRetrofit(){
        this.mockWebServer = new MockWebServer();
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(RESPONSE_BODY));

//        when(retrofitService.getHistoricoHumor(login.getIdLogin())).thenReturn();
    }
}
