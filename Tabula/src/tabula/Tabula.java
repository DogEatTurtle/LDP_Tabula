/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package tabula;

import java.io.File;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.Random;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

/**
 *
 * @author duart
 */
public class Tabula extends Application {
    
    private boolean lancouDados = false;
    private boolean podeMover = false;
    private boolean podeRetirar = false;
    Random random = new Random();
    ObjectOutputStream out;
    private boolean minhavez = true;
    boolean ganhou;

    public Tabula(ObjectOutputStream out) {
        this.out = out;

    }

    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXML.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    public void displayDados(int d1, int d2, int d3) {
        
        //Som ao lançar dados
        Media dados = new Media(getClass().getResource("lancadados.wav").toExternalForm());
        MediaPlayer dadosAudio = new MediaPlayer(dados);
        dadosAudio.play();

        FXMLController.text1Estatico.setText("" + d1);
        FXMLController.text2Estatico.setText("" + d2);
        FXMLController.text3Estatico.setText("" + d3);

    }

    public int[] geraDado() {

        int dado1;
        int dado2;
        int dado3;

        int[] dados = new int[3];

        if (!lancouDados) {
            dado1 = (int) (Math.random() * 6 + 1);
            dado2 = (int) (Math.random() * 6 + 1);
            dado3 = (int) (Math.random() * 6 + 1);
            dados[0] = dado1;
            dados[1] = dado2;
            dados[2] = dado3;
            lancouDados = true;

            return dados;
        } else {
            return dados;
        }
    }
    
    public void lancouDados() {
        FXMLController.lancardadosEstatico.setDisable(true);
    }
    
