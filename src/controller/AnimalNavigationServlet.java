package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AnimalDetails;

/**
 * Servlet implementation class AnimalNavigationServlet
 */
@WebServlet("/animalNavigationServlet")
public class AnimalNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnimalNavigationServlet() {
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
		String act = request.getParameter("doThisToAnimal");
		
		if(act==null) {
			getServletContext().getRequestDispatcher("/viewAllAccountsServlet").forward(request, response);
		} else if (act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				AnimalDetails animalToDelete = adh.searchForAnimalDetailsById(tempId);
				adh.deleteAnimal(animalToDelete);
			} catch (NumberFormatException e) {
				System.out.println("Forgot to click a button");
			} finally {
				getServletContext().getRequestDispatcher("/viewAllAccountsServlet").forward(request, response);
			}
		} else if (act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				AnimalDetails accountToEdit = adh.searchForAnimalDetailsById(tempId);
				request.setAttribute("accountToEdit", accountToEdit);
				
				ListAnimalHelper adhForAnimals = new ListAnimalHelper();
				
				request.setAttribute("allAnimals",  adhForAnimals.showAllAnimals());
				
				if(adhForAnimals.showAllAnimals().isEmpty()) {
					request.setAttribute("allAnimals",  " ");
				}
				
				getServletContext().getRequestDispatcher("/edit-account.jsp").forward(request, response);
			} catch (NumberFormatException e) {
				getServletContext().getRequestDispatcher("/viewAllAccountsServlet").forward(request, response);
			}
		} else if (act.equals("add")) {
			getServletContext().getRequestDispatcher("/addAnimalsForOwnerServlet").forward(request, response);
		}
	}

}
