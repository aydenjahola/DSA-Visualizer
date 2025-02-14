package dsaVisualizer;

import java.util.Random;

public class BubbleSort implements SortAlgorithm {
    private int[] array;
    private int n;
    private int currentPass;
    private int currentIndex;
    private boolean swapped;
    private String statusMessage;

    public BubbleSort(int size, double maxValue) {
        array = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt((int)maxValue - 10) + 10; // values between 10 and maxValue
        }
        n = array.length;
        currentPass = 0;
        currentIndex = 0;
        swapped = false;
        statusMessage = "Initialized array.";
    }
    
    @Override
    public boolean step() {
        if (currentPass >= n - 1) {
            statusMessage = "Array is fully sorted.";
            return true; // Sorting complete
        }
        if (currentIndex < n - currentPass - 1) {
            if (array[currentIndex] > array[currentIndex + 1]) {
                // Swap and update status
                int temp = array[currentIndex];
                array[currentIndex] = array[currentIndex + 1];
                array[currentIndex + 1] = temp;
                swapped = true;
                statusMessage = "Swapped elements at positions " + currentIndex + " and " + (currentIndex + 1);
            } else {
                statusMessage = "Compared positions " + currentIndex + " and " + (currentIndex + 1) + " - no swap needed.";
            }
            currentIndex++;
        } else {
            if (!swapped) {
                statusMessage = "No swaps in pass " + currentPass + "; array sorted.";
                return true;
            }
            statusMessage = "Completed pass " + currentPass + ". Starting next pass.";
            currentPass++;
            currentIndex = 0;
            swapped = false;
        }
        return false;
    }
    
    @Override
    public int[] getArray() {
        return array;
    }
    
    @Override
    public int getCurrentIndex() {
        return currentIndex;
    }
    
    @Override
    public int getNextIndex() {
        if (currentIndex < n - currentPass - 1)
            return currentIndex + 1;
        else
            return -1;
    }
    
    @Override
    public String getStatusMessage() {
        return statusMessage;
    }

    @Override
    public String getName() {
        return "Bubble Sort";
    }
}
