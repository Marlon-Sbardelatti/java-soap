package booksReview;

public class Book {
    private int ISBN;
    private String title;
    private String author;
    private double rating;

    public Book(int ISBN, String title, String author, double rating) {
        setISBN(ISBN);
        setTitle(title);
        setAuthor(author);
        setRating(rating);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title.isEmpty() || title == null) {
            throw new IllegalArgumentException("Título não pode ser vazio ou nulo");
        }
        this.title = title;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        if (ISBN <= 0) {
            throw new IllegalArgumentException("ISBN não deve ser maior ou igual a 0");
        }
        this.ISBN = ISBN;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (author.isEmpty() || author == null) {
            throw new IllegalArgumentException("Autor não deve ser vazio ou nulo");
        }
        this.author = author;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        if (rating < 0 || rating > 5) {
            throw new IllegalArgumentException("Nota deve pertencer ao intervalo de 0 a 5");
        }
        this.rating = rating;
    }

    public String toString() {
        return "  {\n" +
                "   \"ISBN\": " + getISBN() + ",\n" +
                "   \"title\": \"" + getTitle() + "\",\n" +
                "   \"author\": \"" + getAuthor() + "\",\n" +
                "   \"rating\": " + getRating() + "\n" +
                "  }";
    }
}
