interface SunProducer {
  int produce_sun();
}

interface InstantKiller {
  int killType();
}

interface PlantUpgrade {
  int concurrentSunCost();
}

interface Upgradable {
  PlantUpgrade upgrade();
}

interface Attacker {
  int attack();
  int rangeType();
}
