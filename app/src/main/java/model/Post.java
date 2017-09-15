package model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by MyPC on 14/09/2017.
 */

public class Post implements Serializable {
//    @SerializedName("userId")
//    public int userId;
//    @SerializedName("id")
//    public int id;
    @SerializedName("title")
    public String title;
    @SerializedName("body")
    public String body;


}
