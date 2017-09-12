package extras;

/**
 * Created by MyPC on 11/09/2017.
 */

public class Enumes {
    public enum  FragmentType {
        FRAGMENT_DOWNLOAD("FRAGMENT_DOWNLOAD"),
        FRAGMENT_HOT("FRAGMENT_HOT"),
        FRAGMENT_TYPE("FRAGMENT_TYPE");

        final String mValue;
        FragmentType(String value){ mValue = value;}

        public String toString(){
            return mValue;
        }
    }
    public enum Direction{
        RIGHT_IN("RIGHT_IN");

        final String mDirection;
        Direction(String value){ mDirection = value;}

        public String toString(){
            return mDirection;
        }
    }

}
