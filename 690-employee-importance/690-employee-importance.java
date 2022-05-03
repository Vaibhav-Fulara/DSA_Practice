/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee>employees, int id) {
        HashMap<Integer, Employee>hm = new HashMap<>();
        for(Employee e:employees) hm.put(e.id, e);
        Employee e = hm.get(id);
        return dfs(hm, e);
    }
    public int dfs (HashMap<Integer, Employee>hm, Employee e){
        int val =0;
        for(int temp: e.subordinates) val += dfs(hm, hm.get(temp));
        return val + e.importance;
    }
}