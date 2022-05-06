package pl.km.exercise201;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
class UserController {
    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/users")
    @GetMapping("/users")
    @ResponseBody
    String printUsers() {
        String result = "";
        for (User user : userRepository.getUsers()) {
            result += user.toString() + "<br/>";
        }
        return result;
    }

    @RequestMapping("/add")
    String addUser(@RequestParam(name = "imie", required = false) String firstName,
                   @RequestParam(name = "nazwisko", required = false) String lastName,
                   @RequestParam(name = "wiek", required = false) Integer age) {
        if (firstName == null || lastName == null || age == null) {
            return "err.html";
        }
        if (firstName.length() > 1 && lastName.length() > 1 && age >= 0 && age < 121) {
            userRepository.add(firstName, lastName, age);
            return "redirect:success.html";
        } else {
            return "redirect:err.html";

        }
    }
}
