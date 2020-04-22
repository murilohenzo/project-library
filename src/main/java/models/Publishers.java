package models;

public class Publishers {
    public int publisher_id;
    public String name;
    public String url;

    public Publishers(){}

    public Publishers(int publisher_id, String name, String url) {
        this.publisher_id = publisher_id;
        this.name = name;
        this.url = url;
    }

    public int getPublisher_id() {
        return publisher_id;
    }

    public void setPublisher_id(int publisher_id) {
        this.publisher_id = publisher_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
