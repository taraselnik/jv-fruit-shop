package core.basesyntax.dao;

import core.basesyntax.db.Storage;

import java.util.Map;


public class FruitDaoImpl implements FruitDao {
  private final Storage storage;

  public FruitDaoImpl(Storage storage) {
    this.storage = storage;
  }

  @Override
  public boolean update(String fruit, String quantity) {
    return storage.update(fruit, quantity);
  }

  @Override
  public Map<String, String> getAll() {
    return storage.getAll();
  }

  @Override
  public String getQuantity(String key) {
    return storage.getAll().get(key);
  }
}
