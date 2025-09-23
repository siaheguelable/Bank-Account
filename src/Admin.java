package src;

public class Admin {
    private String adminName;
    private String adminPassword;
    private String adminID;
    private static final String DEFAULT_ADMIN_PASSWORD = "admin123";

    public Admin(String adminName, String adminPassword, String adminID, String defaultAdminPassword) {
        this.adminName = adminName;
        this.adminPassword = adminPassword;
        this.adminID = adminID;
        // The defaultAdminPassword parameter is not used; consider removing it
        this.adminPassword = DEFAULT_ADMIN_PASSWORD; // Set to default password
    }

    public String getAdminName() {
        return adminName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public String getAdminID() {
        return adminID;
    }

    public static String getDefaultAdminPassword() {
        return DEFAULT_ADMIN_PASSWORD;
    }

}
