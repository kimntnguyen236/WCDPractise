/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.aptech.student1218312.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author ThienKim
 */
@Entity
@Table(name = "Book")
@NamedQueries({
    @NamedQuery(name = "Book.findAll", query = "SELECT b FROM Book b"),
    @NamedQuery(name = "Book.findByBookCode", query = "SELECT b FROM Book b WHERE b.bookCode = :bookCode"),
    @NamedQuery(name = "Book.findByTitle", query = "SELECT b FROM Book b WHERE b.title = :title"),
    @NamedQuery(name = "Book.findByPrice", query = "SELECT b FROM Book b WHERE b.price = :price"),
    @NamedQuery(name = "Book.findByPublisher", query = "SELECT b FROM Book b WHERE b.publisher = :publisher")})
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "BookCode")
    private String bookCode;
    @Size(max = 50)
    @Column(name = "Title")
    private String title;
    @Column(name = "Price")
    private Integer price;
    @Size(max = 50)
    @Column(name = "Publisher")
    private String publisher;

    public Book() {
    }

    public Book(String bookCode) {
        this.bookCode = bookCode;
    }

    @NotEmpty
    public String getBookCode() {
        return bookCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    @NotEmpty
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @NotEmpty
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @NotEmpty
    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bookCode != null ? bookCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Book)) {
            return false;
        }
        Book other = (Book) object;
        if ((this.bookCode == null && other.bookCode != null) || (this.bookCode != null && !this.bookCode.equals(other.bookCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fpt.aptech.student1218312.jpa.Book[ bookCode=" + bookCode + " ]";
    }

}
