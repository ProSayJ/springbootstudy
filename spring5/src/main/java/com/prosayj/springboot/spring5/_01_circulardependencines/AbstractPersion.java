package com.prosayj.springboot.spring5._01_circulardependencines;

abstract class AbstractPersion {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    abstract void eat();
}
