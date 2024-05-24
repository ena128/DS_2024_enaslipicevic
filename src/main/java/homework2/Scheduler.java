package homework2;

import java.util.ArrayList;
import java.util.Comparator;

public class Scheduler {

    public static void scheduleAndRun(ArrayList<Process> processes) {
        processes.sort(Comparator.comparingInt(p -> p.arrivalTime));
        ProcessQueue processQueue = new ProcessQueue();
        int time = 0;
        int processIndex = 0;
        int totalWaitingTime = 0;

        while (processIndex < processes.size() || processQueue.peekNextProcess() != null) {
            while (processIndex < processes.size() && processes.get(processIndex).arrivalTime <= time) {
                processQueue.addProcess(processes.get(processIndex));
                processIndex++;
            }

            Process currentProcess = processQueue.runNextProcess();
            if (currentProcess != null) {
                System.out.println("t = " + time + " → " + currentProcess.name + " is running");
                currentProcess.remainingTime--;
                if (currentProcess.remainingTime > 0) {
                    processQueue.addProcess(currentProcess);
                } else {
                    int finishTime = time + 1;
                    totalWaitingTime += finishTime - currentProcess.burstTime - currentProcess.arrivalTime;
                }
            } else {
                System.out.println("t = " + time + " → NO PROCESS");
            }
            time++;
        }
        System.out.println("Total time taken: " + time);
        System.out.println("Average waiting time: " + (totalWaitingTime / (double) processes.size()));
    }

    public static void main(String[] args) {
        ArrayList<Process> processes = new ArrayList<>();
        processes.add(new Process("P1", 5, 4, 0));
        processes.add(new Process("P2", 4, 3, 1));
        processes.add(new Process("P3", 3, 1, 2));
        processes.add(new Process("P4", 2, 5, 3));
        processes.add(new Process("P5", 2, 2, 4));

        scheduleAndRun(processes);
    }
}