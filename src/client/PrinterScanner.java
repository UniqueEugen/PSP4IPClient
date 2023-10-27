package client;



import myLibrary.console.Console;
import myLibrary.input.Scan;

import java.util.*;
import java.util.stream.IntStream;

public class PrinterScanner {
    private Integer matrixSize;
   // private Integer matrix[][];
    private String req;
    private void setVarRandom() {
        Random random = new Random();
        IntStream.range(0, matrixSize)
                .forEach(row -> IntStream.range(0, matrixSize)
                        .forEach(column ->getVar(random.nextInt(18))));

    }
    private void setVar(){
        IntStream.range(0, matrixSize)
                .forEach(row -> IntStream.range(0, matrixSize)
                        .forEach(column ->
                               getVar(Var(row, column))));
    }
    private int Var(int row, int column){
        Console.log("Введите значение [" + row+ "]["+column+"]");
        return Scan.intScan();
    }
    private void set(){
        Console.log("Добрейшего времени суток! Ведите размерность квадратной матрицы");
        matrixSize = Math.abs(Scan.intScan());
        req = matrixSize+" ";
        Console.log("Будем мучатся с ручным заполнением, или заполнить случайными числами?\n1.Заполни на рандом\n2.Хочу мучатся!");
        if(!Scan.booleanScan()){
            setVarRandom();
        }else{
            setVar();
        }

    }
    private void getVar(int val){
        req+= val + " ";
    }
   /* @Override
    public String toString(){
        set();
        //System.out.println(xReq.toString());
        String req;
        IntStream.range(0, matrixSize)
                .forEach(row -> IntStream.range(0, matrixSize)
                        .forEach(column -> getVar(row,column)));
        return req;
    }*/
    public String getMatrix(){
        set();
        String str[] =req.split(" ");
        for(int i =1; i< str.length; i++){
            System.out.print(str[i]+" ");
            if(i%matrixSize==0) Console.log("");
        }

        return req;
    }
}
