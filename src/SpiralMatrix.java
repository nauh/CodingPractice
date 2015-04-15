import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix implements Runnable {

    @Override
    public void run() {
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        result.add(matrix[0][0]);
        // state machine
        int state = 0;
        int[] boundary = new int[] {0, matrix[0].length - 1, matrix.length - 1, 0}; // minRow, maxCol, maxRow, minCol
        int[] boundaryAction = new int[] {1, -1, -1, 1};
        int[] position = new int[] {0, 0}; // col, row
        int[] positionAction = new int[] {1, 1, -1, -1};
        while (boundary[0] <= boundary[2] && boundary[3] <= boundary[1]) {
            position[state % position.length] += positionAction[state];
            if (boundary[3] <= position[0] && position[0] <= boundary[1] &&
                boundary[0] <= position[1] && position[1] <= boundary[2]) {
                result.add(matrix[position[1]][position[0]]);
            } else {
                position[state % position.length] -= positionAction[state];
                boundary[state] += boundaryAction[state];
                state = (state + 1) % 4;
            }
        }
        return result;
    }

}
