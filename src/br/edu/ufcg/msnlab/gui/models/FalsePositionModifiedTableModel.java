package br.edu.ufcg.msnlab.gui.models;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.edu.ufcg.msnlab.methods.falseposition.FalsePositionModifiedResult;


/**
 * @author Alfeu Buriti Pereira J�nior.
 * @author Brunno Jos� Guimar�es de Almeida.
 */
public class FalsePositionModifiedTableModel extends AbstractTableModel {

    private static final long serialVersionUID = 1L;

    private List<FalsePositionModifiedResult> results;

    public static final int ITERATION = 0;
    public static final int MIN = 1;
    public static final int MAX = 2;
    public static final int X = 3;

    public FalsePositionModifiedTableModel() {
        results = new ArrayList<FalsePositionModifiedResult>();
    }

    public FalsePositionModifiedTableModel(
            List<FalsePositionModifiedResult> results) {
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
    public List<FalsePositionModifiedResult> getResults() {
        return results;
    }

    /**
     * @param results the results to set
     */
    public void setResults(List<FalsePositionModifiedResult> results) {
        this.results = results;
    }

    public Object getValueAt(int row, int column) {
        FalsePositionModifiedResult bs = get(row);
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

    public FalsePositionModifiedResult get(int row) {
        return results.get(row);
    }

}
