package others;

import java.time.LocalDateTime;

import constituents.*;
import exceptions.ValidationException;


/**
 * Class of Initializer.
 * This class initializes collection.
 */

public class Initializer {
    private static int offset = 0;

    /**
     * Constructor
     */

    public Initializer() {
    }

    /**
     * Method for initialization of collection
     * @param studygroup - the element of collection
     * @param values - the fields of element
     * @throws NullPointerException
     * @throws ValidationException
     */

    public static void Initialize(StudyGroup studygroup, String[] values) throws NullPointerException, ValidationException {
        try {
            studygroup.setName(values[offset++]);
            Coordinates coordinates = new Coordinates();
            coordinates.setX(Double.parseDouble(values[offset++]));
            coordinates.setY(Integer.parseInt(values[offset++]));
            studygroup.setCoordinates(coordinates);
            studygroup.setCreationDate(LocalDateTime.parse(values[offset++]));
            studygroup.setStudentsCount(Long.parseLong(values[offset++]));
            studygroup.setFormOfEducation(values[offset++]);
            studygroup.setSemesterEnum(values[offset++]);
            Person person = new Person();
            person.setName(values[offset++]);
            person.setWeight(Long.parseLong(values[offset++]));
            person.setPassportID(values[offset++]);
            person.setEyeCollor(Color.valueOf(values[offset++]));
            person.setNationality(Country.valueOf(values[offset++]));
            studygroup.setGroupAdmin(person);
        } catch (NullPointerException ex) {
            System.err.println("The field can not be null! Check the file.");
        } catch (ValidationException ex) {
            System.err.println(ex.getMessage());
        } catch (NumberFormatException ex) {
            System.err.println("The field can not be null! Check the file.");
        }
    }
}