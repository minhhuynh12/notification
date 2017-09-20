package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by MyPC on 20/09/2017.
 */

public class ActiclerResponseItems implements Serializable {
    @SerializedName("articleList")
    @Expose
    public ArrayList<ActiclerItems> getList = null;

}
