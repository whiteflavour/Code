package com.google.model;

import com.google.interfaces.Container;
import com.google.interfaces.Iterator;

public class NameRepository implements Container {
    public String[] names = {"Tom", "Jack", "Rose", "Jerry"};

    @Override
    public Iterator getIterator() {
        return new NameRepositoryIterator();
    }

    private class NameRepositoryIterator implements Iterator {
        private int index;

        @Override
        public boolean hasNext() {
            return index < names.length;
        }

        @Override
        public Object next() {
            if (this.hasNext()) {
                return names[index++];
            }
            return null;
        }
    }
}
