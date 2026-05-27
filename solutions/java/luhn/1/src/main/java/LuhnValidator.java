class LuhnValidator {

    boolean isValid(String candidate) {
        //remove the spaces
        String temp= String.join("", candidate.split(" "));

        //len conditions
        if(temp.length() <=1){
            return false;
        }

        int sum = 0;
        boolean seconddigit = false; // 1 (false) .. 2 (true) .. so on

        //right to left 
        for(int i = temp.length() -1; i >=0; i--){
            int digit = Character.getNumericValue(temp.charAt(i));

            if(seconddigit == true){
                digit *= 2;
                if(digit >9){
                    digit -= 9;
                }  
            }
            sum += digit;
            seconddigit = !seconddigit; //flip flops for next iteration

        }
                //divisibility
        return sum % 10 == 0;
    }
}
