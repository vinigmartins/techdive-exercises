package modulo1.semana5.ex1;

import java.lang.management.ManagementFactory;

public class SystemInfo {
    String soName;
    long memoryUsed;
    long memorySize;
    long memoryFree;
    int mb = 1024 * 1024;

    public SystemInfo() {
        soName = System.getProperty("os.version");
        memorySize = ((com.sun.management.OperatingSystemMXBean) ManagementFactory
                                         .getOperatingSystemMXBean()).getTotalMemorySize()/mb;
        memoryFree = ((com.sun.management.OperatingSystemMXBean) ManagementFactory
                                         .getOperatingSystemMXBean()).getFreeMemorySize()/mb;
        memoryUsed = memorySize - memoryFree;
    }

    @Override
    public String toString() {
        return ("SYSTEM INFO%n---------------------%n" +
                "SO =             '%s'   %n" +
                "memorySize =      %d Mb %n" +
                "memoryFree =      %d Mb %n" +
                "memoryUsed =      %d Mb %n").formatted(soName, memorySize, memoryFree, memoryUsed);
    }

    public static void main(String[] args) {
        SystemInfo system = new SystemInfo();
        System.out.println(system);
    }
}
