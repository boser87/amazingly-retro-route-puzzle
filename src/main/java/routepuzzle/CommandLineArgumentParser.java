package routepuzzle;

import org.apache.commons.cli.*;

public class CommandLineArgumentParser {

    private String fileName;
    private Integer startingRoom;
    private String[] itemsToFind;

    CommandLineArgumentParser(String[] arguments) {
        Options options = new Options();

        Option fileName = new Option("f", "fileName", true, "file name of the json with room map");
        fileName.setRequired(true);
        options.addOption(fileName);

        Option startingRoom = new Option("r", "startingRoom", true, "starting room for the puzzle");
        startingRoom.setRequired(true);
        startingRoom.setType(Number.class);
        options.addOption(startingRoom);

        Option itemsToFind = new Option("i", "itemsToFind", true, "items to find");
        itemsToFind.setRequired(true);
        itemsToFind.setArgs(Option.UNLIMITED_VALUES);
        options.addOption(itemsToFind);

        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        CommandLine cmd;

        try {
            cmd = parser.parse(options, arguments);

            this.fileName = cmd.getOptionValue("fileName");
            this.startingRoom = ((Number) cmd.getParsedOptionValue("startingRoom")).intValue();
            this.itemsToFind = cmd.getOptionValues("itemsToFind");
        } catch (ParseException e) {
            e.printStackTrace();
            formatter.printHelp("utility-name", options);
            System.exit(1);
        }
    }

    public String getFileName() {
        return fileName;
    }

    public Integer getStartingRoom() {
        return startingRoom;
    }

    public String[] getItemsToFind() {
        return itemsToFind;
    }
}
