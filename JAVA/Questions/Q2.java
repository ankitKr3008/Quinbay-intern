public class MyList<T> {
    private T[] data;
    private int currIndex;

    @SuppressWarnings("unchecked")
    public MyList() {
        data = (T[]) new Object[100];
        currIndex = 0;
    }

    public void add(T value) {
        if (currIndex == data.length) {
            resize();
        }
        data[currIndex++] = value;
    }

    private void resize() {
        @SuppressWarnings("unchecked")
        T[] newData = (T[]) new Object[data.length * 2];
        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;
    }

    public void deleteByIndex(int index) {
        if (index < 0 || index >= currIndex) throw new IndexOutOfBoundsException("Invalid index");
        System.arraycopy(data, index + 1, data, index, currIndex - index - 1);
        currIndex--;
    }

    public void deleteByValue(T value) {
        for (int i = 0; i < currIndex; i++) {
            if (data[i].equals(value)) {
                deleteByIndex(i);
                return;
            }
        }
    }

    public T get(int index) {
        if (index < 0 || index >= currIndex) throw new IndexOutOfBoundsException("Invalid index");
        return data[index];
    }

    public int size() {
        return currIndex;
    }
}
