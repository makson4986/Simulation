package org.makson;


public class Main {
    public static void main(String[] args) {
        Field field = new Field(10);
        Simulation simulation = new Simulation(field);

        simulation.startSimulation();
    }
}