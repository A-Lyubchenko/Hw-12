package goit.Malecula;


import goit.action.Molecule;



public class Oxygen extends Thread implements Molecule {
    Water water;

    public Oxygen(Water water) {
        this.water = water;

    }

    @Override
    public void run() {
            water.getWaterMolecule(this);

    }


    @Override
    public String getMoleculeName() {
        return "O";
    }
}
