
package uebung1_task1;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Book implements BookRequirements{
    private int id;
    private String autor;
    private String titel;
    private int isbn;
    private Verlag verlag;             
    private int erscheinungsjahr;
    
    
    public Book(){ }
    
    public Book(int id, String autor, String titel, int isbn, Verlag verlag, int erscheinungsjahr){
        this.id = id;
        this.autor = autor;
        this.titel = titel;
        this.isbn = isbn;
        this.verlag = verlag;
        this.erscheinungsjahr = erscheinungsjahr;
    }
    
    //GETTER:
    @Override
    public int getID() {
        return id;         
    }

    @Override
    public String getAutor() {
        return autor;
    }

    @Override
    public String getTitel() {
        return titel;
    }

    @Override
    public int getISBN() {
        return isbn;
    }

    @Override
    public Verlag getVerlag() {
        return verlag;
    }

    @Override
    public int getErscheinungsjahr() {
        return erscheinungsjahr;
    }

    //SETTER:
    @Override
    public void setID(int id) {
        this.id = id;
    }

    @Override
    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public void setTitel(String titel) {
        this.titel = titel;
    }

    @Override
    public void setISBN(int isbn) {
        this.isbn = isbn;
    }

    @Override
    public void setVerlag(Verlag verlag) {
        this.verlag = verlag;
    }

    @Override
    public void setErscheinungsjahr(int erscheinungsjahr) {
        this.erscheinungsjahr = erscheinungsjahr;
    }
    
    //VALIDIERUNG DES BUCHES:
    @Override
    public boolean bookIsValid(){
        return (this.idIsValid() && this.stringIsValid(autor) && this.stringIsValid(titel) && 
                this.isbnIsValid() && this.erscheinungsjahrIsValid() && this.verlagIsValid(this.verlag));
    }
    
    //AUSGABE:
    @Override
    public String toString(){
        return "[ Buch: " + "ID= " + id + ", Name des_der Autor_in= " + autor + ", Titel= " + titel + ", ISBN-Nummer= " + isbn + ", Verlag= " + verlag + ", Erscheinungsjahr= " + erscheinungsjahr + " ]";
    }

    @Override
    public boolean idIsValid() {
        String tempString = String.valueOf(this.id);
        return (tempString.length() > 2 && this.id > 0);
    }
    
    //prueft, ob der Autor oder der Buchtitel gueltig sind:
    @Override
    public boolean stringIsValid(String string) {
        String tempString = string;
        return (tempString != null && tempString != "" && tempString.length() > 2);
    }

    //prueft, ob die ISBN-Nummer 10- oder 13-stellig ist (das sind die aktuell gueltigen ISBN-Nummern):
    @Override
    public boolean isbnIsValid() {
        String tempString = String.valueOf(this.isbn);
        return (tempString.length() == 10 || tempString.length() == 13);
    }

    //prueft, ob das Erscheingsjahr zw. 2000 v.Chr. und dem aktuellen Jahr liegt:
    @Override
    public boolean erscheinungsjahrIsValid() {
        GregorianCalendar cal = new GregorianCalendar();
        return (this.erscheinungsjahr > -2000 && this.erscheinungsjahr < cal.get(Calendar.YEAR));
    }

    @Override
    public boolean verlagIsValid(Verlag verlag) {
        switch(verlag){
            case ARCHE: return true;
            case ULLSTEIN: return true;
            case BECK: return true;
            case ARSENAL: return true;
            case NAUTILUS: return true;
            default: return false;
        }
    }
}
