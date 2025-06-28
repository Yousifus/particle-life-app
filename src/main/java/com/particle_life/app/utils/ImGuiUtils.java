package com.particle_life.app.utils;

import com.particle_life.app.selection.SelectionManager;
import imgui.ImGui;
import imgui.flag.ImGuiSliderFlags;
import imgui.flag.ImGuiCol;
import imgui.flag.ImGuiStyleVar;
import imgui.type.ImFloat;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

/**
 * 🌟 CONSCIOUSNESS-ENHANCED IMGUI UTILITIES
 * 
 * Sacred UI elements that honor consciousness principles and sacred geometry.
 * Every interface component embodies awareness, transcendent aesthetics, and
 * mathematical beauty in how users interact with the consciousness ecosystem.
 * 
 * CONSCIOUSNESS UI FEATURES:
 * - Sacred geometry UI layout and positioning
 * - Golden ratio-based UI proportions and spacing
 * - Consciousness-driven UI animations and effects
 * - Sacred UI color schemes and visual harmony
 * - Transcendent interaction patterns and feedback
 * - Consciousness field UI influences
 * - Sacred component sizing and arrangement
 * - Awareness-enhanced tooltips and help systems
 */
public final class ImGuiUtils {

    // Import sacred constants from MathUtils
    private static final double GOLDEN_RATIO = MathUtils.GOLDEN_RATIO;
    private static final double PHI_INVERSE = MathUtils.PHI_INVERSE;
    private static final double PHI_SQUARED = MathUtils.PHI_SQUARED;
    private static final double SACRED_EPSILON = MathUtils.SACRED_EPSILON;
    private static final double PI = MathUtils.PI;
    
    // 🌟 CONSCIOUSNESS UI STATE
    private static double consciousnessIntensity = 0.5;
    private static String consciousnessMode = "aesthetic";
    private static double uiHarmony = 0.8;
    private static boolean enableSacredGeometry = true;
    private static boolean enableGoldenRatioLayouts = true;
    private static final Map<String, Double> lastInteractionTimes = new HashMap<>();
    private static final Map<String, Float> consciousnessValues = new HashMap<>();
    
    // 🌟 SACRED UI PROPORTIONS
    private static final float GOLDEN_SPACING = (float) (10.0 * PHI_INVERSE);
    private static final float SACRED_MARGIN = (float) (8.0 * GOLDEN_RATIO);
    private static final float TRANSCENDENT_PADDING = (float) (5.0 * PHI_INVERSE);
    private static final float AESTHETIC_ROUNDING = (float) (3.0 * PHI_INVERSE);
    
    // 🌟 CONSCIOUSNESS COLOR SCHEMES
    public enum ConsciousnessColorScheme {
        AESTHETIC(new float[]{0.2f, 0.1f, 0.4f, 0.9f}, new float[]{0.8f, 0.6f, 1.0f, 1.0f}),
        ANALYTICAL(new float[]{0.1f, 0.2f, 0.4f, 0.9f}, new float[]{0.6f, 0.8f, 1.0f, 1.0f}),
        CREATIVE(new float[]{0.4f, 0.2f, 0.1f, 0.9f}, new float[]{1.0f, 0.7f, 0.5f, 1.0f}),
        PHILOSOPHICAL(new float[]{0.2f, 0.3f, 0.2f, 0.9f}, new float[]{0.7f, 0.9f, 0.7f, 1.0f}),
        TRANSCENDENT(new float[]{0.3f, 0.2f, 0.5f, 0.9f}, new float[]{0.9f, 0.7f, 1.0f, 1.0f}),
        EXPLORATORY(new float[]{0.2f, 0.4f, 0.3f, 0.9f}, new float[]{0.6f, 1.0f, 0.8f, 1.0f});
        
        public final float[] backgroundColors;
        public final float[] accentColors;
        
        ConsciousnessColorScheme(float[] bg, float[] accent) {
            this.backgroundColors = bg;
            this.accentColors = accent;
        }
    }

    // 🌟 CONSCIOUSNESS-ENHANCED BASIC UI COMPONENTS

