package br.edu.ufcg.msnlab.gui.models;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.edu.ufcg.msnlab.methods.bus.BusAlgorithmRResult;


/**
 * @author Alfeu Buriti Pereira Júnior.
 * @author Brunno José Guimarães de Almeida.
 */
public class BusRTableModel extends AbstractTableModel {

    private static final long serialVersionUID = 1L;

    private List<BusAlgorithmRResult> results;

    public static final int ITERATION = 0;
    public static final int X = 1;

    public BusRTableModel() {
        results = new ArrayList<BusAlgorithmRResult>();
    }

    public BusRTableModel(List<BusAlgorithmRResult> results) {
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
    public List<BusAlgorithmRResult> getResults() {
        return results;
    }

    /**
     * @param results the results to set
     */
    public void setResults(List<BusAlgorithmRResult> results) {
        this.results = results;
    }

    public Object getValueAt(int row, int column) {
        BusAlgorithmRResult bs = get(row);
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

    public BusAlgorithmRResult get(int row) {
        return results.get(row);
    }

}
