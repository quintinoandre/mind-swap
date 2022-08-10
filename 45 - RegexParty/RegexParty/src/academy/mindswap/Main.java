package academy.mindswap;

import static academy.mindswap.utils.PrintSeparator.printSeparator;

public class Main {
  public static void main(String[] args) {
    System.out.println("1. Write a function that matches a string that has a p followed by zero or more q's");
    Regex.check("afsdfsfpqqqqqasdasdpppqp", "pq*");
    printSeparator("-", 100);

    System.out.println("2. Write a function to find sequences of lowercase letters joined with a underscore");
    Regex.check("afsdfsfpqqqqqasdasdppppp_reterter_erterter_SADFSDF_sdfsdf_", "[a-z]+_");
    printSeparator("-", 100);

    System.out.println("3. Write a function to find the sequences of one upper case letter followed by lower case letters");
    Regex.check("dfgfgAsdfAssasdASDSADaDFSDFsdf", "[A-Z]{1}[a-z]+");
    printSeparator("-", 100);

    System.out.println("4. Write a function that matches a string that has a 'p' followed by anything, ending in 'q'");
    Regex.check("dfgdfgdpgqfhjg_´'+hjhgpghjjqerretq", "p.*q$");
    printSeparator("-", 100);

    System.out.println("5. Write a function to match a string that contains only upper and lowercase letters, numbers, and underscores");
    Regex.check("ASDlertkrl912asd98489SADF_dfgfd__SADF+''+", "[A-Za-z0-9_]");
    printSeparator("-", 100);

    System.out.println("6. Write a function to remove all the vowels of a given string. Return the new string");
    System.out.println("kjsdfsdaqweruiiocvbsdfpi\\´90'90,.-,".replaceAll("[aeiouAEIOU]", ""));
    Regex.check("kjsdfsdaqweruiiocvbsdfpi\\´90'90,.-,", "[^aeiouAEIOU]");
    printSeparator("-", 100);

    System.out.println("7. Write a function to validate a given portuguese mobile phone number");
    System.out.println("921112001".matches("^((\\+|00)(351))?9[1236]\\d{7}$"));
    printSeparator("-", 100);

    System.out.println("8. Write a function to remove all non-alphanumeric characters from a given string");
    System.out.println("kjsdfsdaqweruiiocvbsdfpi\\´90'90,.-,".replaceAll("[^A-Za-z0-9]", ""));
    Regex.check("kjsdfsdaqweruiiocvbsdfpi\\´90'90,.-,", "[A-Za-z0-9]");
  }
}
