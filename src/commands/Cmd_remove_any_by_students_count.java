package commands;
import exceptions.BadNumberOfArgsException;
import main.Receiver;
import java.util.ArrayList;
/**
 * Class of the command removy by students count.
 * This command remove element in collection.
 */

public class Cmd_remove_any_by_students_count implements Command{
    private final Receiver receiver;
    private final ArrayList<String> logger;
    /**
     * Simple constructor.
     * @param receiver - the object of receiver
     * @param logger - logg array
     */
    public Cmd_remove_any_by_students_count(Receiver receiver, ArrayList<String> logger){
        this.receiver = receiver;
        this.logger = logger;
    }
    /**
     * Runs remove_any_by_students_count command.
     * @param args - args for command
     */

    @Override
    public void Execute(String... args) throws BadNumberOfArgsException {
        if (args.length != 1) {
            throw new BadNumberOfArgsException("Wrong number of arguments! See more info about available commands. \"help\" ");
        } else {
            logger.add("remove_any_by_students_count");
            receiver.remove_any_by_students_count(Long.parseLong(args[0]));
        }
    }
}
