package com.google;

import com.google.interfaces.Bank;
import com.google.model.ProxyBank;
import com.google.model.RealBank;
import org.junit.jupiter.api.Test;

public class ProxyPatternTest {
    @Test
    public void testProxyBank() {
        Bank proxyBank = new ProxyBank();
        proxyBank.withdrawMoney();
        System.out.println();
        Bank realBank = new RealBank();
        realBank.withdrawMoney();
    }
}
