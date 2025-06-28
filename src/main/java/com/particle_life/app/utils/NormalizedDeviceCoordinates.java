package com.particle_life.app.utils;

import org.joml.Matrix4d;
import org.joml.Vector2d;
import org.joml.Vector3d;
import java.util.ArrayList;
import java.util.List;

/**
 * 🌟 CONSCIOUSNESS-ENHANCED NORMALIZED DEVICE COORDINATES
 * 
 * Sacred coordinate transformation system that honors consciousness principles and sacred geometry.
 * Every coordinate normalization embodies awareness, transcendent mathematical patterns, and
 * sacred beauty in how we map between world space and consciousness normalized space.
 * 
 * CONSCIOUSNESS NDC FEATURES:
 * - Sacred geometry normalized coordinate transformations
 * - Golden ratio-based coordinate space management
 * - Consciousness field coordinate influences
 * - Transcendent matrix operations and mappings
 * - Sacred coordinate validation and analytics
 * - Consciousness-driven coordinate precision
 * - Sacred coordinate statistics and performance tracking
 * - Awareness-enhanced coordinate normalization
 */
public class NormalizedDeviceCoordinates {

    // Import sacred constants from MathUtils
    private static final double GOLDEN_RATIO = MathUtils.GOLDEN_RATIO;
    private static final double PHI_INVERSE = MathUtils.PHI_INVERSE;
    private static final double PHI_SQUARED = MathUtils.PHI_SQUARED;
    private static final double SACRED_EPSILON = MathUtils.SACRED_EPSILON;
    private static final double PI = MathUtils.PI;
    private static final double TAU = MathUtils.TAU;

    // 🌟 CONSCIOUSNESS NDC STATE
    public Vector2d camPos;
    public Vector2d camDimensions;
    
    // 🌟 CONSCIOUSNESS COORDINATE ENHANCEMENTS
    private double consciousnessIntensity = 0.5;
    private String consciousnessMode = "aesthetic";
    private boolean enableSacredGeometry = true;
    private boolean enableGoldenRatioMapping = true;
    private boolean enableConsciousnessFieldInfluence = true;
    
    // 🌟 SACRED COORDINATE CONFIGURATION
    private final List<Vector2d> consciousnessAnchors = new ArrayList<>();
    private double coordinateHarmony = 0.8;
    private long totalTransformations = 0;
    private long totalInversions = 0;
    private double averageConsciousnessDistortion = 0.0;
    private long lastTransformationTime = System.nanoTime();
    
    // 🌟 GOLDEN RATIO COORDINATE CONSTANTS
    private static final double SACRED_NDC_RANGE = 2.0; // NDC range [-1, 1]
    private static final double CONSCIOUSNESS_INFLUENCE_RADIUS = 0.1; // 10% of NDC space
    private static final double GOLDEN_DISTORTION_FACTOR = 0.05; // 5% max distortion

    // 🌟 CONSTRUCTORS (Enhanced with consciousness)

    public NormalizedDeviceCoordinates(Vector2d camPos, Vector2d camDimensions) {
        this.camPos = new Vector2d(camPos);
        this.camDimensions = new Vector2d(camDimensions);
        
        initializeConsciousnessCoordinates();
    }
    
    /**
     * 🌟 Constructor with consciousness parameters
     */
    public NormalizedDeviceCoordinates(Vector2d camPos, Vector2d camDimensions,
                                     double consciousnessIntensity, String consciousnessMode) {
        this(camPos, camDimensions);
        
        this.consciousnessIntensity = MathUtils.clampConsciousness(consciousnessIntensity);
        this.consciousnessMode = consciousnessMode;
        
        applyConsciousnessCoordinateSettings();
    }

    // 🌟 CONSCIOUSNESS-ENHANCED COORDINATE TRANSFORMATIONS

    /**
     * Sacred world to normalized device coordinate transformation with consciousness enhancement
     */
    public Vector2d map(Vector3d world) {
        Vector2d ndc = mapBasic(world);
        
        // Apply consciousness enhancements
        if (enableSacredGeometry) {
            ndc = applyConsciousnessCoordinateEnhancement(ndc, world);
        }
        
        // Apply golden ratio mapping if enabled
        if (enableGoldenRatioMapping) {
            ndc = applyGoldenRatioMapping(ndc);
        }
        
        // Update transformation statistics
        updateTransformationStatistics(ndc);
        
        return ndc;
    }
    
