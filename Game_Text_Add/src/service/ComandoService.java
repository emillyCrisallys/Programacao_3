package service;

import jogo.Cena;
import jogo.Console;
import jogo.Item;
import jogo.Save;
import repository.SaveDAO;
import repository.CenaDAO;
import repository.ItemDAO;
import java.sql.*;
import java.util.List;

public class ComandoService {
    private final String[] comando;
    private final Console console;

    public ComandoService(String comandoBruto) {
        Console console = new Console();
        this.console = console;
        this.comando = comandoBruto.split(" ");

    }


    public Console help() {
        console.setMensagem("HELP: Mostra esta ajuda. \n" +
                "• START: Inicia o jogo\n" +
                "• USE:  Usa itens do inventário\n" +
                "• CHECK: Checa a descrição dos itens,  ou objetos da cena e abre objetos também \n" +
                "• GET : Pega o item e adiciona ao inventário\n" +
                "• INVENTORY: Mostra os itens presentes no inventario\n" +
                "• USE_WITH [adicionar nome do ITEM]: Realiza ação ao combinar itens.\n" +
                "• SAVE: Salva o jogo.\n" +
                "• LOAD: Carrega o jogo salvo.\n" +
                "• RESTART: Reinicia o jogo.\n"+
                "• EXIT: Sair do jogo.");
        return console;
    }

    public Console start() {
        try {
            Cena Cena = CenaDAO.findCenaById(1);
            console.setMensagem(" " + Cena.getDescricao());

            return console;
        } catch (Exception e) {
            e.printStackTrace();
            console.setMensagem("Erro ao iniciar o jogo");
            return console;
        }
    }

