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
    return name + " (" + hp + ") - cost: " + sun_cost;
  }

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

  public class Sunflower extends Plant implements SunProducer {

    public Sunflower() {
      super("Sunflower", 50);
    }

    @Override
    public int produce_sun() {
      return 50;
    }
  }

  public class TwinSunflower extends Plant implements SunProducer {

    public TwinSunflower() {
      super("Twin Sunflower", 125);
    }

    @Override
    public int produce_sun() {
      return 50;
    }
  }
}
