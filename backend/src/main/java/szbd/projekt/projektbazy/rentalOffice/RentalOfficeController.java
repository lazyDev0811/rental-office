package szbd.projekt.projektbazy.rentalOffice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import szbd.projekt.projektbazy.adress.Adress;



@RestController
public class RentalOfficeController {

	@Autowired
	private RentalOfficeService rentalOfficeService;
	
	@RequestMapping(method=RequestMethod.GET,value="/rentalOffice/all")
	public List<RentalOffice> getAllRentalOfficies() {
		
		return rentalOfficeService.getAllRentalOffices();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/rentalOffice/{idRentalOffice}")
	public Optional<RentalOffice> getRentalOfficies(@PathVariable Integer idRentalOffice) {
		
		return rentalOfficeService.getRentalOffice(idRentalOffice);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/rentalOffice/{idAdress}")
	public void addRentalOffice(@RequestBody RentalOffice rentalOffice, @PathVariable Integer idAdress) {
		
		rentalOffice.setAdress(new Adress(idAdress, "", "", "", "", ""));
		rentalOfficeService.addRentalOffice(rentalOffice);
	}
	
	
	@RequestMapping(method=RequestMethod.DELETE,value="/rentalOffice/{idRentalOffice}")
	public void deleteRentalOffice(@PathVariable Integer idRentalOffice) {
		
		rentalOfficeService.deleteRentalOffice(idRentalOffice);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/rentalOffice/{idRentalOffice}/{idAdress}")
	public void updateRentalOffice(@RequestBody RentalOffice rentalOffice,@PathVariable Integer idRentalOffice,
			@PathVariable Integer idAdress) {

		rentalOffice.setAdress(new Adress(idAdress, "", "", "", "", ""));
		rentalOfficeService.updateRentalOffice(idRentalOffice, rentalOffice);
	}

}

