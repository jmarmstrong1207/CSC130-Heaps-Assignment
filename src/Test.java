import java.util.ArrayList;

public class Test {

    private static boolean testRemoveElement()
    {
        MaxThreeHeap h = new MaxThreeHeap();

        h.insert(1);
        h.insert(2);
        h.insert(3);
        h.insert(4);
        h.insert(5);
        h.insert(6);
        h.insert(7);
        h.insert(8);
        h.insert(9);

        h.removeElement(5);

        ArrayList<Integer> correctOrder = new ArrayList<>();
        correctOrder.add(9);
        correctOrder.add(7);
        correctOrder.add(8);
        correctOrder.add(3);
        correctOrder.add(1);
        correctOrder.add(4);
        correctOrder.add(6);
        correctOrder.add(2);

        int index = 0;
        for (int x : h.getHeap())
        {
            if ( x != correctOrder.get(index++)) return false;
        }
        return true;

    }
    private static boolean testInsert()
    {
        MaxThreeHeap h = new MaxThreeHeap();

        h.insert(1);
        h.insert(2);
        h.insert(3);
        h.insert(4);
        h.insert(5);
        h.insert(6);
        h.insert(7);
        h.insert(8);
        h.insert(9);


        ArrayList<Integer> correctOrder = new ArrayList<>();
        correctOrder.add(9);
        correctOrder.add(6);
        correctOrder.add(8);
        correctOrder.add(3);
        correctOrder.add(1);
        correctOrder.add(4);
        correctOrder.add(5);
        correctOrder.add(2);
        correctOrder.add(7);

        int index = 0;
        for (int x : h.getHeap())
        {
            if ( x != correctOrder.get(index++)) return false;
        }
        return true;

    }
    private static boolean testRemoveLargest()
    {
        MaxThreeHeap h = new MaxThreeHeap();

        h.insert(1);
        h.insert(2);
        h.insert(3);
        h.insert(4);
        h.insert(5);
        h.insert(6);
        h.insert(7);
        h.insert(8);
        h.insert(9);

        h.removeLargest();

        ArrayList<Integer> correctOrder = new ArrayList<>();
        correctOrder.add(8);
        correctOrder.add(6);
        correctOrder.add(7);
        correctOrder.add(3);
        correctOrder.add(1);
        correctOrder.add(4);
        correctOrder.add(5);
        correctOrder.add(2);

        int index = 0;
        for (int x : h.getHeap())
        {
            if ( x != correctOrder.get(index++)) return false;
        }
        return true;
    }

    // This tests the constructor that initializes the heap with a starting array. Returns true if it works
    private static boolean testHeapConstructor()
    {
        ArrayList<Integer> i = new ArrayList<>();
        i.add(1);
        i.add(2);
        i.add(3);
        i.add(4);
        i.add(5);
        i.add(6);
        i.add(7);
        i.add(8);
        i.add(9);

        MaxThreeHeap hh = new MaxThreeHeap(i);

        ArrayList<Integer> correctOrder = new ArrayList<>();
        correctOrder.add(9);
        correctOrder.add(7);
        correctOrder.add(8);
        correctOrder.add(4);
        correctOrder.add(5);
        correctOrder.add(6);
        correctOrder.add(2);
        correctOrder.add(1);
        correctOrder.add(3);

        int index = 0;
        for (int x : hh.getHeap())
        {
            if ( x != correctOrder.get(index++)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // Heap works as intended only if all test functions work
        boolean testRemoveElement = testRemoveElement();
        boolean testInsert = testInsert();
        boolean testRemoveLargest = testRemoveLargest();
        boolean testHeapConstructor = testHeapConstructor();
        System.out.println("Heap works as intended: " +
                (testRemoveElement && testInsert && testRemoveLargest && testHeapConstructor));

        System.out.println("testRemoveElement: " + testRemoveElement());
        System.out.println("testInsert: " + testInsert);
        System.out.println("testRemoveLargest: " + testRemoveLargest);
        System.out.println("testHeapConstructor: " + testHeapConstructor);

    }
}
