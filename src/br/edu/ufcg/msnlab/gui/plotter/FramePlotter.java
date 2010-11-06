package br.edu.ufcg.msnlab.gui.plotter;


import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import br.edu.ufcg.msnlab.InvalidFunctionException;
import br.edu.ufcg.msnlab.gui.MSNLab;
import br.edu.ufcg.msnlab.misc.Function;
import br.edu.ufcg.msnlab.misc.FunctionImpl;
import br.edu.ufcg.msnlab.misc.Point;

/**
 * @author Alfeu Buriti
 * @author Brunno Guimarães
 * @author Andrea Alves
 * @author Erick Moreno
 * @author Rodrigo Barbosa
 * @author Samuel de Barros
 */
public class FramePlotter extends JInternalFrame {

    private static final long serialVersionUID = -5982992152206673531L;

    @SuppressWarnings("unused")
    private MSNLab msnlab;
    private Container screen;

    public FramePlotter(MSNLab msnlab) {
        setTitle("MSN Plot");
        this.msnlab = msnlab;

        initialize();
    }

    private void initialize() {
        setClosable(true);
        setSize(500, 300);
        setAlignmentY(JInternalFrame.CENTER_ALIGNMENT);
        screen = getContentPane();
        screen.setBackground(Color.WHITE);
    }

    public void plot(String expression) throws InvalidFunctionException {
        Function f = new FunctionImpl(expression);
        List<Point> points = f.getPoints();

        XYSeries serie = new XYSeries("Function");

        for (Point p : points) {
            serie.add(p.getX(), p.getY());
        }

        XYSeriesCollection dataset = new XYSeriesCollection(serie);
        JFreeChart chart = ChartFactory.createXYLineChart("f(x) = "
                + expression, "X", "Y", dataset, PlotOrientation.VERTICAL,
                false, false, false);

        JPanel panel = new JPanel(new GridLayout(1, 1));
        panel.add(new ChartPanel(chart));
        screen.add(panel);
    }

}
