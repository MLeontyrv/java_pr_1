package task_2;

interface Box<T> {

    T open();

    void put(T item);

    T removeFromBox();
}
