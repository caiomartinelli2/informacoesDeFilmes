package model;

import javax.imageio.IIOException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OmHelper {
    private String nomeDoFilme;
    private OmHelperlistener listener;


    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (nomeDoFilme != null) {
                String dadosDoFilme = pedirDadosDoFilmeUsandoConnectionManager(nomeDoFilme);
                if (listener != null)
                    listener.chegaramOsDadosDoFilme(dadosDoFilme);
            }
                System.out.println("Dentro do Runnable");
            }
        };

    public OmHelper() {
            nomeDoFilme = null;
        }

    public void setListener(OmHelperlistener listener) {
        this.listener = listener;
    }

    //Metodo que dispara a thread para solicitar os dados do filme ao servidor
    public void requisicaoDoFilmePeloNome(String nome){
            this.nomeDoFilme = nome;
            (new Thread(runnable)).start();
    }

    private String pedirDadosDoFilmeUsandoConnectionManager (String nomeDoFilme){

        List<String> requisicao = montarRequisicao(nomeDoFilme);
        String response = chamandoOConnectionManager(requisicao);

        return limparCabecalho (response);
    }


    private String limparCabecalho(String response) {
        int posicaoDaChave = response.indexOf('{');
        response = response.substring(posicaoDaChave);
        return response;
    }


    //Chama a conexão com o servidor
    private String chamandoOConnectionManager (List < String > requisicao) {
        String response = null;
        OmDBConnectionManager manager = new OmDBConnectionManager();

        try {
        response = manager.requisitarDados(requisicao);
         }
        catch (IOException e) {
            System.out.println("Excessao: " + e.getMessage());
        }

        return response;
    }
    // Monta a requisição para o servidor no formato aceito
    private List<String> montarRequisicao (String nomeDoFilme){
      ArrayList<String> requisicao = new ArrayList<>(1);

      nomeDoFilme = nomeDoFilme.replace(' ', '+');

      requisicao.add("GET /?t=" + nomeDoFilme + "&apikey=ab7b3040 HTTP/1.0");
      requisicao.add("Host: www.omdbapi.com");

      return requisicao;
    }

}