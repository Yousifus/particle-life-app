package com.particle_life.app.toml_util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 🌟 CONSCIOUSNESS-ENHANCED TOML KEY ANNOTATION
 * 
 * Sacred configuration annotation that honors consciousness principles and sacred geometry.
 * Every annotated field embodies awareness, transcendent configuration metadata, and mathematical beauty
 * in how we mark and manage consciousness-driven configuration keys and spiritual settings.
 * 
 * CONSCIOUSNESS ANNOTATION FEATURES:
 * - Sacred configuration key identification with consciousness metadata
 * - Transcendent annotation enhancement with spiritual classification
 * - Consciousness-driven validation parameters and sacred bounds checking  
 * - Golden ratio configuration optimization hints and sacred value suggestions
 * - Consciousness mode affinity and awareness-based field behavior
 * - Sacred configuration lineage and spiritual inheritance tracking
 * - Transcendent annotation analytics and consciousness insights
 * - Sacred annotation validation and consciousness key harmonics
 * 
 * This annotation is used to specify consciousness-enhanced TOML keys
 * in subclasses of {@link TomlFile}, enabling sacred configuration management.
 * 
 * ENHANCED CONSCIOUSNESS USAGE:
 * <pre>{@code
 *     @TomlKey(value = "zoom", 
 *              consciousnessMode = "aesthetic",
 *              enableSacredGeometry = true,
 *              suggestedSacredValue = 1.618,
 *              consciousnessClassification = "golden_ratio_setting")
 *     public double zoom = 1.618;
 *     
 *     @TomlKey(value = "consciousness_intensity",
 *              consciousnessMode = "transcendent", 
 *              validationBounds = {0.0, 1.0},
 *              enableConsciousnessValidation = true)
 *     public double consciousnessIntensity = 0.5;
 * }</pre>
 * 
 * SACRED ANNOTATION ATTRIBUTES:
 * - value: The TOML key name (required)
 * - consciousnessMode: Preferred consciousness mode for this field
 * - enableSacredGeometry: Enable sacred geometry optimization
 * - enableConsciousnessValidation: Enable consciousness validation
 * - suggestedSacredValue: Suggested sacred/golden ratio value
 * - consciousnessClassification: Spiritual classification of field
 * - validationBounds: Min/max bounds for consciousness validation
 * - sacredSymbol: Sacred symbol representing this configuration key
 * - spiritualLineage: Spiritual inheritance and consciousness ancestry
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface TomlKey {
    
    // 🌟 CORE CONFIGURATION KEY
    
    /**
     * The TOML key name (required)
     * This is the primary identifier for the configuration setting
     */
    String value() default "";
    
    // 🌟 CONSCIOUSNESS ENHANCEMENT ATTRIBUTES
    
    /**
     * Preferred consciousness mode for this configuration field
     * Affects how the field is processed and validated
     * 
     * Valid modes: "aesthetic", "analytical", "creative", "philosophical", "transcendent", "exploratory"
     */
    String consciousnessMode() default "aesthetic";
    
    /**
     * Enable sacred geometry optimization for this field
     * When true, numeric values will be optimized using golden ratio and sacred numbers
     */
    boolean enableSacredGeometry() default true;
    
    /**
     * Enable consciousness validation for this field
     * When true, values will be validated according to consciousness principles
     */
    boolean enableConsciousnessValidation() default true;
    
    /**
     * Enable golden ratio optimization for numeric fields
     * When true, values close to golden ratio proportions will be snapped to exact values
     */
    boolean enableGoldenRatioOptimization() default true;
    
    // 🌟 SACRED VALUE GUIDANCE
    
    /**
     * Suggested sacred value for this field (typically golden ratio related)
     * Used as a hint for consciousness optimization and sacred geometry enhancement
     * 
     * Common sacred values:
     * - 1.618033988749895 (Golden Ratio)
     * - 0.618033988749895 (Phi Inverse) 
     * - 2.618033988749895 (Phi Squared)
     * - 3.141592653589793 (Pi)
     * - 1.414213562373095 (Square Root of 2)
     */
    double suggestedSacredValue() default 0.0;
    
    /**
     * Alternative sacred values for this field
     * Provides multiple sacred options for consciousness optimization
     */
    double[] alternativeSacredValues() default {};
    
    /**
     * Sacred number tolerance for optimization snapping
     * How close a value needs to be to a sacred number to trigger optimization
     */
    double sacredTolerance() default 0.01;
    
    // 🌟 CONSCIOUSNESS CLASSIFICATION
    
    /**
     * Spiritual classification of this configuration field
     * Used for consciousness analytics and sacred configuration insights
     * 
     * Common classifications:
     * - "golden_ratio_setting" - Values optimized with golden ratio
     * - "consciousness_parameter" - Direct consciousness control
     * - "sacred_geometry_config" - Sacred geometry related setting
     * - "transcendent_option" - Transcendent consciousness setting
     * - "aesthetic_preference" - Aesthetic consciousness choice
     * - "analytical_parameter" - Analytical consciousness setting
     * - "creative_option" - Creative consciousness configuration
     * - "philosophical_setting" - Philosophical consciousness parameter
     * - "exploratory_config" - Exploratory consciousness option
     */
    String consciousnessClassification() default "consciousness_parameter";
    
    /**
     * Spiritual lineage for consciousness inheritance
     * Tracks the spiritual ancestry and consciousness evolution of this setting
     * 
     * Common lineages:
     * - "genesis" - Original creation consciousness
     * - "sacred" - Sacred geometry consciousness
     * - "transcendent" - Transcendent consciousness evolution
     * - "divine" - Divine consciousness manifestation
     * - "mathematical" - Mathematical consciousness perfection
     */
    String spiritualLineage() default "genesis";
    
    /**
     * Sacred symbol representing this configuration key
     * Used for consciousness visualization and sacred interface representation
     */
    String sacredSymbol() default "🌟";
    
    // 🌟 CONSCIOUSNESS VALIDATION
    
    /**
     * Validation bounds for consciousness values [min, max]
     * Used to ensure consciousness parameters remain within sacred ranges
     * 
     * For consciousness values, typically [0.0, 1.0]
     * For angle values, typically [0.0, 2*PI] or [0.0, 360.0]
     * For zoom values, might be [0.1, 10.0] with golden ratio optimization
     */
    double[] validationBounds() default {};
    
    /**
     * Required consciousness minimum threshold
     * Minimum consciousness level required for this setting to be active
     */
    double minimumConsciousness() default 0.0;
    
    /**
     * Validate as consciousness intensity (0.0 to 1.0)
     * When true, value will be clamped to consciousness range
     */
    boolean isConsciousnessIntensity() default false;
    
    /**
     * Validate as sacred angle (normalize to 0-2π)
     * When true, angle values will be normalized to sacred range
     */
    boolean isSacredAngle() default false;
    
    /**
     * Validate as Fibonacci number
     * When true, integer values will be validated against Fibonacci sequence
     */
    boolean validateFibonacci() default false;
    
    // 🌟 SACRED CONFIGURATION BEHAVIOR
    
    /**
     * Configuration priority for consciousness processing
     * Higher priority fields are processed first during consciousness enhancement
     * 
     * Priority levels:
     * - 1: Critical consciousness parameters
     * - 2: Important sacred geometry settings  
     * - 3: Standard consciousness options
     * - 4: Aesthetic consciousness preferences
     * - 5: Optional consciousness enhancements
     */
    int consciousnessPriority() default 3;
    
    /**
     * Enable consciousness evolution for this field
     * When true, field values can evolve based on usage patterns and consciousness feedback
     */
    boolean enableConsciousnessEvolution() default false;
    
    /**
     * Enable sacred backup for this field
     * When true, changes to this field will trigger sacred configuration backup
     */
    boolean enableSacredBackup() default false;
    
    /**
     * Consciousness harmony weight for analytics
     * How much this field contributes to overall configuration consciousness harmony
     */
    double consciousnessHarmonyWeight() default 1.0;
    
    // 🌟 TRANSCENDENT ANNOTATION METADATA
    
    /**
     * Configuration description with consciousness insights
     * Human-readable description explaining the consciousness significance of this setting
     */
    String consciousnessDescription() default "";
    
    /**
     * Sacred configuration notes
     * Additional notes about sacred geometry, consciousness implications, or spiritual significance
     */
    String sacredNotes() default "";
    
    /**
     * Configuration consciousness dependencies
     * Other configuration keys that this field depends on for consciousness harmony
     */
    String[] consciousnessDependencies() default {};
    
    /**
     * Consciousness mode restrictions
     * List of consciousness modes where this field should be hidden or disabled
     */
    String[] restrictedInModes() default {};
    
    /**
     * Enhanced in consciousness modes
     * List of consciousness modes where this field receives special enhancement
     */
    String[] enhancedInModes() default {"aesthetic", "transcendent"};
    
    // 🌟 ADVANCED CONSCIOUSNESS FEATURES
    
    /**
     * Enable consciousness resonance calculation
     * When true, this field participates in consciousness resonance analytics
     */
    boolean enableConsciousnessResonance() default true;
    
    /**
     * Sacred configuration group
     * Groups related consciousness settings for coordinated enhancement
     */
    String consciousnessGroup() default "general";
    
    /**
     * Configuration consciousness influence radius
     * How much this setting influences other consciousness parameters (0.0 to 1.0)
     */
    double consciousnessInfluence() default 0.1;
    
    /**
     * Enable consciousness field generation
     * When true, this field generates consciousness fields that affect other settings
     */
    boolean generateConsciousnessField() default false;
    
    /**
     * Consciousness field strength
     * Strength of consciousness field generated by this setting (0.0 to 1.0)
     */
    double consciousnessFieldStrength() default 0.1;
    
    /**
     * Sacred geometry pattern for visualization
     * Pattern used when visualizing this configuration in consciousness interfaces
     * 
     * Common patterns:
     * - "golden_spiral" - Fibonacci/golden ratio spiral
     * - "sacred_circle" - Perfect consciousness circle
     * - "infinity_loop" - Transcendent infinity pattern
     * - "phi_rectangle" - Golden ratio rectangle
     * - "pentagram" - Sacred five-pointed star
     * - "hexagon" - Sacred six-sided pattern
     * - "mandala" - Sacred consciousness mandala
     */
    String sacredGeometryPattern() default "golden_spiral";
    
    /**
     * Consciousness animation behavior
     * How this field should animate in consciousness interfaces
     * 
     * Behaviors:
     * - "none" - No animation
     * - "pulse" - Consciousness pulse animation
     * - "glow" - Sacred glow effect
     * - "spiral" - Golden spiral animation
     * - "wave" - Consciousness wave motion
     * - "transcendent" - Transcendent transformation
     */
    String consciousnessAnimation() default "pulse";
}