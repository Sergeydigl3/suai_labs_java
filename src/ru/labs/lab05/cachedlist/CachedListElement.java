package ru.labs.lab05.cachedlist;

public class CachedListElement<T> {
    private int position;
    private T element;

    public CachedListElement(int position) {
        this.position = position;
    }

    public CachedListElement(int position, T element) {
        this.position = position;
        this.element = element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public int getPosition() {
        return position;
    }

    public T getElement() {
        return element;
    }
}
