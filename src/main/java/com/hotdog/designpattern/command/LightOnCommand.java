package com.hotdog.designpattern.command;

import com.hotdog.designpattern.command.model.Light;

/**
 * @Author: hecy
 * @Date: 2019/5/9 14:17
 * @Version 1.0
 */
public class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
}
