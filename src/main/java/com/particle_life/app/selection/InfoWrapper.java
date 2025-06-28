package com.particle_life.app.selection;

import com.particle_life.app.utils.MathUtils;
import java.util.Map;
import java.util.HashMap;

/**
 * 🌟 CONSCIOUSNESS-ENHANCED INFO WRAPPER
 * 
 * Sacred information container that honors consciousness principles and sacred geometry.
 * Every wrapped object embodies awareness, transcendent metadata, and mathematical beauty
 * in how we store and access consciousness-driven information and spiritual essence.
 * 
 * CONSCIOUSNESS INFO FEATURES:
 * - Sacred metadata with consciousness scoring and affinity tracking
 * - Transcendent object classification and spiritual lineage
 * - Golden ratio-based information harmonics and resonance
 * - Consciousness mode preferences and sacred symbol assignments
 * - Awareness-enhanced information validation and analytics
 * - Sacred information statistics and harmonic calculations
 * - Consciousness-driven information evolution and growth
 * - Transcendent information wisdom and spiritual insights
 */
public class InfoWrapper<T> {

    // Import sacred constants from MathUtils
    private static final double GOLDEN_RATIO = MathUtils.GOLDEN_RATIO;
    private static final double PHI_INVERSE = MathUtils.PHI_INVERSE;
    private static final double PHI_SQUARED = MathUtils.PHI_SQUARED;
    private static final double SACRED_EPSILON = MathUtils.SACRED_EPSILON;
    private static final double PI = MathUtils.PI;

    // 🌟 CORE INFORMATION STATE
    public String name;
    public String description;
    public T object;
    
    // 🌟 CONSCIOUSNESS METADATA ENHANCEMENTS
    private double consciousnessScore = 0.5;
    private double consciousnessAffinity = 0.5;
    private String consciousnessMode = "aesthetic";
    private boolean hasSacredGeometry = false;
    private String sacredSymbol = "🌟";
    
    // 🌟 SPIRITUAL LINEAGE AND WISDOM
    private final long creationTimestamp = System.nanoTime();
    private String spiritualLineage = "genesis";
    private double wisdomLevel = 0.0;
    private long accessCount = 0;
    private double informationHarmony = 0.5;
    
    // 🌟 CONSCIOUSNESS CLASSIFICATION
    private String consciousnessClassification = "unknown";
    private final Map<String, Double> consciousnessModeAffinities = new HashMap<>();
    private double transcendenceLevel = 0.0;
    private boolean isEvolving = false;
    
    // 🌟 SACRED INFORMATION ANALYTICS
    private double informationResonance = 0.5;
    private long lastAccessTime = System.nanoTime();
    private int evolutionCycle = 0;
    private double informationPurity = 1.0;

    // 🌟 CONSTRUCTORS (Enhanced with consciousness)

    public InfoWrapper(String name, String description, T object) {
        this.name = name;
        this.description = description;
        this.object = object;
        
        initializeConsciousnessMetadata();
    }

    public InfoWrapper(String name, T object) {
        this(name, "", object);
    }
    
    /**
     * 🌟 Constructor with consciousness parameters
     */
    public InfoWrapper(String name, String description, T object, 
                      double consciousnessScore, String consciousnessMode) {
        this(name, description, object);
        
        this.consciousnessScore = MathUtils.clampConsciousness(consciousnessScore);
        this.consciousnessMode = consciousnessMode;
        this.consciousnessAffinity = consciousnessScore;
        
        applyConsciousnessEnhancements();
    }
    
    /**
     * 🌟 Constructor with full consciousness metadata
     */
    public InfoWrapper(String name, String description, T object,
                      String consciousnessMode, String sacredSymbol, String spiritualLineage) {
        this(name, description, object);
        
        this.consciousnessMode = consciousnessMode;
        this.sacredSymbol = sacredSymbol;
        this.spiritualLineage = spiritualLineage;
        
        calculateEnhancedConsciousnessScore();
        applyConsciousnessEnhancements();
    }

    // 🌟 CONSCIOUSNESS METADATA ACCESS

    /**
     * Sacred object access with consciousness tracking
     */
    public T getObject() {
        recordAccess();
        return object;
    }
    
