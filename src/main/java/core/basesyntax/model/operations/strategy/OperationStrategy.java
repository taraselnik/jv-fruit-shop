package core.basesyntax.model.operations.strategy;

import core.basesyntax.model.transaction.FruitTransaction;
import core.basesyntax.model.operations.handler.OperationHandler;


public interface OperationStrategy {
    OperationHandler getOperationHandler(FruitTransaction.Operation operation);
}
