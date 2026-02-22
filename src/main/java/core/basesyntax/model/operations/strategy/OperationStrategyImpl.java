package core.basesyntax.model.operations.strategy;

import core.basesyntax.model.operations.handler.OperationHandler;
import core.basesyntax.model.transaction.FruitTransaction;

import java.util.Map;


public class OperationStrategyImpl implements OperationStrategy {

  private final Map<FruitTransaction.Operation, OperationHandler> operationHandlers;

  public OperationStrategyImpl(Map<FruitTransaction.Operation, OperationHandler> operationHandlers) {
    if (operationHandlers == null) {
      throw new IllegalArgumentException("Operation handlers map can't be null");
    }
    this.operationHandlers = operationHandlers;
  }

  @Override public OperationHandler getOperationHandler(FruitTransaction.Operation operation) {
    OperationHandler handler = operationHandlers.get(operation);
    if (handler == null) {
      throw new IllegalArgumentException("No handler for operation: " + operation);
    }
    return handler;
  }
}
