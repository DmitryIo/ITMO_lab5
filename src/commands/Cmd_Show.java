package commands;

import exceptions.BadNumberOfArgsException;

import exceptions.ValidationException;
import main.Receiver;
import java.util.ArrayList;


/**
 * Class of the command show.
 * This command show collection.
 */

public class Cmd_Show implements Command {

    private final Receiver receiver;
    private final ArrayList<String> logger;
    /**
     * Simple constructor.
     * @param receiver - the object of receiver
     * @param logger - logg array
     */


    public Cmd_Show(Receiver receiver, ArrayList<String> logger) {
        this.receiver = receiver;
        this.logger = logger;
    }

    /**
     * Execute method add in receiver.
     * @param args - the arguments that are passed to command
     * @throws ValidationException
     * @throws BadNumberOfArgsException
     */

    @Override
    public void Execute(String ... args) throws ValidationException, BadNumberOfArgsException {
        if (args.length != 0) {
            throw new BadNumberOfArgsException("Wrong number of arguments! See more info about available commands. \"help\" ");
        } else {
            logger.add("show");
            receiver.Show();
        }
    }
}