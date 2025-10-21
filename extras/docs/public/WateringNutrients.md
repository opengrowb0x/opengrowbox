## Water & Nutrients

This projects uses an enhanced Flood & Drain System with automatic Top-Off Tank and Nutrient Dosing

See the diagram below


    +---------------------------------------+
    |         Grow Container                |
    |                                       |
    |  [Plant]                              |
    |   |  |                                |
    |   ͰͰͰ              <- Roots in Medium  |
    |                                       |
    |---->| Fill Pipe (from Flood Pump)     |
    |                                       |
    |=========================|             |
    |     Water Level during Flood          |
    |=========================|             |
    |                                       |
    |---->| Overflow Pipe (to Reservoir)    |
    +---------------------------------------+
                    ^
                    |
                    |
    +---------------------------------------+
    |             Main Reservoir            |
    |                                       |
    |         ~~~~~~~~~~~~~~~~~~~           |
    |         ~~~~~~~~~~~~~~~~~~~           |
    |      (Mixed Nutrient Solution)        |
    |                                       |
    |      [ Submersible Pump: Flood Pump ] |
    |                                       |
    +---------------------------------------+
                    ^
                    |
                    | (Water Level Sensor)
                    |
    +---------------+-----------------------+
    | Float Valve or Solenoid or estimated? |
    +---------------------------------------+
                    ^
                    |
    +---------------------------------------+
    |          Clean Water Tank             |
    |        (Top-Off Reservoir)            |
    |                                       |
    |         ~~~~~~~~~~~~~~~~~~~           |
    |         ~~~~~~~~~~~~~~~~~~~           |
    |           (RO/DI Water)               |
    |                                       |
    |    [ Submersible Pump: Water Pump ]  |
    +---------------------------------------+

    +---------------------------------------+
    |        Nutrient Dosing System         |
    |                                       |
    |  +--------+  +--------+  +--------+   |
    |  |  A     |  | B      |  | C      |   |
    |  |Nutrient|  |Nutrient|  |Nutrient|   |
    |  | Stock  |  | Stock  |  | Stock  |   |
    |  +--------+  +--------+  +--------+   |
    |     |           |           |         |
    |  [Dosing Pump] [Dosing Pump] [Dosing Pump]
    |     |           |           |         |
    |     +-----------+-----------+---------+
    |                             |
    |                             v
    |                    To Main Reservoir
    +---------------------------------------+

## Components
### 1. Grow container (Growing medium)
-   This is the container that holds your plants. It's where the flooding happens. The plants are held in net pots filled with a growing medium.
### 2. Clean Water Tank (Top-Off Reservoir)
-   Purpose: Automatically maintains the water level in the main reservoir as plants drink water and evaporation occurs.
-   How it works: Uses either a simple float valve (like in a toilet tank) or an electronic solenoid valve + water level sensor in the main reservoir.
-   Water type: Typically uses Reverse Osmosis (RO) or deionized (DI) water to prevent introducing unknown minerals.
-   Benefit: Prevents nutrient concentration from increasing as water levels drop, maintaining stable Electrical Conductivity (EC).

### 3. Main Reservoir
The tank that holds the nutrient solution. This gets clean water from the Clean Water Tank and nutrients from the Nutrient Dosing system.  
### 4. Nutrient Dosing System with 3 tanks

   Purpose: Store concentrated nutrient solutions for automated dosing.

   Typical Setup:

        Tank A: Base nutrients (Part A)

        Tank B: Base nutrients (Part B) - kept separate to prevent precipitation

        Tank C: Supplements (Cal-Mag, pH adjusters, etc.)

   Why separate? Some nutrients react with each other when concentrated, forming insoluble compounds that plants can't absorb.

Dosing Pumps
- Purpose: Precisely add small amounts of concentrated nutrients to the main reservoir.
- Peristaltic pumps: Most common - very precise and prevent backflow, as well as isolated from the content. 



**growbox-control** manages this by adding nutrients automatically when filling the main reservoir.
There's also support for EC/pH controllers.


### Flood & Drain cycle operation

Automatic Top-Off Process with nutrient mix:

- Plants absorb water from the main reservoir during flood cycles
- Water level in main reservoir drops
- Clean water pump is activated (using estimated or sensor triggers) allowing clean water to enter the reservoir
- Nutrients are added to the reservoir according to the added water allowing to keep the wanted concentration. 
- Water level is restored preserving the nutrient concentration

EC based Nutrient Dosing Process:

- EC sensor monitors nutrient strength in main reservoir
- When EC drops below setpoint (plants are feeding), dosing pumps activate
- Precise amounts from each stock tank are added to main reservoir
  
pH balancing
- pH sensor pH in main reservoir
- When pH is lower or higher than setpoints, dosing pumps activate to add pH+ or pH-


Benefits of This Enhanced System

- Stable Environment: Maintains consistent EC/pH levels automatically
- Reduced Maintenance: Can run for weeks or even months without manual intervention
- Precision Growing: Optimal nutrient levels 24/7
- Scalability: Easy to expand to multiple grow tables


### Default values

Depending on your pump system default values for watering and nutrient dispensing can be adjusted. 

Default values:
- Water Tank Pump (120 s)
- Flood Pump (200 s)
- Nutrient A (3.25 s)
- Nutrient B (1.2 s)
- Nutrient C (3.25 s)

In this setup, nutrients A & C are dispensed at the same rate while B at half the rate, assuming the 3 systems are the same, but you can adjust accordingly to your system.
See scripts/nutrientTests.sh for more info.

### Water/Nutrient Calibration

( sleep 20 ; gpio -g write 27 1 ) &; ( sleep 20 ; gpio -g write 27 1 ) &


### Water Level
A binary water level can be installed on the tank.
See

( sleep 20 ; gpio -g read 27 ) &