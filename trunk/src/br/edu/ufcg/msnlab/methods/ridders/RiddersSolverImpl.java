package br.edu.ufcg.msnlab.methods.ridders;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.msnlab.misc.Function;

/**
 * 
 * @author Eugenia de Sousa
 * @author Jaluska Rodrigues
 * 
 */
public class RiddersSolverImpl implements RiddersSolver{

	public List<RiddersResult> solve(Function funcion, double min, double max,
			double tolerance) {
		
		return ridders(funcion, min, max, tolerance, Integer.MAX_VALUE);
	}

	public List<RiddersResult> solve(Function funcion, double min, double max,
			double tolerance, int maxIterations) {
		
		return ridders(funcion, min, max, tolerance, maxIterations);
	}

	public List<RiddersResult> solve(Function funcion, double tolerance) {
		double x0 = Math.random();
		double x1 = Math.random();
		while(x1 == x0 && x1<x0){
			x1= Math.random();
		}
		
		return ridders(funcion, x0, x1, tolerance, Integer.MAX_VALUE);
	}

	public List<RiddersResult> ridders(Function funcion, double min, double max,
			double tolerance, int maxIterations){
		
		int j;
		List<RiddersResult> result = new ArrayList<RiddersResult>();
		double ans,fh,fl,fm,fnew,s,xh,xl,xm,xnew;
		fl= funcion.calculate(min);
		fh=funcion.calculate(max);
		if ((fl > 0.0 && fh < 0.0) || (fl < 0.0 && fh > 0.0)) {
			xl=min;
			xh=max;
			ans=0;	
			for (j=1;j<=maxIterations;j++) {
				xm=0.5*(xl+xh);
				
				fm=funcion.calculate(xm);
				s=Math.sqrt(fm*fm-fl*fh);
				if (s == 0){
					result.add(new RiddersResultImpl(xh,xl,xm));
					return result;
				}
				xnew=xm+(xm-xl)*((fl >= fh ? 1.0 : -1.0)*fm/s); 
				result.add(new RiddersResultImpl(xh,xl,xnew));
				if (Math.abs(xnew-ans) <= tolerance) return result;
				ans=xnew;
				fnew=funcion.calculate(ans);
				if (fnew == 0.0) return result; 
				if (fm<0 && fnew>0) { 
					xl=xm; 
					fl=fm;
					xh=ans;
					fh=fnew;
				} else if (fnew>0 && fm>0) {
					xh=ans;
					fh=fnew;
				} else if (fnew<0 && fm<0) {
					xl=ans;
					fl=fnew;
				} 
				if (Math.abs(xh-xl) <= tolerance) return result;
				}
				
				}
				else {
				if (fl == 0.0) return result;
				if (fh == 0.0) return result;
				
				}
			return null; 
				
	}
}
