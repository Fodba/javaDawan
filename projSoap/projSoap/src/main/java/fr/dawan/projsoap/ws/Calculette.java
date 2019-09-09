package fr.dawan.projsoap.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService
public class Calculette {
	@WebMethod
	public @WebResult(name = "resultat") int addition(@WebParam(name = "a") int n1, @WebParam(name = "b") int n2) {
		return n1 + n2;
	}

	@WebMethod
	public int soustraction(int n1, int n2) {
		return n1 - n2;
	}
}
