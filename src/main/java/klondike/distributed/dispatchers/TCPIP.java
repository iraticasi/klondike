package klondike.distributed.dispatchers;

import klondike.models.Card;
import klondike.models.Error;
import klondike.models.Number;
import klondike.models.Suit;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPIP extends klondike.utils.TCPIP{

    private static final int PORT = 2020;

    public static TCPIP createClientSocket() {
        try {
            Socket socket = new Socket("localhost", TCPIP.PORT);
            System.out.println("Cliente> Establecida conexion");
            return new TCPIP(socket);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static TCPIP createServerSocket() {
        try {
            ServerSocket serverSocket = new ServerSocket(TCPIP.PORT);
            System.out.println("Servidor> Esperando conexion...");
            Socket socket = serverSocket.accept();
            System.out.println("Servidor> Recibida conexion de " + socket.getInetAddress().getHostAddress() + ":"
                    + socket.getPort());
            return new TCPIP(serverSocket, socket);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    public TCPIP(Socket socket) {
        super(socket);
    }

    public TCPIP(ServerSocket serverSocket, Socket socket) {
        super(serverSocket, socket);
    }

    public void send(Error error) {
        if (error == null) {
            this.send("null");
        }else {
            this.send(error.name());
        }
    }

    public Error receiveError() {
        String error = this.receiveLine();
        if (error.equals("null")) {
            return null;
        }
        return Error.valueOf(error);
    }

    public void send(Suit suit) {
        if (suit == null) {
            this.send("null");
        }else {
            this.send(suit.name());
        }
    }

    public Number receiveNumber() {
        String number = this.receiveLine();
        if (number.equals("null")) {
            return null;
        }
        return Number.valueOf(number);
    }

    public void send(Number number) {
        if (number == null) {
            this.send("null");
        }else {
            this.send(number.name());
        }
    }

    public Suit receiveSuit() {
        String suit = this.receiveLine();
        if (suit.equals("null")) {
            return null;
        }
        return Suit.valueOf(suit);
    }

    public void send(Card card) {
        if (card == null) {
            this.send("null");
        }else {
            this.send(card.getSuit());
            this.send(card.getNumber());
            this.send(card.isFacedUp());
        }
    }

    public Card receiveCard() {
        Suit suit = this.receiveSuit();
        if (suit==null) {
            return null;
        }
        Number number= this.receiveNumber();
        boolean facedUp = this.receiveBoolean();
        return new Card(suit,number,facedUp);
    }
}
