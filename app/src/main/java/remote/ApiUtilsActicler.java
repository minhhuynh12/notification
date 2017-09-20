package remote;

/**
 * Created by MyPC on 20/09/2017.
 */

public class ApiUtilsActicler {
    public  static final String BASE_URL = "http://hmkcode.appspot.com/";

    public static ApiServiceActicler getService(){
        return RetrofitClient.getClient(BASE_URL).create(ApiServiceActicler.class);
    }
}
