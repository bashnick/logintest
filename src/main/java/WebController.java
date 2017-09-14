import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {
    @Autowired
    UserRepository repository;

    @RequestMapping("/save")
    public String process(){
        repository.save(new User("Jack", "Smith"));
        repository.save(new User("Adam", "Johnson"));
        repository.save(new User("Kim", "Smith"));
        repository.save(new User("David", "Williams"));
        repository.save(new User("Peter", "Davis"));
        return "Done";
    }

    @RequestMapping("/findall")
    public String findAll(){
        String result = "<html>";

        for(User cust : repository.findAll()){
            result += "<div>" + cust.toString() + "</div>";
        }

        return result + "</html>";
    }

    @RequestMapping("/findbyid")
    public String findById(@RequestParam("id") long id){
        String result = "";
        result = repository.findOne(id).toString();
        return result;
    }

    @RequestMapping("/findbylastname")
    public String fetchDataByLastName(@RequestParam("lastname") String lastName){
        String result = "<html>";

        for(User cust: repository.findByLastName(lastName)){
            result += "<div>" + cust.toString() + "</div>";
        }

        return result + "</html>";
    }
}