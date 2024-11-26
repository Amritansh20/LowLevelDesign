package CarRentalDesign;

import java.util.ArrayList;
import java.util.List;

public class City {
    String id;
    String name;
    List<Branch> branches;
    
    public City(String id, String name){
        this.id=id;
        this.name=name;
        this.branches= new ArrayList<>();
    }

    public void addBranch(Branch branch){
        branches.add(branch);
    }

    public List<Branch> getBranches(){
        return branches;
    }

    public String getName() {
        return name;
    }

    public Branch getBranch(List<Branch> branches , String branchName){
        for(int i=0;i<branches.size();i++){
            if(branches.get(i).getName() == branchName){
                return branches.get(i);
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "City{id='" + id + "', name='" + name + "'}";
    }

}
