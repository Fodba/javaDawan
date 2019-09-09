package fr.dawan.teegraph.filters;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class MyFirstFilter
 */
@WebFilter(urlPatterns = {"/session/*"}, dispatcherTypes = {DispatcherType.FORWARD, DispatcherType.REQUEST})
public class AuthenticationFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AuthenticationFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		System.out.println("je suis dans le filter");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		HttpSession session = req.getSession(false);
		
		if(session!=null) {
			// SI l'utilisateur n'est pas identifié il sera automatiquement redirigé vers la page d'accueil (index.jsp)
			if(session.getAttribute("userID") == null || ((String) String.valueOf(session.getAttribute("userID"))).isEmpty()) {
				req.setAttribute("msgErrorNonAuthentifie", "Accès interdit si l'utilisateur n'est pas authentifié");
				req.getRequestDispatcher("/authentication.jsp").forward(request, response);
			}
		} else {
			req.setAttribute("msgErrorNonAuthentifie", "Accès interdit si l'utilisateur n'est pas authentifié");
			req.getRequestDispatcher("/authentication.jsp").forward(request, response);
		}
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
