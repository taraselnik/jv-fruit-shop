package core.basesyntax.service.shop;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.transaction.FruitTransaction;
import java.util.List;

public interface ShopService {
    boolean process(List<FruitTransaction> transactions, FruitDao fruitDao);
}
