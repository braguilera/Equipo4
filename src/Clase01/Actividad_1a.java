package Clase01;

public class Actividad_1a {
    public int calcularMax(int[] array){
        if(array.length==0){        //1
            return 0;               //1
        }

        int max = 0;                //1
        boolean flag = true;        //1
        for(int e : array){         //n
            if(flag || max<e){      //n
                max=e;              //n
                flag = false;       //n
            }
        }

        return max;                 //1
    }

    //costo lineal -> f(n)=5+4n

    public static void main(String[] args) {
        Actividad_1a a1 = new Actividad_1a();
        System.out.println(a1.calcularMax (new int[]{-1,-2,3,4,-5}));
    }
}