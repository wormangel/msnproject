package br.edu.ufcg.msnlab.gui.models;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.edu.ufcg.msnlab.methods.wijngaardenDekerBrent.BrentResult;


/**
 * @author Alfeu Buriti Pereira Júnior.
 * @author Brunno José Guimarães de Almeida.
 */
public class BrentTableModel extends AbstractTableModel {

    private static final long serialVersionUID = 1L;

    private List<BrentResult> results;

    public static final int ITERATION = 0;
    public static final int X = 1;
    public static final int ERROR = 2;
    public static final int FX = 3;

    public BrentTableModel() {
        results = new ArrayList<BrentResult>();
    }

    public BrentTableModel(List<BrentResult> results) {
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
    public List<BrentResult> getResults() {
        return results;
    }

    /**
     * @param results the results to set
     */
    public void setResults(List<BrentResult> results) {
        this.results = results;
    }

    public Object getValueAt(int row, int column) {
        BrentResult bs = get(row);
        switch (column) {
        case ITERATION: {
            return (row + 1) + "";
        }
        case X: {
            return bs.getX() + "";
        }
        case FX: {
            return bs.getFx() + "";
        }
        case ERROR: {
            return bs.getError() + "";
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
        case FX:
            return "f(x)";
        case ERROR:
            return "Error";

        }
        return "";
    }

    public BrentResult get(int row) {
        return results.get(row);
    }

}
