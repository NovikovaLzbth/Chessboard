import java.util.LinkedHashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        LinkedHashSet<String> removedCells = new LinkedHashSet<>();

        for (int idx = 0; idx < N; idx++) {
            int cellRow = input.nextInt();
            int cellCol = input.nextInt();
            removedCells.add(cellRow + "," + cellCol);
        }

        int totalPerimeter = calculatePerimeter(removedCells);

        System.out.println(totalPerimeter);
    }

    private static int calculatePerimeter(LinkedHashSet<String> cells) {
        int perimeterCount = 0;

        for (String cell : cells) {
            String[] coordinates = cell.split(",");
            int row = Integer.parseInt(coordinates[0]);
            int column = Integer.parseInt(coordinates[1]);

            // проверка границы
            perimeterCount += checkBoundary(cells, row - 1, column); // Сверху
            perimeterCount += checkBoundary(cells, row + 1, column); // Снизу
            perimeterCount += checkBoundary(cells, row, column - 1); // Слева
            perimeterCount += checkBoundary(cells, row, column + 1); // Справа
        }

        return perimeterCount;
    }

    private static int checkBoundary(LinkedHashSet<String> cells, int row, int col) {
        return cells.contains(row + "," + col) ? 0 : 1;
    }
}
