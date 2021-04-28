package commands;
import main.Receiver;
import java.util.ArrayList;
public class Cmd_filter_by_group_admin implements Command{
    private final Receiver receiver;
    private final ArrayList<String> logger;
    /**
     * Simple constructor.
     * @param receiver - the object of receiver
     * @param logger - logg array
     */

    public Cmd_filter_by_group_admin(Receiver receiver, ArrayList<String> logger){
        this.receiver = receiver;
        this.logger = logger;

    }

    @Override
    public void Execute(String... args) throws Exception {
        logger.add("filter_by_group_admin");
        receiver.filter_by_group_admin("");
    }
}