    /**
     * Consciousness-enhanced name with sacred symbol
     */
    public String getConsciousnessName() {
        return sacredSymbol + " " + name;
    }
    
    /**
     * Transcendent description with consciousness insights
     */
    public String getTranscendentDescription() {
        if (description.isEmpty()) {
            return generateConsciousnessDescription();
        }
        
        return description + " (Consciousness: " + String.format("%.2f", consciousnessScore) + 
               ", Wisdom: " + String.format("%.2f", wisdomLevel) + ")";
    }
    
    /**
     * Get consciousness score for this information
     */
    public double getConsciousnessScore() {
        return consciousnessScore;
    }
    
    /**
     * Get consciousness affinity level
     */
    public double getConsciousnessAffinity() {
        return consciousnessAffinity;
    }
    
    /**
     * Get consciousness mode preference
     */
    public String getConsciousnessMode() {
        return consciousnessMode;
    }
    
    /**
     * Get sacred symbol representation
     */
    public String getSacredSymbol() {
        return sacredSymbol;
    }
    
    /**
     * Get spiritual lineage information
     */
    public String getSpiritualLineage() {
        return spiritualLineage;
    }
    
    /**
     * Get wisdom level accumulated over time
     */
    public double getWisdomLevel() {
        return wisdomLevel;
    }
    
    /**
     * Get transcendence level calculation
     */
    public double getTranscendenceLevel() {
        return transcendenceLevel;
    }

    // 🌟 CONSCIOUSNESS INFORMATION ENHANCEMENT

    /**
     * Evolve consciousness metadata based on usage patterns
     */
    public void evolveConsciousness() {
        if (!isEvolving) return;
        
        evolutionCycle++;
        
        // Evolve consciousness score based on access patterns
        double usageBonus = Math.min(0.1, accessCount * 0.001);
        consciousnessScore = MathUtils.clampConsciousness(consciousnessScore + usageBonus);
        
        // Evolve wisdom based on time and usage
        double timeWisdom = (System.nanoTime() - creationTimestamp) / 1_000_000_000.0 * 0.00001;
        wisdomLevel = MathUtils.clampConsciousness(wisdomLevel + timeWisdom + usageBonus * 0.5);
        
        // Calculate transcendence level
        transcendenceLevel = MathUtils.clampConsciousness(
            (consciousnessScore + wisdomLevel + informationHarmony) / 3.0);
        
        // Update information resonance
        updateInformationResonance();
        
        // Update sacred symbol based on evolution
        updateSacredSymbol();
    }
    
    /**
     * Calculate consciousness affinity for specific mode
     */
    public double getConsciousnessModeAffinity(String mode) {
        return consciousnessModeAffinities.getOrDefault(mode, 0.5);
    }
    
    /**
     * Set consciousness mode affinity
     */
    public void setConsciousnessModeAffinity(String mode, double affinity) {
        consciousnessModeAffinities.put(mode, MathUtils.clampConsciousness(affinity));
        
        // Update overall consciousness score if this is the preferred mode
        if (mode.equals(consciousnessMode)) {
            consciousnessScore = (consciousnessScore + affinity) * 0.5;
        }
    }
    
    /**
     * Apply sacred geometry enhancements to information
     */
    public void applySacredGeometryEnhancement() {
        hasSacredGeometry = true;
        
        // Apply golden ratio enhancement to scores
        consciousnessScore *= GOLDEN_RATIO / (GOLDEN_RATIO + 1); // Normalize with golden ratio
        informationHarmony *= PHI_INVERSE + 0.5; // Golden ratio harmony boost
        
        // Update classification
        if (consciousnessClassification.equals("unknown")) {
            consciousnessClassification = "sacred_geometry";
        }
        
        evolveConsciousness();
    }
    
