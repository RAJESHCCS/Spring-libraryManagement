package LibraryManagementSystem.LibraryManagement.Services;


import LibraryManagementSystem.LibraryManagement.Enum.CardStatus;
import LibraryManagementSystem.LibraryManagement.Model.LibraryCard;
import LibraryManagementSystem.LibraryManagement.Model.Student;
import LibraryManagementSystem.LibraryManagement.Repositories.CardRepository;
import LibraryManagementSystem.LibraryManagement.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private StudentRepository studentRepository;
    public String addNewcard(){
        LibraryCard card = new LibraryCard();
        card.setCardStatus(CardStatus.NEW);
        card.setNoOfBooksIssued(0);
        card = cardRepository.save(card);
        return "The card has been generated with the cardId"+card.getCardId();
    }
    public String associateCardAndStudent(Integer cardId,Integer studentId) {

        LibraryCard card = cardRepository.findById(cardId).get();
        Student student = studentRepository.findById(studentId).get();
        card.setStudent(student); //This is how you set the FK
        card.setCardStatus(CardStatus.ACTIVE);

        cardRepository.save(card);
        return "Associating card and student with cardId " + cardId + " and studentId " + studentId;
    }
}
