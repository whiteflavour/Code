package com.google;

import com.google.manually_clone.Dolphin;
import com.google.manually_clone.Person;
import org.junit.jupiter.api.Test;

public class CloneTest {
    @Test
    public void testClone() {
        Person bonni = new Person("bonni", 21);
        System.out.println("Person 1: " + bonni);

        Person nina = (Person) bonni.clone();
        nina.setName("Nina");
        System.out.println("Person 2: " + nina);

        Dolphin jerry = new Dolphin("jerry", 78);
        System.out.println("Dolphin 1: " + jerry);

        Dolphin sam = (Dolphin) jerry.clone();
        System.out.println("Dolphin 2: " + sam);

        System.out.println(System.identityHashCode(bonni) + "\n"
            + System.identityHashCode(nina) + "\n"
            + System.identityHashCode(jerry) + "\n"
            + System.identityHashCode(sam));
    }
}
