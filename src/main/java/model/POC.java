package main.java.model;

public class POC {
    public static void main(String[] args) {
        Car r24 = new Car("R24");

        // Part frame = new Part("Frame", "1");
        // r24.addPart(frame, "Frame");
        
        // Assembly frontLcorner = new Assembly("Front L Corner", "02-fl");
        // Part LtieRod = new Part("Tie Rod", "02-rod-a");
        // Part frontlhub = new Part("Hub", "02-hub-a");
        // Assembly frontRcorner = new Assembly("Front R Corner", "02-fr");
        // Part RtieRod = new Part("Tie Rod", "02-rod-b");
        // Part frontrhub = new Part("Hub", "02-hub-b");
        // Assembly backLcorner = new Assembly("Back L Corner", "02-bl");
        // Part LTLink = new Part("T Link", "02-link-a");
        // Part backlhub = new Part("Hub", "02-hub-c");
        // Assembly backRcorner = new Assembly("Back R Corner", "02-br");
        // Part RTLink = new Part("T Link", "02-link-b");
        // Part backRhub = new Part("Hub", "02-hub-d");
        // r24.addPart(frontLcorner, "Suspension");
        // r24.addPart(LtieRod, "Suspension/Front L Corner");
        // r24.addPart(frontlhub, "Suspension/Front L Corner");
        // r24.addPart(frontRcorner, "Suspension");
        // r24.addPart(RtieRod, "Suspension/Front R Corner");
        // r24.addPart(frontrhub, "Suspension/Front R Corner");
        // r24.addPart(backLcorner, "Suspension");
        // r24.addPart(LTLink, "Suspension/Back L Corner");
        // r24.addPart(backlhub, "Suspension/Back L Corner");
        // r24.addPart(backRcorner, "Suspension");
        // r24.addPart(RTLink, "Suspension/Back R Corner");
        // r24.addPart(backRhub, "Suspension/Back R Corner");

        Assembly bigboy = new Assembly("big", "Other");
        Assembly smolboy = new Assembly("smol", "Other");
        Assembly miniboy = new Assembly("mini", "Other");
        Assembly microboy = new Assembly("micro", "Other");
        Part boy = new Part("boy", "99-boy");
        r24.addPart(bigboy, "Other");
        r24.addPart(smolboy, "Other/big");
        r24.addPart(miniboy, "Other/big/smol");
        r24.addPart(microboy, "Other/big/smol/mini");
        r24.addPart(boy, "Other/big/smol/mini/micro");
        
        System.out.println(r24.fullPrint());
        System.out.println(bigboy.getParts());
    }
}
