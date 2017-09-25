package remote;

/**
 * Created by MyPC on 21/09/2017.
 */

public class ApiUtilsTodo  {
    public static final String BASE_URL_1 = "http://jsonplaceholder.typicode.com/";

    public static ApiServiceTodo getServiceTodo(){
        return RetrofitClient.getClient(BASE_URL_1).create(ApiServiceTodo.class);
    }
}
