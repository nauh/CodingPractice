public class GasStation implements Runnable {

    @Override
    public void run() {
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null) {
            return -1;
        }

        int maxStart = 0, start = 0, current = 0;
        int maxFuel = 0, currentFuel = 0;
        int traveled = 0;
        while (start < gas.length && traveled < gas.length) {
            currentFuel += gas[current % gas.length] - cost[current % gas.length];
            traveled += 1;
            if (currentFuel < 0) {
                currentFuel = 0;
                traveled = 0;
                start = current + 1;
            }
            if (currentFuel > maxFuel) {
                maxFuel = currentFuel;
                maxStart = start;
            }
            current++;
        }
        if (traveled < gas.length) {
            currentFuel = 0;
            for (int i = maxStart; i < maxStart + gas.length; i++) {
                currentFuel += gas[i % gas.length] - cost[i % gas.length];
                if (currentFuel < 0) {
                    return -1;
                }
            }
        }
        return maxStart;
    }

}
