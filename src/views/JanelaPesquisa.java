package views;

import model.OmHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Criação da Janela de pesquisa
public class JanelaPesquisa extends JFrame {
         private JTextField item1 = new JTextField(30);
         JLabel texto1, título;
         JButton buscar, limpar;
         private Color color;

         public JanelaPesquisa() {
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            color = new Color(148,26,28);

            getContentPane().setBackground(color);

            setSize(1200,500);

            setLayout(new FlowLayout(FlowLayout.CENTER));

            texto1 = new JLabel("Dígite o nome do Filme ou Série em inglês: ");
            buscar = new JButton("Enter");
            limpar = new JButton(("Limpar texto"));


            texto1.setForeground(Color.white);

            add(texto1);
            add(item1);
            add(buscar);
            add(limpar);


            // Adiciona os listener para o botão de limpar a caixa de texto e o buscar, disparando a requisição para a API
            limpar.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                item1.setText("");
            }
            });

            buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nomeDoFilmeDigitado = item1.getText();
                System.out.println(nomeDoFilmeDigitado);
                helper.requisicaoDoFilmePeloNome(nomeDoFilmeDigitado);

                setVisible(false);
            }
        });
     }
     OmHelper helper;

    public OmHelper getHelper() {
        return helper;
    }
    public void setHelper(OmHelper helper) {
        this.helper = helper;
    }
}
