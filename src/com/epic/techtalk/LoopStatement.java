package com.epic.techtalk;

import java.util.ArrayList;
import java.util.List;

public class LoopStatement {
    List<String> myList = new ArrayList<>();
    public void usingSimpleForLoop() {
        String text = "";
        for (int x = 0; x < myList.size(); x++){
            text += myList.get(x);
        }

    }

    public void usingEnhancedForLoop() {
        String text = "";
        for (String value: myList){
            text += value;
        }

    }

    String textIter = "";
    public void usingIterator() {

        myList.iterator().forEachRemaining(value ->{
            textIter += value;
        });
    }

    String textStram = "";
    public void usingStream() {
        myList.stream().forEach(value -> textStram += value);
    }

    public static void main(String[] args) {
        LoopStatement loopStatement = new LoopStatement();
        for (int i = 0; i < 100000; i++) {
            loopStatement.myList.add(""+i);
        }
        double startTime, endTime, duration;
        String seconds;


        startTime = System.nanoTime();
        loopStatement.usingSimpleForLoop();
        endTime = System.nanoTime();
        duration = (endTime - startTime)/1000000000;
        seconds = String.format("%.7f", duration);
        System.out.println("usingSimpleForLoop It's took seconds: "+seconds);
//
//        startTime = System.nanoTime();
//        loopStatement.usingEnhancedForLoop();
//        endTime = System.nanoTime();
//        duration = (endTime - startTime)/1000000000;
//        seconds = String.format("%.7f", duration);
//        System.out.println("usingEnhancedForLoop It's took seconds: "+seconds);
//
//        startTime = System.nanoTime();
//        loopStatement.usingIterator();
//        endTime = System.nanoTime();
//        duration = (endTime - startTime)/1000000000;
//        seconds = String.format("%.7f", duration);
//        System.out.println("usingIterator It's took seconds: "+seconds);

//        startTime = System.nanoTime();
//        loopStatement.usingStream();
//        endTime = System.nanoTime();
//        duration = (endTime - startTime)/1000000000;
//        seconds = String.format("%.7f", duration);
//        System.out.println("usingStream It's took seconds: "+seconds);
    }
}
