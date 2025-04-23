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

        for(int i = 0 ; i<solarSystem.size() ; i++){
            SpeedFunction speedFunction = new SpeedFunction(solarSystem , i);
            CoordinateFunction coordinateFunction = new CoordinateFunction();

            // creates a copy of the object such that I don't change any of the positions of the other planets
            AstralObject currentAObject = new AstralObject(0,0,0,0,0,0,0);
            currentAObject.copyAstralObject(solarSystem.get(i));

            Adams_Bashforth_Solver solver = new Adams_Bashforth_Solver();


            // gets current speedValues to use in the function and calculatest the function of the
            double[] speedValues = currentAObject.getVelocities();
            double[] speedCoordinates = solver.AB4(stepSize , t , speedValues,speedFunction);

            double[] planetSpeedComponent = currentAObject.getVelocities() ;
            double[] coordinates = solver.AB4(stepSize , t , planetSpeedComponent , coordinateFunction );

            currentAObject.setVelocities(speedCoordinates);
            currentAObject.setCoordinates(coordinates);
            tempSolarSystem.add(currentAObject);



        }
        solarSystem.clear();
        solarSystem.addAll(tempSolarSystem);

    }
}
