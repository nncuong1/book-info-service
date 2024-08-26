package io.nnc.bookinfoservice.service.builder;

public interface ICommonRequestBuildable<T> {
  CommonRequest build(T input);
}
