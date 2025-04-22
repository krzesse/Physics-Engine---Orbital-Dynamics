package src.Physics_Engine.SolarSystem;


import java.util.ArrayList;
import java.util.Arrays;

// i want this method to return the trajectories of the planets taking in all the planets
public class Trajectories {

    private ArrayList<AstralObject> solarSystem ;

    public Trajectories(ArrayList<AstralObject> solarSystem){
        this.solarSystem = solarSystem;

    }

    public ArrayList<ArrayList<Double>> getTrajectories(double stepSize){
        ArrayList<ArrayList<Double>> trajectories = new ArrayList<>();
        ObjectPositionCalculator positionCalculator = new ObjectPositionCalculator(stepSize);

        double[] time = getTimeArray(0,stepSize);

        for(int i = 0 ; i<time.length ; i++){
            positionCalculator.getNextStep(solarSystem,time[i]);
            System.out.println(Arrays.toString(solarSystem.get(3).getCoordinates()));
        }

        return trajectories ;
    }

    public double[] getTimeArray(int currentTime , double stepSize){
        double value = 2;

        //such that we don't increase to infinity each time because it scales pretty quickly to amortize
        if(currentTime >= 1000){
            value = 0.2;
        }
        if(currentTime<=1000){
            value = 2;
        }

        double[] time = new double[(int)(currentTime*value) +10];

        for(int i = currentTime; i<currentTime*value+10 ; i++){
            time[i] = i*stepSize;
        }

        return time;
    }


}
