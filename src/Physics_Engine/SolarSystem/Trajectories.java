package src.Physics_Engine.SolarSystem;


import java.util.ArrayList;
import java.util.Arrays;

// i want this method to return the trajectories of the planets taking in all the planets
public class Trajectories {

    private ArrayList<AstralObject> solarSystem ;

    //THIS IS WRONG
    public Trajectories(ArrayList<AstralObject> solarSystem){
        this.solarSystem = solarSystem;

    }

    public ArrayList<ArrayList<Double>> getTrajectories(double stepSize){
        ArrayList<ArrayList<Double>> trajectories = new ArrayList<>();
        ObjectPositionCalculator positionCalculator = new ObjectPositionCalculator(stepSize);

        double[][] time = getTimeArray(0,stepSize);

        for(int i = 0 ; i<time.length ; i++){

            if(i==time.length-1){
                time = getTimeArray((int)time[i+1][0] , stepSize);
            }

            positionCalculator.getNextStep(solarSystem,time[i]);
            System.out.println(Arrays.toString(solarSystem.get(3).getCoordinates()));
        }

        return trajectories ;
    }

    public double[][] getTimeArray(int currentTime , double stepSize){
        double value = 2;

        //such that we don't increase to infinity each time because it scales pretty quickly to amortize
        if(currentTime >= 1000){
            value = 0.2;
        }
        if(currentTime<=1000){
            value = 2;
        }

        double[][] time = new double[(int)(currentTime*value) +10][3];

        for(int i = currentTime; i<currentTime*value+10 ; i++){
            for(int j = 0 ; j<3 ; j++){
                time[i][j] = i*stepSize;

            }
        }

        return time;
    }


}
