/**
 * Created by molayodecker on 19/08/2016.
 */
public class Jar {
    protected String item;
    protected int maxItemAllowed;

    public Jar(String item, int maxNumber) {
        this.item = item;
        this.maxItemAllowed = maxNumber;
    }

    public String getItem() {
        return this.item;
    }

    public Integer getmaxNumber() {
        return this.maxItemAllowed;
    }

}
