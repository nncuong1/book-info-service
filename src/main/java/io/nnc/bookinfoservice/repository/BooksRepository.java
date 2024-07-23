package io.nnc.bookinfoservice.repository;

import io.nnc.bookinfoservice.entity.BookEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepository extends JpaRepository<BookEntity, Long> {
  List<BookEntity> findAllByNumPages(Integer num);
}
