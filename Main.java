import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    List<Plant> plants = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    System.out.print("Game Mode: ");
    String mode = sc.nextLine();

    String input;
    do {
      System.out.print("Add a plant: ");
      input = sc.nextLine();
      boolean isAsleep = mode.equals("Night") || mode.equals("Fog");
      switch (input) {
        case "DONE":
          break;
        case "Wall Nut":
          plants.add((new Plant.WallNut()));
          break;
        case "Sun-shroom":
          plants.add(new Mushroom.SunShroom(isAsleep));
          break;
        case "Sunflower":
          plants.add(new Plant.Sunflower());
          break;
        case "Twin Sunflower":
          for (int i = 0; i < plants.size(); ++i) {
            if (plants.get(i) instanceof Plant.Sunflower) {
              plants.set(i, (Plant) ((Upgradable) plants.get(i)).upgrade());
              break;
            }
          }
          break;
        case "Squash":
          plants.add(new Plant.Squash());
          break;
        case "Peashooter":
          plants.add(new Plant.Peashooter());
          break;
        case "Cattail":
          for (int i = 0; i < plants.size(); ++i) {
            if (plants.get(i) instanceof Plant.LilyPad) {
              plants.set(i, (Plant) ((Upgradable) plants.get(i)).upgrade());
              break;
            }
          }
          break;
        case "Lily Pad":
          plants.add(new Plant.LilyPad());
          break;
        case "Jalapeno":
          plants.add(new Plant.Jalapeno());
          break;
        case "Puff-shroom":
          plants.add(new Mushroom.PuffShroom(isAsleep));
          break;
        case "Doom-shroom":
          plants.add(new Mushroom.DoomShroom(isAsleep));
          break;
        case "Coffee Bean":
          for (int i = 0; i < plants.size(); ++i) {
            if (
              plants.get(i) instanceof Mushroom &&
              !((Mushroom) plants.get(i)).isAwake()
            ) {
              ((Mushroom) plants.get(i)).awaken();
              System.out.println("Coffee Bean dies");
              break;
            }
          }
          break;
        default:
          System.out.println(input + " is not a plant");
      }
    } while (!input.equals("DONE"));

    do {
      int n = 0, x = 0;
      System.out.print("Do something: ");
      input = sc.nextLine();
      switch (input) {
        case "DONE":
          break;
        case "Produce Sun":
          for (Plant p : plants) {
            if (p instanceof SunProducer && p.isAlive()) {
              x += ((SunProducer) p).produce_sun();
              ++n;
            }
          }
          System.out.println(n + " sun producers gather " + x + " suns");
          break;
        case "Attack":
          for (Plant p : plants) {
            if (p instanceof Attacker && p.isAlive()) {
              x += ((Attacker) p).attack();
              ++n;
            }
          }
          System.out.println(n + " attackers dealing " + x + " damage");
          break;
        // add more cases here
        case "Instant Kill Status":
          for (Plant p : plants) {
            if (p instanceof InstantKiller && p.isAlive()) {
              ++n;
              System.out.println(
                p.name +
                (
                  ((InstantKiller) p).killType() == 1
                    ? " can kill instantly"
                    : " can kill on contact"
                )
              );
            }
          }
          if (n == 0) System.out.println(
            "You have no plants which can kill instantly"
          );
          break;
        case "Attacker Status":
          for (Plant p : plants) {
            if (p instanceof Attacker && p.isAlive()) {
              ++n;
              int r = ((Attacker) p).rangeType();
              System.out.println(
                p.name +
                (
                  r == 1
                    ? " can attack on a single line"
                    : r == 3
                      ? " can attack only when enemy is nearby"
                      : r == 2
                        ? " can attack using area-of-effect"
                        : " can attack any enemies from anywhere"
                )
              );
            }
          }
          if (n == 0) System.out.println("You have no attackers");
          break;
        case "Sort by HP":
          Collections.sort(plants, new Comparators.HPComparator());
          for (Plant p : plants) {
            System.out.println(p);
          }
          break;
        case "Sort by Name":
          Collections.sort(plants, new Comparators.NameComparator());
          for (Plant p : plants) {
            System.out.println(p);
          }
          break;
        case "Sort by Sun Cost":
          Collections.sort(plants, new Comparators.SunCostComparator());
          for (Plant p : plants) {
            System.out.println(p);
          }
          break;
        default:
          System.out.println("Unknown action: " + input);
      }
    } while (!input.equals("DONE"));
  }
}
