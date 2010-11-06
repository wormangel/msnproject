/**
 * 
 */
package misc;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import br.edu.ufcg.msnlab.InvalidFunctionException;
import br.edu.ufcg.msnlab.misc.Function;
import br.edu.ufcg.msnlab.misc.FunctionImpl;
import br.edu.ufcg.msnlab.misc.Point;
import br.edu.ufcg.msnlab.misc.PointImpl;

/**
 * @author Rodrigo Barbosa Lira
 *
 */
public class FunctionImplTest extends TestCase {
	
	public void testPolynomialFunction() throws InvalidFunctionException {
		Function f01 = new FunctionImpl("x^2");
		assertEquals(0.0d, f01.calculate(0.0d));
		assertEquals(1.0d, f01.calculate(1.0d));
		assertEquals(4.0d, f01.calculate(2.0d));
		assertEquals(9.0d, f01.calculate(3.0d));
		
		Function f02 = new FunctionImpl("x^(1/3) + 5");
		assertEquals(5.0d, f02.calculate(0.0d));
		assertEquals(6.0d, f02.calculate(1.0d));
		assertEquals(7.0d, f02.calculate(8.0d));
		assertEquals(8.0d, f02.calculate(27.0d));
		
		
		try {
			new FunctionImpl("x**2");
			fail("Bad formed function.");
		} catch (Throwable e) {
			// expected
		}
	}
	
	public void testTrigonometricFunction() throws InvalidFunctionException {
		Function f01 = new FunctionImpl("sin(x)");
		assertEquals(0.0d, f01.calculate(0.0d));
		
		Function f02 = new FunctionImpl("3sin(x)*x");
		assertEquals(0.0d, f02.calculate(0.0d));
		
		@SuppressWarnings("unused")
		Function f03 = new FunctionImpl("0.05*x^3-0.4*x^2+3sin(x)*x");
	}
	
	public void testDerivative() throws InvalidFunctionException {
		Function f01 = new FunctionImpl("x^2");
		assertEquals(2.0d, f01.derivative().calculate(1.0d));
		assertEquals(4.0d, f01.derivative().calculate(2.0d));
		
		Function f02 = new FunctionImpl("2x^2");
		f02 = f02.derivative();
		assertEquals(4000.0, f02.calculate(1000), 0.0001);
	}
	
	public void testGetPoints() throws InvalidFunctionException {
		Function f01 = new FunctionImpl("2x");
		List<Point> expectedValues = new ArrayList<Point>();
		expectedValues.add(new PointImpl(1,2));
		expectedValues.add(new PointImpl(2,4));
		expectedValues.add(new PointImpl(3,6));
		
		List<Point> result = f01.getPoints(1.0, 3.0, 1.0);
		
		for (int i = 0; i < expectedValues.size(); i++) {
			Point e = expectedValues.get(i);
			Point r = result.get(i);
			assertEquals(e.getX(), r.getX());
			assertEquals(e.getY(), r.getY());
		}
			
	}
	
	public void testInvalidFunction(){
	    
	    try {
		new FunctionImpl("1*/2");
		fail();
	    } catch (InvalidFunctionException ife) {
		assertEquals("Unexpected symbol \"/\" found at line 1 and column 3", ife.getMessage());
	    }
	    
	    
	}
	
}
