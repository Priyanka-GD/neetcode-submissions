class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<Car> carList = new ArrayList<>();
        for(int idx = 0; idx < position.length; idx++){
            Car car = new Car(position[idx], speed[idx]);
            carList.add(car);
        }
        Collections.sort(carList);
        int fleetCount = 0;
        double maxTime = Double.MIN_VALUE;
        for(int idx = 0; idx < carList.size(); idx++){
            Car car = carList.get(idx);
            double time = (double) (target - car.position)/ car.speed;
            if(maxTime < time){
                maxTime = time;
                fleetCount++;
            }
        }
        return fleetCount;
    }
}
class Car implements Comparable<Car>{
    int position;
    int speed;

    public Car(int position, int speed){
        this.position = position;
        this.speed = speed;
    }
    @Override
    public int compareTo(Car other){
        return other.position - this.position;
    }
}
