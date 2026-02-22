package core.basesyntax.model.transaction;

import java.math.BigDecimal;
import java.util.Objects;

public class FruitTransaction {

  private final Operation operation;
  private final String fruit;
  private final BigDecimal quantity;

  public FruitTransaction(Operation operation, String fruit, BigDecimal quantity) {
    this.operation = operation;
    this.fruit = fruit;
    this.quantity = quantity;
  }

  public Operation getOperation() {
    return operation;
  }

  public String getFruit() {
    return fruit;
  }

  public BigDecimal getQuantity() {
    return quantity;
  }

  public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private final String code;

    Operation(String code) {
      this.code = code;
    }

    public String getCode() {
      return code;
    }
  }

  @Override public String toString() {
    return "FruitTransaction{" +
            "operation=" + operation +
            ", fruit='" + fruit + '\'' +
            ", quantity=" + quantity +
            '}';
  }

  @Override public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    FruitTransaction that = (FruitTransaction) o;
    return operation == that.operation
            && Objects.equals(fruit, that.fruit)
            && Objects.equals(quantity, that.quantity);
  }

  @Override public int hashCode() {
    return Objects.hash(operation, fruit, quantity);
  }
}
