package core.basesyntax;

import core.basesyntax.service.dataConverter.DataConverter;
import core.basesyntax.service.dataConverter.DataConverterImpl;
import core.basesyntax.model.transaction.FruitTransaction;
import core.basesyntax.service.dataReader.DataReader;
import core.basesyntax.service.dataReader.FileReaderImpl;

import java.nio.file.Path;
import java.util.List;


public class Main {
  private static final Path ROOT_PATH = Path.of("src", "main", "java", "resources");
  private static final Path INPUT_PATH = ROOT_PATH.resolve("reportToRead.csv");
  private static final Path REPORT_PATH = ROOT_PATH.resolve("finalReport.csv");

  public static void main(String[] arg) {
    // 1. Read the data from the input CSV file
    DataReader fileReader = new FileReaderImpl();
    List<String> inputReport = fileReader.read(INPUT_PATH.toString());

    // 2. Convert the incoming data into FruitTransactions list
    DataConverter dataConverter = new DataConverterImpl();
    List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);
//
//    // 3. Create and feel the map with all OperationHandler implementations
//    Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
//    operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
//    operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
//    operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
//    operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
//    OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);
//
//    // 4. Process the incoming transactions with applicable OperationHandler implementations
//    ShopService shopService = new ShopServiceImpl(operationStrategy);
//    shopService.process(transactions);
//
//    // 5.Generate report based on the current Storage state
//    ReportGenerator reportGenerator = new ReportGeneratorImpl();
//    String resultingReport = reportGenerator.getReport();
//
//    // 6. Write the received report into the destination file
//    FileWriter fileWriter = new FileWriterImpl();
//    fileWriter.write(resultingReport, "finalReport.csv");
  }
}
