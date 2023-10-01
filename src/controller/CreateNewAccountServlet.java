package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AnimalDetails;
import model.AnimalList;
import model.Owner;

/**
 * Servlet implementation class CreatNewAccountServlet
 */
@WebServlet("/createNewAccountServlet")
public class CreateNewAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewAccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ListAnimalHelper lah = new ListAnimalHelper();
		String ownershipName = request.getParameter("ownershipName");
		String ownerName = request.getParameter("ownerName");
		
		String[] selectedAnimals = request.getParameterValues("allAnimalsToAdd");
		List<AnimalList> selectedAnimalsInList = new ArrayList<AnimalList>();
		
		if(selectedAnimals != null && selectedAnimals.length > 0) {
			for(int i = 0; i<selectedAnimals.length; i++) {
				System.out.println(selectedAnimals[i]);
				AnimalList c = lah.searchForAnimalById(Integer.parseInt(selectedAnimals[i]));
				selectedAnimalsInList.add(c);
			}
		}
		Owner owner = new Owner(ownerName);
		AnimalDetails adt = new AnimalDetails(ownershipName, owner);
		adt.setListOfAnimals(selectedAnimalsInList);
		AnimalDetailsHelper adh = new AnimalDetailsHelper();
		adh.insertNewAnimalDetails(adt);
		
		System.out.println("Success!");
		System.out.println(adt.toString());
		
		getServletContext().getRequestDispatcher("/viewAllAccountsServlet").forward(request,  response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
