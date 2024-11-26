package CarRentalSystem;

public class User{
    int userId;
    String userName;
    String drivingLicence;

    public String getDrivingLicence() {
        return drivingLicence;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setDrivingLicence(String drivingLicence) {
        this.drivingLicence = drivingLicence;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
}