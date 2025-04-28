package src.Physics_Engine.SolarSystem;

import java.util.*;

public class AstralObject {

    /**
     *This class allows us to retrieve the values from Planet
     */

    private double x;
    private double y ;
    private double z;
    private double Vx;
    private double Vy;
    private double Vz;


    private ArrayList<Coordinate> pastCoordinates  ;
    private ArrayList<Velocities> pastVelocities   ;

    private double Mass;


    /**
     *
     * @param x - x coordinate
     * @param y - y coordinate
     * @param z - z coordinate
     * @param Vx - velocity int the x direction
     * @param Vy - velocity in the y direction
     * @param Vz - velocity in the z direction
     * @param Mass - the size of the planet of asteroid
     */
    public AstralObject(double x , double y , double z , double Vx, double Vy, double Vz , double Mass){
        this.x = x;
        this.y = y;
        this.z = z;
        this.Vx = Vx;
        this.Vy = Vy;
        this.Vz = Vz;

        this.Mass = Mass;

        this.pastCoordinates =new ArrayList<>() ;
        this.pastVelocities = new ArrayList<>() ;

    }

    public double getMass(){
        return Mass;
    }





    // returns the previous velocities
    public double[][] getSpecificVelocities(int j ){
        double[][] velocities = new double[j][3];
        double length  = pastVelocities.size() ;

        for(  int i = 0  ; i<j ; i++){
            velocities[i] = pastVelocities.get((int)length-i).getVelocities() ;
        }

        return velocities ;
    }

    // sets the velocities of the new
    public void setVelocities(double[] newV){
       Vx = newV[0];
       Vy = newV[1];
       Vz = newV[2];
    }
    public ArrayList<Velocities> getAllVelocities(){
        return pastVelocities;
    }
    public void addVelocities(Velocities velocities){
        pastVelocities.add(velocities);
    }


    public void copyAstralObject(AstralObject other) {
        this.pastCoordinates = other.getAllCoordinates();
        this.pastVelocities = other.getAllVelocities() ;
        this.Mass = other.Mass;
        // Copy other fields if you have them
    }
    public void addCoordinate(Coordinate currentCoordinate){

        pastCoordinates.add(currentCoordinate);
    }
    public ArrayList<Coordinate> getAllCoordinates(){

        return pastCoordinates ;
    }
    // returns the last n values of the coordinate array
    public double[][] getSpecificCoordinates(int j ){
        double[][] coordinates = new double[j][3];
        double length  = pastCoordinates.size() ;

        for(  int i = 0  ; i<j ; i++){
            coordinates[i] = pastCoordinates.get((int)length-i).getCoordinates() ;
        }

        return coordinates ;
    }




}
