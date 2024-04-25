import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Drinks {
    private String country;
    private Integer beerServings;
    private Integer spiritServings;
    private Integer wineServings;
    private Double totalLitresOfPureAlcohol;

    private List<Drinks> drinks = new ArrayList<>();

    public Drinks(String country, Integer beerServings, Integer spiritServings, Integer wineServings,
            Double totalLitresOfPureAlcohol) {
        this.country = country;
        this.beerServings = beerServings;
        this.spiritServings = spiritServings;
        this.wineServings = wineServings;
        this.totalLitresOfPureAlcohol = totalLitresOfPureAlcohol;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getBeerServings() {
        return beerServings;
    }

    public void setBeerServings(Integer beerServings) {
        this.beerServings = beerServings;
    }

    public Integer getSpiritServings() {
        return spiritServings;
    }

    public void setSpiritServings(Integer spiritServings) {
        this.spiritServings = spiritServings;
    }

    public Integer getWineServings() {
        return wineServings;
    }

    public void setWineServings(Integer wineServings) {
        this.wineServings = wineServings;
    }

    public Double getTotalLitresOfPureAlcohol() {
        return totalLitresOfPureAlcohol;
    }

    public void setTotalLitresOfPureAlcohol(Double totalLitresOfPureAlcohol) {
        this.totalLitresOfPureAlcohol = totalLitresOfPureAlcohol;
    }

    public static void archive(List<Drinks> drinks) {
        try {
            File file = new File("C:\\Users\\Vinix\\Área de Trabalho\\edaa-lista-nove\\drinks.csv");
            BufferedReader br = new BufferedReader(new FileReader(file));
            br.readLine();
            String line = br.readLine();
            while (line != null) {
                String[] vector = line.split(",");
                String country = vector[0];
                Integer bs = Integer.parseInt(vector[1]);
                Integer Servings = Integer.parseInt(vector[2]);
                Integer wineServings = Integer.parseInt(vector[3]);
                Double totalAlcohol = Double.parseDouble(vector[4]);
                drinks.add(new Drinks(country, bs, Servings, wineServings, totalAlcohol));
                line = br.readLine();
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    public static void list(List<Drinks> drinks) {
        sortWine(drinks);
        for(Drinks d : drinks) {
            System.out.println("País que mais consome vinho: " + d.getCountry() + "\nQuantidade: " + d.getWineServings());
        }
    }
    public static void sortWine(List<Drinks> drinks) {
        Collections.sort(drinks, (wineOne, wineTwo) -> wineOne.getWineServings().compareTo(wineTwo.getWineServings()));
    }

}
