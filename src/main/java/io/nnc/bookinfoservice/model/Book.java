package io.nnc.bookinfoservice.model;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Book {

  private Long bookId;

  private String title;

  private String authors;

  private double averageRating;

  private String isbn;

  private String isbn13;

  private String languageCode;

  private int numPages;

  private long ratingsCount;

  private long textReviewsCount;

  private LocalDateTime created;

  private LocalDateTime modified;
}
