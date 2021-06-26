package com.google.introduction;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class IntroductionAspect {
    @DeclareParents(
            // 类名要指定完整，否则会织入失败，找不到该类
            value = "com.google.introduction.MockTask",
            defaultImpl = CounterImpl.class
    )
    public ICounter counter;
}
