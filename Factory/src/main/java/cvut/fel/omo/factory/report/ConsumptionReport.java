package cvut.fel.omo.factory.report;

import cvut.fel.omo.factory.management.Line;

import java.io.File;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;


public class ConsumptionReport implements Report {
    private Archive archive;

    public ConsumptionReport(Archive archive){
        this.archive = archive;
    }
    @Override
    public void create(int from, int to) {
        try {
            File f = new File("consumptionReport_from_" + from + "_to_" + to + ".txt");
            PrintWriter writer = new PrintWriter(f, StandardCharsets.UTF_8);
            writer.write("CONSUMPTION REPORT - FROM TACT " + from + " TO TACT " + to + "\n");
            writer.flush();
            //DATA
            int total = 0;
            int size = -1;
            ArrayList<Integer> line_consumption = new ArrayList<Integer>();
            ArrayList<Integer> line_robot_consumption = new ArrayList<Integer>();
            ArrayList<Integer> line_machine_consumption = new ArrayList<Integer>();
            ArrayList<ArrayList<Integer>> robot_serial = new ArrayList<ArrayList<Integer>>();
            ArrayList<ArrayList<Integer>> machine_serial = new ArrayList<ArrayList<Integer>>();
            ArrayList<ArrayList<Integer>> every_machine = new ArrayList<ArrayList<Integer>>();
            ArrayList<ArrayList<Integer>> every_robot = new ArrayList<ArrayList<Integer>>();
            /////////////////////////////////////////////
            for (int i = from; i <= to; i++) {
                StatData statData = archive.getStatData().get(i);
                total += statData.getFactoryElectricity();
                for (int j = 0; j < statData.getLineData().size(); j++) {
                    LineStatData lineData = statData.getLineData().get(j);
                    if (j > size) {
                        line_machine_consumption.add(lineData.machinesElectricity);
                        line_robot_consumption.add(lineData.robotsElectricity);
                        line_consumption.add(lineData.allElectricity);
                        every_machine.add(lineData.machElectricity);
                        every_robot.add(lineData.robElectricity);
                        robot_serial.add(lineData.robotSerial);
                        machine_serial.add(lineData.machineSerial);
                        size++;
                    } else {
                        line_machine_consumption.set(j, lineData.machinesElectricity + line_machine_consumption.get(j));
                        line_robot_consumption.set(j, lineData.robotsElectricity + line_robot_consumption.get(j));
                        line_consumption.set(j, lineData.allElectricity + line_consumption.get(j));
                        for (int x = 0; x < every_machine.get(j).size(); x++) {
                            every_machine.get(j).set(x, lineData.machElectricity.get(x) + every_machine.get(j).get(x));
                        }
                        for (int x = 0; x < every_robot.get(j).size(); x++) {
                            every_robot.get(j).set(x, lineData.robElectricity.get(x) + every_robot.get(j).get(x));
                        }
                    }
                }
            }
            writer.write("\tTotal consumption: " + total + "\n");
            writer.flush();
            for (int j = 0; j < line_consumption.size(); j++) {
                writer.write("\t+++++++++++++++++++++++++++++\n" +
                        "\tTotal consumption of line " + (j + 1) + ": " + line_consumption.get(j) + "\n" +
                        "\t\tConsumption of all machines: " + line_machine_consumption.get(j) + "\n" +
                        "\t\tConsumption of all robots: " + line_robot_consumption.get(j) + "\n" +
                        "\t\tConsumption of every machine: \n");
                writer.flush();
                for (int x = 0; x < every_machine.get(j).size(); x++) {
                    writer.write("\t\t\tSerial number: " + machine_serial.get(j).get(x) + " Consumption: " + every_machine.get(j).get(x) + "\n");
                    writer.flush();
                }
                writer.write("\t\tConsumption of every robot: \n");
                writer.flush();
                for (int x = 0; x < every_robot.get(j).size(); x++) {
                    writer.write("\t\t\tSerial number: " + robot_serial.get(j).get(x) + " Consumption: " + every_robot.get(j).get(x) + "\n");
                    writer.flush();
                }
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
