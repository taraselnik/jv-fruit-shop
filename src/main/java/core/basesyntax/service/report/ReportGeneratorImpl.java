package core.basesyntax.service.report;

import core.basesyntax.dao.FruitDao;

import java.util.stream.Collectors;


public class ReportGeneratorImpl implements ReportGenerator {

  @Override
  public String getReport(FruitDao fruitDao) {
    if (fruitDao == null) {
      throw new IllegalArgumentException("FruitDao can't be null");
    }
    String reportHeader = "fruit,quantity\n";
    String reportBody = "";
    reportBody = fruitDao.getAll().entrySet().stream()
            .map(entry -> entry.getKey() + "," + entry.getValue())
            .collect(Collectors.joining("\n"));
    return reportHeader + reportBody;
  }
}
