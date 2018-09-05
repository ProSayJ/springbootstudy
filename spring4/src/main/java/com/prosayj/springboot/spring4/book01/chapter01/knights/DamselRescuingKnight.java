package com.prosayj.springboot.spring4.book01.chapter01.knights;

/**
 * 年轻的有解救能力的其实 骑士
 *
 * @author ProSayJ
 */
public class DamselRescuingKnight implements Knight {

    private RescueDamselQuest quest;

    public DamselRescuingKnight() {
        this.quest = new RescueDamselQuest();
    }

    @Override
    public void embarkOnQuest() {
        quest.embark();
    }

}
