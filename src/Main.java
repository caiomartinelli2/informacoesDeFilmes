import com.sun.security.auth.module.JndiLoginModule;
import model.OmHelper;
import model.OmHelperlistener;
import presenter.OmDBConvert;
import views.JanelaExibicao;
import views.JanelaPesquisa;

public class Main {
    public static void main(String[] args) {
        OmHelper helper= new OmHelper();
        OmDBConvert conversor = new OmDBConvert();

        helper.setListener(conversor);

        JanelaPesquisa janela1 = new JanelaPesquisa();
        conversor.setJanelaPesquisaRef(janela1);
        janela1.setVisible(true);
        janela1.setHelper(helper);

        JanelaExibicao janela2 = new JanelaExibicao();
        conversor.setJanelaExibicaoRef(janela2);
        janela2.setVisible(false);


        System.out.println("Terminando o main");

    }


}
