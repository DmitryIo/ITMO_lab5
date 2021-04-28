package constituents;

import exceptions.ValidationException;

import constituents.Color;
import constituents.Country;
import java.time.LocalDateTime;

/**
 * Class Person
 */
public class Person{
    private String name;
    private long weight;
    private String passportID;
    private Color eyeCollor;
    private Country nationality;

    /**
     * Constructor for completely person
     * @param name
     * @param weight
     * @param passportID
     * @param eyeCollor
     * @param nationality
     * @throws NullPointerException
     * @throws ValidationException
     */
    public Person(String name, long weight, String passportID, Color eyeCollor, Country nationality) throws NullPointerException, ValidationException{
        if(name == null || name.equals("") || eyeCollor == null || nationality == null || passportID.length() < 8
                || passportID.length() > 31) {
            throw new NullPointerException("Check the values of variables. name, annualTurnover and type can be empty!");
        }
        if (weight < 0){
            throw new ValidationException("weight cant be less then zero");
        }
        this.name = name;
        this.weight = weight;
        this.passportID = passportID;
        this.eyeCollor = eyeCollor;
        this.nationality = nationality;
    }
    public Person(){ };

    public void setName(String name) {
        this.name = name;
    }
    public void setWeight(long weight){
        this.weight = weight;
    }
    public void setPassportID(String pass){
        this.passportID = pass;
    }
    public void setEyeCollor(Color color){
        this.eyeCollor = color;
    }
    public void setNationality(Country nati){
        this.nationality = nati;
    }

    public String getName() {
        return name;
    }

    public Color getEyeCollor() {
        return eyeCollor;
    }

    public Country getNationality() {
        return nationality;
    }

    public long getWeight() {
        return weight;
    }

    public String getPassportID() {
        return passportID;
    }
}
