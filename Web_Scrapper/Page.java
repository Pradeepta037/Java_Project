// Page.java
public class Page {
    private String url;
    private String content;

    public Page(String url) {
        this.url = url;
        this.content = "";
    }

    public String getUrl() {
        return url;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}

