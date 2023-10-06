import java.util.Comparator;

public class Comparators {

  public static class HPComparator implements Comparator<Plant> {

    @Override
    public int compare(Plant o1, Plant o2) {
      int a = o2.hp - o1.hp;
      if (a == 0) return o1.name.compareTo(o2.name);
      return a;
    }
  }

  public static class NameComparator implements Comparator<Plant> {

    @Override
    public int compare(Plant o1, Plant o2) {
      return o1.name.compareTo(o2.name);
    }
  }

  public static class SunCostComparator implements Comparator<Plant> {

    @Override
    public int compare(Plant o1, Plant o2) {
      int a = o2.sun_cost - o1.sun_cost;
      if (a == 0) return o1.name.compareTo(o2.name);
      return a;
    }
  }
}