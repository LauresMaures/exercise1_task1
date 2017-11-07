
package uebung1_task1;

public interface BookstoreRequirements {
    int getNumberOfNewBooksFromConsole();
    void addBookToBookstore(Book book);
    Book getBookFromConsole();
    void printAllBooks();
    
    
    public class WrongInputValueException extends Exception{
        public WrongInputValueException(){}
        public WrongInputValueException(String msg){super(msg);}
    }
    
    
}
