package exampletest;
import com.spring.jpa.exception.BookNotFoundException;
import com.spring.jpa.model.Book;
import com.spring.jpa.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * TransactionTest
 *
 * @author guisheng.deng
 * @date 2017年04月12日
 * @reviewer
 * @description
 * @see
 */
    @RunWith(SpringJUnit4ClassRunner.class)
    @ContextConfiguration(locations = "classpath:applicationContext.xml")
    public class TransactionTest {
        @Autowired
        private  BookService bookService;
        @Test
        public void addBook(){
            Book book=new Book();
            book.setBookName("西游记");
            bookService.addOrUpdate(book);
        }
        @Test
        public void  getBook(){

            Book book= null;
            try {
                book = bookService.getBook("西游记");
                book.setBookName("张三丰外传");
                bookService.addOrUpdate(book);
            } catch (BookNotFoundException e) {
                e.printStackTrace();
            }



        }
      @Test
      public void addTest(){
            Book book=new Book();
            book.setBookName("传奇");
            bookService.addOrUpdate(book);
      }
      @Test
      public void queryTest(){

          try {
              bookService.getBook("传奇1");
              bookService.deleteBook(4L);
          } catch (BookNotFoundException e) {
              e.printStackTrace();
          }


      }
    }
