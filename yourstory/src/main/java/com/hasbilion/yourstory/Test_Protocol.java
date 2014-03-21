package com.hasbilion.yourstory;

/**
 * Created by obiknobi on 27.02.14.
 */
/*Protokollskizze:

	Client meldet sich beim Server an:
		String "Client_ID"   z.B. IMEI vom Handy
		String "User_Name"


	Client holt Story:
		String "GetBestRatedSentences"
	Sever antwortet mit csv-datei
		CSV-Story.csv


	Client schlägt satz vor:
		String "UploadOneSentence"
		Int index
		String"Dies ist der Anfang einer tollen Geschichte..."


	Client editiert satz
		String "GetAllSentecesForIndex"
		Int index
	Server antwortet mit CSV datei
		CSV-Sentence.csv



CSV-Story.csv
	yourstory_storyfile
	sentence|votes|index
	sentence|votes|index
	EOF

CSV-Sentence.csv
	yourstory_sentencefile
	sentence|votes
	sentence|votes
	EOF	*/

public class Test_Protocol {
    private static final int WAITING = 0;
    private static final int SENTKNOCKKNOCK = 1;
    private static final int SENTCLUE = 2;
    private static final int ANOTHER = 3;

    private static final int NUMJOKES = 5;

    private int state = WAITING;
    private int currentJoke = 0;

    private String[] clues = { "Turnip", "Little Old Lady", "Atch", "Who", "Who" };
    private String[] answers = { "Turnip the heat, it's cold in here!",
            "I didn't know you could yodel!",
            "Bless you!",
            "Is there an owl in here?",
            "Is there an echo in here?" };

    public String processInput(String theInput) {
        String theOutput = null;

        if (state == WAITING) {
            theOutput = "Knock! Knock!";
            state = SENTKNOCKKNOCK;
        } else if (state == SENTKNOCKKNOCK) {
            if (theInput.equalsIgnoreCase("Who's there?")) {
                theOutput = clues[currentJoke];
                state = SENTCLUE;
            } else {
                theOutput = "You're supposed to say \"Who's there?\"! " +
                        "Try again. Knock! Knock!";
            }
        } else if (state == SENTCLUE) {
            if (theInput.equalsIgnoreCase(clues[currentJoke] + " who?")) {
                theOutput = answers[currentJoke] + " Want another? (y/n)";
                state = ANOTHER;
            } else {
                theOutput = "You're supposed to say \"" +
                        clues[currentJoke] +
                        " who?\"" +
                        "! Try again. Knock! Knock!";
                state = SENTKNOCKKNOCK;
            }
        } else if (state == ANOTHER) {
            if (theInput.equalsIgnoreCase("y")) {
                theOutput = "Knock! Knock!";
                if (currentJoke == (NUMJOKES - 1))
                    currentJoke = 0;
                else
                    currentJoke++;
                state = SENTKNOCKKNOCK;
            } else {
                theOutput = "Bye.";
                state = WAITING;
            }
        }
        return theOutput;
    }
}