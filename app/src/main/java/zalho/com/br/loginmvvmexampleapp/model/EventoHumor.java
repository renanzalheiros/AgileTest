package zalho.com.br.loginmvvmexampleapp.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by andre on 29/03/2017.
 */

public class EventoHumor {

    private Humor humor;
    private Date data;

    public EventoHumor(Humor humor){
        this.humor = humor;
        this.data = new Date();
    }

    public String humorInfo(){
        return humor.getInfoHumor().getMensagem();
    }
}
