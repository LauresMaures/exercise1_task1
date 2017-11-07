
package uebung1_task1;

public class TestClass {

    public static void main(String[] args) {
        Bookstore littleBookstore = new Bookstore();
        int anzahlNewBooks = littleBookstore.getNumberOfNewBooksFromConsole();
        for(int i = 0; i < anzahlNewBooks; i++){
            Book newBook = littleBookstore.getBookFromConsole();
            littleBookstore.addBookToBookstore(newBook);
        }
        
        littleBookstore.printAllBooks();
    }
    
}
