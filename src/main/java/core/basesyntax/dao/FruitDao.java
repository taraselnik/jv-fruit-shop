package core.basesyntax.dao;

import java.util.Map;


public interface FruitDao {
  boolean update(String fruit, String quantity);
  Map<String, String> getAll();
  String getQuantity(String key);
}
