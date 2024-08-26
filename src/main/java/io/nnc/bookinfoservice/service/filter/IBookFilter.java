package io.nnc.bookinfoservice.service.filter;

import java.util.List;

public interface IBookFilter {
  List<BookFilter> filter(List<BookFilter> filters);
}
