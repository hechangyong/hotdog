package com.hotdog.designpattern.command;

import com.hotdog.designpattern.command.model.Light;

/**
 * @Author: hecy
 * @Date: 2019/5/9 14:54
 * @Version 1.0
 */
public class MainCommandTest {
    public static void main(String[] args) {
//        SimpleRemoteControl simpleRemoteControl = new SimpleRemoteControl();
        RemoteControl remoteControl = new RemoteControl();

        Light light = new Light();

        //命令对象
        LightOnCommand lightOnCommand = new LightOnCommand(light);
        LightOffCommand lightOffCommand = new LightOffCommand(light);


        remoteControl.setCommand(0, lightOnCommand,lightOffCommand);
        remoteControl.onButtonWasPushed(0);
        remoteControl.offButtonWasPushed(0);

    }

}
