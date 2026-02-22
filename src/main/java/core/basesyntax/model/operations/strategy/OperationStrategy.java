package core.basesyntax.model.operations.strategy;

import core.basesyntax.model.operations.handler.OperationHandler;
import core.basesyntax.model.transaction.FruitTransaction;

public interface OperationStrategy {
    OperationHandler getOperationHandler(FruitTransaction.Operation operation);
}
