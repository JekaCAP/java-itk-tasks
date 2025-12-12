package ru.practice.spring_data_jdbc.repository;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ru.practice.spring_data_jdbc.model.Book;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

/**
 * BookRepository
 *
 * @author agent
 * @since 12.12.2025
 */
@Repository
@AllArgsConstructor
public class BookRepository {

    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<Book> bookRowMapper = (rs, rowNum) -> {
        Book book = new Book();
        book.setId(rs.getLong("id"));
        book.setTitle(rs.getString("title"));
        book.setAuthor(rs.getString("author"));
        book.setPublicationYear(rs.getInt("publication_year"));
        return book;
    };

    public List<Book> findAll() {
        return jdbcTemplate.query("select * from book", bookRowMapper);
    }

    public Optional<Book> findById(Long id) {
        List<Book> books = jdbcTemplate.query("select * from book where id = ?", bookRowMapper, id);
        return books.isEmpty() ? Optional.empty() : Optional.of(books.get(0));
    }

    public Book save(Book book) {
        if (book.getId() == null) {
            return insert(book);
        } else {
            return update(book);
        }
    }

    private Book insert(Book book) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO book (title, author, publication_year) VALUES (?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setInt(3, book.getPublicationYear());

            return ps;
        }, keyHolder);

        book.setId(keyHolder.getKey().longValue());
        return book;
    }

    private Book update(Book book) {
        jdbcTemplate.update("UPDATE book SET title = ?, author = ?, publication_year = ? WHERE id = ?",
                book.getTitle(),
                book.getAuthor(),
                book.getPublicationYear(),
                book.getId()
        );

        return book;
    }

    public void deleteById(Long id) {
        jdbcTemplate.update("DELETE FROM book WHERE id = ?", id);
    }

    public List<Book> findByTitle(String title) {
        return jdbcTemplate.query("select * from book where title = ?", bookRowMapper, title);
    }

    public List<Book> findByPublicationYear(Integer year) {
        return jdbcTemplate.query("select * from book where publication_year = ?", bookRowMapper, year);
    }

}