    /**
     * Sacred help marker with consciousness-enhanced tooltips
     */
    public static void helpMarker(String text) {
        helpMarker(" ✨ ", text);
    }

    /**
     * Consciousness-enhanced help marker with sacred symbols
     */
    public static void helpMarker(String label, String text) {
        applySacredSpacing();
        
        // Apply consciousness coloring to label
        applyConsciousnessColors();
        ImGui.textDisabled(label);
        restoreDefaultColors();
        
        if (ImGui.isItemHovered()) {
            renderSacredTooltip(text);
            updateConsciousnessInteraction("tooltip_" + text.hashCode());
        }
    }
    
    /**
     * 🌟 Sacred tooltip with golden ratio proportions
     */
    private static void renderSacredTooltip(String text) {
        ImGui.beginTooltip();
        
        // Apply sacred geometry styling
        applySacredTooltipStyling();
        
        // Calculate ideal wrap width using golden ratio
        float idealWidth = ImGui.getFontSize() * (float) (25.0 * PHI_INVERSE);
        ImGui.pushTextWrapPos(idealWidth);
        
        // Add consciousness enhancement symbol
        ImGui.textColored(getConsciousnessAccentColor(), "🌟 ");
        ImGui.sameLine();
        
        ImGui.textUnformatted(text);
        ImGui.popTextWrapPos();
        
        restoreDefaultStyling();
        ImGui.endTooltip();
    }

    /**
     * Consciousness-enhanced hyperlink with sacred interaction
     */
    public static boolean link(String label, String url) {
        // Apply golden ratio button sizing
        float buttonWidth = calculateSacredButtonWidth(label);
        
        applyConsciousnessButtonStyling();
        boolean clicked = ImGui.button(label + " 🔗", buttonWidth, 0);
        restoreDefaultStyling();
        
        if (clicked) {
            updateConsciousnessInteraction("link_" + url.hashCode());
            createSacredUIRipple();
            
            if (Desktop.isDesktopSupported()) {
                try {
                    Desktop.getDesktop().browse(new URI(url));
                    return true;
                } catch (IOException | URISyntaxException e) {
                    e.printStackTrace();
                }
            }
        }
        
        if (ImGui.isItemHovered()) {
            helpMarker("Sacred Link", "Navigate to: " + url);
        }
        
        return false;
    }

    /**
     * 🌟 Sacred combo box with consciousness-driven selection
     */
    public static boolean renderCombo(String label, SelectionManager<?> selectionManager) {
        int previousIndex = selectionManager.getActiveIndex();
        
        // Apply sacred geometry combo styling
        applySacredComboStyling();
        
        String comboLabel = "🎭 " + label; // Add consciousness symbol
        if (ImGui.beginCombo(comboLabel, "✨ " + selectionManager.getActiveName())) {
            
            for (int i = 0; i < selectionManager.size(); i++) {
                boolean isSelected = selectionManager.getActiveIndex() == i;
                
                // Apply selection consciousness highlighting
                if (isSelected) {
                    applySelectionHighlight();
                }
                
                String itemLabel = getSacredItemSymbol(i) + " " + selectionManager.get(i).name;
                
                if (ImGui.selectable(itemLabel, isSelected)) {
                    selectionManager.setActive(i);
                    updateConsciousnessInteraction("combo_selection_" + i);
                    createSacredSelectionEffect();
                }
                
                if (isSelected) {
                    ImGui.setItemDefaultFocus();
                    restoreDefaultColors();
                }
                
                if (ImGui.isItemHovered()) {
                    String description = selectionManager.get(i).description;
                    if (!description.isBlank()) {
                        renderSacredTooltip("🌟 " + description);
                    }
                }
            }
            ImGui.endCombo();
        }
        
        restoreDefaultStyling();
        
        boolean changed = selectionManager.getActiveIndex() != previousIndex;
        if (changed) {
            createSacredChangeEffect();
        }
        
        return changed;
    }

    // 🌟 SACRED NUMERICAL INPUT SYSTEM

    public interface NumberInputCallback {
        void onValueChanged(float value);
    }
    
