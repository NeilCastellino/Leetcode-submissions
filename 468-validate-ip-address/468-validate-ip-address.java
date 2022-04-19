class Solution {
    public String validIPAddress(String queryIP) {
        if(queryIP.chars().filter(ch -> ch == '.').count() == 3){
            //IPv4
            String[] split = queryIP.split("\\.",-1);
            for(String add:split){
                if(add.length()>3 || add.length()==0)
                    return "Neither";
                
                if(add.length()!=1 && add.charAt(0)=='0')
                    return "Neither";
                
                for(char c:add.toCharArray()){
                    if(!Character.isDigit(c)){
                        return "Neither";
                    }
                }
                
                if(Integer.parseInt(add)>255)
                    return "Neither";
            }
            return "IPv4";
        }else if(queryIP.chars().filter(ch -> ch == ':').count() == 7){
            //IPv6
            String[] split = queryIP.split(":",-1);
            String hex = "0123456789abcdefABCDEF";
            for(String add:split){
                if(add.length()>4 || add.length()==0)
                    return "Neither";
                
                for(Character c:add.toCharArray()){
                    if(hex.indexOf(c) == -1){
                        return "Neither";
                    }
                }
            }
            return "IPv6";
        }else
            return "Neither";
    }
}