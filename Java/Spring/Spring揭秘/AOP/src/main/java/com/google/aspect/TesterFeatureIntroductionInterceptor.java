package com.google.aspect;

import com.google.advice.ITester;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

/**
 * 扩展 DelegatingIntroductionInterceptor
 *
 * @date 2021-6-7
 */
public class TesterFeatureIntroductionInterceptor extends DelegatingIntroductionInterceptor implements ITester {
    private static final long serialVersionUID = 4L;
    private boolean busyAsTester;

    public void setBusyAsTester(boolean busyAsTester) {
        this.busyAsTester = busyAsTester;
    }

    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        if (isBusyAsTester() && mi.getMethod().getName().equals("developSoftware")) {
            throw new RuntimeException("qnmd");
        }
        return super.invoke(mi);
    }

    @Override
    public boolean isBusyAsTester() {
        return busyAsTester;
    }

    @Override
    public void testSoftware() {
        System.out.println("testing ... ");
    }
}
