package com.example.BookApi.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    private Long id;
    @Size(min = 2, max = 100, message = "Book name must be between 2 and 100 characters.")
    @NotBlank(message = "Book name is required.")
    private String name;
    @NotBlank(message = "Author name is required.")
    private String author;

    private String genre;

    private String description;
}
