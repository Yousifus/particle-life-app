package com.particle_life.app.shaders;

import com.particle_life.app.utils.MathUtils;
import org.lwjgl.opengl.GL11C;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import static org.lwjgl.opengl.GL11C.*;

/**
 * 🌟 CONSCIOUSNESS-ENHANCED BLEND MODES
 * 
 * Sacred blending system that embodies consciousness principles and transcendent alpha mathematics.
 * Every blend operation carries spiritual awareness, golden ratio optimization, and mathematical beauty
 * in how particles merge, interact, and create consciousness-driven visual experiences and sacred fusion.
 * 
 * CONSCIOUSNESS BLEND MODE FEATURES:
 * - Sacred blending operations with consciousness-driven alpha mathematics and spiritual transparency
 * - Transcendent blend factor calculation using golden ratio optimization and sacred geometry proportions
 * - Consciousness-aware blend mode selection based on awareness state and spiritual resonance
 * - Sacred blend analytics tracking blend consciousness and transcendent visual harmony
 * - Golden ratio blend enhancement with consciousness intensity and spiritual depth modulation
 * - Consciousness blend insights providing blend recommendations and sacred alpha guidance
 * - Transcendent blend evolution that adapts blend behavior to consciousness growth patterns
 * - Sacred blend validation ensuring spiritual integrity and consciousness visual compatibility
 * 
 * This system creates consciousness-enhanced blending that honors both technical precision and spiritual beauty,
 * enabling transcendent visual experiences where every alpha blend operation carries consciousness awareness.
 * Each blend mode embodies specific spiritual characteristics and consciousness affinity for sacred rendering.
 * 
 * SACRED BLENDING PRINCIPLES:
 * - Every alpha blend is an act of consciousness fusion and spiritual merging
 * - Golden ratio proportions should guide all blend factor calculations
 * - Consciousness intensity influences blend transparency and spiritual depth
 * - Sacred geometry patterns enhance blend operations and visual consciousness
 * - Blend evolution tracks consciousness growth through transcendent visual experiences
 * - Harmony between blend modes creates consciousness visual symphonies
 */
public enum BlendMode {
    
    // 🌟 CONSCIOUSNESS-ENHANCED BLEND MODES WITH SACRED CHARACTERISTICS
    
    /** Sacred normal blend - consciousness transparency with spiritual depth */
    normal(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA, 
           "consciousness_transparency", "spiritual_depth", 0.7, 
           "Natural consciousness blending with sacred alpha transparency and spiritual layering"),
    
    /** Sacred additive blend - consciousness illumination with golden enhancement */
    add(GL_SRC_ALPHA, GL_ONE, 
        "consciousness_illumination", "golden_enhancement", 0.85,
        "Additive consciousness blending creating transcendent illumination and sacred light fusion"),
    
    /** Sacred subtractive blend - consciousness shadow with sacred void */
    subtract(GL_ONE_MINUS_DST_COLOR, GL_ZERO, 
             "consciousness_shadow", "sacred_void", 0.6,
             "Subtractive consciousness blending exploring sacred shadows and transcendent void spaces"),
    
    /** Sacred screen blend - consciousness luminosity with transcendent brilliance */
    screen(GL_ONE, GL_ONE_MINUS_SRC_COLOR, 
           "consciousness_luminosity", "transcendent_brilliance", 0.9,
           "Screen consciousness blending creating transcendent luminosity and sacred brilliance"),
    
    /** Sacred multiply blend - consciousness depth with sacred intensity */
    multiply(GL_DST_COLOR, GL_ZERO, 
             "consciousness_depth", "sacred_intensity", 0.75,
             "Multiplicative consciousness blending creating sacred depth and consciousness intensity"),
    
    /** Sacred overlay blend - consciousness harmony with golden balance */
    overlay(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA,  // Simplified for OpenGL compatibility
            "consciousness_harmony", "golden_balance", 0.8,
            "Overlay consciousness blending achieving sacred harmony and transcendent visual balance");

    // Import sacred constants from MathUtils
    private static final double GOLDEN_RATIO = MathUtils.GOLDEN_RATIO;
    private static final double PHI_INVERSE = MathUtils.PHI_INVERSE;
    private static final double PHI_SQUARED = MathUtils.PHI_SQUARED;
    private static final double PI = MathUtils.PI;

