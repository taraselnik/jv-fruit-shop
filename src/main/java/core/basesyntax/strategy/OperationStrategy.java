package core.basesyntax.strategy;

import core.basesyntax.strategy.handler.OperationHandler;
import core.basesyntax.model.transaction.FruitTransaction;

public interface OperationStrategy {
    OperationHandler getOperationHandler(FruitTransaction.Operation operation);
}
