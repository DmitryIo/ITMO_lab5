package main;
import java.util.Scanner;

import commands.*;
import exceptions.InvalidCommand;
import java.util.ArrayList;
public class Main {

    public static void main(String[] args) throws Exception {
        for (String env: args){
            String file_path = System.getenv(env);
            break;
        }

        Receiver receiver = new Receiver();
        Invoker handler = new Invoker();
        Scanner userInput = new Scanner(System.in);
        RegisterCommands(receiver, handler);
        while(!receiver.getExit()) {
            try {
                handler.Execute(ReadUserInput(userInput));
            } catch (InvalidCommand ex) {
                System.err.println(ex.getMessage());
            }
        }
        userInput.close();
    }
    public static void RegisterCommands(Receiver receiver, Invoker handler) {
        ArrayList<String> logger = new ArrayList<String>();

        handler.Register("help", new Cmd_Help(receiver, logger));
        handler.Register("info", new Cmd_Info(receiver, logger));
        handler.Register("show", new Cmd_Show(receiver, logger));
        handler.Register("add", new Cmd_Add(receiver, logger));
        handler.Register("update_id", new Cmd_UpdateId(receiver, logger));
        handler.Register("remove_by_id", new Cmd_Remove_By_Id(receiver, false, logger));
        handler.Register("clear", new Cmd_Clear(receiver, logger));
        handler.Register("save", new Cmd_Save(receiver, logger));
        handler.Register("execute_script", new Cmd_Execute_Script(receiver, handler, logger));
        handler.Register("exit", new Cmd_Exit(receiver, logger));
        handler.Register("remove_first", new Cmd_Remove_By_Id(receiver, true, logger));
        handler.Register("remove_lower", new Cmd_Remove_Lower(receiver, logger));
        handler.Register("history", new Cmd_History(receiver, logger));
        handler.Register("remove_any_by_students_count", new Cmd_remove_any_by_students_count(receiver, logger));
        handler.Register("max_by_name", new Cmd_max_by_name(receiver, logger));
        handler.Register("sort", new Cmd_Sort(receiver, logger));
        handler.Register("filter_by_group_admin", new Cmd_filter_by_group_admin(receiver, logger));
    }
    private static String ReadUserInput(Scanner userInput) {
        String nextCommand;
        nextCommand = userInput.nextLine();
        return nextCommand;
    }
}
