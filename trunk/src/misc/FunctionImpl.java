package misc;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import exceptions.InvalidFunctionException;


import mathExpr.ExpressionConfiguration;
import mathExpr.evaluator.complexEvaluator.ComplexType;
import mathExpr.evaluator.realEvaluator.Real;
import mathExpr.evaluator.realEvaluator.RealType;
import mathExpr.parser.Expression;
import mathExpr.parser.ExpressionFactory;
import mathExpr.parser.javacc.ParseException;
import mathExpr.parser.javacc.Parser;
import mfc.field.Complex;

public class FunctionImpl implements Function {
	
	private static final double DEFAULT_STEP = 0.01;
	private static final double DEFAULT_MAX = 10.d;
	private static final double DEFAULT_MIN = -10.0d;
	private String expression;
	private ExpressionConfiguration config;
	
	/**
	 * @param expression
	 */
	public FunctionImpl(String expression) throws InvalidFunctionException {
		this.expression = expression;
		this.config = new ExpressionConfiguration();
		
		ExpressionFactory ef = config.getExpressionFactory();
		Parser p = new Parser(new StringReader(expression), ef);
		try {
		    p.parse();
		} catch (ParseException e) {
		    throw new InvalidFunctionException(e.currentToken.next.toString(), e.currentToken.next.beginLine, e.currentToken.next.beginColumn);
		}
		
		config.setExpression(this.expression);
	}
	
	private FunctionImpl(Expression expression) {
		//FIXME search way to set string expression
		this.expression = null;
		this.config = new ExpressionConfiguration();
		config.setExpression(expression);
	}

	/**
	 * @return the expression
	 */
	public String getExpression() {
		return expression;
	}

	/* (non-Javadoc)
	 * @see misc.Function#calculate(double)
	 */
	public double calculate(double value) {
		config.setType(RealType.TYPE);
		config.defineVariable("x", new Real(value), RealType.TYPE);
		Real result = (Real) config.evaluateExpression();
		return result.getValue();
	}
	
	/*
	 * (non-Javadoc)
	 * @see misc.Function#calculate(mfc.field.Complex)
	 */
	public Complex calculate(Complex value) {
		config.setType(ComplexType.TYPE);
		config.defineVariable("x", new Complex(value), ComplexType.TYPE);
		Complex result = (Complex) config.evaluateExpression();
		return result;
	}

	/* (non-Javadoc)
	 * @see misc.Function#derivative()
	 */
	public Function derivative() {
		return new FunctionImpl(config.differentiate("x"));
	}

	/* (non-Javadoc)
	 * @see misc.Function#getPoints()
	 */
	public List<Point> getPoints() {
		return getPoints(DEFAULT_MIN, DEFAULT_MAX, DEFAULT_STEP);
	}

	/* (non-Javadoc)
	 * @see misc.Function#getPoints(double, double, double)
	 */
	public List<Point> getPoints(double min, double max, double step) {
		double actual = min;
		List<Point> result = new ArrayList<Point>();
		while (actual <= max){
			result.add(new PointImpl(actual, this.calculate(actual)));
			actual = actual + step;
		}
		return result;
	}
	
}
