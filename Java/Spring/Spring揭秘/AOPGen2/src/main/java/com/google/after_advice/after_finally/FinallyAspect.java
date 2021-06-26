package com.google.after_advice.after_finally;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class FinallyAspect {
    @After(value = "execution(public void FinallyClass.finallyGotShit())")
    public void gotShit() {
        System.out.println("-------------Aspect--------------");
        System.out.println("Congratulations to get that shit ... ");
    }
}
