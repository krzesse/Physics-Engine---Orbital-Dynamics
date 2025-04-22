package src.Physics_Engine.SolarSystem;

import java.util.ArrayList;


public class ObjectPositionCalculator {

    private double stepSize;
    private  ArrayList<AstralObject> tempSolarSystem;

    public ObjectPositionCalculator(double stepSize){
        this.stepSize = stepSize;
    }

    public void getNextStep(ArrayList<AstralObject> solarSystem , double step){
        double[] t  = new double[]{step};
        double[] x = new double[]{0}; // needs to be there for the interface

        for(int i = 0 ; i<solarSystem.size() ; i++){
            SpeedFunction function = new SpeedFunction(solarSystem , i);
            AstralObject currentAObject = new AstralObject(0,0,0,0,0,0,0);
            currentAObject.copyAstralObject(solarSystem.get(i));

            Adams_Bashforth_Solver solver = new Adams_Bashforth_Solver();

            double[] newSpeed = function.computeDerivative(x,1);
            double[] coordinates = solver.AB4(stepSize , t , x,function);

            currentAObject.setVelocities(newSpeed);
            currentAObject.setCoordinates(coordinates);

            tempSolarSystem.add(currentAObject);



        }
        solarSystem.clear();
        solarSystem.addAll(tempSolarSystem);

    }
}
