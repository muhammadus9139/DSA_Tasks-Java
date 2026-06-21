
//sp-25-bcs-151
public class Plane {
    String PlaneId;
    int fuellevel;

    Plane(String PlaneId,int fuellevel){
        this.PlaneId=PlaneId;
        this.fuellevel=fuellevel;
    }

    public String toString(){
        return "PlaneID :"+PlaneId+"Fuellevel :"+fuellevel;
    }

}
