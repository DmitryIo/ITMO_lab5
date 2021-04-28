package commands;


import exceptions.BadNumberOfArgsException;

import exceptions.ValidationException;
import main.Receiver;
import java.util.ArrayList;


/**
 * Class of the command removy by id.
 * This command remove element in collection.
 */

public class Cmd_Remove_By_Id implements Command {

    private final Receiver receiver;
    private Boolean isFirst;
    private final ArrayList<String> logger;

    /**
     * Simple constructor.
     * @param receiver - the object of receiver
     * @param logger - logg array
     */

    public Cmd_Remove_By_Id(Receiver receiver, Boolean isFirst, ArrayList<String> logger) {
        this.receiver = receiver;
        this.isFirst = isFirst;
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
        if (this.isFirst){
            receiver.Remove_By_Id("0");
        }
        else{
        if (args.length != 1) {
            throw new BadNumberOfArgsException("Wrong number of arguments! See more info about available commands. \"help\" ");
        } else {
            logger.add("remove_by_id");
            receiver.Remove_By_Id(args[0]);
        }
        }
    }
}