package org.makson;


public class Main {
    public static void main(String[] args) {
        Field field = new Field();
        Simulation simulation = new Simulation(field);

        simulation.executeInitialActions();

        simulation.startSimulation();
    }
}