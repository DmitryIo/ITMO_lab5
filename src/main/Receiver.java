package main;

import constituents.*;
import exceptions.ValidationException;
import others.Initializer;
import others.Input;
import others.Output;
import others.ParserXML;
import main.Invoker;
import java.io.IOException;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.PriorityQueue;
import java.io.FileReader;
/**
 * Class which manages collection.
 */
public class Receiver {
    private PriorityQueue<StudyGroup> studyGroups;
    private LocalDateTime creationDate;
    private Scanner scanner;
    private boolean exit = false;
    private Invoker invoker;
    /**
     * Constructor
     * @throws ValidationException
     * @throws IOException
     */

    Receiver() throws ValidationException, IOException{
        Input input = new Input();
        ParserXML parser = new ParserXML();
        studyGroups = new PriorityQueue<>();
        creationDate = LocalDateTime.now();
        scanner = new Scanner(System.in);
        parser.Parse(input.readFile());
        for(int i = 1; i <= parser.getGroupsNum(); i++){
            StudyGroup group = new StudyGroup();
            Initializer.Initialize(group, parser.getValues());
            studyGroups.add(group);
        }
    }

    private Person ReadPerson(String name){
        String nextValue = new String();
        Person person = new Person();
        if (name.length()!= 0){
            person.setName(name);
        }
        else {System.out.println("Enter name of groupAdmin");
        name = scanner.nextLine();
        person.setName(name);
        }
        try{
            System.out.println("Enter weight of admin");
            nextValue = scanner.nextLine();
            person.setWeight(Long.parseLong(nextValue));
            System.out.println("Enter passport id of group admin");
            nextValue = scanner.nextLine();
            person.setPassportID(nextValue);
            System.out.println("Enter eye color");
            nextValue = scanner.nextLine();
            person.setEyeCollor(Color.valueOf(nextValue));
            System.out.println("Enter nationality");
            nextValue = scanner.nextLine();
            person.setNationality(Country.valueOf(nextValue));
        }
        catch (IllegalArgumentException ex) {
            if (nextValue.equals("")) {
                System.err.println("Empty string!");
            } else {
                System.out.println("Country: USA JAPAN RUSSIA");
                System.out.println("Eye Color: BROWN WHITE ORANGE");
                System.out.println("Semester: SECOND FOURTH FIFTH SIXTH");
                System.out.println("FormOfEducation: DISTANCE_EDUCATION FULL_TIME_EDUCATION EVENING_CLASSES");
                System.err.println("Invalid value!");
            }
        }
        return person;
    }

