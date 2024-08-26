package io.nnc.bookinfoservice.service.filter;

import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("ConstructorOperationChainCollector")
@Slf4j
public class ConstructorOperationChainCollector implements IBookFilter {

  private final List<IBookFilter> operationFilters;

  public ConstructorOperationChainCollector(
      @Qualifier("FilterA") IBookFilter filterA, @Qualifier("FilterB") IBookFilter filterB) {
    operationFilters = new ArrayList<>();
    operationFilters.add(filterA);
    operationFilters.add(filterB);
  }

  @Override
  public List<BookFilter> filter(List<BookFilter> filters) {
    for (IBookFilter filterChain : operationFilters) {
      if (filters.isEmpty()) {
        break;
      }

      filters = filterChain.filter(filters);
    }
    return filters;
  }
}
