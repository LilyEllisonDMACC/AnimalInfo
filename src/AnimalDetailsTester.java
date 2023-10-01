/**
 * @author tehli - lbellison
 * CIS175 - Fall 2023
 * Sep 29, 2023
 */

import java.util.ArrayList;
import java.util.List;

import controller.AnimalDetailsHelper;
import controller.OwnerHelper;
import model.AnimalDetails;
import model.AnimalList;
import model.Owner;

/**
 * @author LILY ELLISON - LBELLISON
 * CIS175 - FALL 2023
 * Sep 29, 2023
 */
public class AnimalDetailsTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Owner cameron = new Owner("Cameron");
		
		AnimalDetailsHelper adh = new AnimalDetailsHelper();
		
		AnimalList fido = new AnimalList("Fido", "Canine", "Cancer");
		AnimalList fifi = new AnimalList("Fifi", "Feline", "Diabetes");
		
		List<AnimalList> cameronsAnimals = new ArrayList<AnimalList>();
		cameronsAnimals.add(fido);
		cameronsAnimals.add(fifi);
		
		AnimalDetails cameronsPets = new AnimalDetails("Cameron's Animals", cameron);
		cameronsPets.setListOfAnimals(cameronsAnimals);
		
		adh.insertNewAnimalDetails(cameronsPets);
		
		List<AnimalDetails> allAnimals = adh.getAnimals();
		
		for(AnimalDetails a : allAnimals) {
			System.out.println(a.toString());
		}

	}

}
