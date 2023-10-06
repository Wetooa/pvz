public class Peashooter extends Plant implements Attacker {

  public Peashooter() {
    super("Peashooter", 100);
  }

  @Override
  public int attack() {
    return 1;
  }

  @Override
  public int rangeType() {
    return 1;
  }
}
