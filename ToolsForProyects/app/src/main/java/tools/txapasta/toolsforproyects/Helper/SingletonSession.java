package tools.txapasta.toolsforproyects.Helper;

/**
 * Created by txapasta on 22/01/2017.
 */

public class SingletonSession {
    private static SingletonSession instance;
    private String username;
    private String userpassword;

    //no outer class can initialize this class object
    private SingletonSession(){}

    public static SingletonSession getInstance(){
        //if no instance is initialized yet then create new instance
        //else return stored instance
        if(instance == null){
            instance = new SingletonSession();
        }
        return instance;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }
}
