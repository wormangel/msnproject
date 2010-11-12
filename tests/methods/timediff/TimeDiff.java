package methods.timediff;


import org.junit.Assert;
import org.junit.Test;

import br.edu.ufcg.msnlab.InvalidFunctionException;
import br.edu.ufcg.msnlab.methods.newtonraphson.NewtonRaphsonSolverImpl;
import br.edu.ufcg.msnlab.methods.petkovic.PetkovicSolverImpl;
import br.edu.ufcg.msnlab.methods.secant.SecantSolverImpl;
import br.edu.ufcg.msnlab.misc.FunctionImpl;

// Coloquei cada medida de tempo repetida em vez de usar setUp e tearDown pra
// dar a medida mais fiel possível, tirando assim o tempo perdido com chamada de
// método, etc.
public class TimeDiff {
	
	@Test
	public void func1Time() throws InvalidFunctionException, Exception {
		long tempInicial, tempFinal, dif;
		String func1 = "log(x^2+1)*(1/2) - sin(100*x)*(1/x)";
		System.out.println(func1);
		
		tempInicial = System.currentTimeMillis();  
		Assert.assertNotNull(new NewtonRaphsonSolverImpl().solve(new FunctionImpl(func1), 1.6, 0.00000000000001)); 
		tempFinal = System.currentTimeMillis();  
		dif = (tempFinal - tempInicial);  
		System.out.println("Newton: " + dif + " milisegundos");
		
		tempInicial = System.currentTimeMillis();  
		Assert.assertNotNull(new SecantSolverImpl().solve(new FunctionImpl(func1), 1.6, 1.7, 0.00000000000001)); 
		tempFinal = System.currentTimeMillis();  
		dif = (tempFinal - tempInicial);  
		System.out.println("Secante: " + dif + " milisegundos");
		
		tempInicial = System.currentTimeMillis();  
		Assert.assertEquals(5, new PetkovicSolverImpl().solve(new FunctionImpl(func1), 1.6, 0.00000000000001).size()); 
		tempFinal = System.currentTimeMillis();  
		dif = (tempFinal - tempInicial);  
		System.out.println("Petkovic: " + dif + " milisegundos");
		System.out.println("---------------------\n");
	}
	
	@Test
	public void func2Time() throws InvalidFunctionException, Exception {
		long tempInicial, tempFinal, dif;
		String func2 = "(x^15 + 1)*e^((x^2)-1)";
		System.out.println(func2);
		
		tempInicial = System.currentTimeMillis();  
		Assert.assertNotNull(new NewtonRaphsonSolverImpl().solve(new FunctionImpl(func2), 1.7, 0.00000000000001)); 
		tempFinal = System.currentTimeMillis();  
		dif = (tempFinal - tempInicial);  
		System.out.println("Newton: " + dif + " milisegundos");
		
		tempInicial = System.currentTimeMillis();  
		Assert.assertNotNull(new SecantSolverImpl().solve(new FunctionImpl(func2), 1.6, 1.7, 0.00000000000001)); 
		tempFinal = System.currentTimeMillis();  
		dif = (tempFinal - tempInicial);  
		System.out.println("Secante: " + dif + " milisegundos");
		
		
		tempInicial = System.currentTimeMillis();  
		Assert.assertNotNull(new PetkovicSolverImpl().solve(new FunctionImpl(func2), 1.7, 0.00000000000001)); 
		tempFinal = System.currentTimeMillis();  
		dif = (tempFinal - tempInicial);  
		System.out.println("Petkovic: " + dif + " milisegundos");
		System.out.println("---------------------\n");
	}
	
	
	@Test
	public void func3Time() throws InvalidFunctionException, Exception {
		long tempInicial, tempFinal, dif;
		String func3 = "x^10 - 4*(x^9) + 5*(x^8) - x^2 + 4*x - 5";
		System.out.println(func3);
		
		tempInicial = System.currentTimeMillis();  
		Assert.assertNotNull(new NewtonRaphsonSolverImpl().solve(new FunctionImpl(func3), 4, 0.00000000000001)); 
		tempFinal = System.currentTimeMillis();  
		dif = (tempFinal - tempInicial);  
		System.out.println("Newton: " + dif + " milisegundos");
		
		tempInicial = System.currentTimeMillis();  
		Assert.assertNotNull(new SecantSolverImpl().solve(new FunctionImpl(func3), 4, 4.1, 0.00000000000001)); 
		tempFinal = System.currentTimeMillis();  
		dif = (tempFinal - tempInicial);  
		System.out.println("Secante: " + dif + " milisegundos");
		
		tempInicial = System.currentTimeMillis();  
		Assert.assertNotNull(new PetkovicSolverImpl().solve(new FunctionImpl(func3), 4, 0.00000000000001)); 
		tempFinal = System.currentTimeMillis();  
		dif = (tempFinal - tempInicial);  
		System.out.println("Petkovic: " + dif + " milisegundos");
		System.out.println("---------------------\n");
	}
	
