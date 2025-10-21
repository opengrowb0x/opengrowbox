### **Troubleshooting**

*   **No "click" sound:**
    *   Check your VCC and GND connections. Are you providing 5V?
    *   Did you connect the grounds together if using an external PSU?
    *   Check your Python code. Is the correct GPIO number used?
    *   Verify the jumper is on the "VCC/JD-VCC" pins (if your board has it) to enable separate power.
*   **Relay turns on but the device doesn't power:**
    *   Check your connections on the COM and NO terminals.
    *   Test your device with a direct connection to power to ensure it works.
*   **Pi reboots or acts erratically when a relay activates:**
    *    You are overloading the Pi's 5V rail. **You must use an external power supply (Method 2)** for the relay module.