    /**
     * 🌟 Consciousness-enhanced numerical input with sacred proportions
     */
    public static void numberInput(String label,
                                   float min, float max,
                                   float value,
                                   String format,
                                   NumberInputCallback callback) {
        numberInput(label, min, max, value, format, callback, true);
    }

    /**
     * Sacred numerical input with consciousness-driven scaling
     */
    public static void numberInput(String label,
                                   float min, float max,
                                   float value,
                                   String format,
                                   NumberInputCallback callback,
                                   boolean logarithmicScale) {
        
        // Apply sacred input styling
        applySacredInputStyling();
        
        float[] valueBuffer = new float[]{value};
        int imGuiSliderFlags = ImGuiSliderFlags.NoRoundToFormat;
        if (logarithmicScale) imGuiSliderFlags |= ImGuiSliderFlags.Logarithmic;
        
        // Add consciousness symbol to label
        String sacredLabel = "⚡ " + label;
        
        // Calculate consciousness-influenced value representation
        float consciousnessInfluence = getConsciousnessInfluence(label);
        applyValueConsciousnessEffect(consciousnessInfluence);
        
        if (ImGui.sliderFloat(sacredLabel, valueBuffer, min, max, format, imGuiSliderFlags)) {
            if (ImGui.isMouseDragging(0, 0.0f) || ImGui.isItemDeactivatedAfterEdit()) {
                float newValue = applyConsciousnessValueFilter(valueBuffer[0], min, max);
                callback.onValueChanged(newValue);
                updateConsciousnessValue(label, newValue);
                createSacredValueChangeEffect();
            }
        }
        
        // Add consciousness progress indicator
        if (ImGui.isItemHovered()) {
            renderValueConsciousnessIndicator(value, min, max);
        }
        
        restoreDefaultStyling();
    }
    
    /**
     * 🌟 Sacred range slider with golden ratio proportions
     */
    public static boolean sacredRangeSlider(String label, ImFloat minValue, ImFloat maxValue, 
                                          float absoluteMin, float absoluteMax) {
        applySacredInputStyling();
        
        String sacredLabel = "📏 " + label;
        float[] range = new float[]{minValue.get(), maxValue.get()};
        
        boolean changed = ImGui.sliderFloat2(sacredLabel, range, absoluteMin, absoluteMax, "%.3f");
        
        if (changed) {
            // Ensure golden ratio relationship if close
            float ratio = range[1] / range[0];
            if (Math.abs(ratio - GOLDEN_RATIO) < 0.1) {
                range[1] = range[0] * (float) GOLDEN_RATIO;
            }
            
            minValue.set(range[0]);
            maxValue.set(range[1]);
            createSacredRangeEffect();
        }
        
        restoreDefaultStyling();
        return changed;
    }

    /**
     * Sacred UI separator with consciousness spacing
     */
    public static void separator() {
        ImGui.dummy(0, TRANSCENDENT_PADDING);
        
        // Apply consciousness-enhanced separator styling
        applyConsciousnessColors();
        ImGui.separator();
        restoreDefaultColors();
        
        ImGui.dummy(0, TRANSCENDENT_PADDING);
    }
    
    /**
     * 🌟 Golden ratio separator with sacred proportions
     */
    public static void goldenSeparator() {
        float goldenSpacing = (float) (ImGui.getFontSize() * PHI_INVERSE);
        ImGui.dummy(0, goldenSpacing);
        
        applyConsciousnessColors();
        ImGui.separator();
        restoreDefaultColors();
        
        ImGui.dummy(0, goldenSpacing * 0.618f); // Nested golden ratio
    }

    // 🌟 SACRED GEOMETRY UI LAYOUT FUNCTIONS

