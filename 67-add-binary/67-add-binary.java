class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int m = a.length()-1;
        int n = b.length()-1;
        int carry = 0;
        
        while(m>=0 && n>=0){
            carry = add(Character.getNumericValue(a.charAt(m)) + Character.getNumericValue(b.charAt(n)), result, carry);
            m--;
            n--;
        }
        
        if(m>=0){
            while(m>=0){
                carry = add(Character.getNumericValue(a.charAt(m)), result, carry);
                m--;
            }
        }else if(n>=0){
            while(n>=0){
                carry = add(Character.getNumericValue(b.charAt(n)), result, carry);
                n--;
            }
        }
        
        if(carry == 1)
            result.append('1');
        
        return result.reverse().toString();
    }
    
    private int add(int sum, StringBuilder result, int carry){
        carry += sum;
        if(carry%2==0){
            result.append('0');
        }else{
            result.append('1');
        }
        carry /= 2;
        return carry;
    }
}