package dsaVisualizer;

public interface SortAlgorithm {
    /**
     * Perform one step of the sorting algorithm.
     * @return true if sorting is complete.
     */
    boolean step();
    
    /**
     * @return the current array state.
     */
    int[] getArray();
    
    /**
     * @return index of the current element being compared.
     */
    int getCurrentIndex();
    
    /**
     * @return index of the next element being compared.
     */
    int getNextIndex();
    
    /**
     * @return a status message describing the last operation.
     */
    String getStatusMessage();
}
