package LibraryAPI;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    @Column(name = "title")
    private String title;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;
    @ManyToOne
    @JoinColumn(name = "publisher_id", nullable = false)
    private Publisher publisher;

    @Column(name = "edition")
    private String edition;
    @Column(name = "publication_year")
    private LocalDate publicationYear;
    @Column(name = "original_language")
    private String originalLanguage;
    @Column(name = "page_number")
    private int pageNumber;
    @Column(name = "isbn", columnDefinition = "CHAR(13)")
    private char isbn;
    @Column(name = "genre")
    private String genre;

    public Long getBookId() {
        return this.bookId;
    }
    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return this.author;
    }
    public void setAuthor(Author author) {
        this.author = author;
    }

    public Publisher getPublisher() {
        return this.publisher;
    }
    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public String getEdition() {
        return this.edition;
    }
    public void setEdition(String edition) {
        this.edition = edition;
    }

    public LocalDate getPublicationYear() {
        return this.publicationYear;
    }
    public void setPublicationYear(LocalDate publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getOriginalLanguage() {
        return this.originalLanguage;
    }
    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public int getPageNumber() {
        return this.pageNumber;
    }
    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public char getIsbn() {
        return this.isbn;
    }
    public void setIsbn(char isbn) {
        this.isbn = isbn;
    }

    public String getGenre() {
        return this.genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
}
