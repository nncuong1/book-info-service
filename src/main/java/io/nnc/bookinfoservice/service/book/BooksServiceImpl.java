package io.nnc.bookinfoservice.service.book;

import io.nnc.bookinfoservice.entity.BookEntity;
import io.nnc.bookinfoservice.model.Book;
import io.nnc.bookinfoservice.repository.BooksRepository;
import io.nnc.bookinfoservice.util.CompletableFutureUtils;
import io.nnc.bookinfoservice.util.ModelMapperUtils;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class BooksServiceImpl implements BooksService {
  private final BooksRepository booksRepository;

  private final CompletableFutureUtils completableFutureUtils;

  private final Executor executor;

  @Autowired
  public BooksServiceImpl(
      BooksRepository booksRepository,
      CompletableFutureUtils completableFutureUtils,
      @Qualifier("threadPoolTaskExecutor") Executor executor) {
    this.booksRepository = booksRepository;
    this.completableFutureUtils = completableFutureUtils;
    this.executor = executor;
  }

    @Override
  public Optional<Book> findById(Long id) {
    Optional<BookEntity> optionalBookEntity = booksRepository.findById(id);

    return optionalBookEntity.map(e -> ModelMapperUtils.mapper(e, Book.class));
  }

  @Override
  public void check() {
    long startTime = System.currentTimeMillis();
    int numPage = 815;
    List<CompletableFuture<List<Book>>> completableFutures = new ArrayList<>();
    for (int i = 0; i < 20; i++) {
      int finalNumPage = numPage;
      CompletableFuture<List<Book>> listCompletableFutures =
          CompletableFuture.supplyAsync(
              () ->
                  ModelMapperUtils.mapList(
                      booksRepository.findAllByNumPages(finalNumPage), Book.class),
              executor);
      numPage++;
      completableFutures.add(listCompletableFutures);
    }
    List<Book> books =
        completableFutureUtils.getAllCompleted(completableFutures).stream()
            .flatMap(Collection::stream)
            .collect(Collectors.toList());
    long endTime = System.currentTimeMillis();
    log.info("> check : {} took {}", books.size(), endTime - startTime);
  }
}
