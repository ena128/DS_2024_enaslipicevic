package homework2;

import java.util.ArrayList;

public class ProcessQueue {

    public Process[] pq = new Process[2];
    public int length = 0;

    private ArrayList<Process> heap;

    public ProcessQueue() {
        this.heap = new ArrayList<>();
    }

    public void addProcess(Process process) {
        heap.add(process);
        bubbleUp(heap.size() - 1);
    }

    public Process runNextProcess() {
        if (heap.isEmpty()) return null;
        Process min = heap.get(0);
        Process last = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, last);
            bubbleDown(0);
        }
        return min;
    }

    public Process peekNextProcess() {
        return heap.isEmpty() ? null : heap.get(0);
    }

    private void bubbleUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (heap.get(index).compareTo(heap.get(parentIndex)) >= 0) break;
            swap(index, parentIndex);
            index = parentIndex;
        }
    }

    private void bubbleDown(int index) {
        int size = heap.size();
        while (true) {
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;
            int smallest = index;

            if (leftChildIndex < size && heap.get(leftChildIndex).compareTo(heap.get(smallest)) < 0) {
                smallest = leftChildIndex;
            }
            if (rightChildIndex < size && heap.get(rightChildIndex).compareTo(heap.get(smallest)) < 0) {
                smallest = rightChildIndex;
            }
            if (smallest == index) break;
            swap(index, smallest);
            index = smallest;
        }
    }

    private void swap(int i, int j) {
        Process temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

}