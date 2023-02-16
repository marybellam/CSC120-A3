import java.util.Scanner; 
import java.util.Random;
import java.util.ArrayList;

/**
 * Takes a user input and responds to input with a random output or mirrored words and prints transcript
 * @param user input
 * @return a transcript
 */
class Conversation {

  public static void main(String[] arguments) {
    // You will start the conversation here.
    Scanner input = new Scanner(System.in);
    System.out.println("Hi! What number of conversation rounds?");

    int lines = input.nextInt();
    System.out.println("Hey there! Whats on your mind?");
  
    String[] response = new String[6]; // make this static
    response[0] = "WoW!";
    response[1] = "Thats so great!";
    response[2] = "Okay?";
    response[3] = "Can't believe it!";
    response[4] = "Sorry to hear that.";
    response[5] = "Cool!";

    String[] mirrorWords = new String[6];
    mirrorWords[0] = "I";
    mirrorWords[1] = "me";
    mirrorWords[2] = "am";
    mirrorWords[3] = "you";
    mirrorWords[4] = "my";
    mirrorWords[5] = "your";

    String[] replacements = new String[6];
    replacements[0] = "you";
    replacements[1] = "you";
    replacements[2] = "are";
    replacements[3] = "I";
    replacements[4] = "your";
    replacements[5] = "my";

    Random num = new Random();
    String newLine = input.nextLine();
    ArrayList<String> transcript = new ArrayList<String>();
    transcript.add("Hey there! Whats on your mind?");

    for (int i = 0; i < lines; i = i + 1) {
      String str= input.nextLine();
      int intIndex = str.indexOf(mirrorWords[0]);
      int intIndex1 = str.indexOf(mirrorWords[1]);
      int intIndex2 = str.indexOf(mirrorWords[2]);
      int intIndex3 = str.indexOf(mirrorWords[3]);
      int intIndex4 = str.indexOf(mirrorWords[4]);
      int intIndex5 = str.indexOf(mirrorWords[5]);

      if(intIndex == -1 && intIndex1 == -1 && intIndex2 == -1 && intIndex3 == -1 && intIndex4 == -1 && intIndex5 == -1) {
        int next = num.nextInt(5);
        System.out.println(response[next]);
        transcript.add(str);
        transcript.add(response[next]);
      }

      if(intIndex != -1 || intIndex1 != -1 || intIndex2 != -1 || intIndex3 != -1 || intIndex4 != -1 || intIndex5 != -1){
        transcript.add(str);
        String [] sentence = str.split(" ");
        for(int j =0; j < sentence.length;j++){
          for(int k =0; k< mirrorWords.length;k++){
            if(sentence[j].equals(mirrorWords[k])){
              sentence[j] = replacements[k];
              break;
            }
          }
         }
          String result = "";
          for (String s : sentence) {
            result = result + s +" ";
          }
          transcript.add(result);

         for (int l =0; l < sentence.length; l++) {
          String sen = "";
          sen = (sentence[l] + " ");
          System.out.print(sen);
          if(l == sentence.length -1){
            System.out.print(System.lineSeparator());
          }
        }
      }
    }
    System.out.println( "See ya!");
    transcript.add("See ya!");
    System.out.print(System.lineSeparator());
    System.out.println("TRANSCRIPT: ");

    for(int c = 0; c < transcript.size(); c++){
      System.out.println(transcript.get(c));
    }
    input.close();
  }
}