    public Console use() {

        try {


            if (comando.length < 2) {
                console.setMensagem("Digite o nome do item que você deseja usar:");


            } else if (comando[1].equalsIgnoreCase("chave")) {
                Cena Cena = CenaDAO.findCenaById(1);
                console.setMensagem(" " + Cena.getDescricao());


            } else if (comando[1].equalsIgnoreCase("vela")) {
                Cena Cena = CenaDAO.findCenaById(2);
                console.setMensagem(" " + Cena.getDescricao());
            } else if (comando[1].equalsIgnoreCase("interruptor")) {
                Cena Cena = CenaDAO.findCenaById(4);
                console.setMensagem(" " + Cena.getDescricao());
            } else if (comando[1].equalsIgnoreCase("livros")) {
                Cena Cena = CenaDAO.findCenaById(6);
                console.setMensagem(" " + Cena.getDescricao());
            } else if (comando[1].equalsIgnoreCase("chave do sotao")) {
                Cena Cena = CenaDAO.findCenaById(8);
                console.setMensagem(" " + Cena.getDescricao());
            } else if (comando[1].equalsIgnoreCase("adaga")) {
                Cena Cena = CenaDAO.findCenaById(10);
                console.setMensagem(" " + Cena.getDescricao());

            } else if (comando[1].equalsIgnoreCase("maquinas")) {
                Cena Cena = CenaDAO.findCenaById(11);
                console.setMensagem(" " + Cena.getDescricao());

            } else if (comando[1].equalsIgnoreCase("pe-de-cabra")) {
                Cena Cena = CenaDAO.findCenaById(12);
                console.setMensagem(" " + Cena.getDescricao());   
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return console;
    }

    public Console check() {
        try {
            if (comando.length < 2) {
                console.setMensagem("O comando está incorreto.(Exemplo:check-chave)");
                return console;
            } else if (comando[1].equalsIgnoreCase("chave")) {
                Item item = ItemDAO.checkItensInventario(1);
                console.setMensagem(" " + item.getName_Item());
            } else if (comando[1].equalsIgnoreCase("vela")) {
                Item item = ItemDAO.checkItensInventario(2);
                console.setMensagem(" " + item.getName_Item());

            } else if (comando[1].equalsIgnoreCase("mapa")) {
                Item item = ItemDAO.checkItensInventario(3);
                console.setMensagem(" " + item.getName_Item());
            } else if (comando[1].equalsIgnoreCase("livros")) {
                Item item = ItemDAO.checkItensInventario(6);
                console.setMensagem(item.getName_Item());
            } else if (comando[1].equalsIgnoreCase("chave sotao")) {
                Item item = ItemDAO.checkItensInventario(7);
                console.setMensagem(item.getName_Item());
            } else if (comando[1].equalsIgnoreCase("adaga")) {
                Item item = ItemDAO.checkItensInventario(8);
                console.setMensagem(item.getName_Item());

            } else if (comando[1].equalsIgnoreCase("interruptor")) {
                Cena Cena = CenaDAO.findCenaById(4);
                console.setMensagem(Cena.getDescricao());

            } else if (comando[1].equalsIgnoreCase("maquinas")) {
                Cena Cena = CenaDAO.findCenaById(11);
                console.setMensagem(Cena.getDescricao());

            } else if (comando[1].equalsIgnoreCase("pe-de-cabra")) {
                Cena Cena = CenaDAO.findCenaById(12);
                console.setMensagem(Cena.getDescricao());
            }

        } catch (Exception e) {
            e.printStackTrace();
            console.setMensagem("Erro ao checar item.");
        }
        return console;
    }

    public Console get() {
        try {
            if (comando.length < 2) {
                console.setMensagem("Digite o nome do item que você deseja adicionar ao inventário:");

            } else if (comando[1].equalsIgnoreCase("chave")) {
                Cena Cena = CenaDAO.findCenaById(1);
                console.setMensagem(" " + Cena.getDescricao());
                Item item = ItemDAO.addInventario(1, 1, 1, "chave");

            } else if (comando[1].equalsIgnoreCase("vela")) {
                Cena Cena = CenaDAO.findCenaById(2);
                console.setMensagem(" " + Cena.getDescricao());
                Item item = ItemDAO.addInventario(1, 2, 1, "vela");

            } else if (comando[1].equalsIgnoreCase("mapa")) {
                Cena Cena = CenaDAO.findCenaById(3);
                console.setMensagem(" " + Cena.getDescricao());
                Item item = ItemDAO.addInventario(1, 3, 1, "mapa");

            } else if (comando[1].equalsIgnoreCase("medalhao")) {
                Cena Cena = CenaDAO.findCenaById(5);
                console.setMensagem(" " + Cena.getDescricao());
                Item item = ItemDAO.addInventario(1, 4, 1, "medalhao");

            } else if (comando[1].equalsIgnoreCase("livros")) {
                Cena Cena = CenaDAO.findCenaById(6);
                console.setMensagem(" " + Cena.getDescricao());
                Item item = ItemDAO.addInventario(1, 5, 1, "livros");

            } else if (comando[1].equalsIgnoreCase("chave sotao")) {
                Cena Cena = CenaDAO.findCenaById(7);
                console.setMensagem(" " + Cena.getDescricao());
                Item item = ItemDAO.addInventario(1, 6, 1, "chave sotao");

            } else if (comando[1].equalsIgnoreCase("adaga")) {
                Cena Cena = CenaDAO.findCenaById(9);
                console.setMensagem(" " + Cena.getDescricao());
                Item item = ItemDAO.addInventario(1, 6, 1, "adaga");

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return console;
    }

    public Console inventory() {
        try {

            if (comando.length < 2) {
                console.setMensagem("Comando inválido. Tente novamente.");
            } else if (comando[1].equalsIgnoreCase("jogador")) {
                List<Item> inventario = ItemDAO.exibirInventario(1);
                StringBuilder itensInventario = new StringBuilder("Itens atribuidos ao inventário nessa cena:\n");
                for (Item item : inventario) {
                    itensInventario.append("---------------------------------------------\n-")
                            .append("Jogador ID: ").append(item.getItens_Jogador_id()).append("\n")
                            .append("Nome item: ").append(item.getName_Item()).append("\n")
                            .append("Quantidade: ").append(item.getQuant_Itens()).append("\n")
                            .append("---------------------------------------------\n");

                    console.setMensagem(itensInventario.toString());
                }
                if (inventario.isEmpty()) {
                    console.setMensagem("O inventário está vazio no momento");
                }


            }


        } catch (Exception e) {
            console.setMensagem("Erro ao listar os itens presentes no inventário.");
        }
        return console;
    }


    public Console save() {
        try {

            Save save = SaveDAO.novoJogo(1,1);
            console.setMensagem(save.getCena_atual_save().getDescricao());
            console.setId_Save(save.getId_Save());
            console.setMensagem("Jogo salvo com sucesso");
            return console;
        } catch (Exception e) {
            e.printStackTrace();
            console.setMensagem("Erro ao salvar jogo");
            return console;
        }
    }

    public Console load() {
        try {if (comando.length < 2){
            console.setMensagem("Digite load jogador para carregar jogo");
        } else if (comando[1].equalsIgnoreCase("jogador")) {
            Save save = SaveDAO.carregarJogo(5);
            console.setMensagem(" " + save.getId_Save());
            console.setMensagem(" " + save.getCena_atual_save());
            console.setMensagem("Jogo carregado com sucesso!");}
        } catch (Exception e) {
            console.setMensagem("Erro ao carregar o jogo.");
        }
        return console;
    }

    public Console restart() throws SQLException {
        try {
            Cena Cena = CenaDAO.findCenaById(1);
            console.setMensagem(" \"Jogo Reiniciado\" " + Cena.getDescricao());

        } catch (Exception e) {
            console.setMensagem("Erro ao reiniciar o jogo !!!");
        }
        return console;
    }



    public Console getResultadoConsole() {
        try {
            String primeiroComando = comando[0].toLowerCase();
            Console consoleResultado = null;

            if (primeiroComando.equals("help")) {
                consoleResultado = help();
            } else if (primeiroComando.equals("start")) {
                consoleResultado = start();
            } else if (primeiroComando.equals("use")) {
                consoleResultado = use();
            } else if (primeiroComando.equals("check")) {
                consoleResultado = check();
            } else if (primeiroComando.equals("get")) {
                consoleResultado = get();
            } else if (primeiroComando.equals("inventory")) {
                consoleResultado = inventory();
            } else if (primeiroComando.equals("save")) {
                consoleResultado = save();
            } else if (primeiroComando.equals("load")) {
                consoleResultado = load();
            } else if (primeiroComando.equals("restart")) {
                consoleResultado = restart();
            } else {
                console.setMensagem("Comando inválido");
                consoleResultado = console;
            }

            return consoleResultado;
        } catch (Exception e) {
            console.setMensagem("Comando inválido");
            return console;
        }
    }
}
