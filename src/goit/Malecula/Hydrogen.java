package goit.Malecula;


import goit.action.Molecule;



public class Hydrogen extends Thread implements Molecule {
    Water water;

    public Hydrogen(Water water) {
        this.water = water;

    }

    @Override
    public String getMoleculeName() {
        return "H";
    }



    @Override
    public void run() {
            water.getWaterMolecule(this);


    }
}
