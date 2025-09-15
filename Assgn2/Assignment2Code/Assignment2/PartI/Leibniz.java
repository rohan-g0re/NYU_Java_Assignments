public class Leibniz {

    /**
     * Return the Leibniz‐series estimate of π after the requested number of terms.
     * S(n) = 4 · Σ_{k=0}^{n-1} [(-1)^k / (2k + 1)]
     */
    public static double estimatePi(int iterations) {
        double sum = 0.0;

        for (int k = 0; k < iterations; k++) {
            // (-1)^k  →  flip sign every term
            double term = (k % 2 == 0 ? 1.0 : -1.0) / (2 * k + 1);
            sum += term;
        }
        return 4.0 * sum;
    }

    public static void main(String[] args) {

        final double TOLERANCE = 1e-5;          // 0.00001
        int iterations = 0;
        double approximation = 0.0;

        // keep adding terms until the estimate is close enough
        while (Math.abs(Math.PI - approximation) > TOLERANCE) {
            iterations++;
            approximation = estimatePi(iterations);
        }

        System.out.printf("π is estimated as %.6f after %d iterations%n",
                          approximation, iterations);
    }
}

