package utils;

import objects.Account;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Utils {

    static InputStream inputStream;
    public static Account getAccount() {
        Account account = new Account();
        try {
            Properties prop = new Properties();
            String propFileName = "config.properties";
            inputStream = Utils.class.getClassLoader().getResourceAsStream(propFileName);
            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("Property file '" + propFileName + "' is not found in the classpath");
            }
            String email = prop.getProperty("email");
            String password = prop.getProperty("password");
            String keepMeSignIn = prop.getProperty("keepMeSignIn");
            account.setEmail(email);
            account.setPassword(password);
            account.setKeepMeSignIn(Boolean.valueOf(keepMeSignIn));
        }
        catch(IOException ex) { ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return account;
    }
}
