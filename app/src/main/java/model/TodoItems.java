package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by MyPC on 21/09/2017.
 */

public class TodoItems implements Serializable {
    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("userId")
    @Expose
    public String userId;
    @SerializedName("title")
    @Expose
    public String title;

    public TodoItems(String id, String userId, String title) {
        this.id = id;
        this.userId = userId;
        this.title = title;
    }
}
