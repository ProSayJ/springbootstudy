package com.prosayj.springboot.spring4.book01.chapter01.knights;

/**
 * 营救 少女 的问题
 * @author ProSayJ
 */
public class RescueDamselQuest implements Quest {

  @Override
  public void embark() {
    System.out.println("Embarking on a quest to rescue the damsel.");
  }

}