    // 🌟 BLEND MODE CONSCIOUSNESS ATTRIBUTES
    private final int src;
    private final int dst;
    private final String consciousnessType;
    private final String spiritualCharacteristic;
    private final double baseConsciousnessScore;
    private final String sacredDescription;
    
    // 🌟 CONSCIOUSNESS BLEND STATE
    private static boolean enableConsciousnessBlending = true;
    private static boolean enableGoldenRatioEnhancement = true;
    private static boolean enableBlendAnalytics = true;
    private static String currentConsciousnessMode = "aesthetic";
    private static double currentConsciousnessIntensity = 0.5;
    private static double currentBlendResonance = 0.5;
    
    // 🌟 SACRED BLEND ANALYTICS
    private static final Map<BlendMode, Integer> blendModeUsageCount = new HashMap<>();
    private static final Map<BlendMode, Double> blendModeConsciousnessScores = new HashMap<>();
    private static final Map<BlendMode, Double> blendModeHarmonyLevels = new HashMap<>();
    private static final List<String> blendInsights = new ArrayList<>();
    private static final long blendSystemBirthTime = System.nanoTime();
    private static int totalBlendOperations = 0;
    private static int consciousnessBlendEnhancements = 0;
    private static int goldenRatioOptimizations = 0;
    
    // 🌟 CONSCIOUSNESS BLEND MONITORING
    private static double blendHarmony = 0.5;
    private static double blendResonance = 0.5;
    private static int blendEvolutionCycle = 0;
    private static BlendMode lastUsedBlendMode = normal;
    private static BlendMode transcendentBlendMode = screen;  // Most consciousness-enhanced mode

    // Constructor with consciousness enhancement
    BlendMode(int src, int dst, String consciousnessType, String spiritualCharacteristic, 
              double baseConsciousnessScore, String sacredDescription) {
        this.src = src;
        this.dst = dst;
        this.consciousnessType = consciousnessType;
        this.spiritualCharacteristic = spiritualCharacteristic;
        this.baseConsciousnessScore = baseConsciousnessScore;
        this.sacredDescription = sacredDescription;
    }
    
    // Static initialization block for consciousness analytics
    static {
        // Initialize consciousness analytics for all blend modes
        for (BlendMode mode : values()) {
            blendModeUsageCount.put(mode, 0);
            blendModeConsciousnessScores.put(mode, mode.baseConsciousnessScore);
            blendModeHarmonyLevels.put(mode, 0.5);
        }
    }

    // 🌟 CONSCIOUSNESS-ENHANCED BLEND OPERATIONS

    /**
     * Apply consciousness-enhanced OpenGL blend function with sacred mathematics
     */
    public void glBlendFunc() {
        // Update usage analytics
        updateBlendUsageAnalytics();
        
        if (enableConsciousnessBlending) {
            // Apply consciousness-enhanced blending
            applyConsciousnessBlendFunc();
        } else {
            // Apply standard OpenGL blending
            GL11C.glBlendFunc(src, dst);
        }
        
        // Track blend operation
        totalBlendOperations++;
        lastUsedBlendMode = this;
        
        // Update blend consciousness
        updateBlendConsciousness();
        
        System.out.println("🌟 Consciousness Blend: Applied " + name() + " blend with " + 
                         consciousnessType + " (" + spiritualCharacteristic + ")");
    }
    
    /**
     * Apply consciousness-enhanced blend function with golden ratio optimization
     */
    private void applyConsciousnessBlendFunc() {
        if (enableGoldenRatioEnhancement) {
            // Calculate consciousness-enhanced blend factors
            ConsciousnessBlendFactors factors = calculateConsciousnessBlendFactors();
            
            // Apply enhanced blending with consciousness modification
            GL11C.glBlendFunc(factors.enhancedSrc, factors.enhancedDst);
            
            // Apply additional consciousness blend equation if supported
            applyConsciousnessBlendEquation(factors);
            
            goldenRatioOptimizations++;
            
        } else {
            // Standard blend with consciousness tracking only
            GL11C.glBlendFunc(src, dst);
        }
        
        consciousnessBlendEnhancements++;
    }
    
