package fr.dawan.spring.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LogInterceptor extends HandlerInterceptorAdapter {

	// Intercepte les requêtes avant qu'elles arrivent dans nos controllers
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		System.out.println("Request URL : " + request.getRequestURL());
		
		return super.preHandle(request, response, handler);
	}
	
	// Intercepte les requêtes après qu'elles soient passées par nos controllers
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}
	
	// Fait un traitement une fois que l'aller retour requete reponse est terminé
 	@Override
 	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
 			throws Exception {
 		// TODO Auto-generated method stub
 		super.afterCompletion(request, response, handler, ex);
 	}

}
