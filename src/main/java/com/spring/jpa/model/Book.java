package com.spring.jpa.model;
import javax.persistence.*;
import java.io.Serializable;

/**
 * Book
 *
 * @author guisheng.deng
 * @date 2017年04月12日
 * @reviewer
 * @description
 * @see
 */
@Entity
@Table(name = "book")
public class Book implements Serializable {
    private static final long serialVersionUID = -4025383559804042188L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long  bookId;
    @Column(name="bookname",length = 255)
    private String bookName;

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Book() {
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                '}';
    }
}