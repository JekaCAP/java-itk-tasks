package ru.practice.spring_mvc_library.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.practice.spring_mvc_library.model.Author;
import ru.practice.spring_mvc_library.model.dto.AuthorRequest;
import ru.practice.spring_mvc_library.model.dto.AuthorResponse;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-09T11:56:36+0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.5 (Amazon.com Inc.)"
)
@Component
public class AuthorMapperImpl implements AuthorMapper {

    @Override
    public Author toEntity(AuthorRequest request) {
        if ( request == null ) {
            return null;
        }

        Author author = new Author();

        return author;
    }

    @Override
    public AuthorResponse toDto(Author author) {
        if ( author == null ) {
            return null;
        }

        Long id = null;
        String name = null;

        AuthorResponse authorResponse = new AuthorResponse( id, name );

        return authorResponse;
    }
}
