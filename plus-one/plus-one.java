class Solution {
    public int[] plusOne(int[] digits) {
        boolean newArray = false;
        for(int i=digits.length-1; i>=0; i--){
            if(digits[i]<9){
                digits[i]++;
                return digits;
            }else{
                digits[i] = 0;
                if(i==0)
                    newArray = true;
            }
        }
        
        int[] newDigits = new int[digits.length+1];
        newDigits[0] = 1;
        for(int i=1; i<newDigits.length; i++){
            newDigits[i] = digits[i-1];
        }
        
        return newDigits;
    }
}