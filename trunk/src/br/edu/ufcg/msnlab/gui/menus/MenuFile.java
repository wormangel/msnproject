package br.edu.ufcg.msnlab.gui.menus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JMenu;
import javax.swing.JMenuItem;

import br.edu.ufcg.msnlab.gui.MSNLab;

/**
 * @author Alfeu Buriti Pereira Júnior.
 * @author Brunno José Guimarães de Almeida.
 */
public class MenuFile extends JMenu {

    private static final long serialVersionUID = 1L;

    @SuppressWarnings("unused")
    private MSNLab msnLab;

    private JMenuItem exit;

    public MenuFile(MSNLab msnLab) {
        super("File");
        this.msnLab = msnLab;
        initialize();
        actions();
        makeMenu();
    }

    private void initialize() {
        exit = new JMenuItem("Exit");

    }

    private void actions() {
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.exit(0);
            }
        });

    }

    private void makeMenu() {
        add(exit);
    }

}
