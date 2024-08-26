package io.nnc.bookinfoservice.service.filter;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component("FilterA")
@Slf4j
@RequiredArgsConstructor
public class FilterA implements IBookFilter {
  @Override
  public List<BookFilter> filter(List<BookFilter> filters) {
    // todo
    return null;
  }
}
