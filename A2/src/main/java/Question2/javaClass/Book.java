package Question2.javaClass;

import Question2.Interface.AuthorInterface;
import Question2.Interface.BookDvdCommonInterface;

public class Book implements BookDvdCommonInterface, AuthorInterface {

    @Override
    public String GetTitle() {
         return "For Whom The Bell Tolls";
    }

    @Override
    public boolean IsDigitalOnly() {
        return false;
    }

    @Override
    public String GetAuthor() {
        return "Hemingway";
    }
}
