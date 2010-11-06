package br.edu.ufcg.msnlab.gui.about;


import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import br.edu.ufcg.msnlab.gui.MSNLab;

/**
 * @author Alfeu Buriti Pereira Júnior.
 * @author Brunno José Guimarães de Almeida.
 */
public class FrameAbout extends JInternalFrame {

    private static final long serialVersionUID = -5319776206787609374L;

    private JPanel panelAbout;

    private JLabel textInterface;
    private JLabel textMethods;

    private JList listInterface;
    private JList listMethoods;

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

        textInterface = new JLabel("Interface");
        textMethods = new JLabel("Methods");
        listInterface = new JList();
        listMethoods = new JList();

        Vector<String> vetorInterface = new Vector<String>();
        vetorInterface.add("Alfeu Buriti Pereira Júnior");
        vetorInterface.add("Brunno José Guimarães de Almeida");
        vetorInterface.add("Rodrigo Barbosa Lira");
        vetorInterface.add("Samuel de Barros Florentino");
        vetorInterface.add("Erick Moreno Marques Almeida");
        vetorInterface.add("Andrea Alves Nascimento");
        listInterface.setListData(vetorInterface);

        Vector<String> vetorMethods = new Vector<String>();
        vetorMethods.add("Álvaro Magnum Barbosa Neto");
        vetorMethods.add("Marcus Vinícius Mesquita Leite");
        vetorMethods.add("Jaindson Valentim Santana");
        vetorMethods.add("Edigley Pereira Fraga");
        vetorMethods.add("Jaluska Rodrigues de Almeida");
        vetorMethods.add("Eugênia de Sousa Cavalcanti");
        vetorMethods.add("Davi Oliveira Fernandes");
        vetorMethods.add("Vinícius Aguiar");
        vetorMethods.add("Marcus Williams A. de Carvalho");
        vetorMethods.add("Carla Souza");
        vetorMethods.add("Gabriel de Lima Feitosa");
        vetorMethods.add("Raphael Pessoa");
        listMethoods.setListData(vetorMethods);
    }

    private void positions() {
        panelAbout.setBounds(7, 7, 390, 460);
        textInterface.setBounds(7, 7, 80, 20);
        listInterface.setBounds(7, 27, 375, 150);
        
        textMethods.setBounds(7, 187, 80, 20);
        listMethoods.setBounds(7, 207, 375, 230);
    }

    private void actions() {

    }

    private void makeScreen() {
        panelAbout.add(textInterface);
        panelAbout.add(listInterface);
        panelAbout.add(textMethods);
        panelAbout.add(listMethoods);

        add(panelAbout);

    }

}
