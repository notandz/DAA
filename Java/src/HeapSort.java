import java.io.*;
import java.util.*;

class HeapSort {

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        //read file
        File file = new File("D:/KULIAH SMT 3/DAA/JURNAL/daa/src/nanda_wordlist.txt");
        Scanner sc = new Scanner(file);
        ArrayList<String> list = new ArrayList<>();
        while (sc.hasNextLine()) {
            list.add(sc.nextLine());
        }
        sc.close();
        //sort
        String[] arr = list.toArray(new String[0]);
        heapSort(arr);
        //write file
        FileWriter writer = new FileWriter("Heap_Java.txt");
        for (String str : arr) {
            writer.write(str + System.lineSeparator());
        }
        writer.close();
        long time = System.currentTimeMillis() - start;
        System.out.println("lama waktu (TimeMillis): " + time);
    }

    public static void heapSort(String[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        for (int i = n - 1; i >= 0; i--) {
            String temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    public static void heapify(String[] arr, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < n && arr[l].compareTo(arr[largest]) > 0) {
            largest = l;
        }
        if (r < n && arr[r].compareTo(arr[largest]) > 0) {
            largest = r;
        }
        if (largest != i) {
            String swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
        }
    }
}