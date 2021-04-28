package commands;

import exceptions.BadNumberOfArgsException;
import exceptions.ValidationException;
import main.Receiver;

import java.util.ArrayList;

public class Cmd_Sort implements Command {

    private final Receiver receiver;
    private final ArrayList<String> logger;

    /**
     * Simple constructor.
     *
     * @param receiver - the object of receiver
     * @param logger   - logg array
     */


    public Cmd_Sort(Receiver receiver, ArrayList<String> logger) {
        this.receiver = receiver;
        this.logger = logger;
    }

    /**
     * Execute method add in receiver.
     *
     * @param args - the arguments that are passed to command
     * @throws ValidationException
     * @throws BadNumberOfArgsException
     */

    @Override
    public void Execute(String... args) throws ValidationException, BadNumberOfArgsException {
            logger.add("sort");
            receiver.sort();
        }
    }