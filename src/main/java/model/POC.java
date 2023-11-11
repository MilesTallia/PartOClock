package main.java.model;

public class POC {
    public static void main(String[] args) {
        Car r24 = new Car("R24");

        Part frame = new Part("Frame", "1");
        r24.addPart(frame, "Frame");
        
        Assembly frontLcorner = new Assembly("Front L Corner", "02-fl");
        Assembly frontRcorner = new Assembly("Front R Corner", "02-fr");
        Assembly backLcorner = new Assembly("Back L Corner", "02-bl");
        Assembly backRcorner = new Assembly("Back R Corner", "02-br");
        r24.addPart(frontLcorner, "Suspension");
        r24.addPart(frontRcorner, "Suspension");
        r24.addPart(backLcorner, "Suspension");
        r24.addPart(backRcorner, "Suspension");
        
        System.out.println(r24);
        System.out.println(r24.fullPrint());
    }
}
