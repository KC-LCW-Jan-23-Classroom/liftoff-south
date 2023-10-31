package boozeblender.CocktailDB.cocktaildb;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * TheCocktailDB API client.
 * <p>
 * An open, crowd-sourced database of drinks
 * and cocktails from around the world.
 *
 * @author XXIV
 */
public class CocktailDB {

    private static String http(String endpoint) {
        try {
            URL url = new URL(String.format("https://thecocktaildb.com/api/json/v1/1/%s", endpoint));
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            BufferedReader reader;
            if (100 <= connection.getResponseCode() && connection.getResponseCode() <= 399) {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            } else {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            }
            StringBuilder string = new StringBuilder();
            String output;
            while ((output = reader.readLine()) != null) {
                string.append(output);
            }
            return string.toString();
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * Search cocktail by name.
     *
     * @param s Cocktail name.
     * @return List of {@link Cocktail}.
     */
    public static List<Cocktail> search(String s) {
        try {
            String response = http(String.format("search.php?s=%s", URLEncoder.encode(s, StandardCharsets.UTF_8.toString())));
            if (response != null && response.length() != 0) {
                Gson gson = new Gson();
                Cocktails cocktails = gson.fromJson(response, Cocktails.class);
                if (cocktails.drinks != null && !cocktails.drinks.isEmpty()) {
                    List<Cocktail> list = new ArrayList<>(cocktails.drinks);
                    if (list.isEmpty()) {
                        return null;
                    } else {
                        return list;
                    }
                } else {
                    return null;
                }
            } else {
                return null;
            }
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * Search cocktails by first letter.
     *
     * @param c Cocktails letter.
     * @return List of {@link Cocktail}.
     */
    public static List<Cocktail> searchByLetter(char c) {
        try {
            String response = http(String.format("search.php?f=%s", c));
            if (response != null && response.length() != 0) {
                Gson gson = new Gson();
                Cocktails cocktails = gson.fromJson(response, Cocktails.class);
                if (cocktails.drinks != null && !cocktails.drinks.isEmpty()) {
                    List<Cocktail> list = new ArrayList<>(cocktails.drinks);
                    if (list.isEmpty()) {
                        return null;
                    } else {
                        return list;
                    }
                } else {
                    return null;
                }
            } else {
                return null;
            }
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * Search ingredient by name.
     *
     * @param s Ingredient name.
     * @return {@link Ingredient}.
     */
    public static Ingredient searchIngredient(String s) {
        try {
            String response = http(String.format("search.php?i=%s", URLEncoder.encode(s, StandardCharsets.UTF_8.toString())));
            if (response != null && response.length() != 0) {
                Gson gson = new Gson();
                Ingredients cocktails = gson.fromJson(response, Ingredients.class);
                if (cocktails.ingredients != null && !cocktails.ingredients.isEmpty()) {
                    return cocktails.ingredients.get(0);
                } else {
                    return null;
                }
            } else {
                return null;
            }
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * Search cocktail details by id.
     *
     * @param l Cocktail id.
     * @return {@link Cocktail}.
     */
    public static Cocktail searchByID(Long l) {
        try {
            String response = http(String.format("lookup.php?i=%d", l));
            if (response != null && response.length() != 0) {
                Gson gson = new Gson();
                Cocktails cocktails = gson.fromJson(response, Cocktails.class);
                if (cocktails.drinks != null && !cocktails.drinks.isEmpty()) {
                    return cocktails.drinks.get(0);
                } else {
                    return null;
                }
            } else {
                return null;
            }
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * Search ingredient by ID.
     *
     * @param l Ingredient ID.
     * @return {@link Ingredient}.
     */
    public static Ingredient searchIngredientByID(Long l) {
        try {
            String response = http(String.format("lookup.php?iid=%d", l));
            if (response != null && response.length() != 0) {
                Gson gson = new Gson();
                Ingredients cocktails = gson.fromJson(response, Ingredients.class);
                if (cocktails.ingredients != null && !cocktails.ingredients.isEmpty()) {
                    return cocktails.ingredients.get(0);
                } else {
                    return null;
                }
            } else {
                return null;
            }
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * Search a random cocktail.
     *
     * @return Random cocktail.
     */
    public static Cocktail random() {
        try {
            String response = http("random.php");
            if (response != null && response.length() != 0) {
                Gson gson = new Gson();
                Cocktails cocktails = gson.fromJson(response, Cocktails.class);
                if (cocktails.drinks != null && !cocktails.drinks.isEmpty()) {
                    return cocktails.drinks.get(0);
                } else {
                    return null;
                }
            } else {
                return null;
            }
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * Filter by ingredient.
     *
     * @param s Ingredient name.
     * @return List of {@link Filter}.
     */
    public static List<Filter> filterByIngredient(String s) {
        try {
            String response = http(String.format("filter.php?i=%s", URLEncoder.encode(s, StandardCharsets.UTF_8.toString())));
            if (response != null && response.length() != 0) {
                Gson gson = new Gson();
                FilterDrinks cocktails = gson.fromJson(response, FilterDrinks.class);
                if (cocktails.drinks != null && !cocktails.drinks.isEmpty()) {
                    List<Filter> list = new ArrayList<>(cocktails.drinks);
                    if (list.isEmpty()) {
                        return null;
                    } else {
                        return list;
                    }
                } else {
                    return null;
                }
            } else {
                return null;
            }
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * Filter by alcoholic.
     *
     * @param s Alcoholic name.
     * @return List of {@link Filter}.
     */
    public static List<Filter> filterByAlcoholic(String s) {
        try {
            String response = http(String.format("filter.php?a=%s", URLEncoder.encode(s, StandardCharsets.UTF_8.toString())));
            if (response != null && response.length() != 0) {
                Gson gson = new Gson();
                FilterDrinks cocktails = gson.fromJson(response, FilterDrinks.class);
                if (cocktails.drinks != null && !cocktails.drinks.isEmpty()) {
                    List<Filter> list = new ArrayList<>(cocktails.drinks);
                    if (list.isEmpty()) {
                        return null;
                    } else {
                        return list;
                    }
                } else {
                    return null;
                }
            } else {
                return null;
            }
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * Filter by Category.
     *
     * @param s Category name.
     * @return List of {@link Filter}.
     */
    public static List<Filter> filterByCategory(String s) {
        try {
            String response = http(String.format("filter.php?c=%s", URLEncoder.encode(s, StandardCharsets.UTF_8.toString())));
            if (response != null && response.length() != 0) {
                Gson gson = new Gson();
                FilterDrinks cocktails = gson.fromJson(response, FilterDrinks.class);
                if (cocktails.drinks != null && !cocktails.drinks.isEmpty()) {
                    List<Filter> list = new ArrayList<>(cocktails.drinks);
                    if (list.isEmpty()) {
                        return null;
                    } else {
                        return list;
                    }
                } else {
                    return null;
                }
            } else {
                return null;
            }
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * Filter by Glass.
     *
     * @param s Glass name.
     * @return List of {@link Filter}.
     */
    public static List<Filter> filterByGlass(String s) {
        try {
            String response = http(String.format("filter.php?g=%s", URLEncoder.encode(s, StandardCharsets.UTF_8.toString())));
            if (response != null && response.length() != 0) {
                Gson gson = new Gson();
                FilterDrinks cocktails = gson.fromJson(response, FilterDrinks.class);
                if (cocktails.drinks != null && !cocktails.drinks.isEmpty()) {
                    List<Filter> list = new ArrayList<>(cocktails.drinks);
                    if (list.isEmpty()) {
                        return null;
                    } else {
                        return list;
                    }
                } else {
                    return null;
                }
            } else {
                return null;
            }
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * List the categories filter.
     *
     * @return List of {@link String}.
     */
    public static List<String> categoriesFilter() {
        try {
            String response = http("list.php?c=list");
            if (response != null && response.length() != 0) {
                Gson gson = new Gson();
                CategoriesFilter cocktails = gson.fromJson(response, CategoriesFilter.class);
                if (cocktails.drinks != null && !cocktails.drinks.isEmpty()) {
                    List<String> list = new ArrayList<>();
                    for (Category c : cocktails.drinks) {
                        list.add(c.strCategory);
                    }
                    return list;
                } else {
                    return null;
                }
            } else {
                return null;
            }
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * List the glasses filter.
     *
     * @return List of {@link String}.
     */
    public static List<String> glassesFilter() {
        try {
            String response = http("list.php?g=list");
            if (response != null && response.length() != 0) {
                Gson gson = new Gson();
                GlassesFilter cocktails = gson.fromJson(response, GlassesFilter.class);
                if (cocktails.drinks != null && !cocktails.drinks.isEmpty()) {
                    List<String> list = new ArrayList<>();
                    for (Glass c : cocktails.drinks) {
                        list.add(c.strGlass);
                    }
                    return list;
                } else {
                    return null;
                }
            } else {
                return null;
            }
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * List the ingredients filter.
     *
     * @return List of {@link String}.
     */
    public static List<String> ingredientsFilter() {
        try {
            String response = http("list.php?i=list");
            if (response != null && response.length() != 0) {
                Gson gson = new Gson();
                IngredientsFilter cocktails = gson.fromJson(response, IngredientsFilter.class);
                if (cocktails.drinks != null && !cocktails.drinks.isEmpty()) {
                    List<String> list = new ArrayList<>();
                    for (IngredientFilter c : cocktails.drinks) {
                        list.add(c.strIngredient1);
                    }
                    return list;
                } else {
                    return null;
                }
            } else {
                return null;
            }
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * List the alcoholic filter.
     *
     * @return List of {@link String}.
     */
    public static List<String> alcoholicFilter() {
        try {
            String response = http("list.php?a=list");
            if (response != null && response.length() != 0) {
                Gson gson = new Gson();
                AlcoholicFilter cocktails = gson.fromJson(response, AlcoholicFilter.class);
                if (cocktails.drinks != null && !cocktails.drinks.isEmpty()) {
                    List<String> list = new ArrayList<>();
                    for (Alcoholic c : cocktails.drinks) {
                        list.add(c.strAlcoholic);
                    }
                    return list;
                } else {
                    return null;
                }
            } else {
                return null;
            }
        } catch (Exception ex) {
            return null;
        }
    }
}