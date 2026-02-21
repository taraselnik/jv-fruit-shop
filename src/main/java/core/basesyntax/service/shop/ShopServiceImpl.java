package core.basesyntax.service.shop;

import core.basesyntax.model.operations.strategy.OperationStrategy;
import core.basesyntax.model.transaction.FruitTransaction;

import java.util.List;


public class ShopServiceImpl implements ShopService {

  public ShopServiceImpl(OperationStrategy operationStrategy) {}

  @Override public boolean process(List<FruitTransaction> transactions) {
    return false;
  }
}
