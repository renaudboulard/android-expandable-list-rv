package fr.renaudboulard.android.expandable.recyclerview;

/**
 * Created by a525906 on 02/02/2016.
 */
public class Expandable {

    private String title;
    private boolean isExpand = false;
    private boolean isChild = false;

    public Expandable(String title) {
        this.title = title;
    }

    public Expandable(String title, boolean isChild) {
        this.title = title;
        this.isChild = isChild;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isExpand() {
        return isExpand;
    }

    public void setIsExpand(boolean isExpand) {
        this.isExpand = isExpand;
    }

    public boolean isChild() {
        return isChild;
    }

    public void setIsChild(boolean isChild) {
        this.isChild = isChild;
    }
}
