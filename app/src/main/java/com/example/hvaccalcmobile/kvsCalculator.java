package com.example.hvaccalcmobile;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by Чашников Михаил on 30.08.2017.
 */

public class kvsCalculator {
    private double flowRate;                          //кубометры в час
    private double pressure;                          //Паскали
    private double temperature;                       //градусы Цельсия
    private double density;                           //кг на кубометр
    private double kvs;                               //кубометры в час
    private HashMap<Integer, Double> densityTable;    //таблица плотностей воды

    public kvsCalculator(Double flowRate, Double pressure, Double temperature){
        this.flowRate = flowRate;
        this.pressure = pressure;
        this.temperature = temperature;

        getDensityTable();

        this.density = getDensity() * Math.pow(10, 6);
    }

    private void calculateKvs(){
        this.kvs = flowRate * Math.pow((this.density / (1000 * this.pressure)), 0.5);
    }

    public Double getKvs(){
        return this.kvs;
    }


    private double getDensity(){
        double density = 0;
        Integer[] temp = this.densityTable.keySet().toArray(new Integer[this.densityTable.keySet().size()]);
        Arrays.sort(temp);
        int t = temp[0];

        for (int i = 1; i < temp.length - 1; i++) {
            if (t <= this.temperature && this.temperature <= temp[i]){
                density = this.densityTable.get(temp[i - 1]) + ((this.temperature - temp[i - 1]) / (temp[i] - temp[i - 1]))
                        * (this.densityTable.get(temp[i]) - this.densityTable.get(temp[i - 1]));
                break;
            }
            else t = temp[i];
        }
        return density;
    }

    private void getDensityTable() {
        this.densityTable = new HashMap<>();
        this.densityTable.put(0, 999.87);
        this.densityTable.put(1, 999.93);
        this.densityTable.put(2, 999.97);
        this.densityTable.put(3, 999.99);
        this.densityTable.put(4, 1000.00);
        this.densityTable.put(5, 999.99);
        this.densityTable.put(6, 999.97);
        this.densityTable.put(7, 999.93);
        this.densityTable.put(8, 999.88);
        this.densityTable.put(9, 999.81);
        this.densityTable.put(10, 999.73);
        this.densityTable.put(20, 998.23);
        this.densityTable.put(30, 995.67);
        this.densityTable.put(40, 992.24);
        this.densityTable.put(41, 991.86);
        this.densityTable.put(42, 991.47);
        this.densityTable.put(43, 991.07);
        this.densityTable.put(44, 990.66);
        this.densityTable.put(45, 990.25);
        this.densityTable.put(46, 989.82);
        this.densityTable.put(47, 989.40);
        this.densityTable.put(48, 988.96);
        this.densityTable.put(49, 988.52);
        this.densityTable.put(50, 988.07);
        this.densityTable.put(51, 987.62);
        this.densityTable.put(52, 987.15);
        this.densityTable.put(53, 986.69);
        this.densityTable.put(54, 986.21);
        this.densityTable.put(55, 985.73);
        this.densityTable.put(56, 985.25);
        this.densityTable.put(57, 984.75);
        this.densityTable.put(58, 984.25);
        this.densityTable.put(59, 983.75);
        this.densityTable.put(60, 983.24);
        this.densityTable.put(61, 982.72);
        this.densityTable.put(62, 982.20);
        this.densityTable.put(63, 981.67);
        this.densityTable.put(64, 981.13);
        this.densityTable.put(65, 980.59);
        this.densityTable.put(66, 980.05);
        this.densityTable.put(67, 979.50);
        this.densityTable.put(68, 978.94);
        this.densityTable.put(69, 978.38);
        this.densityTable.put(70, 977.81);
        this.densityTable.put(71, 977.23);
        this.densityTable.put(72, 976.66);
        this.densityTable.put(73, 976.07);
        this.densityTable.put(74, 975.48);
        this.densityTable.put(75, 974.89);
        this.densityTable.put(76, 974.29);
        this.densityTable.put(77, 973.68);
        this.densityTable.put(78, 973.07);
        this.densityTable.put(79, 972.45);
        this.densityTable.put(80, 972.83);
        this.densityTable.put(81, 971.23);
        this.densityTable.put(82, 970.57);
        this.densityTable.put(83, 969.94);
        this.densityTable.put(84, 969.30);
        this.densityTable.put(85, 968.65);
        this.densityTable.put(86, 968.00);
        this.densityTable.put(87, 967.24);
        this.densityTable.put(88, 966.68);
        this.densityTable.put(89, 966.01);
        this.densityTable.put(90, 965.34);
        this.densityTable.put(91, 964.67);
        this.densityTable.put(92, 963.99);
        this.densityTable.put(93, 963.30);
        this.densityTable.put(94, 962.61);
        this.densityTable.put(95, 961.92);
        this.densityTable.put(96, 961.22);
        this.densityTable.put(97, 960.51);
        this.densityTable.put(98, 959.81);
        this.densityTable.put(99, 959.09);
        this.densityTable.put(100, 958.38);
        this.densityTable.put(150, 917.30);
        this.densityTable.put(200, 869.00);
        this.densityTable.put(250, 794.00);
        this.densityTable.put(300, 710.00);
        this.densityTable.put(350, 574.00);
        this.densityTable.put(374, 307.00);
    }



}
