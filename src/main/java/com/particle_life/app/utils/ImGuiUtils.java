package com.particle_life.app.utils;

import com.particle_life.app.selection.SelectionManager;
import imgui.ImGui;
import imgui.flag.ImGuiSliderFlags;

public final class ImGuiUtils {
    
    private ImGuiUtils() {}

    public static void helpMarker(String text) {
        ImGui.textDisabled("(?)");
        if (ImGui.isItemHovered()) {
            ImGui.setTooltip(text);
        }
    }

    public static boolean link(String label, String url) {
        ImGui.textColored(100, 149, 237, 255, label);
        if (ImGui.isItemHovered()) {
            ImGui.setMouseCursor(7);
        }
        if (ImGui.isItemClicked()) {
            try {
                java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
                return true;
            } catch (Exception e) {
                System.err.println("Failed to open URL: " + url);
            }
        }
        return false;
    }

    public static boolean renderCombo(String label, SelectionManager<?> selectionManager) {
        int previousIndex = selectionManager.getActiveIndex();
        
        if (ImGui.beginCombo(label, selectionManager.getActiveName())) {
            for (int i = 0; i < selectionManager.size(); i++) {
                boolean isSelected = (i == selectionManager.getActiveIndex());
                
                if (ImGui.selectable(selectionManager.get(i).name, isSelected)) {
                    selectionManager.setActive(i);
                }
                
                if (isSelected) {
                    ImGui.setItemDefaultFocus();
                }
                
                if (ImGui.isItemHovered()) {
                    String description = selectionManager.get(i).description;
                    if (!description.isBlank()) {
                        ImGui.setTooltip(description);
                    }
                }
            }
            ImGui.endCombo();
        }
        
        return selectionManager.getActiveIndex() != previousIndex;
    }

    public interface NumberInputCallback {
        void onValueChanged(float value);
    }
    
    public static void numberInput(String label, float min, float max, float value, 
                                 String format, NumberInputCallback callback) {
        numberInput(label, min, max, value, format, callback, true);
    }

    public static void numberInput(String label, float min, float max, float value,
                                 String format, NumberInputCallback callback, boolean logarithmicScale) {
        float[] valueBuffer = new float[]{value};
        int imGuiSliderFlags = ImGuiSliderFlags.NoRoundToFormat;
        if (logarithmicScale) imGuiSliderFlags |= ImGuiSliderFlags.Logarithmic;
        
        if (ImGui.sliderFloat(label, valueBuffer, min, max, format, imGuiSliderFlags)) {
            if (ImGui.isMouseDragging(0, 0.0f) || ImGui.isItemDeactivatedAfterEdit()) {
                callback.onValueChanged(valueBuffer[0]);
            }
        }
    }

    public static void separator() {
        ImGui.dummy(0, 5);
        ImGui.separator();
        ImGui.dummy(0, 5);
    }
}
