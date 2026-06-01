/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package citylink;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class VehicleDropdownManager {

    // Method 1: Populates the FIRST combo box (Only Vehicle Types)
    public DefaultComboBoxModel<String> getDropdownModel(String filepath) {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] routeData = line.split(";"); 
                
                // Make sure the line has at least the vehicle type data
                if (routeData.length > 0) {
                    String vehicleType = routeData[0].trim();
                    
                    // Add directly to the model if it's not empty and not already in there
                    if (!vehicleType.isEmpty() && model.getIndexOf(vehicleType) == -1) {
                        model.addElement(vehicleType);
                    }
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading routes data: " + e.getMessage());
        }

        return model;
    }

    // Method 2: Populates the SECOND combo box (Only Line Names based on selected vehicle)
    public DefaultComboBoxModel<String> getLineDropdownModel(String filepath, String selectedVehicle) {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] routeData = line.split(";"); 
                
                // Make sure the line has at least vehicle AND line name data
                if (routeData.length > 1) {
                    String fileVehicleType = routeData[0].trim(); 
                    String lineName = routeData[1].trim();        
                    
                    // Only add if vehicle matches, line isn't empty, and isn't already in the model
                    if (fileVehicleType.equals(selectedVehicle) && !lineName.isEmpty() && model.getIndexOf(lineName) == -1) {
                        model.addElement(lineName);
                    }
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading routes data: " + e.getMessage());
        }

        return model;
    }
}