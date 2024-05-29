/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tabula;


import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bruno
 */

public class GameServer {

    private ServerSocket ss;
    private int numPlayers;
    private int turnsMade;
    private int maxTurns;
    private int[] values;

    private static int port = 6666, nClientes = 1;
    // lista de jogadores disponíveis
    public static List<ClientHandler> listaClientes = new ArrayList<>();
    // número de jogadores a jogar
    static int njogadores = 0;
    // id atribuido a um novo cliente
    static int id = 0;
    private static Socket s;
    static boolean minhavez = true;

    static Casa[] casas = new Casa[24];

    static Casa casa1 = new Casa(1);
    static Casa casa2 = new Casa(2);
    static Casa casa3 = new Casa(3);
    static Casa casa4 = new Casa(4);
    static Casa casa5 = new Casa(5);
    static Casa casa6 = new Casa(6);
    static Casa casa7 = new Casa(7);
    static Casa casa8 = new Casa(8);
    static Casa casa9 = new Casa(9);
    static Casa casa10 = new Casa(10);
    static Casa casa11 = new Casa(11);
    static Casa casa12 = new Casa(12);
    static Casa casa13 = new Casa(13);
    static Casa casa14 = new Casa(14);
    static Casa casa15 = new Casa(15);
    static Casa casa16 = new Casa(16);
    static Casa casa17 = new Casa(17);
    static Casa casa18 = new Casa(18);
    static Casa casa19 = new Casa(19);
    static Casa casa20 = new Casa(20);
    static Casa casa21 = new Casa(21);
    static Casa casa22 = new Casa(22);
    static Casa casa23 = new Casa(23);
    static Casa casa24 = new Casa(24);

