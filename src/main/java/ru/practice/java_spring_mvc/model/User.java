package ru.practice.java_spring_mvc.model;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.practice.java_spring_mvc.view.Views;

import java.util.ArrayList;
import java.util.List;

/**
 * User
 *
 * @author agent
 * @since 08.12.2025
 */
@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Views.UserSummary.class)
    private Long id;

    @JsonView(Views.UserSummary.class)
    @Column(nullable = false)
    private String name;

    @JsonView(Views.UserSummary.class)
    @Column(nullable = false)
    private String surname;

    @JsonView(Views.UserSummary.class)
    @Column(nullable = false, unique = true)
    private String email;

    @JsonView(Views.UserSummary.class)
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders = new ArrayList<>();
}