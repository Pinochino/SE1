package ModifyString;

public class ModifyString {

    public static String modifyString(String text){
        StringBuilder result = new StringBuilder();
        boolean isCapitalize = false;

        for (char i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);

            if (currentChar == ' '){
                isCapitalize = true;
            } else {
                if (isCapitalize){
                    result.append(Character.toUpperCase(currentChar));
                    isCapitalize = false;
                } else {
                    result.append(currentChar);
                }
            }
        }

        return result.toString().replaceAll(" ", "");
    }

    public static void main(String[] args) {

    }
}
