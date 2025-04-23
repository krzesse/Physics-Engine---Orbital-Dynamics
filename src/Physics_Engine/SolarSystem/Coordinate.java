package src.Physics_Engine.SolarSystem;

public class Coordinate {
    private double x ;
    private double y ;
    private double z;

    private double[] coordinates;


    public Coordinate(double x , double y , double z){
        this.x = x ;
        this.y = y ;
        this.z = z ;

        coordinates = new double[] {x , y , z};
    }

    public double[] getCoordinates() {
            return coordinates ;
    }
    public void setCoordinates(double[] newCoordinates){
        coordinates = newCoordinates ;
    }

}
