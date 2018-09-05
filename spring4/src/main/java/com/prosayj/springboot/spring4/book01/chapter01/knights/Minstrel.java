package com.prosayj.springboot.spring4.book01.chapter01.knights;

import java.io.PrintStream;

/**
 * 歌手
 *
 * @author ProSayJ
 */
public class Minstrel {

    private PrintStream stream;

    public Minstrel(PrintStream stream) {
        this.stream = stream;
    }

    public void singBeforeQuest() {
        stream.println("Fa la la, the knight is so brave!");
    }

    public void singAfterQuest() {
        stream.println("Tee hee hee, the brave knight " +
                "did embark on a quest!");
    }

}
