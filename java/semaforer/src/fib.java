public class fib {
    public static void main(String[] args) {
        printFib(10);
    }

    public static void printFib(int n) {
        int a = 1;
        int b = 2;

        for (int i = n; i != 0; i--) {
            System.out.println(a);
            int t = a;
            a = b;
            b = t + b;
        }
    }
}
