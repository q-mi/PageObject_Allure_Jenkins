package github.qmi.page;

import com.codeborne.selenide.SelenideElement;
import github.qmi.componentes.CalendarComponent;

import static com.codeborne.selenide.Condition.have;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class RegistrationFormPage {
    private static final String MODAL_TITLE = "Thanks for submitting the form";
    public CalendarComponent calendar = new CalendarComponent();

    private SelenideElement
            setFirstName = $("#firstName"),
            setLastName = $("#lastName"),
            setUserEmail = $("#userEmail"),
            setSubjects = $("#subjectsInput"),
            setUserNumber = $("#userNumber"),
            submitButton = $("#submit"),
            selectState = $("#react-select-3-input"),
            selectCity = $("#react-select-4-input");

    public RegistrationFormPage openPage() {
        open("https://demoqa.com/automation-practice-form");

        return this;
    }

    public RegistrationFormPage setFirstName(String firstName) {
        setFirstName.setValue(firstName);

        return this;
    }

    public RegistrationFormPage setLastName(String lastName) {
        setLastName.setValue(lastName);

        return this;
    }

    public RegistrationFormPage typeEmail(String email) {
        setUserEmail.setValue(email);

        return this;
    }

    public RegistrationFormPage selectGender(Gender gender) {
        $(gender.getSelector()).click();

        return this;
    }

    public RegistrationFormPage typeNumber(String number) {
        setUserNumber.setValue(number);

        return this;
    }

    public RegistrationFormPage typeSubjects(String subjects) {
        setSubjects.setValue(subjects).pressEnter();

        return this;
    }

    public RegistrationFormPage selectHobbies(Hobbies hobbies) {
        $(hobbies.getSelector()).click();

        return this;
    }

    public RegistrationFormPage uploadFile(String fileName) {
        $("#uploadPicture").uploadFromClasspath(fileName);
        return this;
    }

    public RegistrationFormPage typeCurrentAddress(String address) {
        $("#currentAddress").setValue(address);
        return this;
    }

    public RegistrationFormPage selectState(String state) {
        selectState.setValue(state).pressEnter();

        return this;
    }

    public RegistrationFormPage selectCity(String city) {
        selectCity.setValue(city).pressEnter();

        return this;
    }

    public RegistrationFormPage submitButton() {
        submitButton.click();
        return this;
    }

    public RegistrationFormPage checkModalForm(String label, String text) {
        $("#example-modal-sizes-title-lg").should(have(text(MODAL_TITLE)));
        $(".table-responsive").$(byText(label)).parent().shouldHave(text(text));
        return this;

    }
}