    private boolean ReadElement(String name, StudyGroup studyGroup) throws ValidationException {
        boolean success = true;
        Coordinates coordinates = new Coordinates();
        Person person = new Person();
        String nextValue = new String();
        if (name.length()!=0){
            studyGroup.setName(name);
        }
        else {System.out.println("Enter name of group");
            name = scanner.nextLine();
            studyGroup.setName(name);
        }
        try {
            System.out.println("Enter the coordinate x of coordinates");
            nextValue = scanner.nextLine();
            coordinates.setX(Double.parseDouble(nextValue));

            System.out.println("Enter the coordinate y of coordinates");
            nextValue = scanner.nextLine();
            coordinates.setY(Integer.parseInt(nextValue));

            System.out.println("Enter the students count");
            nextValue = scanner.nextLine();
            studyGroup.setStudentsCount(Integer.parseInt(nextValue));

            System.out.println("Enter the form of education");
            nextValue = scanner.nextLine();
            studyGroup.setFormOfEducation(nextValue);

            System.out.println("Enter the semester");
            nextValue = scanner.nextLine();
            studyGroup.setSemesterEnum(nextValue);

            System.out.println("Enter the name of Group Admin");
            nextValue = scanner.nextLine();
            person.setName(nextValue);

            System.out.println("Enter the weight of the Group Admin");
            nextValue = scanner.nextLine();
            person.setWeight(Long.parseLong(nextValue));

            System.out.println("Enter the passport ID");
            nextValue = scanner.nextLine();
            person.setPassportID(nextValue);

            System.out.println("Enter the Eye color");
            nextValue = scanner.nextLine();
            person.setEyeCollor(Color.valueOf(nextValue));

            System.out.println("Enter the nationality");
            nextValue = scanner.nextLine();
            person.setNationality(Country.valueOf(nextValue));

            studyGroup.setCoordinates(coordinates);
            studyGroup.setGroupAdmin(person);
        }
        catch (IllegalArgumentException ex) {
            if (nextValue.equals("")) {
                System.err.println("Empty string!");
            } else {
                System.out.println("Country: USA JAPAN RUSSIA");
                System.out.println("Eye Color: BROWN WHITE ORANGE");
                System.out.println("Semester: SECOND FOURTH FIFTH SIXTH");
                System.out.println("FormOfEducation: DISTANCE_EDUCATION FULL_TIME_EDUCATION EVENING_CLASSES");
                System.err.println("Invalid value!");
            }
            success = false;
        } catch (ValidationException ex) {
            System.err.println(ex.getMessage());
            success = false;
        }
        return success;
    }
    /**
     * Adds a new element to collection
     * @param name - the name of element
     * @throws ValidationException
     */
    public void Add(String name) throws ValidationException {
        StudyGroup studyGroup = new StudyGroup();
        if (ReadElement(name, studyGroup)) {
            studyGroups.add(studyGroup);
        } else {
            System.out.println("Some problems with adding study group");
        }
    }
    /**
     * Shows info about collection
     */
    public void Info() {
        try {
            Field stackField = Receiver.class.getDeclaredField("studyGroups");
            String stackType = stackField.getGenericType().getTypeName();
            if (!studyGroups.isEmpty()) {
                System.out.println("Type: " + studyGroups.getClass().getName() + "<" + stackType + ">" + "\nCreation Date" + creationDate + "\nSize: " + studyGroups.size());
            } else {
                System.out.println("Type can not be defined because collection is empty! " + "\nCreation Date" + creationDate + "\nSize: " + studyGroups.size());
            }
        } catch (NoSuchFieldException ex) {
            System.err.println("Problem with general class. Can not find type of class!");
        }
    }
    /**
     * Shows collection in string presentation
     */
    public void Show() {
        Iterator<StudyGroup> it = studyGroups.iterator();
        while(it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }
    /**
     * Updates id of element
     * @param args
     */
    public void Update_Id(String args) throws ValidationException {
        long id = Long.parseLong(args);
        String name = "";
        for(StudyGroup p : studyGroups) {
            if (id == p.getId()) {
                ReadElement(name, p);
            }
        }
    }
    public void sort(){
        for (StudyGroup p : studyGroups){
            System.out.println(p);
        }
    }

    /**
     * Removes an element by id
     * @param args
     */
    public void Remove_By_Id(String args) {
        StudyGroup redundant = new StudyGroup();
        long id = Long.parseLong((args));
        for(StudyGroup product : studyGroups) {
            if (product.getId() == id){
                redundant = product;
            }
        }
        studyGroups.remove(redundant);
    }
    /**
     * Clears collection
     */
    public void Clear() {
        studyGroups.clear();
    }

    public void Exit() {
        exit = true;
        scanner.close();
    }

    /**
     * Removes first element in collection
     */
    private void Remove_First(){
        studyGroups.poll();
    }

    /**
     *
     */
    public void Remove_Lower(String name) throws ValidationException{
        StudyGroup temp = new StudyGroup();
        ReadElement(name, temp);
        for (StudyGroup st: studyGroups){
            if (temp.isGreater(st)){
                studyGroups.remove(st);
            }
        }
    }
    /**
     * remove_any_by_students_count
     */
    public void remove_any_by_students_count(long studentscount){
        for (StudyGroup st: studyGroups){
            if(st.getStudentsCount() == studentscount){
                studyGroups.remove(st);
                break;
            }
        }
    }
    /**
     * max_by_name
     */
    public void max_by_name(){
        String max_name = studyGroups.peek().getName();
        for (StudyGroup st: studyGroups){
            if (st.getName().length() > max_name.length()){
                max_name = st.getName();
            }
        }
        System.out.println("Max name is: " + max_name);
    }
    /**
     * filter_by_group_admin
     */
    public void filter_by_group_admin(String name){
        Person groupAdmin = ReadPerson(name);
        for (StudyGroup st: studyGroups){
            if (st.getGroupAdmin() == groupAdmin){
                System.out.println(st);
            }
        }
    }
    /**
     * Just for saving in history command execute script
     */
    public void Execute_Script() {

    }

    /**
     * Shows the list of available commands
     */
    public void Help() {
        System.out.println("//// HELP //// " +
                "\ninfo : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)" +
                "\nshow : вывести в стандартный поток вывода все элементы коллекции в строковом представлении" +
                "\nadd {element} : добавить новый элемент в коллекцию" +
                "\nupdate id {element} : обновить значение элемента коллекции, id которого равен заданному" +
                "\nremove_by_id id : удалить элемент из коллекции по его id" +
                "\nclear : очистить коллекцию" +
                "\nsave : сохранить коллекцию в файл" +
                "\nexecute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме" +
                "\nexit : завершить программу (без сохранения в файл)" +
                "\nremove_first : удалить первый элемент из коллекции" +
                "\nremove_lower {element} : удалить из коллекции все элементы, меньшие, чем заданный"+
                "\nhistory : вывести последние 5 команд (без их аргументов)"+
                "\nremove_any_by_students_count studentsCount : удалить из коллекции один элемент, значение поля studentsCount которого эквивалентно заданному"+
                "\nmax_by_name : вывести любой объект из коллекции, значение поля name которого является максимальным"+
                "\nfilter_by_group_admin groupAdmin : вывести элементы, значение поля groupAdmin которых равно заданному");
    }

    /**
     * Saves collection to file
     * @throws IOException
     */

    public void Save() throws IOException {
        String path;
        System.out.println("Enter the path to the file where you want to save the data.");
        try {
            path = scanner.nextLine();
            Output output = new Output(path);
            output.writeLine("<xml -version 8.0>");
            output.writeLine("<Class>");
            for (StudyGroup product : studyGroups) {
                output.writeLine("  <StudyGroup>");
                output.writeLine("    <Name>" + product.getName() + "<\\Name>");
                output.writeLine("    <Coordinates>");
                output.writeLine("      <X>" + product.getCoordinates().getX() + "<\\X>");
                output.writeLine("      <Y>" + product.getCoordinates().getY() + "<\\Y>");
                output.writeLine("    <\\Coordinates>");
                output.writeLine("    <CreationDate>" + product.getCreationDate() + "<\\CreationDate>");
                output.writeLine("    <studentsCount>" + product.getStudentsCount() + "<\\studentsCount>");
                output.writeLine("    <formOfEducation>" + product.getFormOfEducation() + "<\\formOfEducation>");
                output.writeLine("    <semesterEnum>" + product.getSemesterEnum() + "<\\semesterEnum>");
                output.writeLine("    <Person>");
                output.writeLine("      <Name>" + product.getGroupAdmin().getName() + "<\\Name>");
                output.writeLine("      <weight>" + product.getGroupAdmin().getWeight() + "<\\weight>");
                output.writeLine("      <passportID>" + product.getGroupAdmin().getPassportID() + "<\\passportID>");
                output.writeLine("      <eyeColor>" + product.getGroupAdmin().getEyeCollor() + "<\\eyeColor>");
                output.writeLine("      <nationality>" + product.getGroupAdmin().getNationality() + "<\\nationality>");
                output.writeLine("    <\\Person>");
                output.writeLine("  <\\StudyGroup>");
            }
            output.writeLine("<\\Class>");
            output.closeWriter();
            System.out.println("Saving is successful!");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public boolean getExit() {
        return exit;
    }

    public void History(ArrayList<String> history) {
        int count = 0;
        for (String command : history){
            ++count;
            System.out.println(command);
            if (count >= 5){
                break;
            }
        }


    }



}