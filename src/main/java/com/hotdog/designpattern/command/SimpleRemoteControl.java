package com.hotdog.designpattern.command;

/**
 * @Author: hecy
 * @Date: 2019/5/9 14:46
 * @Version 1.0
 */
public class SimpleRemoteControl {
    Command slot;

    public SimpleRemoteControl(){}


    public void setCommand(Command command){
        slot = command;
    }
    public void buttonWasPressed(){
        slot.execute();
    }
}
