
package methods.bus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import br.edu.ufcg.msnlab.InvalidFunctionException;
import br.edu.ufcg.msnlab.MSNLabException;
import br.edu.ufcg.msnlab.methods.bus.BusAlgorithmRException;
import br.edu.ufcg.msnlab.methods.bus.BusAlgorithmRResult;
import br.edu.ufcg.msnlab.methods.bus.BusAlgorithmRSolver;
import br.edu.ufcg.msnlab.methods.bus.BusAlgorithmRSolverImpl;
import br.edu.ufcg.msnlab.misc.FunctionImpl;

import junit.framework.TestCase;

public class BusAlgorithmRSolverImplTest extends TestCase {

    private BusAlgorithmRSolver algorithmR;

    private double tol = 1e-5;

    Double expectedValue;

    Double receivedValue;

    String function;

    @Override
    protected void setUp() throws Exception {

	super.setUp();
	algorithmR = new BusAlgorithmRSolverImpl();
	function = null;
	expectedValue = null;
	receivedValue = null;
    }

    // f(x) = x
    public void testSimpleFunction() throws MSNLabException {

	assertEquals("x", getVariableToValueMap(new String[] {}, new String[] {}), -1.0, 1.0, 0.0);

    }

    // f(x) = (x + 3)(x - 1)^2
    public void testFunction1() throws MSNLabException {

	function = "(x + 3)(x - 1)^2";

	try {
	    assertEquals(function, getVariableToValueMap(new String[] {}, new String[] {}), 0.0, 2.0, 1.0);
	    fail();
	} catch (BusAlgorithmRException e) {
	}

	assertEquals(function, getVariableToValueMap(new String[] {}, new String[] {}), -4.0, -2.0, -3.0);
    }

    // f(x) = -x^(1/3) + 5
    public void testFunction2() throws MSNLabException {

	assertEquals("-x^(1/3) + 5", getVariableToValueMap(new String[] {}, new String[] {}), 100.0, 200.0, 125.0);

    }

    // f(x) = sin(x)
    public void testFunction3() throws MSNLabException {

	assertEquals("sin(x)", getVariableToValueMap(new String[] {}, new String[] {}), -1.0, 1.0, 0.0);

    }

    // f(x) = 0.05*x^3 - 0.4*x^2 + 3sin(x)*x
    public void testFunction4() throws MSNLabException {

	function = "0.05*x^3 - 0.4*x^2 + 3sin(x)*x";

	assertEquals(function, getVariableToValueMap(new String[] {}, new String[] {}), -3.0, -2.0, -2.651500090414005);

	assertEquals(function, getVariableToValueMap(new String[] {}, new String[] {}), 2.0, 4.0, 2.8927988374882276);

    }

    // I - 1. f(x) = sin(x) - 0.5 in the interval [0, 1.5];
    public void testNumericalResultsI1FromPaper() throws MSNLabException {

	assertEquals("sin(x) - 0.5", getVariableToValueMap(new String[] {}, new String[] {}), 0.0, 1.5,
		0.5235987756689628);

    }

    // I - 2. f(x) = 2*x*e^(-n) + 1 - 2*e^(-n*x) in the interval [0, 1] and n = 1, 2, 3, 4;
    public void testNumericalResultsI2FromPaper() throws MSNLabException {

	function = "2*x*e^(-n) + 1 - 2*e^(-n*x)";

	// n = 1
	assertEquals(function, getVariableToValueMap(new String[] { "n" }, new String[] { "1" }), 0.0, 1.0,
		0.4224778388177959);

	// n = 2
	assertEquals(function, getVariableToValueMap(new String[] { "n" }, new String[] { "2" }), 0.0, 1.0,
		0.3066930140743235);

	// n = 3
	assertEquals(function, getVariableToValueMap(new String[] { "n" }, new String[] { "3" }), 0.0, 1.0,
		0.2237054580913046);

	// n = 4
	assertEquals(function, getVariableToValueMap(new String[] { "n" }, new String[] { "4" }), 0.0, 1.0,
		0.1717191488949503);

    }

    // I - 3. f(x) = (1 + (1 - n)^2 )*x - (1 - n*x)^2 in the inverval [0, 1], and n = 1, 4, 8;
    public void testNumericalResultsI3FromPaper() throws MSNLabException {

	function = "(1 + (1 - n)^2 )*x - (1 - n*x)^2";

	// n = 1
	assertEquals(function, getVariableToValueMap(new String[] { "n" }, new String[] { "1" }), 0.0, 1.0,
		0.38196602381959976);

	// n = 4
	assertEquals(function, getVariableToValueMap(new String[] { "n" }, new String[] { "4" }), 0.0, 1.0,
		0.05860896161492582);

	// n = 8
	assertEquals(function, getVariableToValueMap(new String[] { "n" }, new String[] { "8" }), 0.0, 1.0,
		0.015380919063721177);

    }

    // I - 4. f(x) = x^2 - (1 - x)^n in the interval [0, 1], and n = 1, 5, 10;
    public void testNumericalResultsI4FromPaper() throws MSNLabException {

	function = "x^2 - (1 - x)^n";

	// n = 1
	assertEquals(function, getVariableToValueMap(new String[] { "n" }, new String[] { "1" }), 0.0, 1.0,
		0.6180339887562332);

	// n = 5
	assertEquals(function, getVariableToValueMap(new String[] { "n" }, new String[] { "5" }), 0.0, 1.0,
		0.3459548160248938);

	// n = 10
	assertEquals(function, getVariableToValueMap(new String[] { "n" }, new String[] { "10" }), 0.0, 1.0,
		0.24512233375325895);

    }

