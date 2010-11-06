package gui;


import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;


/**
 * @author Alfeu Buriti Pereira Júnior.
 * @author Brunno José Guimarães de Almeida.
 * @author Otacilio Freitas de Lacerda
 */
public class FrameAbout extends JInternalFrame {

    private static final long serialVersionUID = -5319776206787609374L;

    private JPanel panelAbout;

    private JLabel textProjetoBase;
    private JLabel textProjetoAtual;

    private JList listProjetoBase;
    private JList listProjetoAtual;

    @SuppressWarnings("unused")
    private MSNLab msnlab;

    public FrameAbout(MSNLab msnlab) {
        super("About");
        this.msnlab = msnlab;

        initialize();
        positions();
        actions();
        makeScreen();
    }

    private void initialize() {
        setClosable(true);
        setSize(400, 480);

        panelAbout = new JPanel();
        panelAbout.setLayout(null);
        panelAbout.setBorder(new EtchedBorder());

        textProjetoBase = new JLabel("Projeto Base");
        textProjetoAtual = new JLabel("On the Fourth Order Root Finding Methods of Euller's Type");
        listProjetoBase = new JList();
        listProjetoAtual = new JList();

        Vector<String> vetorProjetoBase = new Vector<String>();
        vetorProjetoBase.add("Alfeu Buriti Pereira Júnior");
        vetorProjetoBase.add("Brunno José Guimarães de Almeida");
        vetorProjetoBase.add("Rodrigo Barbosa Lira");
        vetorProjetoBase.add("Samuel de Barros Florentino");
        vetorProjetoBase.add("Erick Moreno Marques Almeida");
        vetorProjetoBase.add("Andrea Alves Nascimento");
        vetorProjetoBase.add("Álvaro Magnum Barbosa Neto");
        vetorProjetoBase.add("Marcus Vinícius Mesquita Leite");
        vetorProjetoBase.add("Jaindson Valentim Santana");
        vetorProjetoBase.add("Edigley Pereira Fraga");
        vetorProjetoBase.add("Jaluska Rodrigues de Almeida");
        vetorProjetoBase.add("Eugênia de Sousa Cavalcanti");
        vetorProjetoBase.add("Davi Oliveira Fernandes");
        vetorProjetoBase.add("Vinícius Aguiar");
        vetorProjetoBase.add("Marcus Williams A. de Carvalho");
        vetorProjetoBase.add("Carla Souza");
        vetorProjetoBase.add("Gabriel de Lima Feitosa");
        vetorProjetoBase.add("Raphael Pessoa");
        vetorProjetoBase.add("  ");
        vetorProjetoBase.add("LINK: http://code.google.com/p/msnlab/");
        listProjetoBase.setListData(vetorProjetoBase);

        Vector<String> vetorProjetoAtual = new Vector<String>();
        vetorProjetoAtual.add("Lucas Medeiros de Azevedo");
        vetorProjetoAtual.add("Otacilio Freitas de Lacerda");
        listProjetoAtual.setListData(vetorProjetoAtual);
    }

    private void positions() {
        panelAbout.setBounds(7, 7, 390, 500);
        textProjetoBase.setBounds(7, 7, 80, 20);
        listProjetoBase.setBounds(7, 27, 375, 330);
        
        textProjetoAtual.setBounds(7, 367, 380, 20);
        listProjetoAtual.setBounds(7, 387, 375, 80);
    }

    private void actions() {

    }

    private void makeScreen() {
        panelAbout.add(textProjetoBase);
        panelAbout.add(listProjetoBase);
        panelAbout.add(textProjetoAtual);
        panelAbout.add(listProjetoAtual);

        add(panelAbout);

    }

}
