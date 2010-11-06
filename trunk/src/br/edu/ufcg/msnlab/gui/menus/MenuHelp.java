package br.edu.ufcg.msnlab.gui.menus;


import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import br.edu.ufcg.msnlab.gui.MSNLab;
import br.edu.ufcg.msnlab.gui.about.FrameAbout;

/**
 * @author Alfeu Buriti Pereira Júnior.
 * @author Brunno José Guimarães de Almeida.
 */
public class MenuHelp extends JMenu {

    private static final long serialVersionUID = 1L;

    private MSNLab msnLab;

    private JMenuItem about;

    public MenuHelp(MSNLab msnLab) {
        super("Help");
        this.msnLab = msnLab;
        initialize();
        actions();
        makeMenu();
    }

    private void initialize() {
        about = new JMenuItem("About");

    }

    private void actions() {
        about.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                FrameAbout fa = new FrameAbout(msnLab);
                fa.setLocation(new Point(
                        (msnLab.getWidth() - fa.getWidth()) / 2, 100));
                msnLab.openComponent(fa);
            }
        });
    }

    private void makeMenu() {
        add(about);
    }

}
