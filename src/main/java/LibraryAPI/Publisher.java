package LibraryAPI;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long publisherId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "publisher")
    private List<Book> books;

    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "website")
    private String website;
    @Column(name = "foundation_year")
    private int foundationYear;

    public Long getPublisherId() {
        return this.publisherId;
    }
    public void setPublisherId(Long publisherId) {
        this.publisherId = publisherId;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return this.address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getWebsite() {
        return this.website;
    }
    public void setWebsite(String website) {
        this.website = website;
    }

    public int getFoundationYear() {
        return this.foundationYear;
    }
    public void setFoundationYear(int foundationYear) {
        this.foundationYear = foundationYear;
    }
}
