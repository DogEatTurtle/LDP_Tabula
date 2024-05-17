/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package tabula;

import java.io.ObjectOutputStream;
import java.util.Random;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
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

        FXMLController.text1Estatico.setText("" + d1);
        FXMLController.text2Estatico.setText("" + d2);
        FXMLController.text3Estatico.setText("" + d3);

    }

    public void movePeca(String peca, int posicao, int atacada) {

        double targetX = 0;
        double targetY = 0;

        switch (posicao) {
            case 1:
                targetX = FXMLController.pos1Estatico.layoutXProperty().get();
                targetY = FXMLController.pos1Estatico.layoutYProperty().get();
                targetX = random.nextInt(25) + targetX;
                targetY = random.nextInt(182) + targetY;
                
                System.out.println(targetX);
                System.out.println(targetY);
                break;

            case 2:
                targetX = FXMLController.pos2Estatico.layoutXProperty().get();
                targetY = FXMLController.pos2Estatico.layoutYProperty().get();
                targetX = random.nextInt(25) + targetX;
                targetY = random.nextInt(182) + targetY;
                System.out.println(targetX);
                System.out.println(targetY);
                break;

            case 3:
                targetX = FXMLController.pos3Estatico.layoutXProperty().get();
                targetY = FXMLController.pos3Estatico.layoutYProperty().get();
                targetX = random.nextInt(25) + targetX;
                targetY = random.nextInt(182) + targetY;
                System.out.println(targetX);
                System.out.println(targetY);
                break;

            case 4:
                targetX = FXMLController.pos4Estatico.layoutXProperty().get();
                targetY = FXMLController.pos4Estatico.layoutYProperty().get();
                targetX = random.nextInt(25) + targetX;
                targetY = random.nextInt(182) + targetY;
                System.out.println(targetX);
                System.out.println(targetY);
                break;

            case 5:
                targetX = FXMLController.pos5Estatico.layoutXProperty().get();
                targetY = FXMLController.pos5Estatico.layoutYProperty().get();
                targetX = random.nextInt(25) + targetX;
                targetY = random.nextInt(182) + targetY;
                System.out.println(targetX);
                System.out.println(targetY);
                break;
            case 6:
                targetX = FXMLController.pos6Estatico.layoutXProperty().get();
                targetY = FXMLController.pos6Estatico.layoutYProperty().get();
                targetX = random.nextInt(25) + targetX;
                targetY = random.nextInt(182) + targetY;
                System.out.println(targetX);
                System.out.println(targetY);
                break;

            case 7:
                targetX = FXMLController.pos7Estatico.layoutXProperty().get();
                targetY = FXMLController.pos7Estatico.layoutYProperty().get();
                targetX = random.nextInt(25) + targetX;
                targetY = random.nextInt(182) + targetY;
                System.out.println(targetX);
                System.out.println(targetY);
                break;

            case 8:
                targetX = FXMLController.pos8Estatico.layoutXProperty().get();
                targetY = FXMLController.pos8Estatico.layoutYProperty().get();
                targetX = random.nextInt(25) + targetX;
                targetY = random.nextInt(182) + targetY;
                System.out.println(targetX);
                System.out.println(targetY);
                break;

            case 9:
                targetX = FXMLController.pos9Estatico.layoutXProperty().get();
                targetY = FXMLController.pos9Estatico.layoutYProperty().get();
                targetX = random.nextInt(25) + targetX;
                targetY = random.nextInt(182) + targetY;
                System.out.println(targetX);
                System.out.println(targetY);
                break;

            case 10:
                targetX = FXMLController.pos10Estatico.layoutXProperty().get();
                targetY = FXMLController.pos10Estatico.layoutYProperty().get();
                targetX = random.nextInt(25) + targetX;
                targetY = random.nextInt(182) + targetY;
                System.out.println(targetX);
                System.out.println(targetY);
                break;

            case 11:
                targetX = FXMLController.pos11Estatico.layoutXProperty().get();
                targetY = FXMLController.pos11Estatico.layoutYProperty().get();
                targetX = random.nextInt(25) + targetX;
                targetY = random.nextInt(182) + targetY;
                System.out.println(targetX);
                System.out.println(targetY);
                break;

            case 12:
                targetX = FXMLController.pos12Estatico.layoutXProperty().get();
                targetY = FXMLController.pos12Estatico.layoutYProperty().get();
                targetX = random.nextInt(25) + targetX;
                targetY = random.nextInt(182) + targetY;
                System.out.println(targetX);
                System.out.println(targetY);
                break;

            case 13:
                targetX = FXMLController.pos13Estatico.layoutXProperty().get();
                targetY = FXMLController.pos13Estatico.layoutYProperty().get();
                targetX = random.nextInt(25) + targetX;
                targetY = random.nextInt(182) + targetY;
                System.out.println(targetX);
                System.out.println(targetY);
                break;

            case 14:
                targetX = FXMLController.pos14Estatico.layoutXProperty().get();
                targetY = FXMLController.pos14Estatico.layoutYProperty().get();
                targetX = random.nextInt(25) + targetX;
                targetY = random.nextInt(182) + targetY;
                System.out.println(targetX);
                System.out.println(targetY);
                break;

            case 15:
                targetX = FXMLController.pos15Estatico.layoutXProperty().get();
                targetY = FXMLController.pos15Estatico.layoutYProperty().get();
                targetX = random.nextInt(25) + targetX;
                targetY = random.nextInt(182) + targetY;
                System.out.println(targetX);
                System.out.println(targetY);
                break;

            case 16:
                targetX = FXMLController.pos16Estatico.layoutXProperty().get();
                targetY = FXMLController.pos16Estatico.layoutYProperty().get();
                targetX = random.nextInt(25) + targetX;
                targetY = random.nextInt(182) + targetY;
                System.out.println(targetX);
                System.out.println(targetY);
                break;

            case 17:
                targetX = FXMLController.pos17Estatico.layoutXProperty().get();
                targetY = FXMLController.pos17Estatico.layoutYProperty().get();
                targetX = random.nextInt(25) + targetX;
                targetY = random.nextInt(182) + targetY;
                System.out.println(targetX);
                System.out.println(targetY);
                break;

            case 18:
                targetX = FXMLController.pos18Estatico.layoutXProperty().get();
                targetY = FXMLController.pos18Estatico.layoutYProperty().get();
                targetX = random.nextInt(25) + targetX;
                targetY = random.nextInt(182) + targetY;
                System.out.println(targetX);
                System.out.println(targetY);
                break;

            case 19:
                targetX = FXMLController.pos19Estatico.layoutXProperty().get();
                targetY = FXMLController.pos19Estatico.layoutYProperty().get();
                targetX = random.nextInt(25) + targetX;
                targetY = random.nextInt(182) + targetY;
                System.out.println(targetX);
                System.out.println(targetY);
                break;

            case 20:
                targetX = FXMLController.pos20Estatico.layoutXProperty().get();
                targetY = FXMLController.pos20Estatico.layoutYProperty().get();
                targetX = random.nextInt(25) + targetX;
                targetY = random.nextInt(182) + targetY;
                System.out.println(targetX);
                System.out.println(targetY);
                break;

            case 21:
                targetX = FXMLController.pos21Estatico.layoutXProperty().get();
                targetY = FXMLController.pos21Estatico.layoutYProperty().get();
                targetX = random.nextInt(25) + targetX;
                targetY = random.nextInt(182) + targetY;
                System.out.println(targetX);
                System.out.println(targetY);
                break;

            case 22:
                targetX = FXMLController.pos22Estatico.layoutXProperty().get();
                targetY = FXMLController.pos22Estatico.layoutYProperty().get();
                targetX = random.nextInt(25) + targetX;
                targetY = random.nextInt(182) + targetY;
                System.out.println(targetX);
                System.out.println(targetY);
                break;

            case 23:
                targetX = FXMLController.pos23Estatico.layoutXProperty().get();
                targetY = FXMLController.pos23Estatico.layoutYProperty().get();
                targetX = random.nextInt(25) + targetX;
                targetY = random.nextInt(182) + targetY;
                System.out.println(targetX);
                System.out.println(targetY);
                break;

            case 24:
                targetX = FXMLController.pos24Estatico.layoutXProperty().get();
                targetY = FXMLController.pos24Estatico.layoutYProperty().get();
                targetX = random.nextInt(25) + targetX;
                targetY = random.nextInt(182) + targetY;
                System.out.println(targetX);
                System.out.println(targetY);
                break;

            default:
                // Handle the case when an invalid position is provided
                return;
        }

        switch (peca) {
            case "1":
                FXMLController.p1Estatico.layoutXProperty().set(targetX);
                FXMLController.p1Estatico.layoutYProperty().set(targetY);
                targetX = FXMLController.p1Estatico.layoutXProperty().get();
                targetY = FXMLController.p1Estatico.layoutYProperty().get();
                System.out.println(targetX);
                System.out.println(targetY);

                break;

            case "2":
                FXMLController.p2Estatico.layoutXProperty().set(targetX);
                FXMLController.p2Estatico.layoutYProperty().set(targetY);
                targetX = FXMLController.p2Estatico.layoutXProperty().get();
                targetY = FXMLController.p2Estatico.layoutYProperty().get();
                System.out.println(targetX);
                System.out.println(targetY);

                break;

            case "3":
                FXMLController.p3Estatico.layoutXProperty().set(targetX);
                FXMLController.p3Estatico.layoutYProperty().set(targetY);
                targetX = FXMLController.p3Estatico.layoutXProperty().get();
                targetY = FXMLController.p3Estatico.layoutYProperty().get();
                System.out.println(targetX);
                System.out.println(targetY);

                break;

            case "4":
                FXMLController.p4Estatico.layoutXProperty().set(targetX);
                FXMLController.p4Estatico.layoutYProperty().set(targetY);
                targetX = FXMLController.p4Estatico.layoutXProperty().get();
                targetY = FXMLController.p4Estatico.layoutYProperty().get();
                System.out.println(targetX);
                System.out.println(targetY);

                break;

            case "5":
                FXMLController.p5Estatico.layoutXProperty().set(targetX);
                FXMLController.p5Estatico.layoutYProperty().set(targetY);
                targetX = FXMLController.p5Estatico.layoutXProperty().get();
                targetY = FXMLController.p5Estatico.layoutYProperty().get();
                System.out.println(targetX);
                System.out.println(targetY);

                break;

            case "6":
                FXMLController.p6Estatico.layoutXProperty().set(targetX);
                FXMLController.p6Estatico.layoutYProperty().set(targetY);
                targetX = FXMLController.p7Estatico.layoutXProperty().get();
                targetY = FXMLController.p7Estatico.layoutYProperty().get();
                System.out.println(targetX);
                System.out.println(targetY);

                break;

            case "7":
                FXMLController.p7Estatico.layoutXProperty().set(targetX);
                FXMLController.p7Estatico.layoutYProperty().set(targetY);
                targetX = FXMLController.p7Estatico.layoutXProperty().get();
                targetY = FXMLController.p7Estatico.layoutYProperty().get();
                System.out.println(targetX);
                System.out.println(targetY);

                break;

            case "8":
                FXMLController.p8Estatico.layoutXProperty().set(targetX);
                FXMLController.p8Estatico.layoutYProperty().set(targetY);
                targetX = FXMLController.p8Estatico.layoutXProperty().get();
                targetY = FXMLController.p8Estatico.layoutYProperty().get();
                System.out.println(targetX);
                System.out.println(targetY);

                break;

            case "9":
                FXMLController.p9Estatico.layoutXProperty().set(targetX);
                FXMLController.p9Estatico.layoutYProperty().set(targetY);
                targetX = FXMLController.p9Estatico.layoutXProperty().get();
                targetY = FXMLController.p9Estatico.layoutYProperty().get();
                System.out.println(targetX);
                System.out.println(targetY);

                break;

            case "10":
                FXMLController.p10Estatico.layoutXProperty().set(targetX);
                FXMLController.p10Estatico.layoutYProperty().set(targetY);
                targetX = FXMLController.p10Estatico.layoutXProperty().get();
                targetY = FXMLController.p10Estatico.layoutYProperty().get();
                System.out.println(targetX);
                System.out.println(targetY);

                break;

            case "11":
                FXMLController.p11Estatico.layoutXProperty().set(targetX);
                FXMLController.p11Estatico.layoutYProperty().set(targetY);
                targetX = FXMLController.p11Estatico.layoutXProperty().get();
                targetY = FXMLController.p11Estatico.layoutYProperty().get();
                System.out.println(targetX);
                System.out.println(targetY);

                break;

            case "12":
                FXMLController.p12Estatico.layoutXProperty().set(targetX);
                FXMLController.p12Estatico.layoutYProperty().set(targetY);
                targetX = FXMLController.p12Estatico.layoutXProperty().get();
                targetY = FXMLController.p12Estatico.layoutYProperty().get();
                System.out.println(targetX);
                System.out.println(targetY);

                break;

            case "13":
                FXMLController.p13Estatico.layoutXProperty().set(targetX);
                FXMLController.p13Estatico.layoutYProperty().set(targetY);
                targetX = FXMLController.p13Estatico.layoutXProperty().get();
                targetY = FXMLController.p13Estatico.layoutYProperty().get();
                System.out.println(targetX);
                System.out.println(targetY);

                break;

            case "14":
                FXMLController.p14Estatico.layoutXProperty().set(targetX);
                FXMLController.p14Estatico.layoutYProperty().set(targetY);
                targetX = FXMLController.p14Estatico.layoutXProperty().get();
                targetY = FXMLController.p14Estatico.layoutYProperty().get();
                System.out.println(targetX);
                System.out.println(targetY);

                break;

            case "15":
                FXMLController.p15Estatico.layoutXProperty().set(targetX);
                FXMLController.p15Estatico.layoutYProperty().set(targetY);
                targetX = FXMLController.p15Estatico.layoutXProperty().get();
                targetY = FXMLController.p15Estatico.layoutYProperty().get();
                System.out.println(targetX);
                System.out.println(targetY);

                break;

            case "16":
                FXMLController.p16Estatico.layoutXProperty().set(targetX);
                FXMLController.p16Estatico.layoutYProperty().set(targetY);
                targetX = FXMLController.p16Estatico.layoutXProperty().get();
                targetY = FXMLController.p16Estatico.layoutYProperty().get();
                System.out.println(targetX);
                System.out.println(targetY);

                break;

            case "17":
                FXMLController.p17Estatico.layoutXProperty().set(targetX);
                FXMLController.p17Estatico.layoutYProperty().set(targetY);
                targetX = FXMLController.p17Estatico.layoutXProperty().get();
                targetY = FXMLController.p17Estatico.layoutYProperty().get();
                System.out.println(targetX);
                System.out.println(targetY);

                break;

            case "18":
                FXMLController.p18Estatico.layoutXProperty().set(targetX);
                FXMLController.p18Estatico.layoutYProperty().set(targetY);
                targetX = FXMLController.p18Estatico.layoutXProperty().get();
                targetY = FXMLController.p18Estatico.layoutYProperty().get();
                System.out.println(targetX);
                System.out.println(targetY);

                break;

            case "19":
                FXMLController.p19Estatico.layoutXProperty().set(targetX);
                FXMLController.p19Estatico.layoutYProperty().set(targetY);
                targetX = FXMLController.p19Estatico.layoutXProperty().get();
                targetY = FXMLController.p19Estatico.layoutYProperty().get();
                System.out.println(targetX);
                System.out.println(targetY);

                break;

            case "20":
                FXMLController.p20Estatico.layoutXProperty().set(targetX);
                FXMLController.p20Estatico.layoutYProperty().set(targetY);
                targetX = FXMLController.p20Estatico.layoutXProperty().get();
                targetY = FXMLController.p20Estatico.layoutYProperty().get();
                System.out.println(targetX);
                System.out.println(targetY);

                break;

            case "21":
                FXMLController.p21Estatico.layoutXProperty().set(targetX);
                FXMLController.p21Estatico.layoutYProperty().set(targetY);
                targetX = FXMLController.p21Estatico.layoutXProperty().get();
                targetY = FXMLController.p21Estatico.layoutYProperty().get();
                System.out.println(targetX);
                System.out.println(targetY);

                break;

            case "22":
                FXMLController.p22Estatico.layoutXProperty().set(targetX);
                FXMLController.p22Estatico.layoutYProperty().set(targetY);
                targetX = FXMLController.p22Estatico.layoutXProperty().get();
                targetY = FXMLController.p22Estatico.layoutYProperty().get();
                System.out.println(targetX);
                System.out.println(targetY);

                break;

            case "23":
                FXMLController.p23Estatico.layoutXProperty().set(targetX);
                FXMLController.p23Estatico.layoutYProperty().set(targetY);
                targetX = FXMLController.p23Estatico.layoutXProperty().get();
                targetY = FXMLController.p23Estatico.layoutYProperty().get();
                System.out.println(targetX);
                System.out.println(targetY);

                break;

            case "24":
                FXMLController.p24Estatico.layoutXProperty().set(targetX);
                FXMLController.p24Estatico.layoutYProperty().set(targetY);
                targetX = FXMLController.p24Estatico.layoutXProperty().get();
                targetY = FXMLController.p24Estatico.layoutYProperty().get();
                System.out.println(targetX);
                System.out.println(targetY);

                break;

            case "25":
                FXMLController.p25Estatico.layoutXProperty().set(targetX);
                FXMLController.p25Estatico.layoutYProperty().set(targetY);
                targetX = FXMLController.p25Estatico.layoutXProperty().get();
                targetY = FXMLController.p25Estatico.layoutYProperty().get();
                System.out.println(targetX);
                System.out.println(targetY);

                break;

            case "26":
                FXMLController.p26Estatico.layoutXProperty().set(targetX);
                FXMLController.p26Estatico.layoutYProperty().set(targetY);
                targetX = FXMLController.p26Estatico.layoutXProperty().get();
                targetY = FXMLController.p26Estatico.layoutYProperty().get();
                System.out.println(targetX);
                System.out.println(targetY);

                break;

            case "27":
                FXMLController.p27Estatico.layoutXProperty().set(targetX);
                FXMLController.p27Estatico.layoutYProperty().set(targetY);
                targetX = FXMLController.p27Estatico.layoutXProperty().get();
                targetY = FXMLController.p27Estatico.layoutYProperty().get();
                System.out.println(targetX);
                System.out.println(targetY);

                break;

            case "28":
                FXMLController.p28Estatico.layoutXProperty().set(targetX);
                FXMLController.p28Estatico.layoutYProperty().set(targetY);
                targetX = FXMLController.p28Estatico.layoutXProperty().get();
                targetY = FXMLController.p28Estatico.layoutYProperty().get();
                System.out.println(targetX);
                System.out.println(targetY);

                break;

            case "29":
                FXMLController.p29Estatico.layoutXProperty().set(targetX);
                FXMLController.p29Estatico.layoutYProperty().set(targetY);
                targetX = FXMLController.p29Estatico.layoutXProperty().get();
                targetY = FXMLController.p29Estatico.layoutYProperty().get();
                System.out.println(targetX);
                System.out.println(targetY);

                break;

            case "30":
                FXMLController.p30Estatico.layoutXProperty().set(targetX);
                FXMLController.p30Estatico.layoutYProperty().set(targetY);
                targetX = FXMLController.p30Estatico.layoutXProperty().get();
                targetY = FXMLController.p30Estatico.layoutYProperty().get();
                System.out.println(targetX);
                System.out.println(targetY);

                break;

            default:
                // Handle the case when an invalid position is provided
                return;
        }

        switch (atacada) {
            case 1:
                FXMLController.p1Estatico.layoutXProperty().set(Math.random() * 410 + 39);
                FXMLController.p1Estatico.layoutYProperty().set(544);

                System.out.println(targetX);
                System.out.println(targetY);
                break;
            case 2:
                FXMLController.p2Estatico.layoutXProperty().set(Math.random() * 410 + 39);
                FXMLController.p2Estatico.layoutYProperty().set(544);

                System.out.println(targetX);
                System.out.println(targetY);
                break;

            case 3:
                FXMLController.p3Estatico.layoutXProperty().set(Math.random() * 410 + 39);
                FXMLController.p3Estatico.layoutYProperty().set(544);

                System.out.println(targetX);
                System.out.println(targetY);
                break;

            case 4:
                FXMLController.p4Estatico.layoutXProperty().set(Math.random() * 410 + 39);
                FXMLController.p4Estatico.layoutYProperty().set(544);

                System.out.println(targetX);
                System.out.println(targetY);
                break;

            case 5:
                FXMLController.p5Estatico.layoutXProperty().set(Math.random() * 410 + 39);
                FXMLController.p5Estatico.layoutYProperty().set(544);

                System.out.println(targetX);
                System.out.println(targetY);
                break;

            case 6:
                FXMLController.p6Estatico.layoutXProperty().set(Math.random() * 410 + 39);
                FXMLController.p6Estatico.layoutYProperty().set(544);

                System.out.println(targetX);
                System.out.println(targetY);
                break;

            case 7:
                FXMLController.p7Estatico.layoutXProperty().set(Math.random() * 410 + 39);
                FXMLController.p7Estatico.layoutYProperty().set(544);

                System.out.println(targetX);
                System.out.println(targetY);
                break;

            case 8:
                FXMLController.p8Estatico.layoutXProperty().set(Math.random() * 410 + 39);
                FXMLController.p8Estatico.layoutYProperty().set(544);

                System.out.println(targetX);
                System.out.println(targetY);
                break;

            case 9:
                FXMLController.p9Estatico.layoutXProperty().set(Math.random() * 410 + 39);
                FXMLController.p9Estatico.layoutYProperty().set(544);

                System.out.println(targetX);
                System.out.println(targetY);
                break;

            case 10:
                FXMLController.p10Estatico.layoutXProperty().set(Math.random() * 410 + 39);
                FXMLController.p10Estatico.layoutYProperty().set(544);

                System.out.println(targetX);
                System.out.println(targetY);
                break;

            case 11:
                FXMLController.p11Estatico.layoutXProperty().set(Math.random() * 410 + 39);
                FXMLController.p11Estatico.layoutYProperty().set(544);

                System.out.println(targetX);
                System.out.println(targetY);
                break;

            case 12:
                FXMLController.p12Estatico.layoutXProperty().set(Math.random() * 410 + 39);
                FXMLController.p12Estatico.layoutYProperty().set(544);

                System.out.println(targetX);
                System.out.println(targetY);
                break;

            case 13:
                FXMLController.p13Estatico.layoutXProperty().set(Math.random() * 410 + 39);
                FXMLController.p13Estatico.layoutYProperty().set(544);

                System.out.println(targetX);
                System.out.println(targetY);
                break;

            case 14:
                FXMLController.p14Estatico.layoutXProperty().set(Math.random() * 410 + 39);
                FXMLController.p14Estatico.layoutYProperty().set(544);

                System.out.println(targetX);
                System.out.println(targetY);
                break;

            case 15:
                FXMLController.p15Estatico.layoutXProperty().set(Math.random() * 410 + 39);
                FXMLController.p15Estatico.layoutYProperty().set(544);

                System.out.println(targetX);
                System.out.println(targetY);
                break;

            case 16:
                FXMLController.p16Estatico.layoutXProperty().set(Math.random() * 413 + 627);
                FXMLController.p16Estatico.layoutYProperty().set(544);

                System.out.println(targetX);
                System.out.println(targetY);
                break;

            case 17:
                FXMLController.p17Estatico.layoutXProperty().set(Math.random() * 413 + 627);
                FXMLController.p17Estatico.layoutYProperty().set(544);

                System.out.println(targetX);
                System.out.println(targetY);
                break;

            case 18:
                FXMLController.p18Estatico.layoutXProperty().set(Math.random() * 413 + 627);
                FXMLController.p18Estatico.layoutYProperty().set(544);

                System.out.println(targetX);
                System.out.println(targetY);
                break;

            case 19:
                FXMLController.p19Estatico.layoutXProperty().set(Math.random() * 413 + 627);
                FXMLController.p19Estatico.layoutYProperty().set(544);

                System.out.println(targetX);
                System.out.println(targetY);
                break;

            case 20:
                FXMLController.p20Estatico.layoutXProperty().set(Math.random() * 413 + 627);
                FXMLController.p20Estatico.layoutYProperty().set(544);

                System.out.println(targetX);
                System.out.println(targetY);
                break;

            case 21:
                FXMLController.p21Estatico.layoutXProperty().set(Math.random() * 627 + 627);
                FXMLController.p21Estatico.layoutYProperty().set(544);

                System.out.println(targetX);
                System.out.println(targetY);
                break;

            case 22:
                FXMLController.p22Estatico.layoutXProperty().set(Math.random() * 413 + 627);
                FXMLController.p22Estatico.layoutYProperty().set(544);

                System.out.println(targetX);
                System.out.println(targetY);
                break;

            case 23:
                FXMLController.p23Estatico.layoutXProperty().set(Math.random() * 413 + 627);
                FXMLController.p23Estatico.layoutYProperty().set(544);

                System.out.println(targetX);
                System.out.println(targetY);
                break;

            case 24:
                FXMLController.p24Estatico.layoutXProperty().set(Math.random() * 413 + 627);
                FXMLController.p24Estatico.layoutYProperty().set(544);

                System.out.println(targetX);
                System.out.println(targetY);
                break;

            case 25:
                FXMLController.p25Estatico.layoutXProperty().set(Math.random() * 413 + 627);
                FXMLController.p25Estatico.layoutYProperty().set(544);

                System.out.println(targetX);
                System.out.println(targetY);
                break;

            case 26:
                FXMLController.p26Estatico.layoutXProperty().set(Math.random() * 413 + 627);
                FXMLController.p26Estatico.layoutYProperty().set(544);

                System.out.println(targetX);
                System.out.println(targetY);
                break;

            case 27:
                FXMLController.p27Estatico.layoutXProperty().set(Math.random() * 413 + 627);
                FXMLController.p27Estatico.layoutYProperty().set(544);

                System.out.println(targetX);
                System.out.println(targetY);
                break;

            case 28:
                FXMLController.p28Estatico.layoutXProperty().set(Math.random() * 413 + 627);
                FXMLController.p28Estatico.layoutYProperty().set(544);

                System.out.println(targetX);
                System.out.println(targetY);
                break;

            case 29:
                FXMLController.p29Estatico.layoutXProperty().set(Math.random() * 413 + 627);
                FXMLController.p29Estatico.layoutYProperty().set(544);

                System.out.println(targetX);
                System.out.println(targetY);
                break;

            case 30:
                FXMLController.p30Estatico.layoutXProperty().set(Math.random() * 413 + 627);
                FXMLController.p30Estatico.layoutYProperty().set(544);

                System.out.println(targetX);
                System.out.println(targetY);
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
    public void lancouDados() {
        FXMLController.lancardadosEstatico.setDisable(true);
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

    public void passouVez() {
        this.mudaVez();
    }

    public void pecasIndicativo(int id) {
        if (id == 0) {
            FXMLController.indicativoPecas1Estatico.setText("AS TUAS PEÇAS");
            FXMLController.indicativoPecas2Estatico.setText("PEÇAS DO ADVERSÁRIO");
        } else {
            FXMLController.indicativoPecas2Estatico.setText("AS TUAS PEÇAS");
            FXMLController.indicativoPecas1Estatico.setText("PEÇAS DO ADVERSÁRIO");
        }
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
            String labelText = "É a tua vez...";
            if (!this.minhavez) {
                labelText = "É a vez do adversário...";
            }
            FXMLController.labelVezEstatico.setText(labelText);
        });

    }

    public void mudaVez() {
        this.minhavez = !this.minhavez;
        lancouDados = false;

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
            String labelText = "É a tua vez...";
            if (!this.minhavez) {
                labelText = "É a vez do adversário...";
            }
            FXMLController.labelVezEstatico.setText(labelText);

        });
    }

    public boolean getMinhaVez() {
        return this.minhavez;
    }
}
