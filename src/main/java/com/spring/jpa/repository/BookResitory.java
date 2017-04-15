package com.spring.jpa.repository;

import com.spring.jpa.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * AccountResitory
 *
 * @author guisheng.deng
 * @date 2017年04月12日
 * @reviewer
 * @description
 * @see
 */
@Repository
public interface BookResitory extends JpaRepository<Book,Long> {
    Book findByBookName(String bookName);

    //调用父级接口中的save()方法实现修改或增加操作CrudRepository接口

    //调用父级接口中的delete()方法实现删除操作CrudRepository接口

    Book findByBookId(Long id);
}
