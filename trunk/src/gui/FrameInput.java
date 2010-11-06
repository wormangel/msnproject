package gui;


import java.awt.Container;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

import secant.SecantResult;
import secant.SecantSolver;
import secant.SecantSolverImpl;

import newtonRaphson.NewtonRaphsonResult;
import newtonRaphson.NewtonRaphsonSolver;
import newtonRaphson.NewtonRaphsonSolverImpl;

import methods.Methods;
import misc.Function;
import misc.FunctionImpl;

import exceptions.InvalidFunctionException;


/**
 * @author Alfeu Buriti Pereira Júnior.
 * @author Brunno José Guimarães de Almeida.
 */
public class FrameInput extends JInternalFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = -4714939028473804954L;
	private JPanel panelButtons;
    private JPanel panelFields;

    private MSNLab msnlab;
    private Container screen;

    private JLabel textExpression;
    private JLabel textGuess;
    private JLabel textMethods;
    private JLabel textMin;
    private JLabel textMax;
    private JLabel textX0;
    private JLabel textX1;
    private JLabel textX2;
    private JLabel textTolerance;
    private JLabel textIterations;
    private JLabel textItFunction;

    private JDecimalField fieldMin;
    private JDecimalField fieldMax;
    private JDecimalField fieldGuess;
    private JDecimalField fieldX0;
    private JDecimalField fieldX1;
    private JDecimalField fieldX2;
    private JDecimalField fieldTolerance;

    private JNumberField fieldIteration;

    private JTextArea fieldExpression;
    private JTextField fieldItFunction;

    private JScrollPane scrollExpression;

    private JComboBox comboMethods;

    private JButton buttonPlot;
    private JButton buttonSolve;

    public FrameInput(MSNLab msnlab) {
        super("Solve Equation");
        this.msnlab = msnlab;

        initialize();
        positions();
        actions();
        makeScreen();
    }

    private void initialize() {
        setClosable(false);
        // setSize(420, 250);
        setSize(420, 280);
        screen = getContentPane();
        screen.setLayout(null);

        panelButtons = new JPanel();
        panelButtons.setLayout(null);
        panelButtons.setBorder(new EtchedBorder());

        panelFields = new JPanel();
        panelFields.setLayout(null);
        panelFields.setBorder(new EtchedBorder());

        textExpression = new JLabel("Expression: ");
        textIterations = new JLabel("Max. Iterations: ");
        textMethods = new JLabel("Method: ");
        textGuess = new JLabel("Guess: ");
        textMin = new JLabel("Min: ");
        textMax = new JLabel("Max: ");
        textX0 = new JLabel("X0: ");
        textX1 = new JLabel("X1: ");
        textX2 = new JLabel("X2: ");
        textTolerance = new JLabel("Tolerance: ");
        textItFunction = new JLabel("It Function: ");

        fieldIteration = new JNumberField();
        fieldMax = new JDecimalField();
        fieldMin = new JDecimalField();
        fieldGuess = new JDecimalField();
        fieldX0 = new JDecimalField();
        fieldX1 = new JDecimalField();
        fieldX2 = new JDecimalField();
        fieldTolerance = new JDecimalField();
        fieldExpression = new JTextArea();
        fieldItFunction = new JTextField();

        scrollExpression = new JScrollPane(fieldExpression);

        comboMethods = makeComboMethods();

        buttonPlot = new JButton("Plot");
        buttonSolve = new JButton("Solve");

        buttonPlot.setFocusable(false);
        buttonSolve.setFocusable(false);

        screen.setBackground(panelButtons.getBackground());

        textX0.setVisible(false);
        textX1.setVisible(false);
        textX2.setVisible(false);
        fieldX0.setVisible(false);
        fieldX1.setVisible(false);
        fieldX2.setVisible(false);
        textGuess.setVisible(false);
        fieldGuess.setVisible(false);
        
        textItFunction.setVisible(false);
        fieldItFunction.setVisible(false);

    }

    private JComboBox makeComboMethods() {
        JComboBox combo = new JComboBox();
        combo.addItem(Methods.NEWTONRAPHSON);
        combo.addItem(Methods.SECANT);
        return combo;
    }

    private void positions() {
        // panelFields.setBounds(7, 7, 390, 167);
        panelFields.setBounds(7, 7, 390, 190);
        
        textExpression.setBounds(0, 7, 100, 20);
        scrollExpression.setBounds(100, 7, 280, 80);
        textMethods.setBounds(0, 92, 100, 20);
        comboMethods.setBounds(100, 92, 280, 20);

        textMin.setBounds(0, 117, 100, 20);
        fieldMin.setBounds(100, 117, 60, 20);
        textMax.setBounds(160, 117, 40, 20);
        fieldMax.setBounds(200, 117, 60, 20);
        // textApproximation.setBounds(260, 117, 60, 20);
        // fieldApproximation.setBounds(320, 117, 60, 20);
        textTolerance.setBounds(260, 117, 60, 20);
        fieldTolerance.setBounds(320, 117, 60, 20);
        textIterations.setBounds(0, 142, 100, 20);
        fieldIteration.setBounds(100, 142, 60, 20);
        comboMethods.setBounds(100, 92, 220, 20);

        // fixed point
        textItFunction.setBounds(0, 167, 100, 20);
        fieldItFunction.setBounds(100,167, 100,20);
        
        // GUESS
        textGuess.setBounds(0, 117, 100, 20);
        fieldGuess.setBounds(100, 117, 60, 20);

        // Müller
        textX0.setBounds(0, 117, 100, 20);
        fieldX0.setBounds(100, 117, 40, 20);
        textX1.setBounds(140, 117, 20, 20);
        fieldX1.setBounds(160, 117, 40, 20);
        textX2.setBounds(200, 117, 20, 20);
        fieldX2.setBounds(220, 117, 40, 20);

        // panelButtons.setBounds(7, 179, 390, 35);
        panelButtons.setBounds(7, 200, 390, 35);
        buttonSolve.setBounds(165, 8, 105, 20);
        buttonPlot.setBounds(275, 8, 105, 20);

        textExpression.setHorizontalAlignment(JLabel.RIGHT);
        textMax.setHorizontalAlignment(JLabel.RIGHT);
        textMin.setHorizontalAlignment(JLabel.RIGHT);
        textMethods.setHorizontalAlignment(JLabel.RIGHT);
        textX0.setHorizontalAlignment(JLabel.RIGHT);
        textX1.setHorizontalAlignment(JLabel.RIGHT);
        textX2.setHorizontalAlignment(JLabel.RIGHT);
        textTolerance.setHorizontalAlignment(JLabel.RIGHT);
        textIterations.setHorizontalAlignment(JLabel.RIGHT);
        textGuess.setHorizontalAlignment(JLabel.RIGHT);
        
        textItFunction.setHorizontalAlignment(JLabel.RIGHT);
    }

    private void actions() {
        buttonPlot.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String expression = fieldExpression.getText();
                try {
                    @SuppressWarnings("unused")
                    Function func = new FunctionImpl(expression);
                    FramePlotter fp = new FramePlotter(msnlab);
                    fp.setBounds(418, 0, fp.getWidth(), fp
                            .getHeight());
                    msnlab.openComponent(fp);
                    fp.plot(expression);

                } catch (Exception e) {
                    msnlab.showError(e.getMessage());
                }
            }
        });
        comboMethods.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String method = (String) comboMethods.getSelectedItem();
                if (method.equals(Methods.SECANT)) {
                    textGuess.setVisible(false);
                    textIterations.setVisible(true);
                    textMax.setVisible(true);
                    textMin.setVisible(true);
                    textX0.setVisible(false);
                    textX1.setVisible(false);
                    textX2.setVisible(false);
                    fieldX0.setVisible(false);
                    fieldX1.setVisible(false);
                    fieldX2.setVisible(false);
                    textTolerance.setVisible(true);
                    
                    fieldGuess.setVisible(false);
                    fieldIteration.setVisible(true);
                    fieldMax.setVisible(true);
                    fieldMin.setVisible(true);
                    fieldTolerance.setVisible(true);
                    
                    textItFunction.setVisible(false);
                    fieldItFunction.setVisible(false);
                    
                } else if (method.equals(Methods.NEWTONRAPHSON)) {
                    textGuess.setVisible(true);
                    textIterations.setVisible(true);
                    textMax.setVisible(false);
                    textMin.setVisible(false);
                    textTolerance.setVisible(true);
                    textX0.setVisible(false);
                    textX1.setVisible(false);
                    textX2.setVisible(false);
                    fieldX0.setVisible(false);
                    fieldX1.setVisible(false);
                    fieldX2.setVisible(false);

                    fieldGuess.setVisible(true);
                    fieldIteration.setVisible(true);
                    fieldMax.setVisible(false);
                    fieldMin.setVisible(false);
                    fieldTolerance.setVisible(true);
                    
                    textItFunction.setVisible(false);
                    fieldItFunction.setVisible(false);
                    
                } 
            }
        });
        buttonSolve.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                solver();
            }

        });

    }

    protected void solver() {
        String method = (String) comboMethods.getSelectedItem();
        Function function;
        try {
            function = new FunctionImpl(fieldExpression.getText());
            if (method.equals(Methods.NEWTONRAPHSON)) {
                if (fieldGuess.getText().trim().equals("")) {
                    msnlab.showError("Guess cannot be empty.");
                    return;
                } else {
                    double tolerance = Double.parseDouble(fieldTolerance
                            .getText());
                    NewtonRaphsonSolver bs = new NewtonRaphsonSolverImpl();
                    double guess = Double.parseDouble(fieldGuess.getText());
                    int iterations = 0;
                    try {
                        iterations = Integer.parseInt(fieldIteration.getText());
                    } catch (Exception e) {}
                    try {
                        List<NewtonRaphsonResult> result;
                        if (iterations == 0) {
                            result = bs.solve(function, guess, tolerance);
                        } else {
                            result = bs.solve(function, guess, tolerance,
                                    iterations);
                        }
                        NewtonRaphsonTableModel btm = new NewtonRaphsonTableModel(
                                result);
                        FrameOutput fo = new FrameOutput(msnlab);
                        fo.setModel(btm);
                        fo.setLocation(new Point(0, 250));
                        msnlab.openComponent(fo);
                    } catch (Exception e) {
                        msnlab.showError(e.getMessage());
                    }
                }
            } else if (method.equals(Methods.SECANT)) {
                if (fieldMin.getText().trim().equals("")
                        || fieldMax.getText().trim().equals("")) {
                    msnlab.showError("Min and Max cannot be empty.");
                    return;
                } else {
                    double tolerance = Double.parseDouble(fieldTolerance
                            .getText());
                    SecantSolver bs = new SecantSolverImpl();
                    double min = Double.parseDouble(fieldMin.getText());
                    double max = Double.parseDouble(fieldMax.getText());
                    int iterations = 0;
                    try {
                        iterations = Integer.parseInt(fieldIteration.getText());
                    } catch (Exception e) {}
                    try {
                        List<SecantResult> result;
                        if (iterations == 0) {
                            result = bs.solve(function, min, max, tolerance);
                        } else {
                            result = bs.solve(function, min, max, tolerance,
                                    iterations);
                        }
                        SecantTableModel btm = new SecantTableModel(result);
                        FrameOutput fo = new FrameOutput(msnlab);
                        fo.setModel(btm);
                        fo.setLocation(new Point(0, 250));
                        msnlab.openComponent(fo);
                    } catch (Exception e) {
                        msnlab.showError(e.getMessage());
                    }
                }
            } 
        } catch (InvalidFunctionException e1) {
            msnlab.showError(e1.getMessage());
        } catch (NumberFormatException e1) {
            msnlab.showError("Tolerance cannot be empty.");
        } catch (Exception e1) {
            msnlab.showError(e1.getMessage());
        }

    }

    private void makeScreen() {
        panelFields.add(textExpression);
        panelFields.add(textIterations);
        panelFields.add(textGuess);
        panelFields.add(textMethods);
        panelFields.add(textMin);
        panelFields.add(textMax);
        panelFields.add(textTolerance);
        panelFields.add(textX0);
        panelFields.add(textX1);
        panelFields.add(textX2);
        panelFields.add(fieldIteration);
        panelFields.add(fieldMin);
        panelFields.add(fieldGuess);
        panelFields.add(fieldMax);
        panelFields.add(fieldX0);
        panelFields.add(fieldX1);
        panelFields.add(fieldX2);
        panelFields.add(fieldTolerance);
        panelFields.add(scrollExpression);
        panelFields.add(comboMethods);
        panelFields.add(fieldItFunction);
        panelFields.add(textItFunction);

        panelButtons.add(buttonPlot);
        panelButtons.add(buttonSolve);

        screen.add(panelButtons);
        screen.add(panelFields);
    }

}