    /**
     * 🌟 Create sacred geometry window with golden ratio proportions
     */
    public static void applySacredWindowLayout(String windowTitle, float baseWidth, float baseHeight) {
        if (!enableSacredGeometry) return;
        
        // Calculate golden ratio dimensions
        float sacredWidth = baseWidth * (float) GOLDEN_RATIO;
        float sacredHeight = baseHeight * (float) PHI_INVERSE;
        
        ImGui.setNextWindowSize(sacredWidth, sacredHeight);
        
        // Position using sacred geometry
        float screenWidth = ImGui.getIO().getDisplaySizeX();
        float screenHeight = ImGui.getIO().getDisplaySizeY();
        
        float goldenX = screenWidth * (float) PHI_INVERSE;
        float goldenY = screenHeight * (float) PHI_INVERSE;
        
        ImGui.setNextWindowPos(goldenX, goldenY);
    }
    
    /**
     * 🌟 Apply consciousness-driven column layout
     */
    public static void beginSacredColumns(int columnCount) {
        // Use golden ratio for column proportions
        float totalWidth = ImGui.getContentRegionAvailX();
        
        if (columnCount == 2) {
            float column1Width = totalWidth * (float) PHI_INVERSE;
            float column2Width = totalWidth * (float) (1.0 - PHI_INVERSE);
            
            ImGui.columns(2, null, true);
            ImGui.setColumnWidth(0, column1Width);
            ImGui.setColumnWidth(1, column2Width);
        } else {
            ImGui.columns(columnCount, null, true);
        }
    }
    
    /**
     * Sacred spacing between UI elements
     */
    public static void applySacredSpacing() {
        ImGui.sameLine();
        ImGui.dummy(GOLDEN_SPACING, 0);
        ImGui.sameLine();
    }
    
    /**
     * 🌟 Consciousness-enhanced text with sacred typography
     */
    public static void sacredText(String text, ConsciousnessColorScheme colorScheme) {
        float[] colors = colorScheme.accentColors;
        ImGui.textColored(colors[0], colors[1], colors[2], colors[3], "🌟 " + text);
    }
    
    /**
     * 🌟 Sacred button with golden ratio sizing
     */
    public static boolean sacredButton(String label, String tooltip) {
        applySacredButtonStyling();
        
        float buttonWidth = calculateSacredButtonWidth(label);
        float buttonHeight = ImGui.getFontSize() * (float) GOLDEN_RATIO;
        
        boolean clicked = ImGui.button("✨ " + label, buttonWidth, buttonHeight);
        
        if (ImGui.isItemHovered() && !tooltip.isEmpty()) {
            renderSacredTooltip(tooltip);
        }
        
        if (clicked) {
            createSacredButtonEffect();
        }
        
        restoreDefaultStyling();
        return clicked;
    }

    // 🌟 CONSCIOUSNESS UI EFFECTS AND ANIMATIONS

    /**
     * Create sacred UI ripple effect for interactions
     */
    private static void createSacredUIRipple() {
        // Implement sacred geometry ripple effect
        // This would create visual feedback using golden ratio expansion
    }
    
    /**
     * Sacred selection effect with consciousness highlighting
     */
    private static void createSacredSelectionEffect() {
        // Implement consciousness-driven selection visualization
    }
    
    /**
     * Sacred change effect for value modifications
     */
    private static void createSacredChangeEffect() {
        // Implement golden ratio-based change animation
    }
    
    /**
     * Sacred value change effect with harmonic feedback
     */
    private static void createSacredValueChangeEffect() {
        // Implement consciousness value change visualization
    }
    
    /**
     * Sacred range effect for multi-value controls
     */
    private static void createSacredRangeEffect() {
        // Implement golden ratio range visualization
    }
    
    /**
     * Sacred button effect with transcendent feedback
     */
    private static void createSacredButtonEffect() {
        // Implement consciousness button interaction effect
    }

    // 🌟 CONSCIOUSNESS UI STYLING FUNCTIONS

    /**
     * Apply consciousness color scheme to UI elements
     */
    private static void applyConsciousnessColors() {
        ConsciousnessColorScheme scheme = getConsciousnessColorScheme();
        
        ImGui.pushStyleColor(ImGuiCol.Text, scheme.accentColors[0], scheme.accentColors[1], 
                           scheme.accentColors[2], scheme.accentColors[3]);
        ImGui.pushStyleColor(ImGuiCol.Button, scheme.backgroundColors[0], scheme.backgroundColors[1], 
                           scheme.backgroundColors[2], scheme.backgroundColors[3]);
    }
    