	@Test
	public void func4Time() throws InvalidFunctionException, Exception {
		long tempInicial, tempFinal, dif;
		String func3 = "x^2";
		System.out.println(func3);
		
		tempInicial = System.currentTimeMillis();  
		Assert.assertNotNull(new NewtonRaphsonSolverImpl().solve(new FunctionImpl(func3), 4, 0.00000000000001)); 
		tempFinal = System.currentTimeMillis();  
		dif = (tempFinal - tempInicial);  
		System.out.println("Newton: " + dif + " milisegundos");
		
		tempInicial = System.currentTimeMillis();  
		Assert.assertNotNull(new SecantSolverImpl().solve(new FunctionImpl(func3), 4, 4.1, 0.00000000000001)); 
		tempFinal = System.currentTimeMillis();  
		dif = (tempFinal - tempInicial);  
		System.out.println("Secante: " + dif + " milisegundos");
		
		tempInicial = System.currentTimeMillis();  
		Assert.assertNotNull(new PetkovicSolverImpl().solve(new FunctionImpl(func3), 4, 0.00000000000001)); 
		tempFinal = System.currentTimeMillis();  
		dif = (tempFinal - tempInicial);  
		System.out.println("Petkovic: " + dif + " milisegundos");
		System.out.println("---------------------\n");
	}
	
	@Test
	public void func5Time() throws InvalidFunctionException, Exception {
		long tempInicial, tempFinal, dif;
		String func3 = "sin (log (x^2+1))";
		System.out.println(func3);
		
		tempInicial = System.currentTimeMillis();  
		Assert.assertNotNull(new NewtonRaphsonSolverImpl().solve(new FunctionImpl(func3), 90, 0.00000000000001)); 
		tempFinal = System.currentTimeMillis();  
		dif = (tempFinal - tempInicial);  
		System.out.println("Newton: " + dif + " milisegundos");
		
		tempInicial = System.currentTimeMillis();  
		Assert.assertNotNull(new SecantSolverImpl().solve(new FunctionImpl(func3), 90, 90.1, 0.00000000000001)); 
		tempFinal = System.currentTimeMillis();  
		dif = (tempFinal - tempInicial);  
		System.out.println("Secante: " + dif + " milisegundos");
		
		tempInicial = System.currentTimeMillis();  
		Assert.assertNotNull(new PetkovicSolverImpl().solve(new FunctionImpl(func3), 90, 0.00000000000001)); 
		tempFinal = System.currentTimeMillis();  
		dif = (tempFinal - tempInicial);  
		System.out.println("Petkovic: " + dif + " milisegundos");
		System.out.println("---------------------\n");
	}
	
	@Test
	public void func6Time() throws InvalidFunctionException, Exception {
		long tempInicial, tempFinal, dif;
		String func3 = "x^2+x-6";
		System.out.println(func3);
		
		tempInicial = System.currentTimeMillis();  
		Assert.assertNotNull(new NewtonRaphsonSolverImpl().solve(new FunctionImpl(func3), 4, 0.00000000000001)); 
		tempFinal = System.currentTimeMillis();  
		dif = (tempFinal - tempInicial);  
		System.out.println("Newton: " + dif + " milisegundos");
		
		tempInicial = System.currentTimeMillis();  
		Assert.assertNotNull(new SecantSolverImpl().solve(new FunctionImpl(func3), 4, 4.1, 0.00000000000001)); 
		tempFinal = System.currentTimeMillis();  
		dif = (tempFinal - tempInicial);  
		System.out.println("Secante: " + dif + " milisegundos");
		
		tempInicial = System.currentTimeMillis();  
		Assert.assertNotNull(new PetkovicSolverImpl().solve(new FunctionImpl(func3), 4, 0.00000000000001)); 
		tempFinal = System.currentTimeMillis();  
		dif = (tempFinal - tempInicial);  
		System.out.println("Petkovic: " + dif + " milisegundos");
		System.out.println("---------------------\n");
	}
	
	@Test
	public void func7Time() throws InvalidFunctionException, Exception {
		long tempInicial, tempFinal, dif;
		String func3 = "x^3-x-1";
		System.out.println(func3);
		
		tempInicial = System.currentTimeMillis();  
		Assert.assertNotNull(new NewtonRaphsonSolverImpl().solve(new FunctionImpl(func3), 4, 0.00000000000001)); 
		tempFinal = System.currentTimeMillis();  
		dif = (tempFinal - tempInicial);  
		System.out.println("Newton: " + dif + " milisegundos");
		
		tempInicial = System.currentTimeMillis();  
		Assert.assertNotNull(new SecantSolverImpl().solve(new FunctionImpl(func3), 4, 4.1, 0.00000000000001)); 
		tempFinal = System.currentTimeMillis();  
		dif = (tempFinal - tempInicial);  
		System.out.println("Secante: " + dif + " milisegundos");
		
		tempInicial = System.currentTimeMillis();  
		Assert.assertNotNull(new PetkovicSolverImpl().solve(new FunctionImpl(func3), 4, 0.00000000000001)); 
		tempFinal = System.currentTimeMillis();  
		dif = (tempFinal - tempInicial);  
		System.out.println("Petkovic: " + dif + " milisegundos");
		System.out.println("---------------------\n");
	}
	
}
