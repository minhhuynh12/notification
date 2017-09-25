package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MyPC on 21/09/2017.
 */

public class TodoResponseItems implements Serializable {

    @Expose
    public ArrayList<TodoItems> getList = null;

}