    // I - 5. f(x) = (1 + (1 - n)^4)*x - (1 - n*x)^4 in the interval [0, 1], and n = 1, 4, 8;
    public void testNumericalResultsI5FromPaper() throws MSNLabException {

	function = "(1 + (1 - n)^4)*x - (1 - n*x)^4";

	// n = 1
	assertEquals(function, getVariableToValueMap(new String[] { "n" }, new String[] { "1" }), 0.0, 1.0,
		0.2755080409994867);

	// n = 4
	assertEquals(function, getVariableToValueMap(new String[] { "n" }, new String[] { "4" }), 0.0, 1.0,
		0.01030729227513948);

	// n = 8
	assertEquals(function, getVariableToValueMap(new String[] { "n" }, new String[] { "8" }), 0.0, 1.0,
		4.108730319927652E-4);

    }

    // I - 6. f(x) = (x - 1) * e^(-n*x) + x^n in the interval [0, 1], and n = 1, 5, 10
    public void testNumericalResultsI6FromPaper() throws MSNLabException {

	function = "(x - 1) * e^(-n*x) + x^n";

	// n = 1
	assertEquals(function, getVariableToValueMap(new String[] { "n" }, new String[] { "1" }), 0.0, 1.0,
		0.40105841721517244);

	// n = 5
	assertEquals(function, getVariableToValueMap(new String[] { "n" }, new String[] { "5" }), 0.0, 1.0,
		0.5161535187581938);

	// n = 10
	assertEquals(function, getVariableToValueMap(new String[] { "n" }, new String[] { "10" }), 0.0, 1.0,
		0.5395220190717841);

    }

    // II - 1. f(x) = x^n + a*x + b, where n = 3, 5, 9, 19, and 1. a=1 and b=0; 2. a=0 and b=10E-4; 3. a=1 and b=0.001.
    public void testNumericalResultsII1FromPaper() throws MSNLabException {

	function = "x^n + a*x + b";

	// n=3, a=1 and b=0
	assertEquals(function, getVariableToValueMap(new String[] { "n", "a", "b" }, new String[] { "3", "1", "0" }),
		-1.0, 1.0, 0.0);

	// n=3, a=0 and b=0.001
	assertEquals(function,
		getVariableToValueMap(new String[] { "n", "a", "b" }, new String[] { "3", "0", "0.001" }), -1.0, 1.0,
		-0.09999996835509936);

	// n=3, a=1 and b=0.001
	assertEquals(function,
		getVariableToValueMap(new String[] { "n", "a", "b" }, new String[] { "3", "1", "0.001" }), -1.0, 1.0,
		-9.999982915893059E-4);

	// n=5, a=1 and b=0
	assertEquals(function, getVariableToValueMap(new String[] { "n", "a", "b" }, new String[] { "5", "1", "0" }),
		-1.0, 1.0, 0.0);

	assertEquals(function,
		getVariableToValueMap(new String[] { "n", "a", "b" }, new String[] { "5", "0", "0.001" }), -1.0, 1.0,
		-0.2511920623779296);

	// n=5, a=1 and b=0.001
	assertEquals(function,
		getVariableToValueMap(new String[] { "n", "a", "b" }, new String[] { "5", "1", "0.001" }), -1.0, 1.0,
		-9.999999999963953E-4);

	// n=9, a=1 and b=0
	assertEquals(function, getVariableToValueMap(new String[] { "n", "a", "b" }, new String[] { "9", "1", "0" }),
		-1.0, 1.0, 0.0);

	// n=9, a=0 and b=0.001
	assertEquals(function,
		getVariableToValueMap(new String[] { "n", "a", "b" }, new String[] { "9", "0", "0.001" }), -1.0, 1.0,
		-0.4641687374618261);

	// n=9, a=1 and b=0.001
	assertEquals(function,
		getVariableToValueMap(new String[] { "n", "a", "b" }, new String[] { "9", "1", "0.001" }), -1.0, 1.0,
		-0.001);

	// n=19, a=1 and b=0
	assertEquals(function, getVariableToValueMap(new String[] { "n", "a", "b" }, new String[] { "19", "1", "0" }),
		-1.0, 1.0, 0.0);

	// n=19, a=0 and b=0.001
	assertEquals(function, getVariableToValueMap(new String[] { "n", "a", "b" },
		new String[] { "19", "0", "0.001" }), -1.0, 1.0, -0.6951946116317534);

	// n=19, a=1 and b=0.001
	assertEquals(function, getVariableToValueMap(new String[] { "n", "a", "b" },
		new String[] { "19", "1", "0.001" }), -1.0, 1.0, -0.001);

    }

    // Auxiliary methods

    private Map<String, String> getVariableToValueMap(String[] variables, String[] values)
	    throws BusAlgorithmRException {

	if (variables.length != values.length) {
	    throw new IllegalArgumentException("#variables != #values: " + variables.length + " != " + values.length);
	}

	Map<String, String> map = new HashMap<String, String>(variables.length);

	for (int i = 0; i < variables.length; i++) {
	    map.put(variables[i], values[i]);
	}

	return map;
    }

    private void assertEquals(String function, Map<String, String> variableToValue, double lowerBound,
	    double upperBound, double expectedValue) throws BusAlgorithmRException, InvalidFunctionException {

	for (Entry<String, String> entry : variableToValue.entrySet()) {
	    String variable = entry.getKey();
	    String value = entry.getValue();
	    function = function.replaceAll(variable, value);
	}

	List<BusAlgorithmRResult> result = algorithmR.solve(new FunctionImpl(function), lowerBound, upperBound, tol);
	Double receivedValue = last(result);

	assertEquals(expectedValue, receivedValue, tol);

    }

    private Double last(List<BusAlgorithmRResult> list) {

	if (list.size() == 0) {
	    return null;
	}

	return list.get(list.size() - 1).getX();
    }
}
