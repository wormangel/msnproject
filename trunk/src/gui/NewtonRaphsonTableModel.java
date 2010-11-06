package gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import newtonRaphson.NewtonRaphsonResult;

/**
 * @author Alfeu Buriti Pereira Júnior.
 * @author Brunno José Guimarães de Almeida.
 */
public class NewtonRaphsonTableModel extends AbstractTableModel {

    private static final long serialVersionUID = 1L;

    private List<NewtonRaphsonResult> results;

    public static final int ITERATION = 0;
    public static final int X = 1;

    public NewtonRaphsonTableModel() {
        results = new ArrayList<NewtonRaphsonResult>();
    }

    public NewtonRaphsonTableModel(List<NewtonRaphsonResult> results) {
        this.results = results;
    }

    public int getColumnCount() {
        return 2;
    }

    public int getRowCount() {
        return results.size();
    }

    /**
     * @return the results
     */
    public List<NewtonRaphsonResult> getResults() {
        return results;
    }

    /**
     * @param results the results to set
     */
    public void setResults(List<NewtonRaphsonResult> results) {
        this.results = results;
    }

    public Object getValueAt(int row, int column) {
        NewtonRaphsonResult bs = get(row);
        switch (column) {
        case ITERATION: {
            return (row + 1) + "";
        }
        case X: {
            return bs.getX() + "";
        }
        }
        return "";
    }

    public String getColumnName(int column) {
        switch (column) {
        case ITERATION:
            return "#";
        case X:
            return "X";

        }
        return "";
    }

    public NewtonRaphsonResult get(int row) {
        return results.get(row);
    }

}
