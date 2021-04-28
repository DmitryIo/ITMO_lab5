package constituents;
import com.sun.istack.internal.NotNull;

import java.text.Normalizer;
import java.time.LocalDateTime;

//import org.jetbrains.annotations.NotNull;
import exceptions.ValidationException;

/**
 * StudyGroup class. Main class in collection.
 */
public class StudyGroup implements Comparable<StudyGroup>{
//    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private static int lastId;
    @NotNull
    private long id;
    @NotNull
    private String name; //Поле не может быть null, Строка не может быть пустой
    @NotNull
    private Coordinates coordinates; //Поле не может быть null
    @NotNull
    private LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private long studentsCount; //Значение поля должно быть больше 0
    private FormOfEducation formOfEducation; //Поле может быть null
    private Semester semesterEnum; //Поле может быть null
    private Person groupAdmin; //Поле может быть null

    public StudyGroup(){
        id = lastId;
        lastId++;
        creationDate =  LocalDateTime.now();
    }

    /**
     * Constructor for StudyGroup
     * @param name
     * @param coordinates
     * @param form
     * @param StCount
     * @param sem
     * @param person
     * @throws ValidationException
     */
    public StudyGroup(String name, Coordinates coordinates, FormOfEducation form, long StCount, Semester sem, Person person) throws ValidationException{
        if(name == null || name.equals("") || coordinates == null) {
            throw new NullPointerException("Check the values of variables. name, annualTurnover and type can be empty!");
        }
        if(StCount <= 0) {
            throw new ValidationException("The height is out of range! It must be more than 0");
        }
        id = lastId;
        lastId++;
        this.name = name;
        this.coordinates = coordinates;
        this.formOfEducation = form;
        this.studentsCount = StCount;
        this.semesterEnum = sem;
        this.groupAdmin = person;

    }
    public void UpdateId() {
        id = lastId;
        lastId++;
    }
    public void setName(String name) throws NullPointerException, ValidationException {
        if(name == null || name.equals("")) {
            throw new NullPointerException("The name can not be empty!");
        }
        this.name = name;
    }
    public void setStudentsCount(long studentsCount) throws NullPointerException, ValidationException {

        if(studentsCount <= 0) {
            throw new ValidationException("The height is out of range! It must be more than 0");
        }
        this.studentsCount = studentsCount;
    }
    public void setCreationDate(LocalDateTime creationDate) throws NullPointerException {
        if (creationDate == null) {
            throw new NullPointerException("The creation date can not be empty!");
        }
        this.creationDate = creationDate;
    }
    public void setGroupAdmin(Person groupAdmin) throws NullPointerException {
        this.groupAdmin = groupAdmin;
    }
    public void setFormOfEducation(String formOfEducation){
        if (formOfEducation.equals("DISTANCE_EDUCATION")) {
            this.formOfEducation = FormOfEducation.DISTANCE_EDUCATION;
        } else if (formOfEducation.equals("FULL_TIME_EDUCATION")){
            this.formOfEducation = FormOfEducation.FULL_TIME_EDUCATION;
        } else if (formOfEducation.equals("EVENING_CLASSES")){
            this.formOfEducation = FormOfEducation.EVENING_CLASSES;
        }
    }
    public void setSemesterEnum(String semesterEnum){
        if (semesterEnum.equals("SECOND")){
            this.semesterEnum = Semester.SECOND;
        } else if (semesterEnum.equals("FOURTH")){
            this.semesterEnum = Semester.FOURTH;
        } else if (semesterEnum.equals("FIFTH")){
            this.semesterEnum = Semester.FIFTH;
        } else if (semesterEnum.equals("SIXTH")){
            this.semesterEnum = Semester.SIXTH;
        }
    }
    public void setCoordinates(Coordinates coordinates) throws NullPointerException {
        if(coordinates == null) {
            throw new NullPointerException("The coordinates can not be empty!");
        }
        this.coordinates = coordinates;
    }
    public long getId() {return id;}
    public String getName() {return name;}
    public Long getStudentsCount() {return studentsCount;}
    public Coordinates getCoordinates() {return coordinates;}
    public LocalDateTime getCreationDate() {return creationDate;}
    public FormOfEducation getFormOfEducation() {return formOfEducation;}
    public Semester getSemesterEnum() {return semesterEnum;}
    public Person getGroupAdmin() {return groupAdmin;}


    public boolean isGreater(StudyGroup group){
        if ((int)(this.id - group.id) > 0){
            return true;
        }
        else {return false;}
    }
    @Override
    public int compareTo(StudyGroup group){
        return (int) (this.id - group.id);
    }


}