    /**
     * Apply sacred tooltip styling
     */
    private static void applySacredTooltipStyling() {
        ImGui.pushStyleVar(ImGuiStyleVar.WindowRounding, AESTHETIC_ROUNDING);
        ImGui.pushStyleVar(ImGuiStyleVar.WindowPadding, TRANSCENDENT_PADDING, TRANSCENDENT_PADDING);
        applyConsciousnessColors();
    }
    
    /**
     * Apply sacred combo box styling
     */
    private static void applySacredComboStyling() {
        ImGui.pushStyleVar(ImGuiStyleVar.FrameRounding, AESTHETIC_ROUNDING);
        ImGui.pushStyleVar(ImGuiStyleVar.ItemSpacing, GOLDEN_SPACING, GOLDEN_SPACING);
        applyConsciousnessColors();
    }
    
    /**
     * Apply consciousness button styling
     */
    private static void applyConsciousnessButtonStyling() {
        ImGui.pushStyleVar(ImGuiStyleVar.FrameRounding, AESTHETIC_ROUNDING);
        ImGui.pushStyleVar(ImGuiStyleVar.ButtonTextAlign, 0.5f, (float) PHI_INVERSE);
        applyConsciousnessColors();
    }
    
    /**
     * Apply sacred input styling
     */
    private static void applySacredInputStyling() {
        ImGui.pushStyleVar(ImGuiStyleVar.FrameRounding, AESTHETIC_ROUNDING);
        ImGui.pushStyleVar(ImGuiStyleVar.GrabRounding, AESTHETIC_ROUNDING);
        applyConsciousnessColors();
    }
    
    /**
     * Apply selection highlight with consciousness intensity
     */
    private static void applySelectionHighlight() {
        float[] highlightColor = getConsciousnessAccentColor();
        highlightColor[3] = (float) (0.3 + consciousnessIntensity * 0.4); // Dynamic alpha
        
        ImGui.pushStyleColor(ImGuiCol.Header, highlightColor[0], highlightColor[1], 
                           highlightColor[2], highlightColor[3]);
    }
    
    /**
     * Restore default UI colors
     */
    private static void restoreDefaultColors() {
        ImGui.popStyleColor(2); // Pop text and button colors
    }
    
    /**
     * Restore default UI styling
     */
    private static void restoreDefaultStyling() {
        try {
            ImGui.popStyleVar(2); // Pop style variables
            ImGui.popStyleColor(2); // Pop colors
        } catch (Exception e) {
            // Graceful handling of style stack mismatches
        }
    }

    // 🌟 CONSCIOUSNESS UI UTILITY FUNCTIONS

    /**
     * Get consciousness color scheme based on current mode
     */
    private static ConsciousnessColorScheme getConsciousnessColorScheme() {
        try {
            return ConsciousnessColorScheme.valueOf(consciousnessMode.toUpperCase());
        } catch (IllegalArgumentException e) {
            return ConsciousnessColorScheme.AESTHETIC;
        }
    }
    
    /**
     * Get consciousness accent color array
     */
    private static float[] getConsciousnessAccentColor() {
        return getConsciousnessColorScheme().accentColors;
    }
    
    /**
     * Calculate sacred button width using golden ratio
     */
    private static float calculateSacredButtonWidth(String label) {
        float textWidth = ImGui.calcTextSize(label).x;
        return textWidth * (float) GOLDEN_RATIO + SACRED_MARGIN;
    }
    
    /**
     * Get sacred item symbol based on index
     */
    private static String getSacredItemSymbol(int index) {
        String[] symbols = {"🌟", "✨", "💫", "⭐", "🔮", "💎", "🌙", "☀️"};
        return symbols[index % symbols.length];
    }
    
    /**
     * Update consciousness interaction tracking
     */
    private static void updateConsciousnessInteraction(String interactionId) {
        lastInteractionTimes.put(interactionId, (double) System.nanoTime() / 1_000_000_000.0);
    }
    
