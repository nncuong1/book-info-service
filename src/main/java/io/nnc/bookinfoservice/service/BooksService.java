package io.nnc.bookinfoservice.service;

import io.nnc.bookinfoservice.model.Book;
import java.util.Optional;

public interface BooksService {
  Optional<Book> findById(Long id);

  void check();
}
