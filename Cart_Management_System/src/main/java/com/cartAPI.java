package com;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class cartAPI
 */
@WebServlet("/cartAPI")
public class cartAPI extends HttpServlet {
	
	cart cobject = new cart();
    public cartAPI() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String output = cobject.insertCart(request.getParameter("ID"),request.getParameter("Item_Code"), 
				 request.getParameter("Item_Name"), 
				request.getParameter("Price"), 
				request.getParameter("Qty")); 
				response.getWriter().write(output);
	}
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map paras = getParasMap(request); 
		 String output = cobject.updateCart(paras.get("hidcartIDSave").toString(), 
		 paras.get("Item_Code").toString(), 
		 paras.get("Item_Name").toString(), 
		paras.get("Price").toString(), 
		paras.get("Qty").toString()); 
		response.getWriter().write(output);

}
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map paras = getParasMap(request); 
		 String output = cobject.deleteCart(paras.get("CID").toString()); 
		response.getWriter().write(output);
	}


private Map getParasMap(HttpServletRequest request) {
	 Map<String, String> map = new HashMap<String, String>(); 
		try
		 { 
		 Scanner scanner = new Scanner(request.getInputStream(), "UTF-8"); 
		 String queryString = scanner.hasNext() ? 
		 scanner.useDelimiter("\\A").next() : ""; 
		 scanner.close(); 
		 String[] params = queryString.split("&"); 
		 for (String param : params) 
		 { 
		String[] p = param.split("=");
		 map.put(p[0], p[1]); 
		 } 
		 } 
		catch (Exception e) 
		 { 
		 } 
		return map; 
		}
}
