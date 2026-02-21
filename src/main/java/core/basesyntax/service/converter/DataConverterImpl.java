package core.basesyntax.service.converter;

import core.basesyntax.model.transaction.FruitTransaction;

import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
  @Override
  public List<FruitTransaction> convertToTransaction(List<String> inputReport) {
    if (inputReport == null) {
      throw new IllegalArgumentException("Input report can't be null");
    }

    List<FruitTransaction> transactions = new ArrayList<>();
    for (int i = 0; i < inputReport.size(); i++) {
      String line = inputReport.get(i);
      if (line == null || line.isBlank()) {
        continue;
      }
      if (i == 0 && line.toLowerCase().startsWith("type,")) {
        continue;
      }

      String[] parts = line.split(",");
      if (parts.length != 3) {
        throw new IllegalArgumentException("Invalid report line: " + line);
      }

      FruitTransaction.Operation operation = parseOperation(parts[0].trim());
      String fruit = parts[1].trim();
      int quantity = 0;
      try {
        quantity = Integer.parseInt(parts[2].trim());
      } catch (NumberFormatException e) {
        throw new RuntimeException("Invalid quantity: " + parts[2], e);
      }

      transactions.add(new FruitTransaction(operation, fruit, quantity));
    }
    return transactions;
  }

  private FruitTransaction.Operation parseOperation(String code) {
    for (FruitTransaction.Operation operation : FruitTransaction.Operation.values()) {
      if (operation.getCode().equals(code)) {
        return operation;
      }
    }
    throw new IllegalArgumentException("Unknown operation code: " + code);
  }
}
