package io.nnc.bookinfoservice.controller;

import io.nnc.bookinfoservice.model.Book;
import io.nnc.bookinfoservice.service.BooksService;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/books")
@RequiredArgsConstructor
public class BooksController {

  private final BooksService booksService;

  @GetMapping("/{id}")
  public ResponseEntity<Book> getTutorialById(@PathVariable("id") Long id) {
    Optional<Book> bookData = booksService.findById(id);

    return bookData
        .map(bookEntity -> new ResponseEntity<>(bookEntity, HttpStatus.OK))
        .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @GetMapping("/check")
  public ResponseEntity<String> checkConnection() {
    booksService.check();
    return new ResponseEntity<>("Success", HttpStatus.OK);
  }
}
