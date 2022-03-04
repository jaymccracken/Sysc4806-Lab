package Labs;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddressbookController {
    private AddressBook book = new AddressBook();

    @GetMapping("/add")
    public String add(@ModelAttribute String name, Model model) {
        BuddyInfo newBuddy = new BuddyInfo(name, "home", "905", 22);
        book.addBuddy(newBuddy);
        model.addAttribute(newBuddy.write());
        return "addressbook";
    }
    @GetMapping("/remove")
    public String remove(@RequestParam(name="index") String name, Model model) {
        book.removeBuddy(Integer.parseInt(name));
        model.notify();
        return "addressbook";
    }
}
// @RequestParam(Phonenumber="Phonenumber"), @RequestParam(address="address"), @RequestParam(age="age"
// String Phonenumber, String address, int age,
