package P0055;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DoctorHash {
    private HashMap<String, Doctor> map = new HashMap<String, Doctor>();

    public int checkAvailability(String availability){
        Scanner input = new Scanner(System.in);
        try {
            int a = Integer.parseInt(availability);
            return a;
        } catch (Exception e) {
            System.out.println("Availability is a number which is equal or greater than 0");
            System.out.print("Enter Availability: ");
            availability = input.next();
            return checkAvailability(availability);
        }
    }

    public boolean addDoctor(Doctor doctor) throws Exception{
        if(map == null)
            throw new Exception("Database does not exist");
        if(doctor == null)
            throw new Exception("Data does not exist");
        if(map.containsKey(doctor.getCode()))
            throw new Exception("Doctor code "+doctor.getCode()+" is duplicate");
        map.put(doctor.getCode(), doctor);
        return true;    
    }

    public boolean updateDoctor(Doctor doctor) throws Exception{
        if(map == null)
            throw new Exception("Database does not exist");
        if(doctor == null)
            throw new Exception("Data does not exist");
        if(!map.containsKey(doctor.getCode()))
            throw new Exception("Doctor code "+doctor.getCode()+" does not exists");
        map.replace(doctor.getCode(), map.get(doctor.getCode()), doctor);
        
        return true;
    }

    public boolean deleteDoctor(String code) throws Exception{
        if(map == null)
            throw new Exception("Database does not exist");
        if(!map.containsKey(code))
            throw new Exception("Doctor code "+code+" does not exists");
        map.remove(code);
        return true;
    }

    public HashMap<String, Doctor> searchDoctor(String name) throws Exception{
        HashMap<String, Doctor> m = new HashMap<String, Doctor>();
        if(map == null)
            throw new Exception("Database does not exist");
        
        for(Map.Entry<String,Doctor> x:map.entrySet()){
            if(x.getValue().getName().equals(name));
                m.put(x.getKey(), x.getValue());
        }
        return m;
    }

    public void display(HashMap<String, Doctor> m){
        for(Map.Entry<String, Doctor> x: map.entrySet()){
            System.out.println(x.getValue().toString());
        }
    }
}
