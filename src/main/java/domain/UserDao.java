package domain;

public class UserDao {
    private UserTest userTest;

    public void setUserTest(UserTest userTest) {
        this.userTest = userTest;
    }

    @Override
    public String toString() {
        return "UserDao{" +
                "userTest=" + userTest +
                '}';
    }
}
