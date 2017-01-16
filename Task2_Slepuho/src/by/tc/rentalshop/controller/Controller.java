package by.tc.rentalshop.controller;

import by.tc.rentalshop.bean.Request;
import by.tc.rentalshop.bean.Response;
import by.tc.rentalshop.controller.command.Command;

public class Controller {
	private final CommandProvider commandProvider = new CommandProvider();

	public Response executeTask(Request request) {
		CommandsNames executeCommand = request.getCommand();
		Command command = commandProvider.getCommand(executeCommand);
		Response response = command.execute(request);
		return response;
	}
}