package remote;

import java.util.List;

import model.ComicResponse;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by MyPC on 10/09/2017.
 */

public interface SOService {
    @GET("/api/Mangas")
//    Call<ComicResponse> getAnswersObjects();
    Call<ComicResponse> getAnswersObjects();

}
