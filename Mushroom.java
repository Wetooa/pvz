public class Mushroom extends Plant {

  public boolean state = false;

  public Mushroom(String name, int sun_cost, boolean state) {
    super(name, sun_cost);
    this.state = state;
  }

  boolean isAwake() {
    return state;
  }

  void awaken() {
    state = true;
  }

  public static class DoomShroom
    extends Mushroom
    implements Attacker, InstantKiller {

    public DoomShroom(boolean state) {
      super("Doom Shroom", 125, state);
    }

    @Override
    public int killType() {
      return 1;
    }

    @Override
    public int attack() {
      return 10;
    }

    @Override
    public int rangeType() {
      return 2;
    }

    @Override
    public String die() {
      return super.die() + " while exploding and leaves a crater";
    }
  }

  public static class PuffShroom extends Mushroom implements Attacker {

    public PuffShroom(boolean state) {
      super("Puff Shroom", 0, state);
    }

    @Override
    public int attack() {
      if (isAwake()) return 1; else System.out.println(
        name + " is asleep and cannot attack"
      );
      return 0;
    }

    @Override
    public int rangeType() {
      return 4;
    }
  }

  public static class SunShroom extends Mushroom implements SunProducer {

    public SunShroom(boolean state) {
      super("Sun Shroom", 10, state);
    }

    @Override
    public int produce_sun() {
      if (isAwake()) return 10; else System.out.println(
        name + " is asleep and cannot produce sun"
      );
      return 0;
    }
  }
}
