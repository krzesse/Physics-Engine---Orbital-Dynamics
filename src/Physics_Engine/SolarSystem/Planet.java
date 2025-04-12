package src.Physics_Engine.SolarSystem;

public class Planet {

    /**
     *This class allows us to retrieve the values from Planet
     */

    private double x;
    private double y ;
    private double z;
    private double Vx;
    private double Vy;
    private double Vz;

    private double Mass;
    private double GForce;


    /**
     *
     * @param x - x coordinate
     * @param y - y coordinate
     * @param z - z coordinate
     * @param Vx - velocity int the x direction
     * @param Vy - velocity in the y direction
     * @param Vz - velocity in the z direction
     * @param Mass - the size of the planet of asteroid
     * @param GForce - the gravitational force
     */
    public Planet(double x , double y , double z , double Vx, double Vy, double Vz , double Mass , double GForce){
        this.x = x;
        this.y = y;
        this.z = z;
        this.Vx = Vx;
        this.Vy = Vy;
        this.Vz = Vz;

        this.Mass = Mass;
        this.GForce = GForce;

    }


    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
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
    public double getGForce(){
        return GForce;
    }

}
