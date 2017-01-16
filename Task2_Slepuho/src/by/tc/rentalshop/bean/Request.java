package by.tc.rentalshop.bean;

import by.tc.rentalshop.controller.CommandsNames;

public class Request {
    private CommandsNames command;

    public CommandsNames getCommand() {
        return command;
    }

    public void setCommand(CommandsNames command) {
        this.command = command;
    }
}

