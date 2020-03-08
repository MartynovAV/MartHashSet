package work1;

import java.util.ArrayList;
import java.util.HashMap;

public class TestMain {
    public static void main(String[] args) {
    MartSet<String> set=new MartSet<>();

   // set.add("first string");
    set.add("second string");
/*    set.add("third string");
    set.add("fourth string");
    set.add("fifth string");
    set.add("sixth string");*/
    set.add("seventh string");
    set.add("second string");


    set.printSet();

    System.out.println();
    System.out.println("Set size: "+set.size());




    //HashMap<Integer,Integer> map=new HashMap<>();


    }
}
