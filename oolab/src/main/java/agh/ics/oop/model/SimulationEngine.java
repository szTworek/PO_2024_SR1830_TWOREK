package agh.ics.oop.model;

import agh.ics.oop.Simulation;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SimulationEngine {
    private List<Simulation> simulations= new ArrayList<Simulation>();
    private final List<Thread> threads = new ArrayList<>();
    private final ExecutorService threadPool = Executors.newFixedThreadPool(4);


    public SimulationEngine(List<Simulation> simulations) {
        this.simulations = simulations;
    }
    public void addSimulation(Simulation simulation) {
        simulations.add(simulation);
        threadPool.submit(simulation);
    }
    public void runSync(){
        for(Simulation simulation : simulations){
            simulation.run();
        }
    }

    public void runAsync(){
        for(Simulation simulation : simulations){
            Thread thread=new Thread(simulation);
            threads.add(thread);
            thread.start();
        }
    }

    public void awaitSimulationsEnd() throws InterruptedException {
        for(Thread thread : threads){
            thread.join();
        }
        if(!threadPool.awaitTermination(10, TimeUnit.SECONDS)){
            System.out.println("Time limit exceeded");
            threadPool.shutdownNow();
        }
    }

    public void runAsyncInThreadPool(){
        for(Simulation simulation: simulations){
            threadPool.submit(simulation);
        }


    }
}