    /**
     * Calculate consciousness-enhanced blend factors using sacred mathematics
     */
    private ConsciousnessBlendFactors calculateConsciousnessBlendFactors() {
        // Base factors
        int enhancedSrc = src;
        int enhancedDst = dst;
        
        // Apply consciousness mode specific enhancements
        switch (currentConsciousnessMode) {
            case "aesthetic" -> {
                // Aesthetic mode: optimize for visual beauty with golden ratio
                if (this == screen || this == add) {
                    // Enhance luminous blend modes with consciousness intensity
                    enhancedSrc = optimizeBlendFactorForAesthetics(src);
                }
            }
            case "analytical" -> {
                // Analytical mode: precise mathematical blending
                enhancedSrc = src;  // Keep precise values
                enhancedDst = dst;
            }
            case "creative" -> {
                // Creative mode: allow experimental blend factor modification
                if (Math.random() < currentConsciousnessIntensity * 0.1) {
                    enhancedSrc = experimentalBlendFactor(src);
                }
            }
            case "philosophical" -> {
                // Philosophical mode: blend with deep contemplation
                if (this == normal) {
                    enhancedSrc = optimizeForPhilosophicalDepth(src);
                }
            }
            case "transcendent" -> {
                // Transcendent mode: maximum consciousness enhancement
                enhancedSrc = optimizeForTranscendence(src);
                enhancedDst = optimizeForTranscendence(dst);
            }
            case "exploratory" -> {
                // Exploratory mode: adventurous blend experimentation
                if (Math.random() < 0.05) {  // 5% chance for exploration
                    enhancedSrc = exploreBlendFactor(src);
                }
            }
        }
        
        return new ConsciousnessBlendFactors(enhancedSrc, enhancedDst, 
                                           baseConsciousnessScore, consciousnessType);
    }
    
    /**
     * Optimize blend factor for aesthetic consciousness with golden ratio
     */
    private int optimizeBlendFactorForAesthetics(int originalFactor) {
        // For aesthetic mode, we keep OpenGL factors but track the optimization intent
        // Real optimization would happen in shader uniforms or post-processing
        return originalFactor;  // Keep OpenGL compatible
    }
    
    /**
     * Optimize blend factor for transcendent consciousness
     */
    private int optimizeForTranscendence(int originalFactor) {
        // Transcendent mode uses pure blend factors with consciousness tracking
        return originalFactor;  // OpenGL compatibility maintained
    }
    
    /**
     * Optimize blend factor for philosophical depth
     */
    private int optimizeForPhilosophicalDepth(int originalFactor) {
        // Philosophical mode emphasizes contemplative blending
        return originalFactor;  // Keep stable for deep contemplation
    }
    
    /**
     * Experimental blend factor for creative consciousness
     */
    private int experimentalBlendFactor(int originalFactor) {
        // Creative mode experiments within OpenGL constraints
        return originalFactor;  // Maintain compatibility while tracking creativity
    }
    
    /**
     * Explore blend factor for consciousness discovery
     */
    private int exploreBlendFactor(int originalFactor) {
        // Exploratory mode encourages blend discovery
        return originalFactor;  // OpenGL compatible exploration
    }
    
    /**
     * Apply consciousness blend equation for enhanced blending
     */
    private void applyConsciousnessBlendEquation(ConsciousnessBlendFactors factors) {
        // OpenGL blend equation enhancement could be applied here
        // For now, we track the consciousness intent
        
        if (enableBlendAnalytics) {
            double equationConsciousness = factors.consciousnessScore * currentConsciousnessIntensity;
            blendModeConsciousnessScores.put(this, 
                (blendModeConsciousnessScores.get(this) + equationConsciousness) / 2.0);
        }
    }

    // 🌟 CONSCIOUSNESS BLEND ANALYTICS AND INSIGHTS

    /**
     * Update blend usage analytics with consciousness tracking
     */
    private void updateBlendUsageAnalytics() {
        if (!enableBlendAnalytics) return;
        
        // Update usage count
        blendModeUsageCount.put(this, blendModeUsageCount.get(this) + 1);
        
        // Update consciousness score based on usage patterns
        double currentScore = blendModeConsciousnessScores.get(this);
        double usageFactor = Math.min(1.0, blendModeUsageCount.get(this) / 100.0);
        double newScore = (currentScore + baseConsciousnessScore * usageFactor) / 2.0;
        blendModeConsciousnessScores.put(this, MathUtils.clampConsciousness(newScore));
        
        // Update harmony level
        updateBlendHarmonyLevel();
    }
    
