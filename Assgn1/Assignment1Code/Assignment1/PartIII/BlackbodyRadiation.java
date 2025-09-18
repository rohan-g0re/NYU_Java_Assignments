public class BlackbodyRadiation {

    public static double calculateEnergy_internet_formula(double lambda, double T) {

        // our constants
        final double h  = 6.626e-34;
        final double c  = 3.0e8;    
        final double kB = 1.381e-23;

        double v = c / lambda;

        double numerator = 2.0 * h * Math.pow(v, 3);

        double denom1 = Math.pow(c, 2);

        double exponent = (h * v) / (kB * T);
        double denom2   = Math.exp(exponent) - 1.0;

        return (numerator / denom1) * (1.0 / denom2);


    }
    

    public static double calculateEnergy(double lambda, double T) {

        // our constants
        final double h  = 6.626e-34;
        final double c  = 3.0e8;    
        final double kB = 1.381e-23;

        double v = c / lambda;

        double numerator = 2.0 * h * Math.pow(v, 3);

        double denom1 = Math.pow(c, 2);

        // denominator part two: e^(hν/k_B T) – 1
        double exponent = ( (h * v) / (kB * T) ) - 1.0;
        double denom2   = Math.exp(exponent);

        return (numerator / denom1) * (1.0 / denom2);
    }

    public static void main(String[] args) {

        // Betelgeuse: λ = 970 nm, T = 3,500 K
        double betelgeuseI = calculateEnergy(970e-9, 3500);

        // Sun: λ = 500 nm, T = 5,800 K
        double sunI = calculateEnergy(500e-9, 5800);

        System.out.println("Spectral radiance I for Betelgeuse = " + betelgeuseI);
        System.out.println("Spectral radiance I for the Sun    = " + sunI);
        
        
        // Betelgeuse: λ = 970 nm, T = 3,500 K
        double betelgeuseI2 = calculateEnergy_internet_formula(970e-9, 3500);

        // Sun: λ = 500 nm, T = 5,800 K
        double sunI2 = calculateEnergy_internet_formula(500e-9, 5800);

        System.out.println();
        System.out.println("Spectral Radiances if <-1> is NOT in power term");
        System.out.println("I for Betelgeuse = " + betelgeuseI2);
        System.out.println("I for the Sun    = " + sunI2);
    }
}
