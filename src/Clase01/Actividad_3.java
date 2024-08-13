package Clase01;

public class Actividad_3 {
    public static int sumaNumeros(int x){
        if (x == 0){
            return 0;
        }
        return x+sumaNumeros(x-1);
    }

    public static void main(String[] args) {
        int num=4;
        System.out.println("La suma de todos los numeros hasta "+ num +" es: "+sumaNumeros(4));
    }
}
