package src.Physics_Engine.SolarSystem;

import src.Physics_Engine.ODEFunction;

import java.util.ArrayList;

public class SpeedFunction implements ODEFunction {

    private ArrayList<AstralObject> solarSystem;
    private int  index ;
    private double Gconstant = 6.67430E-11;

    public SpeedFunction(ArrayList<AstralObject> solarSystem , int index){
        this.solarSystem = solarSystem ;
        this.index = index ;
    }


    @Override
    public double[] computeDerivative(double[] x, double t) {
        double[] answer = new double[3];
        double[] GForce = getForce(x);

        AstralObject targetObject = solarSystem.get(index);
        double mass = targetObject.getMass();

        int i = 0;
        for(double force : GForce){
            answer[i] = force/mass;
            i++;
        }

        return answer;
    }

    public double[] getForce(double[] x) {
        double[] GForce = new double[3];

        AstralObject targetAstralObject = solarSystem.get(index);
        double[] targetCoordinates = x;// I did this such that i didn't have to change the name of it

        for(int i =0 ; i<GForce.length ; i++) {
            for (int j = 0; j < solarSystem.size(); j++) {

                if (j == index) {
                    continue;
                }

                AstralObject currentAObject = solarSystem.get(j);
                double[] currentCoordinates = currentAObject.getCoordinates();

                double targetObjectMass = targetAstralObject.getMass();
                double currentObjectMass = currentAObject.getMass();
                double magnitude = getVectorMagnitude(targetCoordinates, currentCoordinates);


                GForce[i] += Gconstant * targetObjectMass * currentObjectMass
                             *((targetCoordinates[i]-currentCoordinates[i]) / Math.pow(magnitude,3));

            }
            GForce[i] = -1*GForce[i];
        }
        return  GForce;
    }

    private double getVectorMagnitude(double[] targetAValues , double[] currentAValues){
        double solution = 0 ;
        double sum = 0;

        for(int i = 0 ; i<targetAValues.length ; i++){
            sum += Math.pow(targetAValues[i]-currentAValues[i],2);
        }

        solution = Math.sqrt(sum);

        return solution;
    }
}