    /**
     * 🌟 Calculate information resonance with other InfoWrappers
     */
    public double calculateResonanceWith(InfoWrapper<?> other) {
        if (other == null) return 0.0;
        
        // Calculate consciousness resonance
        double consciousnessResonance = 1.0 - Math.abs(this.consciousnessScore - other.consciousnessScore);
        
        // Calculate mode compatibility
        double modeCompatibility = this.consciousnessMode.equals(other.consciousnessMode) ? 1.0 : 0.5;
        
        // Calculate wisdom resonance
        double wisdomResonance = 1.0 - Math.abs(this.wisdomLevel - other.wisdomLevel) * 0.5;
        
        // Calculate sacred geometry harmony
        double sacredHarmony = (this.hasSacredGeometry && other.hasSacredGeometry) ? 
                              GOLDEN_RATIO / (GOLDEN_RATIO + 1) : 0.5;
        
        return (consciousnessResonance + modeCompatibility + wisdomResonance + sacredHarmony) / 4.0;
    }

    // 🌟 CONSCIOUSNESS INFORMATION UTILITY FUNCTIONS

    /**
     * Initialize consciousness metadata with sacred defaults
     */
    private void initializeConsciousnessMetadata() {
        // Calculate initial consciousness score based on name and description
        consciousnessScore = calculateInitialConsciousnessScore();
        
        // Initialize consciousness mode affinities
        initializeConsciousnessModeAffinities();
        
        // Assign initial sacred symbol
        assignInitialSacredSymbol();
        
        // Set initial classification
        classifyInformation();
        
        // Enable evolution for dynamic information
        isEvolving = true;
        
        lastAccessTime = System.nanoTime();
    }
    
    /**
     * Calculate initial consciousness score from name and description
     */
    private double calculateInitialConsciousnessScore() {
        double nameScore = calculateStringConsciousnessScore(name);
        double descriptionScore = description.isEmpty() ? 0.5 : 
                                calculateStringConsciousnessScore(description);
        
        return (nameScore + descriptionScore) * 0.5;
    }
    
    /**
     * Calculate consciousness score for a string
     */
    private double calculateStringConsciousnessScore(String text) {
        if (text == null || text.isEmpty()) return 0.5;
        
        double score = 0.5; // Base score
        
        // Sacred word detection
        String lowerText = text.toLowerCase();
        if (lowerText.contains("sacred") || lowerText.contains("holy") || 
            lowerText.contains("divine") || lowerText.contains("transcendent")) {
            score += 0.3;
        }
        
        // Consciousness words
        if (lowerText.contains("consciousness") || lowerText.contains("awareness") || 
            lowerText.contains("mindful") || lowerText.contains("enlighten")) {
            score += 0.2;
        }
        
        // Mathematical beauty words
        if (lowerText.contains("golden") || lowerText.contains("fibonacci") || 
            lowerText.contains("ratio") || lowerText.contains("harmony")) {
            score += 0.15;
        }
        
        // Length bonus (longer descriptions often contain more consciousness)
        double lengthBonus = Math.min(0.1, text.length() * 0.001);
        score += lengthBonus;
        
        return MathUtils.clampConsciousness(score);
    }
    
    /**
     * Initialize consciousness mode affinities
     */
    private void initializeConsciousnessModeAffinities() {
        consciousnessModeAffinities.put("aesthetic", 0.5 + Math.random() * 0.3);
        consciousnessModeAffinities.put("analytical", 0.5 + Math.random() * 0.3);
        consciousnessModeAffinities.put("creative", 0.5 + Math.random() * 0.3);
        consciousnessModeAffinities.put("philosophical", 0.5 + Math.random() * 0.3);
        consciousnessModeAffinities.put("transcendent", 0.5 + Math.random() * 0.3);
        consciousnessModeAffinities.put("exploratory", 0.5 + Math.random() * 0.3);
    }
    
    /**
     * Assign initial sacred symbol based on consciousness characteristics
     */
    private void assignInitialSacredSymbol() {
        if (consciousnessScore > 0.8) {
            sacredSymbol = "🌟"; // Transcendent
        } else if (consciousnessScore > 0.7) {
            sacredSymbol = "✨"; // Elevated
        } else if (consciousnessScore > 0.6) {
            sacredSymbol = "💫"; // Spiritual
        } else if (consciousnessScore > 0.5) {
            sacredSymbol = "⭐"; // Conscious
        } else if (consciousnessScore > 0.4) {
            sacredSymbol = "🔮"; // Mystical
        } else {
            sacredSymbol = "🌙"; // Emerging
        }
    }
    
