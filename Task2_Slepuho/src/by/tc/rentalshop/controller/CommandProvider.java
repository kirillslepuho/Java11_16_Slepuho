package by.tc.rentalshop.controller;

import java.util.HashMap;

import by.tc.rentalshop.controller.command.Command;
import by.tc.rentalshop.controller.command.impl.AddSportEquipment;
import by.tc.rentalshop.controller.command.impl.DeleteSportEquipment;
import by.tc.rentalshop.controller.command.impl.DeleteUser;
import by.tc.rentalshop.controller.command.impl.EditSportEquipment;
import by.tc.rentalshop.controller.command.impl.EditUser;
import by.tc.rentalshop.controller.command.impl.Registration;
import by.tc.rentalshop.controller.command.impl.RentEquipment;
import by.tc.rentalshop.controller.command.impl.ReturnEquipment;
import by.tc.rentalshop.controller.command.impl.SignIn;

public class CommandProvider {

	private HashMap<CommandsNames, Command> repository = new HashMap<>();

	CommandProvider() {
		repository.put(CommandsNames.ADD_SPORTEQUIPMENT, new AddSportEquipment());
		repository.put(CommandsNames.DELETE_SPORTEQUIPMENT, new DeleteSportEquipment());
		repository.put(CommandsNames.DELETE_USER, new DeleteUser());
		repository.put(CommandsNames.EDIT_SPORTEQUIPMENT, new EditSportEquipment());
		repository.put(CommandsNames.EDIT_USER, new EditUser());
		repository.put(CommandsNames.REGISTRATION, new Registration());
		repository.put(CommandsNames.RENT_EQUIPMENT, new RentEquipment());
		repository.put(CommandsNames.RETURN_EQUIPMENT, new ReturnEquipment());
		repository.put(CommandsNames.SIGN_IN, new SignIn());
	}

	public Command getCommand(CommandsNames name) {
		Command command = null;

		try {
			command = repository.get(name);
		} catch (IllegalArgumentException | NullPointerException e) {
			// write log
			command = repository.get(CommandsNames.WRONG_REQUEST);
		}

		return command;
	}
}