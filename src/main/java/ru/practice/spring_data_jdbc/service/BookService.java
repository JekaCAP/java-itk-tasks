package ru.practice.spring_data_jdbc.service;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.practice.spring_data_jdbc.model.Book;
import ru.practice.spring_data_jdbc.repository.BookRepository;

import java.util.List;

/**
 * BookService
 *
 * @author agent
 * @since 12.12.2025
 */
@AllArgsConstructor
@Service
public class BookService {

    private final BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        String.format("Book with id %s not found", id)
                ));
    }

    public Book createBook(Book book) {
        validateBook(book);
        return bookRepository.save(book);
    }

    public Book updateBook(Long id, Book book) {
        getBookById(id);

        book.setId(id);

        validateBook(book);
        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        getBookById(id);

        bookRepository.deleteById(id);
    }

    private void validateBook(Book book) {
        if (book.getTitle() == null || book.getTitle().isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Title is required"
            );
        }
        if (book.getAuthor() == null || book.getAuthor().isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Author is required"
            );
        }
        if (book.getPublicationYear() == null || book.getPublicationYear() <= 0) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Publication year must be a positive integer"
            );
        }
    }
}