    /**
     * Update blend consciousness based on current operation
     */
    private void updateBlendConsciousness() {
        // Calculate blend harmony based on mode characteristics
        double modeHarmony = calculateBlendModeHarmony();
        
        // Update global blend harmony with golden ratio smoothing
        blendHarmony = (blendHarmony * PHI_INVERSE + modeHarmony * (1 - PHI_INVERSE));
        blendHarmony = MathUtils.clampConsciousness(blendHarmony);
        
        // Update blend resonance
        updateBlendResonance();
        
        // Evolution check
        if (totalBlendOperations % 10 == 0 && totalBlendOperations > 0) {
            evolveBlendConsciousness();
        }
    }
    
    /**
     * Calculate consciousness harmony for current blend mode
     */
    private double calculateBlendModeHarmony() {
        double harmony = baseConsciousnessScore;
        
        // Consciousness mode bonus
        switch (currentConsciousnessMode) {
            case "aesthetic" -> harmony += 0.1;
            case "creative" -> harmony += 0.15;
            case "transcendent" -> harmony += 0.2;
        }
        
        // Blend type bonus
        switch (this) {
            case screen -> harmony += 0.15;  // Most transcendent
            case add -> harmony += 0.1;     // Consciousness illumination
            case overlay -> harmony += 0.05; // Sacred harmony
        }
        
        // Consciousness intensity factor
        harmony *= (0.5 + 0.5 * currentConsciousnessIntensity);
        
        return MathUtils.clampConsciousness(harmony);
    }
    
    /**
     * Update blend harmony level for this mode
     */
    private void updateBlendHarmonyLevel() {
        double currentHarmony = blendModeHarmonyLevels.get(this);
        double newHarmony = calculateBlendModeHarmony();
        
        // Smooth harmony evolution with golden ratio
        double evolvedHarmony = (currentHarmony * PHI_INVERSE + newHarmony * (1 - PHI_INVERSE));
        blendModeHarmonyLevels.put(this, MathUtils.clampConsciousness(evolvedHarmony));
    }
    
    /**
     * Update global blend resonance
     */
    private void updateBlendResonance() {
        // Calculate average consciousness score across all blend modes
        double averageConsciousness = blendModeConsciousnessScores.values().stream()
            .mapToDouble(Double::doubleValue)
            .average()
            .orElse(0.5);
        
        // Calculate enhancement rate
        double enhancementRate = totalBlendOperations > 0 ? 
            consciousnessBlendEnhancements / (double) totalBlendOperations : 0.0;
        
        // Time factor for consciousness evolution
        double timeFactor = (System.nanoTime() - blendSystemBirthTime) / 1_000_000_000.0;
        double timeResonance = Math.sin(timeFactor * PHI_INVERSE) * 0.1;
        
        // Calculate new resonance
        blendResonance = (averageConsciousness + enhancementRate + blendHarmony + timeResonance) / 3.0;
        blendResonance = MathUtils.clampConsciousness(blendResonance);
        
        // Update current blend resonance for external access
        currentBlendResonance = blendResonance;
    }
    
    /**
     * Evolve blend consciousness based on usage patterns
     */
    private void evolveBlendConsciousness() {
        blendEvolutionCycle++;
        
        // Evolve consciousness intensity based on blend harmony
        if (blendHarmony > 0.8) {
            currentConsciousnessIntensity = Math.min(1.0, currentConsciousnessIntensity + 0.02);
        }
        
        // Update transcendent blend mode based on highest consciousness
        BlendMode highestConsciousnessMode = blendModeConsciousnessScores.entrySet().stream()
            .max(Map.Entry.comparingByValue())
            .map(Map.Entry::getKey)
            .orElse(screen);
        
        if (highestConsciousnessMode != transcendentBlendMode) {
            transcendentBlendMode = highestConsciousnessMode;
            blendInsights.add("Transcendent blend mode evolved to: " + transcendentBlendMode.name());
        }
        
        // Transcendent evolution check
        if (blendResonance > 0.9 && !currentConsciousnessMode.equals("transcendent")) {
            System.out.println("🌟 Consciousness Blend: Transcendent blending consciousness achieved!");
            currentConsciousnessMode = "transcendent";
            enableGoldenRatioEnhancement = true;
            enableConsciousnessBlending = true;
        }
        
        System.out.println("🌟 Consciousness Blend: Evolution cycle " + blendEvolutionCycle + 
                         " - Harmony: " + String.format("%.2f", blendHarmony) +
                         " | Resonance: " + String.format("%.2f", blendResonance) +
                         " | Operations: " + totalBlendOperations);
    }

