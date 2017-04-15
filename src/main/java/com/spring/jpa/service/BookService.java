package com.spring.jpa.service;

import com.spring.jpa.exception.BookNotFoundException;
import com.spring.jpa.model.Book;
import com.spring.jpa.repository.BookResitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * AccountService
 *
 * @author guisheng.deng
 * @date 2017年04月12日
 * @reviewer
 * @description
 * @see
 */
@Service
public class BookService {
    @Autowired
    private BookResitory bookResitory;

    /**
     * 根据书名进行查询
     * @param bookname
     * @return
     */
   /* @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,readOnly = true)*/
    public Book getBook(String bookname) throws BookNotFoundException {
       Book book= bookResitory.findByBookName(bookname);
        if(book==null){
            throw new BookNotFoundException("找不到符合条件的书籍");
        }
        return book;

    }
    /**
     * 根据id,删除书籍
     * @param id
     */
    public void deleteBook(Long id){
        bookResitory.delete(id);
    }
    /**
     * 添加或者修改操作,底层调用得是父级接口里的方法
     * @param book
     */
    public void addOrUpdate(Book book){

        bookResitory.save(book);
    }


}