package io.nnc.bookinfoservice.service.builder;

import io.nnc.bookinfoservice.service.builder.vo.RequestB;
import org.springframework.stereotype.Component;

@Component
public class RequestBBuildableImpl implements RequestBBuildable {
  @Override
  public CommonRequest build(RequestB input) {
    return null;
  }
}
