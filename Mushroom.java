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
    this.state = true;
  }

  public static class DoomShroom
    extends Mushroom
    implements Attacker, InstantKiller {

    public DoomShroom(boolean state) {
      super("Doom-shroom", 125, state);
    }

    @Override
    public int killType() {
      return 1;
    }

    @Override
    public int attack() {
      if (isAwake() && isAlive()) {
        System.out.println(name + " attacks");
        System.out.println(die());
        return 10;
      } else System.out.println(name + " is asleep and cannot attack");
      return 0;
    }

    @Override
    public int rangeType() {
      return 2;
    }

    @Override
    public String die() {
      hp = 0;
      return super.die() + " while exploding and leaves a crater";
    }
  }

  public static class PuffShroom extends Mushroom implements Attacker {

    public PuffShroom(boolean state) {
      super("Puff-shroom", 0, state);
    }

    @Override
    public int attack() {
      if (isAwake()) {
        System.out.println(name + " attacks");
        return 1;
      } else System.out.println(name + " is asleep and cannot attack");
      return 0;
    }

    @Override
    public int rangeType() {
      return 3;
    }
  }

  public static class SunShroom extends Mushroom implements SunProducer {

    public SunShroom(boolean state) {
      super("Sun-shroom", 25, state);
    }

    @Override
    public int produce_sun() {
      if (isAwake()) {
        System.out.println(name + " produces " + 10 + " suns");
        return 10;
      } else System.out.println(name + " is asleep and cannot produce sun");
      return 0;
    }
  }
}
