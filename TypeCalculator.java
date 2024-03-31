import java.util.ArrayList;
import java.util.Collections;

/**
 * Author: Ryo Kilgannon
 * Date: 3/31/2024
 *
 * This class receives one or two Pokemon types,
 * calculates the top 5 recommended defensive tera
 * types, and can have that top 5 list printed via
 * its toString() method.
 */
public class TypeCalculator {

    Types type1;
    Types type2;

    ArrayList<Types> weaknesses = new ArrayList<>();
    ArrayList<TeraResists> teraResists = new ArrayList<>();

    public TypeCalculator(Types type1, Types type2){
        this.type1 = type1;
        this.type2 = type2;

        calculateWeaknesses();
        calculateTeraResists();
    }

    /**
     * Determines the weaknesses of the given type or type combo
     * and adds each to the list of weaknesses.
     */
    public void calculateWeaknesses(){
        for(Types t : Types.values()){
            double weakness;

            weakness = TypeWeaknessChart.getWeakness(type1, t);

            if(type2 != null) {
                weakness *= TypeWeaknessChart.getWeakness(type2, t);
            }

            if(weakness > 1){
                weaknesses.add(t);
            }
        }
    }

    /**
     * Creates a TeraResist for each type, passing in the weaknesses
     * of this Pokemon's typing. Afterwards, sorts each TeraResist
     * by lowest sum of defensive multipliers of each type the
     * Pokemon is weak to.
     *
     * Example: Ice Fairy is weak to Fire, Poison, Rock, and Steel.
     * Top 3 Teras are:
     * Water: Fire 0.5, Poison 1.0, Rock 1.0, Steel 0.5
     * Ground: Fire 1.0, Poison 0.5, Rock 0.5, Steel 1.0
     * Steel: Fire 2.0, Poison 0.0, Rock 0.5, Steel 0.5
     *
     * All of which have a sum of 3.0 across various spreads.
     */
    public void calculateTeraResists(){
        for(Types t : Types.values()){
            teraResists.add(new TeraResists(t, weaknesses));
        }

        Collections.sort(teraResists);
    }

    /**
     * Lists the top 5 TeraResists on their own lines
     *
     * @return String containing the top 5 TeraResists
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 5; i++){
            sb.append(teraResists.get(i).toString() + "\n");
        }

        return sb.toString();
    }

    /**
     * Inner class used for calculating a subset of resists
     * for a particular type.
     */
    class TeraResists implements Comparable<TeraResists>{
        Types type;

        ArrayList<Types> resists;

        Double resistTotal = 0.0;

        public TeraResists(Types type, ArrayList<Types> resists){
            this.type = type;
            this.resists = resists;

            calculateResistTotal();
        }

        public Double getResistTotal() {
            return resistTotal;
        }

        /**
         * Increments through the subset of resists we
         * care about, adding each multiplier to the sum,
         * resistTotal.
         */
        void calculateResistTotal(){
            for(Types r : resists){
                resistTotal += TypeWeaknessChart.getWeakness(type, r);
            }
        }

        /**
         * Compares the resistTotal of two TeraResists,
         * with the lowest being better.
         */
        @Override
        public int compareTo(TeraResists tr) {
            return resistTotal.compareTo(tr.getResistTotal());
        }

        /**
         * Returns the subset of weaknesses we care about and
         * their multipliers, then appends the tera type to
         * the end. This is mainly ordered this way for formatting
         * consistency.
         */
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();

            for(Types t : resists){
                sb.append(t.toString() + ": " + TypeWeaknessChart.getWeakness(type, t) + "\t");
            }

            sb.append("Tera Type: " + type.toString() + "\t");

            return sb.toString();
        }
    }
}
