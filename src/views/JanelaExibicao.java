package views;

import model.OmHelper;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Criação da Janela de Exibição com o Título, Data de lançamento, Sinopse e poster
public class JanelaExibicao extends JFrame {


    public JLabel nome, dataDeLançamento, sinopse, poster;
    JButton voltar;
    private Color color;

    public JanelaPesquisa janelaPesquisaRef;

    public JanelaPesquisa getJanelaPesquisaRef() {
        return janelaPesquisaRef;
    }

    public void setJanelaPesquisaRef(JanelaPesquisa janelaPesquisaRef) {
        this.janelaPesquisaRef = janelaPesquisaRef;
    }

    public JanelaExibicao(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(1500,700);
        setVisible(true);
        setResizable(false);

        color = new Color(148,26,28);

        getContentPane().setBackground(color);

        setLayout(null);

        nome = new JLabel();
        dataDeLançamento = new JLabel();
        sinopse= new JLabel();
        poster = new JLabel();

        voltar = new JButton("VOLTAR");

        nome.setFont(new Font("AppleSDGothicNeo-Bold", Font.PLAIN, 30));
        dataDeLançamento.setFont(new Font("Serif", Font.PLAIN, 20));
        sinopse.setFont(new Font("Serif", Font.PLAIN, 17));

        add(nome);
        add(dataDeLançamento);
        add(sinopse);
        add(voltar);
        add(poster);

        nome.setBounds(5,10,500,30);
        dataDeLançamento.setBounds(5,40, 500,30);
        sinopse.setBounds(5,70, 10000,30);
        poster.setBounds(350,125, 400,500);
        voltar.setBounds(800,500, 100,50);


        nome.setForeground(Color.white);
        dataDeLançamento.setForeground(Color.white);
        sinopse.setForeground(Color.white);


        // Adiciona os listener para o botão de voltar para a tela de pesquisa
        voltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janelaPesquisaRef.setVisible(true);
                setVisible(false);
            }
        });

    }

    public OmHelper helper;

    public OmHelper getHelper() {
        return helper;
    }

    public void setHelper(OmHelper helper) {
        this.helper = helper;
    }








}
