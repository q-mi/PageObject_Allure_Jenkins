package github.qmi.page;

public enum Gender {

    MALE("[for='gender-radio-1']"),

    FEMALE("[for='gender-radio-2']"),

    OTHER("[for='gender-radio-3']");

    private String selector;

    Gender(String selector) {
        this.selector = selector;
    }

    public String getSelector() {
        return selector;
    }
}
