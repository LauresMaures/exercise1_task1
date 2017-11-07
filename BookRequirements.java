
package uebung1_task1;

public interface BookRequirements {
    //Getter:
    int getID();
    String getAutor();
    String getTitel();
    int getISBN();
    Verlag getVerlag();
    int getErscheinungsjahr();
    
    //Setter:
    void setID(int id);
    void setAutor(String autor);
    void setTitel(String titel);
    void setISBN(int isbn);
    void setVerlag(Verlag verlag);
    void setErscheinungsjahr(int erscheinungsjahr);
    
    boolean bookIsValid();
    
    boolean idIsValid();
    boolean stringIsValid(String string);
    boolean isbnIsValid();
    boolean erscheinungsjahrIsValid();
    boolean verlagIsValid(Verlag verlag);
}
