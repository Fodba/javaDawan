package fr.dawan.projetjaxrs.ws;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MultivaluedMap;

@Path("/bases")
public class BasesWS {

	@Context
	private HttpServletRequest request;

	@GET
	@Path("/hello1")
	@Produces("text/html;charset=UTF-8")
	public String sayHello() {
		return "MES DEBUTS EN JAX-RS";
	}

	@GET
	@Path("/hello2/{msg}")
	@Produces("text/html;charset=UTF-8")
	public String sayHello2(@PathParam("msg") String msg) {
		return "hello : " + msg;
	}

	@GET
	@Path("/hello3")
	@Produces("text/html;charset=UTF-8")
	public String sayHello3(@QueryParam("msg") String msg) {
		return "hello : " + msg;
	}

	@GET
	@Path("/hello4")
	@Produces("text/html;charset=UTF-8")
	public String sayHello4(@MatrixParam("msg") String msg, @MatrixParam("nom") String nom) {
		return msg + "<br>Hello : " + nom;
	}

	@GET
	@Path("/hello5")
	@Produces("text/html;charset=UTF-8")
	public String sayHello5(@Context HttpServletRequest req) {
		String msg = req.getParameter("msg");
		String[] noms = req.getParameterValues("nom");
//		Map<String, String[]> listParam = req.getParameterMap();

		StringBuilder sb = new StringBuilder();
		sb.append("msg = " + msg + "<br><br>");
		for (String string : noms) {
			sb.append(string + "<br>");
		}
		return sb.toString();
	}

//	@GET
//	@Path("/hello5")
//	@Produces("text/html;charset=UTF-8")
//	public String sayHello5(@Context HttpServletRequest req) {
//		String msg = req.getParameter("msg");
//		String[] noms = req.getParameterValues("nom");
//		StringBuilder sb = new StringBuilder();
//		sb.append("msg=").append(msg).append("<br />");
//		sb.append("noms=");
//		for (String n : noms) {
//			sb.append(n).append(", ");
//		}
//		return sb.toString();
//	}

	@GET
	@Path("/navigateur")
	@Produces("text/html;charset=UTF-8")
	public String getHeader(@HeaderParam("user-agent") String userAgent) {
		return "Navigateur utilisé : " + userAgent;
	}

	@GET
	@Path("/headers")
	@Produces("text/html;charset=UTF-8")
	public String getAllHeaders(@Context HttpHeaders headers) {
		StringBuilder sb = new StringBuilder();
		MultivaluedMap<String, String> mvm = headers.getRequestHeaders();
		for (String cle : mvm.keySet()) {
			sb.append(cle + "=");
			List<String> valeurs = mvm.get(cle);
			for (String v : valeurs) {
				sb.append(v + " - ");
			}
			sb.append("<br />");
		}
		return sb.toString();
	}

}