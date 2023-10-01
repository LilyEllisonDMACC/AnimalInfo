/**
 * @author tehli - lbellison
 * CIS175 - Fall 2023
 * Sep 29, 2023
 */

import java.util.List;

import controller.OwnerHelper;
import model.Owner;

/**
 * @author LILY ELLISON - LBELLISON
 * CIS175 - FALL 2023
 * Sep 29, 2023
 */
public class OwnerTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Owner bill = new Owner("Bill");
		
		OwnerHelper oh = new OwnerHelper();
		
		oh.insertOwner(bill);;
		
		List<Owner> allOwners = oh.showAllOwners();
		for(Owner a: allOwners) {
			System.out.println(a.toString());
		}

	}

}
