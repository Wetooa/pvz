public class Mushroom extends Plant {

  public boolean state = false;

  public Mushroom(String name, int sun_cost) {
    super(name, sun_cost);
  }

  boolean isAwake() {
    return state;
  }

  void awaken() {
    state = true;
  }

  public class DoomShroom extends Mushroom implements Attacker, InstantKiller {

    public DoomShroom() {
      super("Doom Shroom", 125);
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

  public class PuffShroom extends Mushroom implements Attacker {

    public PuffShroom() {
      super("Puff Shroom", 0);
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

    public class WallNut {}
  }

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
}
