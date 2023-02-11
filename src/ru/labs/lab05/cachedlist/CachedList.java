package ru.labs.lab05.cachedlist;

import java.util.LinkedList;
import java.util.ListIterator;

public class CachedList<T> {
    protected LinkedList<CachedListElement<T>> list;
    protected ListIterator<CachedListElement<T>> iterator;
    public int size;

    CachedListElement<T> element;

    public CachedList(int size) {
        this.size = size;
    }

    public CachedListElement<T> setOrCreateCursor(int position) {
        if (iterator == null) {
            list = new LinkedList<>();
            element = new CachedListElement<>(position);
            list.addLast(element);
            iterator = list.listIterator();
            
            return iterator.next();
        }

        if (position == element.getPosition()) {
            return element;
        }


        // If rows and columns lower than cache go forward, else backward
        // if element is not found, add it in the right place with "add"
        // Every element use interface "CachedCursorElement" with method "getPosition"

        if (element.getPosition() < position) {
            while (iterator.hasNext()) {
                element = iterator.next();
                if (element.getPosition() == position) {
                    return element;
                }
                if (element.getPosition() > position) {
                    element = iterator.previous();
                    break;
                }
            }
        } else {
            while (iterator.hasPrevious()) {
                element = iterator.previous();
                if (element.getPosition() == position) {
                    return element;
                }
                if (element.getPosition() < position) {
                    element = iterator.next();
                    break;
                }
            }
        }
        element = new CachedListElement<>(position);
        iterator.add(element);
        return element;
    }

    // get element by position or return null
    public CachedListElement<T> get(int position) {
        if (iterator == null) {
            return null;
        }

        if (position == element.getPosition()) {
            return element;
        }

        if (element.getPosition() < position) {
            while (iterator.hasNext()) {
                element = iterator.next();
                if (element.getPosition() == position) {
                    return element;
                }
                if (element.getPosition() > position) {
                    element = iterator.previous();
                    break;
                }
            }
        } else {
            while (iterator.hasPrevious()) {
                element = iterator.previous();
                if (element.getPosition() == position) {
                    return element;
                }
                if (element.getPosition() < position) {
                    element = iterator.next();
                    break;
                }
            }
        }
        return null;
    }
}
