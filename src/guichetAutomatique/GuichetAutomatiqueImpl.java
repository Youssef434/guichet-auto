package guichetAutomatique;

import java.util.Map;
import java.util.stream.Collectors;

public class GuichetAutomatiqueImpl implements GuichetAutomatique {
  private Map<Integer, Integer> argents;


  public GuichetAutomatiqueImpl(Map<Integer, Integer> argents) {
    this.argents = argents;
  }

  @Override
  public void alimenterGA(Map<Integer, Integer> argents) {
    this.argents = this.argents.entrySet().stream()
        .map(entry -> Map.entry(entry.getKey(), entry.getValue() + argents.get(entry.getKey())))
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
  }
}
