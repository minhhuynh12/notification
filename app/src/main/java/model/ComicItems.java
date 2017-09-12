package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by MyPC on 10/09/2017.
 */

public class ComicItems implements Serializable {
    @SerializedName("title")
    @Expose
    public String title;

    @SerializedName("author")
    @Expose
    public String author;

    @SerializedName("status")
    @Expose
    public String status;

    @SerializedName("translators")
    @Expose
    public String translators;
}
