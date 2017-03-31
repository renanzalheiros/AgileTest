package zalho.com.br.loginmvvmexampleapp.model;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by andre on 29/03/2017.
 */

public class EventoHumor {

    private Humor humor;
    private Calendar data;

    public EventoHumor(Humor humor){
        this.humor = humor;
        data = Calendar.getInstance();
        data.setTime(new Date());
    }

    public String humorInfo(){
        return humor.getInfoHumor().getMensagem();
    }

    public String dataToString(){
        return data.get(Calendar.DAY_OF_MONTH) + "/" +  data.get(Calendar.MONTH) + "/" + data.get(Calendar.YEAR);
    }


}
