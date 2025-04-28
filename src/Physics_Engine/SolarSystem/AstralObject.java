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

    }


    public double getX(){return x;}
    public double getY(){return y; }
    public double getZ(){
        return z;
    }
    public double getVx(){
        return Vx;
    }
    public double getVy(){
        return Vy;
    }
    public double getVz(){
        return Vz;
    }
    public double getMass(){
        return Mass;
    }

    public double[][] getCoordinates(int j ){
        double[][] coordinates = new double[j][3];
        double length  = pastCoordinates.size() ;

        for(  int i = 0  ; i<j ; i++){
            coordinates[i] = pastCoordinates.get((int)length-i).getCoordinates() ;
        }


        return coordinates ;
    }
    public double[] getVelocities(){
        double[] velocities = {Vx ,Vy ,Vz };
        return velocities;
    }
    public void setVelocities(double[] newV){
       Vx = newV[0];
       Vy = newV[1];
       Vz = newV[2];
    }
    public void copyAstralObject(AstralObject other) {
        this.pastCoordinates = other.getAllCoordinates();
        this.Vx = other.Vx;
        this.Vy = other.Vy;
        this.Vz = other.Vz;
        this.Mass = other.Mass;
        // Copy other fields if you have them
    }
    public void addCoordinate(Coordinate currentCoordinate){
        pastCoordinates.add(currentCoordinate);
    }
    public ArrayList<Coordinate> getAllCoordinates(){
        return pastCoordinates ;
    }




}
