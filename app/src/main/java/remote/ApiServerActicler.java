package remote;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by MyPC on 20/09/2017.
 */

public class ApiServerActicler {
    private static ApiServerActicler mApiServerActicler;

    public static ApiServerActicler getApiService(String baseUrl) {
        if (mApiServerActicler == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            mApiServerActicler = retrofit.create(ApiServerActicler.class);
        }
        return mApiServerActicler;
    }
}
