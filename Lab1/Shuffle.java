/**
 * Author: Eli Giglietti
 * 
 * Furst Lab
 */

 //Importing the necessary things

import java.util.ArrayList;
import java.util.Random;


public class Shuffle{

    public static void main (String[] args){
        //First array list
        ArrayList<Integer> arr0 = new ArrayList<Integer>();
        ArrayList<Integer> arr1 = new ArrayList<Integer>();
        ArrayList<Integer> randomarr = new ArrayList<Integer>();
        Random ran = new Random();
        
        //giving the array list 10 random ints from 0-10
        for (int i=0; i<10; i++){

            int x = ran.nextInt(10);
            arr0.add(x);
            arr1.add(x);

        }

        //Makes thrid AL
        ArrayList<Integer> arr2 = arr0;

        //prints the AL
        System.out.println(arr0);
        System.out.println(arr1);
        System.out.println(arr2);

        //comparing the ALs
        System.out.println("arr0 == arr1: " + (arr0 == arr1) + "\narr1 == arr2: " + (arr1 == arr2) + "\narr2 == arr0: " + (arr2 == arr0));
        System.out.println("arr0.equals(arr1): " + (arr0.equals(arr1)) + "\narr1.equals(arr2): " + (arr1.equals(arr2)) + "\narr2.equals(arr0): " + (arr2.equals(arr0)));

        
        System.out.println(arr0);
        for (int i = 0; i<10; i++){
            int delete = ran.nextInt(arr0.size());
            System.out.print(delete);
            System.out.println(arr0);
            randomarr.add(arr0.get(delete));
            arr0.remove(delete);

        }
        
        System.out.println(randomarr);
    }

 }