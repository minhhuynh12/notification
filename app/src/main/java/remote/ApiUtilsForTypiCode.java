package remote;

/**
 * Created by MyPC on 14/09/2017.
 */

public class ApiUtilsForTypiCode {
    public static final String BASE_URL_1 = "http://jsonplaceholder.typicode.com/";
    static ApiService apiService;

    public static ApiService getService() {
        if (apiService == null) {
            synchronized (ApiService.class) {
                if (apiService == null) {
                    apiService = RetrofitClient.getClient(BASE_URL_1).create(ApiService.class);
                }
            }
        }

        return apiService;
    }
}
