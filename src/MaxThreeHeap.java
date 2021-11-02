import java.util.ArrayList;

// A heap, represented as an array, where each node has at max 3 children
public class MaxThreeHeap {
    private ArrayList<Integer> heap;

    public ArrayList<Integer> getHeap()
    {
        return heap;
    }

    public MaxThreeHeap()
    {
        heap = new ArrayList<>();
    }

    public MaxThreeHeap(ArrayList<Integer> initial)
    {
        heap = initial;
        for (int i = (heap.size()) / 3; i >= 0; i--)
        {
            reorderDown(i);
        }
    }
    // will return the index of parent of the current node, indicated as the index in the array
    public int getParentIndex(int i)
    {
        return (i - 1) / 3;
    }

    // get child c of node i. This is a 3-child node, so 1 <= c <= 3
    public int getChildIndex(int i, int c)
    {
        return 3 * i + c;
    }

    // Reorder the parents of the current node, happens from an insert.
    private void reorderUp(int i)
    {
        int currentNodeValue = heap.get(i);
        if (i == 0) return; // if we reached root node

        int parentIndex = getParentIndex(i);
        int parentValue = heap.get(parentIndex);


        if (parentValue < currentNodeValue)
        {
            heap.set(i, parentValue);
            heap.set(parentIndex, currentNodeValue);

            reorderUp(parentIndex);
        }
    }

    // This function will reorder the subtree below node i, either from removing the root node or by building the tree
    // with an initial array
    private void reorderDown(int i)
    {
        int currentNodeValue = heap.get(i);


        int firstChildIndex = getChildIndex(i, 1);
        int firstChildValue = (firstChildIndex < heap.size()) ? heap.get(firstChildIndex) : -1;

        int secondChildIndex = getChildIndex(i, 2);
        int secondChildValue = (secondChildIndex < heap.size()) ? heap.get(secondChildIndex) : -1;

        int thirdChildIndex = getChildIndex(i, 3);
        int thirdChildValue = (thirdChildIndex < heap.size()) ? heap.get(thirdChildIndex) : -1;

        int largestChildIndex;
        int largestChildValue;

        //////////////////
        // this section finds the largest-value child
        if (firstChildValue < secondChildValue) largestChildIndex = secondChildIndex;
        else largestChildIndex = firstChildIndex;

        largestChildValue = (largestChildIndex < heap.size()) ? heap.get(largestChildIndex) : -1;

        if (largestChildValue < thirdChildValue) largestChildIndex = thirdChildIndex;

        largestChildValue = (largestChildIndex < heap.size()) ? heap.get(largestChildIndex) : -1;

        // If there are no children, exit
        if (largestChildValue == -1) return;
        //////////////////

        if (largestChildValue > currentNodeValue)
        {
            heap.set(i, largestChildValue);
            heap.set(largestChildIndex, currentNodeValue);
            reorderDown(largestChildIndex);
        }
    }

    public int removeLargest()
    {
        int x = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);

        reorderDown(0);

        return x;
    }

    // insert x in the heap
    // Big O would be O(logn)
    public void insert(int x)
    {
        heap.add(x);

        // reorder nodes recursively, starting at this node inserted
        reorderUp(heap.size() - 1);
    }

    // This function finds a specific element in the array, then deletes it. It will reorder it as needed
    // This function isn't specified in the lecture, but necessary for hackerrank problem QHEAP1
    public void removeElement(int e)
    {

        // Find the index of the element in the heap
        int index = 0;
        for (int i = 0; i < heap.size(); i++)
        {
            if (heap.get(i) == e) index = i;
        }

        heap.set(index, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);

        // Reorder the heap starting from the index. Because it's possible that the index
        // is in the middle of the tree, we have to reorder the subtree of the index by reorderDown()
        // and then reorder the tree above it with reorderUp()
        reorderDown(index);
        reorderUp(index);
    }

}
