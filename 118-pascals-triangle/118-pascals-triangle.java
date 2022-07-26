class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> main = new ArrayList<>();
        
        main.add(new ArrayList<>());
        main.get(0).add(1);
        numRows--;

        while(numRows>0){
            List<Integer> prevList = main.get(main.size()-1);
            List<Integer> nList = new ArrayList<>();
            
            int i = 1;
            nList.add(1);

            while(i<prevList.size()){
                nList.add(prevList.get(i-1)+prevList.get(i));
                i++;
            }

            nList.add(1);
            main.add(nList);
            numRows--;
        }

        return main;
    }
}