package com.prosayj.springboot.图解Java多线程设计模式._01_SingleThreadedExecution.a1_5;

public class CrackerThread extends Thread {
    private final SecurityGate gate;
    public CrackerThread(SecurityGate gate) {
        this.gate = gate;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            gate.enter();
            gate.exit();
        }
    }
}
