package models;

public class Authors {
    public int author_id;
    public String name;
    public String fname;

    public Authors(){}

    public Authors(int author_id, String name, String fname) {
        this.author_id = author_id;
        this.name = name;
        this.fname = fname;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }
}
