package src.Physics_Engine.SolarSystem;

public interface ODEFunction {

    double[] computeDerivative(double[] x , double t);
}
