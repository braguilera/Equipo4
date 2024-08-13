package Clase01;

import java.math.BigInteger;

public class Actividad_2 {
    public static int factorialConInt(int n){
        if(n==0){
            return 1;
        } else{
            return n * factorialConInt(n-1);
        }
    }

    public static long factorialConLong(long n){
        if(n==0){
            return 1;
        } else{
            return n * factorialConLong(n-1);
        }
    }

    public static BigInteger factorialConBigInteger(BigInteger n) {
        if (n.equals(BigInteger.ZERO)) {
            return BigInteger.ONE;
        } else {
            return n.multiply(factorialConBigInteger(n.subtract(BigInteger.ONE)));
        }
    }

    public static void main(String[] args) {
        int num=50;
        System.out.println("El factorial BigInteger de: "+num+" es: "+factorialConBigInteger(BigInteger.valueOf(num)));
        System.out.println("El factorial int de: "+num+" es: "+factorialConInt(num));
        System.out.println("El factorial long de: "+num+" es: "+factorialConLong(num));
    }
}
