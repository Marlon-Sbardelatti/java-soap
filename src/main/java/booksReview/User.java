package booksReview;

import java.util.HashMap;

public class User {
    private int ID;
    private String name;
    private HashMap<Integer, Book> reviewedBooks;

    public User(int ID, String name) {
        setID(ID);
        setName(name);
        reviewedBooks = new HashMap<>();
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        if (ID <= 0) {
            throw new IllegalArgumentException("ID deve ser superior a zero");
        }
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.isEmpty() || name == null) {
            throw new IllegalArgumentException("Nome não pode ser vazio ou nulo");
        }
        this.name = name;
    }

    public HashMap<Integer, Book> getReviewedBooks() {
        return reviewedBooks;
    }

    public void setReviewedBooks(HashMap<Integer, Book> reviewedBooks) {
        this.reviewedBooks = reviewedBooks;
    }

    public void addReview(int isbn, Book book) {
        reviewedBooks.put(isbn, book);
    }

    public boolean removeReview(int isbn) {
        return reviewedBooks.remove(isbn) != null;
    }

    public void updateReview(int isbn, Book book) {
        reviewedBooks.get(isbn).setAuthor(book.getAuthor());
        reviewedBooks.get(isbn).setTitle(book.getTitle());
        reviewedBooks.get(isbn).setRating(book.getRating());
    }

    public Book getBestRated() {
        double bestRating = 0;
        int bestRatedID = 0;
        for (Book b : getReviewedBooks().values()) {
            if (b.getRating() > bestRating) {
                bestRating = b.getRating();
                bestRatedID = b.getISBN();
            }
        }
        return getReviewedBooks().get(bestRatedID);
    }

    public String reviewsToString() {
        if (reviewedBooks.isEmpty()) {
            return "";
        }

        String dados = "\n";
        for (Book b : getReviewedBooks().values()) {
            dados += b.toString() + ",\n";
        }
        return dados.substring(0, dados.length() - 2);
    }

    @Override
    public String toString() {
        return "{\n" +
                " \"ID\": " + getID() + ",\n" +
                " \"name\": \"" + getName() + "\",\n" +
                " \"reviewedBooks\": [" + reviewsToString() + "]\n" +
                "}";
    }
}