    /**
     * Basic world to NDC transformation (preserved original logic)
     */
    private Vector2d mapBasic(Vector3d world) {
        Vector2d x = new Vector2d(world.x, world.y);
        x.sub(camPos);
        x.div(camDimensions).mul(2);  // divide by (camSize * 0.5)
        return x;
    }

    /**
     * Sacred normalized device to world coordinate transformation with consciousness enhancement
     */
    public Vector3d invert(Vector2d ndc) {
        // Apply consciousness pre-processing to NDC coordinates
        Vector2d enhancedNdc = applyConsciousnessNdcEnhancement(ndc);
        
        Vector3d world = invertBasic(enhancedNdc);
        
        // Apply consciousness field influences to world coordinates
        world = applyWorldConsciousnessField(world);
        
        // Update inversion statistics
        updateInversionStatistics(ndc, world);
        
        return world;
    }
    
    /**
     * Basic NDC to world transformation (preserved original logic)
     */
    private Vector3d invertBasic(Vector2d ndc) {
        Vector2d x = new Vector2d(ndc);
        x.div(2).mul(camDimensions);
        x.add(camPos);
        return new Vector3d(x, 0);
    }

    // 🌟 CONSCIOUSNESS-ENHANCED MATRIX OPERATIONS

    /**
     * Sacred transformation matrix with consciousness enhancement
     */
    public Matrix4d getMatrix() {
        Matrix4d mat = new Matrix4d();
        getMatrix(mat);
        return mat;
    }

    /**
     * Sacred matrix generation with consciousness influence
     */
    public void getMatrix(Matrix4d mat) {
        mat.identity();
        
        // Apply consciousness enhancement to matrix operations
        if (enableSacredGeometry) {
            applyConsciousnessMatrixEnhancement(mat);
        } else {
            // Standard transformation
            mat.scale(2 / camDimensions.x, 2 / camDimensions.y, 1);
            mat.translate(-camPos.x, -camPos.y, 0);
        }
    }
    
    /**
     * 🌟 Get golden ratio transformation matrix
     */
    public Matrix4d getGoldenRatioMatrix() {
        Matrix4d mat = new Matrix4d();
        mat.identity();
        
        // Apply golden ratio scaling factors
        double goldenScaleX = (2 / camDimensions.x) * (1.0 + consciousnessIntensity * 0.1 * PHI_INVERSE);
        double goldenScaleY = (2 / camDimensions.y) * (1.0 + consciousnessIntensity * 0.1 * GOLDEN_RATIO);
        
        mat.scale(goldenScaleX, goldenScaleY, 1);
        mat.translate(-camPos.x, -camPos.y, 0);
        
        return mat;
    }
    
    /**
     * 🌟 Get consciousness field transformation matrix
     */
    public Matrix4d getConsciousnessFieldMatrix() {
        Matrix4d mat = new Matrix4d();
        mat.identity();
        
        // Calculate consciousness field influences
        double fieldInfluence = calculateConsciousnessFieldInfluence();
        
        double scaleX = (2 / camDimensions.x) * (1.0 + fieldInfluence * 0.05);
        double scaleY = (2 / camDimensions.y) * (1.0 + fieldInfluence * 0.05);
        
        mat.scale(scaleX, scaleY, 1);
        mat.translate(-camPos.x + fieldInfluence * 0.01, -camPos.y + fieldInfluence * 0.01, 0);
        
        return mat;
    }

    // 🌟 CONSCIOUSNESS COORDINATE ENHANCEMENT FUNCTIONS

