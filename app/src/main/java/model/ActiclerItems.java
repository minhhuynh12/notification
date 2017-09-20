package model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by MyPC on 16/09/2017.
 */

public class ActiclerItems implements Serializable {
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("url")
    @Expose
    public String url;


}
