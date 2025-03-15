public class CreditCardValidator {
    public static boolean validCreditCard(String value) {
        
        if (!value.matches("[0-9\\s-]+")) {
            return false;
        }

       
        value = value.replaceAll("\\D", "");

        int nCheck = 0;
        boolean bEven = false;

      
        for (int n = value.length() - 1; n >= 0; n--) {
            int nDigit = Character.getNumericValue(value.charAt(n));

            if (bEven) {
                nDigit *= 2;
                if (nDigit > 9) {
                    nDigit -= 9;
                }
            }

            nCheck += nDigit;
            bEven = !bEven;
        }

        
        return (nCheck % 10) == 0;
    }

    public static void main(String[] args) {
        
        System.out.println(validCreditCard("4539 1478 0346 6847")); 
        System.out.println(validCreditCard("1234 5678 9052 3456")); 
        System.out.println(validCreditCard("6011-1111-1241-1117")); 
        System.out.println(validCreditCard("3782 822463 10006"));   
    }
}