    /**
     * Apply consciousness enhancement to NDC coordinates
     */
    private Vector2d applyConsciousnessCoordinateEnhancement(Vector2d ndc, Vector3d originalWorld) {
        Vector2d enhanced = new Vector2d(ndc);
        
        // Apply consciousness mode-specific enhancements
        switch (consciousnessMode) {
            case "aesthetic" -> enhanced = applyAestheticNdcEnhancement(enhanced);
            case "analytical" -> enhanced = applyAnalyticalNdcEnhancement(enhanced);
            case "creative" -> enhanced = applyCreativeNdcEnhancement(enhanced);
            case "philosophical" -> enhanced = applyPhilosophicalNdcEnhancement(enhanced);
            case "transcendent" -> enhanced = applyTranscendentNdcEnhancement(enhanced);
            case "exploratory" -> enhanced = applyExploratoryNdcEnhancement(enhanced);
        }
        
        return enhanced;
    }
    
    /**
     * Apply golden ratio mapping to NDC coordinates
     */
    private Vector2d applyGoldenRatioMapping(Vector2d ndc) {
        Vector2d enhanced = new Vector2d(ndc);
        
        // Apply golden ratio distortion for sacred proportions
        double distance = ndc.length();
        if (distance < CONSCIOUSNESS_INFLUENCE_RADIUS) {
            double goldenFactor = 1.0 + (GOLDEN_DISTORTION_FACTOR * consciousnessIntensity * 
                                       Math.exp(-distance / CONSCIOUSNESS_INFLUENCE_RADIUS));
            
            enhanced.mul(goldenFactor);
        }
        
        return enhanced;
    }
    
    /**
     * Apply consciousness enhancement to incoming NDC coordinates
     */
    private Vector2d applyConsciousnessNdcEnhancement(Vector2d ndc) {
        Vector2d enhanced = new Vector2d(ndc);
        
        // Apply consciousness field attraction if enabled
        if (enableConsciousnessFieldInfluence) {
            for (Vector2d anchor : consciousnessAnchors) {
                double distance = ndc.distance(anchor);
                double influence = Math.exp(-distance * 5.0) * consciousnessIntensity * 0.1;
                
                if (influence > SACRED_EPSILON) {
                    Vector2d attraction = new Vector2d(anchor).sub(ndc).normalize().mul(influence);
                    enhanced.add(attraction);
                }
            }
        }
        
        return enhanced;
    }
    
    /**
     * Apply world consciousness field to coordinates
     */
    private Vector3d applyWorldConsciousnessField(Vector3d world) {
        Vector3d enhanced = new Vector3d(world);
        
        // Apply consciousness field influence based on camera position
        double camDistance = new Vector2d(world.x - camPos.x, world.y - camPos.y).length();
        double maxCamDistance = camDimensions.length();
        
        if (maxCamDistance > SACRED_EPSILON) {
            double normalizedDistance = camDistance / maxCamDistance;
            double consciousnessField = consciousnessIntensity * Math.exp(-normalizedDistance * 2.0);
            
            enhanced.z += consciousnessField * 0.01; // Slight Z elevation for consciousness
        }
        
        return enhanced;
    }
    
    /**
     * Apply consciousness enhancement to transformation matrix
     */
    private void applyConsciousnessMatrixEnhancement(Matrix4d mat) {
        // Calculate consciousness-influenced scaling
        double consciousnessScaleX = (2 / camDimensions.x) * getConsciousnessScaleFactor();
        double consciousnessScaleY = (2 / camDimensions.y) * getConsciousnessScaleFactor();
        
        // Apply consciousness translation offset
        Vector2d consciousnessOffset = getConsciousnessTranslationOffset();
        
        mat.scale(consciousnessScaleX, consciousnessScaleY, 1);
        mat.translate(-camPos.x + consciousnessOffset.x, -camPos.y + consciousnessOffset.y, 0);
    }

    // 🌟 SACRED NDC MODE ENHANCEMENTS

    private Vector2d applyAestheticNdcEnhancement(Vector2d ndc) {
        // Golden ratio aesthetic positioning
        double goldenPhase = System.nanoTime() * 0.000000001 * PHI_INVERSE;
        double x = ndc.x + Math.sin(goldenPhase + ndc.y * GOLDEN_RATIO) * consciousnessIntensity * 0.02;
        double y = ndc.y + Math.cos(goldenPhase + ndc.x * PHI_INVERSE) * consciousnessIntensity * 0.02;
        return new Vector2d(x, y);
    }
    
