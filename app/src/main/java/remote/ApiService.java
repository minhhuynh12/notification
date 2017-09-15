package remote;

import java.util.List;

import model.Post;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by MyPC on 14/09/2017.
 */

public interface ApiService {
    @GET("posts")
    Call<List<Post>> getListPost();

    @GET("posts/{id}")
    Call<Post> getPostDetail(@Path("id") int id);

}
