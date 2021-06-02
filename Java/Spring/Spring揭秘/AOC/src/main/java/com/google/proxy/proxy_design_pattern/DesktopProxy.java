package com.google.proxy.proxy_design_pattern;

public class DesktopProxy implements Computer{
    @Override
    public void showType() {
        new Desktop("desktop").showType();
    }
}
