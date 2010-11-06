package br.edu.ufcg.msnlab.methods.wijngaardenDekerBrent;

import java.util.LinkedList;
import java.util.List;

import br.edu.ufcg.msnlab.misc.Function;


/**
 * 
 * @author Gabriel Feitosa
 * @author Rafael Pessoa
 *
 */
public class WijngaardenDekerBrentSolver implements BrentSolver{
	private double a,b,c,d,e,p,q,r,s,z,fa,fb,fc,tol;
	private int iter;
	
	
	/**
	 * 
	 * @param function
	 * @param min
	 * @param max
	 * @param tolerance
	 * @return 
	 * @throws WijngaardenDekerBrentException 
	 */
	public List<BrentResult> solve(Function function, double min, double max,
			double tolerance) throws WijngaardenDekerBrentException {
		if(max <= min){
			throw new WijngaardenDekerBrentException("Err: The value of max is less equal than to the value of min");
		}
		List<BrentResult> list = new LinkedList<BrentResult>();
		a = min;
		b = max;
		fa = function.calculate(a);
		fb = function.calculate(b);
		if(fa*fb > 0){
			throw new WijngaardenDekerBrentException("The function signal was not changed in the interval");
		}
		c = b;
		fc = fb;
		iter = 0;
		while(true){
			if(fb*fc>0){
				c = a;
				fc = fa;
				d = b-a;
				e= d;
			}
			if(Math.abs(fc) < Math.abs(fb)){
				a = b;
				b = c;
				c = a;
				fa = fb;
				fb = fc;
				fc = fa;
			}
			tol = 2*tolerance*Math.max(Math.abs(b), 1);
			z = (c -b)/2;
			BrentResult br = new WijngaardenDekerBrentResult();
			br.setIteration(iter);
			br.setX(b);
			br.setFx(fb);
			br.setError(z);
			list.add(br);
			if(Math.abs(z) <= tol || fb==0){
				break;
			}
			if(Math.abs(e) >= tol && Math.abs(fa) > Math.abs(fb)){
				s = fb/fa;
				if(a == c){
					p = 2*z*s;
					q = 1-s;
				}else{
					q = fa/fc;
					r = fb/fc;
					p = s*(2*z*q*(q-r)-(b-a)*(r-1));
					q = (q-1)*(r-1)*(s-1);
				}
				if(p>0){
					q = -q;
				}else{
					p = -p;
				}
				if(2*p<Math.min(3*z*q-Math.abs(tol*q),Math.abs(e*q))){
					e = d;
					d = p/q;
				}else{
					d = z;
					e = z;
				}
			}else{
				d = z;
				e = z;
			}
			a = b;
			fa = fb;
			if(Math.abs(d) > tol){
				b += d;
			}else{
				b = b+ Math.signum(z)*tol;
			}
			iter++;
			fb = function.calculate(b);
		}
		if(Math.abs(z) <=tol || fb ==0){
			// Foi possivel calcular as raizes
		}else{
			throw new WijngaardenDekerBrentException("It's not possible to result this equation");
		}
		return list;
	}

	/**
	 * TODO
	 * @param function
	 * @param min
	 * @param max
	 * @param tolerance
	 * @return
	 * @throws WijngaardenDekerBrentException 
	 */
	public List<BrentResult> solve(Function function, double min, double max,
			double tolerance, int maxIterations) throws WijngaardenDekerBrentException {
		if(max <= min){
			throw new WijngaardenDekerBrentException("Err: The value of max is less equal than to the value of min");
		}

		List<BrentResult> list = new LinkedList<BrentResult>();
		a = min;
		b = max;
		fa = function.calculate(a);
		fb = function.calculate(b);
		if(fa*fb > 0){
			throw new WijngaardenDekerBrentException("The function signal was not changed in the interval");
		}
		c = b;
		fc = fb;
		iter = 0;
		while(true){
			if(fb*fc>0){
				c = a;
				fc = fa;
				d = b-a;
				e= d;
			}
			if(Math.abs(fc) < Math.abs(fb)){
				a = b;
				b = c;
				c = a;
				fa = fb;
				fb = fc;
				fc = fa;
			}
			tol = 2*tolerance*Math.max(Math.abs(b), 1);
			z = (c -b)/2;
			BrentResult br = new WijngaardenDekerBrentResult();
			br.setIteration(iter);
			br.setX(b);
			br.setFx(fb);
			br.setError(z);
			list.add(br);
			if(Math.abs(z) <= tol || fb==0 || iter >= maxIterations ){
				break;
			}
			if(Math.abs(e) >= tol && Math.abs(fa) > Math.abs(fb)){
				s = fb/fa;
				if(a == c){
					p = 2*z*s;
					q = 1-s;
				}else{
					q = fa/fc;
					r = fb/fc;
					p = s*(2*z*q*(q-r)-(b-a)*(r-1));
					q = (q-1)*(r-1)*(s-1);
				}
				if(p>0){
					q = -q;
				}else{
					p = -p;
				}
				if(2*p<Math.min(3*z*q-Math.abs(tol*q),Math.abs(e*q))){
					e = d;
					d = p/q;
				}else{
					d = z;
					e = z;
				}
			}else{
				d = z;
				e = z;
			}
			a = b;
			fa = fb;
			if(Math.abs(d) > tol){
				b += d;
			}else{
				b = b+ Math.signum(z)*tol;
			}
			iter++;
			fb = function.calculate(b);
		}
		if(Math.abs(z) <=tol || fb ==0){
			// Foi possivel calcular as raizes
		}else{
			throw new WijngaardenDekerBrentException("It's not possible to result this equation");
		}
		return list;
	}

	/*
	 * (non-Javadoc)
	 * @see methods.Solver#solve(misc.Function, double)
	 */
	public List<BrentResult> solve(Function funcion, double tolerance) {
		return null;
	}
}
