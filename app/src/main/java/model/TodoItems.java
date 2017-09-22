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
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("title")
    @Expose
    public String title;


}
