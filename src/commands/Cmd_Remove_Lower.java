package commands;


import exceptions.BadNumberOfArgsException;
import exceptions.ValidationException;
import main.Receiver;
import java.util.ArrayList;

/**
 * Class for Remove_Lower command
 */
public class Cmd_Remove_Lower implements Command{
    private final Receiver receiver;
    private final ArrayList<String> logger;
    /**
     * Simple constructor.
     * @param receiver - the object of receiver
     * @param logger - logg array
     */

    public Cmd_Remove_Lower(Receiver receiver, ArrayList<String> logger){this.receiver = receiver;
    this.logger = logger;}

    /**
     * Execute method remove_lower in receiver.
     * @param args - the arguments that are passed to command
     * @throws Exception
     */
    @Override
    public void Execute(String... args) throws Exception {
        if (args.length != 1) {
            throw new BadNumberOfArgsException("Wrong number of arguments! See more info about available commands. \"help\" ");
        } else {
            logger.add("remove_lower");
            receiver.Remove_Lower(args[0]);
        }

    }
}
