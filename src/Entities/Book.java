/*
// Curso Egg FullStack
 */
package Entities;

// @author JulianCVidal
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Book")
public class Book implements Serializable {

    @Id
    private Integer isbn;
    private String title;
    private Integer releaseYear;
    private Integer copies;
    private Integer borrowedCopies;
    private Integer remainingCopies;
    private Boolean enabled;
    
//    @OneToOne(cascade = CascadeType.PERSIST) // Persistimos el objecto.
//    private Author author;
//    
//    @OneToOne(cascade = CascadeType.PERSIST) // Persistmimos el objecto.
//    private Editorial editorial;


    @ManyToOne(fetch = FetchType.LAZY)
    private Author author;

    @ManyToOne(fetch = FetchType.LAZY)
    private Editorial editorial;

    public Book() {
    }

    public Book(Integer isbn, String title, Integer releaseYear, Integer copies, Boolean discharged, Author author, Editorial editorial) {
        this.isbn = isbn;
        this.title = title;
        this.releaseYear = releaseYear;
        this.copies = copies;
        this.borrowedCopies = 0;
        this.remainingCopies = copies;
        this.enabled = discharged;
        this.author = author;
        this.editorial = editorial;
    }

    public Integer getIsbn() {
        return isbn;
    }

    public void setIsbn(Integer isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Integer getCopies() {
        return copies;
    }

    public void setCopies(Integer copies) {
        this.copies = copies;
    }

    public Integer getBorrowedCopies() {
        return borrowedCopies;
    }

    public void setBorrowedCopies(Integer borrowedCopies) {
        this.borrowedCopies = borrowedCopies;
    }

    public Integer getRemainingCopies() {
        return remainingCopies;
    }

    public void setRemainingCopies(Integer remainingCopies) {
        this.remainingCopies = remainingCopies;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    @Override
    public String toString() {
        return "Book{" + "isbn=" + isbn + ", title=" + title + ", releaseYear=" + releaseYear + ", copies=" + copies + ", borrowedCopies=" + borrowedCopies + ", remainingCopies=" + remainingCopies + ", enabled=" + enabled + ", author=" + author + ", editorial=" + editorial + '}';
    }

}
