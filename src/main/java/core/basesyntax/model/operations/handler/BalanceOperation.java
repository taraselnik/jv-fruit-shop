package core.basesyntax.model.operations.handler;

import java.math.BigDecimal;

public class BalanceOperation implements OperationHandler {
  @Override
  public String apply(BigDecimal initialQuantity, BigDecimal quantity) {
    validateInputs(initialQuantity, quantity);
    return quantity.toString();
  }
}
