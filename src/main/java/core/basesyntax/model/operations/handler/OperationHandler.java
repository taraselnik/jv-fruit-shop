package core.basesyntax.model.operations.handler;

import java.math.BigDecimal;


public interface OperationHandler {
  String apply(BigDecimal initialQuantity, BigDecimal quantity);

  default boolean isValidToApply(BigDecimal initialQuantity, BigDecimal quantity) {
    if (initialQuantity == null || quantity == null) {
      throw new IllegalArgumentException("Initial quantity or quantity cannot be null");
    }
    if (quantity.compareTo(BigDecimal.ZERO) < 0) {
      throw new IllegalArgumentException("Quantity cannot be negative");
    }
    return true;
  }
}
