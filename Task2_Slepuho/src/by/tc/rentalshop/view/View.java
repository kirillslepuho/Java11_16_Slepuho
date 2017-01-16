package by.tc.rentalshop.view;

import java.util.Scanner;

import by.tc.rentalshop.bean.Request;
import by.tc.rentalshop.bean.Response;
import by.tc.rentalshop.bean.requests.AddSportEquipmentRequest;
import by.tc.rentalshop.bean.requests.DeleteSportEquipmentRequest;
import by.tc.rentalshop.bean.requests.DeleteUserRequest;
import by.tc.rentalshop.bean.requests.EditSportEquipmentRequest;
import by.tc.rentalshop.bean.requests.EditUserRequest;
import by.tc.rentalshop.bean.requests.RegistrationRequest;
import by.tc.rentalshop.bean.requests.RentEquipmentRequest;
import by.tc.rentalshop.bean.requests.ReturnEquipmentRequest;
import by.tc.rentalshop.bean.requests.SignInRequest;
import by.tc.rentalshop.controller.Controller;

public class View {
	private static final int ADD_EQUIPMENT = 1;
	private static final int DELETE_EQUIPMENT = 2;
	private static final int EDIT_EQUIPMENT = 3;
	private static final int REGISTRATION = 4;
	private static final int EDIT_USER = 5;
	private static final int DELETE_USER = 6;
	private static final int SIGN_IN = 7;
	private static final int RENT_EQUIPMENT = 8;
	private static final int RETURN_EQUIPMENT = 9;

	private static Controller controller;
	private static Scanner input;

	public static void main(String[] args) {
		controller = new Controller();
		printCommands();
		input = new Scanner(System.in);
		int numberCommand = Integer.parseInt(input.next());
		while (numberCommand != 0) {
			Request request = getRequest(numberCommand);
			if (request != null) {
				Response response = controller.executeTask(request);
				handleResponse(response);
			}
			printCommands();
			numberCommand = Integer.parseInt(input.next());
		}
	}

	private static void handleResponse(Response response) {
		if (response.isErrorStatus()) {
			System.out.println(response.getErrorMessage());
		} else {
			System.out.println(response.getMessage());
		}
	}

	private static String getString(String text) {
		String result;
		System.out.println(text);
		result = input.next();
		return result;
	}

	private static Request getRequest(int numberCommand) {
		Request result;
		switch (numberCommand) {
		case ADD_EQUIPMENT:
			result = new AddSportEquipmentRequest();
			fillAddEquipmentRequest((AddSportEquipmentRequest) result);
			break;
		case DELETE_EQUIPMENT:
			result = new DeleteSportEquipmentRequest();
			fillDeleteEquipmentRequest((DeleteSportEquipmentRequest) result);
			break;
		case EDIT_EQUIPMENT:
			result = new EditSportEquipmentRequest();
			fillEditEquipmentRequest((EditSportEquipmentRequest) result);
			break;
		case REGISTRATION:
			result = new RegistrationRequest();
			fillRegistration((RegistrationRequest) result);
			break;
		case EDIT_USER:
			result = new EditUserRequest();
			fillEditUser((EditUserRequest) result);
			break;
		case DELETE_USER:
			result = new DeleteUserRequest();
			fillDeleteUser((DeleteUserRequest) result);
			break;
		case SIGN_IN:
			result = new SignInRequest();
			fillSignIn((SignInRequest) result);
			break;
		case RENT_EQUIPMENT:
			result = new RentEquipmentRequest();
			fillRentEquipment((RentEquipmentRequest) result);
			break;
		case RETURN_EQUIPMENT:
			result = new ReturnEquipmentRequest();
			fillReturnEquipment((ReturnEquipmentRequest) result);
			break;
		default:
			result = null;
			break;
		}
		return result;
	}

	private static void printCommands() {
		System.out.println("Enter 1 - to add equipment");
		System.out.println("Enter 2 - to delete equipment");
		System.out.println("Enter 3 - to change equipment");
		System.out.println("Enter 4 - to register user");
		System.out.println("Enter 5 - to edit user");
		System.out.println("Enter 6 - to delete user");
		System.out.println("Enter 7 - to sign in");
		System.out.println("Enter 8 - to rent equipment");
		System.out.println("Enter 9 - to return equipment");
		System.out.println("Enter 0 - to exit");
	}

	// Çàïîëíåíèå çàïðîñîâ
	private static void fillAddEquipmentRequest(AddSportEquipmentRequest addSportEquipmentRequest) {
		String temp;

		temp = getString("Fill title");
		addSportEquipmentRequest.setTitle(temp);

		temp = getString("Fill category name");
		addSportEquipmentRequest.setCategory(temp);

		temp = getString("Fill firm");
		addSportEquipmentRequest.setFirm(temp);

		temp = getString("Fill price");
		addSportEquipmentRequest.setPrice(Integer.parseInt(temp));

	}

	private static void fillDeleteEquipmentRequest(DeleteSportEquipmentRequest deleteSportEquipmentRequest) {
		String temp;

		temp = getString("Fill equipmentId");
		deleteSportEquipmentRequest.setEquipmentId(Integer.parseInt(temp));

	}

	private static void fillEditEquipmentRequest(EditSportEquipmentRequest editSportEquipmentRequest) {
		String temp;

		temp = getString("Fill title");
		editSportEquipmentRequest.setÑhangedEquipmentId(Integer.parseInt(temp));

		temp = getString("Fill new title");
		editSportEquipmentRequest.setTitle(temp);

		temp = getString("Fill new category name");
		editSportEquipmentRequest.setCategory(temp);

		temp = getString("Fill new firm");
		editSportEquipmentRequest.setFirm(temp);

		temp = getString("Fill new price");
		editSportEquipmentRequest.setPrice(Integer.parseInt(temp));

	}

	private static void fillRegistration(RegistrationRequest registrationRequest) {
		String temp;

		temp = getString("Fill name");
		registrationRequest.setName(temp);

		temp = getString("Fill email");
		registrationRequest.setEmail(temp);

		temp = getString("Fill password");
		registrationRequest.setPassword(temp);

		temp = getString("Fill phone");
		registrationRequest.setPhone(Integer.parseInt(temp));

	}

	private static void fillEditUser(EditUserRequest editUserRequest) {
		String temp;

		temp = getString("Fill old email");
		editUserRequest.setChangedUserEmail(temp);

		temp = getString("Fill new name");
		editUserRequest.setName(temp);

		temp = getString("Fill new email");
		editUserRequest.setEmail(temp);

		temp = getString("Fill new password");
		editUserRequest.setPassword(temp);

		temp = getString("Fill new phone");
		editUserRequest.setPhone(Integer.parseInt(temp));

	}

	private static void fillDeleteUser(DeleteUserRequest deleteUserRequest) {
		String temp;

		temp = getString("Fill email");
		deleteUserRequest.setEmail(temp);

	}

	private static void fillSignIn(SignInRequest signInRequest) {
		String temp;

		temp = getString("Fill your email");
		signInRequest.setEmail(temp);

		temp = getString("Fill your password");
		signInRequest.setPassword(temp);

	}

	private static void fillRentEquipment(RentEquipmentRequest rentEquipmentRequest) {
		String temp;

		temp = getString("Fill your email");
		rentEquipmentRequest.setEmail(temp);

		temp = getString("Fill equipment");
		rentEquipmentRequest.setTitle(temp);

	}

	private static void fillReturnEquipment(ReturnEquipmentRequest returnEquipmentRequest) {
		String temp;

		temp = getString("Fill your order number");
		returnEquipmentRequest.setRent_id(Integer.parseInt(temp));

	}

}
