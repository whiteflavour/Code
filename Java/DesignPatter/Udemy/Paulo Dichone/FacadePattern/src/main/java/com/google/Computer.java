package com.google;

public class Computer {
    private CPU cpu;
    private HardDrive hardDrive;
    private Memory memory;

    public Computer() {
        cpu = new CPU();
        hardDrive = new HardDrive();
        memory = new Memory();
    }

    public void startComputer() {
        cpu.freeze();
        memory.load(123, hardDrive.read(654, 2));
        cpu.jump(123);
        cpu.execute();
    }
}
