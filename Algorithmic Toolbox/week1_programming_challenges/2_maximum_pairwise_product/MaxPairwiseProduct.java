import java.util.*;
import java.io.*;

public class MaxPairwiseProduct {
    static long getMaxPairwiseProductOld(long[] numbers) {
        long max_product = 0;
        int n = numbers.length;

        for (int first = 0; first < n; ++first) {
            for (int second = first + 1; second < n; ++second) {
                max_product = Math.max(max_product,
                    numbers[first] * numbers[second]);
            }
        }

        return max_product;
    }

    static long getMaxPairwiseProduct(long[] numbers) {
        int n = numbers.length;

        int max_index1 = -1;
        for(int i = 0; i < n; i++) {
            if((max_index1 == -1) ||(numbers[i] > numbers[max_index1])) {
                max_index1 = i;
            }
        }

        int max_index2 = -1;
        for(int i = 0; i < n; i++) {
            if((i != max_index1) && ((max_index2 == -1) || (numbers[i] > numbers[max_index2]))) {
                max_index2 = i;
            }
        }

        return numbers[max_index1] * numbers[max_index2];
    }

    public static long getMaxPairwiseProductBySorting(long[] numbers) {
        Arrays.sort(numbers);
        return numbers[numbers.length-2] * numbers[numbers.length-1];
    }

    public static void main(String[] args) {
//        FastScanner scanner = new FastScanner(System.in);
//        int n = scanner.nextInt();
//        long[] numbers = new long[n];
//        for (int i = 0; i < n; i++) {
//            numbers[i] = scanner.nextInt();
//        }
//        System.out.println(getMaxPairwiseProduct(numbers));

        testCode();
//        stressTest();
    }

    public static void testCode() {
        int n = 10000000;
        long[] numbers = new long[n];
        for(int i = 0; i < n; i++) {
            numbers[i] = i * i;
        }

        long start = System.currentTimeMillis();
        System.out.println(getMaxPairwiseProductBySorting(numbers));
        System.out.println(System.currentTimeMillis() - start);
    }

    public static void stressTest() {
        while(true) {
            int n = (int) (Math.random() * 10 + 2);
            System.out.println(n);

            long[] a = new long[n];
            for(int i = 0; i < n; i++) {
                a[i] = (int) (Math.random() * 100000);
            }

            for(int i = 0; i < n; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();

            long result1 = getMaxPairwiseProductOld(a);
            long result2 = getMaxPairwiseProduct(a);

            if(result1 != result2) {
                System.out.println("Wrong Answer: " + result1 + " " + result2);
                break;
            } else {
                System.out.println("OK");
            }

        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                    InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}
