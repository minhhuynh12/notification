package model;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.List;

/**
 * Created by MyPC on 14/09/2017.
 */

public class TypiCodeResponse implements Serializable {
    @Expose
    public List<Post> typiCodeItemses;
}
