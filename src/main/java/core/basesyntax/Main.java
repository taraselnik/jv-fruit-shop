package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.db.StorageImpl;
import core.basesyntax.model.operations.handler.BalanceOperation;
import core.basesyntax.model.operations.handler.OperationHandler;
import core.basesyntax.model.operations.handler.PurchaseOperation;
import core.basesyntax.model.operations.handler.ReturnOperation;
import core.basesyntax.model.operations.handler.SupplyOperation;
import core.basesyntax.model.operations.strategy.OperationStrategy;
import core.basesyntax.model.operations.strategy.OperationStrategyImpl;
import core.basesyntax.service.converter.DataConverter;
import core.basesyntax.service.converter.DataConverterImpl;
import core.basesyntax.model.transaction.FruitTransaction;
import core.basesyntax.service.reader.DataReader;
import core.basesyntax.service.reader.FileReaderImpl;
import core.basesyntax.service.report.ReportGenerator;
import core.basesyntax.service.report.ReportGeneratorImpl;
import core.basesyntax.service.shop.ShopService;
import core.basesyntax.service.shop.ShopServiceImpl;
import core.basesyntax.service.writer.FileWriter;
import core.basesyntax.service.writer.FileWriterImpl;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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

    // 3. Create and feel the map with all OperationHandler implementations
    Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
    operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
    operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
    operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
    operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
    OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

    // 4. Process the incoming transactions with applicable OperationHandler implementations
    ShopService shopService = new ShopServiceImpl(operationStrategy);
    Storage storage = new StorageImpl();
    FruitDao fruitDao = new FruitDaoImpl(storage);
    shopService.process(transactions, fruitDao);

    // 5.Generate report based on the current Storage state
    ReportGenerator reportGenerator = new ReportGeneratorImpl();
    String resultingReport = reportGenerator.getReport(fruitDao);

    // 6. Write the received report into the destination file
    FileWriter fileWriter = new FileWriterImpl();
    fileWriter.write(resultingReport, REPORT_PATH.toString());
  }
}
