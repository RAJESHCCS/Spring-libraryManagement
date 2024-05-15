package LibraryManagementSystem.LibraryManagement.Controllers;

import LibraryManagementSystem.LibraryManagement.Repositories.CardRepository;
import LibraryManagementSystem.LibraryManagement.Services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardController {

    @Autowired
    private CardService cardService;

    @PostMapping("add")
    public String addCard(){

        return cardService.addNewcard();
    }

    @PutMapping("associateCardAndStudent")
    public String associateCardAndStudent(@RequestParam("cardId")Integer cardId,
                                          @RequestParam("studentId")Integer studentId) {

        return cardService.associateCardAndStudent(cardId,studentId);
    }
}
