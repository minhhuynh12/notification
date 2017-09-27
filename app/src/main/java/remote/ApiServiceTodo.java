package remote;

import java.util.List;

import model.Post;
import model.TodoItems;
import model.TodoResponseItems;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by MyPC on 21/09/2017.
 */

public interface ApiServiceTodo {
    @GET("todos/{id}")
    Call<TodoItems> getListRepsonseTodoById(@Path("id") String id);
//    @GET("todos")
//    Call<List<TodoItems>> getListRepsonseTodo(@Query("user_id") String user_id  );
    @POST("todos")
    Call<List<TodoItems>> getListRepsonseTodo( );
    @POST("todos")
    Call<List<TodoItems>> getListRepsonseTodoPost(@Field("user_id") String user_id);

}
