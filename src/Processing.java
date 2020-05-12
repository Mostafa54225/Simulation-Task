public class Processing {
    public double avgNumberSystem(double λ, double µ){
        return λ/(µ-λ);
    }
    public double avgTimeSystem(double λ, double µ){
        return 1/(µ-λ);
    }
    public double avgNumberQueue(double λ, double µ){
        double power = Math.pow(λ, 2);
        double p = µ * (µ-λ);
        return power/p;
    }
    public double avgTimeQueue(double λ, double µ){
        double p = µ * (µ-λ);
        return λ / p;
    }
    public double utilizationFactor(double λ, double µ){
        return λ/µ;
    }
    public double percentIdleTime(double λ, double µ){
        return 1 - (λ/µ);
    }

    public double[] probability(int k, double λ, double µ){
        double arr[] = new double[k+1];
        double p = (λ/µ);
        for(int i = 0; i <= k; i++){
            arr[i] = Math.pow(p, i+1);
        }
        return arr;
    }
}
