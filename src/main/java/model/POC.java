package main.java.model;

import java.time.LocalDateTime;

public class POC {

    public static void populateCar(Car car) {
        Part frame = new Part("Frame", "1");
        car.addPart(frame, "Frame");
        
        Assembly frontLcorner = new Assembly("Front L Corner", "02-fl");
        Part LtieRod = new Part("Tie Rod", "02-rod-a");
        Part frontlhub = new Part("Hub", "02-hub-a");
        Assembly frontRcorner = new Assembly("Front R Corner", "02-fr");
        Part RtieRod = new Part("Tie Rod", "02-rod-b");
        Part frontrhub = new Part("Hub", "02-hub-b");
        Assembly backLcorner = new Assembly("Back L Corner", "02-bl");
        Part LTLink = new Part("T Link", "02-link-a");
        Part backlhub = new Part("Hub", "02-hub-c");
        Assembly backRcorner = new Assembly("Back R Corner", "02-br");
        Part RTLink = new Part("T Link", "02-link-b");
        Part backRhub = new Part("Hub", "02-hub-d");
        car.addPart(frontLcorner, "Suspension");
        car.addPart(LtieRod, "Suspension/Front L Corner");
        car.addPart(frontlhub, "Suspension/Front L Corner");
        car.addPart(frontRcorner, "Suspension");
        car.addPart(RtieRod, "Suspension/Front R Corner");
        car.addPart(frontrhub, "Suspension/Front R Corner");
        car.addPart(backLcorner, "Suspension");
        car.addPart(LTLink, "Suspension/Back L Corner");
        car.addPart(backlhub, "Suspension/Back L Corner");
        car.addPart(backRcorner, "Suspension");
        car.addPart(RTLink, "Suspension/Back R Corner");
        car.addPart(backRhub, "Suspension/Back R Corner");

        Assembly bigboy = new Assembly("big", "Other");
        Assembly smolboy = new Assembly("smol", "Other");
        Assembly miniboy = new Assembly("mini", "Other");
        Assembly microboy = new Assembly("micro", "Other");
        Part boy = new Part("boy", "99-boy");
        car.addPart(bigboy, "Other");
        car.addPart(smolboy, "Other/big");
        car.addPart(miniboy, "Other/big/smol");
        car.addPart(microboy, "Other/big/smol/mini");
        car.addPart(boy, "Other/big/smol/mini/micro");
    }
    public static void main(String[] args) {
        Car r24 = new Car("R24");

        populateCar(r24);

        r24.addTime(new Runtime("fun", 500, LocalDateTime.now()));
        r24.addTime(new Runtime("not so fun", 500, LocalDateTime.now()));
        r24.addTime(new Runtime("not so fun", 200, LocalDateTime.now()));
        
        System.out.println(r24.fullPrint());
    }
}
