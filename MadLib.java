import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
// this a program which chooses from a set of random words to fill in
// a pre determined madlib
//the words are separated into categories (noun, adjective...) and kept in seperate files containing fifteen
//options of that category
//Christopher Marcano
public class MadLib {public static void initializeArray(ArrayList<String> aList, File file) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader(file));
    String line;
    while ((line = br.readLine()) != null) {
        aList.add(line);
    }
}


    // this chooses a new random word for each slot in the madlib
    public static String returnAppropriateWord(ArrayList<String> parentList, ArrayList<String> listOfUsedWords) {
        while (true) {
            String word = parentList.get((int) (Math.random() * parentList.size() - 1));
            if (!listOfUsedWords.contains(word)) {
                listOfUsedWords.add(word);
                return word;
            }
        }
    }
// the information from the files will be placed into the correct categories
    public static void main(String[] args) {

        ArrayList<String> place = new ArrayList<String>();
        ArrayList<String> adjective = new ArrayList<String>();
        ArrayList<String> adverb = new ArrayList<String>();
        ArrayList<String> number = new ArrayList<String>();
        ArrayList<String> noun = new ArrayList<String>();



        // this allows the program to read the pathnames of the files.
        File filePlace = new File("place.txt");
        File filedjective = new File("adjective.txt");
        File fileadverb = new File("adverb.txt");
        File filenumber = new File("number.txt");
        File fileTonoun = new File("noun.txt");

        try {
            initializeArray(noun, fileTonoun);
            initializeArray(number, filenumber);
            initializeArray(adverb, fileadverb);
            initializeArray(adjective, filedjective);
            initializeArray(place, filePlace);
        } catch (IOException e) {
            //in case the files aren't able to be located an exception will be thrown and error printed
            System.out.println("error with file");
            return;
        }

//creates arrays populated by words from the .txt files
        ArrayList<String> usedplace = new ArrayList<String>();
        ArrayList<String> usedadjective = new ArrayList<String>();
        ArrayList<String> usedadverb = new ArrayList<String>();
        ArrayList<String> usednumber = new ArrayList<String>();
        ArrayList<String> usednoun = new ArrayList<String>();
        //this prints the pre-written story and adds the correct category of word
        System.out.println("I was feeling bored one day so I decided to go to (a)(an) " + returnAppropriateWord(place, usedplace)
                + ". There is a (an) " + returnAppropriateWord(adjective, usedadjective)
                + " graveyard there. It was a\n" + "strange place with lots of "
                + returnAppropriateWord(noun, usednoun) + "s \n"
                + "and " + returnAppropriateWord(adjective, usedadjective) +  " tombstones. suddenly,\n"
                + "a groundskeeper called out, \"get out of here you salty\n" + returnAppropriateWord(noun, usednoun)
                + "\"" + ".I ran out in a(an) " + returnAppropriateWord(adjective, usedadjective) + "\n" + "hurry, but the gates were locked.\n"
                + "I ran to hide in some nearby " + returnAppropriateWord(noun, usednoun) + " bushes\n"
                + "what a (an) " + returnAppropriateWord(adjective, usedadjective) + " idea this was!\n"
                + "I didn't want to be caught so I " + returnAppropriateWord(adverb, usedadverb) + " ran\n"
                + "from my hiding spot, to try and find a different exit.\n"
                + returnAppropriateWord(number, usednumber) + " more groundskeepers were what greeted me!\n"
                + "I had to think of a new plan.\n" + "I was so nervous I nearly passed out " + returnAppropriateWord(number, usednumber) + " times! \n"
                + "suddenly I saw a crypt. This was the most \n" + returnAppropriateWord(adjective, usedadjective)
                + " crypt I had ever seen! In about " + returnAppropriateWord(number, usednumber) + "\n"
                + "seconds I ran to the crypt and threw open the gates.\n"
                + "That’s when I saw it! A horrible sight!,\n"
                + "It was (A)(An)" + returnAppropriateWord(noun, usednoun) + "!\n"
                + "I was eaten "
                + returnAppropriateWord(adverb, usedadverb) + ". It was a(n) "
                + returnAppropriateWord(adjective, usedadjective) + " day to say the least. ");

    }

}


