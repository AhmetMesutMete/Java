
import gui.TwitterApp;
import network.Client;
import network.ServerBroadcast;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        TwitterApp twitterApp = new TwitterApp();

        ServerBroadcast serv = new ServerBroadcast();
        Client Client1 = new Client();
        Client Client2 = new Client();
        Client Client3 = new Client();
        Client Client4 = new Client();
        Client Client5 = new Client();


        while(true){

            Scanner scanner = new Scanner(System.in);
            System.out.println("Which client will send message (select: 1,2,3,4,5)");
            int s = scanner.nextInt();
            if(s == 1){
                Client1.Process();
            }else if(s == 2){
                Client2.Process();
            }else if(s == 3){
                Client3.Process();
            }else if(s == 4){
                Client4.Process();
            }else if(s == 5){
                Client5.Process();
            }

        }

    }

}

