package main;
import java.util.Arrays;

public class VectorOperations {

    private int[] vector;

    public VectorOperations(int size) {
        this.vector = new int[size];
    }

    // 1. Inserción
    public void insertInicio(int value) {
        int[] newVector = new int[vector.length + 1];
        newVector[0] = value;
        System.arraycopy(vector, 0, newVector, 1, vector.length);
        vector = newVector;
    }

    public void insertFinal(int value) {
        int[] newVector = new int[vector.length + 1];
        System.arraycopy(vector, 0, newVector, 0, vector.length);
        newVector[vector.length] = value;
        vector = newVector;
    }

    public void insertPosicion(int value, int position) {
        if (position >= 0 && position <= vector.length) {
            int[] newVector = new int[vector.length + 1];
            System.arraycopy(vector, 0, newVector, 0, position);
            newVector[position] = value;
            System.arraycopy(vector, position, newVector, position + 1, vector.length - position);
            vector = newVector;
        }
    }

    public void insertAntes(int value, int position) {
        insertPosicion(value, position);
    }

    public void insertDespues(int value, int position) {
        insertPosicion(value, position + 1);
    }

    // 2. Eliminación
    public void deleteInicio() {
        if (vector.length > 0) {
            int[] newVector = new int[vector.length - 1];
            System.arraycopy(vector, 1, newVector, 0, vector.length - 1);
            vector = newVector;
        }
    }

    public void deleteFinal() {
        if (vector.length > 0) {
            int[] newVector = new int[vector.length - 1];
            System.arraycopy(vector, 0, newVector, 0, vector.length - 1);
            vector = newVector;
        }
    }

    public void deletePosicion(int position) {
        if (position >= 0 && position < vector.length) {
            int[] newVector = new int[vector.length - 1];
            System.arraycopy(vector, 0, newVector, 0, position);
            System.arraycopy(vector, position + 1, newVector, position, vector.length - position - 1);
            vector = newVector;
        }
    }

    public void deleteAntes(int position) {
        deletePosicion(position - 1);
    }

    public void deleteDespues(int position) {
        deletePosicion(position + 1);
    }

    public void deleteDato(int value) {
        int count = 0;
        for (int element : vector) {
            if (element != value) {
                count++;
            }
        }
        int[] newVector = new int[count];
        int index = 0;
        for (int element : vector) {
            if (element != value) {
                newVector[index++] = element;
            }
        }
        vector = newVector;
    }

    public void deleteRepeticiones(int value) {
        deleteDato(value);
    }

    // 3. Búsqueda
    public boolean existeDato(int value) {
        for (int element : vector) {
            if (element == value) {
                return true;
            }
        }
        return false;
    }

    public int contarRepeticiones(int value) {
        int count = 0;
        for (int element : vector) {
            if (element == value) {
                count++;
            }
        }
        return count;
    }

    public int buscarBinario(int value) {
        int left = 0;
        int right = vector.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (vector[mid] == value) {
                return mid;
            } else if (vector[mid] < value) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    // 4. Ordenamiento
    public void intercambioDirecto() {
        for (int i = 0; i < vector.length - 1; i++) {
            for (int j = 0; j < vector.length - i - 1; j++) {
                if (vector[j] > vector[j + 1]) {
                    int temp = vector[j];
                    vector[j] = vector[j + 1];
                    vector[j + 1] = temp;
                }
            }
        }
    }

    public void seleccion() {
        for (int i = 0; i < vector.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < vector.length; j++) {
                if (vector[j] < vector[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = vector[minIndex];
            vector[minIndex] = vector[i];
            vector[i] = temp;
        }
    }

    public void insercion() {
        for (int i = 1; i < vector.length; i++) {
            int key = vector[i];
            int j = i - 1;
            while (j >= 0 && vector[j] > key) {
                vector[j + 1] = vector[j];
                j--;
            }
            vector[j + 1] = key;
        }
    }

    public void quicksort() {
        quicksort(vector, 0, vector.length - 1);
    }

    private void quicksort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quicksort(arr, low, pi - 1);
            quicksort(arr, pi + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    // 5. Modificación
    public void modificarValor(int oldValue, int newValue) {
        for (int i = 0; i < vector.length; i++) {
            if (vector[i] == oldValue) {
                vector[i] = newValue;
            }
        }
    }

    public void modificarPosicion(int position, int newValue) {
        if (position >= 0 && position < vector.length) {
            vector[position] = newValue;
        }
    }

    // 6. Recorrido
    public void recorrido() {
        System.out.println(Arrays.toString(vector));
    }

    // Getters y setters para el vector
    public int[] getVector() {
        return vector;
    }

    public void setVector(int[] vector) {
        this.vector = vector;
    }
}