    public static void main(String[] args) throws IOException {
        System.out.println("Servidor aceita conexoes (a escuta na porta " + port + ") .");
        ServerSocket ss = new ServerSocket(port);

        Thread servidor = new Thread(() -> {

            while (true) {
                try {
                    s = ss.accept();

                    DataInputStream dis = new DataInputStream(s.getInputStream());
                    DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                    ObjectInputStream in = new ObjectInputStream(s.getInputStream());
                    ObjectOutputStream objOut = new ObjectOutputStream(s.getOutputStream());

                    System.out.println("Novo client recebido : " + s);
                    ClientHandler mtch = new ClientHandler(s, "client " + id, dis, dos, id, in, objOut, minhavez);

                    Thread t = new Thread(mtch);

                    listaClientes.add(mtch);
                    dos.writeUTF("nomeJogador" + mtch.code);
                    dos.writeUTF(Boolean.toString(minhavez));
                    String idNome = Integer.toString(id);
                    t.setName(idNome);

                    t.start();

                    njogadores++;
                    id++;

                    minhavez = false;
                    System.out.println("Adiciona cliente " + id + " à lista ativa." + s.getInetAddress());

                } catch (IOException ex) {
                    Logger.getLogger(GameServer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        servidor.start();
    }

    public static class ClientHandler implements Runnable {

        private String code;
        private String nome;
        final DataInputStream dis;
        final DataOutputStream dos;
        Socket s;
        boolean isloggedin;
        final int id;
        ObjectInputStream in;
        ObjectOutputStream objOut;
        private boolean prontoJogar;
        private boolean jogoTerminado;
        boolean minhavez;

        public ArrayList<Peca> pecas = new ArrayList<Peca>(15);
        public ArrayList<Peca> pecasAtacadas = new ArrayList<Peca>(15);
        public ArrayList<Peca> pecasRetiradas = new ArrayList<Peca>(15);
        boolean ganhou = false;

        private ClientHandler(Socket s, String string,
                DataInputStream dis, DataOutputStream dos, int id, ObjectInputStream in, ObjectOutputStream objOut, boolean minhavez) {
            this.s = s;
            this.dis = dis;
            this.dos = dos;
            this.code = string;
            this.id = id;
            this.isloggedin = true;
            this.in = in;
            this.objOut = objOut;
            this.nome = null;
            this.prontoJogar = false;
            this.jogoTerminado = false;
            this.minhavez = minhavez;

            geraPecas(id);
        }
        static String recebido;

        private void geraPecas(int playerID) {
            casas[0] = casa1;
            casas[1] = casa2;
            casas[2] = casa3;
            casas[3] = casa4;
            casas[4] = casa5;
            casas[5] = casa6;
            casas[6] = casa7;
            casas[7] = casa8;
            casas[8] = casa9;
            casas[9] = casa10;
            casas[10] = casa11;
            casas[11] = casa12;
            casas[12] = casa13;
            casas[13] = casa14;
            casas[14] = casa15;
            casas[15] = casa16;
            casas[16] = casa17;
            casas[17] = casa18;
            casas[18] = casa19;
            casas[19] = casa20;
            casas[20] = casa21;
            casas[21] = casa22;
            casas[22] = casa23;
            casas[23] = casa24;
            if (playerID == 0) {

                Peca peca1;
                Peca peca2;
                Peca peca3;
                Peca peca4;
                Peca peca5;
                Peca peca6;
                Peca peca7;
                Peca peca8;
                Peca peca9;
                Peca peca10;
                Peca peca11;
                Peca peca12;
                Peca peca13;
                Peca peca14;
                Peca peca15;
                peca1 = new Peca(1);
                peca2 = new Peca(2);
                peca3 = new Peca(3);
                peca4 = new Peca(4);
                peca5 = new Peca(5);
                peca6 = new Peca(6);
                peca7 = new Peca(7);
                peca8 = new Peca(8);
                peca9 = new Peca(9);
                peca10 = new Peca(10);
                peca11 = new Peca(11);
                peca12 = new Peca(12);
                peca13 = new Peca(13);
                peca14 = new Peca(14);
                peca15 = new Peca(15);

                pecas.add(peca1);
                pecas.add(peca2);
                pecas.add(peca3);
                pecas.add(peca4);
                pecas.add(peca5);
                pecas.add(peca6);
                pecas.add(peca7);
                pecas.add(peca8);
                pecas.add(peca9);
                pecas.add(peca10);
                pecas.add(peca11);
                pecas.add(peca12);
                pecas.add(peca13);
                pecas.add(peca14);
                pecas.add(peca15);
                System.out.println("PECAS criadas player 1: " + pecas.get(0).id);

            } else if (playerID == 1) {

                Peca peca16;
                Peca peca17;
                Peca peca18;
                Peca peca19;
                Peca peca20;
                Peca peca21;
                Peca peca22;
                Peca peca23;
                Peca peca24;
                Peca peca25;
                Peca peca26;
                Peca peca27;
                Peca peca28;
                Peca peca29;
                Peca peca30;
                peca16 = new Peca(16);
                peca17 = new Peca(17);
                peca18 = new Peca(18);
                peca19 = new Peca(19);
                peca20 = new Peca(20);
                peca21 = new Peca(21);
                peca22 = new Peca(22);
                peca23 = new Peca(23);
                peca24 = new Peca(24);
                peca25 = new Peca(25);
                peca26 = new Peca(26);
                peca27 = new Peca(27);
                peca28 = new Peca(28);
                peca29 = new Peca(29);
                peca30 = new Peca(30);

                pecas.add(peca16);
                pecas.add(peca17);
                pecas.add(peca18);
                pecas.add(peca19);
                pecas.add(peca20);
                pecas.add(peca21);
                pecas.add(peca22);
                pecas.add(peca23);
                pecas.add(peca24);
                pecas.add(peca25);
                pecas.add(peca26);
                pecas.add(peca27);
                pecas.add(peca28);
                pecas.add(peca29);
                pecas.add(peca30);
                System.out.println("PECAS criadas player 2: " + pecas.get(0));
            }
        }

        // verifica se os jogadores estão prontos para jogar
        private boolean verificaJogadoresProntos() {
            boolean result = true;
            if (GameServer.njogadores < 2) {
                result = false;
            } else {
                for (ClientHandler c : GameServer.listaClientes) {
                    if (!c.prontoJogar) { //verifica se o c.prontoJogar é false
                        result = false;
                    }
                }
            }
            return result;
        }

        // devolve o nome do outro jogador
        private String getNomeOutroJogador(String codeJogador) {
            String result = "";
            for (ClientHandler c : GameServer.listaClientes) {
                if (!c.code.equals(codeJogador)) {
                    result = c.nome;
                }
            }
            return result;
        }

        public boolean geraVez() {
            boolean result = false;
            Random r = new Random();
            int random = r.nextInt();
            if (random % 2 == 0) {
                result = true;
            }
            return result;
        }

        @Override
        public void run() {

            if (GameServer.njogadores > 2) {
                try {
                    System.out.println("Avisar que sala está cheia e remover jogador..");
                    dos.writeUTF("#salacheia");
                    this.isloggedin = false;
                    GameServer.listaClientes.remove(this);
                    GameServer.njogadores--;
                    this.s.close();
                    return;
                } catch (Exception e) {
                };
            }
            Thread cliente = new Thread(() -> {
                while (true) {

                    try {
                        recebido = dis.readUTF();

                        if (recebido.startsWith("#dados")) {
                            // #nome-nomeJogador

                            String[] msgSplit = recebido.split("-");

                            for (ClientHandler client : GameServer.listaClientes) {

                                System.out.println("Mensagem a ser enviada: " + recebido);
                                client.dos.writeUTF(recebido);
                            }
                        } else if (recebido.startsWith("#nome")) {
                            // #nome-nomeJogador

                            boolean vez = this.geraVez();
                            for (ClientHandler client : GameServer.listaClientes) {
                                if (!client.code.equals(code) && client.isloggedin) {
                                    String message = "#nome-" + !vez;
                                    System.out.println("Mensagem a ser enviada: " + message);
                                    client.dos.writeUTF(message);
                                } else {
                                    String message = "#nome-" + vez;
                                    System.out.println("Mensagem a ser enviada: " + message);
                                    client.dos.writeUTF(message);
                                }
                            }
                        } else if (recebido.startsWith("#vez")) {
                            for (ClientHandler client : GameServer.listaClientes) {
                                client.dos.writeUTF(recebido);
                            }
                        } else if (recebido.startsWith("#jogada")) {
                            String[] msgSplit = recebido.split("-");
                            String peca = msgSplit[1];
                            int mover = Integer.parseInt(msgSplit[2]);
                            int player_id_jogada = Integer.parseInt(msgSplit[3]);
                            boolean pecaMovida = false;

                            String enviar = "";
                            for (ClientHandler client : GameServer.listaClientes) {
                                if (client.id == player_id_jogada) {
                                    System.out.println("0");
                                    //verificar se a peca está em jogo
                                    boolean estaEmJogo = false;
                                    boolean existePeca = false;
                                    boolean podeMover = true;
                                    boolean podeAtacar = false;
                                    boolean pecaAtacadaMovida = false;
                                    boolean podeMover2Etapa = false;

                                    int pecaAtacadaIndex = 0;
                                    Peca pecaAtacadaId = new Peca();
                                    Peca pecaAtacadaParaMover = new Peca();
                                    Peca pecaEscolhidaParaMover = new Peca();
                                    Peca pecaEscolhida = new Peca();
                                    int count = 0;
                                    System.out.println(client.pecas);
                                    System.out.println("Tamanho do array peças atacadas" + client.pecasAtacadas.size());
                                    if (client.pecasAtacadas.isEmpty()) {

                                        if (client.pecas.isEmpty()) {
                                            podeMover2Etapa = true;
                                        }
                                        for (Peca pecaEscolhida2 : client.pecas) {

                                            if (pecaEscolhida2.id == Integer.parseInt(peca)) {
                                                
                                                pecaEscolhida = pecaEscolhida2;
                                                existePeca = true;
                                            }
                                        }

                                        for (Casa casa : casas) {
                                            
                                            for (Peca pecaa : casa.posicao) {
                                               
                                                if (pecaa.id == Integer.parseInt(peca)) {
                                                    pecaEscolhida = pecaa;
                                                    existePeca = true;
                                                    break;
                                                }
                                            }
                                        }
                                        if (existePeca) {
                                            System.out.println("1");

                                            for (Casa casa : casas) {
                                                if (!pecaMovida) {

                                                    if (casa.posicao.contains(pecaEscolhida)) {
                                                        estaEmJogo = true;
                                                        System.out.println("2");
                                                        if (player_id_jogada == 0) {
                                                            System.out.println("3");

                                                            System.out.println("5");
                                                            if (casa.id + mover > 24) {
                                                                casa.posicao.remove(pecaEscolhida);
                                                                client.pecasRetiradas.add(pecaEscolhida);
                                                                enviar = "#retirarpeca" + "-" + peca + '-' + String.valueOf(mover);
                                                                pecaMovida = true;
                                                            } else {

                                                                if (!casas[casa.id + mover - 1].posicao.isEmpty()) {
                                                                    for (int i = 0; i < casas[casa.id + mover - 1].posicao.size(); i++) {
                                                                        if (casas[casa.id + mover - 1].posicao.get(i) != null) {
                                                                            if (casas[casa.id + mover - 1].posicao.get(i).id > 15) {
                                                                                pecaAtacadaId = casas[casa.id + mover - 1].posicao.get(i);
                                                                                pecaAtacadaIndex = i;
                                                                                count++;
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            if (count >= 2) {
                                                                podeMover = false;
                                                            } else if (count == 1) {
                                                                podeMover = true;
                                                                podeAtacar = true;
                                                            } else if (count == 0) {
                                                                podeMover = true;
                                                            }
                                                        } else if (player_id_jogada == 1) {

                                                            //mudar
                                                            System.out.println("5");
                                                            System.out.println("5");
                                                            if (casa.id + mover > 24) {
                                                                casa.posicao.remove(pecaEscolhida);
                                                                client.pecasRetiradas.add(pecaEscolhida);
                                                                enviar = "#retirapeca" + "-" + peca;
                                                                pecaMovida = true;
                                                            } else {
                                                                if (!casas[casa.id + mover - 1].posicao.isEmpty()) {
                                                                    for (int i = 0; i < casas[casa.id + mover - 1].posicao.size(); i++) {
                                                                        if (casas[casa.id + mover - 1].posicao.get(i) != null) {
                                                                            if (casas[casa.id + mover - 1].posicao.get(i).id <= 15) {
                                                                                pecaAtacadaId = casas[casa.id + mover - 1].posicao.get(i);
                                                                                pecaAtacadaIndex = i;
                                                                                count++;
                                                                            }
                                                                        }
                                                                    }
                                                                }

                                                            }
                                                            if (count >= 2) {
                                                                podeMover = false;
                                                            } else if (count == 1) {
                                                                podeMover = true;
                                                                podeAtacar = true;
                                                            } else if (count == 0) {
                                                                podeMover = true;
                                                            }
                                                        }
                                                        if (podeMover) {
                                                            if (podeAtacar) {
                                                                for (ClientHandler clientt : GameServer.listaClientes) {
                                                                    if (clientt.id != player_id_jogada) {

                                                                        if (casa.id + mover - 1 <= 12) {
                                                                            casas[casa.id + mover - 1].posicao.remove(casas[casa.id + mover - 1].posicao.get(pecaAtacadaIndex));
                                                                            System.out.println("REMOVIDA PECA-" + pecaAtacadaId.id + "do PLAYER " + clientt.id);

                                                                            System.out.println("array das atacadas antes de adicionar " + clientt.pecasAtacadas);

                                                                            clientt.pecasAtacadas.add(pecaAtacadaId);
                                                                            System.out.println("tamanho array peças atacadas" + client.pecasAtacadas.size());
                                                                            System.out.println("array das atacadas depois de adicionar " + clientt.pecasAtacadas);
                                                                            System.out.println("ADICIONADA NAS ATACADAS-" + pecaAtacadaId.id + "do PLAYER " + clientt.id);

                                                                            pecaEscolhidaParaMover = pecaEscolhida;
                                                                            casas[casa.id + mover - 1].posicao.add(pecaEscolhida);
                                                                            enviar = "#jogada" + "-" + peca + "-" + String.valueOf(mover) + "-" + String.valueOf(casa.id + mover) + '-' + pecaAtacadaId.id + '-' + podeMover2Etapa;
                                                                            pecaMovida = true;
                                                                        } else {
                                                                            if (podeMover2Etapa) {
                                                                                casas[casa.id + mover - 1].posicao.remove(casas[casa.id + mover - 1].posicao.get(pecaAtacadaIndex));
                                                                                System.out.println("REMOVIDA PECA-" + pecaAtacadaId.id + "do PLAYER " + clientt.id);

                                                                                System.out.println("array das atacadas antes de adicionar " + clientt.pecasAtacadas);

                                                                                clientt.pecasAtacadas.add(pecaAtacadaId);
                                                                                System.out.println("tamanho array peças atacadas" + client.pecasAtacadas.size());
                                                                                System.out.println("array das atacadas depois de adicionar " + clientt.pecasAtacadas);
                                                                                System.out.println("ADICIONADA NAS ATACADAS-" + pecaAtacadaId.id + "do PLAYER " + clientt.id);

                                                                                pecaEscolhidaParaMover = pecaEscolhida;
                                                                                casas[casa.id + mover - 1].posicao.add(pecaEscolhida);
                                                                                enviar = "#jogada" + "-" + peca + "-" + String.valueOf(mover) + "-" + String.valueOf(casa.id + mover) + '-' + pecaAtacadaId.id + '-' + podeMover2Etapa;
                                                                                pecaMovida = true;
                                                                            }
                                                                        }

                                                                    }
                                                                }
                                                            } else {
                                                                if (casa.id + mover <= 24) {
                                                                    if (casa.id + mover - 1 <= 12) {
                                                                        System.out.println("7");

                                                                        casa.posicao.remove(pecaEscolhida);
                                                                        System.out.println("peça removida da casa" + casa.id);
                                                                        casas[casa.id + mover - 1].posicao.add(pecaEscolhida);
                                                                        pecaMovida = true;
                                                                        enviar = "#jogada" + "-" + peca + "-" + String.valueOf(mover) + "-" + String.valueOf(casa.id + mover) + '-' + pecaAtacadaId.id + '-' + podeMover2Etapa;
                                                                    } else {
                                                                        if (podeMover2Etapa) {
                                                                            System.out.println("7");

                                                                            casa.posicao.remove(pecaEscolhida);
                                                                            System.out.println("peça removida da casa" + casa.id);
                                                                            casas[casa.id + mover - 1].posicao.add(pecaEscolhida);
                                                                            pecaMovida = true;
                                                                            enviar = "#jogada" + "-" + peca + "-" + String.valueOf(mover) + "-" + String.valueOf(casa.id + mover) + '-' + pecaAtacadaId.id + '-' + podeMover2Etapa;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                            if (!estaEmJogo) {
                                                if (player_id_jogada == 0) {
                                                    System.out.println("3");

                                                    System.out.println("fora de jogo - à procura de pecas para atacar");
                                                    System.out.println(casas[mover - 1].posicao.isEmpty());
                                                    if (!casas[mover - 1].posicao.isEmpty()) {
                                                        for (int i = 0; i < casas[mover - 1].posicao.size(); i++) {
                                                            System.out.println("encontrada");
                                                            if (casas[mover - 1].posicao.get(i) != null) {
                                                                if (casas[mover - 1].posicao.get(i).id > 15) {
                                                                    pecaAtacadaId = casas[mover - 1].posicao.get(i);
                                                                    System.out.println("peca para atacar encontrada - " + pecaAtacadaId);
                                                                    pecaAtacadaIndex = i;
                                                                    count++;
                                                                }
                                                            }
                                                        }
                                                    }
                                                    if (count >= 2) {
                                                        podeMover = false;
                                                    } else if (count == 1) {
                                                        podeMover = true;
                                                        podeAtacar = true;
                                                    } else if (count == 0) {
                                                        podeMover = true;
                                                    }
                                                } else if (player_id_jogada == 1) {
                                                    //mudar
                                                    System.out.println("5");

                                                    System.out.println("fora de jogo - à procura de pecas para atacar");
                                                    System.out.println(casas[mover - 1].posicao.isEmpty());
                                                    if (!casas[mover - 1].posicao.isEmpty()) {
                                                        System.out.println("encontrada");
                                                        for (int i = 0; i < casas[mover - 1].posicao.size(); i++) {

                                                            if (casas[mover - 1].posicao.get(i).id <= 15) {
                                                                pecaAtacadaId = casas[mover - 1].posicao.get(i);
                                                                System.out.println("peca para atacar encontrada - " + pecaAtacadaId);
                                                                pecaAtacadaIndex = i;
                                                                count++;
                                                            }

                                                        }
                                                    }

                                                    if (count >= 2) {
                                                        podeMover = false;
                                                    } else if (count == 1) {
                                                        podeMover = true;
                                                        podeAtacar = true;
                                                    } else if (count == 0) {
                                                        podeMover = true;
                                                    }
                                                }
                                                if (podeMover) {
                                                    if (podeAtacar) {
                                                        for (ClientHandler clientt : GameServer.listaClientes) {
                                                            if (clientt.id != player_id_jogada) {

                                                                System.out.println("array da posicao antes de remover " + casas[mover - 1].posicao);
                                                                casas[mover - 1].posicao.remove(casas[mover - 1].posicao.get(pecaAtacadaIndex));
                                                                System.out.println("array da posicao depois de remover " + casas[mover - 1].posicao);
                                                                System.out.println("REMOVIDA PECA-" + pecaAtacadaId.id + "do PLAYER " + clientt.id);

                                                                System.out.println("array das atacadas antes de adicionar " + clientt.pecasAtacadas);

                                                                clientt.pecasAtacadas.add(pecaAtacadaId);
                                                                System.out.println("array das atacadas depois de adicionar " + clientt.pecasAtacadas);
                                                                System.out.println("ADICIONADA NAS ATACADAS-" + pecaAtacadaId.id + "do PLAYER " + clientt.id);

                                                                pecaEscolhidaParaMover = pecaEscolhida;
                                                                casas[mover - 1].posicao.add(pecaEscolhida);
                                                                enviar = "#jogada" + "-" + peca + "-" + String.valueOf(mover) + "-" + String.valueOf(mover) + '-' + pecaAtacadaId.id + '-' + podeMover2Etapa;
                                                                pecaMovida = true;
                                                            }
                                                        }
                                                    } else {
                                                        System.out.println("8");
                                                        pecaEscolhidaParaMover = pecaEscolhida;
                                                        casas[mover - 1].posicao.add(pecaEscolhida);
                                                        System.out.println(casas[mover - 1].posicao);
                                                        enviar = "#jogada" + "-" + peca + "-" + String.valueOf(mover) + "-" + String.valueOf(mover) + '-' + pecaAtacadaId.id + '-' + podeMover2Etapa;
                                                        pecaMovida = true;
                                                    }
                                                }
                                            }

                                        }

                                    } else {
                                        System.out.println("Existem pecas atacadas para jogar primeiro");
                                        if (!pecaAtacadaMovida) {

                                            for (Peca pecaAttacked : client.pecasAtacadas) {
                                                System.out.println("À procura da peca atacada");
                                                System.out.println("id das peças no array das atacadas" + pecaAttacked.id);
                                                if (pecaAttacked.id == Integer.parseInt(peca)) {

                                                    System.out.println("encontrada");

                                                    pecaAtacadaParaMover = pecaAttacked;
                                                    System.out.println("removida do array das atacadas");
                                                    if (player_id_jogada == 0) {
                                                        System.out.println("3");

                                                        System.out.println("tou aqui bro");
                                                        System.out.println(casas[mover - 1].posicao.isEmpty());
                                                        if (!casas[mover - 1].posicao.isEmpty()) {
                                                            for (int i = 0; i < casas[mover - 1].posicao.size(); i++) {
                                                                System.out.println("estou aqui");
                                                                
                                                                if (casas[mover - 1].posicao.get(i) != null) {
                                                                    if (casas[mover - 1].posicao.get(i).id > 15) {
                                                                        pecaAtacadaId = casas[mover - 1].posicao.get(i);
                                                                        pecaAtacadaIndex = i;
                                                                        count++;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        if (count >= 2) {
                                                            podeMover = false;
                                                        } else if (count == 1) {
                                                            podeMover = true;
                                                            podeAtacar = true;
                                                        } else if (count == 0) {
                                                            podeMover = true;
                                                        }
                                                    } else if (player_id_jogada == 1) {
                                                        //mudar
                                                        
                                                        System.out.println(casas[mover - 1].posicao.isEmpty());
                                                        if (!casas[mover - 1].posicao.isEmpty()) {
                                                            
                                                            for (int i = 0; i < casas[mover - 1].posicao.size(); i++) {
                                                                
                                                                if (casas[mover - 1].posicao.get(i).id <= 15) {
                                                                    pecaAtacadaId = casas[mover - 1].posicao.get(i);
                                                                    pecaAtacadaIndex = i;
                                                                    count++;
                                                                }

                                                            }
                                                        }

                                                        if (count >= 2) {
                                                            podeMover = false;
                                                        } else if (count == 1) {
                                                            podeMover = true;
                                                            podeAtacar = true;
                                                        } else if (count == 0) {
                                                            podeMover = true;
                                                        }
                                                    }
                                                    if (podeMover) {
                                                        if (podeAtacar) {
                                                            for (ClientHandler clientt : GameServer.listaClientes) {
                                                                if (clientt.id != player_id_jogada) {
                                                                    casas[mover - 1].posicao.remove(casas[mover - 1].posicao.get(pecaAtacadaIndex));
                                                                    System.out.println("REMOVIDA PECA-" + pecaAtacadaId.id + "do PLAYER " + clientt.id);

                                                                    System.out.println("array das atacadas antes de adicionar " + clientt.pecasAtacadas);

                                                                    clientt.pecasAtacadas.add(pecaAtacadaId);
                                                                    System.out.println("array das atacadas depois de adicionar " + clientt.pecasAtacadas);
                                                                    System.out.println("ADICIONADA NAS ATACADAS-" + pecaAtacadaId.id + "do PLAYER " + clientt.id);

                                                                    pecaEscolhidaParaMover = pecaEscolhida;

                                                                    casas[mover - 1].posicao.add(pecaAttacked);
                                                                    enviar = "#jogada" + "-" + peca + "-" + String.valueOf(mover) + "-" + String.valueOf(mover) + '-' + pecaAtacadaId.id + '-' + podeMover2Etapa;
                                                                    pecaAtacadaMovida = true;
                                                                    pecaMovida = true;
                                                                }
                                                            }
                                                        } else {
                                                            System.out.println("8");
                                                            casas[mover - 1].posicao.add(pecaAttacked);
                                                            System.out.println("movida peca atacada para posicao  " + casas[mover - 1]);
                                                            System.out.println(casas[mover - 1].posicao);
                                                            enviar = "#jogada" + "-" + peca + "-" + String.valueOf(mover) + "-" + String.valueOf(mover) + '-' + pecaAtacadaId.id + '-' + podeMover2Etapa;
                                                            pecaAtacadaMovida = true;
                                                            pecaMovida = true;
                                                        }

                                                    }

                                                }
                                            }
                                            if (pecaAtacadaMovida) {
                                                client.pecasAtacadas.remove(pecaAtacadaParaMover);
                                            }

                                        }
                                    }
                                    if (pecaMovida) {

                                        System.out.println("array pecas" + client.pecas.size());
                                        client.pecas.remove(pecaEscolhidaParaMover);
                                        System.out.println("array pecas" + client.pecas.size());
                                    }
                                }
                                if (client.pecasRetiradas.size() == 15) {
                                        
                                        if(client.id == 0){
                                            enviar = "#ganhou" +'-' + 0 + '-' + 1;
                                        }else{
                                             enviar = "#ganhou" +'-' + 1 + '-' + 0;
                                        }
                                   
                                    //jogoInstancia.ganhou(client.id);
                                }

                            }
                            for (ClientHandler client : GameServer.listaClientes) {
                                client.dos.writeUTF(enviar);
                            }
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            cliente.start();

        }
    }
}
