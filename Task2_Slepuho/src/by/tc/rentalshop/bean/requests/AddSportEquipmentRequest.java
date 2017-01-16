package by.tc.rentalshop.bean.requests;

import by.tc.rentalshop.bean.Request;
import by.tc.rentalshop.controller.CommandsNames;

public class AddSportEquipmentRequest extends Request {

	private String title;
	private String firm;
	private int price;
	private String category;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFirm() {
		return firm;
	}

	public void setFirm(String firm) {
		this.firm = firm;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public CommandsNames getCommand() {
		return CommandsNames.ADD_SPORTEQUIPMENT;
	}

}