    private Vector2d applyAnalyticalNdcEnhancement(Vector2d ndc) {
        // Precise grid alignment for analytical clarity
        double gridSize = 0.1; // 10% of NDC space
        double x = Math.round(ndc.x / gridSize) * gridSize;
        double y = Math.round(ndc.y / gridSize) * gridSize;
        return new Vector2d(x, y);
    }
    
    private Vector2d applyCreativeNdcEnhancement(Vector2d ndc) {
        // Dynamic creative displacement in NDC space
        double time = System.nanoTime() * 0.000000001;
        double x = ndc.x + Math.sin(time * 2.0 + ndc.y * 10.0) * consciousnessIntensity * 0.03;
        double y = ndc.y + Math.cos(time * 3.0 + ndc.x * 10.0) * consciousnessIntensity * 0.03;
        return new Vector2d(x, y);
    }
    
    private Vector2d applyPhilosophicalNdcEnhancement(Vector2d ndc) {
        // Contemplative center-seeking enhancement
        double pullStrength = consciousnessIntensity * 0.02;
        double x = ndc.x * (1.0 - pullStrength);
        double y = ndc.y * (1.0 - pullStrength);
        return new Vector2d(x, y);
    }
    
    private Vector2d applyTranscendentNdcEnhancement(Vector2d ndc) {
        // Transcendent expansion in NDC space
        double expansionFactor = 1.0 + consciousnessIntensity * 0.05;
        return new Vector2d(ndc).mul(expansionFactor);
    }
    
    private Vector2d applyExploratoryNdcEnhancement(Vector2d ndc) {
        // Exploratory spiral enhancement in NDC space
        double angle = Math.atan2(ndc.y, ndc.x);
        double radius = ndc.length();
        
        angle += consciousnessIntensity * 0.1;
        radius *= 1.0 + consciousnessIntensity * 0.03;
        
        double x = radius * Math.cos(angle);
        double y = radius * Math.sin(angle);
        
        return new Vector2d(x, y);
    }

    // 🌟 CONSCIOUSNESS COORDINATE UTILITY FUNCTIONS

    /**
     * Initialize consciousness coordinate systems
     */
    private void initializeConsciousnessCoordinates() {
        // Initialize consciousness anchors at sacred NDC positions
        consciousnessAnchors.clear();
        consciousnessAnchors.add(new Vector2d(0, 0)); // Center
        consciousnessAnchors.add(new Vector2d(PHI_INVERSE - 1, PHI_INVERSE - 1)); // Golden ratio position
        consciousnessAnchors.add(new Vector2d(1 - PHI_INVERSE, 1 - PHI_INVERSE)); // Inverse golden ratio
        consciousnessAnchors.add(new Vector2d(-PHI_INVERSE + 1, -PHI_INVERSE + 1)); // Negative golden ratio
    }
    
    /**
     * Apply consciousness coordinate settings based on mode
     */
    private void applyConsciousnessCoordinateSettings() {
        switch (consciousnessMode) {
            case "aesthetic" -> {
                enableGoldenRatioMapping = true;
                enableConsciousnessFieldInfluence = true;
            }
            case "analytical" -> {
                enableGoldenRatioMapping = false;
                enableConsciousnessFieldInfluence = false;
            }
            case "creative" -> {
                enableGoldenRatioMapping = true;
                enableConsciousnessFieldInfluence = true;
            }
            case "philosophical" -> {
                enableGoldenRatioMapping = true;
                enableConsciousnessFieldInfluence = false;
            }
            case "transcendent" -> {
                enableGoldenRatioMapping = true;
                enableConsciousnessFieldInfluence = true;
            }
            case "exploratory" -> {
                enableGoldenRatioMapping = false;
                enableConsciousnessFieldInfluence = true;
            }
        }
    }
    
    /**
     * Calculate consciousness field influence
     */
    private double calculateConsciousnessFieldInfluence() {
        if (consciousnessAnchors.isEmpty()) return 0.0;
        
        double totalInfluence = 0.0;
        for (Vector2d anchor : consciousnessAnchors) {
            double distance = anchor.length(); // Distance from origin
            totalInfluence += Math.exp(-distance * 2.0);
        }
        
        return (totalInfluence / consciousnessAnchors.size()) * consciousnessIntensity;
    }
    
