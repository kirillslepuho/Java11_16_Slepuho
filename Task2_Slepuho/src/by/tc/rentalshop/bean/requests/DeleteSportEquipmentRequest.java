package by.tc.rentalshop.bean.requests;

import by.tc.rentalshop.bean.Request;
import by.tc.rentalshop.controller.CommandsNames;

public class DeleteSportEquipmentRequest extends Request {
	private int equipmentId;

	public int getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(int equipmentId) {
		this.equipmentId = equipmentId;
	}

	public CommandsNames getCommand() {
		return CommandsNames.DELETE_SPORTEQUIPMENT;
	}

}