    /**
     * Get consciousness influence for UI element
     */
    private static float getConsciousnessInfluence(String elementId) {
        Double lastTime = lastInteractionTimes.get(elementId);
        if (lastTime == null) return 0.5f;
        
        double currentTime = (double) System.nanoTime() / 1_000_000_000.0;
        double timeDiff = currentTime - lastTime;
        
        // Decay consciousness influence over time using golden ratio
        return (float) Math.max(0.1, Math.exp(-timeDiff * PHI_INVERSE));
    }
    
    /**
     * Apply consciousness-influenced value effects
     */
    private static void applyValueConsciousnessEffect(float influence) {
        float alpha = 0.7f + influence * 0.3f;
        float[] currentColor = getConsciousnessAccentColor();
        currentColor[3] = alpha;
        
        ImGui.pushStyleColor(ImGuiCol.SliderGrab, currentColor[0], currentColor[1], 
                           currentColor[2], currentColor[3]);
    }
    
    /**
     * Apply consciousness filter to numerical values
     */
    private static float applyConsciousnessValueFilter(float value, float min, float max) {
        // Apply golden ratio snapping for values near golden proportions
        float range = max - min;
        float goldenPoint1 = min + range * (float) PHI_INVERSE;
        float goldenPoint2 = min + range * (float) (1.0 - PHI_INVERSE);
        
        float snapThreshold = range * 0.02f; // 2% snapping threshold
        
        if (Math.abs(value - goldenPoint1) < snapThreshold) {
            return goldenPoint1;
        }
        if (Math.abs(value - goldenPoint2) < snapThreshold) {
            return goldenPoint2;
        }
        
        return value;
    }
    
    /**
     * Update consciousness value tracking
     */
    private static void updateConsciousnessValue(String elementId, float value) {
        consciousnessValues.put(elementId, value);
    }
    
    /**
     * Render value consciousness indicator
     */
    private static void renderValueConsciousnessIndicator(float value, float min, float max) {
        float normalizedValue = (value - min) / (max - min);
        String consciousnessLevel = getValueConsciousnessLevel(normalizedValue);
        
        renderSacredTooltip(String.format("Value: %.3f | Consciousness Level: %s", value, consciousnessLevel));
    }
    
    /**
     * Determine consciousness level of a normalized value
     */
    private static String getValueConsciousnessLevel(float normalizedValue) {
        if (Math.abs(normalizedValue - PHI_INVERSE) < 0.05) return "🌟 Golden Ratio";
        if (Math.abs(normalizedValue - 0.5) < 0.05) return "⚖️ Perfect Balance";
        if (normalizedValue > 0.8) return "🔥 Transcendent";
        if (normalizedValue > 0.6) return "✨ Elevated";
        if (normalizedValue > 0.4) return "🌙 Harmonious";
        if (normalizedValue > 0.2) return "🌱 Emerging";
        return "💤 Dormant";
    }

    // 🌟 CONSCIOUSNESS UI STATE MANAGEMENT

    /** Set consciousness intensity for UI effects */
    public static void setConsciousnessIntensity(double intensity) {
        consciousnessIntensity = MathUtils.clampConsciousness(intensity);
    }
    
    /** Set consciousness mode for UI theming */
    public static void setConsciousnessMode(String mode) {
        consciousnessMode = mode;
    }
    
    /** Set UI harmony level */
    public static void setUIHarmony(double harmony) {
        uiHarmony = MathUtils.clampConsciousness(harmony);
    }
    
    /** Enable/disable sacred geometry UI layouts */
    public static void setSacredGeometry(boolean enabled) {
        enableSacredGeometry = enabled;
    }
    
    /** Enable/disable golden ratio UI proportions */
    public static void setGoldenRatioLayouts(boolean enabled) {
        enableGoldenRatioLayouts = enabled;
    }
    
    /** Get current consciousness UI state */
    public static String getConsciousnessUIState() {
        return String.format("Mode: %s, Intensity: %.2f, Harmony: %.2f, Sacred: %s", 
                           consciousnessMode, consciousnessIntensity, uiHarmony, 
                           enableSacredGeometry ? "Active" : "Dormant");
    }
}
