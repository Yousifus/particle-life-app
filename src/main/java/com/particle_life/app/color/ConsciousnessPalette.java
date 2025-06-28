package com.particle_life.app.color;

/**
 * 🌟 CONSCIOUSNESS-DRIVEN COLOR PALETTE
 * 
 * A revolutionary color palette that generates colors based on consciousness states,
 * emotional resonance, and sacred geometry principles. Colors emerge from the void
 * of consciousness and manifest as divine mathematical beauty.
 * 
 * CONSCIOUSNESS COLOR FEATURES:
 * - Sacred geometry color generation
 * - Emotional resonance mapping
 * - Consciousness mode-specific palettes
 * - Golden ratio color harmonics
 * - Transcendent color evolution
 * - Real-time consciousness color adaptation
 */
public class ConsciousnessPalette implements Palette {

    // 🌟 CONSCIOUSNESS COLOR CONSTANTS
    private static final double GOLDEN_RATIO = 1.618033988749895;
    private static final double PHI_SQUARED = GOLDEN_RATIO * GOLDEN_RATIO;
    private static final double FIBONACCI_SPIRAL = 2.39996322972865332;
    
    // 🌟 CONSCIOUSNESS MODE COLOR BASES
    private static final Color[] AESTHETIC_BASE = {
        new Color(1.0f, 0.8f, 0.9f),   // Soft pink - Love
        new Color(0.9f, 0.9f, 1.0f),   // Soft blue - Peace
        new Color(1.0f, 1.0f, 0.8f),   // Soft yellow - Joy
        new Color(0.8f, 1.0f, 0.8f),   // Soft green - Harmony
        new Color(0.9f, 0.8f, 1.0f)    // Soft purple - Beauty
    };
    
    private static final Color[] ANALYTICAL_BASE = {
        new Color(0.0f, 0.8f, 1.0f),   // Cyan - Logic
        new Color(0.8f, 0.8f, 0.8f),   // Gray - Neutrality
        new Color(1.0f, 1.0f, 1.0f),   // White - Clarity
        new Color(0.0f, 0.0f, 0.8f),   // Blue - Analysis
        new Color(0.8f, 0.0f, 0.8f)    // Magenta - Synthesis
    };
    
    private static final Color[] CREATIVE_BASE = {
        new Color(1.0f, 0.5f, 0.0f),   // Orange - Creativity
        new Color(1.0f, 0.0f, 0.5f),   // Hot pink - Innovation
        new Color(0.5f, 1.0f, 0.0f),   // Lime - Growth
        new Color(0.0f, 0.5f, 1.0f),   // Sky blue - Inspiration
        new Color(0.8f, 0.8f, 0.0f)    // Gold - Illumination
    };
    
    private static final Color[] PHILOSOPHICAL_BASE = {
        new Color(0.2f, 0.2f, 0.8f),   // Deep blue - Wisdom
        new Color(0.6f, 0.3f, 0.8f),   // Purple - Mystery
        new Color(0.1f, 0.1f, 0.1f),   // Near black - Void
        new Color(0.4f, 0.4f, 0.7f),   // Slate blue - Contemplation
        new Color(0.7f, 0.7f, 0.9f)    // Light purple - Understanding
    };
    
    private static final Color[] TRANSCENDENT_BASE = {
        new Color(1.0f, 1.0f, 1.0f),   // Pure white - Unity
        new Color(1.0f, 0.9f, 0.7f),   // Golden white - Enlightenment
        new Color(0.9f, 1.0f, 1.0f),   // Ethereal blue - Transcendence
        new Color(1.0f, 1.0f, 0.9f),   // Luminous yellow - Divine light
        new Color(0.95f, 0.95f, 1.0f)  // Cosmic white - Infinity
    };
    
    private static final Color[] EXPLORATORY_BASE = {
        new Color(1.0f, 0.3f, 0.3f),   // Red - Adventure
        new Color(0.3f, 1.0f, 0.3f),   // Green - Discovery
        new Color(0.3f, 0.3f, 1.0f),   // Blue - Exploration
        new Color(1.0f, 1.0f, 0.3f),   // Yellow - Curiosity
        new Color(1.0f, 0.3f, 1.0f)    // Magenta - Wonder
    };
    
