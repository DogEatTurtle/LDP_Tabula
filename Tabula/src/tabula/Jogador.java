/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tabula;

import java.awt.Container;
import java.awt.GridLayout;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JButton;
import javax.swing.JTextArea;

/**
 *
 * @author Bruno
 */

public class Jogador extends Application{
    
    private ClientSideConnection csc;
    private int playerID;
    private int otherPlayer;

    private static String serverIP = "127.0.0.1";
    private static final int serverPort = 6666;
    static DataInputStream in;
    static DataOutputStream out;
    static ObjectOutputStream objOut;
    static ObjectInputStream inObj;
    static String minhavez;
    private Tabula jogoInstancia;
    static boolean comecar;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXML.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
        connectClient();
    }

    public void connectToServer() {
        csc = new ClientSideConnection();
        System.out.println("conecta");
    }

    //Client Connection Inner Class
    private class ClientSideConnection {

        private Socket socket;
        private DataInputStream dataIn;
        private DataOutputStream dataOut;

        public ClientSideConnection() {
            System.out.println("---Client---");
            try {
                socket = new Socket("localhost", 51734);
                dataIn = new DataInputStream(socket.getInputStream());
                dataOut = new DataOutputStream(socket.getOutputStream());
                playerID = dataIn.readInt();

                System.out.println("Connected to Server as Player #" + playerID + ".");

            } catch (IOException ex) {
                System.out.println("IOException from Client Side Connection Constructor");
            }
        }

    }

    public static void main(String[] args) {
        try {
            launch(args);
            System.out.println("Adeus");
            out.writeUTF("#logout");
            System.exit(0);
        } catch (IOException ex) {
        }
    }


    private void connectClient() throws IOException {

        Socket socket = new Socket(serverIP, serverPort);

        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());

        objOut = new ObjectOutputStream(socket.getOutputStream());

        inObj = new ObjectInputStream(socket.getInputStream());
        jogoInstancia = new Tabula(objOut);

        String nomeJogadorserver = in.readUTF();
        System.out.println(nomeJogadorserver);
        String[] parts = nomeJogadorserver.split("\\s+");
        String numberString = parts[1];

        // Convert the number string to an int
        int id = Integer.parseInt(numberString);
        System.out.println(id);

        jogoInstancia.pecasIndicativo(id);
        // Print the number
        System.out.println("Number: " + id);
        comecar = true;
        // Thread que serve para o cliente envia mensagens para o servidor
        Thread enviarMensagem;
        enviarMensagem = new Thread(() -> {
            if (comecar) {
                try {
                    out.writeUTF("#nome");
                    comecar = false;
                } catch (IOException ex) {
                    Logger.getLogger(Jogador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            FXMLController.lancardadosEstatico.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {

                    try {
                        int[] dados = new int[3];

                        dados = jogoInstancia.geraDado();
                        jogoInstancia.lancouDados();
                        System.out.println(nomeJogadorserver);
                        out.writeUTF("#dados" + "-" + dados[0] + "-" + dados[1] + "-" + dados[2]);

                    } catch (IOException ex) {
                        System.out.println("IOException from click button");
                    }
                }
            });

            FXMLController.jogadaEstatico.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {

                    try {

                        out.writeUTF("#vez"); 
                        System.out.println("qwedfrtyukil");
                    } catch (IOException ex) {
                        Logger.getLogger(Jogador.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

            });

            FXMLController.jogarEstatico.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {

                    try {
                        String peca = FXMLController.pecaidEstatico.getText();
                        String moverr = FXMLController.posicaoidEstatico.getText();
                        int mover = Integer.parseInt(moverr);
                        if (mover <= 12) {
                            //verificar se pode mover a casa
                            if (mover == Integer.parseInt(FXMLController.text1Estatico.getText())) {
                                out.writeUTF("#jogada" + "-" + peca + "-" + mover + "-" + id); 
                            } else if (mover == Integer.parseInt(FXMLController.text2Estatico.getText())) {
                                out.writeUTF("#jogada" + "-" + peca + "-" + mover + "-" + id); 
                            } else if (mover == Integer.parseInt(FXMLController.text3Estatico.getText())) {
                                out.writeUTF("#jogada" + "-" + peca + "-" + mover + "-" + id); 
                            } else if (mover == (Integer.parseInt(FXMLController.text1Estatico.getText()) + Integer.parseInt(FXMLController.text2Estatico.getText()))) {
                                out.writeUTF("#jogada" + "-" + peca + "-" + mover + "-" + id); 
                            } else if (mover == (Integer.parseInt(FXMLController.text1Estatico.getText()) + Integer.parseInt(FXMLController.text3Estatico.getText()))) {
                                out.writeUTF("#jogada" + "-" + peca + "-" + mover + "-" + id); 
                            } else if (mover == (Integer.parseInt(FXMLController.text2Estatico.getText()) + Integer.parseInt(FXMLController.text3Estatico.getText()))) {
                                out.writeUTF("#jogada" + "-" + peca + "-" + mover + "-" + id); 
                            } else if (mover == (Integer.parseInt(FXMLController.text1Estatico.getText()) + Integer.parseInt(FXMLController.text2Estatico.getText()) + Integer.parseInt(FXMLController.text3Estatico.getText()))) {
                                out.writeUTF("#jogada" + "-" + peca + "-" + mover + "-" + id); 
                            }

                        }

                        if (jogoInstancia.ganhou) {

                        }

                    } catch (IOException ex) {
                        Logger.getLogger(Jogador.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

            });

        });

        Thread lerMensagem;
        lerMensagem = new Thread(() -> {
            while (true) {

                //
                try {

                    //usar este sistema para comunicar com o jogo
                    String msg = in.readUTF();
                    System.out.println(msg);

                    if (msg.startsWith("#dados")) {
                        String[] msgSplit = msg.split("-");
                        int dado1 = Integer.parseInt(msgSplit[1]);
                        int dado2 = Integer.parseInt(msgSplit[2]);
                        int dado3 = Integer.parseInt(msgSplit[3]);

                        jogoInstancia.displayDados(dado1, dado2, dado3);
                    } else if (msg.startsWith("#vez")) {

                        jogoInstancia.mudaVez();

                    } else if (msg.startsWith("#nome")) {

                        String[] msgSplit = msg.split("-");
                        boolean vez = Boolean.parseBoolean(msgSplit[1]);
                        jogoInstancia.iniciaJogo(vez);
                        System.out.println("fsadfsdf: " + msg);

                    } else if (msg.startsWith("#jogada")) {
                        String[] msgSplit = msg.split("-");
                        String peca = msgSplit[1];
                        int mover = Integer.parseInt(msgSplit[2]);
                        int posicao = Integer.parseInt(msgSplit[3]);
                        int atacada = Integer.parseInt(msgSplit[4]);
                        boolean podeMover2Etapa = Boolean.parseBoolean(msgSplit[5]);

                        if (posicao <= 12) {

                            if (mover <= 12) {

                                //verificar se pode mover a casa
                                if (mover == Integer.parseInt(FXMLController.text1Estatico.getText())) {
                                    FXMLController.text1Estatico.setText("0");
                                    jogoInstancia.movePeca(peca, posicao, atacada);
                                } else if (mover == Integer.parseInt(FXMLController.text2Estatico.getText())) {
                                    FXMLController.text2Estatico.setText("0");
                                    jogoInstancia.movePeca(peca, posicao, atacada);
                                } else if (mover == Integer.parseInt(FXMLController.text3Estatico.getText())) {
                                    FXMLController.text3Estatico.setText("0");
                                    jogoInstancia.movePeca(peca, posicao, atacada);
                                } else if (mover == (Integer.parseInt(FXMLController.text1Estatico.getText()) + Integer.parseInt(FXMLController.text2Estatico.getText()))) {
                                    FXMLController.text1Estatico.setText("0");
                                    FXMLController.text2Estatico.setText("0");
                                    jogoInstancia.movePeca(peca, posicao, atacada);
                                } else if (mover == (Integer.parseInt(FXMLController.text1Estatico.getText()) + Integer.parseInt(FXMLController.text3Estatico.getText()))) {
                                    FXMLController.text1Estatico.setText("0");
                                    FXMLController.text3Estatico.setText("0");
                                    jogoInstancia.movePeca(peca, posicao, atacada);
                                } else if (mover == (Integer.parseInt(FXMLController.text2Estatico.getText()) + Integer.parseInt(FXMLController.text3Estatico.getText()))) {
                                    FXMLController.text2Estatico.setText("0");
                                    FXMLController.text3Estatico.setText("0");
                                    jogoInstancia.movePeca(peca, posicao, atacada);
                                } else if (mover == (Integer.parseInt(FXMLController.text1Estatico.getText()) + Integer.parseInt(FXMLController.text2Estatico.getText()) + Integer.parseInt(FXMLController.text3Estatico.getText()))) {
                                    FXMLController.text1Estatico.setText("0");
                                    FXMLController.text2Estatico.setText("0");
                                    FXMLController.text3Estatico.setText("0");
                                    jogoInstancia.movePeca(peca, posicao, atacada);
                                }
                            }
                        } else {
                            if (podeMover2Etapa) {
                                //verificar se pode mover a casa
                                if (mover == Integer.parseInt(FXMLController.text1Estatico.getText())) {
                                    FXMLController.text1Estatico.setText("0");
                                    jogoInstancia.movePeca(peca, posicao, atacada);

                                } else if (mover == Integer.parseInt(FXMLController.text2Estatico.getText())) {
                                    FXMLController.text2Estatico.setText("0");
                                    jogoInstancia.movePeca(peca, posicao, atacada);
                                } else if (mover == Integer.parseInt(FXMLController.text3Estatico.getText())) {
                                    FXMLController.text3Estatico.setText("0");
                                    jogoInstancia.movePeca(peca, posicao, atacada);
                                } else if (mover == (Integer.parseInt(FXMLController.text1Estatico.getText()) + Integer.parseInt(FXMLController.text2Estatico.getText()))) {
                                    FXMLController.text1Estatico.setText("0");
                                    FXMLController.text2Estatico.setText("0");
                                    jogoInstancia.movePeca(peca, posicao, atacada);
                                } else if (mover == (Integer.parseInt(FXMLController.text1Estatico.getText()) + Integer.parseInt(FXMLController.text3Estatico.getText()))) {
                                    FXMLController.text1Estatico.setText("0");
                                    FXMLController.text3Estatico.setText("0");
                                    jogoInstancia.movePeca(peca, posicao, atacada);
                                } else if (mover == (Integer.parseInt(FXMLController.text2Estatico.getText()) + Integer.parseInt(FXMLController.text3Estatico.getText()))) {
                                    FXMLController.text2Estatico.setText("0");
                                    FXMLController.text3Estatico.setText("0");
                                    jogoInstancia.movePeca(peca, posicao, atacada);
                                } else if (mover == (Integer.parseInt(FXMLController.text1Estatico.getText()) + Integer.parseInt(FXMLController.text2Estatico.getText()) + Integer.parseInt(FXMLController.text3Estatico.getText()))) {
                                    FXMLController.text1Estatico.setText("0");
                                    FXMLController.text2Estatico.setText("0");
                                    FXMLController.text3Estatico.setText("0");
                                    jogoInstancia.movePeca(peca, posicao, atacada);
                                }
                            }
                        }
                    } else if (msg.startsWith("#retirarpeca")) {
                        String[] msgSplit = msg.split("-");
                        String peca = msgSplit[1];
                        int mover = Integer.parseInt(msgSplit[2]);
                        if (mover <= 12) {

                            //verificar se pode mover a casa
                                //Dado 1
                            if (mover == Integer.parseInt(FXMLController.text1Estatico.getText())) {
                                FXMLController.text1Estatico.setText("0");
                                jogoInstancia.retiraPeca(peca);

                                //Dado 2
                            } else if (mover == Integer.parseInt(FXMLController.text2Estatico.getText())) {
                                FXMLController.text2Estatico.setText("0");
                                jogoInstancia.retiraPeca(peca);
                                
                                //Dado 3
                            } else if (mover == Integer.parseInt(FXMLController.text3Estatico.getText())) {
                                FXMLController.text3Estatico.setText("0");
                                jogoInstancia.retiraPeca(peca);
                                
                                //Soma do dado 1 com o dado 2
                            } else if (mover == (Integer.parseInt(FXMLController.text1Estatico.getText()) + Integer.parseInt(FXMLController.text2Estatico.getText()))) {
                                FXMLController.text1Estatico.setText("0");
                                FXMLController.text2Estatico.setText("0");
                                jogoInstancia.retiraPeca(peca);
                                
                                //Soma do dado 1 com o dado 3
                            } else if (mover == (Integer.parseInt(FXMLController.text1Estatico.getText()) + Integer.parseInt(FXMLController.text3Estatico.getText()))) {
                                FXMLController.text1Estatico.setText("0");
                                FXMLController.text3Estatico.setText("0");
                                jogoInstancia.retiraPeca(peca);
                                
                                //Soma do dado 2 com o dado 3
                            } else if (mover == (Integer.parseInt(FXMLController.text2Estatico.getText()) + Integer.parseInt(FXMLController.text3Estatico.getText()))) {
                                FXMLController.text2Estatico.setText("0");
                                FXMLController.text3Estatico.setText("0");
                                jogoInstancia.retiraPeca(peca);
                                
                                //Soma dos 3 dados
                            } else if (mover == (Integer.parseInt(FXMLController.text1Estatico.getText()) + Integer.parseInt(FXMLController.text2Estatico.getText()) + Integer.parseInt(FXMLController.text3Estatico.getText()))) {
                                FXMLController.text1Estatico.setText("0");
                                FXMLController.text2Estatico.setText("0");
                                FXMLController.text3Estatico.setText("0");
                                jogoInstancia.retiraPeca(peca);
                            }

                        }
                        
                        // Quem ganhou / Fim de jogo / Desativar tudo
                    } else if (msg.startsWith("#ganhou")) {
                        String[] msgSplit = msg.split("-");
                        int playerWinner = Integer.parseInt(msgSplit[1]);
                        int playerLoser = Integer.parseInt(msgSplit[2]);

                        if (playerWinner == id) {
                            FXMLController.player1LabelEstatico.setVisible(true);
                            FXMLController.jogadaEstatico.setDisable(true);
                            FXMLController.lancardadosEstatico.setDisable(true);
                            FXMLController.jogarEstatico.setDisable(true);
                            FXMLController.pecaidEstatico.setDisable(true);
                            FXMLController.posicaoidEstatico.setDisable(true);
                        }

                        if (playerLoser == id) {
                            FXMLController.player2LabelEstatico.setVisible(true);
                            FXMLController.jogadaEstatico.setDisable(true);
                            FXMLController.lancardadosEstatico.setDisable(true);
                            FXMLController.jogarEstatico.setDisable(true);
                            FXMLController.pecaidEstatico.setDisable(true);
                            FXMLController.posicaoidEstatico.setDisable(true);
                        }
                    }

                } catch (IOException e) {

                }
            }
        });
        lerMensagem.start();
        enviarMensagem.start();

    }
}