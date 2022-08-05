class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> mainList = new ArrayList<>();
        mainList.add(new ArrayList<>());
        mainList.get(0).add(1);
        
        for(int i=2; i<=rowIndex+1; i++){
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for(int j=1; j<i-1; j++){
                List<Integer> prev = mainList.get(i-2);
                row.add(prev.get(j) + prev.get(j-1));
            }
            row.add(1);
            mainList.add(row);
        }
        
        return mainList.get(rowIndex);
    }
}