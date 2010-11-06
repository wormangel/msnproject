package br.edu.ufcg.msnlab.gui.output;


import java.awt.Container;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import br.edu.ufcg.msnlab.gui.MSNLab;

/**
 * @author Alfeu Buriti Pereira Júnior
 * @author Brunno José Guimarães de Almeida.
 */
public class FrameOutput extends JInternalFrame {

    private static final long serialVersionUID = 1L;

    protected MSNLab msnlab;

    private JTable tabela;
    private JScrollPane scroll;

    private Container screen;

    public FrameOutput(MSNLab msnLab) {
        this.msnlab = msnLab;
        setTitle("Output");
        initialize();
        positions();
        makeScreen();
    }

    private void initialize() {
        setLayout(null);
        screen = getContentPane();
        setSize(420, 305);
        setClosable(true);
        
        tabela = new JTable();
        scroll = new JScrollPane(tabela);

    }

    private void positions() {
        scroll.setBounds(7, 7, 390, 260);

    }

    private void makeScreen() {
        screen.add(scroll);
    }
    
    public void setModel(TableModel modelo) {
        tabela.setModel(modelo);
    }

}
