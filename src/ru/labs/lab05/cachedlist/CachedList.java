package ru.labs.lab05.cachedlist;

import java.util.LinkedList;
import java.util.ListIterator;

public class CachedList<T> {
    protected LinkedList<CachedListElement<T>> list;
    protected ListIterator<CachedListElement<T>> iterator;
    public int size;

    private int cursor = -1;

    public CachedList(int size) {
        this.size = size;
    }

    //    private void setIterator(int position) {
//        if (iterator == null) {
//            iterator = list.listIterator();
//        }
//        if (position == cursor) {
//            return;
//        }
//        if (position > cursor) {
//            while (iterator.hasNext()) {
//                iterator.next();
//                if (iterator.nextIndex() == position) {
//                    break;
//                }
//            }
//        } else {
//            while (iterator.hasPrevious()) {
//                iterator.previous();
//                if (iterator.previousIndex() == position) {
//                    break;
//                }
//            }
//        }
//        cursor = position;
//    }

    public CachedListElement<T> setOrCreateCursor(int position) {
        if (iterator == null) {
            list.addLast(new CachedListElement<T>(position));
            iterator = list.listIterator();

            cursor = position;
            return iterator.next();
        }

        if (position == cursor) {
            return iterator.next();
        }


        // If rows and columns lower than cache go forward, else backward
        // if element is not found, add it in the right place with "add"
        // Every element use interface "CachedCursorElement" with method "getPosition"

        if (cursor < position) {
            while (iterator.hasNext()) {
                CachedListElement<T> element = iterator.next();
                if (element.getPosition() == position) {
                    cursor = position;
                    return element;
                }
                if (element.getPosition() > position) {
                    iterator.previous();
                    break;
                }
            }
        } else {
            while (iterator.hasPrevious()) {
                CachedListElement<T> element = iterator.previous();
                if (element.getPosition() == position) {
                    cursor = position;
                    return element;
                }
                if (element.getPosition() < position) {
                    iterator.next();
                    break;
                }
            }
        }
        iterator.add(new CachedListElement<T>(position));
        cursor = position;
        return iterator.next();
    }
}
