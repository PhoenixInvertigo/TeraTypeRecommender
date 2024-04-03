public class TypeWeaknessChart {

    /**
     * Gets the defensive multiplier of the type matchup.
     *
     * @param defending The type of the defending Pokemon.
     * @param attacking The type of attack.
     * @return The defensive multiplier of this matchup.
     */

    static public double getWeakness(Types defending, Types attacking){
        return switch (defending) {
            case NORMAL -> switch (attacking) {
                case NORMAL, FIRE, WATER, GRASS, ELECTRIC, ICE, POISON, GROUND, FLYING, PSYCHIC, BUG, ROCK, DRAGON, DARK, STEEL, FAIRY ->
                        1;
                case FIGHTING -> 2;
                case GHOST -> 0;
            };
            case FIRE -> switch (attacking) {
                case NORMAL, ELECTRIC, FIGHTING, POISON, FLYING, PSYCHIC, GHOST, DRAGON, DARK -> 1;
                case FIRE, GRASS, ICE, BUG, STEEL, FAIRY -> .5;
                case WATER, GROUND, ROCK -> 2;
            };
            case WATER -> switch (attacking) {
                case NORMAL, FIGHTING, POISON, GROUND, FLYING, PSYCHIC, BUG, ROCK, GHOST, DRAGON, DARK, FAIRY -> 1;
                case FIRE, WATER, ICE, STEEL -> .5;
                case GRASS, ELECTRIC -> 2;
            };
            case GRASS -> switch (attacking) {
                case NORMAL, FIGHTING, PSYCHIC, ROCK, GHOST, DRAGON, DARK, STEEL, FAIRY -> 1;
                case FIRE, ICE, POISON, FLYING, BUG -> 2;
                case WATER, GRASS, ELECTRIC, GROUND -> .5;
            };
            case ELECTRIC -> switch (attacking) {
                case NORMAL, FIRE, WATER, GRASS, ICE, FIGHTING, POISON, PSYCHIC, BUG, ROCK, GHOST, DRAGON, DARK, FAIRY ->
                        1;
                case ELECTRIC, FLYING, STEEL -> .5;
                case GROUND -> 2;
            };
            case ICE -> switch (attacking) {
                case NORMAL, WATER, GRASS, ELECTRIC, POISON, GROUND, FLYING, PSYCHIC, BUG, GHOST, DRAGON, DARK, FAIRY ->
                        1;
                case FIRE, FIGHTING, ROCK, STEEL -> 2;
                case ICE -> .5;
            };
            case FIGHTING -> switch (attacking) {
                case NORMAL, FIRE, WATER, GRASS, ELECTRIC, ICE, FIGHTING, POISON, GROUND, GHOST, DRAGON, STEEL -> 1;
                case FLYING, PSYCHIC, FAIRY -> 2;
                case BUG, ROCK, DARK -> .5;
            };
            case POISON -> switch (attacking) {
                case NORMAL, FIRE, WATER, ELECTRIC, ICE, FLYING, ROCK, GHOST, DRAGON, DARK, STEEL -> 1;
                case GRASS, FIGHTING, POISON, BUG, FAIRY -> .5;
                case GROUND, PSYCHIC -> 2;
            };
            case GROUND -> switch (attacking) {
                case NORMAL, FIRE, FIGHTING, GROUND, FLYING, PSYCHIC, BUG, GHOST, DRAGON, DARK, STEEL, FAIRY -> 1;
                case WATER, GRASS, ICE -> 2;
                case ELECTRIC -> 0;
                case POISON, ROCK -> .5;
            };
            case FLYING -> switch (attacking) {
                case NORMAL, FIRE, WATER, POISON, FLYING, PSYCHIC, GHOST, DRAGON, DARK, STEEL, FAIRY -> 1;
                case GRASS, FIGHTING, BUG -> .5;
                case ELECTRIC, ICE, ROCK -> 2;
                case GROUND -> 0;
            };
            case PSYCHIC -> switch (attacking) {
                case NORMAL, FIRE, WATER, GRASS, ELECTRIC, ICE, POISON, GROUND, FLYING, ROCK, DRAGON, STEEL, FAIRY -> 1;
                case FIGHTING, PSYCHIC -> .5;
                case BUG, GHOST, DARK -> 2;
            };
            case BUG -> switch (attacking) {
                case NORMAL, WATER, ELECTRIC, ICE, POISON, PSYCHIC, BUG, GHOST, DRAGON, DARK, STEEL, FAIRY -> 1;
                case FIRE, FLYING, ROCK -> 2;
                case GRASS, FIGHTING, GROUND -> .5;
            };
            case ROCK -> switch (attacking) {
                case NORMAL, FIRE, POISON, FLYING -> .5;
                case WATER, GRASS, FIGHTING, GROUND, STEEL -> 2;
                case ELECTRIC, ICE, PSYCHIC, BUG, ROCK, GHOST, DRAGON, DARK, FAIRY -> 1;
            };
            case GHOST -> switch (attacking) {
                case NORMAL, FIGHTING -> 0;
                case FIRE, WATER, GRASS, ELECTRIC, ICE, GROUND, FLYING, PSYCHIC, ROCK, DRAGON, STEEL, FAIRY -> 1;
                case POISON, BUG -> .5;
                case GHOST, DARK -> 2;
            };
            case DRAGON -> switch (attacking) {
                case NORMAL, FIGHTING, POISON, GROUND, FLYING, PSYCHIC, BUG, ROCK, GHOST, DARK, STEEL -> 1;
                case FIRE, WATER, GRASS, ELECTRIC -> .5;
                case ICE, DRAGON, FAIRY -> 2;
            };
            case DARK -> switch (attacking) {
                case NORMAL, FIRE, WATER, GRASS, ELECTRIC, ICE, POISON, GROUND, FLYING, ROCK, DRAGON, STEEL -> 1;
                case FIGHTING, BUG, FAIRY -> 2;
                case PSYCHIC -> 0;
                case GHOST, DARK -> .5;
            };
            case STEEL -> switch (attacking) {
                case NORMAL, GRASS, ICE, FLYING, PSYCHIC, BUG, ROCK, DRAGON, STEEL, FAIRY -> .5;
                case FIRE, FIGHTING, GROUND -> 2;
                case WATER, ELECTRIC, GHOST, DARK -> 1;
                case POISON -> 0;
            };
            case FAIRY -> switch (attacking) {
                case NORMAL, FIRE, WATER, GRASS, ELECTRIC, ICE, GROUND, FLYING, PSYCHIC, ROCK, GHOST, FAIRY -> 1;
                case FIGHTING, BUG, DARK -> .5;
                case POISON, STEEL -> 2;
                case DRAGON -> 0;
            };
        };

    }
}
