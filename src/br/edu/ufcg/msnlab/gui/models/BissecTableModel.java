package br.edu.ufcg.msnlab.gui.models;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.edu.ufcg.msnlab.methods.bissec.BissecResult;


/**
 * @author Alfeu Buriti Pereira J�nior.
 * @author Brunno Jos� Guimar�es de Almeida.
 */
public class BissecTableModel extends AbstractTableModel {

    private static final long serialVersionUID = 1L;

    private List<BissecResult> results;

    public static final int ITERATION = 0;
    public static final int MIN = 1;
    public static final int MAX = 2;
    public static final int X = 3;

    public BissecTableModel() {
        results = new ArrayList<BissecResult>();
    }

    public BissecTableModel(List<BissecResult> results) {
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
    public List<BissecResult> getResults() {
        return results;
    }

    /**
     * @param results the results to set
     */
    public void setResults(List<BissecResult> results) {
        this.results = results;
    }

    public Object getValueAt(int row, int column) {
        BissecResult bs = get(row);
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

    public BissecResult get(int row) {
        return results.get(row);
    }

}
