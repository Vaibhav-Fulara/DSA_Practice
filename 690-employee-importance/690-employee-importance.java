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
        int val = 0;
        for(int i=0; i<employees.size(); i++){
            Employee e = employees.get(i);
            if(e.id == id){
                for(int temp: e.subordinates) val += getImportance(employees, temp);
                return val + e.importance;
            }
        }
        return -1;
    }
}