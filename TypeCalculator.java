import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class TypeCalculator {

    Types type1;
    Types type2 = null;

    ArrayList<Types> weaknesses = new ArrayList<>();
    ArrayList<TeraResists> teraResists = new ArrayList<>();

    public TypeCalculator(Types type1, Types type2){
        this.type1 = type1;
        this.type2 = type2;

        calculateWeaknesses();
        calculateTeraResists();
    }

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

    public void calculateTeraResists(){
        for(Types t : Types.values()){
            teraResists.add(new TeraResists(t, weaknesses));
        }

        Collections.sort(teraResists);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 5; i++){
            sb.append(teraResists.get(i).toString() + "\n");
        }

        return sb.toString();
    }

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

        void calculateResistTotal(){
            for(Types r : resists){
                resistTotal += TypeWeaknessChart.getWeakness(type, r);
            }
        }


        @Override
        public int compareTo(TeraResists tr) {
            return resistTotal.compareTo(tr.getResistTotal());
        }

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
