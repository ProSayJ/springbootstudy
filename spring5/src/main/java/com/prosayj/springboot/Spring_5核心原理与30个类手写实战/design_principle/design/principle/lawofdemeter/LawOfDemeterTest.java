package com.prosayj.springboot.Spring_5核心原理与30个类手写实战.design_principle.design.principle.lawofdemeter;

/**
 * Created by Tom
 */
public class LawOfDemeterTest {

    public static void main(String[] args) {
        Boss boss = new Boss();
        TeamLeader teamLeader = new TeamLeader();
        boss.commandCheckNumber(teamLeader);
    }

}
