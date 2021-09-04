package com.google.test;

import com.google.example.AmericanObserver;
import com.google.example.ChineseObserver;
import com.google.example.Subject;
import org.junit.jupiter.api.Test;

public class ObserverPatternTest {
    @Test
    public void testObserverPattern() {
        Subject subject = new Subject();
        ChineseObserver chineseObserver = new ChineseObserver();
        AmericanObserver americanObserver = new AmericanObserver();
        subject.registerObserver(chineseObserver);
        subject.registerObserver(americanObserver);
        subject.notifyObservers(subject.getObservers());
        subject.unregisterObserver(americanObserver);
        subject.notifyObservers(subject.getObservers());
    }
}
