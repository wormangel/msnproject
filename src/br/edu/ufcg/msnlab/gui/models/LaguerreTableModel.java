package br.edu.ufcg.msnlab.gui.models;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.edu.ufcg.msnlab.methods.laguerre.LaguerreResult;


/**
 * @author Alfeu Buriti Pereira Júnior.
 * @author Brunno José Guimarães de Almeida.
 */
public class LaguerreTableModel extends AbstractTableModel {

    private static final long serialVersionUID = 1L;

    private List<LaguerreResult> results;

    public static final int ITERATION = 0;
    public static final int X = 1;
    public static final int GUESS = 2;

    public LaguerreTableModel() {
        results = new ArrayList<LaguerreResult>();
    }

    public LaguerreTableModel(List<LaguerreResult> results) {
        this.results = results;
    }

    public int getColumnCount() {
        return 3;
    }

    public int getRowCount() {
        return results.size();
    }

    /**
     * @return the results
     */
    public List<LaguerreResult> getResults() {
        return results;
    }

    /**
     * @param results the results to set
     */
    public void setResults(List<LaguerreResult> results) {
        this.results = results;
    }

    public Object getValueAt(int row, int column) {
        LaguerreResult bs = get(row);
        switch (column) {
        case ITERATION:
            return (row + 1) + "";
        case X:
            return bs.getX() + "";
        case GUESS:
            return bs.getGuess() + "";

        }
        return "";
    }

    public String getColumnName(int column) {
        switch (column) {
        case ITERATION:
            return "#";
        case X:
            return "X";
        case GUESS:
            return "Guess";

        }
        return "";
    }

    public LaguerreResult get(int row) {
        return results.get(row);
    }

}