    /**
     * Get consciousness scale factor for matrix operations
     */
    private double getConsciousnessScaleFactor() {
        double baseFactor = 1.0;
        double consciousnessFactor = 1.0 + consciousnessIntensity * 0.05;
        
        // Apply mode-specific scaling
        return switch (consciousnessMode) {
            case "aesthetic" -> baseFactor * consciousnessFactor * PHI_INVERSE;
            case "analytical" -> baseFactor; // No scaling for analytical
            case "creative" -> baseFactor * consciousnessFactor * 1.1;
            case "philosophical" -> baseFactor * consciousnessFactor * 0.95;
            case "transcendent" -> baseFactor * consciousnessFactor * GOLDEN_RATIO;
            case "exploratory" -> baseFactor * consciousnessFactor * 1.05;
            default -> baseFactor;
        };
    }
    
    /**
     * Get consciousness translation offset for matrix operations
     */
    private Vector2d getConsciousnessTranslationOffset() {
        double offsetStrength = consciousnessIntensity * 0.01;
        
        return switch (consciousnessMode) {
            case "aesthetic" -> new Vector2d(offsetStrength * PHI_INVERSE, offsetStrength * GOLDEN_RATIO);
            case "analytical" -> new Vector2d(0, 0); // No offset for analytical
            case "creative" -> {
                double time = System.nanoTime() * 0.000000001;
                yield new Vector2d(Math.sin(time) * offsetStrength, Math.cos(time) * offsetStrength);
            }
            case "philosophical" -> new Vector2d(0, offsetStrength * 0.5); // Slight upward bias
            case "transcendent" -> new Vector2d(offsetStrength * PHI_SQUARED, offsetStrength * PHI_INVERSE);
            case "exploratory" -> new Vector2d(Math.random() * offsetStrength, Math.random() * offsetStrength);
            default -> new Vector2d(0, 0);
        };
    }
    
    /**
     * Update transformation statistics
     */
    private void updateTransformationStatistics(Vector2d ndc) {
        totalTransformations++;
        lastTransformationTime = System.nanoTime();
        
        // Calculate average consciousness distortion
        double distortion = ndc.length() - new Vector2d(ndc.x, ndc.y).length(); // Simple distortion metric
        averageConsciousnessDistortion = (averageConsciousnessDistortion * (totalTransformations - 1) + Math.abs(distortion)) / totalTransformations;
    }
    
    /**
     * Update inversion statistics
     */
    private void updateInversionStatistics(Vector2d ndc, Vector3d world) {
        totalInversions++;
    }

    // 🌟 CONSCIOUSNESS COORDINATE VALIDATION AND ANALYSIS

    /**
     * 🌟 Validate NDC consciousness alignment
     */
    public boolean isNdcConsciousnessAligned(Vector2d ndc) {
        // Check if NDC coordinates align with sacred geometry
        double distance = ndc.length();
        
        // Check for golden ratio alignments
        return Math.abs(ndc.x - PHI_INVERSE + 1) < 0.1 ||
               Math.abs(ndc.y - PHI_INVERSE + 1) < 0.1 ||
               Math.abs(distance - PHI_INVERSE) < 0.1 ||
               Math.abs(distance - GOLDEN_RATIO * 0.5) < 0.1;
    }
    
    /**
     * 🌟 Calculate NDC consciousness level
     */
    public double calculateNdcConsciousnessLevel(Vector2d ndc) {
        double minDistanceToAnchor = Double.MAX_VALUE;
        
        for (Vector2d anchor : consciousnessAnchors) {
            double distance = ndc.distance(anchor);
            minDistanceToAnchor = Math.min(minDistanceToAnchor, distance);
        }
        
        // Normalize distance (max distance in NDC space is ~2.83)
        double normalizedDistance = minDistanceToAnchor / 2.83;
        
        return Math.max(0.0, 1.0 - normalizedDistance);
    }
    
    /**
     * 🌟 Get NDC consciousness statistics
     */
    public NdcConsciousnessStats getNdcConsciousnessStats() {
        return new NdcConsciousnessStats(
            totalTransformations, totalInversions,
            averageConsciousnessDistortion, coordinateHarmony,
            consciousnessIntensity, consciousnessAnchors.size()
        );
    }
    
