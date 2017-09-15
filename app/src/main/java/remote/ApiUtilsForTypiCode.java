package remote;

/**
 * Created by MyPC on 14/09/2017.
 */

public class ApiUtilsForTypiCode {
    public  static final String BASE_URL_1 = "http://jsonplaceholder.typicode.com/";

    public static ApiService getService(){
        return RetrofitClient.getClient(BASE_URL_1).create(ApiService.class);
    }
}
