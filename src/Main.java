import goit.Malecula.*;
import goit.action.Molecule;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args)  {
        //первый вариант
        Water water = new Water();
//        List<Molecule> moleculeList = Collections.synchronizedList(new ArrayList<>());
//        IntStream.rangeClosed(0, 10).boxed().peek(s -> {
//
//            moleculeList.add(new Hydrogen(water));
//            moleculeList.add(new Oxygen(water));
//
//        }).forEach(s -> {
//            new Hydrogen(water).start();
//            new Oxygen(water).start();
//            new Hydrogen(water).start();
//
//        });
        //Второй вариант
        IntStream.rangeClosed(0, 10).forEach(s -> {
            new Oxygen(water).start();
            new Hydrogen(water).start();
            new Hydrogen(water).start();
        });
    }
}

