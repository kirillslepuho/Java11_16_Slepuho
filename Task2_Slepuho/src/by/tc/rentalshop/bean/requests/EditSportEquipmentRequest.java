package by.tc.rentalshop.bean.requests;

import by.tc.rentalshop.controller.CommandsNames;

public class EditSportEquipmentRequest extends AddSportEquipmentRequest {
	private int �hangedEquipmentId;

	public int get�hangedEquipmentId() {
		return �hangedEquipmentId;
	}

	public void set�hangedEquipmentId(int �hangedEquipmentId) {
		this.�hangedEquipmentId = �hangedEquipmentId;
	}

	public CommandsNames getCommand() {
		return CommandsNames.EDIT_SPORTEQUIPMENT;
	}

}