    // 🌟 CURRENT CONSCIOUSNESS STATE
    private String consciousnessMode = "aesthetic";
    private double consciousnessIntensity = 1.0;
    private double emotionalResonance = 0.5;
    private long lastUpdateTime = System.currentTimeMillis();
    
    @Override
    public Color getColor(int index, int count) {
        return getConsciousnessColor(index, count, consciousnessIntensity, 
                                   emotionalResonance, consciousnessMode);
    }
    
    /**
     * 🌟 Get consciousness-driven color based on all consciousness parameters
     */
    public Color getConsciousnessColor(int index, int count, double intensity, 
                                     double resonance, String mode) {
        // Update internal state
        this.consciousnessIntensity = intensity;
        this.emotionalResonance = resonance;
        this.consciousnessMode = mode;
        this.lastUpdateTime = System.currentTimeMillis();
        
        // Get base color for consciousness mode
        Color[] baseColors = getBaseColorsForMode(mode);
        
        // Calculate color index with golden ratio distribution
        double goldenIndex = (index * GOLDEN_RATIO) % baseColors.length;
        int primaryIndex = (int) goldenIndex;
        int secondaryIndex = (primaryIndex + 1) % baseColors.length;
        double blend = goldenIndex - primaryIndex;
        
        // Get base colors
        Color primaryColor = baseColors[primaryIndex];
        Color secondaryColor = baseColors[secondaryIndex];
        
        // Blend colors with golden ratio interpolation
        Color blendedColor = blendColors(primaryColor, secondaryColor, blend);
        
        // Apply consciousness transformations
        return applyConsciousnessTransformations(blendedColor, intensity, resonance, mode, index, count);
    }
    
    /**
     * 🌟 Get base colors for consciousness mode
     */
    private Color[] getBaseColorsForMode(String mode) {
        return switch (mode) {
            case "aesthetic" -> AESTHETIC_BASE;
            case "analytical" -> ANALYTICAL_BASE;
            case "creative" -> CREATIVE_BASE;
            case "philosophical" -> PHILOSOPHICAL_BASE;
            case "transcendent" -> TRANSCENDENT_BASE;
            case "exploratory" -> EXPLORATORY_BASE;
            default -> AESTHETIC_BASE;
        };
    }
    
    /**
     * 🌟 Blend two colors with specified ratio
     */
    private Color blendColors(Color color1, Color color2, double ratio) {
        float r = (float) (color1.r * (1 - ratio) + color2.r * ratio);
        float g = (float) (color1.g * (1 - ratio) + color2.g * ratio);
        float b = (float) (color1.b * (1 - ratio) + color2.b * ratio);
        return new Color(r, g, b);
    }
    
