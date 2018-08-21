package controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.control.cell.TextFieldTreeCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.Person;

public class MainWindowController {

	private Main main;
	private Stage primaryStage;

	@FXML
	private TableView<Person> tableView;

	@FXML
	private TableColumn<Person, String> firstNameColumn;

	@FXML
	private TableColumn<Person, String> lastNameColumn;

	@FXML
	private TableColumn<Person, String> roomNrColumn;

	private ObservableList<Person> personList = FXCollections.observableArrayList();

	@FXML
	private TextField firstNameTF;
	@FXML
	private TextField lastNameTF;
	@FXML
	private TextField roomNrTF;
	@FXML
	private TextField inHourTF;
	@FXML
	private TextField outHourTF;

	@FXML
	private Label pok1LB;

	@FXML
	private Label pok2LB;

	@FXML
	private Label pok3LB;

	@FXML
	private Label pok4LB;

	@FXML
	private Label pok5LB;

	@FXML
	private void loadFromFile() {

		Scanner in = null;

		String firstName;

		String lastName;
		String roomNr;
		String inHour;
		String outHour;

		try {

			in = new Scanner(Paths.get("C:\\Users\\Micha³ Lenar\\workspace\\HomeProject1\\controller\\FileIn.txt"));

			while (in.hasNext()) {

				firstName = in.next();
				lastName = in.next();
				roomNr = in.next();
				inHour = in.next();
				outHour = in.next();
				personList.add(new Person(firstName, lastName, roomNr, inHour, outHour));
				

			}
			
		}

		catch (IOException e) {
			e.printStackTrace();

		} finally {

			if (in != null)
				in.close();

		}

	}

	@FXML
	private void saveToFile() {

		PrintWriter out = null;

		try {
			out = new PrintWriter("C:\\Users\\Micha³ Lenar\\workspace\\HomeProject1\\controller\\FileIn.txt");

			for (int i = 0; i < personList.size(); i++) {

				out.printf("%s %s %s %s %s \n", personList.get(i).getFirstName(), personList.get(i).getLastName(),
						personList.get(i).getRoomNr(), personList.get(i).getInHour(), personList.get(i).getOutHour());

			}
		}

		catch (IOException e) {
			e.printStackTrace();

		} finally {

			if (out != null)
				out.close();

		}

	}

	@FXML
	private void addRecordToTable() {

		Person person = new Person();

		person.setFirstName(firstNameTF.getText());
		person.setLastName(lastNameTF.getText());
		person.setRoomNr(roomNrTF.getText());
		person.setInHour(inHourTF.getText());
		person.setOutHour(outHourTF.getText());

		tableView.getItems().add(person);

		firstNameTF.clear();
		lastNameTF.clear();
		roomNrTF.clear();
		inHourTF.clear();
		outHourTF.clear();

	}

	@FXML
	private void generateRaport() {

		PrintWriter out = null;

		Collections.sort(personList, new Komparator());

		try {
			out = new PrintWriter("C:\\Users\\Micha³ Lenar\\workspace\\HomeProject1\\controller\\FileOut.txt");

			for (int i = 0; i < personList.size(); i++) {

				out.printf("%s %s %s %s %s \n", personList.get(i).getFirstName(), personList.get(i).getLastName(),
						personList.get(i).getRoomNr(), personList.get(i).getInHour(), personList.get(i).getOutHour());

			}
		}

		catch (IOException e) {
			e.printStackTrace();

		} finally {

			if (out != null)
				out.close();

		}

	}

	public void setMain(Main main, Stage primaryStage) {

		this.main = main;
		this.primaryStage = primaryStage;

		tableView.setItems(personList);

	}

	@FXML
	public void changeFirstNameCellEvent(CellEditEvent edditedCell) {

		Person personSelected = tableView.getSelectionModel().getSelectedItem();
		personSelected.setFirstName(edditedCell.getNewValue().toString());

	}

	@FXML
	public void changeLastNameCellEvent(CellEditEvent edditedCell) {

		Person personSelected = tableView.getSelectionModel().getSelectedItem();
		personSelected.setLastName(edditedCell.getNewValue().toString());

	}

	@FXML
	public void changeRoomNrCellEvent(CellEditEvent edditedCell) {

		Person personSelected = tableView.getSelectionModel().getSelectedItem();
		personSelected.setRoomNr(edditedCell.getNewValue().toString());

	}

	public void initialize() {

		firstNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
		lastNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
		roomNrColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("roomNr"));

		tableView.setEditable(true);
		firstNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		lastNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		roomNrColumn.setCellFactory(TextFieldTableCell.forTableColumn());

		tableView.getSelectionModel().selectedItemProperty().addListener(

				(ov, oldVal, newVal) -> {

					firstNameTF.setText(newVal.getFirstName());
					lastNameTF.setText(newVal.getLastName());
					roomNrTF.setText(newVal.getRoomNr());
					inHourTF.setText(newVal.getInHour());
					outHourTF.setText(newVal.getOutHour());

					if (Integer.parseInt(newVal.getRoomNr()) == 1) {

						pok1LB.setText("X");
						pok2LB.setText("");
						pok3LB.setText("");
						pok4LB.setText("");
						pok5LB.setText("");

					}

					if (Integer.parseInt(newVal.getRoomNr()) == 2) {

						pok2LB.setText("X");
						pok1LB.setText("");
						pok3LB.setText("");
						pok4LB.setText("");
						pok5LB.setText("");

					}
					if (Integer.parseInt(newVal.getRoomNr()) == 3) {

						pok3LB.setText("X");
						pok2LB.setText("");
						pok1LB.setText("");
						pok4LB.setText("");
						pok5LB.setText("");
					}
					if (Integer.parseInt(newVal.getRoomNr()) == 4) {

						pok4LB.setText("X");
						pok2LB.setText("");
						pok3LB.setText("");
						pok1LB.setText("");
						pok5LB.setText("");
					}
					if (Integer.parseInt(newVal.getRoomNr()) == 5) {

						pok5LB.setText("X");
						pok2LB.setText("");
						pok3LB.setText("");
						pok4LB.setText("");
						pok1LB.setText("");
					}

				});

	}

}
