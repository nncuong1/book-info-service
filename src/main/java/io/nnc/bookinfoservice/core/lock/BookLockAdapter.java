package io.nnc.bookinfoservice.core.lock;

import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component("BookLockAdapter")
public class BookLockAdapter extends LockAdapter<String> {

  @PostConstruct
  public void init() {
    setTtl(900);
    setType("book");
    setLockBucketKey("processing_stations");
    initBucket();
  }
}
