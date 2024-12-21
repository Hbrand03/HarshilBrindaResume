import java.lang.Comparable;
import java.util.Arrays;

public class Main<T extends Comparable<T>> {
    T[] data;


    

    public Main(T[] d) {
        data = d;
    }

    public T[] mergeSort() {
        mergeSort(0, data.length - 1);
        return data;
    }

    public void mergeSort(int start, int end) {
        if (start < end){
            int mid = (end + start) / 2;
            mergeSort(start, mid);
            mergeSort(mid + 1, end);

            merge(start, mid, end);
            
        }
    } 

    public void merge(int start, int mid, int end) {
        int l = mid-start +1; //left hand
        int r = end - mid;//right hand
        int i = 0;
        int j=0;
        int k= start;
        //copys the data of boths sides of the data array to a new left and right array
        T[] leftArr= Arrays.copyOfRange(data, start, mid+1);
        T[] rightArr= Arrays.copyOfRange(data, mid+1, end+1);

        while(i < l && j < r) {
            if (leftArr[i].compareTo(rightArr[j]) <= 0) {
                data[k++] = leftArr[i++];
            } else {
                data[k++] = rightArr[j++];
            }
            
        }

        while(i < l) {
            data[k++] = leftArr[i++];
            i++;
        }

        while(j < r) {
            data[k++] = rightArr[j++];
            j++;
        }
            
    }


    public T[] quickSort() {
        quickSort(0, data.length - 1);
        return data;
    }

    public void quickSort(int start, int end) {
        if (start < end) {
            int pivot = partition(start, end);
            quickSort(start, pivot - 1);
            quickSort(pivot + 1, end);
        }
    }

    public int partition(int start, int end){
        T pivot = data[end];
        int i = start - 1;
        for (int j = start; j < end; j++){
            if (data[j].compareTo(pivot) <= 0){
                i++;
                T temp = data[i];
                data[i] = data[j];
                data[j] = temp;
            }
        }
        T temp = data[i + 1];
        data[i + 1] = data[end];
        data[end] = temp;
        return i + 1;
    }
}
