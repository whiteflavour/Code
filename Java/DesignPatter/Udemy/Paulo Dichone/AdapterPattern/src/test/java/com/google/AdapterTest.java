package com.google;

import com.google.model.AndroidPhone;
import com.google.model.IPhone;
import com.google.model.LightningToMicroUsbAdapter;
import org.junit.jupiter.api.Test;

public class AdapterTest {
    @Test
    public void testAdapter() {
        IPhone iPhone = new IPhone("iPhone 13 Pro");
        AndroidPhone androidPhone = new AndroidPhone("Google pixel 6");
        iPhone.useLightning();
        iPhone.recharge();
        androidPhone.useMicroUsb();
        androidPhone.recharge();

        LightningToMicroUsbAdapter adapter = new LightningToMicroUsbAdapter(iPhone);
        adapter.useMicroUsb();
        adapter.recharge();
    }
}