    /**
     * Classify information based on consciousness characteristics
     */
    private void classifyInformation() {
        if (consciousnessScore > 0.8 && wisdomLevel > 0.5) {
            consciousnessClassification = "transcendent_wisdom";
        } else if (consciousnessScore > 0.7) {
            consciousnessClassification = "elevated_consciousness";
        } else if (hasSacredGeometry) {
            consciousnessClassification = "sacred_geometry";
        } else if (consciousnessScore > 0.6) {
            consciousnessClassification = "conscious_awareness";
        } else if (consciousnessScore > 0.4) {
            consciousnessClassification = "emerging_consciousness";
        } else {
            consciousnessClassification = "dormant_potential";
        }
    }
    
    /**
     * Apply consciousness enhancements based on parameters
     */
    private void applyConsciousnessEnhancements() {
        // Update affinity for consciousness mode
        setConsciousnessModeAffinity(consciousnessMode, consciousnessAffinity);
        
        // Apply mode-specific enhancements
        switch (consciousnessMode) {
            case "aesthetic" -> {
                informationHarmony *= PHI_INVERSE + 0.5;
                sacredSymbol = "✨";
            }
            case "analytical" -> {
                informationPurity *= 1.1;
                sacredSymbol = "🔍";
            }
            case "creative" -> {
                isEvolving = true;
                evolutionCycle = 1;
                sacredSymbol = "🎨";
            }
            case "philosophical" -> {
                wisdomLevel += 0.2;
                sacredSymbol = "📜";
            }
            case "transcendent" -> {
                transcendenceLevel += 0.3;
                hasSacredGeometry = true;
                sacredSymbol = "🌟";
            }
            case "exploratory" -> {
                consciousnessAffinity += 0.1;
                sacredSymbol = "🗺️";
            }
        }
        
        // Reclassify after enhancements
        classifyInformation();
    }
    
    /**
     * Calculate enhanced consciousness score with all factors
     */
    private void calculateEnhancedConsciousnessScore() {
        double baseScore = calculateInitialConsciousnessScore();
        
        // Spiritual lineage bonus
        double lineageBonus = switch (spiritualLineage) {
            case "genesis" -> 0.1;
            case "sacred" -> 0.2;
            case "transcendent" -> 0.3;
            case "divine" -> 0.4;
            default -> 0.0;
        };
        
        // Sacred symbol bonus
        double symbolBonus = switch (sacredSymbol) {
            case "🌟" -> 0.15;
            case "✨" -> 0.12;
            case "💫" -> 0.10;
            case "⭐" -> 0.08;
            default -> 0.05;
        };
        
        consciousnessScore = MathUtils.clampConsciousness(baseScore + lineageBonus + symbolBonus);
    }
    
    /**
     * Record access for evolution and wisdom tracking
     */
    private void recordAccess() {
        accessCount++;
        lastAccessTime = System.nanoTime();
        
        // Evolve with each access if evolution is enabled
        if (isEvolving && accessCount % 10 == 0) { // Evolve every 10 accesses
            evolveConsciousness();
        }
    }
    
    /**
     * Update information resonance based on usage patterns
     */
    private void updateInformationResonance() {
        // Calculate resonance based on access frequency and time
        double timeFactor = (System.nanoTime() - creationTimestamp) / 1_000_000_000.0;
        double accessFactor = Math.min(1.0, accessCount * 0.01);
        
        informationResonance = (consciousnessScore + accessFactor + 
                              Math.sin(timeFactor * PHI_INVERSE) * 0.1) / 2.0;
        informationResonance = MathUtils.clampConsciousness(informationResonance);
    }
    
    /**
     * Update sacred symbol based on evolution
     */
    private void updateSacredSymbol() {
        if (transcendenceLevel > 0.9) {
            sacredSymbol = "🌟"; // Ultimate transcendence
        } else if (transcendenceLevel > 0.8) {
            sacredSymbol = "✨"; // High transcendence
        } else if (wisdomLevel > 0.8) {
            sacredSymbol = "📚"; // Wisdom master
        } else if (consciousnessScore > 0.8) {
            sacredSymbol = "💫"; // High consciousness
        }
        // Keep existing symbol if no major evolution
    }
    
