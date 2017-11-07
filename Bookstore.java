package uebung1_task1;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bookstore implements BookstoreRequirements {

    Scanner scanner;
    List<Book> listOfBooks;
    
    public Bookstore(){
        this.scanner = new Scanner(System.in);
        this.listOfBooks = new ArrayList<>();
    }
    
    @Override
    public int getNumberOfNewBooksFromConsole() {
        System.out.println("Wieviele Buecher sollen eingetragen werden? (Bitte eine Zahl von 0-5 angeben)");
        return this.getIntFromConsole(0, 5, "Bitte geben Sie eine Zahl zwischen 0-5 an!");
    }
    
    public int getIntFromConsole(int x, int y, String errorMessage){
        boolean testInput = true;
        int input = 0;
        do{
            try{
                input = Integer.parseInt(this.scanner.nextLine());
                if(input < x || input > y){
                    System.out.println(errorMessage);
                }
                else{
                    testInput = false;
                }
            }
            catch(Exception e){
                System.out.println(errorMessage);
            }
        }
        while(testInput);
        return input;   
    }
    
    public String getStringFromConsole(int minSize, int maxSize, String errorMessage){
        String input;
        //Matcher: prueft, ob ein String Zahlen enthält:
        Pattern p = Pattern.compile("([0-9])");
        do{
            try{
                input = this.scanner.nextLine();
                Matcher m = p.matcher(input);
                if(input.length() < minSize || input.length() > maxSize || m.find()){
                    System.out.println(errorMessage);
                }
                else{
                    return input;
                }
            }
            catch(Exception e){
                System.out.println(errorMessage);
            }
        }
        while(true);
    }
    
    public Verlag getVerlagFromConsole(String errorMessage){
        String input;
        do{
            try{
                input = this.scanner.nextLine();
                if(this.isVerlagValid(input)){
                    return Verlag.valueOf(input);
                }
                else{
                    System.out.println(errorMessage);
                }
            }
            catch(Exception e){
                System.out.println(errorMessage);
            }
        }
        while(true);
    }

    private boolean isVerlagValid(String input){
        for(Verlag verlag : Verlag.values()){
            if(verlag.name().equals(input)){
                return true;
            }
        }
        return false;
    }
    
    public int getIsbnFromConsole(String errorMessage){
        String input;
        do{
            try{
                input = this.scanner.nextLine();
                int tempInt = Integer.parseInt(input);
                if(this.isIsbnValid(tempInt)){
                    return tempInt;
                }
                else{
                    System.out.println(errorMessage);
                }
            }
            catch(Exception e){
                System.out.println(errorMessage);
            }
        }
        while(true);
    }
    
    private boolean isIsbnValid(int isbn){
        String tempString = String.valueOf(isbn);
        return (tempString.length() == 10 || tempString.length() == 13);
    }
    
    @Override
    public void addBookToBookstore(Book book) {
        if(book.bookIsValid()){
            this.listOfBooks.add(book);
        }
    }

    @Override
    public Book getBookFromConsole() {
        Book newBook = new Book();
        System.out.println("Neues Buch: ");
        
        System.out.println("Geben Sie die ID des Buches ein: ");
        newBook.setID(this.getIntFromConsole(0, 99999, "Bitte geben Sie eine valide ID ein!"));
        
        System.out.println("Geben Sie den Namen des_der Autor_in ein: ");
        newBook.setAutor(this.getStringFromConsole(2, 30, "Bitte geben Sie einen wirklichen AutorIn-Namen an. "));
        
        System.out.println("Geben Sie den Titel des Buches ein: ");
        newBook.setTitel(this.getStringFromConsole(1, 50, "Bitte geben Sie einen validen Buchtitel an!"));
        
        System.out.println("Geben Sie die ISBN-Nummer des Buches ein: (Diese muss 10- oder 13-stellig sein)");
        newBook.setISBN(this.getIsbnFromConsole("Bitte geben Sie eine 10- oder 13-stellige ISBN-Nummer an!"));
        
        System.out.println("Geben Sie einen der folgenden Verlage für das Buch ein: ULLSTEIN, ARSENAL, NAUTILUS, ARCHE, BECK: ");
        newBook.setVerlag(this.getVerlagFromConsole("Bitte geben Sie einen der folgenden Verlage an: ULLSTEIN, ARSENAL, NAUTILUS, ARCHE, BECK"));
        
        System.out.println("Geben Sie das Erscheinungsjahr des Buches ein: ");
        newBook.setErscheinungsjahr(this.getIntFromConsole(-2000, GregorianCalendar.getInstance().get(Calendar.YEAR), "Geben Sie ein gueltiges Erscheinungsjahr an."));
        
        return newBook;
    }

    @Override
    public void printAllBooks() {
        for (Book books: listOfBooks){
            System.out.println(books.toString());
        }
    }
    
}
