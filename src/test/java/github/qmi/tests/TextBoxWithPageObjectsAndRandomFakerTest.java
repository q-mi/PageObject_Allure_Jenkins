package github.qmi.tests;

import com.github.javafaker.Faker;
import github.qmi.componentes.CalendarComponent;
import github.qmi.page.Gender;
import github.qmi.page.Hobbies;
import github.qmi.page.RegistrationFormPage;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static github.qmi.page.Gender.MALE;
import static github.qmi.tests.TestData.*;

@Owner("Tsareva")
@Story("Student Registration Form")
public class TextBoxWithPageObjectsAndRandomFakerTest extends TestBase {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    private final Faker faker = new Faker(new Locale("en"));
    public CalendarComponent calendar = new CalendarComponent();

    @Test
    @DisplayName("Submit completed form")
    @Tag("NORMAL")
    void TextBoxWithPageObjectsAndRandomFakerTest() {
        String firstName = faker.name().firstName(),
                lastName = faker.name().lastName(),
                email = faker.internet().emailAddress(),
                userNumber = faker.phoneNumber().subscriberNumber(10),
                address = faker.address().streetAddress();

        registrationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .typeEmail(email)
                .selectGender(MALE)
                .typeNumber(userNumber);
        registrationFormPage.calendar.setDate(DAY, MONTH, YEAR);
        registrationFormPage.typeSubjects(SUBJECT)
                .selectHobbies(Hobbies.MUSIC)
                .uploadFile(FILE_NAME)
                .typeCurrentAddress(address)
                .selectState(STATE)
                .selectCity(CITY)
                .submitButton();

        registrationFormPage.checkModalForm("Student Name", firstName + " " + lastName)
                .checkModalForm("Student Email", email)
                .checkModalForm("Gender", Gender.MALE.name())
                .checkModalForm("Mobile", userNumber)
                .checkModalForm("Date of Birth", DAY + " " + MONTH + "," + YEAR)
                .checkModalForm("Subjects", SUBJECT)
                .checkModalForm("Hobbies", Hobbies.MUSIC.name())
                .checkModalForm("Picture", FILE_NAME)
                .checkModalForm("Address", address)
                .checkModalForm("State and City", STATE + " " + CITY);
    }
}

