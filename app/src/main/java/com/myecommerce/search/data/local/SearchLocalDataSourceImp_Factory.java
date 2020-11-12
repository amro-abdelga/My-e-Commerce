package com.myecommerce.search.data.local;

import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class SearchLocalDataSourceImp_Factory implements Factory<SearchLocalDataSourceImp> {
  @Override
  public SearchLocalDataSourceImp get() {
    return newInstance();
  }

  public static SearchLocalDataSourceImp_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static SearchLocalDataSourceImp newInstance() {
    return new SearchLocalDataSourceImp();
  }

  private static final class InstanceHolder {
    private static final SearchLocalDataSourceImp_Factory INSTANCE = new SearchLocalDataSourceImp_Factory();
  }
}
