package by.tc.rentalshop.controller.command;

import by.tc.rentalshop.bean.Request;
import by.tc.rentalshop.bean.Response;

public interface Command {
	public Response execute(Request request);
}
