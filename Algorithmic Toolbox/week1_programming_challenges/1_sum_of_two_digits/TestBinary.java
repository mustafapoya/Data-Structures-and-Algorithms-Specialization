import java.util.Arrays;

public class TestBinary {
    public static void main(String[] args) {
        System.out.println(sortDesc(18));
    }

    public static int sortDesc(final int num) {
        String [] values = String.valueOf(num).split("");
        Arrays.sort(values);
        return Integer.parseInt(new StringBuilder(String.join("", values)).reverse().toString());
    }
}
