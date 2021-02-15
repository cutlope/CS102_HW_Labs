public class Hangman {

    //Properties
    private StringBuffer secretWord;
    private StringBuffer allLetters;
    private StringBuffer usedLetters;
    private int numberOfIncorrectTries;
    private int maxAllowedIncorrectTries;
    private StringBuffer knownSoFar;

    //Constructor
    public Hangman(){

        //the method will initialize the variable secretWord
        chooseSecretWord();
        allLetters = new StringBuffer("abcdefghijklmnopqrstuvwxyz");
        usedLetters = new StringBuffer("");
        numberOfIncorrectTries= 0;
        maxAllowedIncorrectTries = 6;
        knownSoFar = new StringBuffer("");
        
        //Adds underscore character in place of all characters of the choosen secretWord
        for( int i = 0; i < secretWord.length(); i++){
            knownSoFar.append("_");
        }
    }

    /**
     *
     * @return All letters in the alphabet
     */
    public String getAllLetters(){
        return allLetters.toString();
    }


    /**
     *
     * @return Letters that have been tried
     */
    public String getUsedLetters(){
        return usedLetters.toString();
    }

    /**
     *
     * @return Incorrect number of tries so far
     */
    public int getNumOfIncorrectTries(){
        return numberOfIncorrectTries;
    }

    /**
     *
     * @return Get the maximum allowed tries
     */
    public int getMaxAllowedIncorrectTries(){
        return maxAllowedIncorrectTries;
    }

    /**
     *
     * @return Get the letters that have been tested so far
     */
    public String getKnownSoFar(){
        return knownSoFar.toString();
    }

    /**
     *
     * @return Whether the game is over or not
     */
    public boolean isGameOver(){
        if( numberOfIncorrectTries == maxAllowedIncorrectTries || knownSoFar.toString().equals(secretWord.toString().toUpperCase().toString())){
            return true;
        }
        return false;
    }

    /**
     *
     * @return Whether the game is lost or won
     */
    public boolean hasLost(){
        return numberOfIncorrectTries == maxAllowedIncorrectTries;
    }

    public int tryThis(char letter) {
        int count;
        int errorCode = 0;
    
        
        // A character that is not in allLetters is invalid.
        if (allLetters.indexOf(String.valueOf(letter)) == -1) {
            errorCode =  -1;
        }

        // It is assumed that the main method will prevent the user from trying
        // a used letter. However, if a letter was already used, the method
        // will not stop but it will not change any of the properties.
        if (usedLetters.indexOf(String.valueOf(letter)) == -1) {
            usedLetters.append(letter);
            errorCode = -2;
        }

        if (isGameOver()) {
            errorCode =  -3;
        }
        
        count = 0;

        if (errorCode != -3) {

        for (int i = 0; i < secretWord.length(); i++) {
            if (secretWord.toString().toUpperCase().charAt(i) == letter) {
                // Replace the blank letters with the correct letter.
                // knownSoFar is assumed to have the same length as secretWord.
                knownSoFar.replace(i, i + 1, String.valueOf(letter));
                count++;
            }
        }
        
        if (count == 0)
            numberOfIncorrectTries++;
    }


        return count == 0 ? errorCode : count ;
    }

    public void chooseSecretWord()
    {
        String[] words = { "bird", "cat", "computer", "java", "Davenport" }; // Some random words
        int index;
        String chosenWord;
        
        // Assigning a random index in the range of the array
        index = (int) ( Math.random() * words.length ) ;
        
        // Getting the word from the array at that index
        chosenWord = words[index];
        secretWord =  new StringBuffer(chosenWord);
    }



}
