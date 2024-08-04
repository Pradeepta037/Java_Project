public class Movie {
    private String title;
    private String genre;
    private String showTime;

    public Movie(String title, String genre, String showTime) {
        this.title = title;
        this.genre = genre;
        this.showTime = showTime;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getShowTime() {
        return showTime;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Genre: " + genre + ", ShowTime: " + showTime;
    }
}
