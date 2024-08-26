package io.nnc.bookinfoservice.service.filter;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component("PostConstructOperationChainCollector")
@Slf4j
@RequiredArgsConstructor
public class PostConstructOperationChainCollector implements IBookFilter {

  private final FilterA filterA;
  private final FilterB filterB;
  private final List<IBookFilter> operationFilters = new ArrayList<>();

  @PostConstruct
  public void initOperations() {
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
