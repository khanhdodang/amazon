package objects;

public class Account {
    String email;
    String phoneno;
    String password;
    boolean keepMeSignIn;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isKeepMeSignIn() {
        return keepMeSignIn;
    }

    public void setKeepMeSignIn(boolean keepMeSignIn) {
        this.keepMeSignIn = keepMeSignIn;
    }

}
