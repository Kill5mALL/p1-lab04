import java.util.Arrays;

interface SortStrategy {
    void sort(short[] a);
}

class InsertionSort implements SortStrategy {
    public void sort(short[] a) {
        for (int i = 1; i < a.length; i++) {
            short key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] < key) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
    }
}

class BubbleSort implements SortStrategy {
    public void sort(short[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] < a[j + 1]) {
                    short tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }
}

class Sorter {
    private SortStrategy strategy;

    Sorter(SortStrategy strategy) {
        this.strategy = strategy;
    }

    void setStrategy(SortStrategy strategy) {
        this.strategy = strategy;
    }

    void sort(short[] a) {
        strategy.sort(a);
    }
}

public class Lab04 {
    public static void main(String[] args) {
        short[][] tests = {
            {5, -2, 9, 0, 14, 3, -8},
            {1, 2, 3, 4, 5},
            {7, 7, -1, 7, 0},
            {}
        };

        Sorter sorter = new Sorter(new InsertionSort());
        for (short[] data : tests) {
            System.out.println("Масив:          " + Arrays.toString(data));

            sorter.setStrategy(new InsertionSort());
            short[] a = data.clone();
            sorter.sort(a);
            System.out.println("Insertion sort: " + Arrays.toString(a));

            sorter.setStrategy(new BubbleSort());
            short[] b = data.clone();
            sorter.sort(b);
            System.out.println("Bubble sort:    " + Arrays.toString(b));
            System.out.println();
        }
    }
}
