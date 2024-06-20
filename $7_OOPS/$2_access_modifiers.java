package $7_OOPS;

public class $2_access_modifiers {
    public static void main(String[] args) {

        BankAccount myAcc = new BankAccount();
        myAcc.username = "mangal1720";
        myAcc.setPass("abvdtyeas");
        myAcc.getPass("mangal1720");
        
        // System.out.println(myAcc.password);
        /* This line will give error as password is defined private
        and can only be accessed in the class itself. */
    }
}

class BankAccount {
    public String username;
    private String password;
    public void setPass(String permit) {
        password = permit;
    }
    public void getPass(String selfname) {
        if (this.username == selfname) {
            System.out.println(password);
        } else {
            System.out.println("Invalid username");
        }
    }
}
