package ru.practice.spring_data_jdbc.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * Book
 *
 * @author agent
 * @since 12.12.2025
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table("book")
public class Book {

    @Id
    private Long id;

    @Column("title")
    private String title;

    @Column("author")
    private String author;

    @Column("publication_year")
    private Integer publicationYear;
}