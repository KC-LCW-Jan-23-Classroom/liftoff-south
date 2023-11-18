package boozeblender.controllers;

import boozeblender.models.Search;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Map;

@Controller
@RequestMapping("search")
public class SearchController {

    @GetMapping("/byIngredient")
    public String searchByIngredient(Model model) {
        model.addAttribute(new Search());
        return "search/byIngredient";
    }
    @GetMapping("/byIngredientResults")
    public String get(String uri) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        String url = "https://www.thecocktaildb.com/api/json/v1/1/search.php?i=Vodka";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
        return "search/byIngredientResults";
    }

    @PostMapping("/byIngredient")
    public String searchByIngredient (@ModelAttribute Search search, Errors errors, Model model) {
        return "search/byIngredientResults";
    }

    @GetMapping("/byGlass")
    public String searchByGlass(Model model) {
        model.addAttribute(new Search());
        return "search/byGlass";
    }

    @PostMapping("/byGlass")
    public String searchByGlass(@ModelAttribute Search search, Errors errors, Model model) {
        return "index";
    }

    @GetMapping("/alcoholicFilter")
    public String alcoholicFilter(Model model) {
        model.addAttribute(new Search());
        return "search/alcoholicFilter";
    }

    @PostMapping("/alcoholicFilter")
    public String alcoholicFilter (@ModelAttribute Search search, Errors errors, Model model) {
        return "index";
    }

    @GetMapping("/randomCocktailGenerator")
    public String randomCocktailGenerator(Model model) {
        model.addAttribute(new Search());
        return "search/randomCocktailGenerator";
    }
    @PostMapping("/randomCocktailGenerator")
    public String searchByIngredient (@ModelAttribute Search search, Errors errors, Model model) throws IOException, InterruptedException {
        if (errors.hasErrors()) {
            System.out.println(errors.getAllErrors().toString());
            return "search/byIngredient";
        }
        HttpClient client = HttpClient.newHttpClient();
        String url = "https://www.thecocktaildb.com/api/json/v1/1/random.php";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());
        String responseString = response.body().toString();
        // Map JSON string to an object
        ObjectMapper mapper = new ObjectMapper();
        Map<String,Object> map = mapper.readValue(response.body(), Map.class);

        // the API returns an object containing an array with a key of "drinks".
        // So get the value for "drinks", and cast it to an ArrayList so that we can iterate over the drinks.
        ArrayList drinksArray = (ArrayList) map.get("drinks");

        // Pass a list of drinks to the template
        model.addAttribute("drinksArray", drinksArray);
        System.out.println(response.body());
        model.addAttribute("response", response.body().toString());
        model.addAttribute("search", search.getSearchParameter());
        return "search/byIngredientResults";
    }

//    @PostMapping("/randomCocktailGenerator")
//    public String randomCocktailGenerator (@ModelAttribute Search search, Errors errors, Model model) {
//        return "index";
//    }

}