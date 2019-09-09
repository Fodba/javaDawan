package fr.dawan.projweb.controleurs;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.dawan.projweb.dao.QcmDao;
import fr.dawan.projweb.entites.Question;
import fr.dawan.projweb.entites.Reponse;

/**
 * Servlet implementation class AdminQcm
 */
public class AdminQcm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminQcm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String action = request.getParameter("action");
		EntityManager em = MyStartupListener.getEmf().createEntityManager();
		if(action !=null) {
			switch (action) {
			case "demarrer":
				long idQcm = Long.parseLong(request.getParameter("idqcm"));
				int ordre = 1;
				
				Question qst = QcmDao.findQuestion(idQcm, ordre, em, false);
				List<Reponse> lRep = QcmDao.findReponses(qst.getId(), em, true);
				request.setAttribute("qst", qst);
				request.setAttribute("lRep", lRep);
				request.getRequestDispatcher("qcm.jsp")
					.forward(request, response);
				break;

			default:
				break;
			}
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
