
# Lights and Fans

Here is a complete guide covering the wiring, the theory of operation, and a gpio examples to test.

### **⚠️ Important Safety Warning First**
This relay module is used to control high-voltage appliances (like lamps, fans, etc.). **Mishandling high voltage can cause fire, electric shock, serious injury, or death.**
*   If you are new to this, **practice only with low-voltage devices** (like 5V/12V LEDs, motors, or buzzers) first.
*   Always disconnect ALL power when making or changing connections.
*   Never work on high-voltage circuits alone.
*   Ensure all high-voltage wiring is properly insulated and secured.

---

## 𖣘 Fans
### **What You'll Need**

1.  **Raspberry Pi** (any model with GPIO pins, e.g., Pi 3, 4, or 5).
2.  **SainSmart 8-Channel Relay Module**.
3.  **Female-to-Female Jumper Wires** (at least 10 recommended).
4.  **External 5V Power Supply** (for the relay module - highly recommended for stability).
5.  **Breadboard** (optional, but helpful for organizing the power connections).

---

### **Step 1: Understanding the Relay Module's Pins**

Your SainSmart board has three sets of pins for each of the 8 relays.

1.  **Control Pins (Low-Voltage Side):**
    *   **VCC:** Power for the relay's electromagnet.
    *   **GND:** Ground for the relay's electromagnet.
    *   **IN1, IN2, IN3, ... IN8:** The signal pins from the Raspberry Pi. Applying a low signal (0V) to these pins activates the relay.

2.  **Relay Terminals (High-Voltage Side - **NO, COM, NC**):**
    *   **COM (Common):** This is the central terminal.
    *   **NO (Normally Open):** When the relay is **OFF**, COM is disconnected from NO. When the relay is **ON**, COM is connected to NO, completing the circuit.
    *   **NC (Normally Closed):** When the relay is **OFF**, COM is connected to NC. When the relay is **ON**, COM is disconnected from NC.

*For this guide you will use the **COM** and **NO** terminals only.*

---

### **Step 2: Wiring it all together**

There are two common ways to power the relay module. **Method 2 is strongly recommended** to avoid overloading your Raspberry Pi's power supply.

#### **Method 1: Powering from the Pi (Simpler, but for Low-Power Use Only)**
If you are only activating one or two relays at a time, you *can* power the module directly from the Pi. For all 8 relays or any substantial load, use **Method 2**.
The growbox control software takes care of only using one at a time!


| Relay Module | Raspberry Pi GPIO |
| :----------- | :---------------- |
| **VCC**      | -> **5V Pin** (e.g., Pin 2) |
| **GND**      | -> **GND Pin** (e.g., Pin 6) |
| **IN1**      | -> **GPIO17** (Pin 11) |
| **IN2**      | -> **GPIO18** (Pin 12) |
| **IN3**      | -> **GPIO27** (Pin 13) |
| ... (continue for other relays) |

    ┌─────────────────┐           ┌─────────────────┐
    │ SainSmart Relay │           │ Raspberry Pi    │
    │ Module          │           │ GPIO Header     │
    │                 │           │                 │
    │ VCC    ────────>│──────────>│ 5V (Pin 2)      │
    │ GND    ────────>│──────────>│ GND (Pin 6)     │
    │ IN1    ────────>│──────────>│ GPIO17 (Pin 11) │
    │ IN2    ────────>│──────────>│ GPIO18 (Pin 12) │
    │ IN3    ────────>│──────────>│ GPIO27 (Pin 13) │
    │ ...             │           │ ...             │
    └─────────────────┘           └─────────────────┘

#### **Method 2: Using an External Power Supply (Recommended & Stable)**
This method uses a separate 5V power supply (like a phone charger adapter) for the relay module, while the control signals still come from the Pi.

| Relay Module | Raspberry Pi GPIO | External 5V PSU |
| :----------- | :---------------- | :-------------- |
| **VCC**      | -> *Not Connected* | -> **5V**       |
| **GND**      | -> **GND Pin** (e.g., Pin 6) | -> **GND**      |
| **IN1**      | -> **GPIO17** (Pin 11) |                 |
| **IN2**      | -> **GPIO18** (Pin 12) |                 |
| **IN3**      | -> **GPIO27** (Pin 13) |                 |
| ... (continue) |                   |                 |

**Crucial:** Notice that the **GND** from the external supply and the **GND** from the Raspberry Pi are connected together (they share a common ground). This is essential for the signal (IN pins) to be understood correctly.

    ┌─────────────────┐    ┌─────────────────┐    ┌───────────────┐
    │ SainSmart Relay │    │ Raspberry Pi    │    │ 5V External   │
    │ Module          │    │ GPIO Header     │    │ Power Supply  │
    │                 │    │                 │    │               │
    │ VCC    ────────>│────┼─────────────────┼────>│ 5V Output    │
    │ GND    ────────>│────>│ GND (Pin 6)    │<───>│ GND          │
    │ IN1    ────────>│────>│ GPIO17 (Pin 11)│    │               │
    │ IN2    ────────>│────>│ GPIO18 (Pin 12)│    │               │
    │ IN3    ────────>│────>│ GPIO27 (Pin 13)│    │               │
    │ ...             │    │ ...             │    │               │
    └─────────────────┘    └─────────────────┘    └───────────────┘
                    (Shared Ground is CRITICAL here)

### Step 3 Testing

Assuming you want to test what's connected on GPIO17:

Turn on
    
    gpio -g write 17 0

Turn off

    gpio -g write 17 1
    
Read all the pins
    
    gpio readall

## 💡 Lights


### **Step 4: Connecting a Load (Example with a Lamp)**

**⚠️ ONLY ATTEMPT THIS IF YOU ARE CONFIDENT AND HAVE TAKEN SAFETY PRECAUTIONS.**

1. ** Unplug the lamp from the wall **
2. Check that the relay board max supported is adequate for your lights: (usually >= 10A)
3. Connect one of the wires to the **COM** terminal of a relay (e.g., Relay 1).
4. Connect the other wire to the **NO** terminal of the same relay.
5. Double-check all connections. Ensure no bare wire is exposed.
6. Plug the relay and light power source.
7. Run gpio to check if it works

