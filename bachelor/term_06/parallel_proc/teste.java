public class Matrix {

    public static long clock() {
        Clock r = Clock.systemDefaultZone();
        long ms = r.millis();
        return ms;
    }

    public static void main(String[] args) {
        int n = 10000, m = 10000;
        int[][] a = new int [n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                a[i][j] = 1;

        long start = clock();
        int sum = 0;
        int[][] a = new int [n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                sum += a[j][i];
        long end = clock();
        System.out.println("Tempo de duração do processo: " + (end - start));

