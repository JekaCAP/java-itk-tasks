package ru.practice.spring_mvc_library.mapper;

import org.mapstruct.Mapper;
import ru.practice.spring_mvc_library.model.Author;
import ru.practice.spring_mvc_library.model.dto.AuthorRequest;
import ru.practice.spring_mvc_library.model.dto.AuthorResponse;

/**
 * AuthorMapper
 *
 * @author agent
 * @since 09.12.2025
 */
@Mapper(componentModel = "spring")
public interface AuthorMapper {

    Author toEntity(AuthorRequest request);

    AuthorResponse toDto(Author author);
}