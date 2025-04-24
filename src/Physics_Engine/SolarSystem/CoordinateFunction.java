package src.Physics_Engine.SolarSystem;

import src.Physics_Engine.ODEFunction;

public class CoordinateFunction implements ODEFunction {

    // second ode function that we plug into the ODE Solver such that we get the coordinates
    @Override
    public double[] computeDerivative(double[] x, double t) {
        double[] position = new double[3];

        for(int i = 0 ;  i<x.length ; i++){
            position[i] = x[i];
        }
        return position;
    }
}
