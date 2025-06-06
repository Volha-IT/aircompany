import Planes.experimentalPlane; // class with lowercase letter
import models.MilitaryType;
import Planes.MilitaryPlane;
import Planes.PassengerPlane;
import Planes.Plane;            // why just Plane(what type of plane)

import java.util.*;

// version: 1.1
// made by Vitali Shulha
// 4-Jan-2019

public class Airport {
    private List<? extends Plane> planes;


    // hard to understand method getPasPl
    public List<PassengerPlane> getPasPl() { 
        // hard to understand variable l
        List<? extends Plane> l = this.planes;
         // hard to understand variable x
        List<PassengerPlane> x = new ArrayList<>();           
        // hard to understand variable p
        for (Plane p : l) {if (p instanceof PassengerPlane) {x.add((PassengerPlane) p);}} 
        return x;
    }

    public List<MilitaryPlane> getMilitaryPlanes() {
        List<MilitaryPlane> militaryPlanes = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof MilitaryPlane) {
                militaryPlanes.add((MilitaryPlane) plane);
                // commented code
            } //if          
            else {
             // commented code
            } // else
        // commented code
        } //for                                                                        
        return militaryPlanes;
    }

    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        List<PassengerPlane> passengerPlanes = getPasPl();
        PassengerPlane planeWithMaxCapacity = passengerPlanes.get(0);
        for (int i = 0; i < passengerPlanes.size(); i++) {
            if (passengerPlanes.get(i).getPassengersCapacity() > planeWithMaxCapacity.getPassengersCapacity()) {
                planeWithMaxCapacity = passengerPlanes.get(i);
            }
        }
        // I'm not sure but a lot of whitespaces
        






        return planeWithMaxCapacity;
    }

    public List<MilitaryPlane> getTransportMilitaryPlanes() {
    List<MilitaryPlane> transportMilitaryPlanes = new ArrayList<>();
    List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();
    // no tabs in here
    for (int i = 0; i < militaryPlanes.size(); i++) {               
    MilitaryPlane plane = militaryPlanes.get(i);
    if (plane.getType() == MilitaryType.TRANSPORT) {
    transportMilitaryPlanes.add(plane);
    }
    }
    return transportMilitaryPlanes;
    }

    public List<MilitaryPlane> getBomberMilitaryPlanes() {
        List<MilitaryPlane> bomberMilitaryPlanes = new ArrayList<>();
        List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();
        for (int i = 0; i < militaryPlanes.size(); i++) {
            MilitaryPlane plane = militaryPlanes.get(i);
            if (plane.getType() == MilitaryType.BOMBER) {
                bomberMilitaryPlanes.add(plane);
            }
        }
        return bomberMilitaryPlanes;

    }

    public List<experimentalPlane> getExperimentalPlanes() {
        List<experimentalPlane> experimentalPlanes = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof experimentalPlane) {
                experimentalPlanes.add((experimentalPlane) plane);
            }
        }
        return experimentalPlanes;
    }

    public Airport sortByMaxDistance() {
        Collections.sort(planes, new Comparator<Plane>() {
            // unreadable variables
            public int compare(Plane o1, Plane o2) {
                // method is started with upperCase and there shouldn't be _
                return o1.Get_Max_Flight_Distance() - o2.Get_Max_Flight_Distance();
            }
        });
        return this;
    }


    /**
     * Sorts by max speed 
     * @return Airport   <-- very obvious 
     */
    public Airport sortByMaxSpeed() {
        Collections.sort(planes, new Comparator<Plane>() {
            // unreadable variables
            public int compare(Plane o1, Plane o2) {
                // unreadable method 
                return o1.getMS() - o2.getMS();
            }
        });
        return this;
    }

    public Airport sortByMaxLoadCapacity() {
        Collections.sort(planes, new Comparator<Plane>() {
            // unreadable variables
            public int compare(Plane o1, Plane o2) {
                return o1.getMinLoadCapacity() - o2.getMinLoadCapacity();
            }
        });
        return this;
    }

    public List<? extends Plane> getPlanes() {
        return planes;
    }

    private void print(Collection<? extends Plane> collection) {
        // too common name(should be smth like planes)
        Iterator<? extends Plane> iterator = collection.iterator();
        while (iterator.hasNext( )) {
            Plane plane = iterator.next();
            // shouldn't use System.out.println
            System.out.println(plane);
        }
    }

    @Override
    public String toString() {
        return "Airport{" +
                "Planes=" + planes.toString() +
                '}';
    }

    //Constructor
    public Airport(List<? extends Plane> planes) {
        this.planes = planes;
    }

}
