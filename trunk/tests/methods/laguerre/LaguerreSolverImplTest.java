package methods.laguerre;

import java.util.List;

import br.edu.ufcg.msnlab.methods.laguerre.LaguerreResult;
import br.edu.ufcg.msnlab.methods.laguerre.LaguerreSolver;
import br.edu.ufcg.msnlab.methods.laguerre.LaguerreSolverImpl;
import br.edu.ufcg.msnlab.misc.Function;
import br.edu.ufcg.msnlab.misc.FunctionImpl;

import junit.framework.TestCase;
import mfc.field.Complex;

public class LaguerreSolverImplTest extends TestCase {
	
	LaguerreSolver laguerre;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		laguerre = new LaguerreSolverImpl();
	}
	
	public void testPolynomials() throws Exception {
		
		Function f;
		double tol = 0.001;
		
		f = new FunctionImpl("x");
		verifyFunction(f, tol);
		
		f = new FunctionImpl("x^2 - 16");
		verifyFunction(f, tol);
		
		f = new FunctionImpl("x^4 - 2x^3 - 6x^2 + 22^x - 15");
		verifyFunction(f, tol);
		
		f = new FunctionImpl("x^52425");
		verifyFunction(f, tol);
		
	}
	
	private void verifyFunction(Function f, double tol) throws Exception {
		List<LaguerreResult> results = laguerre.solve(f, tol);
		Complex lastX = results.get(results.size()-1).getComplexX();
		Complex lastResult = f.calculate(lastX);
		assertTrue(lastResult.abs() <= tol);
	}
	
}