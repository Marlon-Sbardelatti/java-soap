package booksReview;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;

class BooksReviewClient {

    public static void main(String args[]) throws Exception {
        URL url = new URL("http://127.0.0.1:9876/books?wsdl");
        QName qname = new QName("http://booksReview/","BooksReviewServerImplService");
        Service ws = Service.create(url, qname);
        BooksReviewServer servico = ws.getPort(BooksReviewServer.class);

        System.out.println("CRUD USER");
        System.out.println(servico.createUser(1, "Marlon"));
        System.out.println(servico.createUser(2, "Sophia"));
        System.out.println(servico.getUserByID(2));
        System.out.println(servico.updateUser(2, 2, "Sofia"));
        System.out.println(servico.deleteUser(2));

        System.out.println("\nCRUD REVIEWS");
        System.out.println(servico.addReview(1, 1, "Harry Potter", "J.K. Rowling", 3.5));
        System.out.println(servico.addReview(1, 2, "Senhos dos Anéis", "J.R.R. Tolkien", 4.5));
        System.out.println(servico.updateReview(1, 2, "Senhos dos Anéis", "J.R.R. Tolkien", 5.0));
        System.out.println(servico.getBestRated(1));
        System.out.println(servico.deleteReview(1, 1));
        System.out.println(servico.getReviewedBooks(1));
        System.out.println(servico.getUserByID(1));
    }
}