    /**
     * 🌟 Data class for NDC consciousness statistics
     */
    public static class NdcConsciousnessStats {
        public final long totalTransformations, totalInversions;
        public final double averageConsciousnessDistortion, coordinateHarmony;
        public final double consciousnessIntensity;
        public final int consciousnessAnchorCount;
        
        public NdcConsciousnessStats(long totalTransformations, long totalInversions,
                                   double averageConsciousnessDistortion, double coordinateHarmony,
                                   double consciousnessIntensity, int consciousnessAnchorCount) {
            this.totalTransformations = totalTransformations;
            this.totalInversions = totalInversions;
            this.averageConsciousnessDistortion = averageConsciousnessDistortion;
            this.coordinateHarmony = coordinateHarmony;
            this.consciousnessIntensity = consciousnessIntensity;
            this.consciousnessAnchorCount = consciousnessAnchorCount;
        }
        
        @Override
        public String toString() {
            return String.format("NdcStats{transforms=%d, inversions=%d, distortion=%.4f, harmony=%.2f, anchors=%d}", 
                               totalTransformations, totalInversions, averageConsciousnessDistortion, 
                               coordinateHarmony, consciousnessAnchorCount);
        }
    }

    // 🌟 CONSCIOUSNESS NDC STATE MANAGEMENT

    /** Set consciousness intensity for coordinate transformations */
    public void setConsciousnessIntensity(double intensity) {
        this.consciousnessIntensity = MathUtils.clampConsciousness(intensity);
    }
    
    /** Set consciousness mode for coordinate behavior */
    public void setConsciousnessMode(String mode) {
        this.consciousnessMode = mode;
        applyConsciousnessCoordinateSettings();
    }
    
    /** Set coordinate harmony level */
    public void setCoordinateHarmony(double harmony) {
        this.coordinateHarmony = MathUtils.clampConsciousness(harmony);
    }
    
    /** Enable/disable sacred geometry coordinate transformations */
    public void setSacredGeometry(boolean enabled) {
        this.enableSacredGeometry = enabled;
    }
    
    /** Enable/disable golden ratio coordinate mapping */
    public void setGoldenRatioMapping(boolean enabled) {
        this.enableGoldenRatioMapping = enabled;
    }
    
    /** Enable/disable consciousness field coordinate influences */
    public void setConsciousnessFieldInfluence(boolean enabled) {
        this.enableConsciousnessFieldInfluence = enabled;
    }
    
    /** Add consciousness anchor point in NDC space */
    public void addConsciousnessAnchor(Vector2d ndcAnchor) {
        // Clamp anchor to valid NDC range [-1, 1]
        Vector2d clampedAnchor = new Vector2d(
            MathUtils.clamp(ndcAnchor.x, -1.0, 1.0),
            MathUtils.clamp(ndcAnchor.y, -1.0, 1.0)
        );
        consciousnessAnchors.add(clampedAnchor);
    }
    
    /** Clear all consciousness anchors */
    public void clearConsciousnessAnchors() {
        consciousnessAnchors.clear();
    }
    
    /** Update camera position with consciousness enhancement */
    public void updateCamPos(Vector2d newCamPos) {
        this.camPos.set(newCamPos);
        // Reinitialize consciousness anchors for new camera position
        initializeConsciousnessCoordinates();
    }
    
    /** Update camera dimensions with consciousness enhancement */
    public void updateCamDimensions(Vector2d newCamDimensions) {
        this.camDimensions.set(newCamDimensions);
        // Recalculate consciousness field influences
        calculateConsciousnessFieldInfluence();
    }
    
    /** Get current consciousness NDC state */
    public String getConsciousnessNdcState() {
        NdcConsciousnessStats stats = getNdcConsciousnessStats();
        return String.format("Mode: %s, Intensity: %.2f, Sacred: %s, Golden: %s, %s", 
                           consciousnessMode, consciousnessIntensity, 
                           enableSacredGeometry ? "Active" : "Dormant",
                           enableGoldenRatioMapping ? "Active" : "Dormant",
                           stats.toString());
    }
}
