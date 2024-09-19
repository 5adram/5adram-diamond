import java.util.Scanner;

public class Diamond {

}
final class DiamondAlgorithm {

    /** the method will take an Integer called diamondSize and will give a
     * Diamond height out.
     *
     * @param diamondSize the intended height of the diamond
     * @return an equilateral diamond shape of the given height
     * @throws IllegalArgumentException if the given diamond size is an even number or <= 2
     */
    public String getPrintableDiamond(int diamondSize) {
        if (diamondSize % 2 == 0 || diamondSize <= 2) {
            throw new IllegalArgumentException("Diamond Size must be odd and bigger than 2");
        }
        StringBuilder result = new StringBuilder();

        int midRow = diamondSize / 2;

        // Upper half of the diamond
        for (int i = 0; i < midRow + 1; i++) {
            for (int j = 0; j < midRow - i; j++) {
                result.append(" ");
            }
            for (int j = 0; j <= i; j++) {
                if (j == i) {
                    result.append("*");
                } else {
                    result.append("* ");
                }
            }
            result.append("\n");
        }

        // Lower half of the diamond
        for (int p = 0; p < midRow; p++) {
            for (int k = 0; k <= p; k++) {
                result.append(" ");
            }
            for (int k = 0; k < midRow - p; k++) {
                if (k == midRow - p - 1) {
                    result.append("*");
                } else {
                    result.append("* ");
                }
            }
            if (p == midRow - 1) {
                break;
            } else {
                result.append("\n");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int diamondSize;


        while (true) {
            System.out.print("Please enter an odd number greater than 2 for the diamond size: ");
            diamondSize = scanner.nextInt();


            if (diamondSize > 2 && diamondSize % 2 != 0) {
                break;  // Exit the loop if valid input
            } else {
                System.out.println("Invalid input. The number must be odd and greater than 2.");
            }
        }

        DiamondAlgorithm diamondAlgorithm = new DiamondAlgorithm();


        System.out.println(diamondAlgorithm.getPrintableDiamond(diamondSize));


        scanner.close();
    }
}