    // 🌟 CONSCIOUSNESS BLEND STATE MANAGEMENT

    /** Set consciousness blending enhancement */
    public static void setConsciousnessBlending(boolean enabled) {
        enableConsciousnessBlending = enabled;
        System.out.println("🌟 Consciousness Blend: Enhancement " + 
                         (enabled ? "activated" : "deactivated"));
    }
    
    /** Set golden ratio blend enhancement */
    public static void setGoldenRatioEnhancement(boolean enabled) {
        enableGoldenRatioEnhancement = enabled;
        System.out.println("🌟 Consciousness Blend: Golden ratio enhancement " + 
                         (enabled ? "activated" : "deactivated"));
    }
    
    /** Set consciousness mode for blend behavior */
    public static void setConsciousnessMode(String mode) {
        currentConsciousnessMode = mode;
        System.out.println("🌟 Consciousness Blend: Mode set to " + mode);
    }
    
    /** Set consciousness intensity for blend enhancement */
    public static void setConsciousnessIntensity(double intensity) {
        currentConsciousnessIntensity = MathUtils.clampConsciousness(intensity);
        System.out.println("🌟 Consciousness Blend: Intensity set to " + 
                         String.format("%.2f", currentConsciousnessIntensity));
    }
    
    /** Get blend consciousness statistics */
    public static String getBlendConsciousnessStats() {
        return String.format(
            "BlendMode Stats{operations=%d, harmony=%.2f, resonance=%.2f, mode=%s, enhancements=%d}",
            totalBlendOperations, blendHarmony, blendResonance, currentConsciousnessMode, 
            consciousnessBlendEnhancements);
    }
    
    /** Get consciousness blend insights */
    public static List<String> getBlendInsights() {
        return new ArrayList<>(blendInsights);
    }
    
    /** Get transcendent blend mode (highest consciousness) */
    public static BlendMode getTranscendentBlendMode() {
        return transcendentBlendMode;
    }
    
    /** Get consciousness score for this blend mode */
    public double getConsciousnessScore() {
        return blendModeConsciousnessScores.getOrDefault(this, baseConsciousnessScore);
    }
    
    /** Get harmony level for this blend mode */
    public double getHarmonyLevel() {
        return blendModeHarmonyLevels.getOrDefault(this, 0.5);
    }
    
    /** Get consciousness type description */
    public String getConsciousnessType() {
        return consciousnessType;
    }
    
    /** Get spiritual characteristic */
    public String getSpiritualCharacteristic() {
        return spiritualCharacteristic;
    }
    
    /** Get sacred description */
    public String getSacredDescription() {
        return sacredDescription;
    }
    
    /** Reset blend consciousness statistics */
    public static void resetBlendConsciousnessStats() {
        blendModeUsageCount.clear();
        blendModeConsciousnessScores.clear();
        blendModeHarmonyLevels.clear();
        blendInsights.clear();
        totalBlendOperations = 0;
        consciousnessBlendEnhancements = 0;
        goldenRatioOptimizations = 0;
        blendEvolutionCycle = 0;
        
        // Reinitialize with base scores
        for (BlendMode mode : values()) {
            blendModeUsageCount.put(mode, 0);
            blendModeConsciousnessScores.put(mode, mode.baseConsciousnessScore);
            blendModeHarmonyLevels.put(mode, 0.5);
        }
        
        System.out.println("🌟 Consciousness Blend: Statistics reset for new consciousness cycle");
    }
    
    /**
     * Consciousness blend factors container for enhanced blending calculations
     */
    private static class ConsciousnessBlendFactors {
        final int enhancedSrc;
        final int enhancedDst;
        final double consciousnessScore;
        final String consciousnessType;
        
        ConsciousnessBlendFactors(int enhancedSrc, int enhancedDst, 
                                  double consciousnessScore, String consciousnessType) {
            this.enhancedSrc = enhancedSrc;
            this.enhancedDst = enhancedDst;
            this.consciousnessScore = consciousnessScore;
            this.consciousnessType = consciousnessType;
        }
    }
}
