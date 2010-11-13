package methods.timediff;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;

import javax.swing.JFrame;

import br.edu.ufcg.msnlab.methods.newtonraphson.NewtonRaphsonSolverImpl;
import br.edu.ufcg.msnlab.methods.petkovic.PetkovicSolverImpl;
import br.edu.ufcg.msnlab.methods.secant.SecantSolverImpl;
import br.edu.ufcg.msnlab.misc.FunctionImpl;

public class MassTimeDiff {

	private static final String FUNCTIONS_FILE = "C:\\Users\\otacilio\\Desktop\\functions.txt";

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

	public static void main(String[] args) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File(
					FUNCTIONS_FILE)));
			String linha;

			while ((linha = reader.readLine()) != null) {
				FunctionImpl function = new FunctionImpl(linha);
				long[] r = runTests(function, 0.00000000000001);
				System.out.println(linha);
				System.out.println("Newton: " + r[0]);
				System.out.println("Secante: " + r[1]);
				System.out.println("Petkovic: " + r[2]);
				System.out.println("----------\n");

			}
		} catch (Exception e) {
			System.out.println("Problema: " + e.getMessage());
		}

	}

}
