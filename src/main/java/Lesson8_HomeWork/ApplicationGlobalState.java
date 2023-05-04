package Lesson8_HomeWork;

public class ApplicationGlobalState {
    private static ApplicationGlobalState INSTANCE;
    private String selectedCity = null;
    private final String API_KEY = "1Pu57qZ5H2PpiDwqf8HqEiUSsth5VRhU";
    private final String DB_FILENAME = "TEST.db";


    public static ApplicationGlobalState getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new ApplicationGlobalState();
        }

        return INSTANCE;
    }

    public String getDbFileName() {
        return DB_FILENAME;
    }

    public String getSelectedCity(String city) {
        return selectedCity;
    }

    public void setSelectedCity(String selectedCity) {
        this.selectedCity = selectedCity;
    }

    public String getApiKey() {
        return this.API_KEY;
    }

}
