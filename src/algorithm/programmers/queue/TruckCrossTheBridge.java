package algorithm.programmers.queue;

import java.util.LinkedList;

public class TruckCrossTheBridge {

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        LinkedList<Truck> trucks = new LinkedList<>();
        for (int truckWeight : truck_weights) {
            trucks.add(new Truck(truckWeight, bridge_length));
        }
        LinkedList<Truck> bridge = new LinkedList<>();
        int answer = 0;
        int totalWeight = 0;
        do {
            for (Truck truck : bridge) {
                truck.go();
            }
            if (!bridge.isEmpty()) {
                Truck firstTruck = bridge.getFirst();
                if (firstTruck.isEnd()) {
                    totalWeight -= firstTruck.getWeight();
                    bridge.removeFirst();
                }
            }

            if (totalWeight < weight && bridge.size() < bridge_length && !trucks.isEmpty()) {
                Truck nextTruck = trucks.getFirst();
                if (totalWeight + nextTruck.getWeight() <= weight) {
                    trucks.removeFirst();
                    totalWeight += nextTruck.getWeight();
                    nextTruck.go();
                    bridge.addLast(nextTruck);
                }
            }
            answer++;
        } while (!bridge.isEmpty());
        return answer;
    }

    class Truck {
        private int location;
        private int weight;
        private int bridgeLength;

        public Truck(int weight, int bridgeLength) {
            this.weight = weight;
            this.bridgeLength = bridgeLength;
        }

        public int getLocation() {
            return location;
        }

        public int getWeight() {
            return weight;
        }

        public void go() {
            this.location++;
        }

        public boolean isEnd() {
            return this.bridgeLength < this.location;
        }
    }

    public static void main(String[] args) {
        System.out.println(new TruckCrossTheBridge().solution(100, 100, new int[]{10,10,10,10,10,10,10,10,10,10}));
    }
}
