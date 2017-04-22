/**
 * Created by hasun on 17. 4. 22.
 */
public class wikiModel {
    private int id;
    private String title;
    private String text;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Wiki:: ID="+this.id+" Title=" + this.title + " Text=" + this.text;
    }

}