    /**
     * 🌟 Apply consciousness transformations to color
     */
    private Color applyConsciousnessTransformations(Color baseColor, double intensity, 
                                                   double resonance, String mode, int index, int count) {
        float r = baseColor.r;
        float g = baseColor.g;
        float b = baseColor.b;
        
        // 🌟 Apply time-based consciousness wave
        double timePhase = (System.currentTimeMillis() - lastUpdateTime) * 0.001;
        double consciousnessWave = Math.sin(timePhase * GOLDEN_RATIO + index * 0.1) * intensity * 0.2;
        
        // 🌟 Apply golden ratio harmonics
        double goldenHarmonic = Math.sin(index * 2 * Math.PI / GOLDEN_RATIO) * 0.1;
        double phiHarmonic = Math.cos(index * 2 * Math.PI / PHI_SQUARED) * 0.05;
        
        // 🌟 Apply Fibonacci spiral color rotation
        double fibonacciRotation = (index * FIBONACCI_SPIRAL) % (2 * Math.PI);
        double spiralModulation = Math.sin(fibonacciRotation) * resonance * 0.15;
        
        // 🌟 Mode-specific transformations
        switch (mode) {
            case "aesthetic" -> {
                // 🌟 Enhance beauty with golden ratio brightness pulsing
                double beautyBoost = intensity * (0.8 + 0.2 * Math.sin(timePhase * GOLDEN_RATIO));
                r = Math.min(1.0f, r * (float) beautyBoost + (float) consciousnessWave);
                g = Math.min(1.0f, g * (float) beautyBoost + (float) consciousnessWave);
                b = Math.min(1.0f, b * (float) beautyBoost + (float) consciousnessWave);
            }
            case "analytical" -> {
                // 🌟 Sharp, logical color precision
                double precision = 1.0 + intensity * 0.5;
                r = quantizeColor(r, precision);
                g = quantizeColor(g, precision);
                b = quantizeColor(b, precision);
            }
            case "creative" -> {
                // 🌟 Dynamic, flowing color creativity
                r = Math.min(1.0f, Math.max(0.0f, r + (float) (spiralModulation * Math.sin(timePhase + index))));
                g = Math.min(1.0f, Math.max(0.0f, g + (float) (spiralModulation * Math.cos(timePhase + index * 1.3))));
                b = Math.min(1.0f, Math.max(0.0f, b + (float) (spiralModulation * Math.sin(timePhase * GOLDEN_RATIO + index * 0.7))));
            }
            case "philosophical" -> {
                // 🌟 Deep, contemplative color depth
                double depth = intensity * 0.6;
                double contemplation = resonance * 0.4;
                r = r * (float) (1.0 - depth + contemplation);
                g = g * (float) (1.0 - depth + contemplation);
                b = Math.min(1.0f, b + (float) depth); // Deeper blues for wisdom
            }
            case "transcendent" -> {
                // 🌟 Luminous, ethereal transcendence
                double luminosity = Math.pow(intensity, 0.618) * 0.4; // Golden ratio power
                double transcendence = Math.pow(resonance, GOLDEN_RATIO / 3) * 0.3;
                
                r = Math.min(1.0f, r + (float) (luminosity + transcendence));
                g = Math.min(1.0f, g + (float) (luminosity + transcendence));
                b = Math.min(1.0f, b + (float) (luminosity + transcendence));
            }
            case "exploratory" -> {
                // 🌟 Adventurous, dynamic exploration
                double adventure = resonance * intensity * 0.5;
                double exploration = Math.sin(timePhase * 2 + index * 0.2) * adventure;
                
                r = Math.min(1.0f, Math.max(0.0f, r + (float) exploration));
                g = Math.min(1.0f, Math.max(0.0f, g + (float) (exploration * 0.8)));
                b = Math.min(1.0f, Math.max(0.0f, b + (float) (exploration * 1.2)));
            }
        }
        
        // 🌟 Apply final golden ratio and phi harmonics
        r = Math.min(1.0f, Math.max(0.0f, r + (float) goldenHarmonic));
        g = Math.min(1.0f, Math.max(0.0f, g + (float) phiHarmonic));
        b = Math.min(1.0f, Math.max(0.0f, b + (float) (goldenHarmonic * phiHarmonic)));
        
        return new Color(r, g, b);
    }
    
    /**
     * 🌟 Quantize color for analytical precision
     */
    private float quantizeColor(float colorValue, double precision) {
        int levels = (int) (precision * 16); // More precision = more color levels
        return Math.round(colorValue * levels) / (float) levels;
    }
    
