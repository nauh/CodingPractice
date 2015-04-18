import java.util.ArrayList;
import java.util.List;

public class SpiralMatrixII implements Runnable {

    @Override
    public void run() {
    }

    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];

        // state machine
        int state = 0;
        int[] boundary = new int[] {0, n - 1, n - 1, 0}; // minRow, maxCol, maxRow, minCol
        int[] boundaryAction = new int[] {1, -1, -1, 1};
        int[] position = new int[] {-1, 0}; // col, row
        int[] positionAction = new int[] {1, 1, -1, -1};

        int i = 1;
        while (i <= Math.pow(n , 2)) {
            position[state % position.length] += positionAction[state];
            if (boundary[3] <= position[0] && position[0] <= boundary[1] &&
                boundary[0] <= position[1] && position[1] <= boundary[2]) {
                result[position[1]][position[0]] = i++;
            } else {
                position[state % position.length] -= positionAction[state];
                boundary[state] += boundaryAction[state];
                state = (state + 1) % 4;
            }
        }
        return result;
    }

}
