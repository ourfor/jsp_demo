package user;

public class Client {
    public static void main(String args[]){
        ConnectDBSingleton test = ConnectDBSingleton.getIns();
        test.Connect();
        ConnectDBSingleton test2 = ConnectDBSingleton.getIns();
        if(test==test2) System.out.println("单例模式");
    }
}
