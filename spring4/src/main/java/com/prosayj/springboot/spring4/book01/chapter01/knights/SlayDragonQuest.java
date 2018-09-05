package com.prosayj.springboot.spring4.book01.chapter01.knights;

import java.io.PrintStream;

/**
 * 杀 龙 的问题
 * @author ProSayJ
 */
public class SlayDragonQuest implements Quest {

    private PrintStream stream;

    public SlayDragonQuest(PrintStream stream) {
        this.stream = stream;
    }

    @Override
    public void embark() {
        stream.println("Embarking on quest to slay the dragon!");
    }

}
