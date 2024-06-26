package seedu.address.ui;

import java.util.Comparator;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.person.Person;

/**
 * An UI component that displays information of a {@code Person}.
 */
public class PersonCard extends UiPart<Region> {

    private static final String FXML = "PersonListCard.fxml";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on AddressBook level 4</a>
     */

    public final Person person;

    @FXML
    private HBox cardPane;
    @FXML
    private Label nric;
    @FXML
    private Label name;
    @FXML
    private Label gender;
    @FXML
    private Label birthDate;
    @FXML
    private Label id;
    @FXML
    private Label phone;
    @FXML
    private Label email;
    @FXML
    private Label drugAllergy;
    @FXML
    private FlowPane illnesses;

    /**
     * Creates a {@code PersonCode} with the given {@code Person} and index to display.
     */
    public PersonCard(Person person, int displayedIndex) {
        super(FXML);

        illnesses.setVgap(5);
        illnesses.setHgap(5);
        String illnessLabelStyle = "-fx-background-color: #d4c262;"
                + "-fx-background-radius: 20;"
                + "-fx-label-padding: 5;"
                + "-fx-text-fill: #000;"
                + "-fx-font-size: 13px";

        this.person = person;
        id.setText(displayedIndex + ". ");
        nric.setText(person.getNric().nric);
        name.setText(person.getName().fullName);
        gender.setText("Gender: " + person.getGender().gender);
        birthDate.setText("Birth Date: " + person.getBirthDate() + " (" + person.getAge() + " yrs)");
        phone.setText("Phone Number: " + person.getPhone().value);
        email.setText("Email: " + person.getEmail().value);
        drugAllergy.setText("Drug Allergies: " + person.getDrugAllergy().drugAllergy);
        person.getIllnesses().stream()
                .sorted(Comparator.comparing(illness -> illness.illnessName))
                .forEach(illness -> {
                    Label illnessLabel = new Label(illness.illnessName);
                    illnessLabel.setStyle(illnessLabelStyle);
                    illnesses.getChildren().add(illnessLabel);
                });
    }
}
