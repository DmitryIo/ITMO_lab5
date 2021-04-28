package commands;
import java.lang.reflect.Array;
import java.util.ArrayList;
import main.Receiver;

/**
 * Class for max_by_name command
 */
public class Cmd_max_by_name implements Command{
    private final Receiver receiver;
    private final ArrayList<String> logger;
    /**
     * Simple constructor.
     * @param receiver - the object of receiver
     * @param logger - logg array
     */

    public Cmd_max_by_name(Receiver receiver, ArrayList<String> logger){
        this.receiver = receiver;
        this.logger = logger;
    }

    /**
     * runs max_by_name command
     * @param args - the arguments that are passed to command
     * @throws Exception
     */

    @Override
    public void Execute(String... args) throws Exception {
        logger.add("max_by_name");
        receiver.max_by_name();
    }
}
