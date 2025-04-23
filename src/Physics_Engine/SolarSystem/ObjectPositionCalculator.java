package src.Physics_Engine.SolarSystem;

import java.util.ArrayList;


public class ObjectPositionCalculator {

    private double stepSize;
    private  ArrayList<AstralObject> tempSolarSystem = new ArrayList<>();

    public ObjectPositionCalculator(double stepSize){
        this.stepSize = stepSize;
    }

    public void getNextStep(ArrayList<AstralObject> solarSystem , double[] step){
        double[] t  = step;
        double[] x = new double[3]; // needs to be there for the interface

        for(int i = 0 ; i<solarSystem.size() ; i++){
            SpeedFunction function = new SpeedFunction(solarSystem , i);

            // creates a copy of the object such that I don't change any of the positions of the other planets
            AstralObject currentAObject = new AstralObject(0,0,0,0,0,0,0);
            currentAObject.copyAstralObject(solarSystem.get(i));

            Adams_Bashforth_Solver solver = new Adams_Bashforth_Solver();


            // gets current speedValues to use in the function and calculatest the function of the
            double[] speedValues = currentAObject.getVelocities();
            double[] speedCoordinates = solver.AB4(stepSize , t , speedValues,function);

            double[] planetSpeedComponent = currentAObject.getVelocities() ;
            double[] coordinates = solver.AB4(stepSize , t , planetSpeedComponent , function );

            currentAObject.setVelocities(speedCoordinates);
            currentAObject.setCoordinates(coordinates);
            tempSolarSystem.add(currentAObject);



        }
        solarSystem.clear();
        solarSystem.addAll(tempSolarSystem);

    }
}
