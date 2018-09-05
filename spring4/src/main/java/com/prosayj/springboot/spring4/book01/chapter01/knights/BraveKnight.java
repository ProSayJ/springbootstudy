package com.prosayj.springboot.spring4.book01.chapter01.knights;

/**
 * 勇敢的骑士
 *
 * @author ProSayJ
 */
public class BraveKnight implements Knight {

    private Quest quest;

    public BraveKnight(Quest quest) {
        this.quest = quest;
    }

    @Override
    public void embarkOnQuest() {
        quest.embark();
    }

}
