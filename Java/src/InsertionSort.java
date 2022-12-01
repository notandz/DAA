import java.io.*;
import java.util.*;
public class InsertionSort {
    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        //read file
        File file = new File("D:/KULIAH SMT 3/DAA/JURNAL/daa/src/nanda_wordlist.txt");
        Scanner sc = new Scanner(file);
        ArrayList<String> list = new ArrayList<String>();
        while (sc.hasNextLine()) {
            list.add(sc.nextLine());
        }
        sc.close();
        //sort
        String[] arr = list.toArray(new String[0]);
        insertionSort(arr);
        //write file
        FileWriter writer = new FileWriter("Insertion_Java.txt");
        for (String str : arr) {
            writer.write(str + System.lineSeparator());
        }
        writer.close();
        long time = System.currentTimeMillis() - start;
        System.out.println("lama waktu (TimeMillis): " + time);
    }

    public static void insertionSort(String[] arr) {
        for (int i = 1; i < arr.length; i++) {
            String temp = arr[i];
            int j = i - 1;
            while (j >= 0 && temp.compareTo(arr[j]) < 0) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }
}