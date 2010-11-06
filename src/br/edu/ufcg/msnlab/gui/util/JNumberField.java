package br.edu.ufcg.msnlab.gui.util;

import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

/**
 * @author Alfeu Buriti Pereira Júnior.
 * @author Brunno José Guimarães de Almeida.
 */
public class JNumberField extends JTextField {

    private static final long serialVersionUID = 1L;

    public JNumberField() {
        super();
    }

    public JNumberField(int cols) {
        super(cols);
    }

    protected Document createDefaultModel() {
        return new NumberDocument();
    }

    static class NumberDocument extends PlainDocument {

        private static final long serialVersionUID = 1L;

        public void insertString(int offs, String str, AttributeSet a)
                throws BadLocationException {
            String entrada = "";
            for (int i = 0; i < str.length(); i++) {
                if (((str.charAt(i) >= 48) && (str.charAt(i) <= 57))
                        || (str.charAt(i) == 45))
                    entrada += str.charAt(i);
            }
            if (entrada == null)
                return;
            super.insertString(offs, entrada, a);
        }
    }
}