package br.edu.ufcg.msnlab.gui.models;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.edu.ufcg.msnlab.methods.petkovic.PetkovicResult;


/**
 * @author Otacilio Freitas de Lacerda.
 * @author Lucas Medeiros de Azevedo.
 */
public class PetkovicTableModel extends AbstractTableModel {

    private static final long serialVersionUID = 1L;

    private List<PetkovicResult> results;

    public static final int ITERATION = 0;
    public static final int X = 1;

    public PetkovicTableModel() {
        results = new ArrayList<PetkovicResult>();
    }

    public PetkovicTableModel(List<PetkovicResult> results) {
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
    public List<PetkovicResult> getResults() {
        return results;
    }

    /**
     * @param results the results to set
     */
    public void setResults(List<PetkovicResult> results) {
        this.results = results;
    }

    public Object getValueAt(int row, int column) {
    	PetkovicResult bs = get(row);
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

    public PetkovicResult get(int row) {
        return results.get(row);
    }

}
