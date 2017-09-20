package remote;

import java.util.List;

import model.ActiclerResponseItems;
import model.Post;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by MyPC on 20/09/2017.
 */

public interface ApiServiceActicler {
    @GET("rest/controller/get.json")
    Call<ActiclerResponseItems> getListResponse();
}
