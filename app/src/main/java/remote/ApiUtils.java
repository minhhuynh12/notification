package remote;

/**
 * Created by MyPC on 10/09/2017.
 */

public class ApiUtils {
    public  static final  String BASE_URL = "http://thichcomic.com:1221/";

    public static SOService getSOService(){
        return RetrofitClient.getClient(BASE_URL).create(SOService.class);
    }
}
