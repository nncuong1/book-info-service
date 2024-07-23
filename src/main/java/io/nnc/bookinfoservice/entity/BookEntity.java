package io.nnc.bookinfoservice.entity;

import java.time.LocalDateTime;
import javax.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "books")
public class BookEntity {
  @Id
  @Column(name = "book_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long bookId;

  @Column(name = "title")
  private String title;

  @Column(name = "authors")
  private String authors;

  @Column(name = "average_rating")
  private double averageRating;

  @Column(name = "isbn")
  private String isbn;

  @Column(name = "isbn13")
  private String isbn13;

  @Column(name = "language_code")
  private String languageCode;

  @Column(name = "num_pages")
  private int numPages;

  @Column(name = "ratings_count")
  private long ratingsCount;

  @Column(name = "text_reviews_count")
  private long textReviewsCount;

  @Column(name = "created", insertable = false, updatable = false)
  private LocalDateTime created;

  @Column(name = "modified", insertable = false, updatable = false)
  private LocalDateTime modified;
}
