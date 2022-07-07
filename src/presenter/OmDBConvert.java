package presenter;

import model.OmHelperlistener;
import views.JanelaExibicao;
import views.JanelaPesquisa;
import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import javax.swing.ImageIcon;



public class OmDBConvert implements OmHelperlistener{

    public JanelaPesquisa janelaPesquisaRef;

    public void setJanelaPesquisaRef(JanelaPesquisa janelaPesquisaRef) {
        this.janelaPesquisaRef = janelaPesquisaRef;
    }

    public JanelaExibicao janelaExibicaoRef;



    public void setJanelaExibicaoRef(JanelaExibicao janelaExibicaoRef) {
        this.janelaExibicaoRef = janelaExibicaoRef;
    }

    //Recebe os dados do filme e procura os valores desejados
    private String procurarValorPorChave(String chave, String dadosDoFilme){
        String valorDaChave;

        int posicaoInicial = dadosDoFilme.indexOf("\"" + chave + "\":\"") + chave.length() + 4;
        int posicaoFinal = dadosDoFilme.indexOf("\",\"", posicaoInicial);

        valorDaChave = dadosDoFilme.substring(posicaoInicial , posicaoFinal);

        System.out.println(valorDaChave);

        return valorDaChave;


    }

    // Capta o poster que é recebido do servidor
    private Image procurarImagemUrl (String poster){

        Image imagem = null;/* w  ww .  ja  v  a 2 s.c o m*/

        URL url;
        try {
            url = new URL(poster);
            imagem = ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imagem;
    }

    // Insere os valores que vão ser encontrados pela função em váriaveis
    @Override
    public void chegaramOsDadosDoFilme(String dadosDoFilme) {
        System.out.println(dadosDoFilme + "\n");
        String titulo, lancamento,sinopse, poster;

        titulo =  procurarValorPorChave("Title", dadosDoFilme);
        lancamento = procurarValorPorChave("Released", dadosDoFilme);
        sinopse = procurarValorPorChave("Plot", dadosDoFilme);
        poster = procurarValorPorChave("Poster", dadosDoFilme);

        Image imagemDoPoster = procurarImagemUrl(poster);

        janelaExibicaoRef.setJanelaPesquisaRef(janelaPesquisaRef);
        janelaExibicaoRef.setVisible (true);
        janelaExibicaoRef.nome.setText("\n" + titulo);
        janelaExibicaoRef.dataDeLançamento.setText(lancamento + "\n");
        janelaExibicaoRef.sinopse.setText(sinopse + "\n");
        janelaExibicaoRef.poster.setIcon(new ImageIcon(imagemDoPoster));
    }

}

