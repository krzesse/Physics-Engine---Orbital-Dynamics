package src.Physics_Engine.SolarSystem;

import java.util.ArrayList;


public class ObjectPositionCalculator {

    private double stepSize;
    private  ArrayList<AstralObject> tempSolarSystem = new ArrayList<>();

    public ObjectPositionCalculator(double stepSize){
        this.stepSize = stepSize;
    }

    // we want to update all the plant one step , so this method updates all objects by one step at a time
    public ArrayList<AstralObject> getNextStep(ArrayList<AstralObject> solarSystem , double[] step){
        double[] t  = step;

        // we calculate the next step for each individual planet , which will inevitable give certain errors
        // it starts at 1 because the sun shouldn't move
        for(int i = 1 ; i<solarSystem.size() ; i++){

            SpeedFunction speedFunction = new SpeedFunction(solarSystem , i);
            CoordinateFunction coordinateFunction = new CoordinateFunction();

            // creates a copy of the object such that I don't change any of the positions of the other planets
            AstralObject currentAObject = new AstralObject(0,0,0,0,0,0,0);
            currentAObject.copyAstralObject(solarSystem.get(i));

            Adams_Bashforth_Solver solver = new Adams_Bashforth_Solver();


            // gets current coordinate to use in the function such that we can calculate the gforce for out speedfunction
            double[] planetCoordinates = currentAObject.getCoordinates() ;
            double[] UpdatedSpeedCoordinates = solver.AB4(stepSize , t , planetCoordinates, speedFunction);

            // we need the previous speed values for each plane
            double[] speedCoordinates  = currentAObject.getVelocities();
            double[] coordinates = solver.AB4(stepSize , t , speedCoordinates , coordinateFunction );

            currentAObject.setVelocities(UpdatedSpeedCoordinates);
            currentAObject.setCoordinates(coordinates);
            tempSolarSystem.add (currentAObject);


        }

        solarSystem.clear();
        solarSystem.addAll(tempSolarSystem);
        // such that i can save these values in a large arrayList
        return solarSystem ;
    }
}
