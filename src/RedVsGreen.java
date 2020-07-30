import java.util.Scanner;

public class RedVsGreen {
    public static void main(String[] args) {
        String line;
        String[] lineVector;
        int x = -1, y = -1;
        int x1 = -1, y1 = -1, N = -1;

        Scanner scanner = new Scanner(System.in);
        // Takе x and y from the user
        do {
            System.out.print("Please enter x and y, comma separated (more than 1 and less than 1000):");

            line = scanner.nextLine();
            lineVector = line.split(",");

            if (lineVector.length != 2)
                continue;

            y = Integer.parseInt(lineVector[0]);
            x = Integer.parseInt(lineVector[1]);
        } while (!((x > 1 && x < 1000 && y > 1 && y < 1000)));

        String[] checkLine = new String[x];
        int[][] field = new int[x][y];
        //Takе y lines with x elements from the user
        for (int i = 0; i < x; ++i) {
            System.out.print("Enter row " + (i+1) + ":");
            checkLine[i] = scanner.nextLine();
            //Make sure entered row is valid
            while (!isValid(checkLine[i]) || checkLine[i].length() != y) {
                System.out.print("Invalid input. Re-enter row " + (i+1) + ":");
                checkLine[i] = scanner.nextLine();
            }
        }
        //Savе the values entered by the user in the field array
        for (int i = 0; i < x; ++i) {
            System.out.println();
            for (int j = 0; j < y; ++j) {
                char c = checkLine[i].charAt(j);
                if (c == '0')
                    field[i][j] = 0;
                else
                    field[i][j] = 1;
                System.out.print(field[i][j] + " ");
            }
        }
        //Take x1,y1 and N from the user
        do {
        System.out.println();
        System.out.printf("Please enter x1 between 0 and %d, y1 between 0 and %d and N comma separated :", x - 1, y - 1);

        line = scanner.nextLine();
        lineVector = line.split("\\s*,\\s*");

        if (lineVector.length != 3)
            continue;

        y1 = Integer.parseInt(lineVector[0]);
        x1 = Integer.parseInt(lineVector[1]);
        N = Integer.parseInt(lineVector[2]);
        } while(!((x1 >=0&&x1<x &&y1 >=0&&y1<y && N > 0)));

        Board board = new Board(x, y, field);
        System.out.println("Output: " + board.count(x1, y1, N));
}
    //Check that user have entered only 0s and 1s
    public static boolean isValid(String s) {
        for(int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if(c != '0' && c != '1')
                return false;
        }
        return true;
    }
}