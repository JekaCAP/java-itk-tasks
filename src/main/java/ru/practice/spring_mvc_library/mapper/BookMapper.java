package ru.practice.spring_mvc_library.mapper;

import org.mapstruct.Mapper;
import ru.practice.spring_mvc_library.model.Book;
import ru.practice.spring_mvc_library.model.dto.BookResponse;

/**
 * BookMapper
 *
 * @author agent
 * @since 09.12.2025
 */
@Mapper(componentModel = "spring")
public interface BookMapper {

    default BookResponse toDto(Book book) {
        if (book == null) return null;
        return new BookResponse(
                book.getId(),
                book.getTitle(),
                book.getPublicationYear(),
                book.getAuthor() != null ? book.getAuthor().getName() : null
        );
    }

}