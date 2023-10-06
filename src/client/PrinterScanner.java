package client;

import scan.Scan;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PrinterScanner {
    private Double x;
    private Double y;
    private Double z;
    private Map<String, Double> xReq = Stream.of(
                    new AbstractMap.SimpleEntry<>("x", x=0d),
                    new AbstractMap.SimpleEntry<>("y", y=0d),
                    new AbstractMap.SimpleEntry<>("z", z=0d))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    private void setVar(String var) {
        System.out.println("Введите значение " + var);
        xReq.put(var, Scan.doubleScan());
    }
    private void set(){
        xReq.forEach((k, v) -> setVar(k));
    }
    private String checkNull(String var){
        try {
            return xReq.get(var).toString();
        }catch (Exception e){
            return "0";
        }
    }
    @Override
    public String toString(){
        set();
        System.out.println(xReq.toString());
        String req;
        req =    checkNull("x") +" "
                +checkNull("y")+" "
                +checkNull("z");
        return req;
    }
}
