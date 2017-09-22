package remote;

import java.util.List;

import model.TodoItems;
import model.TodoResponseItems;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by MyPC on 21/09/2017.
 */

public interface ApiServiceTodo {
    @GET("todos/{id}")
    Call<List<TodoItems>> getListRepsonseTodoById(@Path("id") int id);
    @GET("todos")
    Call<List<TodoItems>> getListRepsonseTodo();
}
