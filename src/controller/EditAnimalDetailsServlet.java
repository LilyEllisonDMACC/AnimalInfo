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
 * Servlet implementation class EditAnimalDetailsServlet
 */
@WebServlet("/editAnimalDetailsServlet")
public class EditAnimalDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditAnimalDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AnimalDetailsHelper adh = new AnimalDetailsHelper();
		ListAnimalHelper lah = new ListAnimalHelper();
		OwnerHelper oh = new OwnerHelper();
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		AnimalDetails animalToUpdate = adh.searchForAnimalDetailsById(tempId);
		
		String newAcountName = request.getParameter("ownershipName");
		
		String ownerName = request.getParameter("ownerName");
		Owner newOwner = oh.findOwner(ownerName);
		
		try {
			String[] selectedAnimals = request.getParameterValues("allAnimalsToAdd");
			List<AnimalList> selectedAnimalsInList = new ArrayList<AnimalList>();
			
			for (int i=0; i < selectedAnimals.length; i++) {
				System.out.println(selectedAnimals[i]);
				AnimalList c = lah.searchForAnimalById(Integer.parseInt(selectedAnimals[i]));
				selectedAnimalsInList.add(c);
			}
			animalToUpdate.setListOfAnimals(selectedAnimalsInList);
		} catch (NullPointerException ex) {
			List<AnimalList> selectedAnimalsInList = new ArrayList<AnimalList>();
			animalToUpdate.setListOfAnimals(selectedAnimalsInList);
		}
		
		animalToUpdate.setOwnershipName(newAcountName);
		animalToUpdate.setOwner(newOwner);
		adh.updateAccount(animalToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllAccountsServlet").forward(request, response);
		
	}

}
