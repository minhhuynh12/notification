package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by MyPC on 10/09/2017.
 */

public class ComicResponse implements Serializable {
    @SerializedName("data")
    @Expose
    public List<ComicItems> comicItemses = null;

}
