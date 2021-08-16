package goit.Malecula;


import goit.action.Molecule;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Water {
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private final StringBuilder stringBuilder = new StringBuilder();


    public void getWaterMolecule(Molecule molecule) {
        try {
            lock.lockInterruptibly();
            String moleculeName = molecule.getMoleculeName();
            if (moleculeName.equals("H")) {
                while (getCountMolecule(moleculeName) >= 2) {
                    condition.await();
                }
            } else {
                while (getCountMolecule(moleculeName) >= 1) {
                    condition.await();
                }
            }

            stringBuilder.append(moleculeName);
            if (stringBuilder.length()==3){
                System.out.println(stringBuilder);
                stringBuilder.delete(0,stringBuilder.length());
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            condition.signalAll();
            lock.unlock();
        }
    }

    private long getCountMolecule(String molecule) {
        return stringBuilder.chars().mapToObj(s -> (char) s)
                .map(String::valueOf)
                .filter(molecule::equals)
                .count();
    }
}

