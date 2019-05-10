package com.hotdog.designpattern.command;

/**
 * @Author: hecy
 * @Date: 2019/5/10 10:00
 * @Version 1.0
 */
public class RemoteControl {
    Command[] onCommands;
    Command[] offCommands;

    public RemoteControl() {
        onCommands = new Command[7];
        offCommands = new Command[7];

        Command noCommand = new NoCommand();

        for (int i = 0; i < 7; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
    }

    public void setCommand(int solt, Command onCommand, Command offCommand) {
        onCommands[solt] = onCommand;
        offCommands[solt] = offCommand;
    }

    public void onButtonWasPushed(int solt) {
        onCommands[solt].execute();
    }

    public void offButtonWasPushed(int solt) {
        offCommands[solt].execute();
    }



}
