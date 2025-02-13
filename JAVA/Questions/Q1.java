public class MyList {
    private int[] data;
    private int currIndex;

    public MyList() {
        data = new int[100];
        currIndex = 0;
    }

    public void add(int value) {
        if (currIndex == data.length) {
            resize();
        }
        data[currIndex++] = value;
    }

    private void resize() {
        int[] newData = new int[data.length * 2];
        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;
    }

    public void deleteByIndex(int index) {
        if (index < 0 || index >= currIndex) throw new IndexOutOfBoundsException("Invalid index");
        for(int i = index+1; i <= currIndex; i++){
            data[i-1] = data[i];
        }
        currIndex--;
    }

    public void deleteByValue(int value) {
        for (int i = 0; i < currIndex; i++) {
            if (data[i] == value) {
                deleteByIndex(i);
                return;
            }
        }
    }

    public int get(int index) {
        if (index < 0 || index >= currIndex) throw new IndexOutOfBoundsException("Invalid index");
        return data[index];
    }

    public int size() {
        return currIndex;
    }
}
