package filtro;

import java.io.IOException;
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

import modelo.Cliente;

/**
 * Servlet Filter implementation class FiltroAdmin
 */
@WebFilter("/administracao/*")
public class FiltroAdmin implements Filter {

    /**
     * Default constructor. 
     */
    public FiltroAdmin() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
     * @param request
     * @param response
     * @param chain
     * @throws java.io.IOException
     * @throws javax.servlet.ServletException
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
    @Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		Cliente u = null;
		
		HttpSession session = ((HttpServletRequest) request).getSession(false);
		
		if(session != null){
			u = (Cliente) session.getAttribute("admin-logado");
		}
		
		if (u == null){
			String contextPath = ((HttpServletRequest) request).getContextPath();
			((HttpServletResponse) response).sendRedirect(contextPath + "/index.xhtml");
		} else {
			chain.doFilter(request, response);
		}
	}

	/**
     * @param fConfig
     * @throws javax.servlet.ServletException
	 * @see Filter#init(FilterConfig)
	 */
    @Override
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
