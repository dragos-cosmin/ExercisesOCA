package org.example.designPatterns.singleton;

/**
 * @author dragos.cosmin
 **/
public class Main {
    public static void main(String[] args) {
        PeerSingleton peerList1=PeerSingleton.getInstance();
        PeerSingleton peerList2=PeerSingleton.getInstance();

        for (String hostName :
                peerList1.getHostNames()) {
            System.out.println("Host name: "+hostName);
        }
        System.out.println();

        for (String hostName :
                peerList2.getHostNames()) {
            System.out.println("Host name: "+hostName);
        }
    }
}
