import java.util.Map;

public class Movie extends Content{

    private String title;
    private String image;
    private Double rating;

    private Long imdbRating;

    public Movie(Map<String, String> movie) {
        super(movie.get("title"), movie.get("image"));
        this.rating = Double.valueOf(movie.get("imDbRating"));
        this.imdbRating = Math.round(rating);
    }

    public String getTitle() {
        return super.getTitle();
    }

    public String getImage() {
        return super.getImageUrl();
    }

    public Double getRating() {
        return rating;
    }

    public Long getImdbRating() {
        return imdbRating;
    }

    public void printMovie() {
        System.out.println("\033[43m" + "Title = " + this.getTitle() + "\033[0m");
        System.out.println("Image = " + this.getImageUrl());
        System.out.println("Rating = " + "\u2606".repeat(Math.toIntExact(imdbRating)));
        System.out.println("==========================");
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + super.getTitle() + '\'' +
                ", image='" + super.getImageUrl() + '\'' +
                ", rating=" + rating +
                '}';
    }
}
