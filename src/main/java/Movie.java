import java.util.Map;

public class Movie {

    private String title;
    private String image;
    private Double rating;

    private Long imdbRating;

    public Movie(Map<String, String> movie) {
        this.title = movie.get("title");
        this.image = movie.get("image");
        this.rating = Double.valueOf(movie.get("imDbRating"));
        this.imdbRating = Math.round(rating);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Long getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(Long imdbRating) {
        this.imdbRating = imdbRating;
    }

    public void printMovie() {
        System.out.println("\033[43m" + "Title = " + title + "\033[0m");
        System.out.println("Image = " + image);
        System.out.println("Rating = " + "\u2606".repeat(Math.toIntExact(imdbRating)));
        System.out.println("==========================");
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", rating=" + rating +
                '}';
    }
}
