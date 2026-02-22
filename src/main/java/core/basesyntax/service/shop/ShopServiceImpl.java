package core.basesyntax.service.shop;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.operations.handler.OperationHandler;
import core.basesyntax.model.operations.strategy.OperationStrategy;
import core.basesyntax.model.transaction.FruitTransaction;
import java.math.BigDecimal;
import java.util.List;

public class ShopServiceImpl implements ShopService {

    private final OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        if (operationStrategy == null) {
            throw new IllegalArgumentException("Operation strategy can't be null");
        }
        this.operationStrategy = operationStrategy;
    }

    @Override
    public boolean process(List<FruitTransaction> transactions, FruitDao fruitDao) {
        if (transactions == null) {
            throw new IllegalArgumentException("Transactions can't be null");
        }
        if (fruitDao == null) {
            throw new IllegalArgumentException("FruitDao can't be null");
        }
        for (FruitTransaction transaction : transactions) {
            if (transaction == null) {
                continue;
            }
            String fruit = transaction.getFruit();
            String storedQuantityStr = fruitDao.getQuantity(fruit);
            BigDecimal storedQuantity = storedQuantityStr == null
                    ? BigDecimal.ZERO
                    : new BigDecimal(storedQuantityStr);

            OperationHandler handler = operationStrategy.getOperationHandler(
                    transaction.getOperation());
            String newQuantity = handler.apply(storedQuantity, transaction.getQuantity());
            fruitDao.update(fruit, newQuantity);
        }
        return true;
    }
}