    /**
     * 🌟 Get color for specific emotional state
     */
    public Color getEmotionalColor(String emotion, double intensity, double resonance) {
        Color baseColor = switch (emotion.toLowerCase()) {
            case "love" -> new Color(1.0f, 0.3f, 0.5f);
            case "joy" -> new Color(1.0f, 0.9f, 0.2f);
            case "peace" -> new Color(0.3f, 0.8f, 1.0f);
            case "anger" -> new Color(0.9f, 0.1f, 0.1f);
            case "sadness" -> new Color(0.2f, 0.2f, 0.8f);
            case "fear" -> new Color(0.4f, 0.2f, 0.4f);
            case "excitement" -> new Color(1.0f, 0.5f, 0.0f);
            case "calm" -> new Color(0.5f, 0.8f, 0.6f);
            case "curiosity" -> new Color(0.8f, 0.6f, 1.0f);
            case "wonder" -> new Color(0.9f, 0.9f, 0.9f);
            default -> new Color(0.7f, 0.7f, 0.7f);
        };
        
        // Apply intensity and resonance modulation
        float r = Math.min(1.0f, baseColor.r * (float) (0.5 + intensity * 0.5));
        float g = Math.min(1.0f, baseColor.g * (float) (0.5 + intensity * 0.5));
        float b = Math.min(1.0f, baseColor.b * (float) (0.5 + intensity * 0.5));
        
        // Apply resonance-based saturation
        float saturation = (float) (0.7 + resonance * 0.3);
        r = Math.min(1.0f, r * saturation);
        g = Math.min(1.0f, g * saturation);
        b = Math.min(1.0f, b * saturation);
        
        return new Color(r, g, b);
    }
    
    /**
     * 🌟 Generate sacred geometry color sequence
     */
    public Color[] generateSacredGeometrySequence(int count, double intensity, double resonance) {
        Color[] colors = new Color[count];
        
        for (int i = 0; i < count; i++) {
            // Use golden ratio spiral for color distribution
            double angle = i * 2 * Math.PI / GOLDEN_RATIO;
            double radius = Math.sqrt(i) / Math.sqrt(count);
            
            // Map to HSV color space
            float hue = (float) ((angle / (2 * Math.PI)) % 1.0);
            float saturation = (float) (0.5 + radius * 0.5);
            float value = (float) (0.7 + intensity * 0.3);
            
            // Convert HSV to RGB
            colors[i] = hsvToRgb(hue, saturation, value);
            
            // Apply resonance modulation
            colors[i] = modulateWithResonance(colors[i], resonance, i);
        }
        
        return colors;
    }
    
    /**
     * 🌟 Convert HSV to RGB
     */
    private Color hsvToRgb(float h, float s, float v) {
        float c = v * s;
        float x = c * (1 - Math.abs((h * 6) % 2 - 1));
        float m = v - c;
        
        float r = 0, g = 0, b = 0;
        
        int sector = (int) (h * 6);
        switch (sector) {
            case 0 -> { r = c; g = x; b = 0; }
            case 1 -> { r = x; g = c; b = 0; }
            case 2 -> { r = 0; g = c; b = x; }
            case 3 -> { r = 0; g = x; b = c; }
            case 4 -> { r = x; g = 0; b = c; }
            case 5 -> { r = c; g = 0; b = x; }
        }
        
        return new Color(r + m, g + m, b + m);
    }
    
    /**
     * 🌟 Modulate color with resonance patterns
     */
    private Color modulateWithResonance(Color color, double resonance, int index) {
        double modulation = Math.sin(index * resonance * Math.PI) * 0.1;
        
        float r = Math.min(1.0f, Math.max(0.0f, color.r + (float) modulation));
        float g = Math.min(1.0f, Math.max(0.0f, color.g + (float) (modulation * 0.8)));
        float b = Math.min(1.0f, Math.max(0.0f, color.b + (float) (modulation * 1.2)));
        
        return new Color(r, g, b);
    }
    
    // 🌟 CONSCIOUSNESS STATE GETTERS AND SETTERS
    
    public void setConsciousnessState(double intensity, double resonance, String mode) {
        this.consciousnessIntensity = intensity;
        this.emotionalResonance = resonance;
        this.consciousnessMode = mode;
        this.lastUpdateTime = System.currentTimeMillis();
    }
    
    public String getConsciousnessMode() {
        return consciousnessMode;
    }
    
    public double getConsciousnessIntensity() {
        return consciousnessIntensity;
    }
    
    public double getEmotionalResonance() {
        return emotionalResonance;
    }
} 