    public void iniciaJogo(boolean vez) {
        this.minhavez = vez;
         
        Platform.runLater(() -> {
            if (!this.minhavez) {
                FXMLController.jogadaEstatico.setDisable(true);
                FXMLController.lancardadosEstatico.setDisable(true);
                FXMLController.jogarEstatico.setDisable(true);
                FXMLController.pecaidEstatico.setDisable(true);
                FXMLController.posicaoidEstatico.setDisable(true);
            } else {
                FXMLController.jogadaEstatico.setDisable(false);
                FXMLController.lancardadosEstatico.setDisable(false);
                FXMLController.jogarEstatico.setDisable(false);
                FXMLController.pecaidEstatico.setDisable(false);
                FXMLController.posicaoidEstatico.setDisable(false);
            }
        });
        Platform.runLater(() -> {
            String labelText = "É a sua vez de jogar";
            if (!this.minhavez) {
                labelText = "Aguarde que o adversário jogue";
            }
            FXMLController.labelVezEstatico.setText(labelText);
        });
    }
    
    
    public void pecasIndicativo(int id) {
        if (id == 0) {
            FXMLController.indicativoPecas1Estatico.setText("AS SUAS PEÇAS");
            FXMLController.indicativoPecas2Estatico.setText("PEÇAS DO ADVERSÁRIO");
        } else {
            FXMLController.indicativoPecas2Estatico.setText("AS SUAS PEÇAS");
            FXMLController.indicativoPecas1Estatico.setText("PEÇAS DO ADVERSÁRIO");
        }
    }
    
    
    public void movePeca(String peca, int posicao, int atacada) {
        
        double targetX = 0;
        double targetY = 0;
        
        
        //Som ao mover peça
        Media movePeca = new Media(getClass().getResource("Peca.mp3").toExternalForm());
        MediaPlayer pecaAudio = new MediaPlayer(movePeca);
        pecaAudio.play();
        

        // Array para armazenar as posições estáticas
        Node[] posicoesEstaticas = {
            FXMLController.pos1Estatico,
            FXMLController.pos2Estatico,
            FXMLController.pos3Estatico,
            FXMLController.pos4Estatico,
            FXMLController.pos5Estatico,
            FXMLController.pos6Estatico,
            FXMLController.pos7Estatico,
            FXMLController.pos8Estatico,
            FXMLController.pos9Estatico,
            FXMLController.pos10Estatico,
            FXMLController.pos11Estatico,
            FXMLController.pos12Estatico,
            FXMLController.pos13Estatico,
            FXMLController.pos14Estatico,
            FXMLController.pos15Estatico,
            FXMLController.pos16Estatico,
            FXMLController.pos17Estatico,
            FXMLController.pos18Estatico,
            FXMLController.pos19Estatico,
            FXMLController.pos20Estatico,
            FXMLController.pos21Estatico,
            FXMLController.pos22Estatico,
            FXMLController.pos23Estatico,
            FXMLController.pos24Estatico
        };

        if (posicao >= 1 && posicao <= posicoesEstaticas.length) {
            Node posicaoEstatica = posicoesEstaticas[posicao - 1];
            targetX = posicaoEstatica.getLayoutX();
            targetY = posicaoEstatica.getLayoutY();
            targetX += random.nextInt(35);
            targetY += random.nextInt(200);
        } else {
            // Lidar com o caso em que uma posição inválida é fornecida
            return;
        }
    

        switch (peca) {
            case "1":
                FXMLController.p1Estatico.layoutXProperty().set(targetX);
                FXMLController.p1Estatico.layoutYProperty().set(targetY);
                targetX = FXMLController.p1Estatico.layoutXProperty().get();
                targetY = FXMLController.p1Estatico.layoutYProperty().get();
                break;

            case "2":
                FXMLController.p2Estatico.layoutXProperty().set(targetX);
                FXMLController.p2Estatico.layoutYProperty().set(targetY);
                targetX = FXMLController.p2Estatico.layoutXProperty().get();
                targetY = FXMLController.p2Estatico.layoutYProperty().get();
                break;

            case "3":
                FXMLController.p3Estatico.layoutXProperty().set(targetX);
                FXMLController.p3Estatico.layoutYProperty().set(targetY);
                targetX = FXMLController.p3Estatico.layoutXProperty().get();
                targetY = FXMLController.p3Estatico.layoutYProperty().get();
                break;

            case "4":
                FXMLController.p4Estatico.layoutXProperty().set(targetX);
                FXMLController.p4Estatico.layoutYProperty().set(targetY);
                targetX = FXMLController.p4Estatico.layoutXProperty().get();
                targetY = FXMLController.p4Estatico.layoutYProperty().get();
                break;

            case "5":
                FXMLController.p5Estatico.layoutXProperty().set(targetX);
                FXMLController.p5Estatico.layoutYProperty().set(targetY);
                targetX = FXMLController.p5Estatico.layoutXProperty().get();
                targetY = FXMLController.p5Estatico.layoutYProperty().get();
                break;

            case "6":
                FXMLController.p6Estatico.layoutXProperty().set(targetX);
                FXMLController.p6Estatico.layoutYProperty().set(targetY);
                targetX = FXMLController.p7Estatico.layoutXProperty().get();
                targetY = FXMLController.p7Estatico.layoutYProperty().get();
                break;

            case "7":
                FXMLController.p7Estatico.layoutXProperty().set(targetX);
                FXMLController.p7Estatico.layoutYProperty().set(targetY);
                targetX = FXMLController.p7Estatico.layoutXProperty().get();
                targetY = FXMLController.p7Estatico.layoutYProperty().get();
                break;

            case "8":
                FXMLController.p8Estatico.layoutXProperty().set(targetX);
                FXMLController.p8Estatico.layoutYProperty().set(targetY);
                targetX = FXMLController.p8Estatico.layoutXProperty().get();
                targetY = FXMLController.p8Estatico.layoutYProperty().get();
                break;

            case "9":
                FXMLController.p9Estatico.layoutXProperty().set(targetX);
                FXMLController.p9Estatico.layoutYProperty().set(targetY);
                targetX = FXMLController.p9Estatico.layoutXProperty().get();
                targetY = FXMLController.p9Estatico.layoutYProperty().get();
                break;

            case "10":
                FXMLController.p10Estatico.layoutXProperty().set(targetX);
                FXMLController.p10Estatico.layoutYProperty().set(targetY);
                targetX = FXMLController.p10Estatico.layoutXProperty().get();
                targetY = FXMLController.p10Estatico.layoutYProperty().get();
                break;

            case "11":
                FXMLController.p11Estatico.layoutXProperty().set(targetX);
                FXMLController.p11Estatico.layoutYProperty().set(targetY);
                targetX = FXMLController.p11Estatico.layoutXProperty().get();
                targetY = FXMLController.p11Estatico.layoutYProperty().get();
                break;

            case "12":
                FXMLController.p12Estatico.layoutXProperty().set(targetX);
                FXMLController.p12Estatico.layoutYProperty().set(targetY);
                targetX = FXMLController.p12Estatico.layoutXProperty().get();
                targetY = FXMLController.p12Estatico.layoutYProperty().get();
                break;

            case "13":
                FXMLController.p13Estatico.layoutXProperty().set(targetX);
                FXMLController.p13Estatico.layoutYProperty().set(targetY);
                targetX = FXMLController.p13Estatico.layoutXProperty().get();
                targetY = FXMLController.p13Estatico.layoutYProperty().get();
                break;

            case "14":
                FXMLController.p14Estatico.layoutXProperty().set(targetX);
                FXMLController.p14Estatico.layoutYProperty().set(targetY);
                targetX = FXMLController.p14Estatico.layoutXProperty().get();
                targetY = FXMLController.p14Estatico.layoutYProperty().get();
                break;

            case "15":
                FXMLController.p15Estatico.layoutXProperty().set(targetX);
                FXMLController.p15Estatico.layoutYProperty().set(targetY);
                targetX = FXMLController.p15Estatico.layoutXProperty().get();
                targetY = FXMLController.p15Estatico.layoutYProperty().get();
                break;

            case "16":
                FXMLController.p16Estatico.layoutXProperty().set(targetX);
                FXMLController.p16Estatico.layoutYProperty().set(targetY);
                targetX = FXMLController.p16Estatico.layoutXProperty().get();
                targetY = FXMLController.p16Estatico.layoutYProperty().get();
                break;

            case "17":
                FXMLController.p17Estatico.layoutXProperty().set(targetX);
                FXMLController.p17Estatico.layoutYProperty().set(targetY);
                targetX = FXMLController.p17Estatico.layoutXProperty().get();
                targetY = FXMLController.p17Estatico.layoutYProperty().get();
                break;

            case "18":
                FXMLController.p18Estatico.layoutXProperty().set(targetX);
                FXMLController.p18Estatico.layoutYProperty().set(targetY);
                targetX = FXMLController.p18Estatico.layoutXProperty().get();
                targetY = FXMLController.p18Estatico.layoutYProperty().get();
                break;

            case "19":
                FXMLController.p19Estatico.layoutXProperty().set(targetX);
                FXMLController.p19Estatico.layoutYProperty().set(targetY);
                targetX = FXMLController.p19Estatico.layoutXProperty().get();
                targetY = FXMLController.p19Estatico.layoutYProperty().get();
                break;

            case "20":
                FXMLController.p20Estatico.layoutXProperty().set(targetX);
                FXMLController.p20Estatico.layoutYProperty().set(targetY);
                targetX = FXMLController.p20Estatico.layoutXProperty().get();
                targetY = FXMLController.p20Estatico.layoutYProperty().get();
                break;

            case "21":
                FXMLController.p21Estatico.layoutXProperty().set(targetX);
                FXMLController.p21Estatico.layoutYProperty().set(targetY);
                targetX = FXMLController.p21Estatico.layoutXProperty().get();
                targetY = FXMLController.p21Estatico.layoutYProperty().get();
                break;

            case "22":
                FXMLController.p22Estatico.layoutXProperty().set(targetX);
                FXMLController.p22Estatico.layoutYProperty().set(targetY);
                targetX = FXMLController.p22Estatico.layoutXProperty().get();
                targetY = FXMLController.p22Estatico.layoutYProperty().get();
                break;

            case "23":
                FXMLController.p23Estatico.layoutXProperty().set(targetX);
                FXMLController.p23Estatico.layoutYProperty().set(targetY);
                targetX = FXMLController.p23Estatico.layoutXProperty().get();
                targetY = FXMLController.p23Estatico.layoutYProperty().get();
                break;

            case "24":
                FXMLController.p24Estatico.layoutXProperty().set(targetX);
                FXMLController.p24Estatico.layoutYProperty().set(targetY);
                targetX = FXMLController.p24Estatico.layoutXProperty().get();
                targetY = FXMLController.p24Estatico.layoutYProperty().get();
                break;

            case "25":
                FXMLController.p25Estatico.layoutXProperty().set(targetX);
                FXMLController.p25Estatico.layoutYProperty().set(targetY);
                targetX = FXMLController.p25Estatico.layoutXProperty().get();
                targetY = FXMLController.p25Estatico.layoutYProperty().get();
                break;

            case "26":
                FXMLController.p26Estatico.layoutXProperty().set(targetX);
                FXMLController.p26Estatico.layoutYProperty().set(targetY);
                targetX = FXMLController.p26Estatico.layoutXProperty().get();
                targetY = FXMLController.p26Estatico.layoutYProperty().get();
                break;

            case "27":
                FXMLController.p27Estatico.layoutXProperty().set(targetX);
                FXMLController.p27Estatico.layoutYProperty().set(targetY);
                targetX = FXMLController.p27Estatico.layoutXProperty().get();
                targetY = FXMLController.p27Estatico.layoutYProperty().get();
                break;

            case "28":
                FXMLController.p28Estatico.layoutXProperty().set(targetX);
                FXMLController.p28Estatico.layoutYProperty().set(targetY);
                targetX = FXMLController.p28Estatico.layoutXProperty().get();
                targetY = FXMLController.p28Estatico.layoutYProperty().get();
                break;

            case "29":
                FXMLController.p29Estatico.layoutXProperty().set(targetX);
                FXMLController.p29Estatico.layoutYProperty().set(targetY);
                targetX = FXMLController.p29Estatico.layoutXProperty().get();
                targetY = FXMLController.p29Estatico.layoutYProperty().get();
                break;

            case "30":
                FXMLController.p30Estatico.layoutXProperty().set(targetX);
                FXMLController.p30Estatico.layoutYProperty().set(targetY);
                targetX = FXMLController.p30Estatico.layoutXProperty().get();
                targetY = FXMLController.p30Estatico.layoutYProperty().get();
                break;

            default:
                // Handle the case when an invalid position is provided
                return;
        }

        switch (atacada) {
            case 1:
                
                targetX = FXMLController.atacadasEstatico.layoutXProperty().get();
                targetY = FXMLController.atacadasEstatico.layoutYProperty().get();
                
                targetX = random.nextInt(140) + targetX;
                targetY = random.nextInt(60) + targetY;
                
                FXMLController.p1Estatico.layoutXProperty().set(targetX);
                FXMLController.p1Estatico.layoutYProperty().set(targetY);              
                break;
            case 2:
                targetX = FXMLController.atacadasEstatico.layoutXProperty().get();
                targetY = FXMLController.atacadasEstatico.layoutYProperty().get();
                
                targetX = random.nextInt(140) + targetX;
                targetY = random.nextInt(60) + targetY;
                
                FXMLController.p2Estatico.layoutXProperty().set(targetX);
                FXMLController.p2Estatico.layoutYProperty().set(targetY);               
                break;

            case 3:
                targetX = FXMLController.atacadasEstatico.layoutXProperty().get();
                targetY = FXMLController.atacadasEstatico.layoutYProperty().get();
                
                targetX = random.nextInt(140) + targetX;
                targetY = random.nextInt(60) + targetY;
                
                FXMLController.p3Estatico.layoutXProperty().set(targetX);
                FXMLController.p3Estatico.layoutYProperty().set(targetY); 
                break;

            case 4:
                targetX = FXMLController.atacadasEstatico.layoutXProperty().get();
                targetY = FXMLController.atacadasEstatico.layoutYProperty().get();
                
                targetX = random.nextInt(140) + targetX;
                targetY = random.nextInt(60) + targetY;
                
                FXMLController.p4Estatico.layoutXProperty().set(targetX);
                FXMLController.p4Estatico.layoutYProperty().set(targetY); 
                break;

            case 5:
                targetX = FXMLController.atacadasEstatico.layoutXProperty().get();
                targetY = FXMLController.atacadasEstatico.layoutYProperty().get();
                
                targetX = random.nextInt(140) + targetX;
                targetY = random.nextInt(60) + targetY;
                
                FXMLController.p5Estatico.layoutXProperty().set(targetX);
                FXMLController.p5Estatico.layoutYProperty().set(targetY); 
                break;

            case 6:
                targetX = FXMLController.atacadasEstatico.layoutXProperty().get();
                targetY = FXMLController.atacadasEstatico.layoutYProperty().get();
                
                targetX = random.nextInt(140) + targetX;
                targetY = random.nextInt(60) + targetY;
                
                FXMLController.p6Estatico.layoutXProperty().set(targetX);
                FXMLController.p6Estatico.layoutYProperty().set(targetY); 
                break;

            case 7:
                targetX = FXMLController.atacadasEstatico.layoutXProperty().get();
                targetY = FXMLController.atacadasEstatico.layoutYProperty().get();
                
                targetX = random.nextInt(140) + targetX;
                targetY = random.nextInt(60) + targetY;
                
                FXMLController.p7Estatico.layoutXProperty().set(targetX);
                FXMLController.p7Estatico.layoutYProperty().set(targetY); 
                break;

            case 8:
                targetX = FXMLController.atacadasEstatico.layoutXProperty().get();
                targetY = FXMLController.atacadasEstatico.layoutYProperty().get();
                
                targetX = random.nextInt(140) + targetX;
                targetY = random.nextInt(60) + targetY;
                
                FXMLController.p8Estatico.layoutXProperty().set(targetX);
                FXMLController.p8Estatico.layoutYProperty().set(targetY); 
                break;

            case 9:
                targetX = FXMLController.atacadasEstatico.layoutXProperty().get();
                targetY = FXMLController.atacadasEstatico.layoutYProperty().get();
                
                targetX = random.nextInt(140) + targetX;
                targetY = random.nextInt(60) + targetY;
                
                FXMLController.p9Estatico.layoutXProperty().set(targetX);
                FXMLController.p9Estatico.layoutYProperty().set(targetY); 
                break;

            case 10:
                targetX = FXMLController.atacadasEstatico.layoutXProperty().get();
                targetY = FXMLController.atacadasEstatico.layoutYProperty().get();
                
                targetX = random.nextInt(140) + targetX;
                targetY = random.nextInt(60) + targetY;
                
                FXMLController.p10Estatico.layoutXProperty().set(targetX);
                FXMLController.p10Estatico.layoutYProperty().set(targetY); 
                break;

            case 11:
                targetX = FXMLController.atacadasEstatico.layoutXProperty().get();
                targetY = FXMLController.atacadasEstatico.layoutYProperty().get();
                
                targetX = random.nextInt(140) + targetX;
                targetY = random.nextInt(60) + targetY;
                
                FXMLController.p11Estatico.layoutXProperty().set(targetX);
                FXMLController.p11Estatico.layoutYProperty().set(targetY); 
                break;

            case 12:
                targetX = FXMLController.atacadasEstatico.layoutXProperty().get();
                targetY = FXMLController.atacadasEstatico.layoutYProperty().get();
                
                targetX = random.nextInt(140) + targetX;
                targetY = random.nextInt(60) + targetY;
                
                FXMLController.p12Estatico.layoutXProperty().set(targetX);
                FXMLController.p12Estatico.layoutYProperty().set(targetY); 
                break;

            case 13:
                targetX = FXMLController.atacadasEstatico.layoutXProperty().get();
                targetY = FXMLController.atacadasEstatico.layoutYProperty().get();
                
                targetX = random.nextInt(140) + targetX;
                targetY = random.nextInt(60) + targetY;
                
                FXMLController.p13Estatico.layoutXProperty().set(targetX);
                FXMLController.p13Estatico.layoutYProperty().set(targetY); 
                break;

            case 14:
                targetX = FXMLController.atacadasEstatico.layoutXProperty().get();
                targetY = FXMLController.atacadasEstatico.layoutYProperty().get();
                
                targetX = random.nextInt(140) + targetX;
                targetY = random.nextInt(60) + targetY;
                
                FXMLController.p14Estatico.layoutXProperty().set(targetX);
                FXMLController.p14Estatico.layoutYProperty().set(targetY); 
                break;

            case 15:
                targetX = FXMLController.atacadasEstatico.layoutXProperty().get();
                targetY = FXMLController.atacadasEstatico.layoutYProperty().get();
                
                targetX = random.nextInt(140) + targetX;
                targetY = random.nextInt(60) + targetY;
                
                FXMLController.p15Estatico.layoutXProperty().set(targetX);
                FXMLController.p15Estatico.layoutYProperty().set(targetY); 
                break;

            case 16:
                targetX = FXMLController.atacadasEstatico.layoutXProperty().get();
                targetY = FXMLController.atacadasEstatico.layoutYProperty().get();
                
                targetX = 160 + random.nextInt(140) + targetX;
                targetY = random.nextInt(60) + targetY;
                
                FXMLController.p16Estatico.layoutXProperty().set(targetX);
                FXMLController.p16Estatico.layoutYProperty().set(targetY); 
                break;

            case 17:
                targetX = FXMLController.atacadasEstatico.layoutXProperty().get();
                targetY = FXMLController.atacadasEstatico.layoutYProperty().get();
                
                targetX = 160 + random.nextInt(140) + targetX;
                targetY = random.nextInt(60) + targetY;
                
                FXMLController.p17Estatico.layoutXProperty().set(targetX);
                FXMLController.p17Estatico.layoutYProperty().set(targetY);
                break;

            case 18:
                targetX = FXMLController.atacadasEstatico.layoutXProperty().get();
                targetY = FXMLController.atacadasEstatico.layoutYProperty().get();
                
                targetX = 160 + random.nextInt(140) + targetX;
                targetY = random.nextInt(60) + targetY;
                
                FXMLController.p18Estatico.layoutXProperty().set(targetX);
                FXMLController.p18Estatico.layoutYProperty().set(targetY);
                break;

            case 19:
                targetX = FXMLController.atacadasEstatico.layoutXProperty().get();
                targetY = FXMLController.atacadasEstatico.layoutYProperty().get();
                
                targetX = 160 + random.nextInt(140) + targetX;
                targetY = random.nextInt(60) + targetY;
                
                FXMLController.p19Estatico.layoutXProperty().set(targetX);
                FXMLController.p19Estatico.layoutYProperty().set(targetY);
                break;

            case 20:
                targetX = FXMLController.atacadasEstatico.layoutXProperty().get();
                targetY = FXMLController.atacadasEstatico.layoutYProperty().get();
                
                targetX = 160 + random.nextInt(140) + targetX;
                targetY = random.nextInt(60) + targetY;
                
                FXMLController.p20Estatico.layoutXProperty().set(targetX);
                FXMLController.p20Estatico.layoutYProperty().set(targetY);
                break;

            case 21:
                targetX = FXMLController.atacadasEstatico.layoutXProperty().get();
                targetY = FXMLController.atacadasEstatico.layoutYProperty().get();
                
                targetX = 160 + random.nextInt(140) + targetX;
                targetY = random.nextInt(60) + targetY;
                
                FXMLController.p21Estatico.layoutXProperty().set(targetX);
                FXMLController.p21Estatico.layoutYProperty().set(targetY);
                break;

            case 22:
                targetX = FXMLController.atacadasEstatico.layoutXProperty().get();
                targetY = FXMLController.atacadasEstatico.layoutYProperty().get();
                
                targetX = 160 + random.nextInt(140) + targetX;
                targetY = random.nextInt(60) + targetY;
                
                FXMLController.p22Estatico.layoutXProperty().set(targetX);
                FXMLController.p22Estatico.layoutYProperty().set(targetY);
                break;

            case 23:
                targetX = FXMLController.atacadasEstatico.layoutXProperty().get();
                targetY = FXMLController.atacadasEstatico.layoutYProperty().get();
                
                targetX = 160 + random.nextInt(140) + targetX;
                targetY = random.nextInt(60) + targetY;
                
                FXMLController.p23Estatico.layoutXProperty().set(targetX);
                FXMLController.p23Estatico.layoutYProperty().set(targetY);
                break;

            case 24:
                targetX = FXMLController.atacadasEstatico.layoutXProperty().get();
                targetY = FXMLController.atacadasEstatico.layoutYProperty().get();
                
                targetX = 160 + random.nextInt(140) + targetX;
                targetY = random.nextInt(60) + targetY;
                
                FXMLController.p24Estatico.layoutXProperty().set(targetX);
                FXMLController.p24Estatico.layoutYProperty().set(targetY);
                break;

            case 25:
                targetX = FXMLController.atacadasEstatico.layoutXProperty().get();
                targetY = FXMLController.atacadasEstatico.layoutYProperty().get();
                
                targetX = 160 + random.nextInt(140) + targetX;
                targetY = random.nextInt(60) + targetY;
                
                FXMLController.p25Estatico.layoutXProperty().set(targetX);
                FXMLController.p25Estatico.layoutYProperty().set(targetY);
                break;

            case 26:
                targetX = FXMLController.atacadasEstatico.layoutXProperty().get();
                targetY = FXMLController.atacadasEstatico.layoutYProperty().get();
                
                targetX = 160 + random.nextInt(140) + targetX;
                targetY = random.nextInt(60) + targetY;
                
                FXMLController.p26Estatico.layoutXProperty().set(targetX);
                FXMLController.p26Estatico.layoutYProperty().set(targetY);
                break;

            case 27:
                targetX = FXMLController.atacadasEstatico.layoutXProperty().get();
                targetY = FXMLController.atacadasEstatico.layoutYProperty().get();
                
                targetX = 160 + random.nextInt(140) + targetX;
                targetY = random.nextInt(60) + targetY;
                
                FXMLController.p27Estatico.layoutXProperty().set(targetX);
                FXMLController.p27Estatico.layoutYProperty().set(targetY);
                break;

            case 28:
                targetX = FXMLController.atacadasEstatico.layoutXProperty().get();
                targetY = FXMLController.atacadasEstatico.layoutYProperty().get();
                
                targetX = 160 + random.nextInt(140) + targetX;
                targetY = random.nextInt(60) + targetY;
                
                FXMLController.p28Estatico.layoutXProperty().set(targetX);
                FXMLController.p28Estatico.layoutYProperty().set(targetY);
                break;

            case 29:
                targetX = FXMLController.atacadasEstatico.layoutXProperty().get();
                targetY = FXMLController.atacadasEstatico.layoutYProperty().get();
                
                targetX = 160 + random.nextInt(140) + targetX;
                targetY = random.nextInt(60) + targetY;
                
                FXMLController.p29Estatico.layoutXProperty().set(targetX);
                FXMLController.p29Estatico.layoutYProperty().set(targetY);
                break;

            case 30:
                targetX = FXMLController.atacadasEstatico.layoutXProperty().get();
                targetY = FXMLController.atacadasEstatico.layoutYProperty().get();
                
                targetX = 160 + random.nextInt(140) + targetX;
                targetY = random.nextInt(60) + targetY;
                
                FXMLController.p30Estatico.layoutXProperty().set(targetX);
                FXMLController.p30Estatico.layoutYProperty().set(targetY);
                break;

            default:
                // Handle the case when an invalid position is provided
                return;
        }
    }

   
    public void retiraPeca(String peca){
        switch (peca) {
            case "1":
                FXMLController.p1Estatico.setVisible(false);
                break;

            case "2":
                FXMLController.p2Estatico.setVisible(false);         
                break;

            case "3":
                FXMLController.p3Estatico.setVisible(false);                            
                break;

            case "4":
                FXMLController.p4Estatico.setVisible(false);                             
                break;

            case "5":
                FXMLController.p5Estatico.setVisible(false);                              
                break;

            case "6":
                FXMLController.p6Estatico.setVisible(false);                         
                break;

            case "7":
                FXMLController.p7Estatico.setVisible(false);                         
                break;

            case "8":
                FXMLController.p8Estatico.setVisible(false);                            
                break;

            case "9":
                FXMLController.p9Estatico.setVisible(false);                             
                break;

            case "10":
                FXMLController.p10Estatico.setVisible(false);                              
                break;

            case "11":
                FXMLController.p11Estatico.setVisible(false);                            
                break;

            case "12":
                FXMLController.p12Estatico.setVisible(false);               
                break;

            case "13":
                FXMLController.p13Estatico.setVisible(false);                               
                break;

            case "14":
                FXMLController.p14Estatico.setVisible(false);                             
                break;

            case "15":
                FXMLController.p15Estatico.setVisible(false);                           
                break;

            case "16":
                FXMLController.p16Estatico.setVisible(false);                              
                break;

            case "17":
                FXMLController.p17Estatico.setVisible(false);                        
                break;

            case "18":
                FXMLController.p18Estatico.setVisible(false);                              
                break;

            case "19":
                FXMLController.p19Estatico.setVisible(false);                       
                break;

            case "20":
                FXMLController.p20Estatico.setVisible(false);                              
                break;

            case "21":
                FXMLController.p21Estatico.setVisible(false);                            
                break;

            case "22":
                FXMLController.p22Estatico.setVisible(false);                             
                break;

            case "23":
                FXMLController.p23Estatico.setVisible(false);                           
                break;

            case "24":
                FXMLController.p24Estatico.setVisible(false);                                
                break;

            case "25":
                FXMLController.p25Estatico.setVisible(false);                            
                break;

            case "26":
                FXMLController.p26Estatico.setVisible(false);                           
                break;

            case "27":
                FXMLController.p27Estatico.setVisible(false);                               
                break;

            case "28":
                FXMLController.p28Estatico.setVisible(false);                             
                break;

            case "29":
                FXMLController.p29Estatico.setVisible(false);                              
                break;

            case "30":
                FXMLController.p30Estatico.setVisible(false);               
                break;

            default:
                // Handle the case when an invalid position is provided
                return;
        }
    }

