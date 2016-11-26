package area51.clase02.screen.product.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by segundo on 26/11/16.
 */

public class Image implements Serializable {

    private String id;
    private String url;
    private ArrayList<Image> images;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ArrayList<Image> getImages() {
        return images;
    }

    public void setImages(ArrayList<Image> images) {
        this.images = images;
    }
}