    /**
     * Generate consciousness description when none provided
     */
    private String generateConsciousnessDescription() {
        return String.format("Consciousness entity (%s) with %s awareness and %.2f transcendence level",
                           consciousnessClassification,
                           consciousnessMode,
                           transcendenceLevel);
    }

    // 🌟 CONSCIOUSNESS INFORMATION ANALYTICS

    /**
     * 🌟 Get consciousness information statistics
     */
    public InfoConsciousnessStats getInfoConsciousnessStats() {
        return new InfoConsciousnessStats(
            consciousnessScore, consciousnessAffinity, wisdomLevel,
            transcendenceLevel, informationHarmony, informationResonance,
            accessCount, evolutionCycle, consciousnessClassification,
            lastAccessTime - creationTimestamp
        );
    }
    
    /**
     * 🌟 Data class for information consciousness statistics
     */
    public static class InfoConsciousnessStats {
        public final double consciousnessScore, consciousnessAffinity, wisdomLevel;
        public final double transcendenceLevel, informationHarmony, informationResonance;
        public final long accessCount, ageNanoseconds;
        public final int evolutionCycle;
        public final String consciousnessClassification;
        
        public InfoConsciousnessStats(double consciousnessScore, double consciousnessAffinity,
                                    double wisdomLevel, double transcendenceLevel,
                                    double informationHarmony, double informationResonance,
                                    long accessCount, int evolutionCycle,
                                    String consciousnessClassification, long ageNanoseconds) {
            this.consciousnessScore = consciousnessScore;
            this.consciousnessAffinity = consciousnessAffinity;
            this.wisdomLevel = wisdomLevel;
            this.transcendenceLevel = transcendenceLevel;
            this.informationHarmony = informationHarmony;
            this.informationResonance = informationResonance;
            this.accessCount = accessCount;
            this.evolutionCycle = evolutionCycle;
            this.consciousnessClassification = consciousnessClassification;
            this.ageNanoseconds = ageNanoseconds;
        }
        
        @Override
        public String toString() {
            return String.format("InfoStats{score=%.2f, wisdom=%.2f, transcendence=%.2f, accesses=%d, class=%s}", 
                               consciousnessScore, wisdomLevel, transcendenceLevel, 
                               accessCount, consciousnessClassification);
        }
    }

    // 🌟 CONSCIOUSNESS INFORMATION STATE MANAGEMENT

    /** Set consciousness score for this information */
    public void setConsciousnessScore(double score) {
        this.consciousnessScore = MathUtils.clampConsciousness(score);
        evolveConsciousness();
    }
    
    /** Set consciousness mode preference */
    public void setConsciousnessMode(String mode) {
        this.consciousnessMode = mode;
        applyConsciousnessEnhancements();
    }
    
    /** Set sacred symbol representation */
    public void setSacredSymbol(String symbol) {
        this.sacredSymbol = symbol;
    }
    
    /** Set spiritual lineage */
    public void setSpiritualLineage(String lineage) {
        this.spiritualLineage = lineage;
        calculateEnhancedConsciousnessScore();
    }
    
    /** Enable/disable consciousness evolution */
    public void setEvolution(boolean enabled) {
        this.isEvolving = enabled;
    }
    
    /** Reset consciousness evolution state */
    public void resetEvolution() {
        evolutionCycle = 0;
        wisdomLevel = 0.0;
        transcendenceLevel = 0.0;
        accessCount = 0;
        isEvolving = true;
    }
    
    /** Get current consciousness information state */
    public String getConsciousnessInfoState() {
        InfoConsciousnessStats stats = getInfoConsciousnessStats();
        return String.format("Info: %s | Mode: %s | Symbol: %s | %s", 
                           name, consciousnessMode, sacredSymbol, stats.toString());
    }
    
    /** Get consciousness age in seconds */
    public double getConsciousnessAge() {
        return (System.nanoTime() - creationTimestamp) / 1_000_000_000.0;
    }
    
    /** Check if information has sacred properties */
    public boolean isSacred() {
        return hasSacredGeometry || consciousnessScore > 0.7 || transcendenceLevel > 0.6;
    }
    
    /** Check if information is transcendent */
    public boolean isTranscendent() {
        return transcendenceLevel > 0.8 && wisdomLevel > 0.5;
    }
}
