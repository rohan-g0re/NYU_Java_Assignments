public class SpiralMatrix {

    /**
     * Return the elements of a 2-D array in spiral order.
     *
     * @param m 2-D rectangular array (rows × cols).
     * @return 1-D array with all values arranged spirally.
     */
    public static int[] spiralMatrix(int[][] m) {

        int rows = m.length;
        int cols = m[0].length;
        int[] spiral = new int[rows * cols];

        // four moving “walls”
        int top = 0, bottom = rows - 1;
        int left = 0, right = cols - 1;
        int idx = 0;                         // where to write next value

        while (top <= bottom && left <= right) {

            // 1. left → right along the current top row
            for (int c = left; c <= right; c++)
                spiral[idx++] = m[top][c];
            top++;

            // 2. top → bottom down the current right column
            for (int r = top; r <= bottom; r++)
                spiral[idx++] = m[r][right];
            right--;

            // 3. right → left along the current bottom row
            if (top <= bottom) {
                for (int c = right; c >= left; c--)
                    spiral[idx++] = m[bottom][c];
                bottom--;
            }

            // 4. bottom → top up the current left column
            if (left <= right) {
                for (int r = bottom; r >= top; r--)
                    spiral[idx++] = m[r][left];
                left++;
            }
        }
        return spiral;
    }


    public static void main(String[] args) {

        int[][] matrix = {
            { 1,  2,  3,  4},
            { 5,  6,  7,  8},
            { 9, 10, 11, 12},
            {13, 14, 15, 16},
            {17, 18, 19, 20}
        };

        /* --- Part 1: print matrix row-by-row --- */
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                System.out.printf("%3d", matrix[r][c]);
            }
            System.out.println();
        }

        /* --- Part 2: spiral traversal --- */
        int[] spiral = spiralMatrix(matrix);

        System.out.print("\nSpiral order: ");
        for (int val : spiral) System.out.print(val + " ");
        System.out.println();
    }
}
