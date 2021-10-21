package com.google;

import com.google.interfaces.Iterator;
import com.google.model.NameRepository;
import org.junit.jupiter.api.Test;

public class IteratorPatternTest {
    @Test
    public void testIteratorPattern() {
        NameRepository nameRepository = new NameRepository();
        Iterator iterator = nameRepository.getIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
