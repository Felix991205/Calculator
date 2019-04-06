public class Main{


    public static void main(String[] args){

        Calculator calculator = new Calculator();

    }

    public static Integer Factorial(int n){

        Integer result = 1;
        for(int i = n; i > 0; i--) result *= i;
        return result;

    }

    public static Double Modulo(double a, double b){

        Double result;
        if(a > 0 && b > 0){
            while(a - b >= 0)
                a = a - b;
        }
        if(a < 0 && b > 0){
            while(a + b <= 0){
                a = a + b;
            }
        }
        if(a > 0 && b < 0){
            while(a + b >= 0){
                a = a + b;
            }
        }
        if(a < 0 && b < 0){
            while(a - b <= 0){
                a = a - b;
            }
        }
        result = a;
        return result;

    }
}
