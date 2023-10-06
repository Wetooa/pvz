public abstract class Plant {

  public String name;
  public int hp = 6;
  public int sun_cost;

  public Plant(String name, int sun_cost) {
    this.name = name;
    this.sun_cost = sun_cost;
  }

  public Plant(String name, int hp, int sun_cost) {
    this.name = name;
    this.hp = hp;
    this.sun_cost = sun_cost;
  }

  boolean isAlive() {
    return hp > 0;
  }

  String die() {
    return name + " dies";
  }

  @Override
  public String toString() {
    return (
      name +
      " (" +
      (hp == Integer.MAX_VALUE ? "∞" : hp) +
      ") - cost: " +
      sun_cost
    );
  }

  public static class Jalapeno
    extends Plant
    implements Attacker, InstantKiller {

    public Jalapeno() {
      super("Jalapeno", Integer.MAX_VALUE, 125);
    }

    public int killType() {
      return 1;
    }

    public int attack() {
      System.out.println(name + " attacks");
      die();
      return 5;
    }

    public int rangeType() {
      return 1;
    }

    @Override
    public String die() {
      hp = 0;
      return super.die() + " while exploding";
    }
  }

  public static class LilyPad extends Plant implements Upgradable {

    public LilyPad() {
      super("Lily Pad", 25);
    }

    public PlantUpgrade upgrade() {
      PlantUpgrade upgraded = new Cattail();
      return upgraded;
    }
  }

  public static class Cattail extends Plant implements PlantUpgrade, Attacker {

    public Cattail() {
      super("Cattail", 225);
    }

    public int concurrentSunCost() {
      return 25;
    }

    public int attack() {
      System.out.println(name + " attacks");
      return 1;
    }

    public int rangeType() {
      return 4;
    }
  }

  public static class Peashooter extends Plant implements Attacker {

    public Peashooter() {
      super("Peashooter", 100);
    }

    @Override
    public int attack() {
      System.out.println(name + " attacks");
      return 1;
    }

    @Override
    public int rangeType() {
      return 1;
    }
  }

  public static class Sunflower
    extends Plant
    implements SunProducer, Upgradable {

    public Sunflower() {
      super("Sunflower", 50);
    }

    @Override
    public int produce_sun() {
      System.out.println(name + " produces " + 25 + " suns");
      return 25;
    }

    public PlantUpgrade upgrade() {
      PlantUpgrade upgraded = new TwinSunflower();
      return upgraded;
    }
  }

  public static class TwinSunflower
    extends Plant
    implements SunProducer, PlantUpgrade {

    public TwinSunflower() {
      super("Twin Sunflower", 125);
    }

    @Override
    public int produce_sun() {
      System.out.println(name + " produces " + 50 + " suns");
      return 50;
    }

    public int concurrentSunCost() {
      return 50;
    }
  }

  public static class Squash extends Plant implements Attacker, InstantKiller {

    public Squash() {
      super("Squash", Integer.MAX_VALUE, 50);
    }

    @Override
    public int killType() {
      return 2;
    }

    @Override
    public int attack() {
      System.out.println(name + " attacks");
      die();
      return 3;
    }

    @Override
    public int rangeType() {
      return 4;
    }

    @Override
    public String die() {
      hp = 0;
      return super.die() + " while squashing zombies";
    }
  }

  public static class WallNut extends Plant {

    public WallNut() {
      super("Wall Nut", 25, 50);
    }
  }
}
