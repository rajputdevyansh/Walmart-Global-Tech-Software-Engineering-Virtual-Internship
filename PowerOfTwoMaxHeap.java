import java.util.ArrayList;
import java.util.Collections;

public class PowerOfTwoMaxHeap {
    private ArrayList<Integer> heap;
    private int childCount;

    public PowerOfTwoMaxHeap(int childCount) {
        this.heap = new ArrayList<>();
        this.childCount = (int) Math.pow(2, childCount);
    }

    public void insert(int value) {
        heap.add(value);
        int i = heap.size() - 1;
        int parent = (i - 1) / childCount;

        while (parent >= 0) {
            if (heap.get(i) > heap.get(parent)) {
                Collections.swap(heap, i, parent);
                i = parent;
                parent = (i - 1) / childCount;
            } else {
                break;
            }
        }
    }
    public int popMax() {
        if (heap.size() == 0) {
            throw new IllegalStateException("Heap is empty");
        } else {
            int poppedValue = heap.get(0);
            heap.set(0, heap.get(heap.size() - 1));
            heap.remove(heap.size() - 1);

            heapify(0);
            return poppedValue;
        }
    }
    private void heapify(int i) {
        int max = i;
        int leftChild = childCount * i + 1;
        int rightChild = childCount * i + childCount;

        for (int j = leftChild; j <= rightChild; j++) {
            if (j < heap.size() && heap.get(j) > heap.get(max)) {
                max = j;
            }
        }
        if (max != i) {
            Collections.swap(heap, i, max);
            heapify(max);
        }
    }
}