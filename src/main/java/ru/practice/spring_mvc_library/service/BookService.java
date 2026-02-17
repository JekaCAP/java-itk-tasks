package ru.practice.spring_mvc_library.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.practice.spring_mvc_library.mapper.BookMapper;
import ru.practice.spring_mvc_library.model.Book;
import ru.practice.spring_mvc_library.model.dto.BookRequest;
import ru.practice.spring_mvc_library.model.dto.BookResponse;
import ru.practice.spring_mvc_library.repository.AuthorRepository;
import ru.practice.spring_mvc_library.repository.BookRepository;

/**
 * BookService
 *
 * @author agent
 * @since 09.12.2025
 */
@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final BookMapper bookMapper;

    @Transactional(readOnly = true)
    public Page<BookResponse> getAll(Pageable pageable) {
        return bookRepository.findAll(pageable)
                .map(bookMapper::toDto);
    }

    @Transactional(readOnly = true)
    public BookResponse getById(Long id) {
        return bookMapper.toDto(bookRepository.getOrThrow(id));
    }

    @Transactional
    public BookResponse create(BookRequest request) {
        var author = authorRepository.getOrThrow(request.authorId());

        Book book = new Book();
        book.setTitle(request.title());
        book.setPublicationYear(request.year());
        book.setAuthor(author);

        return bookMapper.toDto(bookRepository.save(book));
    }

    @Transactional
    public BookResponse update(Long id, BookRequest request) {
        var book = bookRepository.getOrThrow(id);

        book.setTitle(request.title());
        book.setPublicationYear(request.year());

        return bookMapper.toDto(bookRepository.save(book));
    }

    @Transactional
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }
}