    public boolean ganhou(){
       return this.ganhou = true;
    }

    public void passouVez() {
        this.mudaVez();
    }


    public void mudaVez() {
        this.minhavez = !this.minhavez;
        lancouDados = false;
        
        //Som ao mudar vez
        Media mudarVez = new Media(getClass().getResource("terminaronda.wav").toExternalForm());
        MediaPlayer mudarAudio = new MediaPlayer(mudarVez);
        mudarAudio.play();
        
        Platform.runLater(() -> {
            if (!this.minhavez) {
                FXMLController.jogadaEstatico.setDisable(true);
                FXMLController.lancardadosEstatico.setDisable(true);
                FXMLController.jogarEstatico.setDisable(true);
                FXMLController.pecaidEstatico.setDisable(true);
                FXMLController.posicaoidEstatico.setDisable(true);
                FXMLController.text1Estatico.setText("0");
                FXMLController.text2Estatico.setText("0");
                FXMLController.text3Estatico.setText("0");

            } else {
                FXMLController.jogadaEstatico.setDisable(false);
                FXMLController.lancardadosEstatico.setDisable(false);
                FXMLController.jogarEstatico.setDisable(false);
                FXMLController.pecaidEstatico.setDisable(false);
                FXMLController.posicaoidEstatico.setDisable(false);
                FXMLController.text1Estatico.setText("0");
                FXMLController.text2Estatico.setText("0");
                FXMLController.text3Estatico.setText("0");
            }
        });
        Platform.runLater(() -> {
            String labelText = "É a sua vez de jogar";
            if (!this.minhavez) {
                labelText = "Aguarde que o adversário jogue";
            }
            FXMLController.labelVezEstatico.setText(labelText);

        });
    }

    public boolean getMinhaVez() {
        return this.minhavez;
    }
}