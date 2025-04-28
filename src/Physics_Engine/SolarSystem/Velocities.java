package src.Physics_Engine.SolarSystem;

public class Velocities {

    private double Vx ;
    private double Vy ;
    private double Vz;

    private double[] velocities ;


    public Velocities(double Vx , double Vy , double Vz){
        this.Vx = Vx ;
        this.Vy = Vy ;
        this.Vz = Vz ;

        velocities = new double[] {Vx , Vy , Vz};
    }
    public double[] getVelocities() {
        return velocities ;
    }
    public void setVelocities(double[] newVelocities){
        velocities = newVelocities ;
    }
}
