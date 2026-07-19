class DynamicArray {
    int array[];
    int elementsCount;
    int capacity;

    public DynamicArray(int capacity) {
        this.array = new int[capacity];
        this.elementsCount = 0;
        this.capacity = capacity;
    }

    public int get(int i) {
        return array[i];
    }

    public void set(int i, int n) {
        array[i] = n;
    }

    public void pushback(int n) {
        if(elementsCount == capacity)
            resize();
        array[elementsCount] = n;
         elementsCount++;
    }

    public int popback() {
        if(elementsCount > 0)
            elementsCount--;
        return array[elementsCount];
    }

    private void resize() {
        capacity = 2 * capacity;
        int[] newArr = new int[capacity];
        for (int i = 0; i < elementsCount; i++) {
            newArr[i] = array[i];
        }
        array = newArr;
    }

    public int getSize() {
        return elementsCount;
    }

    public int getCapacity() {
        return capacity;
    }
}
