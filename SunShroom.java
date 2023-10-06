public class SunShroom extends Mushroom implements SunProducer {

  public SunShroom() {
    super("Sun Shroom", 10);
  }

  @Override
  public int produce_sun() {
    if (isAwake()) return 10; else System.out.println(
      name + " is asleep and cannot produce sun"
    );
    return 0;
  }
}
