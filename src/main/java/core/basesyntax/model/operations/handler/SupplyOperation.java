package core.basesyntax.model.operations.handler;

import java.math.BigDecimal;

public class SupplyOperation implements OperationHandler {
    @Override
    public String apply(BigDecimal initialQuantity, BigDecimal quantity) {
        if (!isValidToApply(initialQuantity, quantity)) {
            return initialQuantity.toString();
        }
        return initialQuantity.add(quantity).toString();
    }
}
