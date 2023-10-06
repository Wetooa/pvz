public class Sunflower extends Plant implements SunProducer {

  public Sunflower() {
    super("Sunflower", 50);
  }

  @Override
  public int produce_sun() {
    return 50;
  }
}
