package br.edu.ufcg.msnlab.gui.models;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.edu.ufcg.msnlab.methods.muller.MullerResult;


/**
 * @author Alfeu Buriti Pereira Júnior.
 * @author Brunno José Guimarães de Almeida.
 */
public class MullerTableModel extends AbstractTableModel {

    private static final long serialVersionUID = 1L;

    private List<MullerResult> results;

    public static final int ITERATION = 0;
    public static final int X = 1;
    public static final int X0 = 2;
    public static final int X1 = 3;
    public static final int X2 = 4;

    public MullerTableModel() {
        results = new ArrayList<MullerResult>();
    }

    public MullerTableModel(List<MullerResult> results) {
        this.results = results;
    }

    public int getColumnCount() {
        return 5;
    }

    public int getRowCount() {
        return results.size();
    }

    /**
     * @return the results
     */
    public List<MullerResult> getResults() {
        return results;
    }

    /**
     * @param results the results to set
     */
    public void setResults(List<MullerResult> results) {
        this.results = results;
    }

    public Object getValueAt(int row, int column) {
        MullerResult bs = get(row);
        switch (column) {
        case ITERATION:
            return (row + 1) + "";
        case X:
            return bs.getX() + "";
        case X0:
            return bs.getX0() + "";
        case X1:
            return bs.getX1() + "";
        case X2:
            return bs.getX2() + "";

        }
        return "";
    }

    public String getColumnName(int column) {
        switch (column) {
        case ITERATION:
            return "#";
        case X:
            return "X";
        case X1:
            return "X1";
        case X2:
            return "X2";
        case X0:
            return "X0";

        }
        return "";
    }

    public MullerResult get(int row) {
        return results.get(row);
    }

}
