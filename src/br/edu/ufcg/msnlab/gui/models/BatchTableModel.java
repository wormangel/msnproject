package br.edu.ufcg.msnlab.gui.models;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.edu.ufcg.msnlab.misc.BatchResult;


public class BatchTableModel extends AbstractTableModel {

    private static final long serialVersionUID = 1L;

    private List<BatchResult> results;

    public static final int FUNCTION = 0;
    public static final int TIME = 1;

    public BatchTableModel() {
        results = new ArrayList<BatchResult>();
    }

    public BatchTableModel(List<BatchResult> results) {
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
    public List<BatchResult> getResults() {
        return results;
    }

    /**
     * @param results the results to set
     */
    public void setResults(List<BatchResult> results) {
        this.results = results;
    }

    public Object getValueAt(int row, int column) {
    	BatchResult bs = get(row);
        switch (column) {
        case FUNCTION: {
            return bs.getFunction().getExpression() + "";
        }
        case TIME: {
        	if (bs.getTime() == -1){
        		return "Erro";
        	} else {
        		return bs.getTime() + "";
        	}
            
        }
        }
        return "";
    }

    public String getColumnName(int column) {
        switch (column) {
        case FUNCTION:
            return "Function";
        case TIME:
            return "Time (milisegundos)";

        }
        return "";
    }

    public BatchResult get(int row) {
        return results.get(row);
    }

}
