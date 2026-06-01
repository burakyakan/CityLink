/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package citylink;

/**
 *
 * @author burak
 */
public class InvalidUserIDException extends Exception {
    
    private final boolean shouldClearField;

    /**
     * Creates a new instance of <code>InvalidUserIDException</code> without
     * detail message.
     * @param msg
     * @param shouldClearField
     */
    public InvalidUserIDException(String msg, boolean shouldClearField) {
        super(msg);
        this.shouldClearField = shouldClearField;
    }
    
    public boolean isShouldClearField() {
        return shouldClearField;
    }

    
}
