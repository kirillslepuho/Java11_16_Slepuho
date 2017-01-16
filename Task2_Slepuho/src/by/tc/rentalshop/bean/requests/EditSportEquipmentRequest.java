package by.tc.rentalshop.bean.requests;

import by.tc.rentalshop.controller.CommandsNames;

public class EditSportEquipmentRequest extends AddSportEquipmentRequest {
	private int ÒhangedEquipmentId;

	public int get—hangedEquipmentId() {
		return ÒhangedEquipmentId;
	}

	public void set—hangedEquipmentId(int ÒhangedEquipmentId) {
		this.ÒhangedEquipmentId = ÒhangedEquipmentId;
	}

	public CommandsNames getCommand() {
		return CommandsNames.EDIT_SPORTEQUIPMENT;
	}

}
