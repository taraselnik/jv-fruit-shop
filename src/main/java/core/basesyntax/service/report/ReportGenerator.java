package core.basesyntax.service.report;

import core.basesyntax.dao.FruitDao;

public interface ReportGenerator {
    String getReport(FruitDao fruitDao);
}
