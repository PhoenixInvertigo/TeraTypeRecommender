import java.util.Scanner;

/**
 * Author: Ryo Kilgannon
 * Date: 3/31/2024
 *
 * This program allows the user to input one
 * or two Pokemon types separated by a space,
 * then prints the top 5 recommended defensive
 * tera types for that Pokemon's typing.
 */
public class TeraTypeRecommender {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter a pokemon type or type combination separated by space");

        while(true){
            try{

                Types type1;
                Types type2 = null;

                String line = input.nextLine();
                String[] types = line.split("\\s+");

                type1 = Types.valueOf(types[0].toUpperCase());

                if(types.length > 1){
                    type2 = Types.valueOf(types[1].toUpperCase());
                }

                TypeCalculator calc = new TypeCalculator(type1, type2);

                System.out.println(calc);

                System.out.println("Type 0 to exit or more types to continue");

                if(input.hasNextInt() && input.nextInt() == 0){
                    System.exit(0);
                }

            } catch(Exception e){
                System.out.println("Error in input");
                System.out.println("Please enter a pokemon type or type combination separated by space");
            }
        }
    }
}
