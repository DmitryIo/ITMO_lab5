package commands;
import main.Receiver;
import java.util.ArrayList;

/**
 * Class for history command
 */
public class Cmd_History implements Command{
    private final Receiver receiver;
    private final ArrayList<String> logger;
    /**
     * Simple constructor.
     * @param receiver - the object of receiver
     * @param logger - logg array
     */

    public Cmd_History(Receiver receiver, ArrayList<String> logger){this.receiver = receiver; this.logger = logger;}

    /**
     * runs history command
     * @param args - the arguments that are passed to command
     * @throws Exception
     */
    @Override
    public void Execute(String... args) throws Exception {
        receiver.History(logger);
    }
}
