package br.edu.ufcg.msnlab.gui;


import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import br.edu.ufcg.msnlab.gui.input.FrameInput;
import br.edu.ufcg.msnlab.gui.menus.MenuFile;
import br.edu.ufcg.msnlab.gui.menus.MenuHelp;

/**
 * @author Alfeu Buriti Pereira Júnior.
 * @author Brunno José Guimarães de Almeida.
 */
public class MSNLab extends JFrame {

    private static final long serialVersionUID = 1L;

    private JDesktopPane screen;

    private JMenuBar menuBar;

    private JLabel background;

    public MSNLab() {
        super("MSNLab 1.0 Alpha");
        initialize();
        positions();
        makeMenu();
        actions();
        makeScreen();
        openComponent(new FrameInput(this));
    }

    private void initialize() {
        setSize(800, 560);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        validate();
        screen = new JDesktopPane();
        screen.setLayout(null);
        setContentPane(screen);

        URL url = this.getClass().getClassLoader()
                .getResource("background.jpg");
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        background = new JLabel(new ImageIcon(toolkit.getImage(url)));
        screen.setBackground(Color.WHITE);

    }

    public void openComponent(JInternalFrame internal) {
        screen.add(internal);
        internal.setVisible(true);
    }

    private void positions() {
        background.setBounds((getWidth() - 640) / 2, (getHeight() - 480) / 2,
                640, 480);
    }

    private void makeMenu() {
        menuBar = new JMenuBar();
        menuBar.add(new MenuFile(this));
        menuBar.add(new MenuHelp(this));

        setJMenuBar(menuBar);
    }

    private void actions() {
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent arg0) {
                System.exit(0);
            }
        });
        addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent arg0) {
                background.setBounds((getWidth() - 640) / 2,
                        (getHeight() - 480) / 2, 640, 480);
            }
        });
    }

    private void makeScreen() {
        screen.add(background);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        MSNLab lab = new MSNLab();
        lab.setVisible(true);
    }

    public void showError(String message) {
        JOptionPane.showMessageDialog(null, message, "Error",
                JOptionPane.ERROR_MESSAGE);

    }
}
