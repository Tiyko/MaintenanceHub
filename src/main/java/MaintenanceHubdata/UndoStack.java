/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MaintenanceHubdata;

/**
 *
 * @author Tiyko
 */

import java.util.Stack;

public class UndoStack {
    private Stack<String> stack = new Stack<>();

    public void pushAction(String action) {
        stack.push(action);
    }

    public String undo() {
        if (!stack.isEmpty()) {
            return stack.pop();
        }
        return null;
    }
}
