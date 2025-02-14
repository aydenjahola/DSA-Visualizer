package dsaVisualizer;

import java.util.Random;

public class SelectionSort implements SortAlgorithm {
    private int[] array;
    private int n;
    private int currentPass;
    private int currentMinIndex;
    private int currentCompareIndex;
    private boolean sorted;
    private String statusMessage;
    private boolean swappedThisStep;
    private int swapIndex1;
    private int swapIndex2;

    public SelectionSort(int size, double maxValue) {
        array = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt((int) maxValue - 10) + 10;
        }
        n = array.length;
        currentPass = 0;
        currentMinIndex = currentPass;
        currentCompareIndex = currentPass + 1;
        sorted = false;
        statusMessage = "Initialized array.";
        swappedThisStep = false;
    }

    @Override
    public boolean step() {
        swappedThisStep = false;

        if (sorted) {
            statusMessage = "Array is fully sorted.";
            return true;
        }

        if (currentPass >= n - 1) {
            sorted = true;
            statusMessage = "Array is fully sorted.";
            return true;
        }

        if (currentCompareIndex < n) {
            if (array[currentCompareIndex] < array[currentMinIndex]) {
                currentMinIndex = currentCompareIndex;
                statusMessage = "New minimum found at index " + currentMinIndex;
            } else {
                statusMessage = "Comparing index " + currentCompareIndex + " with current minimum " + currentMinIndex;
            }
            currentCompareIndex++;
        } else {
            if (currentMinIndex != currentPass) {
                int temp = array[currentPass];
                array[currentPass] = array[currentMinIndex];
                array[currentMinIndex] = temp;
                swappedThisStep = true;
                swapIndex1 = currentPass;
                swapIndex2 = currentMinIndex;
                statusMessage = "Swapped elements at positions " + currentPass + " and " + currentMinIndex;
            } else {
                statusMessage = "No swap needed in pass " + currentPass;
            }

            currentPass++;
            currentMinIndex = currentPass;
            currentCompareIndex = currentPass + 1;

            if (currentPass >= n - 1) {
                sorted = true;
                statusMessage = "Array is fully sorted.";
                return true;
            }
        }

        return false;
    }

    @Override
    public int[] getArray() {
        return array;
    }

    @Override
    public int getCurrentIndex() {
        if (swappedThisStep) {
            return swapIndex1;
        } else {
            return currentCompareIndex;
        }
    }

    @Override
    public int getNextIndex() {
        if (swappedThisStep) {
            return swapIndex2;
        } else {
            return currentMinIndex;
        }
    }

    @Override
    public String getStatusMessage() {
        return statusMessage;
    }

    @Override
    public String getName() {
        return "Selection Sort";
    }
}