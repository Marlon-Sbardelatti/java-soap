package booksReview;

import javax.xml.ws.Endpoint;

public class BooksReviewPublisher {

    public static void main(String[] args)
    {
       Endpoint.publish("http://127.0.0.1:9876/books",
       new BooksReviewServerImpl());
    }
}