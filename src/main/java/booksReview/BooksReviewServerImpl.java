package booksReview;

import javax.jws.WebService;
import java.util.HashMap;

@WebService(endpointInterface = "booksReview.BooksReviewServer")
public class BooksReviewServerImpl implements BooksReviewServer {
    private HashMap<Integer, User> users = new HashMap<>();

    @Override
    public String createUser(int userID, String name) {
        if (users.containsKey(userID)) {
            return (new Response(false, "Usuário já cadastrado")).toString();
        }
        if (name.isEmpty()) {
            return (new Response(false, "Nome inválido")).toString();
        }

        users.put(userID, new User(userID, name));
        return (new Response(true, "Usuário cadastrado com sucesso")).toString();
    }

    @Override
    public String getUserByID(int userID) {
        if (!users.containsKey(userID)) {
            return (new Response(false, "Usuário não encontrado")).toString();
        }
        return users.get(userID).toString();
    }

    @Override
    public String updateUser(int userID, int newID, String newName) {
        if (!users.containsKey(userID)) {
            return (new Response(false, "Usuário não encontrado")).toString();
        }
        if (userID != newID && users.containsKey(newID)) {
            return (new Response(false, "ID já cadastrado")).toString();
        }

        users.get(userID).setName(newName);
        return (new Response(true, "Usuário alterado com sucesso")).toString();
    }

    @Override
    public String deleteUser(int userID) {
        if (!users.containsKey(userID)) {
            return (new Response(false, "Usuário não encontrado")).toString();
        }

        users.remove(userID);
        return (new Response(true, "Usuário removido com sucesso")).toString();
    }

    @Override
    public String addReview(int userID, int ISBN, String title, String author, double rating) {
        if (!users.containsKey(userID)) {
            return (new Response(false, "Usuário não encontrado")).toString();
        }
        if (ISBN <= 0 || title.isEmpty() || author.isEmpty() || rating < 0 || rating > 5){
            return (new Response(false, "Informações do livro inválidas")).toString();
        }

        Book reviewedBook = new Book(ISBN, title, author, rating);
        users.get(userID).addReview(ISBN, reviewedBook);
        return (new Response(true, "Review adicionada com sucesso")).toString();
    }

    @Override
    public String getReviewedBooks(int userID) {
        if (!users.containsKey(userID)) {
            return (new Response(false, "Usuário não encontrado")).toString();
        }
        if (users.get(userID).getReviewedBooks().isEmpty()){
            return (new Response(false, "Não há reviews cadastradas")).toString();
        }

        return "{\n" + " \"reviewedBooks\": [" + users.get(userID).reviewsToString() + "]\n" + "}";
    }

    @Override
    public String getBestRated(int userID) {
        if (!users.containsKey(userID)) {
            return (new Response(false, "Usuário não encontrado")).toString();
        }
        if (users.get(userID).getReviewedBooks().isEmpty()) {
            return (new Response(false, "Não há reviews cadastradas")).toString();
        }

        return users.get(userID).getBestRated().toString();
    }

    @Override
    public String updateReview(int userID, int ISBN, String title, String author, double rating) {
        if (!users.containsKey(userID)) {
            return (new Response(false, "Usuário não encontrado")).toString();
        }
        if (!users.get(userID).getReviewedBooks().containsKey(ISBN)){
            return (new Response(false, "Não há reviews cadastradas")).toString();
        }

        Book updated = new Book(ISBN, title, author, rating);
        users.get(userID).updateReview(ISBN, updated);
        return (new Response(true, "Review alterada com sucesso")).toString();
    }

    @Override
    public String deleteReview(int userID, int ISBN) {
        if (!users.containsKey(userID)) {
            return (new Response(false, "Usuário não encontrado")).toString();
        }
        if (!users.get(userID).removeReview(ISBN)){
            return (new Response(false, "Livro não encontrado")).toString();
        }

        return (new Response(true , "Review removida com sucesso")).toString();
    }
}
