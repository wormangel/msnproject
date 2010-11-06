package br.edu.ufcg.msnlab.gui.models;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.edu.ufcg.msnlab.methods.ridders.RiddersResult;


/**
 * @author Alfeu Buriti Pereira Júnior.
 * @author Brunno José Guimarães de Almeida.
 */
public class RiddersTableModel extends AbstractTableModel {

    private static final long serialVersionUID = 1L;

    private List<RiddersResult> results;

    public static final int ITERATION = 0;
    public static final int MIN = 1;
    public static final int MAX = 2;
    public static final int X = 3;

    public RiddersTableModel() {
        results = new ArrayList<RiddersResult>();
    }

    public RiddersTableModel(List<RiddersResult> results) {
        this.results = results;
    }

    public int getColumnCount() {
        return 4;
    }

    public int getRowCount() {
        return results.size();
    }

    /**
     * @return the results
     */
    public List<RiddersResult> getResults() {
        return results;
    }

    /**
     * @param results the results to set
     */
    public void setResults(List<RiddersResult> results) {
        this.results = results;
    }

    public Object getValueAt(int row, int column) {
        RiddersResult bs = get(row);
        switch (column) {
        case ITERATION: {
            return (row + 1) + "";
        }
        case MIN: {
            return bs.getMin() + "";
        }
        case MAX: {
            return bs.getMax() + "";
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
        case MIN:
            return "Min";
        case MAX:
            return "Max";
        case X:
            return "X";

        }
        return "";
    }

    public RiddersResult get(int row) {
        return results.get(row);
    }

}
