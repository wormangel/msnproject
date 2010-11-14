package methods.timediff;

import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import br.edu.ufcg.msnlab.methods.newtonraphson.NewtonRaphsonSolverImpl;
import br.edu.ufcg.msnlab.methods.petkovic.PetkovicSolverImpl;
import br.edu.ufcg.msnlab.methods.secant.SecantSolverImpl;
import br.edu.ufcg.msnlab.misc.FunctionImpl;

public class MassTimeDiff {

	private static final String FUNCTIONS_FILE = "C:\\func.txt";
	private static DefaultTableModel model;
	private static JFrame frame;

	// Coloquei cada medida de tempo repetida em vez de usar setUp e tearDown
	// pra
	// dar a medida mais fiel possível, tirando assim o tempo perdido com
	// chamada de
	// método, etc.
	public static long[] runTests(FunctionImpl function, double tolerancia)
			throws Exception {
		long tempInicial, tempFinal, dif;
		long[] list = new long[3];

		tempInicial = System.currentTimeMillis();
		new NewtonRaphsonSolverImpl().solve(function, 1.6, tolerancia);
		tempFinal = System.currentTimeMillis();
		dif = (tempFinal - tempInicial);
		list[0] = dif;

		tempInicial = System.currentTimeMillis();
		new SecantSolverImpl().solve(function, 1.6, 1.7, tolerancia);
		tempFinal = System.currentTimeMillis();
		dif = (tempFinal - tempInicial);
		list[1] = dif;

		tempInicial = System.currentTimeMillis();
		new PetkovicSolverImpl().solve(function, 1.6, tolerancia).size();
		tempFinal = System.currentTimeMillis();
		dif = (tempFinal - tempInicial);
		list[2] = dif;

		return list;
	}
	
	
	private static void initFrame() {
		try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
		frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Resultado dos testes.");
        frame.setMinimumSize(new Dimension(600, 400));
        frame.setName("Form"); 

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setName("scrollPane");
        
        model = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;
			
			boolean[] canEdit = new boolean [] {
                    false, false, false, false
                };
			
			public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        };
        
        JTable table = new JTable(model); 

        model.addColumn("Functions");
        model.addColumn("Newton");
        model.addColumn("Secante");
        model.addColumn("Petkovic");

        table.setName("tabelaResultados");
        scrollPane.setViewportView(table);
        frame.add(scrollPane);
	}

	public static void main(String[] args) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File(
					FUNCTIONS_FILE)));
			String linha;

			initFrame();
			
			while ((linha = reader.readLine()) != null) {
				FunctionImpl function = new FunctionImpl(linha);
				long[] r = runTests(function, 0.00000000000001);
				
				//Modelo da tabela:
				//funtions-newton-secante-petkovic
				
				model.addRow(new Object[] {linha, r[0], r[1], r[2]});
				
				// Se quiser o resultado em texto puro
				System.out.println(linha);
				System.out.println("Newton: " + r[0]);
				System.out.println("Secante: " + r[1]);
				System.out.println("Petkovic: " + r[2]);
				System.out.println("----------");

			}
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
		} catch (Exception e) {
			System.out.println("Problema: " + e.getMessage());
		}

	}

}
