package br.edu.ufcg.msnlab.gui.models;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.edu.ufcg.msnlab.methods.bus.BusAlgorithmMResult;


/**
 * @author Alfeu Buriti Pereira Júnior.
 * @author Brunno José Guimarães de Almeida.
 */
public class BusMTableModel extends AbstractTableModel {

    private static final long serialVersionUID = 1L;

    private List<BusAlgorithmMResult> results;

    public static final int ITERATION = 0;
    public static final int X = 1;

    public BusMTableModel() {
        results = new ArrayList<BusAlgorithmMResult>();
    }

    public BusMTableModel(List<BusAlgorithmMResult> results) {
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
    public List<BusAlgorithmMResult> getResults() {
        return results;
    }

    /**
     * @param results the results to set
     */
    public void setResults(List<BusAlgorithmMResult> results) {
        this.results = results;
    }

    public Object getValueAt(int row, int column) {
        BusAlgorithmMResult bs = get(row);
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

    public BusAlgorithmMResult get(int row) {
        return results.get(row);
    }

}
