package booksReview;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public interface BooksReviewServer {
    @WebMethod String createUser(int userID, String name);
    @WebMethod String getUserByID(int userID);
    @WebMethod String updateUser(int userID, int newID, String newName);
    @WebMethod String deleteUser(int userID);
    @WebMethod String addReview(int userID, int ISBN, String title, String author, double rating);
    @WebMethod String getReviewedBooks(int userID);
    @WebMethod String getBestRated(int userID);
    @WebMethod String updateReview(int userID, int ISBN, String title, String author, double rating);
    @WebMethod String deleteReview(int userID, int ISBN);
}
