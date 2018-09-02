package thom9521.madapp;

import java.util.Random;

public class RandomNumber {

    Random random = new Random();
    int number = 0;

    public int randomx() {
        int x = random.nextInt(number) + 1;
        number = number + 1;
        return x;

    }

    public int nemRandom(){
        int x = random.nextInt(20)+1;
        return x;
        }
    }
