package core.basesyntax.model.operations.strategy;

import core.basesyntax.model.operations.handler.OperationHandler;
import core.basesyntax.model.transaction.FruitTransaction;

import java.util.Map;


public class OperationStrategyImpl implements OperationStrategy {

  public OperationStrategyImpl(Map<FruitTransaction.Operation, OperationHandler> operationHandlers) {}

  @Override public OperationHandler getOperationHandler(FruitTransaction.Operation operation) {
    return null;
  }
}
