package paf.lecture.paf_24l.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import paf.lecture.paf_24l.model.Book;

@Repository
public class BookRepository {
    @Autowired
    private JdbcTemplate template;

    public boolean insertBook(Book book) {
        // KeyHolder will return the priamry key back to you
        KeyHolder keyHolder = new GeneratedKeyHolder();
        int added = template.update((Connection con) -> {
            PreparedStatement ps = con.prepareStatement(QueryBooks.CREATE_BOOK);
            ps.setString(1, book.getTitle());
            ps.setInt(2, book.getQuantity());
            return ps;
            },
            keyHolder);
        
        return added > 0;
    }

    public Book getBookById(int id) {
        Book b = template.queryForObject(QueryBooks.GET_BOOK_BY_ID, BeanPropertyRowMapper.newInstance(Book.class), id);
        return b;
    }

    public boolean updateBook(Book book) {
        int updated = template.update(QueryBooks.UPDATE_BOOK, book.getTitle(), book.getQuantity(), book.getId());
        return updated > 0;
    }

    public List<Book> getAllBooks() {
        List<Book> books = template.query(QueryBooks.ALL_BOOKS, BeanPropertyRowMapper.newInstance(Book.class));

        if (books.isEmpty()) {
            // throw new BookNotfounException(".....");
        }

        return books;
    }

}
