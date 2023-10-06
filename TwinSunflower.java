public class TwinSunflower extends Plant implements SunProducer {

  public TwinSunflower() {
    super("Twin Sunflower", 125);
  }

  @Override
  public int produce_sun() {
    return 50;
  }
}
